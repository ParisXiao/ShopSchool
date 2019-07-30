package com.liuzhi.eschool.entity;

import java.util.List;

public class ClassSearchEntity {

    /**
     * pageSize : 20
     * totalRows : 1
     * pageNo : 1
     * resultList : [{"lsId":"601141517284806656","lsName":"微积分","lsDscb":"微积分（Calculus）是高等数学中研究函数的微分(Differentiation)、积分(Integration)以及有关概念和应用的数学分支。它是数学的一个基础学科。内容主要包括极限、微分学、积分学及其应用。微分学包括求导数的运算，是一套关于变化率的理论。它使得函数、速度、加速度和曲线的斜率等均可用一套通用的符号进行讨论。积分学，包括求积分的运算，为定义和计算面积、体积等提供一套通用的方法","lsFirstType":"1","lsFirstTypeName":"数学","lsSecType":"2","lsSecTypeName":"微积分","lsUsuType":"601127142067015680","lsUsuTypeName":"基础","lsCreateTime":"2019-01-11 11:36:41.0","lsCreateUId":"20181248699","lsCreateUName":"admin","lsEditTime":"2019-04-22 14:06:23.0","lsEditUId":"20181342745","lsEditUName":"guanli","lsImg":"/static/upload//lesson/img/1555913183928.jpg","lsIsFirstTppe":true,"lsIsLink":false,"lsLink":"","lsIsHot":true,"lsClickCount":31}]
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
         * lsId : 601141517284806656
         * lsName : 微积分
         * lsDscb : 微积分（Calculus）是高等数学中研究函数的微分(Differentiation)、积分(Integration)以及有关概念和应用的数学分支。它是数学的一个基础学科。内容主要包括极限、微分学、积分学及其应用。微分学包括求导数的运算，是一套关于变化率的理论。它使得函数、速度、加速度和曲线的斜率等均可用一套通用的符号进行讨论。积分学，包括求积分的运算，为定义和计算面积、体积等提供一套通用的方法
         * lsFirstType : 1
         * lsFirstTypeName : 数学
         * lsSecType : 2
         * lsSecTypeName : 微积分
         * lsUsuType : 601127142067015680
         * lsUsuTypeName : 基础
         * lsCreateTime : 2019-01-11 11:36:41.0
         * lsCreateUId : 20181248699
         * lsCreateUName : admin
         * lsEditTime : 2019-04-22 14:06:23.0
         * lsEditUId : 20181342745
         * lsEditUName : guanli
         * lsImg : /static/upload//lesson/img/1555913183928.jpg
         * lsIsFirstTppe : true
         * lsIsLink : false
         * lsLink :
         * lsIsHot : true
         * lsClickCount : 31
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
        private String lsEditTime;
        private String lsEditUId;
        private String lsEditUName;
        private String lsImg;
        private boolean lsIsFirstTppe;
        private boolean lsIsLink;
        private String lsLink;
        private boolean lsIsHot;
        private int lsClickCount;

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

        public String getLsEditTime() {
            return lsEditTime;
        }

        public void setLsEditTime(String lsEditTime) {
            this.lsEditTime = lsEditTime;
        }

        public String getLsEditUId() {
            return lsEditUId;
        }

        public void setLsEditUId(String lsEditUId) {
            this.lsEditUId = lsEditUId;
        }

        public String getLsEditUName() {
            return lsEditUName;
        }

        public void setLsEditUName(String lsEditUName) {
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

        public String getLsLink() {
            return lsLink;
        }

        public void setLsLink(String lsLink) {
            this.lsLink = lsLink;
        }

        public boolean isLsIsHot() {
            return lsIsHot;
        }

        public void setLsIsHot(boolean lsIsHot) {
            this.lsIsHot = lsIsHot;
        }

        public int getLsClickCount() {
            return lsClickCount;
        }

        public void setLsClickCount(int lsClickCount) {
            this.lsClickCount = lsClickCount;
        }
    }
}
