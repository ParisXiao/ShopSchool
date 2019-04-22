package com.liuzhi.eschool.entity;

import java.io.Serializable;
import java.util.List;

public class QuestionEntity  implements Serializable {

    /**
     * pageSize : 10
     * totalRows : 1
     * pageNo : 1
     * resultList : [{"qnId":"603365569676185600","qnName":"大学生消费情况调查","qnContent":"QRAFASFWERasdsdadasd","qnCreateTime":"2019-01-17 14:54:17","qnCreateUId":"20181342745","qnCreateUName":"杜康","qnEditTime":null,"qnEditUId":null,"qnEditUName":null,"qnIsClosed":false}]
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

    public static class ResultListBean implements Serializable{
        /**
         * qnId : 603365569676185600
         * qnName : 大学生消费情况调查
         * qnContent : QRAFASFWERasdsdadasd
         * qnCreateTime : 2019-01-17 14:54:17
         * qnCreateUId : 20181342745
         * qnCreateUName : 杜康
         * qnEditTime : null
         * qnEditUId : null
         * qnEditUName : null
         * qnIsClosed : false
         */

        private String qnId;
        private String qnName;
        private String qnContent;
        private String qnCreateTime;
        private String qnCreateUId;
        private String qnCreateUName;
        private Object qnEditTime;
        private Object qnEditUId;
        private Object qnEditUName;
        private boolean qnIsClosed;

        public String getQnId() {
            return qnId;
        }

        public void setQnId(String qnId) {
            this.qnId = qnId;
        }

        public String getQnName() {
            return qnName;
        }

        public void setQnName(String qnName) {
            this.qnName = qnName;
        }

        public String getQnContent() {
            return qnContent;
        }

        public void setQnContent(String qnContent) {
            this.qnContent = qnContent;
        }

        public String getQnCreateTime() {
            return qnCreateTime;
        }

        public void setQnCreateTime(String qnCreateTime) {
            this.qnCreateTime = qnCreateTime;
        }

        public String getQnCreateUId() {
            return qnCreateUId;
        }

        public void setQnCreateUId(String qnCreateUId) {
            this.qnCreateUId = qnCreateUId;
        }

        public String getQnCreateUName() {
            return qnCreateUName;
        }

        public void setQnCreateUName(String qnCreateUName) {
            this.qnCreateUName = qnCreateUName;
        }

        public Object getQnEditTime() {
            return qnEditTime;
        }

        public void setQnEditTime(Object qnEditTime) {
            this.qnEditTime = qnEditTime;
        }

        public Object getQnEditUId() {
            return qnEditUId;
        }

        public void setQnEditUId(Object qnEditUId) {
            this.qnEditUId = qnEditUId;
        }

        public Object getQnEditUName() {
            return qnEditUName;
        }

        public void setQnEditUName(Object qnEditUName) {
            this.qnEditUName = qnEditUName;
        }

        public boolean isQnIsClosed() {
            return qnIsClosed;
        }

        public void setQnIsClosed(boolean qnIsClosed) {
            this.qnIsClosed = qnIsClosed;
        }
    }
}
