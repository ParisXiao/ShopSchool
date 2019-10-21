package com.liuzhi.eschool.view.fragment

import android.graphics.Color
import android.os.Bundle
import android.view.View
import com.liuzhi.eschool.R
import com.liuzhi.eschool.entity.ProjectDetailByIdEntity
import com.zzhoujay.richtext.ImageHolder
import com.zzhoujay.richtext.RichText
import kotlinx.android.synthetic.main.fragment_richtext.view.*

class RichTextFragment:BaseFragment(){
    lateinit var info:String
    override fun getLayoutId(): Int {
        return R.layout.fragment_richtext
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var bundle: Bundle = arguments
        info = bundle.getString("richtext")
    }
    override fun initView(view: View) {
        RichText.fromHtml(info).into(view.rich_text)
    }

    override fun initData() {
    }

    override fun onDestroy() {
        super.onDestroy()
        RichText.clear(activity)
    }
}