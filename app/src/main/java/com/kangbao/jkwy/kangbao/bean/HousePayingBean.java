package com.kangbao.jkwy.kangbao.bean;

public class HousePayingBean {

    /**
     * errcode : 200
     * errmsg : 操作成功
     * pageInfo : {"currentPage":1,"order":"asc","pageSize":1,"total":9,"totalPage":9}
     * data : {}
     */

    private String errcode;
    private String errmsg;
    private String pageInfo;
    private DataBean data;

    public String getErrcode() {
        return errcode;
    }

    public void setErrcode(String errcode) {
        this.errcode = errcode;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }

    public String getPageInfo() {
        return pageInfo;
    }

    public void setPageInfo(String pageInfo) {
        this.pageInfo = pageInfo;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
    }
}
