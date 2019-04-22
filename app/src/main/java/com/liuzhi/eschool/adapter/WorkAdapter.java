package com.liuzhi.eschool.adapter;

import android.content.Context;
import android.view.View;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.liuzhi.eschool.R;
import com.liuzhi.eschool.entity.WorkingEntity;

import java.util.List;

public class WorkAdapter extends BaseQuickAdapter<WorkingEntity.ResultListBean,BaseViewHolder> {
    private Context context;
    public WorkAdapter(Context context, List<WorkingEntity.ResultListBean> data) {
        super(R.layout.item_question, data);
        this.context=context;
    }

    @Override
    protected void convert(BaseViewHolder helper, WorkingEntity.ResultListBean item) {
        if (null == item) return;
//        ImageUtils.setImageBitmapUrl(context,helper.getView(R.id.item_question_icon),item.g);
        helper.setText(R.id.item_question_name,item.getCwName());
        helper.setText(R.id.item_question_release_time,"作业简介："+item.getCwContent());
        helper.setText(R.id.item_question_end_time,"发布时间："+item.getCwCreateTime());
        helper.setText(R.id.item_question_time,"最晚完成时间："+item.getCwDue());
        helper.getView(R.id.item_question_time).setVisibility(View.VISIBLE);

    }
}
