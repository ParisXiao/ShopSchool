package com.liuzhi.eschool.entity;

import java.util.List;

public class MyCourseEntity {

    /**
     * pageSize : 10
     * totalRows : 1
     * pageNo : 1
     * resultList : [{"styId":633849098021113900,"lsId":601141517284806700,"lsName":"微积分","styUId":20181342745,"styCreateTime":1554975896000,"styFinishTime":null,"styStatus":null,"styPg":null}]
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
         * styId : 633849098021113900
         * lsId : 601141517284806700
         * lsName : 微积分
         * styUId : 20181342745
         * styCreateTime : 1554975896000
         * styFinishTime : null
         * styStatus : null
         * styPg : null
         */

        private long styId;
        private long lsId;
        private String lsName;
        private long styUId;
        private long styCreateTime;
        private Object styFinishTime;
        private Object styStatus;
        private Object styPg;

        public long getStyId() {
            return styId;
        }

        public void setStyId(long styId) {
            this.styId = styId;
        }

        public long getLsId() {
            return lsId;
        }

        public void setLsId(long lsId) {
            this.lsId = lsId;
        }

        public String getLsName() {
            return lsName;
        }

        public void setLsName(String lsName) {
            this.lsName = lsName;
        }

        public long getStyUId() {
            return styUId;
        }

        public void setStyUId(long styUId) {
            this.styUId = styUId;
        }

        public long getStyCreateTime() {
            return styCreateTime;
        }

        public void setStyCreateTime(long styCreateTime) {
            this.styCreateTime = styCreateTime;
        }

        public Object getStyFinishTime() {
            return styFinishTime;
        }

        public void setStyFinishTime(Object styFinishTime) {
            this.styFinishTime = styFinishTime;
        }

        public Object getStyStatus() {
            return styStatus;
        }

        public void setStyStatus(Object styStatus) {
            this.styStatus = styStatus;
        }

        public Object getStyPg() {
            return styPg;
        }

        public void setStyPg(Object styPg) {
            this.styPg = styPg;
        }
    }
}
