package com.liuzhi.eschool.view.activity

import android.content.Intent
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import com.liuzhi.eschool.R
import com.liuzhi.eschool.adapter.PaperAdapter
import com.liuzhi.eschool.constants.UrlConstans
import com.liuzhi.eschool.entity.PaperTotalEntity
import com.liuzhi.eschool.entity.PaperTypeEntity
import com.liuzhi.eschool.entity.convert.PaperTotalConvert
import com.liuzhi.eschool.entity.convert.PaperTypeConvert
import com.liuzhi.eschool.utils.common.DateUtil
import com.liuzhi.eschool.utils.common.DialogUtils
import com.liuzhi.eschool.view.widget.CustomDatePicker
import com.lzy.okgo.OkGo
import com.lzy.okgo.convert.StringConvert
import com.lzy.okgo.model.Response
import com.lzy.okrx2.adapter.ObservableResponse
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_myscore.*
import kotlinx.android.synthetic.main.layout_title.*
import org.json.JSONObject

class MyScoreActivity:BaseActivity(),View.OnClickListener{
    override fun onClick(p0: View?) {
        when(p0){
            time_spinner->{
                customDatePicker.show(time_spinner.text.toString().trim())
            }

        }
    }

    lateinit var customDatePicker:CustomDatePicker
    private var chooseTime: String=""
    lateinit var paperAdapter:PaperAdapter
    var types:MutableList<String> = ArrayList()
    var paperTypes:MutableList<PaperTypeEntity.DataBean> = ArrayList()
    lateinit var paperTotals:MutableList<PaperTotalEntity.ResultListBean>
    override fun getLayoutId(): Int {
        return R.layout.activity_myscore
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
        title_name.text="成绩查询"
        time_spinner.text= DateUtil.getPicKinit(System.currentTimeMillis())
        time_spinner.setOnClickListener(this)
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
        getPaperTypeList()
        initDatePicker()
        paperTotals=ArrayList()
        paperAdapter=PaperAdapter(this@MyScoreActivity,paperTotals)
        var layoutManager: RecyclerView.LayoutManager  = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter=paperAdapter
        pm_spinner.setOnItemSelectedListener(object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {
                if (time_spinner.text.toString().trim().isNotEmpty()&&pm_spinner.text.toString().trim().isNotEmpty()){
                    for (bean in paperTypes){
                        if (pm_spinner.text.equals(bean.ptName)){
                            getPaperTotalList(time_spinner.text.toString().trim(),bean.ptId)
                        }
                    }

                }
            }

            override fun onNothingSelected(parent: AdapterView<*>) {
            }
        })
    }

    private fun initDatePicker() {
        chooseTime=DateUtil.getPicKinit2(System.currentTimeMillis())
        customDatePicker = CustomDatePicker(this@MyScoreActivity, object : CustomDatePicker.ResultHandler {
          override  fun handle(time: String) { // 回调接口，获得选中的时间
              var newTime=time.substring(0,time.length-6)
                time_spinner.setText(newTime)
              if (time_spinner.text.toString().trim().isNotEmpty()&&pm_spinner.text.toString().trim().isNotEmpty()){
                  for (bean in paperTypes){
                      if (pm_spinner.text.equals(bean.ptName)){
                          getPaperTotalList(time_spinner.text.toString().trim(),bean.ptId)
                      }
                  }

              }
            }
        },"2018-01-01 00:00", chooseTime) // 初始化日期格式请用：yyyy-MM-dd HH:mm，否则不能正常运行
        customDatePicker.showSpecificTime(false) // 显示时和分
        customDatePicker.setIsLoop(true) // 不允许循环滚动
    }
    fun getPaperTypeList(){
        var paperTypeConvert =PaperTypeConvert()
        var paperObservableResponse=ObservableResponse<PaperTypeEntity>()
        OkGo.get<PaperTypeEntity>(UrlConstans.PaperTypeList)
            .headers("Content-Type", "application/json;charset=UTF-8")
            .converter(paperTypeConvert)
            .adapt(paperObservableResponse)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : DisposableObserver<Response<PaperTypeEntity>>() {
                override fun onNext(response: Response<PaperTypeEntity>) {
                    if (response.code()==302){
                        var intent = Intent(this@MyScoreActivity,LoginActivity::class.java)
                        startActivity(intent)
                        return
                    }
                    var entity = response.body()
                    if (entity!=null&&entity.data.size>0) {
                        paperTypes=entity.data
                        for (bean in entity.data){
                            types.add(bean.ptName)
                        }
                        pm_spinner.attachDataSource(types)
                    }
                }

                override fun onError(e: Throwable) {
                    Log.e("OKGO", e.message)
                }

                override fun onComplete() {
                }
            })
    }
    fun getPaperTotalList(time:String,type:String){
        var paperTotalConvert =PaperTotalConvert()
        var paperTotalObservableResponse=ObservableResponse<PaperTotalEntity>()
        paperTotals.clear()
        OkGo.get<PaperTotalEntity>(UrlConstans.PersonalGradeList)
            .headers("Content-Type", "application/json;charset=UTF-8")
            .params("time",time)
            .params("mebId",type)
            .converter(paperTotalConvert)
            .adapt(paperTotalObservableResponse)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : DisposableObserver<Response<PaperTotalEntity>>() {
                override fun onNext(response: Response<PaperTotalEntity>) {
                    if (response.code()==302){
                        var intent =Intent(this@MyScoreActivity,LoginActivity::class.java)
                        startActivity(intent)
                        return
                    }
                    var entity = response.body()
                    if (entity!=null) {
                        paperTotals=entity.resultList
                        paperAdapter.setNewData(paperTotals)
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