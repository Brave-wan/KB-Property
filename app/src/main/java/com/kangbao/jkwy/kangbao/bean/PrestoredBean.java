package com.kangbao.jkwy.kangbao.bean;

public class PrestoredBean {

    private String prepayId;
    private String amount;

    public PrestoredBean(String prepayId, String amount) {
        this.prepayId = prepayId;
        this.amount = amount;
    }


    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getAmount() {
        return amount;
    }

    public void setPrepayId(String prepayId) {
        this.prepayId = prepayId;
    }

    public String getPrepayId() {
        return prepayId;
    }
}
