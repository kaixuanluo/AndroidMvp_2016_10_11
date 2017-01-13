package com.example.admin.androidmvp_2016_10_11.module.response;

import com.example.admin.androidmvp_2016_10_11.common.module.BaseLoadingModule;
import com.example.admin.androidmvp_2016_10_11.module.response.LoginResult.Login;

import java.util.List;

/**
 * 描述说明  <br/>
 * Author : luokaixuan <br/>
 * CreateDate : 2016/10/11 17:21 <br/>
 * Modified : luokaixuan <br/>
 * ModifiedDate : 2016/10/11 17:21 <br/>
 * Email : 1005949566@qq.com <br/>
 * Version 1.0
 */
public class LoginResult extends BaseLoadingModule<Login> {

    public static class Login {

        private String companyName;
        private boolean isBindApp;
        private boolean allowBindApp;
        private boolean isFunManag;
        private String userCode;
        private String userName;
        private int deptId;
        private int upDeptId;
        private String deptName;
        private int roleId;
        private String roleName;
        private String jobName;
        private String imgUrl;
        private String mailAccount;
        private String email;
        private String employeeNo;
        private String mobileNo;
        private String officePhoneNo;
        private String qq;
        private String birthday;
        private String sex;
        private String comeFrom;
        private String bloodType;
        private String weChat;
        private String microBlog;
        private boolean isMultiJob;

        private List<RightsBean> rights;

        private List<DiyMenusBean> diyMenus;

        private List<UserPostsBean> userPosts;

        private List<PerMenuBean> perMenu;

        public String getCompanyName() {
            return companyName;
        }

        public void setCompanyName(String companyName) {
            this.companyName = companyName;
        }

        public boolean isIsBindApp() {
            return isBindApp;
        }

        public void setIsBindApp(boolean isBindApp) {
            this.isBindApp = isBindApp;
        }

        public boolean isAllowBindApp() {
            return allowBindApp;
        }

        public void setAllowBindApp(boolean allowBindApp) {
            this.allowBindApp = allowBindApp;
        }

        public boolean isIsFunManag() {
            return isFunManag;
        }

        public void setIsFunManag(boolean isFunManag) {
            this.isFunManag = isFunManag;
        }

        public String getUserCode() {
            return userCode;
        }

