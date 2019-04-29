package com.liuzhi.eschool.view.fragment

import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.text.TextUtils
import android.util.Log
import android.view.View
import com.liuzhi.eschool.R
import com.liuzhi.eschool.adapter.*
import com.liuzhi.eschool.constants.UrlConstans
import com.liuzhi.eschool.constants.UserInfoConstans
import com.liuzhi.eschool.entity.*
import com.liuzhi.eschool.entity.convert.*
import com.liuzhi.eschool.utils.common.DateUtil
import com.liuzhi.eschool.utils.common.SPUtils
import com.liuzhi.eschool.view.activity.*
import com.lzy.okgo.OkGo
import com.lzy.okgo.model.Response
import com.lzy.okrx2.adapter.ObservableResponse
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.fragment_tab.view.*

class TabFragment : BaseFragment() {
    var tabId = 0
    var pageNo: Int = 1
    lateinit var examiationEntitys: MutableList<ExamiationEntity.ResultListBean>
    lateinit var simulateEntitys: MutableList<SimulationEntity.ResultListBean>
    lateinit var questionEntitys: MutableList<QuestionEntity.ResultListBean>
    lateinit var questionOnlines: MutableList<QuestionEntity.ResultListBean>
    lateinit var questionOffs: MutableList<QuestionEntity.ResultListBean>
    lateinit var examiationAdapter: ExamiationAdapter
    lateinit var simulateExamAdapter: SimulateExamAdapter
    lateinit var questionAdapter: QuestionAdapter
    lateinit var onlines: MutableList<QuestionEntity.ResultListBean>
    lateinit var offs: MutableList<QuestionEntity.ResultListBean>
    lateinit var noComments: MutableList<DisGroupEntity.ResultListBean>
    lateinit var isComments: MutableList<DisGroupEntity.ResultListBean>
    lateinit var disGroupAdapter: DisGroupAdapter
    lateinit var courseStudyings: MutableList<MyCourseEntity.ResultListBean>
    lateinit var courseStudyeds: MutableList<MyCourseEntity.ResultListBean>
    lateinit var myCourseAdapter: MyCourseAdapter
    lateinit var workings: MutableList<WorkingEntity.ResultListBean>
    lateinit var workFinishs: MutableList<FinishWorkEntity.ResultListBean>
    lateinit var workAdapter: WorkAdapter
    lateinit var workFinishAdapter: WorkFinishAdapter
    lateinit var historys: MutableList<HistoryEntity.DataBean>
    lateinit var historyAdapter: HistoryAdapter
    lateinit var collectionLessions: MutableList<CollectionEntity.DataBean>
    lateinit var collectionNews: MutableList<CollectionEntity.DataBean>
    lateinit var collectionAdapter: CollectionAdapter
    lateinit var systemMsgs: MutableList<SystemMsgEntity.DataBean.ResultListBean>
    lateinit var systemMsgAdapter: SystemMsgAdapter
    lateinit var classTimes: MutableList<ClassTimeEntity.ResultListBean>
    lateinit var classTimeAdapter: ClassTimeAdapter
    override fun getLayoutId(): Int {
        return R.layout.fragment_tab
    }

