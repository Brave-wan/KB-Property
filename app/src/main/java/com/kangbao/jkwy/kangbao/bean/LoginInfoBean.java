package com.kangbao.jkwy.kangbao.bean;

import java.util.List;

public class LoginInfoBean {

    /**
     * total : 0
     * data : {"kbUser":[{"id":1545380880974,"nickName":"人和康宝一号","projectId":"171","passWord":"695079","projectName":"人和政府项目","loginAcct":"grewrq341"}]}
     * sessionId :
     * userId :
     * errcode : 1
     * pageInfo : {"currentPage":0,"order":"asc","pageSize":20,"total":0,"totalPage":0}
     * errmsg : 成功
     */

    private int total;
    private DataBean data;
    private String sessionId;
    private String userId;
    private String errcode;
    private String pageInfo;
    private String errmsg;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getErrcode() {
        return errcode;
    }

    public void setErrcode(String errcode) {
        this.errcode = errcode;
    }

    public String getPageInfo() {
        return pageInfo;
    }

    public void setPageInfo(String pageInfo) {
        this.pageInfo = pageInfo;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }

    public static class DataBean {
        private List<KbUserBean> kbUser;

        public List<KbUserBean> getKbUser() {
            return kbUser;
        }

        public void setKbUser(List<KbUserBean> kbUser) {
            this.kbUser = kbUser;
        }

        public static class KbUserBean {
            /**
             * id : 1545380880974
             * nickName : 人和康宝一号
             * projectId : 171
             * passWord : 695079
             * projectName : 人和政府项目
             * loginAcct : grewrq341
             */

            private long id;
            private String nickName;
            private String projectId;
            private String passWord;
            private String projectName;
            private String loginAcct;

            public long getId() {
                return id;
            }

            public void setId(long id) {
                this.id = id;
            }

            public String getNickName() {
                return nickName;
            }

            public void setNickName(String nickName) {
                this.nickName = nickName;
            }

            public String getProjectId() {
                return projectId;
            }

            public void setProjectId(String projectId) {
                this.projectId = projectId;
            }

            public String getPassWord() {
                return passWord;
            }

            public void setPassWord(String passWord) {
                this.passWord = passWord;
            }

            public String getProjectName() {
                return projectName;
            }

            public void setProjectName(String projectName) {
                this.projectName = projectName;
            }

            public String getLoginAcct() {
                return loginAcct;
            }

            public void setLoginAcct(String loginAcct) {
                this.loginAcct = loginAcct;
            }
        }
    }
}
