package com.liuzhi.eschool.entity;

import java.util.List;

public class SecondResponseEntity {

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
        private List<InfoBean> info;

        public List<ColumnBean> getColumn() {
            return column;
        }

        public void setColumn(List<ColumnBean> column) {
            this.column = column;
        }

        public List<InfoBean> getInfo() {
            return info;
        }

        public void setInfo(List<InfoBean> info) {
            this.info = info;
        }

        public static class ColumnBean {
            private String colId;
            private String colName;
            private String colCreateTime;
            private String colEditTime;
            private String colUpdateId;
            private String colUpdateName;
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
            private String colPage;
            private String colStopTime;
            private String colReleaseTime;
            private String colMenuModel;
            private String colListModel;
            private String colInfoAlert;
            private String colAuditId;
            private String colAuditName;
            private String colImg;
            private String colKeyword;
            private int colReadLev;
            private String colLink;
            private boolean colIsCompany;
            private boolean colAllowInfo;
            private String colDesc;
            private int colNodeLevel;
            private String remark;
            private String colOther;
            private String name;
            private String children;

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

            public String getColEditTime() {
                return colEditTime;
            }

            public void setColEditTime(String colEditTime) {
                this.colEditTime = colEditTime;
            }

            public String getColUpdateId() {
                return colUpdateId;
            }

            public void setColUpdateId(String colUpdateId) {
                this.colUpdateId = colUpdateId;
            }

            public String getColUpdateName() {
                return colUpdateName;
            }

