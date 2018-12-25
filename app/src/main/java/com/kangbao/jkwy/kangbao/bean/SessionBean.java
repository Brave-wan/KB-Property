package com.kangbao.jkwy.kangbao.bean;

/**
 * Created by root on 18-4-26.
 */

public class SessionBean {


    /**
     * data : {"sessionId":"e76d38b0c9a94e8d9c18c67fca508792","staffName":"hanbin","ifManage":"1"}
     * errmsg : 成功
     * errcode : 1
     * pageInfo : {"currentPage":0,"order":"asc","pageSize":20,"total":0,"totalPage":0}
     */

    private DataBean data;
    private String errmsg;
    private String errcode;
    private String pageInfo;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
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

    public static class DataBean {
        /**
         * sessionId : e76d38b0c9a94e8d9c18c67fca508792
         * staffName : hanbin
         * ifManage : 1
         */

        private String sessionId;
        private String staffName;
        private String ifManage;

        public String getSessionId() {
            return sessionId;
        }

        public void setSessionId(String sessionId) {
            this.sessionId = sessionId;
        }

        public String getStaffName() {
            return staffName;
        }

        public void setStaffName(String staffName) {
            this.staffName = staffName;
        }

        public String getIfManage() {
            return ifManage;
        }

        public void setIfManage(String ifManage) {
            this.ifManage = ifManage;
        }
    }
}
