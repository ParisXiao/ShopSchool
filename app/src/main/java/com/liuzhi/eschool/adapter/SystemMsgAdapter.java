package com.liuzhi.eschool.adapter;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.liuzhi.eschool.R;
import com.liuzhi.eschool.entity.SystemMsgEntity;

import java.util.List;

public class SystemMsgAdapter extends BaseQuickAdapter<SystemMsgEntity.DataBean.ResultListBean,BaseViewHolder> {
    private Context context;
    public SystemMsgAdapter(Context context, List<SystemMsgEntity.DataBean.ResultListBean> data) {
        super(R.layout.item_question, data);
        this.context=context;
    }

    @Override
    protected void convert(BaseViewHolder helper, SystemMsgEntity.DataBean.ResultListBean item) {
        if (null == item) return;
//        ImageUtils.setImageBitmapUrl(context,helper.getView(R.id.item_question_icon),item.g);
        TextView name= helper.getView(R.id.item_question_name);
        TextView content= helper.getView(R.id.item_question_release_time);
        TextView send= helper.getView(R.id.item_question_end_time);
        TextView time= helper.getView(R.id.item_question_time);
        if (!item.isCtIsVerify()){
            name.setCompoundDrawables(context.getResources().getDrawable(R.drawable.icon_system_msg),null,null,null);
            name.setTextColor(context.getResources().getColor(R.color.c244E8D));
            content.setTextColor(context.getResources().getColor(R.color.c244E8D));
            send.setTextColor(context.getResources().getColor(R.color.c244E8D));
            time.setTextColor(context.getResources().getColor(R.color.c244E8D));
        }else {
            name.setCompoundDrawables(context.getResources().getDrawable(R.drawable.icon_system_msg_p),null,null,null);
            name.setTextColor(context.getResources().getColor(R.color.c787878));
            content.setTextColor(context.getResources().getColor(R.color.c787878));
            send.setTextColor(context.getResources().getColor(R.color.c787878));
            time.setTextColor(context.getResources().getColor(R.color.c787878));
        }

        name.setText("  "+item.getCtName());
        content.setText(item.getCtContent());
        send.setText("来自："+item.getCtSenderName());
        time.setVisibility(View.VISIBLE);
        time.setText("发送时间："+item.getCtCreateTime());
    }
}