    override fun initView(view: View) {
        examiationEntitys = ArrayList()
        examiationAdapter = ExamiationAdapter(activity, examiationEntitys)
        simulateEntitys = ArrayList()
        simulateExamAdapter = SimulateExamAdapter(activity, simulateEntitys)
        questionEntitys = ArrayList()
        questionOnlines = ArrayList()
        questionOffs = ArrayList()
        questionAdapter = QuestionAdapter(activity, questionEntitys)
        noComments = ArrayList()
        isComments = ArrayList()
        courseStudyeds = ArrayList()
        courseStudyings = ArrayList()
        workings = ArrayList()
        workFinishs = ArrayList()
        historys = ArrayList()
        collectionLessions = ArrayList()
        collectionNews = ArrayList()
        systemMsgs = ArrayList()
        classTimes = ArrayList()
        when (tabId) {
            1 -> {
                getExamiationList()
                var layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(activity)
                view.tab_recycler.layoutManager = layoutManager
                view.tab_recycler.adapter = examiationAdapter
                examiationAdapter.setOnItemClickListener { adapter, view, position ->
                    var intent= Intent(activity,WebActivity::class.java)
                    intent.putExtra("WebTitle", examiationEntitys[position].mebname)
                    intent.putExtra("WebHtml",UrlConstans.BaseUrl+"/exam/exam.html?pmLink="+examiationEntitys[position].pmLink)
                    startActivity(intent)
                }
                examiationAdapter.setOnLoadMoreListener {
                    pageNo++
                    getExamiationList()
                }
            }
            2 -> {
                getSimulationExamList()
                var layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(activity)
                view.tab_recycler.layoutManager = layoutManager
                view.tab_recycler.adapter = simulateExamAdapter

                simulateExamAdapter.setOnItemClickListener { adapter, view, position ->
                    var intent= Intent(activity,WebActivity::class.java)
                    intent.putExtra("WebTitle", simulateEntitys[position].teName)
                    intent.putExtra("WebHtml",UrlConstans.BaseUrl+"/exam/exam.html?pmLink="+simulateEntitys[position].teLink)
                    startActivity(intent)
                }
                simulateExamAdapter.setOnLoadMoreListener {
                    pageNo++
                    getSimulationExamList()
                }
            }
            3 -> {
                getQuestionList()
                var layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(activity)
                view.tab_recycler.layoutManager = layoutManager
                view.tab_recycler.adapter = questionAdapter
                questionAdapter.setOnItemClickListener { adapter, view, position ->
                    var intent= Intent(activity,WebActivity::class.java)
                    intent.putExtra("WebTitle", questionOnlines[position].qnName)
                    intent.putExtra("WebHtml",UrlConstans.BaseUrl+"/exam/questionnaire/"+questionOnlines[position].qnId+".html")
                    startActivity(intent)
                }
                questionAdapter.setOnLoadMoreListener {
                    pageNo++
                    getQuestionList()
                }
            }
            4 -> {
                getQuestionList()
                var layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(activity)
                view.tab_recycler.layoutManager = layoutManager
                view.tab_recycler.adapter = questionAdapter
                questionAdapter.setOnItemClickListener { adapter, view, position ->
                    var intent= Intent(activity,WebActivity::class.java)
                    intent.putExtra("WebTitle", questionOffs[position].qnName)
                    intent.putExtra("WebHtml",UrlConstans.BaseUrl+"/exam/questionnaire/"+questionOffs[position].qnId+".html")
                    startActivity(intent)
                }
                questionAdapter.setOnLoadMoreListener {
                    pageNo++
                    getQuestionList()
                }
            }
            5 -> {
                disGroupAdapter = DisGroupAdapter(activity, noComments)
                getDisGroupList()
                var layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(activity)
                view.tab_recycler.layoutManager = layoutManager
                view.tab_recycler.adapter = disGroupAdapter
                disGroupAdapter.setOnItemClickListener { adapter, view, position ->
                    var intent =Intent(activity,DisGroupDetailActivity::class.java)
                    intent.putExtra("DisGroupDetail",noComments[position])
                    startActivity(intent)
                }
                disGroupAdapter.setOnLoadMoreListener {
                    pageNo++
                    getDisGroupList()
                }
            }
            6 -> {

                disGroupAdapter = DisGroupAdapter(activity, isComments)
                getDisGroupList()
                var layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(activity)
                view.tab_recycler.layoutManager = layoutManager
                view.tab_recycler.adapter = disGroupAdapter
                disGroupAdapter.setOnItemClickListener { adapter, view, position ->
                    var intent =Intent(activity,DisGroupDetailActivity::class.java)
                    intent.putExtra("DisGroupDetail",isComments[position])
                    startActivity(intent)
                }
                disGroupAdapter.setOnLoadMoreListener {
                    pageNo++
                    getDisGroupList()
                }
            }
            7 -> {
                myCourseAdapter = MyCourseAdapter(activity, courseStudyings)
                getCourseList()
                var layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(activity)
                view.tab_recycler.layoutManager = layoutManager
                view.tab_recycler.adapter = myCourseAdapter
                myCourseAdapter.setOnItemClickListener { adapter, view, position ->
                    getClassDetailById(courseStudyings[position].lsId)
                }
                myCourseAdapter.setOnLoadMoreListener {
                    pageNo++
                    getCourseList()
                }
            }
            8 -> {
                myCourseAdapter = MyCourseAdapter(activity, courseStudyeds)
                getCourseList()
                var layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(activity)
                view.tab_recycler.layoutManager = layoutManager
                view.tab_recycler.adapter = myCourseAdapter
                myCourseAdapter.setOnItemClickListener { adapter, view, position ->
                    getClassDetailById(courseStudyeds[position].lsId)
                }
                myCourseAdapter.setOnLoadMoreListener {
                    pageNo++
                    getCourseList()
                }
            }
            9 -> {
                workAdapter = WorkAdapter(activity, workings)
                getWorkingList()
                var layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(activity)
                view.tab_recycler.layoutManager = layoutManager
                view.tab_recycler.adapter = workAdapter
                workAdapter.setOnItemClickListener { adapter, view, position ->
                    var intent= Intent(activity,WebActivity::class.java)
                    intent.putExtra("WebTitle", workings[position].cwName)
                    intent.putExtra("WebHtml",UrlConstans.BaseUrl+"/exam/classwork/"+workings[position].cwId+".html?jsessionid="+SPUtils.getInstance().getString(activity,UserInfoConstans.CookieId))
                    startActivity(intent)
                }
                workAdapter.setOnLoadMoreListener {
                    pageNo++
                    getWorkingList()
                }
            }
            10 -> {
                workFinishAdapter = WorkFinishAdapter(activity, workFinishs)
                getFinishWorkList()
                var layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(activity)
                view.tab_recycler.layoutManager = layoutManager
                view.tab_recycler.adapter = workFinishAdapter
                workFinishAdapter.setOnItemClickListener { adapter, view, position ->
                    var intent= Intent(activity,WebActivity::class.java)
                    intent.putExtra("WebTitle", workFinishs[position].cwName)
                    intent.putExtra("WebHtml",UrlConstans.BaseUrl+"/exam/classwork/"+workFinishs[position].cwId+".html?LZSESSIONID="+SPUtils.getInstance().getString(activity,UserInfoConstans.CookieId))
                    startActivity(intent)
                }
                workFinishAdapter.setOnLoadMoreListener {
                    pageNo++
                    getFinishWorkList()
                }
            }
            11 -> {
                historyAdapter = HistoryAdapter(activity, historys)
                getHistoryList()
                var layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(activity)
                view.tab_recycler.layoutManager = layoutManager
                view.tab_recycler.adapter = historyAdapter
                historyAdapter.setOnItemClickListener { adapter, view, position ->
                    if (!TextUtils.isEmpty(historys[position].getLsName())) {
                        getClassDetailById(historys[position].hiId.toLong())
                    }else{
                        var intent= Intent(activity,WebActivity::class.java)
                        intent.putExtra("WebTitle", historys[position].ifName)
                        intent.putExtra("WebHtml", UrlConstans.BaseUrl+"/html/text/"+historys[position].hiId+".html")
                        startActivity(intent)
                    }
                }
            }
            12 -> {
                collectionAdapter = CollectionAdapter(activity, collectionLessions)
                getCollectionLessionList(1)
                var layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(activity)
                view.tab_recycler.layoutManager = layoutManager
                view.tab_recycler.adapter = collectionAdapter
                collectionAdapter.setOnItemClickListener { adapter, view, position ->
                    getClassDetailById(collectionLessions[position].coId.toLong())
                }
            }
            13 -> {
                collectionAdapter = CollectionAdapter(activity, collectionNews)
                getCollectionLessionList(2)
                var layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(activity)
                view.tab_recycler.layoutManager = layoutManager
                view.tab_recycler.adapter = collectionAdapter
                collectionAdapter.setOnItemClickListener { adapter, view, position ->
                    var intent= Intent(activity,WebActivity::class.java)
                    intent.putExtra("WebTitle", collectionNews[position].ifName)
                    intent.putExtra("WebHtml", UrlConstans.BaseUrl+"/html/text/"+collectionNews[position].coId+".html")
                    startActivity(intent)
                }
            }
            14 -> {
                systemMsgAdapter = SystemMsgAdapter(activity, systemMsgs)
                getSystemMsgList()
                var layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(activity)
                view.tab_recycler.layoutManager = layoutManager
                view.tab_recycler.adapter = systemMsgAdapter
                systemMsgAdapter.setOnItemClickListener { adapter, view, position ->
                    var intent=Intent(activity,MsgDetailActivity::class.java)
                    intent.putExtra("MsgDetail",systemMsgs[position])
                    startActivity(intent)
                }
                systemMsgAdapter.setOnLoadMoreListener {
                    pageNo++
                    getSystemMsgList()
                }
            }
            15 -> {
                classTimeAdapter = ClassTimeAdapter(activity, classTimes)
                getClassTimeList()
                var layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(activity)
                view.tab_recycler.layoutManager = layoutManager
                view.tab_recycler.adapter = classTimeAdapter
                classTimeAdapter.setOnItemClickListener { adapter, view, position ->
                    var intent =Intent(activity, PdfActivity::class.java)
                    intent.putExtra("PDFName","课程表")
                    intent.putExtra("PDFUrl",UrlConstans.BaseUrl+classTimes[position].schCreateUName)
                    startActivity(intent)
                }
            }
        }

    }

