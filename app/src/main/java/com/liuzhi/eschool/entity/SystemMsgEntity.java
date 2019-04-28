package com.liuzhi.eschool.entity;

import java.io.Serializable;
import java.util.List;

public class SystemMsgEntity implements Serializable {

    /**
     * code : 0
     * msg : 操作成功
     * data : {"pageSize":10,"totalRows":5,"pageNo":1,"resultList":[{"ctId":"634462296055222275","ctRoomId":"634462296055222276","ctSenderId":"20181342745","ctReceiverId":"20181342745","ctSenderName":"guanli","ctReceiverName":"小李子","ctName":"驱蚊器翁","ctContent":"切尔奇翁群无二群翁","ctCreateTime":"2019-04-13 10:21:34","ctIsVerify":true},{"ctId":"634462296055222272","ctRoomId":"634462296055222274","ctSenderId":"20181342745","ctReceiverId":"20181342745","ctSenderName":"guanli","ctReceiverName":"123123","ctName":"驱蚊器翁","ctContent":"切尔奇翁群无二群翁","ctCreateTime":"2019-04-13 10:21:34","ctIsVerify":true},{"ctId":"634462296051027968","ctRoomId":"634462296055222273","ctSenderId":"20181342745","ctReceiverId":"20181342745","ctSenderName":"guanli","ctReceiverName":"阿斯达所多","ctName":"驱蚊器翁","ctContent":"切尔奇翁群无二群翁","ctCreateTime":"2019-04-13 10:21:34","ctIsVerify":true},{"ctId":"634462296042639360","ctRoomId":"634462296042639361","ctSenderId":"20181342745","ctReceiverId":"20181342745","ctSenderName":"guanli","ctReceiverName":"老王","ctName":"驱蚊器翁","ctContent":"切尔奇翁群无二群翁","ctCreateTime":"2019-04-13 10:21:34","ctIsVerify":true},{"ctId":"634462296038445058","ctRoomId":"634462296038445059","ctSenderId":"20181342745","ctReceiverId":"20181342745","ctSenderName":"guanli","ctReceiverName":"小程","ctName":"驱蚊器翁","ctContent":"切尔奇翁群无二群翁","ctCreateTime":"2019-04-13 10:21:34","ctIsVerify":true}],"query":null,"endIndex":5,"totalPages":1,"offset":0}
     */

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
        /**
         * pageSize : 10
         * totalRows : 5
         * pageNo : 1
         * resultList : [{"ctId":"634462296055222275","ctRoomId":"634462296055222276","ctSenderId":"20181342745","ctReceiverId":"20181342745","ctSenderName":"guanli","ctReceiverName":"小李子","ctName":"驱蚊器翁","ctContent":"切尔奇翁群无二群翁","ctCreateTime":"2019-04-13 10:21:34","ctIsVerify":true},{"ctId":"634462296055222272","ctRoomId":"634462296055222274","ctSenderId":"20181342745","ctReceiverId":"20181342745","ctSenderName":"guanli","ctReceiverName":"123123","ctName":"驱蚊器翁","ctContent":"切尔奇翁群无二群翁","ctCreateTime":"2019-04-13 10:21:34","ctIsVerify":true},{"ctId":"634462296051027968","ctRoomId":"634462296055222273","ctSenderId":"20181342745","ctReceiverId":"20181342745","ctSenderName":"guanli","ctReceiverName":"阿斯达所多","ctName":"驱蚊器翁","ctContent":"切尔奇翁群无二群翁","ctCreateTime":"2019-04-13 10:21:34","ctIsVerify":true},{"ctId":"634462296042639360","ctRoomId":"634462296042639361","ctSenderId":"20181342745","ctReceiverId":"20181342745","ctSenderName":"guanli","ctReceiverName":"老王","ctName":"驱蚊器翁","ctContent":"切尔奇翁群无二群翁","ctCreateTime":"2019-04-13 10:21:34","ctIsVerify":true},{"ctId":"634462296038445058","ctRoomId":"634462296038445059","ctSenderId":"20181342745","ctReceiverId":"20181342745","ctSenderName":"guanli","ctReceiverName":"小程","ctName":"驱蚊器翁","ctContent":"切尔奇翁群无二群翁","ctCreateTime":"2019-04-13 10:21:34","ctIsVerify":true}]
         * query : null
         * endIndex : 5
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
             * ctId : 634462296055222275
             * ctRoomId : 634462296055222276
             * ctSenderId : 20181342745
             * ctReceiverId : 20181342745
             * ctSenderName : guanli
             * ctReceiverName : 小李子
             * ctName : 驱蚊器翁
             * ctContent : 切尔奇翁群无二群翁
             * ctCreateTime : 2019-04-13 10:21:34
             * ctIsVerify : true
             */

            private String ctId;
            private String ctRoomId;
            private String ctSenderId;
            private String ctReceiverId;
            private String ctSenderName;
            private String ctReceiverName;
            private String ctName;
            private String ctContent;
            private String ctCreateTime;
            private boolean ctIsVerify;

            public String getCtId() {
                return ctId;
            }

            public void setCtId(String ctId) {
                this.ctId = ctId;
            }

            public String getCtRoomId() {
                return ctRoomId;
            }

            public void setCtRoomId(String ctRoomId) {
                this.ctRoomId = ctRoomId;
            }

            public String getCtSenderId() {
                return ctSenderId;
            }

            public void setCtSenderId(String ctSenderId) {
                this.ctSenderId = ctSenderId;
            }

            public String getCtReceiverId() {
                return ctReceiverId;
            }

            public void setCtReceiverId(String ctReceiverId) {
                this.ctReceiverId = ctReceiverId;
            }

            public String getCtSenderName() {
                return ctSenderName;
            }

            public void setCtSenderName(String ctSenderName) {
                this.ctSenderName = ctSenderName;
            }

            public String getCtReceiverName() {
                return ctReceiverName;
            }

            public void setCtReceiverName(String ctReceiverName) {
                this.ctReceiverName = ctReceiverName;
            }

            public String getCtName() {
                return ctName;
            }

            public void setCtName(String ctName) {
                this.ctName = ctName;
            }

            public String getCtContent() {
                return ctContent;
            }

            public void setCtContent(String ctContent) {
                this.ctContent = ctContent;
            }

            public String getCtCreateTime() {
                return ctCreateTime;
            }

            public void setCtCreateTime(String ctCreateTime) {
                this.ctCreateTime = ctCreateTime;
            }

            public boolean isCtIsVerify() {
                return ctIsVerify;
            }

            public void setCtIsVerify(boolean ctIsVerify) {
                this.ctIsVerify = ctIsVerify;
            }
        }
    }
}
