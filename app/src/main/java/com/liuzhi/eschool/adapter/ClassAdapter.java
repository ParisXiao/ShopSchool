package com.liuzhi.eschool.adapter;

import android.content.Context;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.liuzhi.eschool.R;
import com.liuzhi.eschool.entity.ClassEntity;

import java.util.List;

public class ClassAdapter extends BaseQuickAdapter<ClassEntity.DataBean,BaseViewHolder> {
    private Context context;
    public ClassAdapter(Context context,List<ClassEntity.DataBean> data) {
        super(R.layout.item_class, data);
        this.context=context;
    }

    @Override
    protected void convert(BaseViewHolder helper, ClassEntity.DataBean item) {
        if (null == item) return;
        TextView className=helper.getView(R.id.class_name);
        View choosedLine=helper.getView(R.id.choosed_line);
        RelativeLayout itemBg=helper.getView(R.id.class_bg);
        className.setText(item.getTpName());
        if (item.isTpIsChoosed()){
            choosedLine.setVisibility(View.VISIBLE);
            itemBg.setBackgroundColor(context.getResources().getColor(R.color.white));
        }else {
            choosedLine.setVisibility(View.GONE);
            itemBg.setBackgroundColor(context.getResources().getColor(R.color.cF6F6F6));
        }
    }
}
