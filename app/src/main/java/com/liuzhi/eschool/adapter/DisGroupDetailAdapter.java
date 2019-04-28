package com.liuzhi.eschool.adapter;

import android.content.Context;
import android.view.View;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.liuzhi.eschool.R;
import com.liuzhi.eschool.constants.UserInfoConstans;
import com.liuzhi.eschool.entity.DisGroupDetailEntity;
import com.liuzhi.eschool.entity.DisGroupEntity;

import java.util.List;

public class DisGroupDetailAdapter extends BaseQuickAdapter<DisGroupDetailEntity.DataBean.ResultListBean,BaseViewHolder> {
    private Context context;
    public DisGroupDetailAdapter(Context context, List<DisGroupDetailEntity.DataBean.ResultListBean> data) {
        super(R.layout.item_disgroup, data);
        this.context=context;
    }

    @Override
    protected void convert(BaseViewHolder helper, DisGroupDetailEntity.DataBean.ResultListBean item) {
        if (null == item) return;
//        ImageUtils.setImageBitmapUrl(context,helper.getView(R.id.item_question_icon),item.g);
        if (UserInfoConstans.USERNAME.equals(item.getUName())){
            helper.getView(R.id.item_group_other).setVisibility(View.GONE);
            helper.setText(R.id.item_group_me_name,item.getUName());
            helper.setText(R.id.item_group_me_time,item.getPsEditTime());
            helper.setText(R.id.item_group_me_content,item.getPsContent());
        }else {
            helper.getView(R.id.item_group_me).setVisibility(View.GONE);
            helper.setText(R.id.item_group_other_name,item.getUName());
            helper.setText(R.id.item_group_other_time,item.getPsEditTime());
            helper.setText(R.id.item_group_other_content,item.getPsContent());
        }
    }
}
