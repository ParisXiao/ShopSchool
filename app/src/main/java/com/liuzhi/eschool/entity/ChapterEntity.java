package com.liuzhi.eschool.entity;

import com.chad.library.adapter.base.entity.AbstractExpandableItem;
import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.liuzhi.eschool.adapter.ClassMenuAdapter;

public class ChapterEntity  extends AbstractExpandableItem<SectionEntity> implements MultiItemEntity {
    private String chapterId;
    private String chapterName;
    private boolean isHaveSc;

    public boolean isHaveSc() {
        return isHaveSc;
    }

    public void setHaveSc(boolean haveSc) {
        isHaveSc = haveSc;
    }

    public String getChapterId() {
        return chapterId;
    }

    public void setChapterId(String chapterId) {
        this.chapterId = chapterId;
    }

    public String getChapterName() {
        return chapterName;
    }

    public void setChapterName(String chapterName) {
        this.chapterName = chapterName;
    }

    @Override
    public int getLevel() {
        return 0;
    }

    @Override
    public int getItemType() {
        return ClassMenuAdapter.TYPE_LEVEL_0;
    }
}
