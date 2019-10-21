package com.liuzhi.eschool.entity;

import java.io.Serializable;
import java.util.List;

public class ProjectDetailByIdEntity implements Serializable {

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

    public static class DataBean implements Serializable {
        private LeftMenuHeadBean leftMenuHead;
        private List<NewsBean> news;
        private List<LocationBean> location;
        private List<LeftMenuBean> leftMenu;
        private List<InfoBeanX> info;

        public LeftMenuHeadBean getLeftMenuHead() {
            return leftMenuHead;
        }

        public void setLeftMenuHead(LeftMenuHeadBean leftMenuHead) {
            this.leftMenuHead = leftMenuHead;
        }

        public List<NewsBean> getNews() {
            return news;
        }

        public void setNews(List<NewsBean> news) {
            this.news = news;
        }

        public List<LocationBean> getLocation() {
            return location;
        }

        public void setLocation(List<LocationBean> location) {
            this.location = location;
        }

        public List<LeftMenuBean> getLeftMenu() {
            return leftMenu;
        }

        public void setLeftMenu(List<LeftMenuBean> leftMenu) {
            this.leftMenu = leftMenu;
        }

        public List<InfoBeanX> getInfo() {
            return info;
        }

        public void setInfo(List<InfoBeanX> info) {
            this.info = info;
        }

        public static class LeftMenuHeadBean implements Serializable {
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

        public static class NewsBean implements Serializable  {
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
            private Object ifEditTime;
            private Object ifEditUId;
            private Object ifEditUName;
            private boolean ifNeedVerify;
            private String ifImg;
            private Object ifRecommend;
            private Object ifHeadline;
            private Object ifLinehead;
            private Object stoId;
            private Object stoName;
            private Object stoAllId;
            private String ifCreateName;
            private String ifLink;
            private String ifKeyword;
            private Object ifDesc;
            private String remark;
            private Object ifContent;
            private Object lsId;
            private Object lsName;
            private Object lsCreateTime;
            private Object lsDscb;

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

            public Object getIfEditTime() {
                return ifEditTime;
            }

            public void setIfEditTime(Object ifEditTime) {
                this.ifEditTime = ifEditTime;
            }

            public Object getIfEditUId() {
                return ifEditUId;
            }

            public void setIfEditUId(Object ifEditUId) {
                this.ifEditUId = ifEditUId;
            }

            public Object getIfEditUName() {
                return ifEditUName;
            }