        public void setUserCode(String userCode) {
            this.userCode = userCode;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public int getDeptId() {
            return deptId;
        }

        public void setDeptId(int deptId) {
            this.deptId = deptId;
        }

        public int getUpDeptId() {
            return upDeptId;
        }

        public void setUpDeptId(int upDeptId) {
            this.upDeptId = upDeptId;
        }

        public String getDeptName() {
            return deptName;
        }

        public void setDeptName(String deptName) {
            this.deptName = deptName;
        }

        public int getRoleId() {
            return roleId;
        }

        public void setRoleId(int roleId) {
            this.roleId = roleId;
        }

        public String getRoleName() {
            return roleName;
        }

        public void setRoleName(String roleName) {
            this.roleName = roleName;
        }

        public String getJobName() {
            return jobName;
        }

        public void setJobName(String jobName) {
            this.jobName = jobName;
        }

        public String getImgUrl() {
            return imgUrl;
        }

        public void setImgUrl(String imgUrl) {
            this.imgUrl = imgUrl;
        }

        public String getMailAccount() {
            return mailAccount;
        }

        public void setMailAccount(String mailAccount) {
            this.mailAccount = mailAccount;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getEmployeeNo() {
            return employeeNo;
        }

        public void setEmployeeNo(String employeeNo) {
            this.employeeNo = employeeNo;
        }

        public String getMobileNo() {
            return mobileNo;
        }

        public void setMobileNo(String mobileNo) {
            this.mobileNo = mobileNo;
        }

        public String getOfficePhoneNo() {
            return officePhoneNo;
        }

        public void setOfficePhoneNo(String officePhoneNo) {
            this.officePhoneNo = officePhoneNo;
        }

        public String getQq() {
            return qq;
        }

        public void setQq(String qq) {
            this.qq = qq;
        }

        public String getBirthday() {
            return birthday;
        }

        public void setBirthday(String birthday) {
            this.birthday = birthday;
        }

        public String getSex() {
            return sex;
        }

        public void setSex(String sex) {
            this.sex = sex;
        }

        public String getComeFrom() {
            return comeFrom;
        }

        public void setComeFrom(String comeFrom) {
            this.comeFrom = comeFrom;
        }

        public String getBloodType() {
            return bloodType;
        }

        public void setBloodType(String bloodType) {
            this.bloodType = bloodType;
        }

        public String getWeChat() {
            return weChat;
        }

        public void setWeChat(String weChat) {
            this.weChat = weChat;
        }

        public String getMicroBlog() {
            return microBlog;
        }

        public void setMicroBlog(String microBlog) {
            this.microBlog = microBlog;
        }

        public boolean isIsMultiJob() {
            return isMultiJob;
        }

        public void setIsMultiJob(boolean isMultiJob) {
            this.isMultiJob = isMultiJob;
        }

        public List<RightsBean> getRights() {
            return rights;
        }

        public void setRights(List<RightsBean> rights) {
            this.rights = rights;
        }

        public List<DiyMenusBean> getDiyMenus() {
            return diyMenus;
        }

        public void setDiyMenus(List<DiyMenusBean> diyMenus) {
            this.diyMenus = diyMenus;
        }

        public List<UserPostsBean> getUserPosts() {
            return userPosts;
        }

        public void setUserPosts(List<UserPostsBean> userPosts) {
            this.userPosts = userPosts;
        }

        public List<PerMenuBean> getPerMenu() {
            return perMenu;
        }

        public void setPerMenu(List<PerMenuBean> perMenu) {
            this.perMenu = perMenu;
        }

        public static class RightsBean {
            private String code;
            private String menuName;

            private List<SubBean> sub;

            public String getCode() {
                return code;
            }

            public void setCode(String code) {
                this.code = code;
            }

            public String getMenuName() {
                return menuName;
            }

            public void setMenuName(String menuName) {
                this.menuName = menuName;
            }

            public List<SubBean> getSub() {
                return sub;
            }

            public void setSub(List<SubBean> sub) {
                this.sub = sub;
            }

            public static class SubBean {
                private String $id;
                private String code;
                private String menuName;

                private List<Sub> sub;

                public String get$id() {
                    return $id;
                }

                public void set$id(String $id) {
                    this.$id = $id;
                }

                public String getCode() {
                    return code;
                }

                public void setCode(String code) {
                    this.code = code;
                }

                public String getMenuName() {
                    return menuName;
                }

                public void setMenuName(String menuName) {
                    this.menuName = menuName;
                }

                public List<Sub> getSub() {
                    return sub;
                }

                public void setSub(List<Sub> sub) {
                    this.sub = sub;
                }

                public static class Sub {
                    private String $ref;

                    public String get$ref() {
                        return $ref;
                    }

                    public void set$ref(String $ref) {
                        this.$ref = $ref;
                    }
                }
            }
        }

        public static class DiyMenusBean {
            private String $ref;

            public String get$ref() {
                return $ref;
            }

            public void set$ref(String $ref) {
                this.$ref = $ref;
            }
        }

        public static class UserPostsBean {
            private String userCode;
            private int deptId;
            private String deptName;
            private int roleId;
            private String roleName;
            private String jobName;

            public String getUserCode() {
                return userCode;
            }

            public void setUserCode(String userCode) {
                this.userCode = userCode;
            }

            public int getDeptId() {
                return deptId;
            }

            public void setDeptId(int deptId) {
                this.deptId = deptId;
            }

            public String getDeptName() {
                return deptName;
            }

            public void setDeptName(String deptName) {
                this.deptName = deptName;
            }

            public int getRoleId() {
                return roleId;
            }

            public void setRoleId(int roleId) {
                this.roleId = roleId;
            }

            public String getRoleName() {
                return roleName;
            }

            public void setRoleName(String roleName) {
                this.roleName = roleName;
            }

            public String getJobName() {
                return jobName;
            }

            public void setJobName(String jobName) {
                this.jobName = jobName;
            }
        }

        public static class PerMenuBean {
            private int menuId;
            private String menuName;
            /**
             * id : 1
             * name : sample string 2
             */

            private List<PerActionsBean> perActions;

            public int getMenuId() {
                return menuId;
            }

            public void setMenuId(int menuId) {
                this.menuId = menuId;
            }

            public String getMenuName() {
                return menuName;
            }

            public void setMenuName(String menuName) {
                this.menuName = menuName;
            }

            public List<PerActionsBean> getPerActions() {
                return perActions;
            }

            public void setPerActions(List<PerActionsBean> perActions) {
                this.perActions = perActions;
            }

            public static class PerActionsBean {
                private int id;
                private String name;

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }
            }
        }

    }
}
