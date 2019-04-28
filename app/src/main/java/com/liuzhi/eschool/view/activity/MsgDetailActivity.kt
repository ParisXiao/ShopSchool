package com.liuzhi.eschool.view.activity

import android.view.MenuItem
import com.liuzhi.eschool.R
import com.liuzhi.eschool.entity.SystemMsgEntity
import com.liuzhi.eschool.entity.SystemMsgEntity.DataBean.ResultListBean
import kotlinx.android.synthetic.main.activity_msg_detail.*
import kotlinx.android.synthetic.main.layout_title.*

class MsgDetailActivity:BaseActivity(){
    lateinit var msgEntitys: ResultListBean
    override fun getLayoutId(): Int {
        return R.layout.activity_msg_detail
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
        title_name.text="系统信息详情"
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
        msgEntitys= intent.getSerializableExtra("MsgDetail") as ResultListBean
        msg_title.text=msgEntitys.ctName
        msg_sender.text=msgEntitys.ctSenderName
        msg_receiver.text=msgEntitys.ctReceiverName
        msg_time.text=msgEntitys.ctCreateTime
        msg_content.text=msgEntitys.ctContent
    }

}