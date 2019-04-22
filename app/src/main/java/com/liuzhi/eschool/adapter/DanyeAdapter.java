package com.liuzhi.eschool.adapter;

import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.liuzhi.eschool.R;
import com.liuzhi.eschool.constants.UrlConstans;
import com.liuzhi.eschool.entity.ProjectInfoByEntity;
import com.liuzhi.eschool.utils.common.ImageUtils;

import java.util.List;

public class DanyeAdapter extends BaseQuickAdapter<ProjectInfoByEntity.ResultListBean,BaseViewHolder> {
    private Context context;
    public DanyeAdapter(Context context, List<ProjectInfoByEntity.ResultListBean> data) {
        super(R.layout.item_danye, data);
        this.context=context;
    }

    @Override
    protected void convert(BaseViewHolder helper,ProjectInfoByEntity.ResultListBean item) {
        if (null == item) return;
        ImageView danyeImg=helper.getView(R.id.item_danye_img);
        TextView danyeName=helper.getView(R.id.item_danye_text);
        String name="";
        if (item.getIfName().contains("-")){
            name=item.getIfName().substring(0,item.getIfName().indexOf("-"));
        }else {
            name=item.getIfName();
        }
        danyeName.setText(name);
        ImageUtils.setImageBitmapUrl(context,danyeImg,UrlConstans.Companion.getBaseUrl()+item.getIfImg());
    }
}
