package com.liuzhi.eschool.entity;

import java.util.List;

public class SimulationEntity {

    /**
     * pageSize : 10
     * totalRows : 2
     * pageNo : 1
     * resultList : [{"teId":"624074056685064192","teName":"无主观题","mebName":null,"mebAllScore":null,"mebAllNumber":null,"mebOneScore":null,"mebOneNumber":null,"mebMoreScore":null,"mebMoreNumber":null,"mebJudgeScore":null,"mebJudgeNumber":null,"mebSubjectiveScore":null,"mebSubjectiveNumber":null,"mebId":null,"ptName":"数学","ptId":"621425374558949376","teIsAllTopic":null,"teState":true,"teUpdateTime":null,"teCreateTime":"2019-03-15 18:22:24.0","teCreateId":"990852611096141344","teUpdateId":null,"teShowOrder":true,"teTopicWay":true,"teStuLevel":1,"teTestModel":true,"teInvite":"WACS","teLink":"GZG5U2","teTwoCode":"/static/upload/qr/WACS.png","teDesc":null,"remark":null},{"teId":"623963076529491968","teName":"fdfdfd","mebName":"文言文 英语","mebAllScore":"1.0 5.0 ","mebAllNumber":"1 1 ","mebOneScore":"1.0 1.0 ","mebOneNumber":"1 1 ","mebMoreScore":"1.0 1.0 ","mebMoreNumber":"1 1 ","mebJudgeScore":"1.0 1.0 ","mebJudgeNumber":"1 1 ","mebSubjectiveScore":"1.0 1.0 ","mebSubjectiveNumber":"1 1 ","mebId":"621422332509949952 621407131605667840","ptName":"文言文","ptId":"621425412672589824","teIsAllTopic":false,"teState":true,"teUpdateTime":"2019-03-15 18:22:09.0","teCreateTime":"2019-03-15 11:01:24.0","teCreateId":"990852611096141344","teUpdateId":"990852611096141344","teShowOrder":false,"teTopicWay":true,"teStuLevel":2,"teTestModel":false,"teInvite":"4D1E","teLink":"HUKFMV","teTwoCode":"/static/upload/qr/4D1E.png","teDesc":null,"remark":"0 0 "}]
     * query : null
     * endIndex : 2
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
         * teId : 624074056685064192
         * teName : 无主观题
         * mebName : null
         * mebAllScore : null
         * mebAllNumber : null
         * mebOneScore : null
         * mebOneNumber : null
         * mebMoreScore : null
         * mebMoreNumber : null
         * mebJudgeScore : null
         * mebJudgeNumber : null
         * mebSubjectiveScore : null
         * mebSubjectiveNumber : null
         * mebId : null
         * ptName : 数学
         * ptId : 621425374558949376
         * teIsAllTopic : null
         * teState : true
         * teUpdateTime : null
         * teCreateTime : 2019-03-15 18:22:24.0
         * teCreateId : 990852611096141344
         * teUpdateId : null
         * teShowOrder : true
         * teTopicWay : true
         * teStuLevel : 1
         * teTestModel : true
         * teInvite : WACS
         * teLink : GZG5U2
         * teTwoCode : /static/upload/qr/WACS.png
         * teDesc : null
         * remark : null
         */

        private String teId;
        private String teName;
        private Object mebName;
        private Object mebAllScore;
        private Object mebAllNumber;
        private Object mebOneScore;
        private Object mebOneNumber;
        private Object mebMoreScore;
        private Object mebMoreNumber;
        private Object mebJudgeScore;
        private Object mebJudgeNumber;
        private Object mebSubjectiveScore;
        private Object mebSubjectiveNumber;
        private Object mebId;
        private String ptName;
        private String ptId;
        private Object teIsAllTopic;
        private boolean teState;
        private Object teUpdateTime;
        private String teCreateTime;
        private String teCreateId;
        private Object teUpdateId;
        private boolean teShowOrder;
        private boolean teTopicWay;
        private int teStuLevel;
        private boolean teTestModel;
        private String teInvite;
        private String teLink;
        private String teTwoCode;
        private Object teDesc;
        private Object remark;

        public String getTeId() {
            return teId;
        }

        public void setTeId(String teId) {
            this.teId = teId;
        }

        public String getTeName() {
            return teName;
        }

        public void setTeName(String teName) {
            this.teName = teName;
        }

        public Object getMebName() {
            return mebName;
        }

        public void setMebName(Object mebName) {
            this.mebName = mebName;
        }

        public Object getMebAllScore() {
            return mebAllScore;
        }

        public void setMebAllScore(Object mebAllScore) {
            this.mebAllScore = mebAllScore;
        }

        public Object getMebAllNumber() {
            return mebAllNumber;
        }

