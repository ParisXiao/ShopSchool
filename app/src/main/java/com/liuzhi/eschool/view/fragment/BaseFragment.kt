package com.liuzhi.eschool.view.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

abstract class BaseFragment : Fragment() {
    /**
     * 初始化layout
     *
     * @return
     */
    protected abstract fun getLayoutId(): Int

    /**
     * 初始化布局
     */
    protected abstract fun initView(view: View)

    /**
     * 参数设置
     */
    protected abstract fun initData()
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var view = inflater.inflate(getLayoutId(), null)
        initView(view)
        initData()
        return view

    }


    override fun onDestroyView() {
        super.onDestroyView()
    }




}
