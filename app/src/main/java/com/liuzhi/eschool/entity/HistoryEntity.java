package com.liuzhi.eschool.entity;

import java.util.List;

public class HistoryEntity {

    /**
     * code : 0
     * msg : 操作成功
     * data : [{"hId":"636355187182669824","hUrl":"/html/lesson/id/636352160598069248.html","hUId":"20181342745","hIId":"636352160598069248","hYear":2019,"hMonth":4,"hDay":18,"hTime":"2019-04-18 15:43:14","ifName":null,"lsName":"三角函数"},{"hId":"636279946460794880","hUrl":"/html/text/631320540618952704.html","hUId":"20181342745","hIId":"631320540618952704","hYear":2019,"hMonth":4,"hDay":18,"hTime":"2019-04-18 10:44:16","ifName":"伊朗洪灾肆虐 已造成至少57人死亡478人受伤","lsName":null},{"hId":"634176136175161344","hUrl":"/html/text/630599323838582784.html","hUId":"20181342745","hIId":"630599323838582784","hYear":2019,"hMonth":4,"hDay":12,"hTime":"2019-04-12 15:24:28","ifName":"尛尛企业","lsName":null},{"hId":"634175653947641856","hUrl":"/html/text/630848958444343296.html","hUId":"20181342745","hIId":"630848958444343296","hYear":2019,"hMonth":4,"hDay":12,"hTime":"2019-04-12 15:22:33","ifName":"经验分享经验分享经验分享","lsName":null},{"hId":"634174919281741824","hUrl":"/html/text/630921387183181824.html","hUId":"20181342745","hIId":"630921387183181824","hYear":2019,"hMonth":4,"hDay":12,"hTime":"2019-04-12 15:19:38","ifName":"java","lsName":null},{"hId":"634173473836503040","hUrl":"/html/text/633492542125510656.html","hUId":"20181342745","hIId":"633492542125510656","hYear":2019,"hMonth":4,"hDay":12,"hTime":"2019-04-12 15:13:53","ifName":"教学文件教学文件","lsName":null},{"hId":"634168021627179008","hUrl":"/html/text/630938399787716612.html","hUId":"20181342745","hIId":"630938399787716612","hYear":2019,"hMonth":4,"hDay":12,"hTime":"2019-04-12 14:52:13","ifName":"项目组长 孙芳城","lsName":null},{"hId":"634168007039389696","hUrl":"/html/text/630938109780955139.html","hUId":"20181342745","hIId":"630938109780955139","hYear":2019,"hMonth":4,"hDay":12,"hTime":"2019-04-12 14:52:10","ifName":"成员四","lsName":null},{"hId":"633836243150442496","hUrl":"/html/text/630938399787716608.html","hUId":"20181342745","hIId":"630938399787716608","hYear":2019,"hMonth":4,"hDay":11,"hTime":"2019-04-11 16:53:51","ifName":"项目组长 孙芳城","lsName":null},{"hId":"633493290183823360","hUrl":"/html/text/633492504762650624.html","hUId":"20181342745","hIId":"633492504762650624","hYear":2019,"hMonth":4,"hDay":10,"hTime":"2019-04-10 18:11:05","ifName":"教学文件","lsName":null},{"hId":"633493209292476416","hUrl":"/html/text/630921612035624960.html","hUId":"20181342745","hIId":"630921612035624960","hYear":2019,"hMonth":4,"hDay":10,"hTime":"2019-04-10 18:10:46","ifName":"javajavajavajava","lsName":null},{"hId":"633490732623073280","hUrl":"/html/text/627661412210053120.html","hUId":"20181342745","hIId":"627661412210053120","hYear":2019,"hMonth":4,"hDay":10,"hTime":"2019-04-10 18:00:55","ifName":null,"lsName":null},{"hId":"633479663636713472","hUrl":"/html/lesson/id/601204281000857600.html","hUId":"20181342745","hIId":"601204281000857600","hYear":2019,"hMonth":4,"hDay":10,"hTime":"2019-04-10 17:16:56","ifName":null,"lsName":"阅读"},{"hId":"633479650714062848","hUrl":"/html/lesson/id/605562999792472064.html","hUId":"20181342745","hIId":"605562999792472064","hYear":2019,"hMonth":4,"hDay":10,"hTime":"2019-04-10 17:16:53","ifName":null,"lsName":null},{"hId":"633479575250145280","hUrl":"/html/lesson/id/602667488198529024.html","hUId":"20181342745","hIId":"602667488198529024","hYear":2019,"hMonth":4,"hDay":10,"hTime":"2019-04-10 17:16:35","ifName":null,"lsName":"文言文"},{"hId":"633479551967563776","hUrl":"/html/lesson/id/606306917299523585.html","hUId":"20181342745","hIId":"606306917299523585","hYear":2019,"hMonth":4,"hDay":10,"hTime":"2019-04-10 17:16:29","ifName":null,"lsName":"课程链接2"},{"hId":"633453560138305536","hUrl":"/html/lesson/id/601141517284806656.html","hUId":"20181342745","hIId":"601141517284806656","hYear":2019,"hMonth":4,"hDay":10,"hTime":"2019-04-10 15:33:12","ifName":null,"lsName":"微积分"},{"hId":"633453528144154624","hUrl":"/html/lesson/id/606306348040196096.html","hUId":"20181342745","hIId":"606306348040196096","hYear":2019,"hMonth":4,"hDay":10,"hTime":"2019-04-10 15:33:05","ifName":null,"lsName":"课程链接"}]
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
         * hId : 636355187182669824
         * hUrl : /html/lesson/id/636352160598069248.html
         * hUId : 20181342745
         * hIId : 636352160598069248
         * hYear : 2019
         * hMonth : 4
         * hDay : 18
         * hTime : 2019-04-18 15:43:14
         * ifName : null
         * lsName : 三角函数
         */

        private String hId;
        private String hUrl;
        private String hUId;
        private String hIId;
        private int hYear;
        private int hMonth;
        private int hDay;
        private String hTime;
        private String ifName;
        private String lsName;

        public String getHId() {
            return hId;
        }

        public void setHId(String hId) {
            this.hId = hId;
        }

        public String getHUrl() {
            return hUrl;
        }

        public void setHUrl(String hUrl) {
            this.hUrl = hUrl;
        }

        public String getHUId() {
            return hUId;
        }

        public void setHUId(String hUId) {
            this.hUId = hUId;
        }

        public String getHIId() {
            return hIId;
        }

        public void setHIId(String hIId) {
            this.hIId = hIId;
        }

        public int getHYear() {
            return hYear;
        }

        public void setHYear(int hYear) {
            this.hYear = hYear;
        }

        public int getHMonth() {
            return hMonth;
        }

        public void setHMonth(int hMonth) {
            this.hMonth = hMonth;
        }

        public int getHDay() {
            return hDay;
        }

        public void setHDay(int hDay) {
            this.hDay = hDay;
        }

        public String getHTime() {
            return hTime;
        }

        public void setHTime(String hTime) {
            this.hTime = hTime;
        }

        public String getIfName() {
            return ifName;
        }

        public void setIfName(String ifName) {
            this.ifName = ifName;
        }

        public String getLsName() {
            return lsName;
        }

        public void setLsName(String lsName) {
            this.lsName = lsName;
        }
    }
}
