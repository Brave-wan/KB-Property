package com.kangbao.jkwy.kangbao.bean;

public class OrderNoBean {


    /**
     * data : {"tradeNo":"jkwy20190403165314550"}
     * pageInfo : {"currentPage":0,"order":"asc","pageSize":20,"total":0,"totalPage":0}
     * errmsg : 成功
     * errcode : 1
     */

    private DataBean data;
    private String pageInfo;
    private String errmsg;
    private String errcode;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
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
         * tradeNo : jkwy20190403165314550
         */

        private String tradeNo;

        public String getTradeNo() {
            return tradeNo;
        }

        public void setTradeNo(String tradeNo) {
            this.tradeNo = tradeNo;
        }
    }
}
