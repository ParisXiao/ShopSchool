package com.liuzhi.eschool.utils.common;

/**
 * Created by tjq on 2017/12/26.
 */
public class BtnClickUtils {
    // 两次点击按钮之间的点击间隔不能少于1000毫秒
    private static long endTime;
    private static final int MAX_CLICK_DELAY_TIME = 1000;
    public static boolean isDouableClick() {
        boolean flag = false;
        long curClickTime = System.currentTimeMillis();
        if ((curClickTime - endTime) <= MAX_CLICK_DELAY_TIME) {
            flag = true;
        }
        endTime = curClickTime;
        return flag;
    }
}
