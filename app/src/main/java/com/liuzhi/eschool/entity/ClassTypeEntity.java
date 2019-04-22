package com.liuzhi.eschool.entity;

import java.util.List;

public class ClassTypeEntity {

    /**
     * code : 0
     * msg : 操作成功
     * data : [{"tpId":"600866880307073024","tpName":"应用文写作","tpHasSon":0,"tpNodeId":"600861597014953984","tpIsUsual":0,"tpCreateTime":"2019-01-10 17:25:22.0","tpEditTime":null,"tpEditUId":null,"tpEditUName":"admin"},{"tpId":"601204868429910016","tpName":"阅读理解","tpHasSon":0,"tpNodeId":"600861597014953984","tpIsUsual":0,"tpCreateTime":"2019-01-11 15:48:25.0","tpEditTime":null,"tpEditUId":null,"tpEditUName":"admin"},{"tpId":"601204900096905216","tpName":"文言文","tpHasSon":0,"tpNodeId":"600861597014953984","tpIsUsual":0,"tpCreateTime":"2019-01-11 15:48:32.0","tpEditTime":null,"tpEditUId":null,"tpEditUName":"admin"},{"tpId":"601204972176019456","tpName":"古诗词","tpHasSon":0,"tpNodeId":"600861597014953984","tpIsUsual":0,"tpCreateTime":"2019-01-11 15:48:49.0","tpEditTime":null,"tpEditUId":null,"tpEditUName":"admin"}]
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
         * tpId : 600866880307073024
         * tpName : 应用文写作
         * tpHasSon : 0
         * tpNodeId : 600861597014953984
         * tpIsUsual : 0
         * tpCreateTime : 2019-01-10 17:25:22.0
         * tpEditTime : null
         * tpEditUId : null
         * tpEditUName : admin
         */

        private String tpId;
        private String tpName;
        private int tpHasSon;
        private String tpNodeId;
        private int tpIsUsual;
        private String tpCreateTime;
        private Object tpEditTime;
        private Object tpEditUId;
        private String tpEditUName;

        public String getTpId() {
            return tpId;
        }

        public void setTpId(String tpId) {
            this.tpId = tpId;
        }

        public String getTpName() {
            return tpName;
        }

        public void setTpName(String tpName) {
            this.tpName = tpName;
        }

        public int getTpHasSon() {
            return tpHasSon;
        }

        public void setTpHasSon(int tpHasSon) {
            this.tpHasSon = tpHasSon;
        }

        public String getTpNodeId() {
            return tpNodeId;
        }

        public void setTpNodeId(String tpNodeId) {
            this.tpNodeId = tpNodeId;
        }

        public int getTpIsUsual() {
            return tpIsUsual;
        }

        public void setTpIsUsual(int tpIsUsual) {
            this.tpIsUsual = tpIsUsual;
        }

        public String getTpCreateTime() {
            return tpCreateTime;
        }

        public void setTpCreateTime(String tpCreateTime) {
            this.tpCreateTime = tpCreateTime;
        }

        public Object getTpEditTime() {
            return tpEditTime;
        }

        public void setTpEditTime(Object tpEditTime) {
            this.tpEditTime = tpEditTime;
        }

        public Object getTpEditUId() {
            return tpEditUId;
        }

        public void setTpEditUId(Object tpEditUId) {
            this.tpEditUId = tpEditUId;
        }

        public String getTpEditUName() {
            return tpEditUName;
        }

        public void setTpEditUName(String tpEditUName) {
            this.tpEditUName = tpEditUName;
        }
    }
}
