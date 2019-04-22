package com.liuzhi.eschool.adapter;

import android.util.Log;
import android.view.View;
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.liuzhi.eschool.R;
import com.liuzhi.eschool.entity.ChapterEntity;
import com.liuzhi.eschool.entity.SectionEntity;

import java.util.List;

public class ClassMenuAdapter extends BaseMultiItemQuickAdapter<MultiItemEntity, BaseViewHolder> {
    public static final int TYPE_LEVEL_0 = 0;
    public static final int TYPE_LEVEL_1 = 1;
    private ItemOnclickInter itemOnclickInter;
    /**
     * Same as QuickAdapter#QuickAdapter(Context,int) but with
     * some initialization data.
     *
     * @param data A new list is created out of this one to avoid mutable list
     */
    public ClassMenuAdapter(List<MultiItemEntity> data) {
        super(data);
        addItemType(TYPE_LEVEL_0, R.layout.item_class_chapter);
        addItemType(TYPE_LEVEL_1, R.layout.item_class_section);
    }
    public interface ItemOnclickInter{
        void itemOnclick(String scId);
    }
    public void setItemOnclickInter(ItemOnclickInter itemOnclickInter){
        this.itemOnclickInter=itemOnclickInter;
    }
    @Override
    protected void convert(final BaseViewHolder helper, MultiItemEntity item) {
        switch (helper.getItemViewType()) {
            case TYPE_LEVEL_0:
                final ChapterEntity chapterEntity = (ChapterEntity) item;
                helper.setText(R.id.item_chapter_name,chapterEntity.getChapterName());
                helper.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override

                    public void onClick(View v) {
                        if (chapterEntity.isHaveSc()) {
                            helper.setVisible(R.id.item_chapter_img, true);
                            int pos = helper.getAdapterPosition();
                            if (chapterEntity.isExpanded()) {
                                collapse(pos);
                            } else {
                                expand(pos);
                            }
                        } else {
                            helper.setVisible(R.id.item_chapter_img, false);
                        }

                    }
                });

                break;
            case TYPE_LEVEL_1:
                final SectionEntity sectionEntity = (SectionEntity) item;
                helper.setText(R.id.item_section_name,sectionEntity.getSectionName());
                helper.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override

                    public void onClick(View v) {
                        Log.e("section",sectionEntity.getSectionName());
                        itemOnclickInter.itemOnclick(sectionEntity.getSectionId());
                    }
                });
                break;
        }
    }
}
