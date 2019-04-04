package com.kangbao.jkwy.kangbao.bean;

import java.util.List;

public class HouseListYuBean {


    /**
     * data : {"listData":[{"houseId":"01d1d870-07d9-4d34-8551-3937bc70ffab","buildName":"01","address":"重庆市涪陵区崇义街道办事处","ownerName":"罗素碧","houseType":"高层","houseNo":"01-2-2803","buildId":"317a474f-b7b1-4cf6-a141-05893aca848a","company":"涪陵城区-10303","projectName":"涪陵·黄金海岸","projectId":"c3513085-97b9-4b3b-bd6b-0303c83e3886"},{"houseId":"01d1d870-07d9-4d34-8551-3937bc70ffab","buildName":"01","address":"重庆市涪陵区崇义街道办事处","ownerName":"覃建新","houseType":"高层","houseNo":"01-2-2803","buildId":"317a474f-b7b1-4cf6-a141-05893aca848a","company":"涪陵城区-10303","projectName":"涪陵·黄金海岸","projectId":"c3513085-97b9-4b3b-bd6b-0303c83e3886"},{"houseId":"01d1d870-07d9-4d34-8551-3937bc70ffab","buildName":"01","address":"重庆市涪陵区崇义街道办事处","ownerName":"罗素碧","houseType":"高层","houseNo":"01-2-2803","buildId":"317a474f-b7b1-4cf6-a141-05893aca848a","company":"涪陵城区-10303","projectName":"涪陵·黄金海岸","projectId":"c3513085-97b9-4b3b-bd6b-0303c83e3886"},{"houseId":"01d1d870-07d9-4d34-8551-3937bc70ffab","buildName":"01","address":"重庆市涪陵区崇义街道办事处","ownerName":"覃建新","houseType":"高层","houseNo":"01-2-2803","buildId":"317a474f-b7b1-4cf6-a141-05893aca848a","company":"涪陵城区-10303","projectName":"涪陵·黄金海岸","projectId":"c3513085-97b9-4b3b-bd6b-0303c83e3886"},{"houseId":"0204e7b5-ce96-4481-bbf9-c22ef1d3d5be","buildName":"01","address":"重庆市涪陵区崇义街道办事处","ownerName":"邹锡敏","houseType":"高层","houseNo":"01-1-506","buildId":"317a474f-b7b1-4cf6-a141-05893aca848a","company":"涪陵城区-10303","projectName":"涪陵·黄金海岸","projectId":"c3513085-97b9-4b3b-bd6b-0303c83e3886"},{"houseId":"0259fb8a-2c54-420e-93ce-873c71bf8aaf","buildName":"01","address":"重庆市涪陵区崇义街道办事处","ownerName":"高瑜","houseType":"高层","houseNo":"01-1-1403","buildId":"317a474f-b7b1-4cf6-a141-05893aca848a","company":"涪陵城区-10303","projectName":"涪陵·黄金海岸","projectId":"c3513085-97b9-4b3b-bd6b-0303c83e3886"},{"houseId":"0259fb8a-2c54-420e-93ce-873c71bf8aaf","buildName":"01","address":"重庆市涪陵区崇义街道办事处","ownerName":"杜明红","houseType":"高层","houseNo":"01-1-1403","buildId":"317a474f-b7b1-4cf6-a141-05893aca848a","company":"涪陵城区-10303","projectName":"涪陵·黄金海岸","projectId":"c3513085-97b9-4b3b-bd6b-0303c83e3886"},{"houseId":"0259fb8a-2c54-420e-93ce-873c71bf8aaf","buildName":"01","address":"重庆市涪陵区崇义街道办事处","ownerName":"高瑜","houseType":"高层","houseNo":"01-1-1403","buildId":"317a474f-b7b1-4cf6-a141-05893aca848a","company":"涪陵城区-10303","projectName":"涪陵·黄金海岸","projectId":"c3513085-97b9-4b3b-bd6b-0303c83e3886"},{"houseId":"03240ba3-7a6e-446c-a775-627da0a965d6","buildName":"01","address":"重庆市涪陵区崇义街道办事处","ownerName":"符利娟","houseType":"高层","houseNo":"01-2-503","buildId":"317a474f-b7b1-4cf6-a141-05893aca848a","company":"涪陵城区-10303","projectName":"涪陵·黄金海岸","projectId":"c3513085-97b9-4b3b-bd6b-0303c83e3886"},{"houseId":"047d2de9-fa80-408f-9a7b-c0dd7b874ab9","buildName":"01","address":"重庆市涪陵区崇义街道办事处","ownerName":"石沁灵","houseType":"高层","houseNo":"01-2-501","buildId":"317a474f-b7b1-4cf6-a141-05893aca848a","company":"涪陵城区-10303","projectName":"涪陵·黄金海岸","projectId":"c3513085-97b9-4b3b-bd6b-0303c83e3886"}]}
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
        private List<ListDataBean> listData;

        public List<ListDataBean> getListData() {
            return listData;
        }

        public void setListData(List<ListDataBean> listData) {
            this.listData = listData;
        }

        public static class ListDataBean {
            /**
             * houseId : 01d1d870-07d9-4d34-8551-3937bc70ffab
             * buildName : 01
             * address : 重庆市涪陵区崇义街道办事处
             * ownerName : 罗素碧
             * houseType : 高层
             * houseNo : 01-2-2803
             * buildId : 317a474f-b7b1-4cf6-a141-05893aca848a
             * company : 涪陵城区-10303
             * projectName : 涪陵·黄金海岸
             * projectId : c3513085-97b9-4b3b-bd6b-0303c83e3886
             */

            private String houseId;
            private String buildName;
            private String address;
            private String ownerPhone;
            private String ownerName;
            private String houseType;
            private String houseNo;
            private String buildId;
            private String company;
            private String projectName;
            private String projectId;

            public void setOwnerPhone(String ownerPhone) {
                this.ownerPhone = ownerPhone;
            }

            public String getOwnerPhone() {
                return ownerPhone;
            }

            public String getHouseId() {
                return houseId;
            }

            public void setHouseId(String houseId) {
                this.houseId = houseId;
            }

            public String getBuildName() {
                return buildName;
            }

            public void setBuildName(String buildName) {
                this.buildName = buildName;
            }

            public String getAddress() {
                return address;
            }

            public void setAddress(String address) {
                this.address = address;
            }

            public String getOwnerName() {
                return ownerName;
            }

            public void setOwnerName(String ownerName) {
                this.ownerName = ownerName;
            }

            public String getHouseType() {
                return houseType;
            }

            public void setHouseType(String houseType) {
                this.houseType = houseType;
            }

            public String getHouseNo() {
                return houseNo;
            }

            public void setHouseNo(String houseNo) {
                this.houseNo = houseNo;
            }

            public String getBuildId() {
                return buildId;
            }

            public void setBuildId(String buildId) {
                this.buildId = buildId;
            }

            public String getCompany() {
                return company;
            }

            public void setCompany(String company) {
                this.company = company;
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
        }
    }
}
