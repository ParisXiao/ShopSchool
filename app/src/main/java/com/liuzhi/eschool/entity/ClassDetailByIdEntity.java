package com.liuzhi.eschool.entity;

import java.util.List;

public class ClassDetailByIdEntity {

    /**
     * code : 0
     * msg : 操作成功
     * data : {"flag":true,"lesson":[{"chapter":{"cpId":"601228071437078528","lsName":"aaa","lsId":"601141517284806656","cpName":"aaa第一章","cpDscb":"aa","cpCreateUId":"20181248699","cpCreateUName":"admin","cpCreateTime":"2019-01-11 17:20:37.0","cpEditTime":"2019-01-14 13:03:21.0","cpEditUId":"20181248699","cpEditUName":"admin"},"sections":[{"scId":"601534271298998272","cpId":"601228071437078528","cpName":"范德萨发","lsName":"","scName":"请问请问","scAttachedType":null,"scContent":"","scIsAttached":false,"scAttachPath":"","scCreateTime":"2019-01-12 13:37:21.0","scCreateUId":"20181248699","scCreateUName":"admin","scEditTime":null,"scEditUId":null,"scEditUName":null},{"scId":"602224610930331648","cpId":"601228071437078528","cpName":"范德萨发","lsName":"","scName":"发发发","scAttachedType":null,"scContent":"","scIsAttached":true,"scAttachPath":"/static/upload/lesson/attached/1547436030710.jpg /static/upload/lesson/attached/1547436030711.jpg /static/upload/lesson/attached/1547436030712.png ","scCreateTime":"2019-01-14 11:20:30.0","scCreateUId":"20181248699","scCreateUName":"admin","scEditTime":null,"scEditUId":null,"scEditUName":null},{"scId":"602261727903485952","cpId":"601228071437078528","cpName":"aaa第一章","lsName":"","scName":"小节1","scAttachedType":null,"scContent":"PDF测试","scIsAttached":true,"scAttachPath":"/static/upload/lesson/attached/1554357962814.pdf ","scCreateTime":"2019-01-14 13:48:00.0","scCreateUId":"20181248699","scCreateUName":"admin","scEditTime":"2019-04-04 14:06:02.0","scEditUId":"20181342745","scEditUName":"杜康"},{"scId":"602261803929440256","cpId":"601228071437078528","cpName":"aaa第一章","lsName":"","scName":"小节2","scAttachedType":null,"scContent":"视频测试","scIsAttached":true,"scAttachPath":"/static/upload/lesson/attached/1554357799826.mp4 ","scCreateTime":"2019-01-14 13:48:18.0","scCreateUId":"20181248699","scCreateUName":"admin","scEditTime":"2019-04-04 14:03:19.0","scEditUId":"20181342745","scEditUName":"杜康"},{"scId":"602261856089804800","cpId":"601228071437078528","cpName":"aaa第一章","lsName":"","scName":"小节三","scAttachedType":null,"scContent":"","scIsAttached":false,"scAttachPath":"","scCreateTime":"2019-01-14 13:48:30.0","scCreateUId":"20181248699","scCreateUName":"admin","scEditTime":"2019-01-14 16:58:27.0","scEditUId":"20181248699","scEditUName":"admin"},{"scId":"602309956791701504","cpId":"601228071437078528","cpName":"aaa第一章","lsName":"","scName":"发大水发","scAttachedType":null,"scContent":"","scIsAttached":false,"scAttachPath":"","scCreateTime":"2019-01-14 16:59:38.0","scCreateUId":"20181248699","scCreateUName":"admin","scEditTime":null,"scEditUId":null,"scEditUName":null},{"scId":"603385822347005952","cpId":"601228071437078528","cpName":"aaa第一章","lsName":"","scName":"AAA","scAttachedType":null,"scContent":"FFF","scIsAttached":false,"scAttachPath":"","scCreateTime":"2019-01-17 16:14:45.0","scCreateUId":"20181248699","scCreateUName":"admin","scEditTime":"2019-01-17 17:20:41.0","scEditUId":"20181248699","scEditUName":"admin"}]}],"lessonInfo":{"lsId":"601141517284806656","lsName":"微积分","lsDscb":"微积分（Calculus）是高等数学中研究函数的微分(Differentiation)、积分(Integration)以及有关概念和应用的数学分支。它是数学的一个基础学科。内容主要包括极限、微分学、积分学及其应用。微分学包括求导数的运算，是一套关于变化率的理论。它使得函数、速度、加速度和曲线的斜率等均可用一套通用的符号进行讨论。积分学，包括求积分的运算，为定义和计算面积、体积等提供一套通用的方法","lsFirstType":"1","lsFirstTypeName":"数学","lsSecType":"2","lsSecTypeName":"微积分","lsUsuType":"601127142067015680","lsUsuTypeName":"基础","lsCreateTime":"2019-01-11 11:36:41.0","lsCreateUId":"20181248699","lsCreateUName":"admin","lsEditTime":"2019-04-18 15:29:13.0","lsEditUId":"20181342745","lsEditUName":"guanli","lsImg":"/static/img/timg.jpg","lsIsFirstTppe":true,"lsIsLink":false,"lsLink":"","lsIsHot":true,"lsClickCount":17}}
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

    public static class DataBean {
        /**
         * flag : true
         * lesson : [{"chapter":{"cpId":"601228071437078528","lsName":"aaa","lsId":"601141517284806656","cpName":"aaa第一章","cpDscb":"aa","cpCreateUId":"20181248699","cpCreateUName":"admin","cpCreateTime":"2019-01-11 17:20:37.0","cpEditTime":"2019-01-14 13:03:21.0","cpEditUId":"20181248699","cpEditUName":"admin"},"sections":[{"scId":"601534271298998272","cpId":"601228071437078528","cpName":"范德萨发","lsName":"","scName":"请问请问","scAttachedType":null,"scContent":"","scIsAttached":false,"scAttachPath":"","scCreateTime":"2019-01-12 13:37:21.0","scCreateUId":"20181248699","scCreateUName":"admin","scEditTime":null,"scEditUId":null,"scEditUName":null},{"scId":"602224610930331648","cpId":"601228071437078528","cpName":"范德萨发","lsName":"","scName":"发发发","scAttachedType":null,"scContent":"","scIsAttached":true,"scAttachPath":"/static/upload/lesson/attached/1547436030710.jpg /static/upload/lesson/attached/1547436030711.jpg /static/upload/lesson/attached/1547436030712.png ","scCreateTime":"2019-01-14 11:20:30.0","scCreateUId":"20181248699","scCreateUName":"admin","scEditTime":null,"scEditUId":null,"scEditUName":null},{"scId":"602261727903485952","cpId":"601228071437078528","cpName":"aaa第一章","lsName":"","scName":"小节1","scAttachedType":null,"scContent":"PDF测试","scIsAttached":true,"scAttachPath":"/static/upload/lesson/attached/1554357962814.pdf ","scCreateTime":"2019-01-14 13:48:00.0","scCreateUId":"20181248699","scCreateUName":"admin","scEditTime":"2019-04-04 14:06:02.0","scEditUId":"20181342745","scEditUName":"杜康"},{"scId":"602261803929440256","cpId":"601228071437078528","cpName":"aaa第一章","lsName":"","scName":"小节2","scAttachedType":null,"scContent":"视频测试","scIsAttached":true,"scAttachPath":"/static/upload/lesson/attached/1554357799826.mp4 ","scCreateTime":"2019-01-14 13:48:18.0","scCreateUId":"20181248699","scCreateUName":"admin","scEditTime":"2019-04-04 14:03:19.0","scEditUId":"20181342745","scEditUName":"杜康"},{"scId":"602261856089804800","cpId":"601228071437078528","cpName":"aaa第一章","lsName":"","scName":"小节三","scAttachedType":null,"scContent":"","scIsAttached":false,"scAttachPath":"","scCreateTime":"2019-01-14 13:48:30.0","scCreateUId":"20181248699","scCreateUName":"admin","scEditTime":"2019-01-14 16:58:27.0","scEditUId":"20181248699","scEditUName":"admin"},{"scId":"602309956791701504","cpId":"601228071437078528","cpName":"aaa第一章","lsName":"","scName":"发大水发","scAttachedType":null,"scContent":"","scIsAttached":false,"scAttachPath":"","scCreateTime":"2019-01-14 16:59:38.0","scCreateUId":"20181248699","scCreateUName":"admin","scEditTime":null,"scEditUId":null,"scEditUName":null},{"scId":"603385822347005952","cpId":"601228071437078528","cpName":"aaa第一章","lsName":"","scName":"AAA","scAttachedType":null,"scContent":"FFF","scIsAttached":false,"scAttachPath":"","scCreateTime":"2019-01-17 16:14:45.0","scCreateUId":"20181248699","scCreateUName":"admin","scEditTime":"2019-01-17 17:20:41.0","scEditUId":"20181248699","scEditUName":"admin"}]}]
         * lessonInfo : {"lsId":"601141517284806656","lsName":"微积分","lsDscb":"微积分（Calculus）是高等数学中研究函数的微分(Differentiation)、积分(Integration)以及有关概念和应用的数学分支。它是数学的一个基础学科。内容主要包括极限、微分学、积分学及其应用。微分学包括求导数的运算，是一套关于变化率的理论。它使得函数、速度、加速度和曲线的斜率等均可用一套通用的符号进行讨论。积分学，包括求积分的运算，为定义和计算面积、体积等提供一套通用的方法","lsFirstType":"1","lsFirstTypeName":"数学","lsSecType":"2","lsSecTypeName":"微积分","lsUsuType":"601127142067015680","lsUsuTypeName":"基础","lsCreateTime":"2019-01-11 11:36:41.0","lsCreateUId":"20181248699","lsCreateUName":"admin","lsEditTime":"2019-04-18 15:29:13.0","lsEditUId":"20181342745","lsEditUName":"guanli","lsImg":"/static/img/timg.jpg","lsIsFirstTppe":true,"lsIsLink":false,"lsLink":"","lsIsHot":true,"lsClickCount":17}
         */

