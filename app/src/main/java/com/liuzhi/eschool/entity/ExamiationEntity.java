package com.liuzhi.eschool.entity;

import java.io.Serializable;
import java.util.List;

public class ExamiationEntity implements Serializable{

    /**
     * pageSize : 10
     * totalRows : 3
     * pageNo : 1
     * resultList : [{"pmId":"623940497869639680","mebId":"621425308926480384","mebname":"文学","pmModel":false,"pmState":true,"pmTimeLimit":0,"pmCreateTime":"2019-03-15 09:31:41.0","pmUpdateTime":"2019-03-15 10:06:48.0","pmCreateId":"990852611096141344","pmCreateName":null,"pmUpdateId":"990852611096141344","pmUpdateName":"管理员9","pmName":"fdsafdsfd","pmStuLevel":2,"pmCountLimit":0,"pmAnswerLimit":false,"pmTopicWay":false,"pmTopicPage":0,"pmQuestionsWay":false,"pmQualified":"60","pmReturn":1,"pmTwoCode":"/static/upload/qr/2WZX.png","pmLink":"EGPLJR","pmInvite":"2WZX","pmDesc":null,"remark":null},{"pmId":"623954926543835136","mebId":"621425308926480384","mebname":"文学","pmModel":false,"pmState":true,"pmTimeLimit":0,"pmCreateTime":"2019-03-15 10:29:01.0","pmUpdateTime":"2019-03-15 10:42:27.0","pmCreateId":"990852611096141344","pmCreateName":null,"pmUpdateId":"600852611096141344","pmUpdateName":"管理员411","pmName":"fdasfdsa","pmStuLevel":2,"pmCountLimit":0,"pmAnswerLimit":false,"pmTopicWay":false,"pmTopicPage":0,"pmQuestionsWay":false,"pmQualified":"60","pmReturn":1,"pmTwoCode":"/static/upload/qr/JU0C.png","pmLink":"VYUMZK","pmInvite":"JU0C","pmDesc":null,"remark":null},{"pmId":"623959770562301952","mebId":"621425308926480384","mebname":"文学","pmModel":false,"pmState":true,"pmTimeLimit":0,"pmCreateTime":"2019-03-15 10:48:16.0","pmUpdateTime":"2019-04-04 14:33:02.0","pmCreateId":"990852611096141344","pmCreateName":null,"pmUpdateId":"20181248699","pmUpdateName":"admin","pmName":"发的萨芬","pmStuLevel":2,"pmCountLimit":0,"pmAnswerLimit":false,"pmTopicWay":false,"pmTopicPage":0,"pmQuestionsWay":false,"pmQualified":"60","pmReturn":1,"pmTwoCode":"/static/upload/qr/YHET.png","pmLink":"OB4GL2","pmInvite":"YHET","pmDesc":null,"remark":null}]
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

    public static class ResultListBean implements Serializable {
        /**
         * pmId : 623940497869639680
         * mebId : 621425308926480384
         * mebname : 文学
         * pmModel : false
         * pmState : true
         * pmTimeLimit : 0
         * pmCreateTime : 2019-03-15 09:31:41.0
         * pmUpdateTime : 2019-03-15 10:06:48.0
         * pmCreateId : 990852611096141344
         * pmCreateName : null
         * pmUpdateId : 990852611096141344
         * pmUpdateName : 管理员9
         * pmName : fdsafdsfd
         * pmStuLevel : 2
         * pmCountLimit : 0
         * pmAnswerLimit : false
         * pmTopicWay : false
         * pmTopicPage : 0
         * pmQuestionsWay : false
         * pmQualified : 60
         * pmReturn : 1
         * pmTwoCode : /static/upload/qr/2WZX.png
         * pmLink : EGPLJR
         * pmInvite : 2WZX
         * pmDesc : null
         * remark : null
         */

        private String pmId;
        private String mebId;
        private String mebname;
        private boolean pmModel;
        private boolean pmState;
        private int pmTimeLimit;
        private String pmCreateTime;
        private String pmUpdateTime;
        private String pmCreateId;
        private Object pmCreateName;
        private String pmUpdateId;
        private String pmUpdateName;
        private String pmName;
        private int pmStuLevel;
        private int pmCountLimit;
        private boolean pmAnswerLimit;
        private boolean pmTopicWay;
        private int pmTopicPage;
        private boolean pmQuestionsWay;
        private String pmQualified;
        private int pmReturn;
        private String pmTwoCode;
        private String pmLink;
        private String pmInvite;
        private Object pmDesc;
        private Object remark;

