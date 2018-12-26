package com.kangbao.jkwy.kangbao.bean;

import java.util.List;

public class ArrearsListBean {


    /**
     * data : {"projectId":"38e70023-9bb1-4874-855f-6f46ac61fff8","detailList":[{"amount":"0.01","mouth":"2019-10","typeList":[{"chargeId":"bc44964d-2590-4961-bff1-c621a18bc0fe","totalAmount":"0.01","chargeName":"高层物业服务费","thisAmount":"0.01"}]}],"houseNo":"1-1-101","buildId":"5574f0dd-12a9-4d8e-9c7d-a73f00f94aa3","ownerPhone":"15155120227","total":"0.01","houseId":"a596af19-2979-41cd-8691-a73f00fd4ed2","ownerName":"张春生","houseType":"高层","buildName":"1栋","projectName":"深圳·金科智慧城","company":"虚拟公司","adress":"广东省广东省深圳"}
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
        /**
         * projectId : 38e70023-9bb1-4874-855f-6f46ac61fff8
         * detailList : [{"amount":"0.01","mouth":"2019-10","typeList":[{"chargeId":"bc44964d-2590-4961-bff1-c621a18bc0fe","totalAmount":"0.01","chargeName":"高层物业服务费","thisAmount":"0.01"}]}]
         * houseNo : 1-1-101
         * buildId : 5574f0dd-12a9-4d8e-9c7d-a73f00f94aa3
         * ownerPhone : 15155120227
         * total : 0.01
         * houseId : a596af19-2979-41cd-8691-a73f00fd4ed2
         * ownerName : 张春生
         * houseType : 高层
         * buildName : 1栋
         * projectName : 深圳·金科智慧城
         * company : 虚拟公司
         * adress : 广东省广东省深圳
         */

        private String projectId;
        private String houseNo;
        private String buildId;
        private String ownerPhone;
        private String total;
        private String houseId;
        private String ownerName;
        private String houseType;
        private String buildName;
        private String projectName;
        private String company;
        private String adress;
        private List<DetailListBean> detailList;

        public String getProjectId() {
            return projectId;
        }

        public void setProjectId(String projectId) {
            this.projectId = projectId;
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

        public String getOwnerPhone() {
            return ownerPhone;
        }

        public void setOwnerPhone(String ownerPhone) {
            this.ownerPhone = ownerPhone;
        }

        public String getTotal() {
            return total;
        }

        public void setTotal(String total) {
            this.total = total;
        }

        public String getHouseId() {
            return houseId;
        }

        public void setHouseId(String houseId) {
            this.houseId = houseId;
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

        public String getBuildName() {
            return buildName;
        }

        public void setBuildName(String buildName) {
            this.buildName = buildName;
        }

        public String getProjectName() {
            return projectName;
        }

        public void setProjectName(String projectName) {
            this.projectName = projectName;
        }

        public String getCompany() {
            return company;
        }

        public void setCompany(String company) {
            this.company = company;
        }

        public String getAdress() {
            return adress;
        }

        public void setAdress(String adress) {
            this.adress = adress;
        }

        public List<DetailListBean> getDetailList() {
            return detailList;
        }

        public void setDetailList(List<DetailListBean> detailList) {
            this.detailList = detailList;
        }

        public static class DetailListBean {
            /**
             * amount : 0.01
             * mouth : 2019-10
             * typeList : [{"chargeId":"bc44964d-2590-4961-bff1-c621a18bc0fe","totalAmount":"0.01","chargeName":"高层物业服务费","thisAmount":"0.01"}]
             */

            private String amount;
            private String mouth;
            private List<TypeListBean> typeList;

            public String getAmount() {
                return amount;
            }

            public void setAmount(String amount) {
                this.amount = amount;
            }

            public String getMouth() {
                return mouth;
            }

            public void setMouth(String mouth) {
                this.mouth = mouth;
            }

            public List<TypeListBean> getTypeList() {
                return typeList;
            }

            public void setTypeList(List<TypeListBean> typeList) {
                this.typeList = typeList;
            }

            public static class TypeListBean {
                /**
                 * chargeId : bc44964d-2590-4961-bff1-c621a18bc0fe
                 * totalAmount : 0.01
                 * chargeName : 高层物业服务费
                 * thisAmount : 0.01
                 */

                private String chargeId;
                private String totalAmount;
                private String chargeName;
                private String thisAmount;

                public String getChargeId() {
                    return chargeId;
                }

                public void setChargeId(String chargeId) {
                    this.chargeId = chargeId;
                }

                public String getTotalAmount() {
                    return totalAmount;
                }

                public void setTotalAmount(String totalAmount) {
                    this.totalAmount = totalAmount;
                }

                public String getChargeName() {
                    return chargeName;
                }

                public void setChargeName(String chargeName) {
                    this.chargeName = chargeName;
                }

                public String getThisAmount() {
                    return thisAmount;
                }

                public void setThisAmount(String thisAmount) {
                    this.thisAmount = thisAmount;
                }
            }
        }
    }
}
