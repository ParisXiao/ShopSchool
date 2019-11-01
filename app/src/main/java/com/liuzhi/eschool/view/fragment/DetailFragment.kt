package com.liuzhi.eschool.view.fragment

import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.text.Html
import android.util.Log
import android.view.View
import android.widget.ListAdapter
import android.widget.TextView
import com.liuzhi.eschool.R
import com.liuzhi.eschool.adapter.IfListColumnAdapter
import com.liuzhi.eschool.adapter.IfListInfoAdapter
import com.liuzhi.eschool.adapter.IfPhotoAdapter
import com.liuzhi.eschool.constants.UrlConstans
import com.liuzhi.eschool.entity.ProjectInfoByEntity
import com.liuzhi.eschool.entity.SecondResponseEntity
import com.liuzhi.eschool.entity.convert.SecondResponseConvert
import com.liuzhi.eschool.view.activity.DetailActivity
import com.liuzhi.eschool.view.activity.LoginActivity
import com.lzy.okgo.OkGo
import com.lzy.okgo.model.Response
import com.lzy.okrx2.adapter.ObservableResponse
import com.zzhoujay.richtext.RichText
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_train_template.*
import kotlinx.android.synthetic.main.fragment_project_danye.view.*
import kotlinx.android.synthetic.main.fragment_richtext.view.*

/**
 * 列表页
 */
class DetailFragment : BaseFragment() {
    var pageNo = 1
    var colId = ""
    var colType = 0

    private lateinit var secondResponseConvert: SecondResponseConvert
    private lateinit var secondResponseObserver: ObservableResponse<SecondResponseEntity>
    private var mSecondResponseInfos: MutableList<SecondResponseEntity.DataBean.InfoBean> = ArrayList()
    private var mSecondResponseColumns: MutableList<SecondResponseEntity.DataBean.ColumnBean> = ArrayList()
    lateinit var mifColumnAdapter: IfListColumnAdapter
    lateinit var mifInfoAdapter: IfListInfoAdapter
    lateinit var mifPhotoAdapter: IfPhotoAdapter
    override fun getLayoutId(): Int {
        return R.layout.fragment_project_danye
    }

    override fun initView(view: View) {
        getSecondResponse(view, colId)

    }

    override fun initData() {
//        ifPhotoAdapter.setOnLoadMoreListener(BaseQuickAdapter.RequestLoadMoreListener {
//            Observable.timer(1, TimeUnit.SECONDS).observeOn(Schedulers.io()).doOnComplete {
//                pageNo += 1
//                getProjectInfoById(colId)
//            }.subscribe()
//        })
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var bundle: Bundle = arguments
        colId = bundle.getString("colId")
        colType = bundle.getInt("colType")
    }



    fun getSecondResponse(view: View, colId: String) {
        secondResponseConvert = SecondResponseConvert()
        secondResponseObserver = ObservableResponse()
        OkGo.post<SecondResponseEntity>(UrlConstans.SecondPost)
                .headers("Content-Type", "application/json;charset=UTF-8")
                .params("colId", colId)
                .converter(secondResponseConvert)
                .adapt(secondResponseObserver)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(object : DisposableObserver<Response<SecondResponseEntity>>() {
                    override fun onNext(response: Response<SecondResponseEntity>) {
                        var entity = response.body()
                        if (entity == null) {
                            var intent = Intent(activity, LoginActivity::class.java)
                            startActivity(intent)
                            return
                        }
                        if (entity.code == 0) {
                            if (entity.data.column.size > 0) {
                                view.text_detail.visibility = View.GONE
                                view.danye_recycle.visibility = View.VISIBLE
                                view.danye_recycle.setHasFixedSize(true)
                                var layoutManager: RecyclerView.LayoutManager  = LinearLayoutManager(activity)
                                view.danye_recycle.layoutManager = layoutManager
                                mifColumnAdapter = IfListColumnAdapter(activity, mSecondResponseColumns)
                                view.danye_recycle.adapter = mifColumnAdapter
                                mSecondResponseColumns=entity.data.column
                                mifColumnAdapter.setNewData(mSecondResponseColumns)
                            } else {
                                if (entity.data.info.size == 1) {
                                    view.text_detail.visibility = View.VISIBLE
                                    view.danye_recycle.visibility = View.GONE
                                    RichText.fromHtml(entity.data.info[0].ifContent).into(view.text_detail)
                                } else if (entity.data.info.size > 0) {
                                    view.text_detail.visibility = View.GONE
                                    view.danye_recycle.visibility = View.VISIBLE
                                    view.danye_recycle.setHasFixedSize(true)
                                    mSecondResponseInfos=entity.data.info
                                    if (colType == 1) {
                                        view.danye_recycle.layoutManager = GridLayoutManager(activity, 2) as RecyclerView.LayoutManager?
                                        mifPhotoAdapter = IfPhotoAdapter(activity, mSecondResponseInfos)
                                        view.danye_recycle.adapter = mifPhotoAdapter
                                        mifPhotoAdapter.setNewData(mSecondResponseInfos)
                                    }else{
                                        var layoutManager: RecyclerView.LayoutManager  = LinearLayoutManager(activity)
                                        view.danye_recycle.layoutManager = layoutManager
                                        mifInfoAdapter= IfListInfoAdapter(activity,mSecondResponseInfos)
                                        view.danye_recycle.adapter=mifInfoAdapter
                                        mifInfoAdapter.setNewData(mSecondResponseInfos)
                                        mifInfoAdapter.setOnItemClickListener { adapter, view, position ->
                                            var intent=Intent(activity,DetailActivity::class.java)
                                            intent.putExtra("ifId",mSecondResponseInfos[position].ifId)
                                            startActivity(intent)
                                        }
                                    }
                                }
                            }
                        }
                    }

                    override fun onError(e: Throwable) {
                        Log.e("OKGO", e.message)
                    }

                    override fun onComplete() {
                    }
                })
    }
    override fun onDestroy() {
        super.onDestroy()
        RichText.clear(activity)
    }
}