        private boolean flag;
        private LessonInfoBean lessonInfo;
        private List<LessonBean> lesson;

        public boolean isFlag() {
            return flag;
        }

        public void setFlag(boolean flag) {
            this.flag = flag;
        }

        public LessonInfoBean getLessonInfo() {
            return lessonInfo;
        }

        public void setLessonInfo(LessonInfoBean lessonInfo) {
            this.lessonInfo = lessonInfo;
        }

        public List<LessonBean> getLesson() {
            return lesson;
        }

        public void setLesson(List<LessonBean> lesson) {
            this.lesson = lesson;
        }

        public static class LessonInfoBean {
            /**
             * lsId : 601141517284806656
             * lsName : 微积分
             * lsDscb : 微积分（Calculus）是高等数学中研究函数的微分(Differentiation)、积分(Integration)以及有关概念和应用的数学分支。它是数学的一个基础学科。内容主要包括极限、微分学、积分学及其应用。微分学包括求导数的运算，是一套关于变化率的理论。它使得函数、速度、加速度和曲线的斜率等均可用一套通用的符号进行讨论。积分学，包括求积分的运算，为定义和计算面积、体积等提供一套通用的方法
             * lsFirstType : 1
             * lsFirstTypeName : 数学
             * lsSecType : 2
             * lsSecTypeName : 微积分
             * lsUsuType : 601127142067015680
             * lsUsuTypeName : 基础
             * lsCreateTime : 2019-01-11 11:36:41.0
             * lsCreateUId : 20181248699
             * lsCreateUName : admin
             * lsEditTime : 2019-04-18 15:29:13.0
             * lsEditUId : 20181342745
             * lsEditUName : guanli
             * lsImg : /static/img/timg.jpg
             * lsIsFirstTppe : true
             * lsIsLink : false
             * lsLink :
             * lsIsHot : true
             * lsClickCount : 17
             */

