package com.liuzhi.eschool.view.fragment

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.TabLayout
import android.text.TextUtils
import android.view.View
import com.liuzhi.eschool.R
import com.liuzhi.eschool.adapter.ClassTypeAdapter
import com.liuzhi.eschool.constants.UrlConstans
import com.liuzhi.eschool.entity.ClassTypeEntity
import com.liuzhi.eschool.entity.convert.ClassTypeConvert
import com.liuzhi.eschool.view.activity.LoginActivity
import com.lzy.okgo.OkGo
import com.lzy.okgo.model.Response
import com.lzy.okrx2.adapter.ObservableResponse
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.fragment_classtype.view.*

class ClassTypeFragment : BaseFragment() {
    lateinit var classTypeAdapter: ClassTypeAdapter
    private var classTypes: MutableList<ClassTypeEntity.DataBean> = ArrayList()
    private  var classTypeConvert:ClassTypeConvert?=null
    private  var classTypeResponse:ObservableResponse<ClassTypeEntity>?=null
    var classId:String?=""
    override fun getLayoutId(): Int {
        return R.layout.fragment_classtype
    }

    override fun initView(view: View) {
        classTypeAdapter= ClassTypeAdapter(childFragmentManager)
        view.class_container.adapter=classTypeAdapter
        view.class_type_tab.setupWithViewPager(view.class_container)
        view.class_container.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(view.class_type_tab))

    }

    override fun initData() {
        if (!TextUtils.isEmpty(classId)){
            getClassTypeLists(classId!!)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       var bundle:Bundle = getArguments()
        classId = bundle.getString("classId")
        if (classId == null) {
            classId = ""
        }

    }
    fun getClassTypeLists(classId:String){
        if (classTypeConvert == null) {
            classTypeConvert = ClassTypeConvert()
            classTypeResponse = ObservableResponse()
        }
        OkGo.get<ClassTypeEntity>(UrlConstans.SecondType)
            .headers("Content-Type", "application/json;charset=UTF-8")
            .params("tpNodeId",classId)
            .converter(classTypeConvert)
            .adapt(classTypeResponse)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : DisposableObserver<Response<ClassTypeEntity>>() {
                override fun onNext(response: Response<ClassTypeEntity>) {
                    var entity:ClassTypeEntity=response.body()
                    classTypes=entity.data
                    classTypeAdapter.setDataList(classTypes)
                }

                override fun onError(e: Throwable) {

                }

                override fun onComplete() {

                }
            })
    }
}