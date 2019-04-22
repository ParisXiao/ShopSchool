package com.liuzhi.eschool.entity;

import java.util.List;

public class DisGroupEntity {

    /**
     * pageSize : 10
     * totalRows : 1
     * pageNo : 1
     * resultList : [{"psId":"625876864073732096","uId":"20181342745","uName":"管理员411","psName":"去问问群二","psContent":"驱蚊器翁无群二","psIsComment":false,"psCommentId":null,"psIsVerify":true,"psCreateTime":"2019-03-20 17:46:07","psEditTime":"2019-03-20 21:32:23","psEditUId":"600852611096141344","psEditUName":"管理员411"}]
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
         * psId : 625876864073732096
         * uId : 20181342745
         * uName : 管理员411
         * psName : 去问问群二
         * psContent : 驱蚊器翁无群二
         * psIsComment : false
         * psCommentId : null
         * psIsVerify : true
         * psCreateTime : 2019-03-20 17:46:07
         * psEditTime : 2019-03-20 21:32:23
         * psEditUId : 600852611096141344
         * psEditUName : 管理员411
         */

        private String psId;
        private String uId;
        private String uName;
        private String psName;
        private String psContent;
        private boolean psIsComment;
        private Object psCommentId;
        private boolean psIsVerify;
        private String psCreateTime;
        private String psEditTime;
        private String psEditUId;
        private String psEditUName;

        public String getPsId() {
            return psId;
        }

        public void setPsId(String psId) {
            this.psId = psId;
        }

        public String getUId() {
            return uId;
        }

        public void setUId(String uId) {
            this.uId = uId;
        }

        public String getUName() {
            return uName;
        }

        public void setUName(String uName) {
            this.uName = uName;
        }

        public String getPsName() {
            return psName;
        }

        public void setPsName(String psName) {
            this.psName = psName;
        }

        public String getPsContent() {
            return psContent;
        }

        public void setPsContent(String psContent) {
            this.psContent = psContent;
        }

        public boolean isPsIsComment() {
            return psIsComment;
        }

        public void setPsIsComment(boolean psIsComment) {
            this.psIsComment = psIsComment;
        }

        public Object getPsCommentId() {
            return psCommentId;
        }

        public void setPsCommentId(Object psCommentId) {
            this.psCommentId = psCommentId;
        }

        public boolean isPsIsVerify() {
            return psIsVerify;
        }

        public void setPsIsVerify(boolean psIsVerify) {
            this.psIsVerify = psIsVerify;
        }

        public String getPsCreateTime() {
            return psCreateTime;
        }

        public void setPsCreateTime(String psCreateTime) {
            this.psCreateTime = psCreateTime;
        }

        public String getPsEditTime() {
            return psEditTime;
        }

        public void setPsEditTime(String psEditTime) {
            this.psEditTime = psEditTime;
        }

        public String getPsEditUId() {
            return psEditUId;
        }

        public void setPsEditUId(String psEditUId) {
            this.psEditUId = psEditUId;
        }

        public String getPsEditUName() {
            return psEditUName;
        }

        public void setPsEditUName(String psEditUName) {
            this.psEditUName = psEditUName;
        }
    }
}
