package com.liuzhi.eschool.view.activity

import android.content.Intent
import android.support.design.widget.TabLayout
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.MenuItem
import android.view.View
import android.widget.AbsListView
import com.liuzhi.eschool.R
import com.liuzhi.eschool.adapter.*
import com.liuzhi.eschool.constants.UrlConstans
import com.liuzhi.eschool.entity.*
import com.liuzhi.eschool.entity.convert.*
import com.liuzhi.eschool.utils.common.DateUtil
import com.lzy.okgo.OkGo
import com.lzy.okgo.model.Response
import com.lzy.okrx2.adapter.ObservableResponse
import com.zzhoujay.richtext.RichText
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_project_detail.*
import kotlinx.android.synthetic.main.activity_train_template.*
import kotlinx.android.synthetic.main.fragment_project_danye.view.*
import kotlinx.android.synthetic.main.layout_title.*

class ColumnListActivity : BaseActivity() {

    private var mSecondResponseInfos: MutableList<SecondResponseEntity.DataBean.InfoBean> = ArrayList()
    lateinit var mifInfoAdapter: IfListInfoAdapter
    lateinit var mifPhotoAdapter: IfPhotoAdapter


    private lateinit var mProjectColumnAdapter: ProjectColumnAdapter
    var colType=0
    override fun getLayoutId(): Int {
        return R.layout.activity_train_template
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
        project_refresh.setColorSchemeResources(android.R.color.holo_blue_light,
            android.R.color.holo_green_light, android.R.color.holo_orange_light)
        train_search.visibility=View.GONE

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
        title_name.text = intent.getStringExtra("colName")
        colType=intent.getIntExtra("colType",0)
       if (!project_refresh.isRefreshing) {
           project_refresh.isRefreshing=true
       }
        getSecondResponse(intent.getStringExtra("toColId"))
        project_refresh.setOnRefreshListener {
            getSecondResponse(intent.getStringExtra("toColId"))
        }
        train_recycler.addOnScrollListener(object : RecyclerView.OnScrollListener(){
            override fun onScrolled(recyclerView: RecyclerView?, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                project_refresh.isEnabled=train_recycler.getChildCount() == 0 || train_recycler.getChildAt(0).getTop() >= 0
            }
        })
    }
    private lateinit var secondResponseConvert: SecondResponseConvert
    private lateinit var secondResponseObserver: ObservableResponse<SecondResponseEntity>
    fun getSecondResponse(colId: String) {
        secondResponseConvert = SecondResponseConvert()
        secondResponseObserver = ObservableResponse()
        OkGo.post<SecondResponseEntity>(UrlConstans.SecondPost)
                .headers("Content-Type", "application/json;charset=UTF-8")
                .params("colId", colId)
                .converter(secondResponseConvert)
                .adapt(secondResponseObserver)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(object : DisposableObserver<Response<SecondResponseEntity>>() {
                    override fun onNext(response: Response<SecondResponseEntity>) {
                        var entity = response.body()
                        if (entity == null) {
                            var intent = Intent(this@ColumnListActivity, LoginActivity::class.java)
                            startActivity(intent)
                            return
                        }
                        if (entity.code == 0) {
                            if (entity.data.column.size > 0) {
                                train_recycler.visibility=View.GONE
                                train_tab.visibility=View.VISIBLE
                                train_viewpager.visibility=View.VISIBLE
                                mProjectColumnAdapter = ProjectColumnAdapter(supportFragmentManager)
                                train_viewpager.adapter = mProjectColumnAdapter
                                train_tab.setupWithViewPager(train_viewpager)
                                train_viewpager.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(train_tab))
                                mProjectColumnAdapter.setDataList(entity.data.column)
                            } else {
                                 if (entity.data.info.size > 0) {
                                     train_viewpager.visibility = View.GONE
                                     train_tab.visibility = View.GONE
                                     train_recycler.visibility = View.VISIBLE
                                     train_recycler.setHasFixedSize(true)
                                    mSecondResponseInfos=entity.data.info
                                    if (colType == 1) {
                                        train_recycler.layoutManager = GridLayoutManager(this@ColumnListActivity, 2) as RecyclerView.LayoutManager?
                                        mifPhotoAdapter = IfPhotoAdapter(this@ColumnListActivity, mSecondResponseInfos)
                                        train_recycler.adapter = mifPhotoAdapter
                                        mifPhotoAdapter.setNewData(mSecondResponseInfos)
                                    }else{
                                        var layoutManager: RecyclerView.LayoutManager  = LinearLayoutManager(this@ColumnListActivity)
                                        train_recycler.layoutManager = layoutManager
                                        mifInfoAdapter= IfListInfoAdapter(this@ColumnListActivity,mSecondResponseInfos)
                                        train_recycler.adapter=mifInfoAdapter
                                        mifInfoAdapter.setNewData(mSecondResponseInfos)
                                        mifInfoAdapter.setOnItemClickListener { adapter, view, position ->
                                            var intent=Intent(this@ColumnListActivity,DetailActivity::class.java)
                                            intent.putExtra("ifId",mSecondResponseInfos[position].ifId)
                                            startActivity(intent)
                                        }
                                    }
                                }
                            }
                        }
                    }

                    override fun onError(e: Throwable) {
                        Log.e("OKGO", e.message)
                    }

                    override fun onComplete() {
                        if (project_refresh.isRefreshing) {
                            project_refresh.isRefreshing=false
                        }
                    }
                })
    }


}

