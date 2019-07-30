package com.liuzhi.eschool.entity;

import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.liuzhi.eschool.adapter.ClassMenuAdapter;

public class SectionEntity implements MultiItemEntity {
    private String sectionId;
    private String sectionName;
    private String classUrl;

    public String getClassUrl() {
        return classUrl;
    }

    public void setClassUrl(String classUrl) {
        this.classUrl = classUrl;
    }

    public String getSectionId() {
        return sectionId;
    }

    public void setSectionId(String sectionId) {
        this.sectionId = sectionId;
    }

    public String getSectionName() {
        return sectionName;
    }

    public void setSectionName(String sectionName) {
        this.sectionName = sectionName;
    }

    @Override
    public int getItemType() {
        return ClassMenuAdapter.TYPE_LEVEL_1;
    }
}
