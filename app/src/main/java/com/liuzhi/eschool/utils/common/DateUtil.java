package com.liuzhi.eschool.utils.common;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by Admin on 2017/12/20.
 */

public class DateUtil {

    private static SimpleDateFormat sf=null;
    /*获取系统时间 格式为："yyyy/MM/dd "*/
    public static String getCurrentDate() {
        Date d = new Date();
        sf = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        return sf.format(d);
    }
    /*时间戳转换成字符窜*/
    public static String getDateToString(long time) {
        Date d = new Date(time);
        sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
        return sf.format(d);
    }
    /*时间戳转换成字符窜*/
    public static String getDateToStringHour(long time) {
        Date d = new Date(time);
        sf = new SimpleDateFormat("MM/dd HH:mm", Locale.getDefault());
        return sf.format(d);
    }
    /*将字符串转为时间戳*/
    public static long getStringToDate(String time) {
        sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
        Date date = new Date();
        try {
            date = sf.parse(time);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return date.getTime();
    }
    /*将字符串转为时间戳*/
    public static long getAlarmDate(String time) {
        sf = new SimpleDateFormat("yyyy-MM-ddTHH:mm:ss", Locale.getDefault());
        Date date = new Date();
        try {
            date = sf.parse(time);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return date.getTime();
    }
    //获得年月
    public static String getYM(String time){
        long ltime=getStringToDate(time);
        Date d = new Date(ltime);
        sf = new SimpleDateFormat("yyyy.MM", Locale.getDefault());
        return sf.format(d);
    }
    //获得年月日
    public static String getYMD(String time){
        long ltime=getStringToDate(time);
        Date d = new Date(ltime);
        sf = new SimpleDateFormat("yyyy.MM.dd", Locale.getDefault());
        return sf.format(d);
    }
    //获得年
    public static String getYear(long time){
        Date d = new Date(time);
        sf = new SimpleDateFormat("yyyy", Locale.getDefault());
        return sf.format(d);
    }
    //获得月
    public static String getMouth(long time){
        Date d = new Date(time);
        sf = new SimpleDateFormat("MM", Locale.getDefault());
        return sf.format(d);
    }
}
