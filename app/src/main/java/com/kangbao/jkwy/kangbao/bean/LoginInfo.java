package com.kangbao.jkwy.kangbao.bean;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class LoginInfo {
    /**
     * total : 0
     * data : {"kbUser":[{"id":1545380880974,"nickName":"人和康宝一号","projectId":"171","passWord":"695079","projectName":"人和政府项目","loginAcct":"grewrq341"}]}
     * sessionId :
     * userId :
     * errcode : 1
     * pageInfo : {"currentPage":0,"order":"asc","pageSize":20,"total":0,"totalPage":0}
     * errmsg : 成功
     */

    private DataBean data;
    private int total;
    private String sessionId;
    private String userId;
    private String errcode;
    private String pageInfo;
    private String errmsg;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
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

    public String getErrcode() {
        return errcode;
    }

    public void setErrcode(String errcode) {
        this.errcode = errcode;
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

    public static class DataBean {
        /**
         * userId : 1490060633984
         * sessionId : dcadd96abe6f4534988d505620d27805
         * username : cq04
         * name : 韩斌
         * mobile : 13667629670
         * power : -1
         * type : 0
         * roleType : 1
         * roles : [{"roleCode":1471828189174,"roleName":"公司总部领导"},{"roleCode":1470919027857,"roleName":"公司总部负责人"},{"roleCode":1477453625547,"roleName":"公司总部物管中心"},{"roleCode":1477453625550,"roleName":"公司总部接管中心"}]
         * organization : [{"orgCode":"0","orgName":"金科物业服务有限公司","type":"0"}]
         * organization2 : {"orgCode":"6","orgName":"北京廊桥水岸"}
         * deptName : 工程管理
         * commpany : 金科物业服务有限公司
         * fenCompany :
         * sex : 男
         * position :
         */


        private long userId;
        private String sessionId;
        private String username;
        private String name;
        private String mobile;
        private String power;
        private String type;
        private String roleType;
        private Organization2Bean organization2;
        private String deptName;
        private String commpany;
        private String fenCompany;
        private String sex;
        private String position;
        private List<RolesBean> roles;
        private List<OrganizationBean> organization;
        private String roleName;
        private List<AppListBean> appList;


        public void setRoleName(String roleName) {
            this.roleName = roleName;
        }

        public String getRoleName() {
            return roleName;
        }

        public long getUserId() {
            return userId;
        }

        public void setUserId(long userId) {
            this.userId = userId;
        }

        public String getSessionId() {
            return sessionId;
        }

        public void setSessionId(String sessionId) {
            this.sessionId = sessionId;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getMobile() {
            return mobile;
        }

        public void setMobile(String mobile) {
            this.mobile = mobile;
        }

        public String getPower() {
            return power;
        }

        public void setPower(String power) {
            this.power = power;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getRoleType() {
            return roleType;
        }

        public void setRoleType(String roleType) {
            this.roleType = roleType;
        }

        public Organization2Bean getOrganization2() {
            return organization2;
        }

        public void setOrganization2(Organization2Bean organization2) {
            this.organization2 = organization2;
        }

        public String getDeptName() {
            return deptName;
        }

        public void setDeptName(String deptName) {
            this.deptName = deptName;
        }

        public String getCommpany() {
            return commpany;
        }

        public void setCommpany(String commpany) {
            this.commpany = commpany;
        }

        public String getFenCompany() {
            return fenCompany;
        }

        public void setFenCompany(String fenCompany) {
            this.fenCompany = fenCompany;
        }

        public String getSex() {
            return sex;
        }

        public void setSex(String sex) {
            this.sex = sex;
        }

        public String getPosition() {
            return position;
        }

        public void setPosition(String position) {
            this.position = position;
        }

        public List<RolesBean> getRoles() {
            return roles;
        }

        public void setRoles(List<RolesBean> roles) {
            this.roles = roles;
        }

        public List<OrganizationBean> getOrganization() {
            return organization;
        }

        public void setOrganization(List<OrganizationBean> organization) {
            this.organization = organization;
        }

        public List<AppListBean> getAppList() {
            return appList;
        }

        public void setAppList(List<AppListBean> appList) {
            this.appList = appList;
        }

        public static class Organization2Bean implements Serializable {
            /**
             * orgCode : 6
             * orgName : 北京廊桥水岸
             */

            private String orgCode;
            private String orgName;

            public String getOrgCode() {
                return orgCode;
            }

            public void setOrgCode(String orgCode) {
                this.orgCode = orgCode;
            }

            public String getOrgName() {
                return orgName;
            }

            public void setOrgName(String orgName) {
                this.orgName = orgName;
            }
        }

        public static class RolesBean implements Serializable {
            /**
             * roleCode : 1471828189174
             * roleName : 公司总部领导
             */

            private long roleCode;
            private String roleName;

            public long getRoleCode() {
                return roleCode;
            }

            public void setRoleCode(long roleCode) {
                this.roleCode = roleCode;
            }

            public String getRoleName() {
                return roleName;
            }

            public void setRoleName(String roleName) {
                this.roleName = roleName;
            }
        }

        public static class OrganizationBean implements Serializable {
            /**
             * orgCode : 0
             * orgName : 金科物业服务有限公司
             * type : 0
             */

            private String orgCode;
            private String orgName;
            private String type;

            public String getOrgCode() {
                return orgCode;
            }

            public void setOrgCode(String orgCode) {
                this.orgCode = orgCode;
            }

            public String getOrgName() {
                return orgName;
            }

            public void setOrgName(String orgName) {
                this.orgName = orgName;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }
        }

        public static class AppListBean implements Serializable {
            /**
             * id : 1433211
             * parent : 系统管理
             * img :
             * src :
             * plateCode :
             * childList : [{"id":"1","name":"菜单管理","img":"https://staticfile.tq-service.com/image/QualitySystem/20180117/ddad7089755b434fadafdd44868d7380.jpg","src":"http://dev-oa.tq-service.com/device/menu/menuList","plateCode":"","childList":[{"id":"1","name":"菜单管理","img":"https://staticfile.tq-service.com/image/QualitySystem/20180117/ddad7089755b434fadafdd44868d7380.jpg","src":"http://dev-oa.tq-service.com/device/menu/menuList","plateCode":""}]},{"id":"1481767485905","name":"待审核用户管理","img":"","src":"/user/checkUserList","plateCode":"","childList":[]},{"id":"1431328054196","name":"日志管理","img":"","src":"/log/logList","plateCode":"","childList":[]},{"id":"1431328054216","name":"项目管理","img":"","src":"/organ/main","plateCode":"","childList":[]}]
             */

            private String id;
            private String parent;
            private String img;
            private String src;
            private String plateCode;
            private List<ChildListBeanX> childList;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getParent() {
                return parent;
            }

            public void setParent(String parent) {
                this.parent = parent;
            }

            public String getImg() {
                return img;
            }

            public void setImg(String img) {
                this.img = img;
            }

            public String getSrc() {
                return src;
            }

            public void setSrc(String src) {
                this.src = src;
            }

            public String getPlateCode() {
                return plateCode;
            }

            public void setPlateCode(String plateCode) {
                this.plateCode = plateCode;
            }

            public List<ChildListBeanX> getChildList() {
                return childList;
            }

            public void setChildList(List<ChildListBeanX> childList) {
                this.childList = childList;
            }

            public static class ChildListBeanX implements Serializable {
                /**
                 * id : 1
                 * name : 菜单管理
                 * img : https://staticfile.tq-service.com/image/QualitySystem/20180117/ddad7089755b434fadafdd44868d7380.jpg
                 * src : http://dev-oa.tq-service.com/device/menu/menuList
                 * plateCode :
                 * childList : [{"id":"1","name":"菜单管理","img":"https://staticfile.tq-service.com/image/QualitySystem/20180117/ddad7089755b434fadafdd44868d7380.jpg","src":"http://dev-oa.tq-service.com/device/menu/menuList","plateCode":""}]
                 */

                private String id;
                @SerializedName("name")
                private String nameX;
                private String img;
                private String src;
                private String plateCode;
                private List<ChildListBean> childList;

                public String getId() {
                    return id;
                }

                public void setId(String id) {
                    this.id = id;
                }

                public String getNameX() {
                    return nameX;
                }

                public void setNameX(String nameX) {
                    this.nameX = nameX;
                }

                public String getImg() {
                    return img;
                }

                public void setImg(String img) {
                    this.img = img;
                }

                public String getSrc() {
                    return src;
                }

                public void setSrc(String src) {
                    this.src = src;
                }

                public String getPlateCode() {
                    return plateCode;
                }

                public void setPlateCode(String plateCode) {
                    this.plateCode = plateCode;
                }

                public List<ChildListBean> getChildList() {
                    return childList;
                }

                public void setChildList(List<ChildListBean> childList) {
                    this.childList = childList;
                }

                public static class ChildListBean implements Serializable {
                    /**
                     * id : 1
                     * name : 菜单管理
                     * img : https://staticfile.tq-service.com/image/QualitySystem/20180117/ddad7089755b434fadafdd44868d7380.jpg
                     * src : http://dev-oa.tq-service.com/device/menu/menuList
                     * plateCode :
                     */

                    private String id;
                    @SerializedName("name")
                    private String nameX;
                    private String img;
                    private String src;
                    private String plateCode;

                    public String getId() {
                        return id;
                    }

                    public void setId(String id) {
                        this.id = id;
                    }

                    public String getNameX() {
                        return nameX;
                    }

                    public void setNameX(String nameX) {
                        this.nameX = nameX;
                    }

                    public String getImg() {
                        return img;
                    }

                    public void setImg(String img) {
                        this.img = img;
                    }

                    public String getSrc() {
                        return src;
                    }

                    public void setSrc(String src) {
                        this.src = src;
                    }

                    public String getPlateCode() {
                        return plateCode;
                    }

                    public void setPlateCode(String plateCode) {
                        this.plateCode = plateCode;
                    }
                }
            }
        }
    }
}
