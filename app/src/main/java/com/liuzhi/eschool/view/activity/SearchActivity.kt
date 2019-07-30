package com.liuzhi.eschool.view.activity

import android.content.Context
import android.content.Intent
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.KeyEvent
import android.view.MenuItem
import android.view.View
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputMethodManager
import android.widget.TextView
import com.liuzhi.eschool.R
import com.liuzhi.eschool.adapter.ClassSearchAdapter
import com.liuzhi.eschool.adapter.HomeSearchAdapter
import com.liuzhi.eschool.adapter.ProjectSearchAdapter
import com.liuzhi.eschool.constants.UrlConstans
import com.liuzhi.eschool.entity.*
import com.liuzhi.eschool.entity.convert.*
import com.liuzhi.eschool.utils.common.DateUtil
import com.liuzhi.eschool.utils.common.DialogUtils
import com.lzy.okgo.OkGo
import com.lzy.okgo.model.Response
import com.lzy.okrx2.adapter.ObservableResponse
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_search.*
import kotlinx.android.synthetic.main.fragment_tab.view.*
import java.util.*
import kotlin.collections.ArrayList

class SearchActivity : BaseActivity() {
    var type: Int = 0
    var colId = ""
    lateinit var homeSearchAdapter: HomeSearchAdapter
    lateinit var classSearchAdapter: ClassSearchAdapter
    lateinit var projectSearchAdapter: ProjectSearchAdapter
    lateinit var homes: MutableList<HomeSearchEntity.ResultListBean>
    lateinit var classs: MutableList<ClassSearchEntity.ResultListBean>
    lateinit var projects: MutableList<ProjectSearchEntity.ResultListBean>
    override fun getLayoutId(): Int {
        return R.layout.activity_search
    }

