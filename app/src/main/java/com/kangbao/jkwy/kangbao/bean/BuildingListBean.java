package com.kangbao.jkwy.kangbao.bean;

import java.util.List;

public class BuildingListBean {

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
        private List<BuildListBean> buildList;

        public List<BuildListBean> getBuildList() {
            return buildList;
        }

        public void setBuildList(List<BuildListBean> buildList) {
            this.buildList = buildList;
        }

        public static class BuildListBean {
            /**
             * id : 1535079324233327
             * unitId : null
             * houseNum : 0
             * projectName : 深圳·金科智慧城
             * projectId : 38e70023-9bb1-4874-855f-6f46ac61fff8
             * unitName : null
             * buildName : 1栋
             * buildId : 5574f0dd-12a9-4d8e-9c7d-a73f00f94aa3
             */

            private long id;
            private Object unitId;
            private String houseNum;
            private String projectName;
            private String projectId;
            private Object unitName;
            private String buildName;
            private String buildId;

            public long getId() {
                return id;
            }

            public void setId(long id) {
                this.id = id;
            }

            public Object getUnitId() {
                return unitId;
            }

            public void setUnitId(Object unitId) {
                this.unitId = unitId;
            }

            public String getHouseNum() {
                return houseNum;
            }

            public void setHouseNum(String houseNum) {
                this.houseNum = houseNum;
            }

            public String getProjectName() {
                return projectName;
            }

            public void setProjectName(String projectName) {
                this.projectName = projectName;
            }

            public String getProjectId() {
                return projectId;
            }

            public void setProjectId(String projectId) {
                this.projectId = projectId;
            }

            public Object getUnitName() {
                return unitName;
            }

            public void setUnitName(Object unitName) {
                this.unitName = unitName;
            }

            public String getBuildName() {
                return buildName;
            }

            public void setBuildName(String buildName) {
                this.buildName = buildName;
            }

            public String getBuildId() {
                return buildId;
            }

            public void setBuildId(String buildId) {
                this.buildId = buildId;
            }
        }
    }
}
