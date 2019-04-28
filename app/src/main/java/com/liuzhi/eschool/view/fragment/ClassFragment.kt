package com.liuzhi.eschool.view.fragment

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.FragmentManager
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import com.liuzhi.eschool.R
import com.liuzhi.eschool.adapter.ClassAdapter
import com.liuzhi.eschool.constants.UrlConstans
import com.liuzhi.eschool.entity.ClassEntity
import com.liuzhi.eschool.entity.convert.ClassConvert
import com.liuzhi.eschool.utils.common.DialogUtils
import com.liuzhi.eschool.view.activity.LoginActivity
import com.liuzhi.eschool.view.widget.VpSwipeRefreshLayout
import com.lzy.okgo.OkGo
import com.lzy.okgo.model.Response
import com.lzy.okrx2.adapter.ObservableResponse
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.fragment_class.view.*


class ClassFragment : BaseFragment() {
    private lateinit var classAdapter: ClassAdapter
    private var classLists: MutableList<ClassEntity.DataBean> = ArrayList()
    private var classConvert: ClassConvert? = null
    private var classResponse: ObservableResponse<ClassEntity>? = null
    override fun getLayoutId(): Int {
        return R.layout.fragment_class
    }
    private lateinit var refresh_class : VpSwipeRefreshLayout
    override fun initView(view: View) {
        refresh_class= view.findViewById(R.id.refresh_class) as VpSwipeRefreshLayout
        var layoutManager: RecyclerView.LayoutManager  = LinearLayoutManager(context)
        view.vertical_class_tab.layoutManager = layoutManager
        refresh_class.setColorSchemeResources(android.R.color.holo_blue_light,
            android.R.color.holo_green_light, android.R.color.holo_orange_light)
        classAdapter = ClassAdapter(activity,classLists)
        view.vertical_class_tab.adapter=classAdapter
        getClassLists()
        classAdapter.setOnItemClickListener { adapter, view, position ->
            for (item in classLists){
                item.isTpIsChoosed=false
            }
            classLists[position].isTpIsChoosed=true
            adapter.setNewData(classLists)
            goSecondClass(classLists[position].tpId)
        }
    }

    override fun initData() {
        refresh_class.setOnRefreshListener {
            getClassLists()
        }
    }

    fun getClassLists() {
        if (classConvert == null) {
            classConvert = ClassConvert()
            classResponse = ObservableResponse()
        }
        if (!refresh_class.isRefreshing) {
            refresh_class.isRefreshing=true
        }
        OkGo.get<ClassEntity>(UrlConstans.FirstType)
            .headers("Content-Type", "application/json;charset=UTF-8")
            .converter(classConvert)
            .adapt(classResponse)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : DisposableObserver<Response<ClassEntity>>() {
                override fun onNext(response: Response<ClassEntity>) {
                    if (response.code()==302){
                        var intent =Intent(activity,LoginActivity::class.java)
                        startActivity(intent)
                        return
                    }
                    var entity = response.body()
                    if (entity.code == 0) {
                        classLists.clear()
                        classLists=entity.data
                        if (classLists.isNotEmpty()){
                            classLists[0].isTpIsChoosed=true
                            goSecondClass(classLists[0].tpId)
                        }
                        classAdapter.setNewData(classLists)
                    } else {
                        DialogUtils.getInstance(activity)
                            .showFailDialog("加载失败", entity.msg, "重新加载") {
                                getClassLists()
                            }
                    }
                }

                override fun onError(e: Throwable) {
                    DialogUtils.getInstance(activity)
                        .showFailDialog("加载失败", e.message, "重新加载") {
                            getClassLists()
                        }
                }

                override fun onComplete() {
                    if(refresh_class.isRefreshing){
                        refresh_class.isRefreshing=false
                    }
                }
            })
    }
    fun goSecondClass(classId:String){
        val fragment = ClassTypeFragment()
        val bundle = Bundle()
        bundle.putString("classId",classId)
        fragment.arguments = bundle
        val fm:FragmentManager=activity.supportFragmentManager
        fm.beginTransaction().replace(R.id.frame_second_class,fragment).commit()
    }
}