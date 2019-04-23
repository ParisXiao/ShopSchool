package com.liuzhi.eschool.adapter;

import android.content.Context;
import android.view.View;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.liuzhi.eschool.R;
import com.liuzhi.eschool.entity.PaperTotalEntity;
import com.liuzhi.eschool.entity.WorkingEntity;

import java.util.List;

public class PaperAdapter extends BaseQuickAdapter<PaperTotalEntity.ResultListBean,BaseViewHolder> {
    private Context context;
    public PaperAdapter(Context context, List<PaperTotalEntity.ResultListBean> data) {
        super(R.layout.item_question, data);
        this.context=context;
    }

    @Override
    protected void convert(BaseViewHolder helper, PaperTotalEntity.ResultListBean item) {
        if (null == item) return;
//        ImageUtils.setImageBitmapUrl(context,helper.getView(R.id.item_question_icon),item.g);
        helper.setText(R.id.item_question_name,item.getPmName());
        helper.setText(R.id.item_question_release_time,"试卷类型："+item.getMebName());
        helper.setText(R.id.item_question_end_time,"总分："+item.getATotalPoint());
        helper.setText(R.id.item_question_time,"考试时间："+item.getABTime());
        helper.getView(R.id.item_question_time).setVisibility(View.VISIBLE);

    }
}
