package com.liuzhi.eschool.entity;

import java.util.List;

public class WorkingEntity {

    /**
     * pageSize : 12
     * totalRows : 1
     * pageNo : 1
     * resultList : [{"cwId":"633807585266372608","cwName":"驱蚊器翁无群二","cwContent":"阿斯达所大所多","cwScore":16,"clId":null,"cwCreateTime":"2019-04-11 14:59:59","cwCreateUId":"20181342745","cwCreateUName":"guanli","cwEditTime":"2019-04-11 15:58:26","cwEditUId":"20181342745","cwEditUName":"guanli","cwEditTimes":1,"cwDue":"2222-02-22 22:22:00","avgScore":null}]
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
         * cwId : 633807585266372608
         * cwName : 驱蚊器翁无群二
         * cwContent : 阿斯达所大所多
         * cwScore : 16
         * clId : null
         * cwCreateTime : 2019-04-11 14:59:59
         * cwCreateUId : 20181342745
         * cwCreateUName : guanli
         * cwEditTime : 2019-04-11 15:58:26
         * cwEditUId : 20181342745
         * cwEditUName : guanli
         * cwEditTimes : 1
         * cwDue : 2222-02-22 22:22:00
         * avgScore : null
         */

        private String cwId;
        private String cwName;
        private String cwContent;
        private int cwScore;
        private Object clId;
        private String cwCreateTime;
        private String cwCreateUId;
        private String cwCreateUName;
        private String cwEditTime;
        private String cwEditUId;
        private String cwEditUName;
        private int cwEditTimes;
        private String cwDue;
        private Object avgScore;

        public String getCwId() {
            return cwId;
        }

        public void setCwId(String cwId) {
            this.cwId = cwId;
        }

        public String getCwName() {
            return cwName;
        }

        public void setCwName(String cwName) {
            this.cwName = cwName;
        }

        public String getCwContent() {
            return cwContent;
        }

        public void setCwContent(String cwContent) {
            this.cwContent = cwContent;
        }

        public int getCwScore() {
            return cwScore;
        }

        public void setCwScore(int cwScore) {
            this.cwScore = cwScore;
        }

        public Object getClId() {
            return clId;
        }

        public void setClId(Object clId) {
            this.clId = clId;
        }

        public String getCwCreateTime() {
            return cwCreateTime;
        }

        public void setCwCreateTime(String cwCreateTime) {
            this.cwCreateTime = cwCreateTime;
        }

        public String getCwCreateUId() {
            return cwCreateUId;
        }

        public void setCwCreateUId(String cwCreateUId) {
            this.cwCreateUId = cwCreateUId;
        }

        public String getCwCreateUName() {
            return cwCreateUName;
        }

        public void setCwCreateUName(String cwCreateUName) {
            this.cwCreateUName = cwCreateUName;
        }

        public String getCwEditTime() {
            return cwEditTime;
        }

        public void setCwEditTime(String cwEditTime) {
            this.cwEditTime = cwEditTime;
        }

        public String getCwEditUId() {
            return cwEditUId;
        }

        public void setCwEditUId(String cwEditUId) {
            this.cwEditUId = cwEditUId;
        }

        public String getCwEditUName() {
            return cwEditUName;
        }

        public void setCwEditUName(String cwEditUName) {
            this.cwEditUName = cwEditUName;
        }

        public int getCwEditTimes() {
            return cwEditTimes;
        }

        public void setCwEditTimes(int cwEditTimes) {
            this.cwEditTimes = cwEditTimes;
        }

        public String getCwDue() {
            return cwDue;
        }

        public void setCwDue(String cwDue) {
            this.cwDue = cwDue;
        }

        public Object getAvgScore() {
            return avgScore;
        }

        public void setAvgScore(Object avgScore) {
            this.avgScore = avgScore;
        }
    }
}
