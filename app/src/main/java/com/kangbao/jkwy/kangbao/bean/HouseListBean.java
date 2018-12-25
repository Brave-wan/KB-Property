package com.kangbao.jkwy.kangbao.bean;

import java.util.List;

public class HouseListBean {

    /**
     * data : {"buildList":[{"id":1535079324233327,"unitId":null,"houseNum":"0","projectName":"深圳·金科智慧城","projectId":"38e70023-9bb1-4874-855f-6f46ac61fff8","unitName":null,"buildName":"1栋","buildId":"5574f0dd-12a9-4d8e-9c7d-a73f00f94aa3"},{"id":1535079324234089,"unitId":null,"houseNum":"0","projectName":"深圳·金科智慧城","projectId":"38e70023-9bb1-4874-855f-6f46ac61fff8","unitName":null,"buildName":"6","buildId":"b651f5b5-e4fd-49f6-a163-8fb9960c6dec"},{"id":1535079324235509,"unitId":null,"houseNum":"0","projectName":"深圳·金科智慧城","projectId":"38e70023-9bb1-4874-855f-6f46ac61fff8","unitName":null,"buildName":"7栋","buildId":"90a07211-4625-47a8-b6b7-171777dc26ac"},{"id":1535079324236539,"unitId":null,"houseNum":"100","projectName":"深圳·金科智慧城","projectId":"38e70023-9bb1-4874-855f-6f46ac61fff8","unitName":null,"buildName":"8栋","buildId":"c1d48d76-16b2-489b-9508-a73600b0b65b"},{"id":1535079324237643,"unitId":null,"houseNum":"0","projectName":"深圳·金科智慧城","projectId":"38e70023-9bb1-4874-855f-6f46ac61fff8","unitName":null,"buildName":"9栋","buildId":"bde10e7e-79c3-426e-883f-a73e009d82ee"},{"id":1535079324238284,"unitId":null,"houseNum":"0","projectName":"深圳·金科智慧城","projectId":"38e70023-9bb1-4874-855f-6f46ac61fff8","unitName":null,"buildName":"JK-service","buildId":"cf7a8226-6b63-4638-99a3-a6a400f51478"},{"id":1535079324239060,"unitId":null,"houseNum":"0","projectName":"深圳·金科智慧城","projectId":"38e70023-9bb1-4874-855f-6f46ac61fff8","unitName":null,"buildName":"物业","buildId":"0d98ea0c-470e-4570-be91-a8a500f593c4"},{"id":1535079324240918,"unitId":null,"houseNum":"0","projectName":"深圳·金科智慧城","projectId":"38e70023-9bb1-4874-855f-6f46ac61fff8","unitName":null,"buildName":"物业","buildId":"cb62130f-9ea7-4f0d-bc46-d7dccc10bf18"},{"id":1535079324241533,"unitId":null,"houseNum":"0","projectName":"深圳·金科智慧城","projectId":"38e70023-9bb1-4874-855f-6f46ac61fff8","unitName":null,"buildName":"科技中心楼栋","buildId":"c806c8ee-748e-416a-aa5a-bca0d96c3ecb"}]}
     * errcode : 200
     * errmsg : 操作成功
     * pageInfo : {"currentPage":1,"order":"asc","pageSize":1,"total":9,"totalPage":9}
     */

    private DataBean data;
    private String errcode;
    private String errmsg;
    private String pageInfo;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

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

    public static class DataBean {
        private List<HouseArrearsListBean> houseArrearsList;

        public List<HouseArrearsListBean> getHouseArrearsList() {
            return houseArrearsList;
        }

        public void setHouseArrearsList(List<HouseArrearsListBean> houseArrearsList) {
            this.houseArrearsList = houseArrearsList;
        }

        public static class HouseArrearsListBean {
            /**
             * arrearageTotal : 489.60
             * houseName : 7-3-201
             * houseId : 2fe58ed0-6adb-465f-911e-09c5ffcea01e
             */

            private String arrearageTotal;
            private String houseName;
            private String houseId;

            public String getArrearageTotal() {
                return arrearageTotal;
            }

            public void setArrearageTotal(String arrearageTotal) {
                this.arrearageTotal = arrearageTotal;
            }

            public String getHouseName() {
                return houseName;
            }

            public void setHouseName(String houseName) {
                this.houseName = houseName;
            }

            public String getHouseId() {
                return houseId;
            }

            public void setHouseId(String houseId) {
                this.houseId = houseId;
            }
        }
    }
}
