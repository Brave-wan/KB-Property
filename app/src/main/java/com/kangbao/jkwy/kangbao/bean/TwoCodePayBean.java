package com.kangbao.jkwy.kangbao.bean;

public class TwoCodePayBean {

    /**
     * data : {"code_url":"weixin://wxpay/bizpayurl?pr=tSGOCIz","out_trade_no":"fdstd112123981127","hy_bill_no":"1810111022524728518475001967"}
     * code : 200
     * message : 大管家收款二维码生成成功
     */

    private DataBean data;
    private String code;
    private String message;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public static class DataBean {
        /**
         * code_url : weixin://wxpay/bizpayurl?pr=tSGOCIz
         * out_trade_no : fdstd112123981127
         * hy_bill_no : 1810111022524728518475001967
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

