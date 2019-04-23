package com.liuzhi.eschool.view.fragment

import android.content.Intent
import android.util.Log
import android.view.View
import com.liuzhi.eschool.R
import com.liuzhi.eschool.constants.UrlConstans
import com.liuzhi.eschool.entity.HistoryEntity
import com.liuzhi.eschool.entity.SystemMsgEntity
import com.liuzhi.eschool.entity.UserInfoEntity
import com.liuzhi.eschool.entity.convert.HistoryConvert
import com.liuzhi.eschool.entity.convert.SystemMsgConvert
import com.liuzhi.eschool.entity.convert.UserInfoConvert
import com.liuzhi.eschool.utils.common.DateUtil
import com.liuzhi.eschool.utils.common.ImageUtils
import com.liuzhi.eschool.view.activity.MineListActivity
import com.liuzhi.eschool.view.activity.MyScoreActivity
import com.liuzhi.eschool.view.activity.UserInfoSetActivity
import com.lzy.okgo.OkGo
import com.lzy.okgo.model.Response
import com.lzy.okrx2.adapter.ObservableResponse
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.fragment_mine.*
import kotlinx.android.synthetic.main.fragment_mine.view.*

class MineFragment : BaseFragment(), View.OnClickListener {
    override fun onClick(p0: View?) {
        when (p0) {
            mine_exam -> {
                var intent = Intent(activity, MineListActivity::class.java)
                intent.putExtra("MineListType", 1)
                activity.startActivity(intent)
            }
            mine_question -> {
                var intent = Intent(activity, MineListActivity::class.java)
                intent.putExtra("MineListType", 2)
                activity.startActivity(intent)
            }
            mine_group -> {
                var intent = Intent(activity, MineListActivity::class.java)
                intent.putExtra("MineListType", 3)
                activity.startActivity(intent)
            }
            mine_curriculum -> {
                var intent = Intent(activity, MineListActivity::class.java)
                intent.putExtra("MineListType", 4)
                activity.startActivity(intent)
            }
            mine_work -> {
                var intent = Intent(activity, MineListActivity::class.java)
                intent.putExtra("MineListType", 5)
                activity.startActivity(intent)
            }
            mine_history -> {
                var intent = Intent(activity, MineListActivity::class.java)
                intent.putExtra("MineListType", 6)
                activity.startActivity(intent)
            }
            mine_collect -> {
                var intent = Intent(activity, MineListActivity::class.java)
                intent.putExtra("MineListType", 7)
                activity.startActivity(intent)
            }
            mine_msg_record -> {
                var intent = Intent(activity, MineListActivity::class.java)
                intent.putExtra("MineListType", 8)
                activity.startActivity(intent)
            }
            mine_browse_record -> {
                var intent = Intent(activity, MineListActivity::class.java)
                intent.putExtra("MineListType", 6)
                activity.startActivity(intent)
            }
            mine_syllabus -> {
                var intent = Intent(activity, MineListActivity::class.java)
                intent.putExtra("MineListType", 9)
                activity.startActivity(intent)
            }
            mine_data_manager -> {
                var intent = Intent(activity, UserInfoSetActivity::class.java)
                intent.putExtra("UserInfo", userInfoEntity)
                if (userInfoEntity != null) {
                    activity.startActivity(intent)
                }
            }
            mine_score -> {
                var intent = Intent(activity, MyScoreActivity::class.java)
                activity.startActivity(intent)
            }
        }
    }

    private var userInfoEntity: UserInfoEntity? = null
    override fun getLayoutId(): Int {
        return R.layout.fragment_mine
    }

    override fun initView(view: View) {
        view.mine_exam.setOnClickListener(this)
        view.mine_question.setOnClickListener(this)
        view.mine_group.setOnClickListener(this)
        view.mine_curriculum.setOnClickListener(this)
        view.mine_work.setOnClickListener(this)
        view.mine_history.setOnClickListener(this)
        view.mine_collect.setOnClickListener(this)
        view.mine_msg_record.setOnClickListener(this)
        view.mine_browse_record.setOnClickListener(this)
        view.mine_syllabus.setOnClickListener(this)
        view.mine_data_manager.setOnClickListener(this)
        view.mine_score.setOnClickListener(this)
    }

    override fun initData() {
        getUserInfo()
        getHistoryList()
        getSystemMsgList()
    }

    fun getUserInfo() {
        var userInfoConvert = UserInfoConvert()
        var userInfoObservableResponse = ObservableResponse<UserInfoEntity>()
        OkGo.get<UserInfoEntity>(UrlConstans.CurrentUser)
            .headers("Content-Type", "application/json;charset=UTF-8")
            .converter(userInfoConvert)
            .adapt(userInfoObservableResponse)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : DisposableObserver<Response<UserInfoEntity>>() {
                override fun onNext(response: Response<UserInfoEntity>) {
                    var entity = response.body()
                    if (entity != null) {
                        userInfoEntity = entity
                        mine_username.text = entity.getaUserName()
                        mine_usermajor.text = entity.mjName
                        ImageUtils.setImageBitmapUrl(activity, user_icon, UrlConstans.BaseUrl + entity.getaPhotoUrl())
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
            .params("page", 1)
            .params("pageSize", 100)
            .converter(systemMsgConvert)
            .adapt(systemMsgObservableResponse)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : DisposableObserver<Response<SystemMsgEntity>>() {
                override fun onNext(response: Response<SystemMsgEntity>) {
                    var entity = response.body()

                    if (entity != null && entity.code == 0) {
                        view!!.msg_record.text = entity.data.totalRows.toString()
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
                    var entity = response.body()

                    if (entity != null) {
                        if (entity.code == 0) {
                            view!!.browse_record.text = "" + entity.data.size
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