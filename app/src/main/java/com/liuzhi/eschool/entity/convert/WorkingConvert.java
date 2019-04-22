package com.liuzhi.eschool.entity.convert;


import android.text.TextUtils;
import android.util.Log;
import com.liuzhi.eschool.entity.WorkingEntity;
import com.liuzhi.eschool.gjson.AppConsds;
import com.liuzhi.eschool.utils.common.JsonUtils;
import com.lzy.okgo.convert.Converter;
import okhttp3.Response;
import okhttp3.ResponseBody;

/**
 * Created by YANGLIN on 2018/5/10.
 */

public class WorkingConvert implements Converter<WorkingEntity> {

    @Override
    public WorkingEntity convertResponse(Response response) throws Throwable {
        ResponseBody body = response.body();
        if (body == null) return null;
        String data =  body.string();
        Log.e("result","data ===> "+data);
        if (TextUtils.isEmpty(data) || !JsonUtils.getInstance().isJsonObj(data))
            return null;
        return AppConsds.mGson.fromJson(data,WorkingEntity.class);
    }
}
