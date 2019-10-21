package com.liuzhi.eschool.adapter;

import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.liuzhi.eschool.R;
import com.liuzhi.eschool.constants.UrlConstans;
import com.liuzhi.eschool.entity.AllProjectEntity;
import com.liuzhi.eschool.entity.ProjectDetailByIdEntity;
import com.liuzhi.eschool.utils.common.DateUtil;
import com.liuzhi.eschool.utils.common.ImageUtils;

import java.util.List;

public class NewsListAdapter extends BaseQuickAdapter<ProjectDetailByIdEntity.DataBean.InfoBeanX.InfoBean.ResultListBean,BaseViewHolder> {
    private Context context;
    public NewsListAdapter(Context context, List<ProjectDetailByIdEntity.DataBean.InfoBeanX.InfoBean.ResultListBean> data) {
        super(R.layout.item_project, data);
        this.context=context;
    }

    @Override
    protected void convert(BaseViewHolder helper,ProjectDetailByIdEntity.DataBean.InfoBeanX.InfoBean.ResultListBean item) {
        if (null == item) return;
        ImageView projectImg=helper.getView(R.id.item_project_img);
        TextView projectName=helper.getView(R.id.item_project_name);
        TextView projectXueke=helper.getView(R.id.item_project_xueke);
        TextView projectTime=helper.getView(R.id.item_project_time);
        TextView projectMsg=helper.getView(R.id.item_project_msg);
        projectName.setText(item.getIfName());
        projectXueke.setText("上传者："+item.getIfCreateName());
        projectMsg.setText(item.getIfCreateUName());
        projectTime.setText(DateUtil.getYM(item.getIfReleaseTime()));
        ImageUtils.setImageBitmapUrl(context,projectImg,UrlConstans.Companion.getBaseUrl()+item.getIfImg());
    }
}
