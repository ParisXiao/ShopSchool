package com.liuzhi.eschool.entity;

import java.util.List;

public class TabTitleEntity {
    private String titleName;
    private int dataSize;
    private int tabId;
    private boolean isRed;
    private List<Object> entitys;

    public List<Object> getEntitys() {
        return entitys;
    }

    public void setEntitys(List<Object> entitys) {
        this.entitys = entitys;
    }

    public int getTabId() {
        return tabId;
    }

    public void setTabId(int tabId) {
        this.tabId = tabId;
    }

    public String getTitleName() {
        return titleName;
    }

    public void setTitleName(String titleName) {
        this.titleName = titleName;
    }

    public int getDataSize() {
        return dataSize;
    }

    public void setDataSize(int dataSize) {
        this.dataSize = dataSize;
    }

    public boolean isRed() {
        return isRed;
    }

    public void setRed(boolean red) {
        isRed = red;
    }
}
