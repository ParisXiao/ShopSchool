package com.liuzhi.eschool.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.liuzhi.eschool.R;
import com.liuzhi.eschool.constants.UrlConstans;
import com.liuzhi.eschool.entity.ClassSearchEntity;
import com.liuzhi.eschool.entity.HomeSearchEntity;
import com.liuzhi.eschool.utils.common.DateUtil;
import com.liuzhi.eschool.utils.common.ImageUtils;

import java.util.List;

public class ClassSearchAdapter extends BaseQuickAdapter<ClassSearchEntity.ResultListBean, BaseViewHolder> {
    private Context context;

    public ClassSearchAdapter(Context context, List<ClassSearchEntity.ResultListBean> data) {
        super(R.layout.item_search, data);
        this.context = context;
    }

    @Override
    protected void convert(BaseViewHolder helper, ClassSearchEntity.ResultListBean item) {
        if (null == item) return;
        ImageView projectImg = helper.getView(R.id.item_project_img);
        TextView projectName = helper.getView(R.id.item_project_name);
        TextView projectXueke = helper.getView(R.id.item_project_xueke);
        TextView projectTime = helper.getView(R.id.item_project_time);
        TextView projectMsg = helper.getView(R.id.item_project_msg);
        projectTime.setText(DateUtil.getYM(item.getLsCreateTime()));
        ImageUtils.setImageBitmapUrl(context, projectImg, UrlConstans.Companion.getBaseUrl() + item.getLsImg());
        projectName.setText(item.getLsName());
        projectXueke.setText(item.getLsFirstTypeName());
        projectMsg.setText(item.getLsDscb());
    }
}
