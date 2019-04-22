package com.liuzhi.eschool.entity;

import java.util.List;

public class ClassTimeEntity {

    /**
     * pageSize : 10
     * totalRows : 3
     * pageNo : 1
     * resultList : [{"schId":"631206684630454272","clId":"601133903981318144","schBeginTime":"2019-04-02 00:00:00.0","schFinishTime":"2019-04-25 00:00:00.0","schCreateUId":null,"schCreateUName":"admin","schCreateTime":"2019-04-04 10:44:55.0","schEditUId":null,"schEditUName":null,"schEditTime":null},{"schId":"625535602774773760","clId":"601133903981318144","schBeginTime":"2019-03-30 00:00:00.0","schFinishTime":"2019-03-21 00:00:00.0","schCreateUId":null,"schCreateUName":"/static/upload/schedule/1553053417932.pdf","schCreateTime":"2019-03-19 19:10:04.0","schEditUId":null,"schEditUName":null,"schEditTime":null},{"schId":"625828151959752704","clId":"601133903981318144","schBeginTime":"1111-11-11 00:00:00.0","schFinishTime":"1111-11-11 00:00:00.0","schCreateUId":null,"schCreateUName":"/static/upload/schedule/1553063601116.pdf","schCreateTime":"2019-03-20 14:32:33.0","schEditUId":null,"schEditUName":null,"schEditTime":null}]
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

    public static class ResultListBean {
        /**
         * schId : 631206684630454272
         * clId : 601133903981318144
         * schBeginTime : 2019-04-02 00:00:00.0
         * schFinishTime : 2019-04-25 00:00:00.0
         * schCreateUId : null
         * schCreateUName : admin
         * schCreateTime : 2019-04-04 10:44:55.0
         * schEditUId : null
         * schEditUName : null
         * schEditTime : null
         */

        private String schId;
        private String clId;
        private String schBeginTime;
        private String schFinishTime;
        private Object schCreateUId;
        private String schCreateUName;
        private String schCreateTime;
        private Object schEditUId;
        private Object schEditUName;
        private Object schEditTime;

        public String getSchId() {
            return schId;
        }

        public void setSchId(String schId) {
            this.schId = schId;
        }

        public String getClId() {
            return clId;
        }

        public void setClId(String clId) {
            this.clId = clId;
        }

        public String getSchBeginTime() {
            return schBeginTime;
        }

        public void setSchBeginTime(String schBeginTime) {
            this.schBeginTime = schBeginTime;
        }

        public String getSchFinishTime() {
            return schFinishTime;
        }

        public void setSchFinishTime(String schFinishTime) {
            this.schFinishTime = schFinishTime;
        }

        public Object getSchCreateUId() {
            return schCreateUId;
        }

        public void setSchCreateUId(Object schCreateUId) {
            this.schCreateUId = schCreateUId;
        }

        public String getSchCreateUName() {
            return schCreateUName;
        }

        public void setSchCreateUName(String schCreateUName) {
            this.schCreateUName = schCreateUName;
        }

        public String getSchCreateTime() {
            return schCreateTime;
        }

        public void setSchCreateTime(String schCreateTime) {
            this.schCreateTime = schCreateTime;
        }

        public Object getSchEditUId() {
            return schEditUId;
        }

        public void setSchEditUId(Object schEditUId) {
            this.schEditUId = schEditUId;
        }

        public Object getSchEditUName() {
            return schEditUName;
        }

        public void setSchEditUName(Object schEditUName) {
            this.schEditUName = schEditUName;
        }

        public Object getSchEditTime() {
            return schEditTime;
        }

        public void setSchEditTime(Object schEditTime) {
            this.schEditTime = schEditTime;
        }
    }
}
