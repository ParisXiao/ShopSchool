package com.liuzhi.eschool

import android.annotation.TargetApi
import android.os.Build
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.view.MenuItem
import com.liuzhi.eschool.other.BottomNavigationViewHelper
import com.liuzhi.eschool.view.activity.BaseActivity
import com.liuzhi.eschool.view.fragment.ClassFragment
import com.liuzhi.eschool.view.fragment.HomeFragment
import com.liuzhi.eschool.view.fragment.MineFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {
    val homeFragment = HomeFragment()
    val classFragment = ClassFragment()
    val mineFragment = MineFragment()
    private var fragments: Array<Fragment>? = null    //Fragment数组
    private var lastShowFragment = 0   //表示最后一个显示的Fragment
    override fun getLayoutId(): Int {
        return R.layout.activity_main
    }

    @TargetApi(Build.VERSION_CODES.KITKAT)
    override fun initView() {
        BottomNavigationViewHelper.disableShiftMode(bottom_navigation)
        bottom_navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
    }

    override fun initData() {
        initFragments()
    }

    private val mOnNavigationItemSelectedListener: BottomNavigationView.OnNavigationItemSelectedListener =
        object : BottomNavigationView.OnNavigationItemSelectedListener {
            override fun onNavigationItemSelected(p0: MenuItem): Boolean {
                when (p0.itemId) {
                    R.id.navigation_home -> {
                        if (lastShowFragment != 0) {
                            switchFrament(lastShowFragment, 0)
                            lastShowFragment = 0
                        }
                    }
                    R.id.navigation_class -> {
                        if (lastShowFragment != 1) {
                            switchFrament(lastShowFragment, 1)
                            lastShowFragment = 1
                        }
                    }
                    R.id.navigation_mine -> {
                        if (lastShowFragment != 2) {
                            switchFrament(lastShowFragment, 2)
                            lastShowFragment = 2
                        }
                    }
                }
                return false
            }

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
        lastShowFragment = 0;
        getSupportFragmentManager()
            .beginTransaction()
            .add(R.id.main_view, homeFragment)
            .show(homeFragment)
            .commit()
    }


}
