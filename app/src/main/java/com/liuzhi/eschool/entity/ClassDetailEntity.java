package com.liuzhi.eschool.entity;

import java.io.Serializable;
import java.util.List;

public class ClassDetailEntity implements Serializable{

    /**
     * pageSize : 10
     * totalRows : 3
     * pageNo : 1
     * resultList : [{"lsId":"602667488198529024","lsName":"文言文","lsDscb":"","lsFirstType":"600861597014953984","lsFirstTypeName":"中国文学","lsSecType":"601204900096905216","lsSecTypeName":"文言文","lsUsuType":"601127195439534080","lsUsuTypeName":"进阶","lsCreateTime":"2019-01-15 16:40:20.0","lsCreateUId":"20181248699","lsCreateUName":"admin","lsEditTime":null,"lsEditUId":null,"lsEditUName":null,"lsImg":"/static/upload//lesson/img/1548233268070.jpg","lsIsFirstTppe":true,"lsIsLink":false,"lsLink":null},{"lsId":"601204281000857600","lsName":"阅读","lsDscb":"","lsFirstType":"600861597014953984","lsFirstTypeName":"中国文学","lsSecType":"601204868429910016","lsSecTypeName":"阅读理解","lsUsuType":"601127195439534080","lsUsuTypeName":"进阶","lsCreateTime":"2019-01-11 15:46:05.0","lsCreateUId":"20181248699","lsCreateUName":"admin","lsEditTime":"2019-01-11 16:13:53.0","lsEditUId":"20181248699","lsEditUName":"admin","lsImg":"/static/upload//lesson/img/1548233268070.jpg","lsIsFirstTppe":true,"lsIsLink":false,"lsLink":null},{"lsId":"601141990867865600","lsName":"读书有感","lsDscb":"读书","lsFirstType":"600861597014953984","lsFirstTypeName":"中国文学","lsSecType":"600866880307073024","lsSecTypeName":"应用文写作","lsUsuType":"601127195439534080","lsUsuTypeName":"进阶","lsCreateTime":"2019-01-11 11:38:34.0","lsCreateUId":"20181248699","lsCreateUName":"admin","lsEditTime":"2019-01-11 13:21:02.0","lsEditUId":"20181248699","lsEditUName":"admin","lsImg":"/static/upload//lesson/img/1548233268070.jpg","lsIsFirstTppe":true,"lsIsLink":false,"lsLink":null}]
     * query : null
     * endIndex : 3
     * totalPages : 1
     * offset : 0
     */

    private int pageSize;
    private int totalRows;
    private int pageNo;
    private Object query;
    private int endIndex;
    private int totalPages;
    private int offset;
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

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public List<ResultListBean> getResultList() {
        return resultList;
    }

    public void setResultList(List<ResultListBean> resultList) {
        this.resultList = resultList;
    }

    public static class ResultListBean implements Serializable {
        /**
         * lsId : 602667488198529024
         * lsName : 文言文
         * lsDscb :
         * lsFirstType : 600861597014953984
         * lsFirstTypeName : 中国文学
         * lsSecType : 601204900096905216
         * lsSecTypeName : 文言文
         * lsUsuType : 601127195439534080
         * lsUsuTypeName : 进阶
         * lsCreateTime : 2019-01-15 16:40:20.0
         * lsCreateUId : 20181248699
         * lsCreateUName : admin
         * lsEditTime : null
         * lsEditUId : null
         * lsEditUName : null
         * lsImg : /static/upload//lesson/img/1548233268070.jpg
         * lsIsFirstTppe : true
         * lsIsLink : false
         * lsLink : null
         */

        private String lsId;
        private String lsName;
        private String lsDscb;
        private String lsFirstType;
        private String lsFirstTypeName;
        private String lsSecType;
        private String lsSecTypeName;
        private String lsUsuType;
        private String lsUsuTypeName;
        private String lsCreateTime;
        private String lsCreateUId;
        private String lsCreateUName;
        private Object lsEditTime;
        private Object lsEditUId;
        private Object lsEditUName;
        private String lsImg;
        private boolean lsIsFirstTppe;
        private boolean lsIsLink;
        private Object lsLink;

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

        public String getLsDscb() {
            return lsDscb;
        }

        public void setLsDscb(String lsDscb) {
            this.lsDscb = lsDscb;
        }

        public String getLsFirstType() {
            return lsFirstType;
        }

        public void setLsFirstType(String lsFirstType) {
            this.lsFirstType = lsFirstType;
        }

        public String getLsFirstTypeName() {
            return lsFirstTypeName;
        }

        public void setLsFirstTypeName(String lsFirstTypeName) {
            this.lsFirstTypeName = lsFirstTypeName;
        }

        public String getLsSecType() {
            return lsSecType;
        }

        public void setLsSecType(String lsSecType) {
            this.lsSecType = lsSecType;
        }

        public String getLsSecTypeName() {
            return lsSecTypeName;
        }

        public void setLsSecTypeName(String lsSecTypeName) {
            this.lsSecTypeName = lsSecTypeName;
        }

        public String getLsUsuType() {
            return lsUsuType;
        }

        public void setLsUsuType(String lsUsuType) {
            this.lsUsuType = lsUsuType;
        }

        public String getLsUsuTypeName() {
            return lsUsuTypeName;
        }

        public void setLsUsuTypeName(String lsUsuTypeName) {
            this.lsUsuTypeName = lsUsuTypeName;
        }

        public String getLsCreateTime() {
            return lsCreateTime;
        }

        public void setLsCreateTime(String lsCreateTime) {
            this.lsCreateTime = lsCreateTime;
        }

        public String getLsCreateUId() {
            return lsCreateUId;
        }

        public void setLsCreateUId(String lsCreateUId) {
            this.lsCreateUId = lsCreateUId;
        }

        public String getLsCreateUName() {
            return lsCreateUName;
        }

        public void setLsCreateUName(String lsCreateUName) {
            this.lsCreateUName = lsCreateUName;
        }

        public Object getLsEditTime() {
            return lsEditTime;
        }

        public void setLsEditTime(Object lsEditTime) {
            this.lsEditTime = lsEditTime;
        }

        public Object getLsEditUId() {
            return lsEditUId;
        }

        public void setLsEditUId(Object lsEditUId) {
            this.lsEditUId = lsEditUId;
        }

        public Object getLsEditUName() {
            return lsEditUName;
        }

        public void setLsEditUName(Object lsEditUName) {
            this.lsEditUName = lsEditUName;
        }

        public String getLsImg() {
            return lsImg;
        }

        public void setLsImg(String lsImg) {
            this.lsImg = lsImg;
        }

        public boolean isLsIsFirstTppe() {
            return lsIsFirstTppe;
        }

        public void setLsIsFirstTppe(boolean lsIsFirstTppe) {
            this.lsIsFirstTppe = lsIsFirstTppe;
        }

        public boolean isLsIsLink() {
            return lsIsLink;
        }

        public void setLsIsLink(boolean lsIsLink) {
            this.lsIsLink = lsIsLink;
        }

        public Object getLsLink() {
            return lsLink;
        }

        public void setLsLink(Object lsLink) {
            this.lsLink = lsLink;
        }
    }
}
