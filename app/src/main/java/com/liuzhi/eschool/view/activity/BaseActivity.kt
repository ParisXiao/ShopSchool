package com.liuzhi.eschool.view.activity

import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.view.WindowManager
import cn.pedant.SweetAlert.SweetAlertDialog

/**
 * Created by xiaoli on 2018/4/11.
 */

abstract class BaseActivity : AppCompatActivity() {
    private var mDialog: SweetAlertDialog? = null
    var setBlackBar = false

    /**
     * 初始化layout
     *
     * @return
     */
    protected abstract fun getLayoutId(): Int

    /**
     * 初始化布局
     */
    protected abstract fun initView()

    /**
     * 参数设置
     */
    protected abstract fun initData()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutId())
        TranslucentFlag()
        initView()
        initData()
    }

    /**
     * 沉浸式状态栏适配
     */
    private fun TranslucentFlag() {
        window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {//4.4 全透明状态栏
            window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {//5.0 全透明实现
            val window = window
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
            window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or
                    View.SYSTEM_UI_FLAG_LAYOUT_STABLE
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            window.statusBarColor = -0x7fcfc061//calculateStatusColor(Color.WHITE, (int) alphaValue)
            window.statusBarColor = Color.TRANSPARENT//calculateStatusColor(Color.WHITE, (int) alphaValue)
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {//6.0以上 全透明实现
            if (!setBlackBar) {
                window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or
                        View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
            } else {
                window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
            }

        }
    }

    /**
     * 隐藏Android底部的虚拟按键
     */
    private fun hideVirtualKey() {
        val window = window
        val params = window.attributes
        params.systemUiVisibility = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
        window.attributes = params
    }


}
