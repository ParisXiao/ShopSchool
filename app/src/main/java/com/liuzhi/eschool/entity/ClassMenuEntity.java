package com.liuzhi.eschool.entity;

import java.util.List;

public class ClassMenuEntity {

    /**
     * code : 0
     * msg : 操作成功
     * data : {"flag":true,"lesson":[{"chapter":{"cpId":"601228071437078528","lsName":"aaa","lsId":"601141517284806656","cpName":"aaa第一章","cpDscb":"aa","cpCreateUId":"20181248699","cpCreateUName":"admin","cpCreateTime":"2019-01-11 17:20:37.0","cpEditTime":"2019-01-14 13:03:21.0","cpEditUId":"20181248699","cpEditUName":"admin"},"sections":[{"scId":"601534271298998272","cpId":"601228071437078528","cpName":"范德萨发","lsName":"","scName":"请问请问","scAttachedType":null,"scContent":"","scIsAttached":false,"scAttachPath":"","scCreateTime":"2019-01-12 13:37:21.0","scCreateUId":"20181248699","scCreateUName":"admin","scEditTime":null,"scEditUId":null,"scEditUName":null},{"scId":"602224610930331648","cpId":"601228071437078528","cpName":"范德萨发","lsName":"","scName":"发发发","scAttachedType":null,"scContent":"","scIsAttached":true,"scAttachPath":"/static/upload/lesson/attached/1547436030710.jpg /static/upload/lesson/attached/1547436030711.jpg /static/upload/lesson/attached/1547436030712.png ","scCreateTime":"2019-01-14 11:20:30.0","scCreateUId":"20181248699","scCreateUName":"admin","scEditTime":null,"scEditUId":null,"scEditUName":null},{"scId":"602261727903485952","cpId":"601228071437078528","cpName":"aaa第一章","lsName":"","scName":"小节1","scAttachedType":null,"scContent":"PDF测试","scIsAttached":true,"scAttachPath":"/static/upload/lesson/attached/1554357962814.pdf ","scCreateTime":"2019-01-14 13:48:00.0","scCreateUId":"20181248699","scCreateUName":"admin","scEditTime":"2019-04-04 14:06:02.0","scEditUId":"20181342745","scEditUName":"杜康"},{"scId":"602261803929440256","cpId":"601228071437078528","cpName":"aaa第一章","lsName":"","scName":"小节2","scAttachedType":null,"scContent":"视频测试","scIsAttached":true,"scAttachPath":"/static/upload/lesson/attached/1554357799826.mp4 ","scCreateTime":"2019-01-14 13:48:18.0","scCreateUId":"20181248699","scCreateUName":"admin","scEditTime":"2019-04-04 14:03:19.0","scEditUId":"20181342745","scEditUName":"杜康"},{"scId":"602261856089804800","cpId":"601228071437078528","cpName":"aaa第一章","lsName":"","scName":"小节三","scAttachedType":null,"scContent":"","scIsAttached":false,"scAttachPath":"","scCreateTime":"2019-01-14 13:48:30.0","scCreateUId":"20181248699","scCreateUName":"admin","scEditTime":"2019-01-14 16:58:27.0","scEditUId":"20181248699","scEditUName":"admin"},{"scId":"602309956791701504","cpId":"601228071437078528","cpName":"aaa第一章","lsName":"","scName":"发大水发","scAttachedType":null,"scContent":"","scIsAttached":false,"scAttachPath":"","scCreateTime":"2019-01-14 16:59:38.0","scCreateUId":"20181248699","scCreateUName":"admin","scEditTime":null,"scEditUId":null,"scEditUName":null},{"scId":"603385822347005952","cpId":"601228071437078528","cpName":"aaa第一章","lsName":"","scName":"AAA","scAttachedType":null,"scContent":"FFF","scIsAttached":false,"scAttachPath":"","scCreateTime":"2019-01-17 16:14:45.0","scCreateUId":"20181248699","scCreateUName":"admin","scEditTime":"2019-01-17 17:20:41.0","scEditUId":"20181248699","scEditUName":"admin"}]}]}
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
         */

        private boolean flag;
        private List<LessonBean> lesson;

        public boolean isFlag() {
            return flag;
        }

        public void setFlag(boolean flag) {
            this.flag = flag;
        }

        public List<LessonBean> getLesson() {
            return lesson;
        }

        public void setLesson(List<LessonBean> lesson) {
            this.lesson = lesson;
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
