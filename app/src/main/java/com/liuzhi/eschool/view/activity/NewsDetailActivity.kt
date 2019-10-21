package com.liuzhi.eschool.view.activity

import android.view.MenuItem
import com.liuzhi.eschool.R
import com.zzhoujay.richtext.RichText
import kotlinx.android.synthetic.main.activity_news_detail.*
import kotlinx.android.synthetic.main.fragment_richtext.view.*
import kotlinx.android.synthetic.main.layout_title.*

class NewsDetailActivity:BaseActivity(){
    override fun getLayoutId(): Int {
        return R.layout.activity_news_detail
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
        title_name.text = "新闻详情"
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
        var info=intent.getStringExtra("newsDetail")
        RichText.fromHtml(info).into(news_text)
    }

    override fun onDestroy() {
        super.onDestroy()
        RichText.clear(this)
    }

}