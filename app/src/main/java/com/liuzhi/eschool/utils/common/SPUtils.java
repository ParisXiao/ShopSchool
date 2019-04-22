package com.liuzhi.eschool.utils.common;


import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import android.util.Log;

/**
 *  SharedPreferences 通用工具
 * @author CHENXINXU
 * */
public class SPUtils {
	/** 存储名 */
	private static final String SHAREDNAME = "SCHOOLSHOP";

	public static SPUtils getInstance(){return Instance.mSPUtils;}
	private static class Instance{
		static final SPUtils mSPUtils = new SPUtils();
	}

	/** 通用存入 除去 set<String> */
	public <T> void set(Context context, String key,T value){
		if (null == context || TextUtils.isEmpty(key))
			return;
		SharedPreferences settings = context.getApplicationContext().getSharedPreferences(SHAREDNAME, 0);
		Editor editor = settings.edit();
		if (value instanceof String) {
			editor.putString(key, (String)value);
		}else if(value instanceof Boolean){
			editor.putBoolean(key, (Boolean)value);
		}else if(value instanceof Integer){
			editor.putInt(key, (Integer)value);
		}else if (value instanceof Float){
			editor.putFloat(key, (Float)value);
		}else if(value instanceof Long){
			editor.putLong(key, (Long)value);
		}else if(value instanceof Double){
			editor.putString(key, value+"");
		}else {
			Log.e("result", "value 类型不对!");
			return;
		}
		editor.commit();
	}
	/** 清除所有数据  */
	public void clearShare(Context context){
		if (null == context)
			return;
		SharedPreferences settings = context.getApplicationContext().getSharedPreferences(SHAREDNAME, 0);
		Editor editor = settings.edit();
		editor.clear();
		editor.commit();
	}
	/** 移除一个 */
	public void remove(Context context, String key){
		if (null == context || TextUtils.isEmpty(key))
			return;
		SharedPreferences settings = context.getApplicationContext().getSharedPreferences(SHAREDNAME, 0);
		Editor editor = settings.edit();
		editor.remove(key).commit();
	}
	/** 通用读取数据 */
	public Object getObject(Context context, String key){
		if (null == context)
			return null;
		SharedPreferences settings = context.getApplicationContext().getSharedPreferences(SHAREDNAME, 0);
		return settings.getAll().get(key);
	}
	/** 通用读取String数据 */
	public String getString(Context context, String key){
		if (null == context || TextUtils.isEmpty(key))
			return "";
		SharedPreferences settings = context.getApplicationContext().getSharedPreferences(SHAREDNAME, 0);
		return settings.getString(key, "");
	}
	/** 通用读取Double数据 */
	public double getDouble(Context context, String key){
		if (null == context || TextUtils.isEmpty(key))
			return 0;
		SharedPreferences settings = context.getApplicationContext().getSharedPreferences(SHAREDNAME, 0);
		double value = 0d;
		String sv = settings.getString(key, "");
		if(null == sv || sv.length() == 0)
			return value;
		try {
			value = Double.parseDouble(sv);
		} catch (Exception e) {}
		return value;
	}
	/** 通用读取boolean数据 */
	public boolean getBoolean(Context context, String key){
		if (null == context || TextUtils.isEmpty(key))
			return false;
		SharedPreferences settings = context.getApplicationContext().getSharedPreferences(SHAREDNAME, 0);
		return settings.getBoolean(key, false);
	}
	/** 通用读取float数据 */
	public double getFloat(Context context, String key){
		if (null == context || TextUtils.isEmpty(key))
			return 0f;
		SharedPreferences settings = context.getApplicationContext().getSharedPreferences(SHAREDNAME, 0);
		return settings.getFloat(key, 0f);
	}
}
