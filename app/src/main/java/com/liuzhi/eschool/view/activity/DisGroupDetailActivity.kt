package com.liuzhi.eschool.view.activity

import android.content.Intent
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.MenuItem
import com.liuzhi.eschool.R
import com.liuzhi.eschool.adapter.DisGroupDetailAdapter
import com.liuzhi.eschool.constants.UrlConstans
import com.liuzhi.eschool.constants.UserInfoConstans
import com.liuzhi.eschool.entity.DisGroupDetailEntity
import com.liuzhi.eschool.entity.DisGroupEntity
import com.liuzhi.eschool.entity.PaperTypeEntity
import com.liuzhi.eschool.entity.convert.DisGrouupDetailConvert
import com.liuzhi.eschool.entity.convert.PaperTypeConvert
import com.liuzhi.eschool.utils.common.DateUtil
import com.liuzhi.eschool.utils.common.DialogUtils
import com.lzy.okgo.OkGo
import com.lzy.okgo.convert.StringConvert
import com.lzy.okgo.model.Response
import com.lzy.okrx2.adapter.ObservableResponse
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_group.*
import kotlinx.android.synthetic.main.activity_myscore.*
import kotlinx.android.synthetic.main.fragment_tab.view.*
import kotlinx.android.synthetic.main.layout_title.*
import org.json.JSONObject

class DisGroupDetailActivity:BaseActivity(){
    lateinit var disGroupEntity : DisGroupEntity.ResultListBean
    lateinit var disGroupDetailEntitys:MutableList<DisGroupDetailEntity.DataBean.ResultListBean>
    lateinit var disGroupDetailAdapter:DisGroupDetailAdapter
     var pageNo=1
    override fun getLayoutId(): Int {
        return R.layout.activity_group
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
        title_name.setTextColor(resources.getColor(R.color.white))
        title_name.text="讨论组详情"
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
        disGroupEntity= intent.getSerializableExtra("DisGroupDetail") as DisGroupEntity.ResultListBean
        group_title.text="  "+disGroupEntity.psContent
        disGroupDetailEntitys=ArrayList()
        getDisGroupDetail(disGroupEntity.psId)
        disGroupDetailAdapter= DisGroupDetailAdapter(this,disGroupDetailEntitys)
        var layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(this)
        group_recycler.layoutManager = layoutManager
        group_recycler.adapter = disGroupDetailAdapter
        disGroupDetailAdapter.setOnLoadMoreListener {
            pageNo++
            getDisGroupDetail(disGroupEntity.psId)
        }
        group_commit.setOnClickListener {
            if (group_edit.text.toString().trim().isEmpty()){
                DialogUtils.getInstance(this).shortToast("请输入内容")
            }else{
                sendMyDis(disGroupEntity.psId,group_edit.text.toString().trim())
            }
        }
    }
    fun getDisGroupDetail(psId:String){
        var disGroupDetailConvert = DisGrouupDetailConvert()
        var  disGroupDetailObservableResponse= ObservableResponse<DisGroupDetailEntity>()
        OkGo.get<DisGroupDetailEntity>(UrlConstans.GetForum)
            .headers("Content-Type", "application/json;charset=UTF-8")
            .params("psId",psId)
            .params("pageNo",pageNo)
            .params("pageSize",10)
            .converter(disGroupDetailConvert)
            .adapt(disGroupDetailObservableResponse)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : DisposableObserver<Response<DisGroupDetailEntity>>() {
                override fun onNext(response: Response<DisGroupDetailEntity>) {
                    var entity = response.body()
                    if (entity==null){
                        var intent =Intent(this@DisGroupDetailActivity,LoginActivity::class.java)
                        startActivity(intent)
                        return
                    }
                    if (entity != null&&entity.code==0) {
                        if (1 == pageNo) {
                            disGroupDetailEntitys.clear()
                            disGroupDetailEntitys = entity.data.resultList
                            disGroupDetailAdapter.setNewData(disGroupDetailEntitys)
                        } else {
                            if (entity.data.resultList.size > 0) {
                                for (listBean in entity.data.resultList) {
                                    disGroupDetailEntitys.add(listBean)
                                }
                            }
                            disGroupDetailAdapter.addData(entity.data.resultList)
                            if (pageNo >= entity.data.totalPages) {
                                pageNo = entity.data.totalPages
                                disGroupDetailAdapter.loadMoreEnd()
                            } else {
                                disGroupDetailAdapter.loadMoreComplete()
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
    fun sendMyDis(psId:String,psContent:String){
        OkGo.post<String>(UrlConstans.UserPost)
            .headers("Content-Type", "application/json;charset=UTF-8")
            .params("psCommentId",psId)
            .params("psContent",psContent)
            .converter(StringConvert())
            .adapt(ObservableResponse<String>())
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : DisposableObserver<Response<String>>() {
                override fun onNext(response: Response<String>) {
                    var entity:JSONObject =JSONObject( response.body())
                    if (entity==null){
                        var intent =Intent(this@DisGroupDetailActivity,LoginActivity::class.java)
                        startActivity(intent)
                        return
                    }

                    if (entity .optInt("code")==0) {
                        var bean=DisGroupDetailEntity.DataBean.ResultListBean()
                        bean.uName=UserInfoConstans.USERNAME
                        bean.psEditTime=DateUtil.getDateToString(System.currentTimeMillis())
                        bean.psContent=psContent
                        disGroupDetailAdapter.addData(bean)
                        group_edit.setText("")
                        DialogUtils.getInstance(this@DisGroupDetailActivity).shortToast("发表成功")
                    }else{
                        DialogUtils.getInstance(this@DisGroupDetailActivity).shortToast("发表失败")
                    }
                }

                override fun onError(e: Throwable) {
                    Log.e("OKGO", e.message)
                    DialogUtils.getInstance(this@DisGroupDetailActivity).shortToast("发表失败："+e.message)
                }

                override fun onComplete() {
                    DialogUtils.getInstance(this@DisGroupDetailActivity).dismisDialog()
                }
            })
    }
}