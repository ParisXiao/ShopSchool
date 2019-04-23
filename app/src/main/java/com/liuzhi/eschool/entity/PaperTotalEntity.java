package com.liuzhi.eschool.entity;

import java.util.List;

public class PaperTotalEntity {

    /**
     * pageSize : 3
     * totalRows : 1
     * pageNo : 1
     * resultList : [{"aId":"634120215289925632","pmId":"634116309847642112","qId":"634117633565790208","aAnswer":null,"aUId":"20181342745","aUName":"123213","aUTime":null,"aComment":null,"aTotalPoint":"39.0","aScore":"11.0","aBTime":"2019-04-12 11:32:23.0","stuNumber":"123123","mebName":"文言文","pmName":"文言文考试","mebId":"621425412672589824"}]
     * query : null
     * endIndex : 1
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

    public static class ResultListBean {
        /**
         * aId : 634120215289925632
         * pmId : 634116309847642112
         * qId : 634117633565790208
         * aAnswer : null
         * aUId : 20181342745
         * aUName : 123213
         * aUTime : null
         * aComment : null
         * aTotalPoint : 39.0
         * aScore : 11.0
         * aBTime : 2019-04-12 11:32:23.0
         * stuNumber : 123123
         * mebName : 文言文
         * pmName : 文言文考试
         * mebId : 621425412672589824
         */

        private String aId;
        private String pmId;
        private String qId;
        private Object aAnswer;
        private String aUId;
        private String aUName;
        private Object aUTime;
        private Object aComment;
        private String aTotalPoint;
        private String aScore;
        private String aBTime;
        private String stuNumber;
        private String mebName;
        private String pmName;
        private String mebId;

        public String getAId() {
            return aId;
        }

        public void setAId(String aId) {
            this.aId = aId;
        }

        public String getPmId() {
            return pmId;
        }

        public void setPmId(String pmId) {
            this.pmId = pmId;
        }

        public String getQId() {
            return qId;
        }

        public void setQId(String qId) {
            this.qId = qId;
        }

        public Object getAAnswer() {
            return aAnswer;
        }

        public void setAAnswer(Object aAnswer) {
            this.aAnswer = aAnswer;
        }

        public String getAUId() {
            return aUId;
        }

        public void setAUId(String aUId) {
            this.aUId = aUId;
        }

        public String getAUName() {
            return aUName;
        }

        public void setAUName(String aUName) {
            this.aUName = aUName;
        }

        public Object getAUTime() {
            return aUTime;
        }

        public void setAUTime(Object aUTime) {
            this.aUTime = aUTime;
        }

        public Object getAComment() {
            return aComment;
        }

        public void setAComment(Object aComment) {
            this.aComment = aComment;
        }

        public String getATotalPoint() {
            return aTotalPoint;
        }

        public void setATotalPoint(String aTotalPoint) {
            this.aTotalPoint = aTotalPoint;
        }

        public String getAScore() {
            return aScore;
        }

        public void setAScore(String aScore) {
            this.aScore = aScore;
        }

        public String getABTime() {
            return aBTime;
        }

        public void setABTime(String aBTime) {
            this.aBTime = aBTime;
        }

        public String getStuNumber() {
            return stuNumber;
        }

        public void setStuNumber(String stuNumber) {
            this.stuNumber = stuNumber;
        }

        public String getMebName() {
            return mebName;
        }

        public void setMebName(String mebName) {
            this.mebName = mebName;
        }

        public String getPmName() {
            return pmName;
        }

        public void setPmName(String pmName) {
            this.pmName = pmName;
        }

        public String getMebId() {
            return mebId;
        }

        public void setMebId(String mebId) {
            this.mebId = mebId;
        }
    }
}
