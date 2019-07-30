package com.liuzhi.eschool

import android.annotation.SuppressLint
import android.annotation.TargetApi
import android.os.Build
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.view.KeyEvent
import android.view.MenuItem
import android.widget.Toast
import com.liuzhi.eschool.other.BottomNavigationViewHelper
import com.liuzhi.eschool.utils.common.DialogUtils
import com.liuzhi.eschool.view.activity.BaseActivity
import com.liuzhi.eschool.view.fragment.ClassFragment
import com.liuzhi.eschool.view.fragment.HomeFragment
import com.liuzhi.eschool.view.fragment.MineFragment
import kotlinx.android.synthetic.main.activity_main.*



class MainActivity : BaseActivity() {
    val homeFragment = HomeFragment()
    val classFragment = ClassFragment()
    val mineFragment = MineFragment()
    lateinit var navigation:BottomNavigationView
    private var fragments: Array<Fragment>? = null    //Fragment数组
    private var lastShowFragment = 0   //表示最后一个显示的Fragment
    override fun getLayoutId(): Int {
        return R.layout.activity_main
    }

    @TargetApi(Build.VERSION_CODES.KITKAT)
    override fun initView() {
        navigation= findViewById(R.id.bottom_navigation) as BottomNavigationView
        BottomNavigationViewHelper.disableShiftMode(navigation)
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
    }

    override fun initData() {
        initFragments()
    }
    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home -> {
                if (lastShowFragment != 0) {
                    switchFrament(lastShowFragment, 0)
                    lastShowFragment = 0

                }
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_class -> {
                if (lastShowFragment != 1) {
                    switchFrament(lastShowFragment, 1)
                    lastShowFragment = 1
                }
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_mine -> {
                if (lastShowFragment != 2) {
                    switchFrament(lastShowFragment, 2)
                    lastShowFragment = 2
                }
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    /**
     * 切换Fragment
     *
     * @param lastIndex 上个显示Fragment的索引
     * @param index     需要显示的Fragment的索引
     */
    private fun switchFrament(lastIndex: Int, index: Int) {
        var transaction = getSupportFragmentManager().beginTransaction()
        transaction.hide(fragments?.get(lastIndex))
        if (!fragments?.get(index)?.isAdded()!!) {
            transaction.add(R.id.main_view, fragments?.get(index))
        }
        transaction.show(fragments?.get(index)).commitAllowingStateLoss()
    }

    private fun initFragments() {
        fragments = arrayOf(homeFragment, classFragment, mineFragment)
        lastShowFragment = 0
        getSupportFragmentManager()
            .beginTransaction()
            .add(R.id.main_view, homeFragment)
            .show(homeFragment)
            .commit()
    }

    private var exitTime: Long = 0

    override fun onKeyDown(keyCode: Int, event: KeyEvent): Boolean {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if (supportFragmentManager.backStackEntryCount == 0) {
                if (System.currentTimeMillis() - exitTime > 2000) {
                    //弹出提示，可以有多种方式
                    DialogUtils.getInstance(this@MainActivity).shortToast("再按一次退出")
                    exitTime = System.currentTimeMillis()
                } else {
                    super.onBackPressed() //退出
                }
            } else {
                supportFragmentManager.popBackStack() //fragment 出栈
            }
            return false
        }
        return super.onKeyDown(keyCode, event)
    }
}
