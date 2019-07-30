package com.liuzhi.eschool.view.activity

import android.content.Intent
import android.support.design.widget.TabLayout
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.MenuItem
import android.view.View
import com.liuzhi.eschool.R
import com.liuzhi.eschool.adapter.ProjectListAdapter
import com.liuzhi.eschool.constants.UrlConstans
import com.liuzhi.eschool.entity.AllProjectEntity
import com.liuzhi.eschool.entity.ProjectColumEntity
import com.liuzhi.eschool.entity.convert.AllProjectConvert
import com.liuzhi.eschool.entity.convert.ProjectColumConvert
import com.liuzhi.eschool.utils.common.DateUtil
import com.lzy.okgo.OkGo
import com.lzy.okgo.model.Response
import com.lzy.okrx2.adapter.ObservableResponse
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_train_template.*
import kotlinx.android.synthetic.main.layout_title.*

class ProjectListActivity : BaseActivity() {
    private lateinit var projectColumConvert: ProjectColumConvert
    private lateinit var allProjectConvert: AllProjectConvert
    private lateinit var projectColumResponse: ObservableResponse<ProjectColumEntity>
    private lateinit var allProjectResponse: ObservableResponse<AllProjectEntity>
    private lateinit var projectColumLists: MutableList<ProjectColumEntity.DataBean>
    private lateinit var allProjectLists: MutableList<AllProjectEntity.DataBean>
    private lateinit var projectListAdapter: ProjectListAdapter
    private var projectClId=""
    var projectName: String = ""

    override fun getLayoutId(): Int {
        return R.layout.activity_train_template
    }

    override fun initView() {
        projectName = intent.getStringExtra("ProjectName")
        when (projectName) {
            "CYFH" -> title_name.text = "创业孵化"
            "XQHZ" -> title_name.text = "校企合作"
            "XKJS" -> title_name.text = "学科竞赛"
            "FZSX" -> title_name.text = "仿真实训"
            "XNFZSFXM" -> title_name.text = "虚拟仿真示范项目"
            "XWZX" -> title_name.text = "新闻资讯"
            "XXSYS" -> title_name.text = "线下实验室"
        }

        toolbar.title = ""
        setSupportActionBar(toolbar)
        val actionBar = supportActionBar
        if (actionBar != null) {
            //设置左上角图标是否可点击
            actionBar.setHomeButtonEnabled(true)
            //左上角加上一个返回图标
            actionBar.setDisplayHomeAsUpEnabled(true)
        }
        project_refresh.setColorSchemeResources(android.R.color.holo_blue_light,
            android.R.color.holo_green_light, android.R.color.holo_orange_light)
        allProjectLists=ArrayList()
        projectListAdapter= ProjectListAdapter(this,allProjectLists)
        var layoutManager: RecyclerView.LayoutManager  = LinearLayoutManager(this)
        train_recycler.layoutManager = layoutManager
        train_recycler.adapter=projectListAdapter
        projectListAdapter.setOnItemClickListener { adapter, view, position ->
            if (projectName == "XWZX") {
                var intentWeb=Intent(this@ProjectListActivity,WebActivity::class.java)
                intentWeb.putExtra("WebTitle", "新闻详情")
                intentWeb.putExtra("WebHtml", UrlConstans.BaseUrl+"/html/text/"+allProjectLists[position].colId+".html")
                startActivity(intentWeb)
            }else {
                var intent = Intent(this@ProjectListActivity, ProjectDetailActivity::class.java)
                intent.putExtra("ProjectBean", allProjectLists[position])
                startActivity(intent)
            }
        }
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

    override fun initData() {

       if (!project_refresh.isRefreshing) {
           project_refresh.isRefreshing=true
       }

        getProjectColumn(projectName)
        train_tab.setOnTabSelectedListener(object:TabLayout.OnTabSelectedListener{
            override fun onTabReselected(tab: TabLayout.Tab?) {
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
            }

            override fun onTabSelected(tab: TabLayout.Tab?) {
                projectClId=projectColumLists[tab!!.position].colId
                getAllProject(projectClId)
            }
        })
        project_refresh.setOnRefreshListener {
            getProjectColumn(projectName)
        }
        train_search.setOnClickListener {
            var intent=Intent(this,SearchActivity::class.java)
            intent.putExtra("SearchType",2)
            intent.putExtra("colId",projectClId)
            startActivity(intent)
        }

    }

    fun getAllProject(projectClId: String) {
        allProjectConvert = AllProjectConvert()
        allProjectResponse = ObservableResponse()
        OkGo.get<AllProjectEntity>(UrlConstans.AllProject)
            .headers("Content-Type", "application/json;charset=UTF-8")
            .params("colId", projectClId)
            .converter(allProjectConvert)
            .adapt(allProjectResponse)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : DisposableObserver<Response<AllProjectEntity>>() {
                override fun onNext(response: Response<AllProjectEntity>) {
                    var entity = response.body()
                    if (entity==null){
                        var intent =Intent(this@ProjectListActivity,LoginActivity::class.java)
                        startActivity(intent)
                        return
                    }
                    if (entity.code == 0) {
                        allProjectLists=entity.data
                        projectListAdapter.setNewData(allProjectLists)
                    }
                }

                override fun onError(e: Throwable) {
                    Log.e("OKGO",e.message)
                }

                override fun onComplete() {
                    if (project_refresh.isRefreshing) {
                        project_refresh.isRefreshing=false
                    }
                }
            })
    }
    fun getProjectColumn(projectName: String) {
        projectColumConvert = ProjectColumConvert()
        projectColumResponse = ObservableResponse()
        projectColumLists=ArrayList()
        OkGo.get<ProjectColumEntity>(UrlConstans.ProjectColumn)
            .headers("Content-Type", "application/json;charset=UTF-8")
            .params("colSign", projectName)
            .converter(projectColumConvert)
            .adapt(projectColumResponse)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : DisposableObserver<Response<ProjectColumEntity>>() {
                override fun onNext(response: Response<ProjectColumEntity>) {
                    var entity = response.body()
                    if (entity==null){
                        var intent =Intent(this@ProjectListActivity,LoginActivity::class.java)
                        startActivity(intent)
                        return
                    }

                    if (entity.code == 0&&entity.data.size>0) {
                        projectColumLists=entity.data
                        if (entity.data.size>1) {
                            train_tab.visibility= View.VISIBLE
                            for (item in entity.data) {
                                train_tab.addTab(TabLayout(this@ProjectListActivity).newTab().setText(item.colName))
                            }

                        }else{
                            train_tab.visibility= View.GONE
                        }
                          getAllProject(projectColumLists[0].colId)
                    }else{
                        if (project_refresh.isRefreshing) {
                            project_refresh.isRefreshing=false
                        }
                    }
                }

                override fun onError(e: Throwable) {
                    Log.e("OKGO",e.message)
                    if (project_refresh.isRefreshing) {
                        project_refresh.isRefreshing=false
                    }
                }

                override fun onComplete() {
                }
            })
    }
}

