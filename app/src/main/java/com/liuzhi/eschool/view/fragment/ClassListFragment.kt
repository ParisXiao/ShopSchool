package com.liuzhi.eschool.view.fragment

import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.text.TextUtils
import android.util.Log
import android.view.View
import com.chad.library.adapter.base.BaseQuickAdapter
import com.liuzhi.eschool.R
import com.liuzhi.eschool.adapter.ClassDetailAdapter
import com.liuzhi.eschool.constants.UrlConstans
import com.liuzhi.eschool.entity.ClassDetailEntity
import com.liuzhi.eschool.entity.convert.ClassDetailConvert
import com.liuzhi.eschool.view.activity.ClassDetailActivity
import com.liuzhi.eschool.view.activity.LoginActivity
import com.lzy.okgo.OkGo
import com.lzy.okgo.model.Response
import com.lzy.okrx2.adapter.ObservableResponse
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.fragment_classdelist.view.*
import java.util.concurrent.TimeUnit

class ClassListFragment : BaseFragment() {
    var classId: String = ""
    var classTypeId: String = ""
    private lateinit var classDetailConvert: ClassDetailConvert
    private lateinit var classDetailResponse: ObservableResponse<ClassDetailEntity>
    private lateinit var classDetailAdapter: ClassDetailAdapter
    private lateinit var classDetailLists: MutableList<ClassDetailEntity.ResultListBean>
    private var pageNo: Int = 1
    override fun getLayoutId(): Int {
        return R.layout.fragment_classdelist
    }

    override fun initView(view: View) {
        view.recycler_class_list.hasFixedSize()
        view.recycler_class_list.layoutManager = GridLayoutManager(activity, 3)
        classDetailLists = ArrayList()
        classDetailAdapter = ClassDetailAdapter(activity, classDetailLists)
        view.recycler_class_list.adapter = classDetailAdapter
    }

    override fun initData() {
        if (!TextUtils.isEmpty(classTypeId)) {
            getClassList(classTypeId)
        }
        classDetailAdapter.setOnItemClickListener { adapter, view, position ->
            var intent=Intent(activity,ClassDetailActivity::class.java)
            intent.putExtra("LessonDetail",classDetailLists.get(position))
            startActivity(intent)
        }
        classDetailAdapter.setOnLoadMoreListener(BaseQuickAdapter.RequestLoadMoreListener {
            Observable.timer(1, TimeUnit.SECONDS).observeOn(Schedulers.io()).doOnComplete {
                pageNo += 1
                getClassList(classTypeId)
            }.subscribe()
        })

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var bundle: Bundle = getArguments();
        classId = bundle.getString("classId")
        classTypeId = bundle.getString("classTypeId")
        if (classId == null) {
            classId = ""
        }
        if (classTypeId == null) {
            classTypeId = ""
        }

    }

    fun getClassList(classTypeId: String) {
        classDetailConvert = ClassDetailConvert()
        classDetailResponse = ObservableResponse()
        OkGo.post<ClassDetailEntity>(UrlConstans.LessonSelective)
            .headers("Content-Type", "application/x-www-form-urlencoded")
            .params("type", classTypeId)
            .params("pageNo", pageNo)
            .params("pageSize", 20)
            .params("time", true)
            .converter(classDetailConvert)
            .adapt(classDetailResponse)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : DisposableObserver<Response<ClassDetailEntity>>() {
                override fun onNext(response: Response<ClassDetailEntity>) {
                    if (response.code()==302){
                        var intent =Intent(activity, LoginActivity::class.java)
                        startActivity(intent)
                        return
                    }
                    Log.e("result", "response ==> " + response.body().toString())
                    var listEntity = response.body()
                    if (listEntity.resultList==null) {
                        return
                    }
                    if (1 == pageNo) {
                        classDetailLists.clear()
                        classDetailLists = listEntity.resultList
                        classDetailAdapter.setNewData(classDetailLists)
                    } else {
                        if (listEntity.resultList.size > 0) {
                            for (listBean in listEntity.resultList) {
                                classDetailLists.add(listBean)
                            }
                        }
                        classDetailAdapter.addData(listEntity.resultList)
                        if (pageNo >= listEntity.totalPages) {
                            pageNo = listEntity.totalPages
                            classDetailAdapter.loadMoreEnd()
                        } else {
                            classDetailAdapter.loadMoreComplete()
                        }
                    }
                }

                override fun onError(e: Throwable) {
                    Log.e("OKGO",e.message)
                }

                override fun onComplete() {
                }
            })
    }
}