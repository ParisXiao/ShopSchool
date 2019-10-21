package com.liuzhi.eschool.view.activity

import android.content.Intent
import android.support.design.widget.TabLayout
import android.util.Log
import android.view.MenuItem
import com.liuzhi.eschool.R
import com.liuzhi.eschool.adapter.FzsxInfoAdapter
import com.liuzhi.eschool.adapter.NewsViewAdapter
import com.liuzhi.eschool.adapter.ProjectInfoColAdapter
import com.liuzhi.eschool.constants.UrlConstans
import com.liuzhi.eschool.entity.*
import com.liuzhi.eschool.entity.convert.ClassDetailByIdConvert
import com.liuzhi.eschool.entity.convert.ProjectDetailByIdConvert
import com.liuzhi.eschool.entity.convert.ProjectInfoColConvert
import com.liuzhi.eschool.utils.common.DateUtil
import com.liuzhi.eschool.utils.common.ImageUtils
import com.lzy.okgo.OkGo
import com.lzy.okgo.model.Response
import com.lzy.okrx2.adapter.ObservableResponse
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_project_detail.*
import kotlinx.android.synthetic.main.layout_title.*

class NewsListActivity : BaseActivity() {
    lateinit var projectBean: ProjectDetailByIdEntity.DataBean
    lateinit var newsViewAdapter: NewsViewAdapter
    var projectInfoCOlBeans: MutableList<ProjectDetailByIdEntity.DataBean.InfoBeanX> = ArrayList()
    override fun getLayoutId(): Int {
        return R.layout.activity_detail_fzsx
    }

    override fun initView() {
        toolbar.title = ""
        setSupportActionBar(toolbar)
        val actionBar = supportActionBar
        if (actionBar != null) {
            //设置左上角图标是否可点击
            actionBar.setHomeButtonEnabled(true)
            //左上角加上一个返回图标
            actionBar.setDisplayHomeAsUpEnabled(true)
        }
        newsViewAdapter = NewsViewAdapter(supportFragmentManager)
        project_detail_viewpager.adapter = newsViewAdapter
        project_detail_tab.setupWithViewPager(project_detail_viewpager)
        project_detail_viewpager.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(project_detail_tab))
    }

    override fun initData() {
        title_name.text = "新闻中心"
        getProjectById("631316344624648192")

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Pass the event to ActionBarDrawerToggle, if it returns
        // true, then it has handled the app icon_star touch event
        if (item.itemId == android.R.id.home) {
            finish()
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    fun getProjectById(id: String) {
        var projectDetailByIdConvert = ProjectDetailByIdConvert()
        var projectDetailByIdResponse = ObservableResponse<ProjectDetailByIdEntity>()
        OkGo.get<ProjectDetailByIdEntity>(UrlConstans.ColInfo)
                .headers("Content-Type", "application/json;charset=UTF-8")
                .params("colId", id)
                .converter(projectDetailByIdConvert)
                .adapt(projectDetailByIdResponse)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(object : DisposableObserver<Response<ProjectDetailByIdEntity>>() {
                    override fun onNext(response: Response<ProjectDetailByIdEntity>) {
                        var entity = response.body()
                        if (entity==null){
                            var intent =Intent(this@NewsListActivity,LoginActivity::class.java)
                            startActivity(intent)
                            return
                        }
                        if (entity.code == 0) {
                            projectBean=entity.data
                            projectInfoCOlBeans = projectBean.info
                            newsViewAdapter.setDataList(projectInfoCOlBeans)
                            return
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