        public void setMebAllNumber(Object mebAllNumber) {
            this.mebAllNumber = mebAllNumber;
        }

        public Object getMebOneScore() {
            return mebOneScore;
        }

        public void setMebOneScore(Object mebOneScore) {
            this.mebOneScore = mebOneScore;
        }

        public Object getMebOneNumber() {
            return mebOneNumber;
        }

        public void setMebOneNumber(Object mebOneNumber) {
            this.mebOneNumber = mebOneNumber;
        }

        public Object getMebMoreScore() {
            return mebMoreScore;
        }

        public void setMebMoreScore(Object mebMoreScore) {
            this.mebMoreScore = mebMoreScore;
        }

        public Object getMebMoreNumber() {
            return mebMoreNumber;
        }

        public void setMebMoreNumber(Object mebMoreNumber) {
            this.mebMoreNumber = mebMoreNumber;
        }

        public Object getMebJudgeScore() {
            return mebJudgeScore;
        }

        public void setMebJudgeScore(Object mebJudgeScore) {
            this.mebJudgeScore = mebJudgeScore;
        }

        public Object getMebJudgeNumber() {
            return mebJudgeNumber;
        }

        public void setMebJudgeNumber(Object mebJudgeNumber) {
            this.mebJudgeNumber = mebJudgeNumber;
        }

        public Object getMebSubjectiveScore() {
            return mebSubjectiveScore;
        }

        public void setMebSubjectiveScore(Object mebSubjectiveScore) {
            this.mebSubjectiveScore = mebSubjectiveScore;
        }

        public Object getMebSubjectiveNumber() {
            return mebSubjectiveNumber;
        }

        public void setMebSubjectiveNumber(Object mebSubjectiveNumber) {
            this.mebSubjectiveNumber = mebSubjectiveNumber;
        }

        public Object getMebId() {
            return mebId;
        }

        public void setMebId(Object mebId) {
            this.mebId = mebId;
        }

        public String getPtName() {
            return ptName;
        }

        public void setPtName(String ptName) {
            this.ptName = ptName;
        }

        public String getPtId() {
            return ptId;
        }

        public void setPtId(String ptId) {
            this.ptId = ptId;
        }

        public Object getTeIsAllTopic() {
            return teIsAllTopic;
        }

        public void setTeIsAllTopic(Object teIsAllTopic) {
            this.teIsAllTopic = teIsAllTopic;
        }

        public boolean isTeState() {
            return teState;
        }

        public void setTeState(boolean teState) {
            this.teState = teState;
        }

        public Object getTeUpdateTime() {
            return teUpdateTime;
        }

        public void setTeUpdateTime(Object teUpdateTime) {
            this.teUpdateTime = teUpdateTime;
        }

        public String getTeCreateTime() {
            return teCreateTime;
        }

        public void setTeCreateTime(String teCreateTime) {
            this.teCreateTime = teCreateTime;
        }

        public String getTeCreateId() {
            return teCreateId;
        }

        public void setTeCreateId(String teCreateId) {
            this.teCreateId = teCreateId;
        }

        public Object getTeUpdateId() {
            return teUpdateId;
        }

        public void setTeUpdateId(Object teUpdateId) {
            this.teUpdateId = teUpdateId;
        }

        public boolean isTeShowOrder() {
            return teShowOrder;
        }

        public void setTeShowOrder(boolean teShowOrder) {
            this.teShowOrder = teShowOrder;
        }

        public boolean isTeTopicWay() {
            return teTopicWay;
        }

        public void setTeTopicWay(boolean teTopicWay) {
            this.teTopicWay = teTopicWay;
        }

        public int getTeStuLevel() {
            return teStuLevel;
        }

        public void setTeStuLevel(int teStuLevel) {
            this.teStuLevel = teStuLevel;
        }

        public boolean isTeTestModel() {
            return teTestModel;
        }

        public void setTeTestModel(boolean teTestModel) {
            this.teTestModel = teTestModel;
        }

        public String getTeInvite() {
            return teInvite;
        }

        public void setTeInvite(String teInvite) {
            this.teInvite = teInvite;
        }

        public String getTeLink() {
            return teLink;
        }

        public void setTeLink(String teLink) {
            this.teLink = teLink;
        }

        public String getTeTwoCode() {
            return teTwoCode;
        }

        public void setTeTwoCode(String teTwoCode) {
            this.teTwoCode = teTwoCode;
        }

        public Object getTeDesc() {
            return teDesc;
        }

        public void setTeDesc(Object teDesc) {
            this.teDesc = teDesc;
        }

        public Object getRemark() {
            return remark;
        }

        public void setRemark(Object remark) {
            this.remark = remark;
        }
    }
}
