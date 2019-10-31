package com.liuzhi.eschool.entity;

import java.util.List;

public class FirstResponseEntity {

    private int code;
    private String msg;
    private DataBean data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        private List<ColumnBean> column;

        public List<ColumnBean> getColumn() {
            return column;
        }

        public void setColumn(List<ColumnBean> column) {
            this.column = column;
        }

        public static class ColumnBean {
            private String colId;
            private String colName;
            private String colCreateTime;
            private Object colEditTime;
            private Object colUpdateId;
            private Object colUpdateName;
            private String colManageId;
            private String colCreateId;
            private String colCreateName;
            private String colManageName;
            private String colNode;
            private int colType;
            private String colSign;
            private boolean colIsNode;
            private boolean colNav;
            private boolean colState;
            private boolean colAudit;
            private int colSort;
            private Object colPage;
            private String colStopTime;
            private String colReleaseTime;
            private String colMenuModel;
            private String colListModel;
            private Object colInfoAlert;
            private String colAuditId;
            private String colAuditName;
            private Object colImg;
            private String colKeyword;
            private int colReadLev;
            private Object colLink;
            private boolean colIsCompany;
            private boolean colAllowInfo;
            private String colDesc;
            private int colNodeLevel;
            private Object remark;
            private Object colOther;
            private Object name;
            private Object children;

            public String getColId() {
                return colId;
            }

            public void setColId(String colId) {
                this.colId = colId;
            }

            public String getColName() {
                return colName;
            }

            public void setColName(String colName) {
                this.colName = colName;
            }

            public String getColCreateTime() {
                return colCreateTime;
            }

            public void setColCreateTime(String colCreateTime) {
                this.colCreateTime = colCreateTime;
            }

            public Object getColEditTime() {
                return colEditTime;
            }

            public void setColEditTime(Object colEditTime) {
                this.colEditTime = colEditTime;
            }

            public Object getColUpdateId() {
                return colUpdateId;
            }

            public void setColUpdateId(Object colUpdateId) {
                this.colUpdateId = colUpdateId;
            }

            public Object getColUpdateName() {
                return colUpdateName;
            }

            public void setColUpdateName(Object colUpdateName) {
                this.colUpdateName = colUpdateName;
            }

            public String getColManageId() {
                return colManageId;
            }

            public void setColManageId(String colManageId) {
                this.colManageId = colManageId;
            }

            public String getColCreateId() {
                return colCreateId;
            }

            public void setColCreateId(String colCreateId) {
                this.colCreateId = colCreateId;
            }

            public String getColCreateName() {
                return colCreateName;
            }

            public void setColCreateName(String colCreateName) {
                this.colCreateName = colCreateName;
            }

            public String getColManageName() {
                return colManageName;
            }

            public void setColManageName(String colManageName) {
                this.colManageName = colManageName;
            }

            public String getColNode() {
                return colNode;
            }

            public void setColNode(String colNode) {
                this.colNode = colNode;
            }

            public int getColType() {
                return colType;
            }

            public void setColType(int colType) {
                this.colType = colType;
            }

            public String getColSign() {
                return colSign;
            }

            public void setColSign(String colSign) {
                this.colSign = colSign;
            }

            public boolean isColIsNode() {
                return colIsNode;
            }

            public void setColIsNode(boolean colIsNode) {
                this.colIsNode = colIsNode;
            }

            public boolean isColNav() {
                return colNav;
            }

            public void setColNav(boolean colNav) {
                this.colNav = colNav;
            }

            public boolean isColState() {
                return colState;
            }

            public void setColState(boolean colState) {
                this.colState = colState;
            }

            public boolean isColAudit() {
                return colAudit;
            }

            public void setColAudit(boolean colAudit) {
                this.colAudit = colAudit;
            }

            public int getColSort() {
                return colSort;
            }

            public void setColSort(int colSort) {
                this.colSort = colSort;
            }

            public Object getColPage() {
                return colPage;
            }

            public void setColPage(Object colPage) {
                this.colPage = colPage;
            }

            public String getColStopTime() {
                return colStopTime;
            }

            public void setColStopTime(String colStopTime) {
                this.colStopTime = colStopTime;
            }

            public String getColReleaseTime() {
                return colReleaseTime;
            }

            public void setColReleaseTime(String colReleaseTime) {
                this.colReleaseTime = colReleaseTime;
            }

            public String getColMenuModel() {
                return colMenuModel;
            }

            public void setColMenuModel(String colMenuModel) {
                this.colMenuModel = colMenuModel;
            }

            public String getColListModel() {
                return colListModel;
            }

            public void setColListModel(String colListModel) {
                this.colListModel = colListModel;
            }

            public Object getColInfoAlert() {
                return colInfoAlert;
            }

            public void setColInfoAlert(Object colInfoAlert) {
                this.colInfoAlert = colInfoAlert;
            }

            public String getColAuditId() {
                return colAuditId;
            }

            public void setColAuditId(String colAuditId) {
                this.colAuditId = colAuditId;
            }

            public String getColAuditName() {
                return colAuditName;
            }

            public void setColAuditName(String colAuditName) {
                this.colAuditName = colAuditName;
            }

            public Object getColImg() {
                return colImg;
            }

            public void setColImg(Object colImg) {
                this.colImg = colImg;
            }

            public String getColKeyword() {
                return colKeyword;
            }

            public void setColKeyword(String colKeyword) {
                this.colKeyword = colKeyword;
            }

            public int getColReadLev() {
                return colReadLev;
            }

            public void setColReadLev(int colReadLev) {
                this.colReadLev = colReadLev;
            }

            public Object getColLink() {
                return colLink;
            }

            public void setColLink(Object colLink) {
                this.colLink = colLink;
            }

            public boolean isColIsCompany() {
                return colIsCompany;
            }

            public void setColIsCompany(boolean colIsCompany) {
                this.colIsCompany = colIsCompany;
            }

            public boolean isColAllowInfo() {
                return colAllowInfo;
            }

            public void setColAllowInfo(boolean colAllowInfo) {
                this.colAllowInfo = colAllowInfo;
            }

            public String getColDesc() {
                return colDesc;
            }

            public void setColDesc(String colDesc) {
                this.colDesc = colDesc;
            }

            public int getColNodeLevel() {
                return colNodeLevel;
            }

            public void setColNodeLevel(int colNodeLevel) {
                this.colNodeLevel = colNodeLevel;
            }

            public Object getRemark() {
                return remark;
            }

            public void setRemark(Object remark) {
                this.remark = remark;
            }

            public Object getColOther() {
                return colOther;
            }

            public void setColOther(Object colOther) {
                this.colOther = colOther;
            }

            public Object getName() {
                return name;
            }

            public void setName(Object name) {
                this.name = name;
            }

            public Object getChildren() {
                return children;
            }

            public void setChildren(Object children) {
                this.children = children;
            }
        }
    }
}
