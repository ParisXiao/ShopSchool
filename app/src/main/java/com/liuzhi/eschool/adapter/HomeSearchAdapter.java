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
import com.liuzhi.eschool.entity.AllProjectEntity;
import com.liuzhi.eschool.entity.HomeSearchEntity;
import com.liuzhi.eschool.utils.common.DateUtil;
import com.liuzhi.eschool.utils.common.ImageUtils;

import java.util.List;

public class HomeSearchAdapter extends BaseQuickAdapter<HomeSearchEntity.ResultListBean,BaseViewHolder> {
    private Context context;
    public HomeSearchAdapter(Context context, List<HomeSearchEntity.ResultListBean> data) {
        super(R.layout.item_search, data);
        this.context=context;
    }

    @Override
    protected void convert(BaseViewHolder helper,HomeSearchEntity.ResultListBean item) {
        if (null == item) return;
        boolean b=item.getLsName()!=null&&!TextUtils.isEmpty(item.getLsName())?true:false;
        ImageView projectImg=helper.getView(R.id.item_project_img);
        TextView projectName=helper.getView(R.id.item_project_name);
        TextView projectXueke=helper.getView(R.id.item_project_xueke);
        TextView projectTime=helper.getView(R.id.item_project_time);
        TextView projectMsg=helper.getView(R.id.item_project_msg);
        if (b) {
            projectName.setText(item.getLsName());
            projectMsg.setText(item.getLsDscb());
            projectXueke.setVisibility(View.GONE);
            projectImg.setVisibility(View.GONE);
            projectTime.setVisibility(View.GONE);
        }else {
            projectTime.setText(DateUtil.getYM(item.getIfCreateTime()));
            ImageUtils.setImageBitmapUrl(context,projectImg,UrlConstans.Companion.getBaseUrl()+item.getIfImg());
            projectName.setText(item.getIfName());
            projectXueke.setText(item.getColName());
            projectMsg.setText(item.getIfSubhead());
        }



    }
}