    override fun initView() {
        search_toolbar.setTitle("");
        setSupportActionBar(search_toolbar)
        val actionBar = supportActionBar
        if (actionBar != null) {
            //设置左上角图标是否可点击
            actionBar.setHomeButtonEnabled(true)
            //左上角加上一个返回图标
            actionBar.setDisplayHomeAsUpEnabled(true)
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
        type = intent.getIntExtra("SearchType", 0)
        when (type) {
            0 -> {
                search_edit.hint = "请输入您想要搜索的内容"
            }
            1 -> {
                search_edit.hint = "请输入您想要搜索的课程名称"
            }
            2 -> {
                search_edit.hint = "请输入您想要搜索的项目名称"
                colId=intent.getStringExtra("colId")
            }
        }
        search_edit.setOnEditorActionListener(object : TextView.OnEditorActionListener {
            override fun onEditorAction(p0: TextView?, p1: Int, p2: KeyEvent?): Boolean {
                if (p1 == EditorInfo.IME_ACTION_SEARCH) {
                    // 当按了搜索之后关闭软键盘
                    hideKeyboard(search_edit)
                    if (search_edit.text.toString().trim().isEmpty()) {
                        DialogUtils.getInstance(this@SearchActivity).shortToast("请输入搜索内容")
                    } else {
                        when (type) {
                            0 -> {
                                getHomeSearchList(search_edit.text.toString().trim())
                            }
                            1 -> {
                                getClassSearchList(search_edit.text.toString().trim())
                            }
                            2 -> {
                                getProjectSearchList(search_edit.text.toString().trim(),colId)
                            }
                        }
                    }
                    return true
                }

                return false
            }
        })
        homes = ArrayList()
        classs = ArrayList()
        projects = ArrayList()
        when (type) {
            0 -> {
                homeSearchAdapter= HomeSearchAdapter(this,homes)
                var layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(this)
                search_recycler.layoutManager = layoutManager
                search_recycler.adapter = homeSearchAdapter
                homeSearchAdapter.setOnItemClickListener { adapter, view, position ->
                    if (homes[position].ifName!=null&& homes[position].ifName.isNotEmpty()){
                        getProjectById(homes[position].colId)
                    }else{
                        getClassDetailById(homes[position].lsId.toLong())
                    }
                }
            }
            1 -> {
                classSearchAdapter= ClassSearchAdapter(this ,classs)
                var layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(this)
                search_recycler.layoutManager = layoutManager
                search_recycler.adapter = classSearchAdapter
                classSearchAdapter.setOnItemClickListener { adapter, view, position ->
                        getClassDetailById(classs[position].lsId.toLong())
                }
            }
            2 -> {
                projectSearchAdapter= ProjectSearchAdapter(this,projects)
                var layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(this)
                search_recycler.layoutManager = layoutManager
                search_recycler.adapter = projectSearchAdapter
                projectSearchAdapter.setOnItemClickListener { adapter, view, position ->
                    getProjectById(projects[position].colId)
                }
            }
        }
        search_commit.setOnClickListener {
            hideKeyboard(search_edit)
            if (search_edit.text.toString().trim().isEmpty()) {
                DialogUtils.getInstance(this@SearchActivity).shortToast("请输入搜索内容")
            } else {
                when (type) {
                    0 -> {
                        getHomeSearchList(search_edit.text.toString().trim())
                    }
                    1 -> {
                        getClassSearchList(search_edit.text.toString().trim())
                    }
                    2 -> {
                        getProjectSearchList(search_edit.text.toString().trim(),colId)
                    }
                }
            }
        }
    }

    fun hideKeyboard(view: View) {
        var manager = view.getContext()
            .getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        manager.hideSoftInputFromWindow(view.getWindowToken(), 0)
    }

    fun getHomeSearchList(searchText: String) {
        var homeSearchConvert = HomeSearchConvert()
        var homeSearchObservableResponse = ObservableResponse<HomeSearchEntity>()
        OkGo.get<HomeSearchEntity>(UrlConstans.IndexSearch)
            .headers("Content-Type", "application/json;charset=UTF-8")
            .params("keyword", searchText)
            .params("page", 1)
            .params("pageSize", 20)
            .converter(homeSearchConvert)
            .adapt(homeSearchObservableResponse)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : DisposableObserver<Response<HomeSearchEntity>>() {
                override fun onNext(response: Response<HomeSearchEntity>) {
                    var entity = response.body()
                    if (entity==null){
                        var intent =Intent(this@SearchActivity,LoginActivity::class.java)
                        startActivity(intent)
                        return
                    }

                    if (entity != null) {
                        homes.clear()
                        homes = entity.resultList
                        homeSearchAdapter.setNewData(homes)
                    }
                }

                override fun onError(e: Throwable) {
                    Log.e("OKGO", e.message)
                }

                override fun onComplete() {

                }
            })
    }