            private String lsId;
            private String lsName;
            private String lsDscb;
            private String lsFirstType;
            private String lsFirstTypeName;
            private String lsSecType;
            private String lsSecTypeName;
            private String lsUsuType;
            private String lsUsuTypeName;
            private String lsCreateTime;
            private String lsCreateUId;
            private String lsCreateUName;
            private String lsEditTime;
            private String lsEditUId;
            private String lsEditUName;
            private String lsImg;
            private boolean lsIsFirstTppe;
            private boolean lsIsLink;
            private String lsLink;
            private boolean lsIsHot;
            private int lsClickCount;

            public String getLsId() {
                return lsId;
            }

            public void setLsId(String lsId) {
                this.lsId = lsId;
            }

            public String getLsName() {
                return lsName;
            }

            public void setLsName(String lsName) {
                this.lsName = lsName;
            }

            public String getLsDscb() {
                return lsDscb;
            }

            public void setLsDscb(String lsDscb) {
                this.lsDscb = lsDscb;
            }

            public String getLsFirstType() {
                return lsFirstType;
            }

            public void setLsFirstType(String lsFirstType) {
                this.lsFirstType = lsFirstType;
            }

            public String getLsFirstTypeName() {
                return lsFirstTypeName;
            }

            public void setLsFirstTypeName(String lsFirstTypeName) {
                this.lsFirstTypeName = lsFirstTypeName;
            }

