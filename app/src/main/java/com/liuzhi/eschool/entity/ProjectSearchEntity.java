package com.liuzhi.eschool.entity;

import java.util.List;

public class ProjectSearchEntity {

    /**
     * pageSize : 20
     * totalRows : 1
     * pageNo : 1
     * resultList : [{"colId":"630859153606184960","colName":"商务谈判","colCreateTime":"2019-04-03 11:43:57.0","colEditTime":"2019-04-03 16:06:56.0","colUpdateId":"20181248699","colUpdateName":"admin","colManageId":"","colCreateId":"20181342745","colCreateName":"学科竞赛","colManageName":"","colNode":"630857371081510912","colType":7,"colSign":"SWTP","colIsNode":true,"colNav":false,"colState":true,"colAudit":false,"colSort":0,"colPage":null,"colStopTime":"2099-12-31 00:00:00.0","colReleaseTime":"2019-04-02 00:00:00.0","colMenuModel":"630587944628916224","colListModel":"630587709030666240","colInfoAlert":null,"colAuditId":"","colAuditName":"","colImg":"/static/upload//column/1554263037731.jpg","colKeyword":"","colReadLev":1,"colLink":null,"colIsCompany":false,"colAllowInfo":true,"colDesc":" ","colNodeLevel":1,"remark":null,"colOther":null,"name":null,"children":null}]
     * query : null
     * offset : 0
     * endIndex : 1
     * totalPages : 1
     */

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

    public static class ResultListBean {
        /**
         * colId : 630859153606184960
         * colName : 商务谈判
         * colCreateTime : 2019-04-03 11:43:57.0
         * colEditTime : 2019-04-03 16:06:56.0
         * colUpdateId : 20181248699
         * colUpdateName : admin
         * colManageId :
         * colCreateId : 20181342745
         * colCreateName : 学科竞赛
         * colManageName :
         * colNode : 630857371081510912
         * colType : 7
         * colSign : SWTP
         * colIsNode : true
         * colNav : false
         * colState : true
         * colAudit : false
         * colSort : 0
         * colPage : null
         * colStopTime : 2099-12-31 00:00:00.0
         * colReleaseTime : 2019-04-02 00:00:00.0
         * colMenuModel : 630587944628916224
         * colListModel : 630587709030666240
         * colInfoAlert : null
         * colAuditId :
         * colAuditName :
         * colImg : /static/upload//column/1554263037731.jpg
         * colKeyword :
         * colReadLev : 1
         * colLink : null
         * colIsCompany : false
         * colAllowInfo : true
         * colDesc :
         * colNodeLevel : 1
         * remark : null
         * colOther : null
         * name : null
         * children : null
         */

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
}