        public String getPmId() {
            return pmId;
        }

        public void setPmId(String pmId) {
            this.pmId = pmId;
        }

        public String getMebId() {
            return mebId;
        }

        public void setMebId(String mebId) {
            this.mebId = mebId;
        }

        public String getMebname() {
            return mebname;
        }

        public void setMebname(String mebname) {
            this.mebname = mebname;
        }

        public boolean isPmModel() {
            return pmModel;
        }

        public void setPmModel(boolean pmModel) {
            this.pmModel = pmModel;
        }

        public boolean isPmState() {
            return pmState;
        }

        public void setPmState(boolean pmState) {
            this.pmState = pmState;
        }

        public int getPmTimeLimit() {
            return pmTimeLimit;
        }

        public void setPmTimeLimit(int pmTimeLimit) {
            this.pmTimeLimit = pmTimeLimit;
        }

        public String getPmCreateTime() {
            return pmCreateTime;
        }

        public void setPmCreateTime(String pmCreateTime) {
            this.pmCreateTime = pmCreateTime;
        }

        public String getPmUpdateTime() {
            return pmUpdateTime;
        }

        public void setPmUpdateTime(String pmUpdateTime) {
            this.pmUpdateTime = pmUpdateTime;
        }

        public String getPmCreateId() {
            return pmCreateId;
        }

        public void setPmCreateId(String pmCreateId) {
            this.pmCreateId = pmCreateId;
        }

        public Object getPmCreateName() {
            return pmCreateName;
        }

        public void setPmCreateName(Object pmCreateName) {
            this.pmCreateName = pmCreateName;
        }

        public String getPmUpdateId() {
            return pmUpdateId;
        }

        public void setPmUpdateId(String pmUpdateId) {
            this.pmUpdateId = pmUpdateId;
        }

        public String getPmUpdateName() {
            return pmUpdateName;
        }

        public void setPmUpdateName(String pmUpdateName) {
            this.pmUpdateName = pmUpdateName;
        }

        public String getPmName() {
            return pmName;
        }

        public void setPmName(String pmName) {
            this.pmName = pmName;
        }

        public int getPmStuLevel() {
            return pmStuLevel;
        }

        public void setPmStuLevel(int pmStuLevel) {
            this.pmStuLevel = pmStuLevel;
        }

        public int getPmCountLimit() {
            return pmCountLimit;
        }

        public void setPmCountLimit(int pmCountLimit) {
            this.pmCountLimit = pmCountLimit;
        }

        public boolean isPmAnswerLimit() {
            return pmAnswerLimit;
        }

        public void setPmAnswerLimit(boolean pmAnswerLimit) {
            this.pmAnswerLimit = pmAnswerLimit;
        }

        public boolean isPmTopicWay() {
            return pmTopicWay;
        }

        public void setPmTopicWay(boolean pmTopicWay) {
            this.pmTopicWay = pmTopicWay;
        }

        public int getPmTopicPage() {
            return pmTopicPage;
        }

        public void setPmTopicPage(int pmTopicPage) {
            this.pmTopicPage = pmTopicPage;
        }

        public boolean isPmQuestionsWay() {
            return pmQuestionsWay;
        }

        public void setPmQuestionsWay(boolean pmQuestionsWay) {
            this.pmQuestionsWay = pmQuestionsWay;
        }

        public String getPmQualified() {
            return pmQualified;
        }

        public void setPmQualified(String pmQualified) {
            this.pmQualified = pmQualified;
        }

        public int getPmReturn() {
            return pmReturn;
        }

        public void setPmReturn(int pmReturn) {
            this.pmReturn = pmReturn;
        }

        public String getPmTwoCode() {
            return pmTwoCode;
        }

        public void setPmTwoCode(String pmTwoCode) {
            this.pmTwoCode = pmTwoCode;
        }

        public String getPmLink() {
            return pmLink;
        }

        public void setPmLink(String pmLink) {
            this.pmLink = pmLink;
        }

        public String getPmInvite() {
            return pmInvite;
        }

        public void setPmInvite(String pmInvite) {
            this.pmInvite = pmInvite;
        }

        public Object getPmDesc() {
            return pmDesc;
        }

        public void setPmDesc(Object pmDesc) {
            this.pmDesc = pmDesc;
        }

        public Object getRemark() {
            return remark;
        }

        public void setRemark(Object remark) {
            this.remark = remark;
        }
    }
}
