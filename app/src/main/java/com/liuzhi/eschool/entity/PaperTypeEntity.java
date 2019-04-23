package com.liuzhi.eschool.entity;

import java.util.List;

public class PaperTypeEntity {

    /**
     * code : 0
     * msg : 操作成功
     * data : [{"ptId":"621425308926480384","ptName":"文学","ptCreateTime":"2019-03-08 10:57:13.0","ptUpdateTime":null,"ptCreateId":"990852611096141344","ptNode":"0","ptIsNode":true,"ptDesc":null,"name":null,"children":null},{"ptId":"621425347576991744","ptName":"语文","ptCreateTime":"2019-03-08 10:57:23.0","ptUpdateTime":null,"ptCreateId":"990852611096141344","ptNode":"621425308926480384","ptIsNode":true,"ptDesc":null,"name":null,"children":null},{"ptId":"621425374558949376","ptName":"数学","ptCreateTime":"2019-03-08 10:57:29.0","ptUpdateTime":null,"ptCreateId":"990852611096141344","ptNode":"621425308926480384","ptIsNode":false,"ptDesc":null,"name":null,"children":null},{"ptId":"621425412672589824","ptName":"文言文","ptCreateTime":"2019-03-08 10:57:38.0","ptUpdateTime":null,"ptCreateId":"990852611096141344","ptNode":"621425347576991744","ptIsNode":true,"ptDesc":null,"name":null,"children":null},{"ptId":"621425442364067840","ptName":"写作","ptCreateTime":"2019-03-08 10:57:45.0","ptUpdateTime":null,"ptCreateId":"990852611096141344","ptNode":"621425412672589824","ptIsNode":false,"ptDesc":null,"name":null,"children":null}]
     */

    private int code;
    private String msg;
    private List<DataBean> data;

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

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * ptId : 621425308926480384
         * ptName : 文学
         * ptCreateTime : 2019-03-08 10:57:13.0
         * ptUpdateTime : null
         * ptCreateId : 990852611096141344
         * ptNode : 0
         * ptIsNode : true
         * ptDesc : null
         * name : null
         * children : null
         */

        private String ptId;
        private String ptName;
        private String ptCreateTime;
        private Object ptUpdateTime;
        private String ptCreateId;
        private String ptNode;
        private boolean ptIsNode;
        private Object ptDesc;
        private Object name;
        private Object children;

        public String getPtId() {
            return ptId;
        }

        public void setPtId(String ptId) {
            this.ptId = ptId;
        }

        public String getPtName() {
            return ptName;
        }

        public void setPtName(String ptName) {
            this.ptName = ptName;
        }

        public String getPtCreateTime() {
            return ptCreateTime;
        }

        public void setPtCreateTime(String ptCreateTime) {
            this.ptCreateTime = ptCreateTime;
        }

        public Object getPtUpdateTime() {
            return ptUpdateTime;
        }

        public void setPtUpdateTime(Object ptUpdateTime) {
            this.ptUpdateTime = ptUpdateTime;
        }

        public String getPtCreateId() {
            return ptCreateId;
        }

        public void setPtCreateId(String ptCreateId) {
            this.ptCreateId = ptCreateId;
        }

        public String getPtNode() {
            return ptNode;
        }

        public void setPtNode(String ptNode) {
            this.ptNode = ptNode;
        }

        public boolean isPtIsNode() {
            return ptIsNode;
        }

        public void setPtIsNode(boolean ptIsNode) {
            this.ptIsNode = ptIsNode;
        }

        public Object getPtDesc() {
            return ptDesc;
        }

        public void setPtDesc(Object ptDesc) {
            this.ptDesc = ptDesc;
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