            public void setIfEditUName(Object ifEditUName) {
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

            public Object getIfRecommend() {
                return ifRecommend;
            }

            public void setIfRecommend(Object ifRecommend) {
                this.ifRecommend = ifRecommend;
            }

            public Object getIfHeadline() {
                return ifHeadline;
            }

            public void setIfHeadline(Object ifHeadline) {
                this.ifHeadline = ifHeadline;
            }

            public Object getIfLinehead() {
                return ifLinehead;
            }

            public void setIfLinehead(Object ifLinehead) {
                this.ifLinehead = ifLinehead;
            }

            public Object getStoId() {
                return stoId;
            }

            public void setStoId(Object stoId) {
                this.stoId = stoId;
            }

            public Object getStoName() {
                return stoName;
            }

            public void setStoName(Object stoName) {
                this.stoName = stoName;
            }

            public Object getStoAllId() {
                return stoAllId;
            }

            public void setStoAllId(Object stoAllId) {
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

            public Object getIfDesc() {
                return ifDesc;
            }

            public void setIfDesc(Object ifDesc) {
                this.ifDesc = ifDesc;
            }

            public String getRemark() {
                return remark;
            }

            public void setRemark(String remark) {
                this.remark = remark;
            }

            public Object getIfContent() {
                return ifContent;
            }

            public void setIfContent(Object ifContent) {
                this.ifContent = ifContent;
            }

            public Object getLsId() {
                return lsId;
            }

            public void setLsId(Object lsId) {
                this.lsId = lsId;
            }

            public Object getLsName() {
                return lsName;
            }

            public void setLsName(Object lsName) {
                this.lsName = lsName;
            }

            public Object getLsCreateTime() {
                return lsCreateTime;
            }

            public void setLsCreateTime(Object lsCreateTime) {
                this.lsCreateTime = lsCreateTime;
            }

            public Object getLsDscb() {
                return lsDscb;
            }

            public void setLsDscb(Object lsDscb) {
                this.lsDscb = lsDscb;
            }
        }

        public static class LocationBean  implements Serializable {
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

        public static class LeftMenuBean implements Serializable  {
            private String colId;
            private String colName;
            private String colCreateTime;
            private Object colEditTime;
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
            private Object colPage;
            private String colStopTime;
            private String colReleaseTime;
            private String colMenuModel;
            private String colListModel;
            private Object colInfoAlert;
            private String colAuditId;
            private String colAuditName;
            private String colImg;
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

        public static class InfoBeanX implements Serializable {
            private ColumnBean column;
            private long colId;
            private int type;
            private InfoBean info;

            public ColumnBean getColumn() {
                return column;
            }

            public void setColumn(ColumnBean column) {
                this.column = column;
            }

            public long getColId() {
                return colId;
            }

            public void setColId(long colId) {
                this.colId = colId;
            }

            public int getType() {
                return type;
            }

            public void setType(int type) {
                this.type = type;
            }

            public InfoBean getInfo() {
                return info;
            }

            public void setInfo(InfoBean info) {
                this.info = info;
            }

            public static class ColumnBean implements  Serializable{
                private String colId;
                private String colName;
                private String colCreateTime;
                private Object colEditTime;
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

            public static class InfoBean  implements Serializable{
                private int pageSize;
                private int totalRows;
                private int pageNo;
                private Object query;
                private int offset;
                private int endIndex;
                private int totalPages;
                private List<ResultListBean> resultList;

                public int getPageSize() {
                    return pageSize;
                }

                public void setPageSize(int pageSize) {
                    this.pageSize = pageSize;
                }

                public int getTotalRows() {
                    return totalRows;
                }

                public void setTotalRows(int totalRows) {
                    this.totalRows = totalRows;
                }

                public int getPageNo() {
                    return pageNo;
                }

                public void setPageNo(int pageNo) {
                    this.pageNo = pageNo;
                }

                public Object getQuery() {
                    return query;
                }

                public void setQuery(Object query) {
                    this.query = query;
                }

                public int getOffset() {
                    return offset;
                }

                public void setOffset(int offset) {
                    this.offset = offset;
                }

                public int getEndIndex() {
                    return endIndex;
                }

                public void setEndIndex(int endIndex) {
                    this.endIndex = endIndex;
                }

                public int getTotalPages() {
                    return totalPages;
                }

                public void setTotalPages(int totalPages) {
                    this.totalPages = totalPages;
                }

                public List<ResultListBean> getResultList() {
                    return resultList;
                }

                public void setResultList(List<ResultListBean> resultList) {
                    this.resultList = resultList;
                }

                public static class ResultListBean  implements Serializable{
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
                    private Object ifEditTime;
                    private Object ifEditUId;
                    private Object ifEditUName;
                    private boolean ifNeedVerify;
                    private String ifImg;
                    private Object ifRecommend;
                    private Object ifHeadline;
                    private Object ifLinehead;
                    private Object stoId;
                    private Object stoName;
                    private Object stoAllId;
                    private String ifCreateName;
                    private String ifLink;
                    private String ifKeyword;
                    private Object ifDesc;
                    private Object remark;
                    private String ifContent;
                    private Object lsId;
                    private Object lsName;
                    private Object lsCreateTime;
                    private Object lsDscb;

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

                    public Object getIfEditTime() {
                        return ifEditTime;
                    }

                    public void setIfEditTime(Object ifEditTime) {
                        this.ifEditTime = ifEditTime;
                    }

                    public Object getIfEditUId() {
                        return ifEditUId;
                    }

                    public void setIfEditUId(Object ifEditUId) {
                        this.ifEditUId = ifEditUId;
                    }

                    public Object getIfEditUName() {
                        return ifEditUName;
                    }

                    public void setIfEditUName(Object ifEditUName) {
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

                    public Object getIfRecommend() {
                        return ifRecommend;
                    }

                    public void setIfRecommend(Object ifRecommend) {
                        this.ifRecommend = ifRecommend;
                    }

                    public Object getIfHeadline() {
                        return ifHeadline;
                    }

                    public void setIfHeadline(Object ifHeadline) {
                        this.ifHeadline = ifHeadline;
                    }

                    public Object getIfLinehead() {
                        return ifLinehead;
                    }

                    public void setIfLinehead(Object ifLinehead) {
                        this.ifLinehead = ifLinehead;
                    }

                    public Object getStoId() {
                        return stoId;
                    }

                    public void setStoId(Object stoId) {
                        this.stoId = stoId;
                    }

                    public Object getStoName() {
                        return stoName;
                    }

                    public void setStoName(Object stoName) {
                        this.stoName = stoName;
                    }

                    public Object getStoAllId() {
                        return stoAllId;
                    }

                    public void setStoAllId(Object stoAllId) {
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

                    public Object getIfDesc() {
                        return ifDesc;
                    }

                    public void setIfDesc(Object ifDesc) {
                        this.ifDesc = ifDesc;
                    }

                    public Object getRemark() {
                        return remark;
                    }

                    public void setRemark(Object remark) {
                        this.remark = remark;
                    }

                    public String getIfContent() {
                        return ifContent;
                    }

                    public void setIfContent(String ifContent) {
                        this.ifContent = ifContent;
                    }

                    public Object getLsId() {
                        return lsId;
                    }

                    public void setLsId(Object lsId) {
                        this.lsId = lsId;
                    }

                    public Object getLsName() {
                        return lsName;
                    }

                    public void setLsName(Object lsName) {
                        this.lsName = lsName;
                    }

                    public Object getLsCreateTime() {
                        return lsCreateTime;
                    }

                    public void setLsCreateTime(Object lsCreateTime) {
                        this.lsCreateTime = lsCreateTime;
                    }

                    public Object getLsDscb() {
                        return lsDscb;
                    }

                    public void setLsDscb(Object lsDscb) {
                        this.lsDscb = lsDscb;
                    }
                }
            }
        }
    }
}
