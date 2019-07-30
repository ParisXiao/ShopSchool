package com.liuzhi.eschool.adapter;

import android.content.Context;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.liuzhi.eschool.R;
import com.liuzhi.eschool.entity.ExamiationEntity;

import java.util.List;

public class ExamiationAdapter extends BaseQuickAdapter<ExamiationEntity.ResultListBean,BaseViewHolder> {
    private Context context;
    public ExamiationAdapter(Context context, List<ExamiationEntity.ResultListBean> data) {
        super(R.layout.item_question, data);
        this.context=context;
    }

    @Override
    protected void convert(BaseViewHolder helper, ExamiationEntity.ResultListBean item) {
        if (null == item) return;
//        ImageUtils.setImageBitmapUrl(context,helper.getView(R.id.item_question_icon),item.g);
        helper.setText(R.id.item_question_name,item.getPmName());
        helper.setText(R.id.item_question_release_time,"开始时间："+item.getPmCreateTime());
        helper.setText(R.id.item_question_end_time,"结束时间："+item.getPmCreateTime());
    }
}
