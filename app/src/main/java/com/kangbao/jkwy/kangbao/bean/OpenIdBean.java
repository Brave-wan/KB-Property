package com.kangbao.jkwy.kangbao.bean;

import java.io.Serializable;

/**
 * function: 平台验证获取openId
 * author: hank
 * date: 2017/8/1
 */

public class OpenIdBean implements Serializable {

    /**
     * total : 0
     * data : {"openId":"1536906026844","phone":"13111111111"}
     * sessionId : 2072c96c2daf4aef94a27f2b686fd50e
     * userId : 1502360241888
     * pageInfo : {"currentPage":0,"order":"asc","pageSize":20,"total":0,"totalPage":0}
     * errmsg : 成功
     * errcode : 1
     */

    private int total;
    private DataBean data;
    private String sessionId;
    private String userId;
    private String pageInfo;
    private String errmsg;
    private String errcode;

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

    public String getErrcode() {
        return errcode;
    }

    public void setErrcode(String errcode) {
        this.errcode = errcode;
    }

    public static class DataBean {
        /**
         * openId : 1536906026844
         * phone : 13111111111
         */

        private String openId;
        private String phone;

        public String getOpenId() {
            return openId;
        }

        public void setOpenId(String openId) {
            this.openId = openId;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }
    }
}
