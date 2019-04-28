package com.liuzhi.eschool.view.fragment

import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.chad.library.adapter.base.BaseQuickAdapter
import com.liuzhi.eschool.R
import com.liuzhi.eschool.adapter.DanyeAdapter
import com.liuzhi.eschool.constants.UrlConstans
import com.liuzhi.eschool.entity.ProjectInfoByEntity
import com.liuzhi.eschool.entity.convert.ProjectInfoByConvert
import com.liuzhi.eschool.view.activity.LoginActivity
import com.lzy.okgo.OkGo
import com.lzy.okgo.model.Response
import com.lzy.okrx2.adapter.ObservableResponse
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.fragment_project_danye.view.*
import kotlinx.android.synthetic.main.layout_project_head.*
import java.util.concurrent.TimeUnit


class DanyeFragment : BaseFragment() {
    lateinit var projectInfoByConvert: ProjectInfoByConvert
    lateinit var projecInfoByResponse: ObservableResponse<ProjectInfoByEntity>
    var projectInfoByList: MutableList<ProjectInfoByEntity.ResultListBean> = ArrayList()
    lateinit var danyeAdapter: DanyeAdapter
    var pageNo = 1
    var colId = ""
    var danyeText: TextView? = null
    override fun getLayoutId(): Int {
        return R.layout.fragment_project_danye
    }

    override fun initView(view: View) {
        view.danye_recycle.setHasFixedSize(true)
        view.danye_recycle.layoutManager = GridLayoutManager(activity, 2) as RecyclerView.LayoutManager?
        danyeAdapter = DanyeAdapter(activity, projectInfoByList)
        view.danye_recycle.adapter = danyeAdapter
        val headerView = activity.getLayoutInflater().inflate(R.layout.layout_project_head, null)
        danyeText= headerView.findViewById(R.id.danye_text) as TextView
        headerView.layoutParams = ViewGroup.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        danyeAdapter.addHeaderView(headerView)
    }

    override fun initData() {
        danyeAdapter.setOnLoadMoreListener(BaseQuickAdapter.RequestLoadMoreListener {
            Observable.timer(1, TimeUnit.SECONDS).observeOn(Schedulers.io()).doOnComplete {
                pageNo += 1
                getProjectInfoById(colId)
            }.subscribe()
        })
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var bundle: Bundle = arguments
        colId = bundle.getString("ProjectInfoById")
        getProjectInfoById(colId)
    }

    fun getProjectInfoById(colId: String) {
        projectInfoByConvert = ProjectInfoByConvert()
        projecInfoByResponse = ObservableResponse()
        OkGo.post<ProjectInfoByEntity>(UrlConstans.InformationByCol)
            .headers("Content-Type", "application/json;charset=UTF-8")
            .params("colId", colId)
            .params("pageNo", pageNo)
            .params("pageSize", 10)
            .converter(projectInfoByConvert)
            .adapt(projecInfoByResponse)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : DisposableObserver<Response<ProjectInfoByEntity>>() {
                override fun onNext(response: Response<ProjectInfoByEntity>) {
                    if (response.code()==302){
                        var intent = Intent(activity, LoginActivity::class.java)
                        startActivity(intent)
                        return
                    }
                    var entity = response.body()
                    if (1 == pageNo) {
                        projectInfoByList.clear()
                        projectInfoByList = entity.resultList
                        danyeAdapter.setNewData(projectInfoByList)
                        danye_text.text = "      " + projectInfoByList[0].ifCreateName
                    } else {
                        if (entity.resultList.size > 0) {
                            for (listBean in entity.resultList) {
                                projectInfoByList.add(listBean)
                            }
                        }
                        danyeAdapter.addData(entity.resultList)
                        if (pageNo >= entity.totalPages) {
                            pageNo = entity.totalPages
                            danyeAdapter.loadMoreEnd()
                        } else {
                            danyeAdapter.loadMoreComplete()
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
}