            public String getLsSecType() {
                return lsSecType;
            }

            public void setLsSecType(String lsSecType) {
                this.lsSecType = lsSecType;
            }

            public String getLsSecTypeName() {
                return lsSecTypeName;
            }

            public void setLsSecTypeName(String lsSecTypeName) {
                this.lsSecTypeName = lsSecTypeName;
            }

            public String getLsUsuType() {
                return lsUsuType;
            }

            public void setLsUsuType(String lsUsuType) {
                this.lsUsuType = lsUsuType;
            }

            public String getLsUsuTypeName() {
                return lsUsuTypeName;
            }

            public void setLsUsuTypeName(String lsUsuTypeName) {
                this.lsUsuTypeName = lsUsuTypeName;
            }

            public String getLsCreateTime() {
                return lsCreateTime;
            }

            public void setLsCreateTime(String lsCreateTime) {
                this.lsCreateTime = lsCreateTime;
            }

            public String getLsCreateUId() {
                return lsCreateUId;
            }

            public void setLsCreateUId(String lsCreateUId) {
                this.lsCreateUId = lsCreateUId;
            }

            public String getLsCreateUName() {
                return lsCreateUName;
            }

            public void setLsCreateUName(String lsCreateUName) {
                this.lsCreateUName = lsCreateUName;
            }

            public String getLsEditTime() {
                return lsEditTime;
            }

            public void setLsEditTime(String lsEditTime) {
                this.lsEditTime = lsEditTime;
            }

            public String getLsEditUId() {
                return lsEditUId;
            }

            public void setLsEditUId(String lsEditUId) {
                this.lsEditUId = lsEditUId;
            }

            public String getLsEditUName() {
                return lsEditUName;
            }

            public void setLsEditUName(String lsEditUName) {
                this.lsEditUName = lsEditUName;
            }

            public String getLsImg() {
                return lsImg;
            }

            public void setLsImg(String lsImg) {
                this.lsImg = lsImg;
            }

            public boolean isLsIsFirstTppe() {
                return lsIsFirstTppe;
            }

            public void setLsIsFirstTppe(boolean lsIsFirstTppe) {
                this.lsIsFirstTppe = lsIsFirstTppe;
            }

            public boolean isLsIsLink() {
                return lsIsLink;
            }

            public void setLsIsLink(boolean lsIsLink) {
                this.lsIsLink = lsIsLink;
            }

            public String getLsLink() {
                return lsLink;
            }

            public void setLsLink(String lsLink) {
                this.lsLink = lsLink;
            }

            public boolean isLsIsHot() {
                return lsIsHot;
            }

            public void setLsIsHot(boolean lsIsHot) {
                this.lsIsHot = lsIsHot;
            }

            public int getLsClickCount() {
                return lsClickCount;
            }

            public void setLsClickCount(int lsClickCount) {
                this.lsClickCount = lsClickCount;
            }
        }

