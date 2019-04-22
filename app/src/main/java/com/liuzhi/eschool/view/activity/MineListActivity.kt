package com.liuzhi.eschool.view.activity

import android.support.design.widget.TabLayout
import android.util.Log
import android.view.MenuItem
import android.view.View
import com.liuzhi.eschool.R
import com.liuzhi.eschool.adapter.TabTitleAdapter
import com.liuzhi.eschool.constants.UrlConstans
import com.liuzhi.eschool.entity.*
import com.liuzhi.eschool.entity.convert.DisGroupConvert
import com.liuzhi.eschool.entity.convert.MyCourseConvert
import com.liuzhi.eschool.entity.convert.QuestionConvert
import com.liuzhi.eschool.entity.convert.WorkingConvert
import com.lzy.okgo.OkGo
import com.lzy.okgo.model.Response
import com.lzy.okrx2.adapter.ObservableResponse
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_question_template.*
import kotlinx.android.synthetic.main.layout_title.*

class MineListActivity : BaseActivity() {
    var pageNo: Int = 1
    var type: Int = 0
    var psIsComment = 0
    var psNoComment = 0
    var courseStudying = 0
    var courseStudyed = 0
    var working = 0
    var finishWork = 0
    lateinit var tabTitleAdapter: TabTitleAdapter
    lateinit var tabTitleEntitys: MutableList<TabTitleEntity>
    lateinit var questionEntitys: MutableList<QuestionEntity.ResultListBean>
    lateinit var questionOnlines: MutableList<QuestionEntity.ResultListBean>
    lateinit var questionOffs: MutableList<QuestionEntity.ResultListBean>
    override fun getLayoutId(): Int {
        return R.layout.activity_question_template
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
        toolbar.setBackgroundColor(resources.getColor(R.color.main_blue_color))
        ll_main.setBackgroundColor(resources.getColor(R.color.main_blue_color))
        title_name.setTextColor(resources.getColor(R.color.white))
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

        type = intent.getIntExtra("MineListType", 0)
        tabTitleAdapter = TabTitleAdapter(supportFragmentManager)
        question_viewpager.adapter = tabTitleAdapter
        question_tab.setupWithViewPager(question_viewpager)
        question_viewpager.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(question_tab))
        when (type) {
            1 -> {
                //考试列表
                title_name.text = "在线考试"
                var tabTitleEntity: TabTitleEntity = TabTitleEntity()
                tabTitleEntity.tabId = 1
                tabTitleEntity.isRed = false
                tabTitleEntity.titleName = "在线考试"
                var tabTitleEntity1: TabTitleEntity = TabTitleEntity()
                tabTitleEntity1.tabId = 2
                tabTitleEntity1.isRed = false
                tabTitleEntity1.titleName = "模拟考试"
                tabTitleEntitys = ArrayList()
                tabTitleEntitys.add(tabTitleEntity)
                tabTitleEntitys.add(tabTitleEntity1)
                tabTitleAdapter.setDataList(tabTitleEntitys)

            }
            2 -> {
                //考试列表
                title_name.text = "调查问卷"
                questionEntitys = ArrayList()
                questionOnlines = ArrayList()
                questionOffs = ArrayList()
                getQuestionList()
            }
            3 -> {
                //讨论组列表
                title_name.text = "讨论组"
                getDisGroupList()
            }
            4 -> {
                //课程列表
                title_name.text = "我的课程"
                getCourseList()
            }
            5 -> {
                //作业列表
                title_name.text = "作业管理"
                getWorkingList()
            }
            6 -> {
                //浏览记录列表
                title_name.text = "浏览记录"
                question_tab.visibility= View.GONE
                var tabTitleEntity1: TabTitleEntity= TabTitleEntity()
                tabTitleEntity1.tabId=11
                tabTitleEntity1.isRed=false
                tabTitleEntity1.titleName="已完成"
                tabTitleEntitys=ArrayList()
                tabTitleEntitys.add(tabTitleEntity1)
                tabTitleAdapter.setDataList(tabTitleEntitys)
            }
            7 -> {
                //收藏列表
                title_name.text = "我的收藏"
                var tabTitleEntity: TabTitleEntity = TabTitleEntity()
                tabTitleEntity.tabId = 12
                tabTitleEntity.isRed = false
                tabTitleEntity.titleName = "学习资源"
                var tabTitleEntity1: TabTitleEntity = TabTitleEntity()
                tabTitleEntity1.tabId = 13
                tabTitleEntity1.isRed = false
                tabTitleEntity1.titleName = "新闻资讯"
                tabTitleEntitys = ArrayList()
                tabTitleEntitys.add(tabTitleEntity)
                tabTitleEntitys.add(tabTitleEntity1)
                tabTitleAdapter.setDataList(tabTitleEntitys)

            }
            8 -> {
                //系统消息列表
                title_name.text = "系统消息"
                question_tab.visibility= View.GONE
                var tabTitleEntity: TabTitleEntity = TabTitleEntity()
                tabTitleEntity.tabId = 14
                tabTitleEntity.isRed = false
                tabTitleEntity.titleName = "系统消息"
                tabTitleEntitys = ArrayList()
                tabTitleEntitys.add(tabTitleEntity)
                tabTitleAdapter.setDataList(tabTitleEntitys)

            }
            9 -> {
                //课程表列表
                title_name.text = "课程表"
                question_tab.visibility= View.GONE
                var tabTitleEntity: TabTitleEntity = TabTitleEntity()
                tabTitleEntity.tabId = 15
                tabTitleEntity.isRed = false
                tabTitleEntity.titleName = "课程表"
                tabTitleEntitys = ArrayList()
                tabTitleEntitys.add(tabTitleEntity)
                tabTitleAdapter.setDataList(tabTitleEntitys)

            }
        }


    }

    fun getQuestionList() {
        var questionConvert = QuestionConvert()
        var questionObservableResponse = ObservableResponse<QuestionEntity>()
        OkGo.get<QuestionEntity>(UrlConstans.SurveyList)
            .headers("Content-Type", "application/json;charset=UTF-8")
            .params("pageNo", pageNo)
            .params("pageSize", 100)
            .converter(questionConvert)
            .adapt(questionObservableResponse)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : DisposableObserver<Response<QuestionEntity>>() {
                override fun onNext(response: Response<QuestionEntity>) {
                    var entity = response.body()

                    if (entity != null) {
                        questionEntitys.clear()
                        questionEntitys = entity.resultList
                        questionOnlines.clear()
                        questionOffs.clear()
                        for (bean in questionEntitys) {
                            if (!bean.isQnIsClosed) {
                                questionOnlines.add(bean)
                            } else {
                                questionOffs.add(bean)
                            }
                        }

                    }

                }

                override fun onError(e: Throwable) {
                    Log.e("OKGO", e.message)
                }

                override fun onComplete() {
                    var tabTitleEntity: TabTitleEntity= TabTitleEntity()
                    tabTitleEntity.tabId=3
                    tabTitleEntity.isRed=true
                    tabTitleEntity.titleName="未完成"
                    tabTitleEntity.dataSize=questionOnlines.size
                    var tabTitleEntity1: TabTitleEntity= TabTitleEntity()
                    tabTitleEntity1.tabId=4
                    tabTitleEntity1.isRed=true
                    tabTitleEntity1.titleName="已完成"
                    tabTitleEntity1.dataSize=questionOffs.size
                    tabTitleEntitys=ArrayList()
                    tabTitleEntitys.add(tabTitleEntity)
                    tabTitleEntitys.add(tabTitleEntity1)
                    tabTitleAdapter.setDataList(tabTitleEntitys)
                }
            })
    }
    fun getDisGroupList() {
        var disGroupConvert = DisGroupConvert()
        var disGroupObservableResponse = ObservableResponse<DisGroupEntity>()
        OkGo.get<DisGroupEntity>(UrlConstans.ForumList)
            .headers("Content-Type", "application/json;charset=UTF-8")
            .params("pageNo", pageNo)
            .params("pageSize", 100)
            .converter(disGroupConvert)
            .adapt(disGroupObservableResponse)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : DisposableObserver<Response<DisGroupEntity>>() {
                override fun onNext(response: Response<DisGroupEntity>) {
                    var entity = response.body()

                    if (entity != null) {
                        for (bean in entity.resultList) {
                            if (!bean.isPsIsVerify) {
                                psNoComment++
                            } else {
                                psIsComment++
                            }
                        }
                    }

                }

                override fun onError(e: Throwable) {
                    Log.e("OKGO", e.message)
                }

                override fun onComplete() {
                    var tabTitleEntity: TabTitleEntity= TabTitleEntity()
                    tabTitleEntity.tabId=5
                    tabTitleEntity.isRed=true
                    tabTitleEntity.titleName="未审核"
                    tabTitleEntity.dataSize=psNoComment
                    var tabTitleEntity1: TabTitleEntity= TabTitleEntity()
                    tabTitleEntity1.tabId=6
                    tabTitleEntity1.isRed=true
                    tabTitleEntity1.titleName="已审核"
                    tabTitleEntity1.dataSize=psIsComment
                    tabTitleEntitys=ArrayList()
                    tabTitleEntitys.add(tabTitleEntity)
                    tabTitleEntitys.add(tabTitleEntity1)
                    tabTitleAdapter.setDataList(tabTitleEntitys)
                }
            })
    }
    fun getCourseList() {
        var myCourseConvert = MyCourseConvert()
        var myCourseObservableResponse = ObservableResponse<MyCourseEntity>()
        OkGo.get<MyCourseEntity>(UrlConstans.CourseList)
            .headers("Content-Type", "application/json;charset=UTF-8")
            .params("pageNo", pageNo)
            .params("pageSize", 100)
            .converter(myCourseConvert)
            .adapt(myCourseObservableResponse)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : DisposableObserver<Response<MyCourseEntity>>() {
                override fun onNext(response: Response<MyCourseEntity>) {
                    var entity = response.body()

                    if (entity != null) {
                        for (bean in entity.resultList) {
                            if (bean.styStatus==0) {
                                courseStudying++
                            } else {
                                courseStudyed++
                            }
                        }
                    }

                }

                override fun onError(e: Throwable) {
                    Log.e("OKGO", e.message)
                }

                override fun onComplete() {
                    var tabTitleEntity: TabTitleEntity= TabTitleEntity()
                    tabTitleEntity.tabId=7
                    tabTitleEntity.isRed=true
                    tabTitleEntity.titleName="正在学习"
                    tabTitleEntity.dataSize=courseStudying
                    var tabTitleEntity1: TabTitleEntity= TabTitleEntity()
                    tabTitleEntity1.tabId=8
                    tabTitleEntity1.isRed=true
                    tabTitleEntity1.titleName="学习完成"
                    tabTitleEntity1.dataSize=courseStudyed
                    tabTitleEntitys=ArrayList()
                    tabTitleEntitys.add(tabTitleEntity)
                    tabTitleEntitys.add(tabTitleEntity1)
                    tabTitleAdapter.setDataList(tabTitleEntitys)
                }
            })
    }
    fun getWorkingList() {
        var workingConvert = WorkingConvert()
        var workingObservableResponse = ObservableResponse<WorkingEntity>()
        OkGo.get<WorkingEntity>(UrlConstans.MyWorkList)
            .headers("Content-Type", "application/json;charset=UTF-8")
            .params("pageNo", pageNo)
            .params("pageSize", 100)
            .converter(workingConvert)
            .adapt(workingObservableResponse)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : DisposableObserver<Response<WorkingEntity>>() {
                override fun onNext(response: Response<WorkingEntity>) {
                    var entity = response.body()

                    if (entity != null) {
                        working=entity.resultList.size
                    }

                }

                override fun onError(e: Throwable) {
                    Log.e("OKGO", e.message)
                }

                override fun onComplete() {
                    getFinishWorkList()
                }
            })
    }
    fun getFinishWorkList() {
        var myCourseConvert = MyCourseConvert()
        var myCourseObservableResponse = ObservableResponse<MyCourseEntity>()
        OkGo.get<MyCourseEntity>(UrlConstans.FinishWorkList)
            .headers("Content-Type", "application/json;charset=UTF-8")
            .params("pageNo", pageNo)
            .params("pageSize", 100)
            .converter(myCourseConvert)
            .adapt(myCourseObservableResponse)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : DisposableObserver<Response<MyCourseEntity>>() {
                override fun onNext(response: Response<MyCourseEntity>) {
                    var entity = response.body()

                    if (entity != null) {
                       finishWork=entity.resultList.size
                    }

                }

                override fun onError(e: Throwable) {
                    Log.e("OKGO", e.message)
                }

                override fun onComplete() {
                    var tabTitleEntity: TabTitleEntity= TabTitleEntity()
                    tabTitleEntity.tabId=9
                    tabTitleEntity.isRed=true
                    tabTitleEntity.titleName="未完成"
                    tabTitleEntity.dataSize=working
                    var tabTitleEntity1: TabTitleEntity= TabTitleEntity()
                    tabTitleEntity1.tabId=10
                    tabTitleEntity1.isRed=true
                    tabTitleEntity1.titleName="已完成"
                    tabTitleEntity1.dataSize=finishWork
                    tabTitleEntitys=ArrayList()
                    tabTitleEntitys.add(tabTitleEntity)
                    tabTitleEntitys.add(tabTitleEntity1)
                    tabTitleAdapter.setDataList(tabTitleEntitys)
                }
            })
    }

}