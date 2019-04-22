package com.liuzhi.eschool.view.activity

import android.support.design.widget.TabLayout
import android.util.Log
import android.view.MenuItem
import com.liuzhi.eschool.R
import com.liuzhi.eschool.adapter.ProjectInfoColAdapter
import com.liuzhi.eschool.constants.UrlConstans
import com.liuzhi.eschool.entity.AllProjectEntity
import com.liuzhi.eschool.entity.ProjectInfoColEntity
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

class ProjectDetailActivity : BaseActivity() {
    lateinit var projectBean: AllProjectEntity.DataBean
    lateinit var projectInfoColConvert: ProjectInfoColConvert
    lateinit var projectInfoColResponse: ObservableResponse<ProjectInfoColEntity>
    lateinit var projectInfoColAdapter: ProjectInfoColAdapter
    var projectInfoCOlBeans: MutableList<ProjectInfoColEntity.DataBean> = ArrayList()
    override fun getLayoutId(): Int {
        return R.layout.activity_project_detail
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
        projectInfoColAdapter = ProjectInfoColAdapter(supportFragmentManager)
        project_detail_viewpager.adapter = projectInfoColAdapter
        project_detail_tab.setupWithViewPager(project_detail_viewpager)
        project_detail_viewpager.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(project_detail_tab))
    }

    override fun initData() {
        projectBean = intent.getSerializableExtra("ProjectBean") as AllProjectEntity.DataBean
        title_name.text = projectBean.colName
        project_detail_name.text = projectBean.colName
        project_detail_start.text = "始于:" + DateUtil.getYM(projectBean.colReleaseTime)
        project_detail_end.text = "结束于:" + DateUtil.getYM(projectBean.colStopTime)
        ImageUtils.load(this, project_detail_img, UrlConstans.BaseUrl + projectBean.colImg)
        project_detail_des.text="       "+ projectBean.colDesc
        project_detail_btn.setOnClickListener {

        }
        getProjectInfoCol(projectBean.colId)
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

    fun getProjectInfoCol(colId: String) {
        projectInfoColConvert = ProjectInfoColConvert()
        projectInfoColResponse = ObservableResponse()
        OkGo.get<ProjectInfoColEntity>(UrlConstans.ProjectInfoCol)
            .headers("Content-Type", "application/json;charset=UTF-8")
            .params("colId", colId)
            .converter(projectInfoColConvert)
            .adapt(projectInfoColResponse)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : DisposableObserver<Response<ProjectInfoColEntity>>() {
                override fun onNext(response: Response<ProjectInfoColEntity>) {
                    var entity = response.body()

                    if (entity.code == 0) {
                        projectInfoCOlBeans = entity.data
                        projectInfoColAdapter.setDataList(projectInfoCOlBeans)
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