    fun getClassSearchList(searchText: String) {
        var classSearchConvert = ClassSearchConvert()
        var observableResponse = ObservableResponse<ClassSearchEntity>()
        OkGo.get<ClassSearchEntity>(UrlConstans.LessonSearch)
            .headers("Content-Type", "application/json;charset=UTF-8")
            .params("keyword", searchText)
            .params("page", 1)
            .params("pageSize", 20)
            .converter(classSearchConvert)
            .adapt(observableResponse)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : DisposableObserver<Response<ClassSearchEntity>>() {
                override fun onNext(response: Response<ClassSearchEntity>) {
                    var entity = response.body()
                    if (entity==null){
                        var intent =Intent(this@SearchActivity,LoginActivity::class.java)
                        startActivity(intent)
                        return
                    }

                    if (entity != null) {
                        classs.clear()
                        classs = entity.resultList
                        classSearchAdapter.setNewData(classs)
                    }
                }

                override fun onError(e: Throwable) {
                    Log.e("OKGO", e.message)
                }

                override fun onComplete() {

                }
            })
    }

    fun getProjectSearchList(searchText: String, colId: String) {
        var projectSearchConvert = ProjectSearchConvert()
        var observableResponse = ObservableResponse<ProjectSearchEntity>()
        OkGo.get<ProjectSearchEntity>(UrlConstans.ProjectSearch)
            .headers("Content-Type", "application/json;charset=UTF-8")
            .params("colId", colId)
            .params("keyword", searchText)
            .params("page", 1)
            .params("pageSize", 20)
            .converter(projectSearchConvert)
            .adapt(observableResponse)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : DisposableObserver<Response<ProjectSearchEntity>>() {
                override fun onNext(response: Response<ProjectSearchEntity>) {
                    var entity = response.body()
                    if (entity==null){
                        var intent =Intent(this@SearchActivity,LoginActivity::class.java)
                        startActivity(intent)
                        return
                    }

                    if (entity != null) {
                        projects.clear()
                        projects = entity.resultList
                        projectSearchAdapter.setNewData(projects)
                    }
                }

                override fun onError(e: Throwable) {
                    Log.e("OKGO", e.message)
                }

                override fun onComplete() {

                }
            })
    }
    fun getClassDetailById(id:Long) {
        var classDetailByIdConvert = ClassDetailByIdConvert()
        var detailByIdObservableResponse = ObservableResponse<ClassDetailByIdEntity>()
        OkGo.get<ClassDetailByIdEntity>(UrlConstans.LessonDetailById)
            .headers("Content-Type", "application/json;charset=UTF-8")
            .params("lsId", id)
            .converter(classDetailByIdConvert)
            .adapt(detailByIdObservableResponse)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : DisposableObserver<Response<ClassDetailByIdEntity>>() {
                override fun onNext(response: Response<ClassDetailByIdEntity>) {
                    var entity = response.body()
                    if (entity==null){
                        var intent =Intent(this@SearchActivity,LoginActivity::class.java)
                        startActivity(intent)
                        return
                    }

                    if (entity != null) {
                        if (entity.code == 0) {
                            var classDetail= ClassDetailEntity.ResultListBean()
                            classDetail.lsName=entity.data.lessonInfo.lsName
                            classDetail.lsCreateUName=entity.data.lessonInfo.lsCreateUName
                            classDetail.lsCreateTime=entity.data.lessonInfo.lsCreateTime
                            classDetail.lsDscb=entity.data.lessonInfo.lsDscb
                            classDetail.lsImg=entity.data.lessonInfo.lsImg
                            classDetail.lsId=entity.data.lessonInfo.lsId
                            var intent=Intent(this@SearchActivity, ClassDetailActivity::class.java)
                            intent.putExtra("LessonDetail",classDetail)
                            startActivity(intent)
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
    fun getProjectById(id: String) {
        var  projectDetailByIdConvert = ProjectDetailByIdConvert()
        var  projectDetailByIdResponse = ObservableResponse<ProjectDetailByIdEntity>()
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
                        var intent =Intent(this@SearchActivity,LoginActivity::class.java)
                        startActivity(intent)
                        return
                    }
                    if (entity.code == 0) {
                        var bean= AllProjectEntity.DataBean()
                        bean.colName=entity.data.leftMenu[0].colName
                        bean.colReleaseTime=entity.data.leftMenu[0].colReleaseTime
                        bean.colStopTime=entity.data.leftMenu[0].colStopTime
                        bean.colImg=entity.data.leftMenu[0].colImg
                        bean.colDesc=entity.data.leftMenu[0].colDesc
                        bean.colId=entity.data.leftMenu[0].colId
                        var intent =Intent(this@SearchActivity,ProjectDetailActivity::class.java)
                        intent.putExtra("ProjectBean",bean)
                        startActivity(intent)
                        return
                    }
                }

                override fun onError(e: Throwable) {
                    Log.e("OKGO",e.message)
                }

                override fun onComplete() {
                }
            })
    }

    override fun onDestroy() {
        super.onDestroy()
        hideKeyboard(search_commit)
    }
}