            public void setColUpdateName(String colUpdateName) {
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

            public String getColPage() {
                return colPage;
            }

            public void setColPage(String colPage) {
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

            public String getColInfoAlert() {
                return colInfoAlert;
            }

            public void setColInfoAlert(String colInfoAlert) {
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

            public String getColImg() {
                return colImg;
            }

            public void setColImg(String colImg) {
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

            public String getColLink() {
                return colLink;
            }

            public void setColLink(String colLink) {
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

            public String getRemark() {
                return remark;
            }

            public void setRemark(String remark) {
                this.remark = remark;
            }

            public String getColOther() {
                return colOther;
            }

            public void setColOther(String colOther) {
                this.colOther = colOther;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getChildren() {
                return children;
            }

            public void setChildren(String children) {
                this.children = children;
            }
        }

        public static class InfoBean {
            private String ifId;
            private String ifSubhead;
            private String ifName;
            private String ifRsce;
            private String colId;
            private String colAllId;
            private String colName;
            private String ifCreateTime;
            private String ifStopTime;
            private String ifReleaseTime;
            private String ifCreateUId;
            private String ifCreateUName;
            private String ifEditTime;
            private String ifEditUId;
            private String ifEditUName;
            private boolean ifNeedVerify;
            private String ifImg;
            private String ifRecommend;
            private String ifHeadline;
            private String ifLinehead;
            private String stoId;
            private String stoName;
            private String stoAllId;
            private String ifCreateName;
            private String ifLink;
            private String ifKeyword;
            private String ifDesc;
            private String remark;
            private String ifContent;
            private String lsId;
            private String lsName;
            private String lsCreateTime;
            private String lsDscb;

            public String getIfId() {
                return ifId;
            }

            public void setIfId(String ifId) {
                this.ifId = ifId;
            }

            public String getIfSubhead() {
                return ifSubhead;
            }

            public void setIfSubhead(String ifSubhead) {
                this.ifSubhead = ifSubhead;
            }

            public String getIfName() {
                return ifName;
            }

            public void setIfName(String ifName) {
                this.ifName = ifName;
            }

            public String getIfRsce() {
                return ifRsce;
            }

            public void setIfRsce(String ifRsce) {
                this.ifRsce = ifRsce;
            }

            public String getColId() {
                return colId;
            }

            public void setColId(String colId) {
                this.colId = colId;
            }

            public String getColAllId() {
                return colAllId;
            }

            public void setColAllId(String colAllId) {
                this.colAllId = colAllId;
            }

            public String getColName() {
                return colName;
            }

            public void setColName(String colName) {
                this.colName = colName;
            }

            public String getIfCreateTime() {
                return ifCreateTime;
            }

            public void setIfCreateTime(String ifCreateTime) {
                this.ifCreateTime = ifCreateTime;
            }

            public String getIfStopTime() {
                return ifStopTime;
            }

            public void setIfStopTime(String ifStopTime) {
                this.ifStopTime = ifStopTime;
            }

            public String getIfReleaseTime() {
                return ifReleaseTime;
            }

            public void setIfReleaseTime(String ifReleaseTime) {
                this.ifReleaseTime = ifReleaseTime;
            }

            public String getIfCreateUId() {
                return ifCreateUId;
            }

            public void setIfCreateUId(String ifCreateUId) {
                this.ifCreateUId = ifCreateUId;
            }

            public String getIfCreateUName() {
                return ifCreateUName;
            }

            public void setIfCreateUName(String ifCreateUName) {
                this.ifCreateUName = ifCreateUName;
            }

            public String getIfEditTime() {
                return ifEditTime;
            }

            public void setIfEditTime(String ifEditTime) {
                this.ifEditTime = ifEditTime;
            }

            public String getIfEditUId() {
                return ifEditUId;
            }

            public void setIfEditUId(String ifEditUId) {
                this.ifEditUId = ifEditUId;
            }

            public String getIfEditUName() {
                return ifEditUName;
            }

            public void setIfEditUName(String ifEditUName) {
                this.ifEditUName = ifEditUName;
            }

            public boolean isIfNeedVerify() {
                return ifNeedVerify;
            }

            public void setIfNeedVerify(boolean ifNeedVerify) {
                this.ifNeedVerify = ifNeedVerify;
            }

            public String getIfImg() {
                return ifImg;
            }

            public void setIfImg(String ifImg) {
                this.ifImg = ifImg;
            }

            public String getIfRecommend() {
                return ifRecommend;
            }

            public void setIfRecommend(String ifRecommend) {
                this.ifRecommend = ifRecommend;
            }

            public String getIfHeadline() {
                return ifHeadline;
            }

            public void setIfHeadline(String ifHeadline) {
                this.ifHeadline = ifHeadline;
            }

            public String getIfLinehead() {
                return ifLinehead;
            }

            public void setIfLinehead(String ifLinehead) {
                this.ifLinehead = ifLinehead;
            }

            public String getStoId() {
                return stoId;
            }

            public void setStoId(String stoId) {
                this.stoId = stoId;
            }

            public String getStoName() {
                return stoName;
            }

            public void setStoName(String stoName) {
                this.stoName = stoName;
            }

            public String getStoAllId() {
                return stoAllId;
            }

            public void setStoAllId(String stoAllId) {
                this.stoAllId = stoAllId;
            }

            public String getIfCreateName() {
                return ifCreateName;
            }

            public void setIfCreateName(String ifCreateName) {
                this.ifCreateName = ifCreateName;
            }

            public String getIfLink() {
                return ifLink;
            }

            public void setIfLink(String ifLink) {
                this.ifLink = ifLink;
            }

            public String getIfKeyword() {
                return ifKeyword;
            }

            public void setIfKeyword(String ifKeyword) {
                this.ifKeyword = ifKeyword;
            }

            public String getIfDesc() {
                return ifDesc;
            }

            public void setIfDesc(String ifDesc) {
                this.ifDesc = ifDesc;
            }

            public String getRemark() {
                return remark;
            }

            public void setRemark(String remark) {
                this.remark = remark;
            }

            public String getIfContent() {
                return ifContent;
            }

            public void setIfContent(String ifContent) {
                this.ifContent = ifContent;
            }

            public String getLsId() {
                return lsId;
            }

            public void setLsId(String lsId) {
                this.lsId = lsId;
            }

            public String getLsName() {
                return lsName;
            }

            public void setLsName(String lsName) {
                this.lsName = lsName;
            }

            public String getLsCreateTime() {
                return lsCreateTime;
            }

            public void setLsCreateTime(String lsCreateTime) {
                this.lsCreateTime = lsCreateTime;
            }

            public String getLsDscb() {
                return lsDscb;
            }

            public void setLsDscb(String lsDscb) {
                this.lsDscb = lsDscb;
            }
        }
    }
}
