package com.liuzhi.eschool.entity;

import java.util.List;

public class ClassEntity {

    /**
     * code : 0
     * msg : 操作成功
     * data : [{"tpId":"1","tpName":"数学","tpHasSon":1,"tpNodeId":"0","tpIsUsual":0,"tpCreateTime":"2019-01-01 13:40:19.0","tpEditTime":"2019-01-10 13:40:23.0","tpEditUId":"1","tpEditUName":"aaa"},{"tpId":"600861597014953984","tpName":"中国文学","tpHasSon":1,"tpNodeId":"0","tpIsUsual":0,"tpCreateTime":"2019-01-10 17:04:22.0","tpEditTime":"2019-01-10 17:24:47.0","tpEditUId":"20181248699","tpEditUName":"admin"},{"tpId":"601205390205521920","tpName":"物理","tpHasSon":1,"tpNodeId":"0","tpIsUsual":0,"tpCreateTime":"2019-01-11 15:50:29.0","tpEditTime":null,"tpEditUId":null,"tpEditUName":"admin"},{"tpId":"601205720813146112","tpName":"计算机","tpHasSon":1,"tpNodeId":"0","tpIsUsual":0,"tpCreateTime":"2019-01-11 15:51:48.0","tpEditTime":null,"tpEditUId":null,"tpEditUName":"admin"}]
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
         * tpId : 1
         * tpName : 数学
         * tpHasSon : 1
         * tpNodeId : 0
         * tpIsUsual : 0
         * tpCreateTime : 2019-01-01 13:40:19.0
         * tpEditTime : 2019-01-10 13:40:23.0
         * tpEditUId : 1
         * tpEditUName : aaa
         */

        private String tpId;
        private String tpName;
        private int tpHasSon;
        private String tpNodeId;
        private int tpIsUsual;
        private String tpCreateTime;
        private String tpEditTime;
        private String tpEditUId;
        private String tpEditUName;
        private boolean tpIsChoosed;

        public boolean isTpIsChoosed() {
            return tpIsChoosed;
        }

        public void setTpIsChoosed(boolean tpIsChoosed) {
            this.tpIsChoosed = tpIsChoosed;
        }

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

        public String getTpEditTime() {
            return tpEditTime;
        }

        public void setTpEditTime(String tpEditTime) {
            this.tpEditTime = tpEditTime;
        }

        public String getTpEditUId() {
            return tpEditUId;
        }

        public void setTpEditUId(String tpEditUId) {
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
