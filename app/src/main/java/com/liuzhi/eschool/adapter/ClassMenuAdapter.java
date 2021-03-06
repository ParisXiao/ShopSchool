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
        void itemOnclick(String id,String className,String classUrl);
    }
    public void setItemOnclickInter(ItemOnclickInter itemOnclickInter){
        this.itemOnclickInter=itemOnclickInter;
    }
    @Override
    protected void convert(final BaseViewHolder helper, MultiItemEntity item) {
        switch (helper.getItemViewType()) {
            case TYPE_LEVEL_0:
                final ChapterEntity chapterEntity = (ChapterEntity) item;

                    if (chapterEntity.getChapterName()!=null) {
                        helper.setText(R.id.item_chapter_name, chapterEntity.getChapterName());
                        if (chapterEntity.isHaveSc()) {
                            helper.setVisible(R.id.item_chapter_img, true);
                        }else {
                            helper.setVisible(R.id.item_chapter_img, false);
                        }
                        helper.itemView.setOnClickListener(new View.OnClickListener() {
                            @Override

                            public void onClick(View v) {
                                    int pos = helper.getAdapterPosition();
                                    if (chapterEntity.isExpanded()) {
                                        collapse(pos);
                                        helper.setImageResource(R.id.item_chapter_img,R.drawable.ic_return_down_blue);
                                    } else {
                                        expand(pos);
                                        helper.setImageResource(R.id.item_chapter_img,R.drawable.ic_return_right_blue);
                                    }

                            }
                        });
                }
                break;
            case TYPE_LEVEL_1:
                final SectionEntity sectionEntity = (SectionEntity) item;
                helper.setText(R.id.item_section_name,sectionEntity.getSectionName());
                helper.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override

                    public void onClick(View v) {
                        Log.e("section",sectionEntity.getSectionName());
                        itemOnclickInter.itemOnclick(sectionEntity.getSectionId(),sectionEntity.getSectionName(),sectionEntity.getClassUrl());
                    }
                });
                break;
        }
    }
}
