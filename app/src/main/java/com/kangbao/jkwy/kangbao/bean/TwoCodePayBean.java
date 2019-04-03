package com.kangbao.jkwy.kangbao.bean;

public class TwoCodePayBean {


    /**
     * data : {"code_url":"weixin://wxpay/bizpayurl?pr=LDdzDxq","out_trade_no":"jkwy20190403172016242","hy_bill_no":"1904031720776929518475001145"}
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
         * code_url : weixin://wxpay/bizpayurl?pr=LDdzDxq
         * out_trade_no : jkwy20190403172016242
         * hy_bill_no : 1904031720776929518475001145
         */

        private String code_url;
        private String out_trade_no;
        private String hy_bill_no;

        public String getCode_url() {
            return code_url;
        }

        public void setCode_url(String code_url) {
            this.code_url = code_url;
        }

        public String getOut_trade_no() {
            return out_trade_no;
        }

        public void setOut_trade_no(String out_trade_no) {
            this.out_trade_no = out_trade_no;
        }

        public String getHy_bill_no() {
            return hy_bill_no;
        }

        public void setHy_bill_no(String hy_bill_no) {
            this.hy_bill_no = hy_bill_no;
        }
    }
}

