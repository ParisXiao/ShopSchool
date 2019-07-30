package com.liuzhi.eschool.adapter;

import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.liuzhi.eschool.R;
import com.liuzhi.eschool.constants.UrlConstans;
import com.liuzhi.eschool.entity.AllProjectEntity;
import com.liuzhi.eschool.utils.common.DateUtil;
import com.liuzhi.eschool.utils.common.ImageUtils;

import java.util.List;

public class ProjectListAdapter extends BaseQuickAdapter<AllProjectEntity.DataBean,BaseViewHolder> {
    private Context context;
    public ProjectListAdapter(Context context, List<AllProjectEntity.DataBean> data) {
        super(R.layout.item_project, data);
        this.context=context;
    }

    @Override
    protected void convert(BaseViewHolder helper,AllProjectEntity.DataBean item) {
        if (null == item) return;
        ImageView projectImg=helper.getView(R.id.item_project_img);
        TextView projectName=helper.getView(R.id.item_project_name);
        TextView projectXueke=helper.getView(R.id.item_project_xueke);
        TextView projectTime=helper.getView(R.id.item_project_time);
        TextView projectMsg=helper.getView(R.id.item_project_msg);
        projectName.setText(item.getColName());
        projectXueke.setText("上传者："+item.getColUpdateName());
        projectMsg.setText(item.getColDesc());
        projectTime.setText(DateUtil.getYM(item.getColCreateTime()));
        ImageUtils.setImageBitmapUrl(context,projectImg,UrlConstans.Companion.getBaseUrl()+item.getColImg());
    }
}
