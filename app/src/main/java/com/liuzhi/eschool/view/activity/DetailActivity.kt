package com.liuzhi.eschool.view.activity

import android.content.Intent
import android.support.design.widget.TabLayout
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.MenuItem
import android.view.View
import com.liuzhi.eschool.R
import com.liuzhi.eschool.adapter.ProjectInfoColAdapter
import com.liuzhi.eschool.adapter.ProjectListAdapter
import com.liuzhi.eschool.constants.UrlConstans
import com.liuzhi.eschool.entity.FirstResponseEntity
import com.liuzhi.eschool.entity.GetIfInfoEntity
import com.liuzhi.eschool.entity.SecondResponseEntity
import com.liuzhi.eschool.entity.convert.FirstResponseConvert
import com.liuzhi.eschool.entity.convert.GetInfoResponseConvert
import com.liuzhi.eschool.utils.common.DateUtil
import com.lzy.okgo.OkGo
import com.lzy.okgo.model.Response
import com.lzy.okrx2.adapter.ObservableResponse
import com.zzhoujay.richtext.RichText
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.android.synthetic.main.layout_title.*

class DetailActivity:BaseActivity(){
    private lateinit var mGetInfoResponseConvert:GetInfoResponseConvert
    private lateinit var mGetInfoObservableResponse:ObservableResponse<GetIfInfoEntity>
    override fun getLayoutId(): Int {
        return R.layout.activity_detail
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
        title_name.text = "信息详情"
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
        getInfo(intent.getStringExtra("ifId"))
    }
    fun getInfo(ifId:String){
        mGetInfoResponseConvert = GetInfoResponseConvert()
        mGetInfoObservableResponse = ObservableResponse()
        OkGo.get<GetIfInfoEntity>(UrlConstans.GetInfoPost)
                .headers("Content-Type", "application/json;charset=UTF-8")
                .params("ifId", ifId)
                .converter(mGetInfoResponseConvert)
                .adapt(mGetInfoObservableResponse)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(object : DisposableObserver<Response<GetIfInfoEntity>>() {
                    override fun onNext(response: Response<GetIfInfoEntity>) {
                        var entity = response.body()
                        if (entity==null){
                            var intent = Intent(this@DetailActivity,LoginActivity::class.java)
                            startActivity(intent)
                            return
                        }
                        if (entity.code == 0) {
                            if (entity.data.size>0){
                                main_text_title.text=entity.data[0].ifName
                                fu_text_title.text=entity.data[0].ifSubhead
                                text_from.text=entity.data[0].ifRsce
                                text_time.text= DateUtil.getYM(entity.data[0].ifReleaseTime)
                                RichText.fromHtml(entity.data[0].ifContent).into(text_rich)
                            }
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
        RichText.clear(this)
    }
}