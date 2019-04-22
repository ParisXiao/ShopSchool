package com.liuzhi.eschool.adapter;

import android.content.Context;
import android.view.View;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.liuzhi.eschool.R;
import com.liuzhi.eschool.entity.ClassTimeEntity;
import com.liuzhi.eschool.utils.common.DateUtil;

import java.util.List;

public class ClassTimeAdapter extends BaseQuickAdapter<ClassTimeEntity.ResultListBean,BaseViewHolder> {
    private Context context;
    public ClassTimeAdapter(Context context, List<ClassTimeEntity.ResultListBean> data) {
        super(R.layout.item_question, data);
        this.context=context;
    }

    @Override
    protected void convert(BaseViewHolder helper, ClassTimeEntity.ResultListBean item) {
        if (null == item) return;
//        ImageUtils.setImageBitmapUrl(context,helper.getView(R.id.item_question_icon),item.g);
        helper.setText(R.id.item_question_name,"执行开始时间："+DateUtil.getYMD(item.getSchBeginTime()));
        helper.setText(R.id.item_question_release_time,"结束时间："+DateUtil.getYMD(item.getSchFinishTime()));
        helper.getView(R.id.item_question_end_time).setVisibility(View.GONE);
    }
}