        public static class LessonBean {
            /**
             * chapter : {"cpId":"601228071437078528","lsName":"aaa","lsId":"601141517284806656","cpName":"aaa第一章","cpDscb":"aa","cpCreateUId":"20181248699","cpCreateUName":"admin","cpCreateTime":"2019-01-11 17:20:37.0","cpEditTime":"2019-01-14 13:03:21.0","cpEditUId":"20181248699","cpEditUName":"admin"}
             * sections : [{"scId":"601534271298998272","cpId":"601228071437078528","cpName":"范德萨发","lsName":"","scName":"请问请问","scAttachedType":null,"scContent":"","scIsAttached":false,"scAttachPath":"","scCreateTime":"2019-01-12 13:37:21.0","scCreateUId":"20181248699","scCreateUName":"admin","scEditTime":null,"scEditUId":null,"scEditUName":null},{"scId":"602224610930331648","cpId":"601228071437078528","cpName":"范德萨发","lsName":"","scName":"发发发","scAttachedType":null,"scContent":"","scIsAttached":true,"scAttachPath":"/static/upload/lesson/attached/1547436030710.jpg /static/upload/lesson/attached/1547436030711.jpg /static/upload/lesson/attached/1547436030712.png ","scCreateTime":"2019-01-14 11:20:30.0","scCreateUId":"20181248699","scCreateUName":"admin","scEditTime":null,"scEditUId":null,"scEditUName":null},{"scId":"602261727903485952","cpId":"601228071437078528","cpName":"aaa第一章","lsName":"","scName":"小节1","scAttachedType":null,"scContent":"PDF测试","scIsAttached":true,"scAttachPath":"/static/upload/lesson/attached/1554357962814.pdf ","scCreateTime":"2019-01-14 13:48:00.0","scCreateUId":"20181248699","scCreateUName":"admin","scEditTime":"2019-04-04 14:06:02.0","scEditUId":"20181342745","scEditUName":"杜康"},{"scId":"602261803929440256","cpId":"601228071437078528","cpName":"aaa第一章","lsName":"","scName":"小节2","scAttachedType":null,"scContent":"视频测试","scIsAttached":true,"scAttachPath":"/static/upload/lesson/attached/1554357799826.mp4 ","scCreateTime":"2019-01-14 13:48:18.0","scCreateUId":"20181248699","scCreateUName":"admin","scEditTime":"2019-04-04 14:03:19.0","scEditUId":"20181342745","scEditUName":"杜康"},{"scId":"602261856089804800","cpId":"601228071437078528","cpName":"aaa第一章","lsName":"","scName":"小节三","scAttachedType":null,"scContent":"","scIsAttached":false,"scAttachPath":"","scCreateTime":"2019-01-14 13:48:30.0","scCreateUId":"20181248699","scCreateUName":"admin","scEditTime":"2019-01-14 16:58:27.0","scEditUId":"20181248699","scEditUName":"admin"},{"scId":"602309956791701504","cpId":"601228071437078528","cpName":"aaa第一章","lsName":"","scName":"发大水发","scAttachedType":null,"scContent":"","scIsAttached":false,"scAttachPath":"","scCreateTime":"2019-01-14 16:59:38.0","scCreateUId":"20181248699","scCreateUName":"admin","scEditTime":null,"scEditUId":null,"scEditUName":null},{"scId":"603385822347005952","cpId":"601228071437078528","cpName":"aaa第一章","lsName":"","scName":"AAA","scAttachedType":null,"scContent":"FFF","scIsAttached":false,"scAttachPath":"","scCreateTime":"2019-01-17 16:14:45.0","scCreateUId":"20181248699","scCreateUName":"admin","scEditTime":"2019-01-17 17:20:41.0","scEditUId":"20181248699","scEditUName":"admin"}]
             */

            private ChapterBean chapter;
            private List<SectionsBean> sections;

            public ChapterBean getChapter() {
                return chapter;
            }

            public void setChapter(ChapterBean chapter) {
                this.chapter = chapter;
            }

            public List<SectionsBean> getSections() {
                return sections;
            }

            public void setSections(List<SectionsBean> sections) {
                this.sections = sections;
            }

            public static class ChapterBean {
                /**
                 * cpId : 601228071437078528
                 * lsName : aaa
                 * lsId : 601141517284806656
                 * cpName : aaa第一章
                 * cpDscb : aa
                 * cpCreateUId : 20181248699
                 * cpCreateUName : admin
                 * cpCreateTime : 2019-01-11 17:20:37.0
                 * cpEditTime : 2019-01-14 13:03:21.0
                 * cpEditUId : 20181248699
                 * cpEditUName : admin
                 */

                private String cpId;
                private String lsName;
                private String lsId;
                private String cpName;
                private String cpDscb;
                private String cpCreateUId;
                private String cpCreateUName;
                private String cpCreateTime;
                private String cpEditTime;
                private String cpEditUId;
                private String cpEditUName;

                public String getCpId() {
                    return cpId;
                }

                public void setCpId(String cpId) {
                    this.cpId = cpId;
                }

                public String getLsName() {
                    return lsName;
                }

                public void setLsName(String lsName) {
                    this.lsName = lsName;
                }

                public String getLsId() {
                    return lsId;
                }

                public void setLsId(String lsId) {
                    this.lsId = lsId;
                }

                public String getCpName() {
                    return cpName;
                }

                public void setCpName(String cpName) {
                    this.cpName = cpName;
                }

                public String getCpDscb() {
                    return cpDscb;
                }

                public void setCpDscb(String cpDscb) {
                    this.cpDscb = cpDscb;
                }

