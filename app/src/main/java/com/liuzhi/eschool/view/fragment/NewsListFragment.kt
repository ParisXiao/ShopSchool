package com.liuzhi.eschool.view.fragment

import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import com.liuzhi.eschool.R
import com.liuzhi.eschool.adapter.NewsListAdapter
import com.liuzhi.eschool.entity.ProjectDetailByIdEntity
import com.liuzhi.eschool.view.activity.NewsDetailActivity
import com.liuzhi.eschool.view.activity.ProjectDetailActivity
import kotlinx.android.synthetic.main.activity_train_template.*
import kotlinx.android.synthetic.main.fragment_list_news.view.*

class NewsListFragment:BaseFragment(){
    lateinit var newsLists:ProjectDetailByIdEntity.DataBean.InfoBeanX.InfoBean
    lateinit var newsListAdapter:NewsListAdapter
    override fun getLayoutId(): Int {
        return R.layout.fragment_list_news
    }

    override fun initView(view: View) {
        newsListAdapter= NewsListAdapter(activity,newsLists.resultList)
        var layoutManager: RecyclerView.LayoutManager  = LinearLayoutManager(activity) as RecyclerView.LayoutManager
        view. recycler_news_list.layoutManager = layoutManager
        view. recycler_news_list.adapter=newsListAdapter
        newsListAdapter.setOnItemClickListener { adapter, view, position ->
            var intent = Intent(activity, NewsDetailActivity::class.java)
            intent.putExtra("newsDetail", newsLists.resultList[position].ifContent)
           activity.startActivity(intent)
        }
    }

    override fun initData() {

    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var bundle: Bundle = arguments
        newsLists = bundle.getSerializable("NewsList") as ProjectDetailByIdEntity.DataBean.InfoBeanX.InfoBean
    }
}