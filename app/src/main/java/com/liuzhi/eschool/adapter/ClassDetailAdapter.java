package com.liuzhi.eschool.adapter;

import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.liuzhi.eschool.R;
import com.liuzhi.eschool.constants.UrlConstans;
import com.liuzhi.eschool.entity.ClassDetailEntity;
import com.liuzhi.eschool.utils.common.ImageUtils;

import java.util.List;

public class ClassDetailAdapter extends BaseQuickAdapter<ClassDetailEntity.ResultListBean,BaseViewHolder> {
    private Context context;
    public ClassDetailAdapter(Context context, List<ClassDetailEntity.ResultListBean> data) {
        super(R.layout.item_class_detail, data);
        this.context=context;
    }

    @Override
    protected void convert(BaseViewHolder helper,ClassDetailEntity.ResultListBean item) {
        if (null == item) return;
        ImageView classImg=helper.getView(R.id.item_class_detail_img);
        TextView className=helper.getView(R.id.item_class_detail_text);
        className.setText(item.getLsName());
        ImageUtils.setImageBitmapUrl(context,classImg,UrlConstans.Companion.getBaseUrl()+item.getLsImg());
    }
}
