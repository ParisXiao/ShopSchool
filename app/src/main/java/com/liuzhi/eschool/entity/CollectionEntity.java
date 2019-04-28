package com.liuzhi.eschool.entity;

import java.util.List;

public class CollectionEntity {

    /**
     * code : 0
     * msg : 操作成功
     * data : [{"coId":"633740803952349184","coUrl":"/html/lesson/section/602261856089804800.html","coType":1,"coTime":"2019-04-11 10:34:37","coUId":"20181342745","coIId":"602261856089804800","lsName":"小节三","ifName":null},{"coId":"633740618916433920","coUrl":"/html/lesson/section/601534271298998272.html","coType":1,"coTime":"2019-04-11 10:33:53","coUId":"20181342745","coIId":"601534271298998272","lsName":"请问请问","ifName":null}]
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
         * coId : 633740803952349184
         * coUrl : /html/lesson/section/602261856089804800.html
         * coType : 1
         * coTime : 2019-04-11 10:34:37
         * coUId : 20181342745
         * coIId : 602261856089804800
         * lsName : 小节三
         * ifName : null
         */

        private String coId;
        private String coUrl;
        private int coType;
        private String coTime;
        private String coUId;
        private String coIId;
        private String lsName;
        private String ifName;

        public String getCoId() {
            return coId;
        }

        public void setCoId(String coId) {
            this.coId = coId;
        }

        public String getCoUrl() {
            return coUrl;
        }

        public void setCoUrl(String coUrl) {
            this.coUrl = coUrl;
        }

        public int getCoType() {
            return coType;
        }

        public void setCoType(int coType) {
            this.coType = coType;
        }

        public String getCoTime() {
            return coTime;
        }

        public void setCoTime(String coTime) {
            this.coTime = coTime;
        }

        public String getCoUId() {
            return coUId;
        }

        public void setCoUId(String coUId) {
            this.coUId = coUId;
        }

        public String getCoIId() {
            return coIId;
        }

        public void setCoIId(String coIId) {
            this.coIId = coIId;
        }

        public String getLsName() {
            return lsName;
        }

        public void setLsName(String lsName) {
            this.lsName = lsName;
        }

        public String getIfName() {
            return ifName;
        }

        public void setIfName(String ifName) {
            this.ifName = ifName;
        }
    }
}
