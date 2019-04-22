package com.liuzhi.eschool.adapter;

import android.content.Context;
import android.text.TextUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.liuzhi.eschool.R;
import com.liuzhi.eschool.entity.CollectionEntity;

import java.util.List;

public class CollectionAdapter extends BaseQuickAdapter<CollectionEntity.DataBean,BaseViewHolder> {
    private Context context;
    public CollectionAdapter(Context context, List<CollectionEntity.DataBean> data) {
        super(R.layout.item_question, data);
        this.context=context;
    }

    @Override
    protected void convert(BaseViewHolder helper, CollectionEntity.DataBean item) {
        if (null == item) return;
//        ImageUtils.setImageBitmapUrl(context,helper.getView(R.id.item_question_icon),item.g);
        String name= TextUtils.isEmpty(item.getLsName())? (String) item.getIfName() :(String)item.getLsName();
        boolean type= item.getCoType()==1? true :false;
        helper.setText(R.id.item_question_name,name);
        helper.setText(R.id.item_question_release_time,"信息类型：" +(type?"课程":"新闻"));
        helper.setText(R.id.item_question_end_time,"收藏时间："+item.getCoTime());
    }
}
