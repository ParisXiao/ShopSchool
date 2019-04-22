package com.liuzhi.eschool.adapter;

import android.content.Context;
import android.text.TextUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.liuzhi.eschool.R;
import com.liuzhi.eschool.entity.HistoryEntity;

import java.util.List;

public class HistoryAdapter extends BaseQuickAdapter<HistoryEntity.DataBean,BaseViewHolder> {
    private Context context;
    public HistoryAdapter(Context context, List<HistoryEntity.DataBean> data) {
        super(R.layout.item_question, data);
        this.context=context;
    }

    @Override
    protected void convert(BaseViewHolder helper, HistoryEntity.DataBean item) {
        if (null == item) return;
//        ImageUtils.setImageBitmapUrl(context,helper.getView(R.id.item_question_icon),item.g);
        String name= TextUtils.isEmpty(item.getLsName())? (String) item.getIfName() :(String)item.getLsName();
        boolean type= TextUtils.isEmpty(item.getLsName())? true :false;
        helper.setText(R.id.item_question_name,name);
        helper.setText(R.id.item_question_release_time,"信息类型：" +(type?"资讯":"课程"));
        helper.setText(R.id.item_question_end_time,"浏览时间："+item.getHTime());
    }
}