                public String getCpCreateUId() {
                    return cpCreateUId;
                }

                public void setCpCreateUId(String cpCreateUId) {
                    this.cpCreateUId = cpCreateUId;
                }

                public String getCpCreateUName() {
                    return cpCreateUName;
                }

                public void setCpCreateUName(String cpCreateUName) {
                    this.cpCreateUName = cpCreateUName;
                }

                public String getCpCreateTime() {
                    return cpCreateTime;
                }

                public void setCpCreateTime(String cpCreateTime) {
                    this.cpCreateTime = cpCreateTime;
                }

                public String getCpEditTime() {
                    return cpEditTime;
                }

                public void setCpEditTime(String cpEditTime) {
                    this.cpEditTime = cpEditTime;
                }

                public String getCpEditUId() {
                    return cpEditUId;
                }

                public void setCpEditUId(String cpEditUId) {
                    this.cpEditUId = cpEditUId;
                }

                public String getCpEditUName() {
                    return cpEditUName;
                }

                public void setCpEditUName(String cpEditUName) {
                    this.cpEditUName = cpEditUName;
                }
            }

            public static class SectionsBean {
                /**
                 * scId : 601534271298998272
                 * cpId : 601228071437078528
                 * cpName : 范德萨发
                 * lsName :
                 * scName : 请问请问
                 * scAttachedType : null
                 * scContent :
                 * scIsAttached : false
                 * scAttachPath :
                 * scCreateTime : 2019-01-12 13:37:21.0
                 * scCreateUId : 20181248699
                 * scCreateUName : admin
                 * scEditTime : null
                 * scEditUId : null
                 * scEditUName : null
                 */

                private String scId;
                private String cpId;
                private String cpName;
                private String lsName;
                private String scName;
                private Object scAttachedType;
                private String scContent;
                private boolean scIsAttached;
                private String scAttachPath;
                private String scCreateTime;
                private String scCreateUId;
                private String scCreateUName;
                private Object scEditTime;
                private Object scEditUId;
                private Object scEditUName;

                public String getScId() {
                    return scId;
                }

                public void setScId(String scId) {
                    this.scId = scId;
                }

                public String getCpId() {
                    return cpId;
                }

                public void setCpId(String cpId) {
                    this.cpId = cpId;
                }

                public String getCpName() {
                    return cpName;
                }

                public void setCpName(String cpName) {
                    this.cpName = cpName;
                }

                public String getLsName() {
                    return lsName;
                }

                public void setLsName(String lsName) {
                    this.lsName = lsName;
                }

                public String getScName() {
                    return scName;
                }

                public void setScName(String scName) {
                    this.scName = scName;
                }

                public Object getScAttachedType() {
                    return scAttachedType;
                }

                public void setScAttachedType(Object scAttachedType) {
                    this.scAttachedType = scAttachedType;
                }

                public String getScContent() {
                    return scContent;
                }

                public void setScContent(String scContent) {
                    this.scContent = scContent;
                }

                public boolean isScIsAttached() {
                    return scIsAttached;
                }

                public void setScIsAttached(boolean scIsAttached) {
                    this.scIsAttached = scIsAttached;
                }

                public String getScAttachPath() {
                    return scAttachPath;
                }

                public void setScAttachPath(String scAttachPath) {
                    this.scAttachPath = scAttachPath;
                }

                public String getScCreateTime() {
                    return scCreateTime;
                }

                public void setScCreateTime(String scCreateTime) {
                    this.scCreateTime = scCreateTime;
                }

                public String getScCreateUId() {
                    return scCreateUId;
                }

                public void setScCreateUId(String scCreateUId) {
                    this.scCreateUId = scCreateUId;
                }

                public String getScCreateUName() {
                    return scCreateUName;
                }

                public void setScCreateUName(String scCreateUName) {
                    this.scCreateUName = scCreateUName;
                }

                public Object getScEditTime() {
                    return scEditTime;
                }

                public void setScEditTime(Object scEditTime) {
                    this.scEditTime = scEditTime;
                }

                public Object getScEditUId() {
                    return scEditUId;
                }

                public void setScEditUId(Object scEditUId) {
                    this.scEditUId = scEditUId;
                }

                public Object getScEditUName() {
                    return scEditUName;
                }

                public void setScEditUName(Object scEditUName) {
                    this.scEditUName = scEditUName;
                }
            }
        }
    }
}