    override fun initData() {
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var bundle: Bundle = getArguments()
        tabId = bundle.getInt("TabId")
    }

    fun getExamiationList() {
        var examiationConvert = ExamiationConvert()
        var examiationObservableResponse = ObservableResponse<ExamiationEntity>()
        OkGo.get<ExamiationEntity>(UrlConstans.OnlineExamList)
            .headers("Content-Type", "application/json;charset=UTF-8")
            .params("pageNo", pageNo)
            .params("pageSize", 10)
            .converter(examiationConvert)
            .adapt(examiationObservableResponse)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : DisposableObserver<Response<ExamiationEntity>>() {
                override fun onNext(response: Response<ExamiationEntity>) {
                    if (response.code()==302){
                        var intent =Intent(activity,LoginActivity::class.java)
                        startActivity(intent)
                        return
                    }
                    var entity = response.body()
                    if (entity != null) {
                        if (1 == pageNo) {
                            examiationEntitys.clear()
                            examiationEntitys = entity.resultList
                            examiationAdapter.setNewData(examiationEntitys)
                        } else {
                            if (entity.resultList.size > 0) {
                                for (listBean in entity.resultList) {
                                    examiationEntitys.add(listBean)
                                }
                            }
                            examiationAdapter.addData(entity.resultList)
                            if (pageNo >= entity.totalPages) {
                                pageNo = entity.totalPages
                                examiationAdapter.loadMoreEnd()
                            } else {
                                examiationAdapter.loadMoreComplete()
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

    fun getSimulationExamList() {
        var simulateExamConvert = SimulateExamConvert()
        var simulateObservableResponse = ObservableResponse<SimulationEntity>()
        OkGo.get<SimulationEntity>(UrlConstans.SimulateExamList)
            .headers("Content-Type", "application/json;charset=UTF-8")
            .params("pageNo", pageNo)
            .params("pageSize", 10)
            .converter(simulateExamConvert)
            .adapt(simulateObservableResponse)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : DisposableObserver<Response<SimulationEntity>>() {
                override fun onNext(response: Response<SimulationEntity>) {
                    if (response.code()==302){
                        var intent =Intent(activity,LoginActivity::class.java)
                        startActivity(intent)
                        return
                    }
                    var entity = response.body()

                    if (entity != null) {
                        if (1 == pageNo) {
                            simulateEntitys.clear()
                            simulateEntitys = entity.resultList
                            simulateExamAdapter.setNewData(simulateEntitys)
                        } else {
                            if (entity.resultList.size > 0) {
                                for (listBean in entity.resultList) {
                                    simulateEntitys.add(listBean)
                                }
                            }
                            simulateExamAdapter.addData(entity.resultList)
                            if (pageNo >= entity.totalPages) {
                                pageNo = entity.totalPages
                                simulateExamAdapter.loadMoreEnd()
                            } else {
                                simulateExamAdapter.loadMoreComplete()
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

    fun getQuestionList() {
        var questionConvert = QuestionConvert()
        var questionObservableResponse = ObservableResponse<QuestionEntity>()
        OkGo.get<QuestionEntity>(UrlConstans.SurveyList)
            .headers("Content-Type", "application/json;charset=UTF-8")
            .params("pageNo", pageNo)
            .params("pageSize", 10)
            .converter(questionConvert)
            .adapt(questionObservableResponse)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : DisposableObserver<Response<QuestionEntity>>() {
                override fun onNext(response: Response<QuestionEntity>) {
                    if (response.code()==302){
                        var intent =Intent(activity,LoginActivity::class.java)
                        startActivity(intent)
                        return
                    }
                    var entity = response.body()

                    if (entity != null) {
                        if (1 == pageNo) {
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
                            if (tabId == 3) {
                                questionAdapter.setNewData(questionOnlines)
                            } else if (tabId == 4) {
                                questionAdapter.setNewData(questionOffs)
                            }
                        } else {
                            onlines = ArrayList()
                            offs = ArrayList()
                            if (entity.resultList.size > 0) {
                                for (listBean in entity.resultList) {
                                    if (!listBean.isQnIsClosed) {
                                        onlines.add(listBean)
                                        questionOnlines.add(listBean)
                                    } else {
                                        offs.add(listBean)
                                        questionOffs.add(listBean)
                                    }
                                }
                            }
                            if (tabId == 3) {
                                questionAdapter.addData(onlines)
                            } else if (tabId == 4) {
                                questionAdapter.addData(offs)
                            }
                            if (pageNo >= entity.totalPages) {
                                pageNo = entity.totalPages
                                questionAdapter.loadMoreEnd()
                            } else {
                                questionAdapter.loadMoreComplete()
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

    fun getDisGroupList() {
        var disGroupConvert = DisGroupConvert()
        var disGroupObservableResponse = ObservableResponse<DisGroupEntity>()
        OkGo.get<DisGroupEntity>(UrlConstans.ForumList)
            .headers("Content-Type", "application/json;charset=UTF-8")
            .params("pageNo", pageNo)
            .params("pageSize", 10)
            .converter(disGroupConvert)
            .adapt(disGroupObservableResponse)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : DisposableObserver<Response<DisGroupEntity>>() {
                override fun onNext(response: Response<DisGroupEntity>) {
                    if (response.code()==302){
                        var intent =Intent(activity,LoginActivity::class.java)
                        startActivity(intent)
                        return
                    }
                    var entity = response.body()


                    if (entity != null) {
                        if (1 == pageNo) {
                            noComments.clear()
                            isComments.clear()
                            for (bean in entity.resultList) {
                                if (!bean.isPsIsVerify) {
                                    noComments.add(bean)
                                } else {
                                    isComments.add(bean)
                                }
                            }
                            if (tabId == 5) {
                                disGroupAdapter.setNewData(noComments)
                            } else if (tabId == 6) {
                                disGroupAdapter.setNewData(isComments)
                            }
                        } else {
                            var no: MutableList<DisGroupEntity.ResultListBean> = ArrayList()
                            var have: MutableList<DisGroupEntity.ResultListBean> = ArrayList()
                            if (entity.resultList.size > 0) {
                                for (listBean in entity.resultList) {
                                    if (!listBean.isPsIsVerify) {
                                        no.add(listBean)
                                        noComments.add(listBean)
                                    } else {
                                        have.add(listBean)
                                        isComments.add(listBean)
                                    }
                                }
                            }
                            if (tabId == 5) {
                                disGroupAdapter.addData(no)
                            } else if (tabId == 6) {
                                disGroupAdapter.addData(have)
                            }
                            if (pageNo >= entity.totalPages) {
                                pageNo = entity.totalPages
                                disGroupAdapter.loadMoreEnd()
                            } else {
                                disGroupAdapter.loadMoreComplete()
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

    fun getCourseList() {
        var myCourseConvert = MyCourseConvert()
        var myCourseObservableResponse = ObservableResponse<MyCourseEntity>()
        OkGo.get<MyCourseEntity>(UrlConstans.CourseList)
            .headers("Content-Type", "application/json;charset=UTF-8")
            .params("pageNo", pageNo)
            .params("pageSize", 10)
            .converter(myCourseConvert)
            .adapt(myCourseObservableResponse)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : DisposableObserver<Response<MyCourseEntity>>() {
                override fun onNext(response: Response<MyCourseEntity>) {
                    if (response.code()==302){
                        var intent =Intent(activity,LoginActivity::class.java)
                        startActivity(intent)
                        return
                    }
                    var entity = response.body()

                    if (entity != null) {
                        if (1 == pageNo) {
                            courseStudyeds.clear()
                            courseStudyings.clear()
                            for (bean in entity.resultList) {
                                if (bean.styStatus == 0) {
                                    courseStudyings.add(bean)
                                } else {
                                    courseStudyeds.add(bean)
                                }
                            }
                            if (tabId == 7) {
                                myCourseAdapter.setNewData(courseStudyings)
                            } else if (tabId == 8) {
                                myCourseAdapter.setNewData(courseStudyeds)
                            }
                        } else {
                            var no: MutableList<MyCourseEntity.ResultListBean> = ArrayList()
                            var have: MutableList<MyCourseEntity.ResultListBean> = ArrayList()
                            if (entity.resultList.size > 0) {
                                for (listBean in entity.resultList) {
                                    if (listBean.styStatus == 0) {
                                        no.add(listBean)
                                        courseStudyings.add(listBean)
                                    } else {
                                        have.add(listBean)
                                        courseStudyeds.add(listBean)
                                    }
                                }
                            }
                            if (tabId == 7) {
                                myCourseAdapter.addData(no)
                            } else if (tabId == 8) {
                                myCourseAdapter.addData(have)
                            }
                            if (pageNo >= entity.totalPages) {
                                pageNo = entity.totalPages
                                myCourseAdapter.loadMoreEnd()
                            } else {
                                myCourseAdapter.loadMoreComplete()
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

    fun getWorkingList() {
        var workingConvert = WorkingConvert()
        var workingObservableResponse = ObservableResponse<WorkingEntity>()
        OkGo.get<WorkingEntity>(UrlConstans.MyWorkList)
            .headers("Content-Type", "application/json;charset=UTF-8")
            .params("pageNo", pageNo)
            .params("pageSize", 10)
            .converter(workingConvert)
            .adapt(workingObservableResponse)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : DisposableObserver<Response<WorkingEntity>>() {
                override fun onNext(response: Response<WorkingEntity>) {
                    if (response.code()==302){
                        var intent =Intent(activity,LoginActivity::class.java)
                        startActivity(intent)
                        return
                    }
                    var entity = response.body()

                    if (entity != null) {
                        if (1 == pageNo) {
                            workings.clear()
                            workings = entity.resultList
                            workAdapter.setNewData(workings)
                        } else {
                            if (entity.resultList.size > 0) {
                                for (listBean in entity.resultList) {
                                    workings.add(listBean)
                                }
                            }
                            workAdapter.addData(entity.resultList)
                            if (pageNo >= entity.totalPages) {
                                pageNo = entity.totalPages
                                workAdapter.loadMoreEnd()
                            } else {
                                workAdapter.loadMoreComplete()
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

    fun getFinishWorkList() {
        var finishWorkConvert = FinishWorkConvert()
        var finishWorkObservableResponse = ObservableResponse<FinishWorkEntity>()
        OkGo.get<FinishWorkEntity>(UrlConstans.FinishWorkList)
            .headers("Content-Type", "application/json;charset=UTF-8")
            .params("pageNo", pageNo)
            .params("pageSize", 10)
            .converter(finishWorkConvert)
            .adapt(finishWorkObservableResponse)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : DisposableObserver<Response<FinishWorkEntity>>() {
                override fun onNext(response: Response<FinishWorkEntity>) {
                    if (response.code()==302){
                        var intent =Intent(activity,LoginActivity::class.java)
                        startActivity(intent)
                        return
                    }
                    var entity = response.body()


                    if (entity != null) {
                        if (1 == pageNo) {
                            workFinishs.clear()
                            workFinishs = entity.resultList
                            workFinishAdapter.setNewData(workFinishs)
                        } else {
                            if (entity.resultList.size > 0) {
                                for (listBean in entity.resultList) {
                                    workFinishs.add(listBean)
                                }
                            }
                            workFinishAdapter.addData(entity.resultList)
                            if (pageNo >= entity.totalPages) {
                                pageNo = entity.totalPages
                                workFinishAdapter.loadMoreEnd()
                            } else {
                                workFinishAdapter.loadMoreComplete()
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

    fun getHistoryList() {
        var historyConvert = HistoryConvert()
        var historyObservableResponse = ObservableResponse<HistoryEntity>()
        Log.e("time", DateUtil.getYear(System.currentTimeMillis()))
        Log.e("time", DateUtil.getMouth(System.currentTimeMillis()))
        OkGo.post<HistoryEntity>(UrlConstans.UserHistory)
            .headers("Content-Type", "application/json;charset=UTF-8")
            .params("year", DateUtil.getYear(System.currentTimeMillis()))
            .params("month", DateUtil.getMouth(System.currentTimeMillis()))
            .params("day", 0)
            .converter(historyConvert)
            .adapt(historyObservableResponse)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : DisposableObserver<Response<HistoryEntity>>() {
                override fun onNext(response: Response<HistoryEntity>) {
                    if (response.code()==302){
                        var intent =Intent(activity,LoginActivity::class.java)
                        startActivity(intent)
                        return
                    }
                    var entity = response.body()

                    if (entity != null) {
                        if (entity.code == 0) {
                            historys.clear()
                            historys = entity.data
                            historyAdapter.setNewData(historys)
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

    fun getCollectionLessionList(type: Int) {
        var collectionConvert = CollectionConvert()
        var collectionObservableResponse = ObservableResponse<CollectionEntity>()
        OkGo.post<CollectionEntity>(UrlConstans.Collection)
            .headers("Content-Type", "application/json;charset=UTF-8")
            .params("type", type)
            .converter(collectionConvert)
            .adapt(collectionObservableResponse)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : DisposableObserver<Response<CollectionEntity>>() {
                override fun onNext(response: Response<CollectionEntity>) {
                    if (response.code()==302){
                        var intent =Intent(activity,LoginActivity::class.java)
                        startActivity(intent)
                        return
                    }
                    var entity = response.body()

                    if (entity != null && entity.code == 0) {
                        if (type == 1) {
                            collectionLessions.clear()
                            for (bean in entity.data) {
                                collectionLessions.add(bean)
                            }
                            collectionAdapter.setNewData(collectionLessions)
                        } else {
                            collectionNews.clear()
                            for (bean in entity.data) {
                                collectionNews.add(bean)
                            }
                            collectionAdapter.setNewData(collectionNews)
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
    fun getSystemMsgList() {
        var systemMsgConvert = SystemMsgConvert()
        var systemMsgObservableResponse = ObservableResponse<SystemMsgEntity>()
        OkGo.get<SystemMsgEntity>(UrlConstans.ChatList)
            .headers("Content-Type", "application/json;charset=UTF-8")
            .params("page", pageNo)
            .params("pageSize", 10)
            .converter(systemMsgConvert)
            .adapt(systemMsgObservableResponse)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : DisposableObserver<Response<SystemMsgEntity>>() {
                override fun onNext(response: Response<SystemMsgEntity>) {
                    if (response.code()==302){
                        var intent =Intent(activity,LoginActivity::class.java)
                        startActivity(intent)
                        return
                    }
                    var entity = response.body()

                    if (entity != null&&entity.code==0) {
                        if (1 == pageNo) {
                            systemMsgs.clear()
                            systemMsgs = entity.data.resultList
                            systemMsgAdapter.setNewData(systemMsgs)
                        } else {
                            if (entity.data.resultList.size > 0) {
                                for (listBean in entity.data.resultList) {
                                    systemMsgs.add(listBean)
                                }
                            }
                            systemMsgAdapter.addData(entity.data.resultList)
                            if (pageNo >= entity.data.totalPages) {
                                pageNo = entity.data.totalPages
                                workFinishAdapter.loadMoreEnd()
                            } else {
                                workFinishAdapter.loadMoreComplete()
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
    fun getClassTimeList() {
        var classTimeConvert = ClassTimeConvert()
        var classTimeObservableResponse = ObservableResponse<ClassTimeEntity>()
        OkGo.get<ClassTimeEntity>(UrlConstans.ScheduleList)
            .headers("Content-Type", "application/json;charset=UTF-8")
            .params("pageNO", pageNo)
            .params("pageSize", 10)
            .converter(classTimeConvert)
            .adapt(classTimeObservableResponse)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : DisposableObserver<Response<ClassTimeEntity>>() {
                override fun onNext(response: Response<ClassTimeEntity>) {
                    if (response.code()==302){
                        var intent =Intent(activity,LoginActivity::class.java)
                        startActivity(intent)
                        return
                    }
                    var entity = response.body()

                    if (entity != null) {
                        if (1 == pageNo) {
                            classTimes.clear()
                            classTimes = entity.resultList
                            classTimeAdapter.setNewData(classTimes)
                        } else {
                            if (entity.resultList.size > 0) {
                                for (listBean in entity.resultList) {
                                    classTimes.add(listBean)
                                }
                            }
                            classTimeAdapter.addData(entity.resultList)
                            if (pageNo >= entity.totalPages) {
                                pageNo = entity.totalPages
                                classTimeAdapter.loadMoreEnd()
                            } else {
                                classTimeAdapter.loadMoreComplete()
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
                    if (response.code()==302){
                        var intent =Intent(activity,LoginActivity::class.java)
                        startActivity(intent)
                        return
                    }
                    var entity = response.body()

                    if (entity != null) {
                        if (entity.code == 0) {
                            var classDetail=ClassDetailEntity.ResultListBean()
                            classDetail.lsName=entity.data.lessonInfo.lsName
                            classDetail.lsCreateUName=entity.data.lessonInfo.lsCreateUName
                            classDetail.lsCreateTime=entity.data.lessonInfo.lsCreateTime
                            classDetail.lsDscb=entity.data.lessonInfo.lsDscb
                            classDetail.lsImg=entity.data.lessonInfo.lsImg
                            classDetail.lsId=entity.data.lessonInfo.lsId
                            var intent=Intent(activity, ClassDetailActivity::class.java)
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

}