package com.example.admin.androidmvp_2016_10_11.module.response;

import com.example.admin.androidmvp_2016_10_11.common.module.BaseListModule3;
import com.example.admin.androidmvp_2016_10_11.module.response.FlowProgressResult.FlowProgress;

import java.util.List;

/**
 * 描述说明  <br/>
 * Author : luokaixuan <br/>
 * CreateDate : 2016/10/14 20:02 <br/>
 * Modified : luokaixuan <br/>
 * ModifiedDate : 2016/10/14 20:02 <br/>
 * Email : 1005949566@qq.com <br/>
 * Version 1.0
 */
public class FlowProgressResult extends BaseListModule3<FlowProgress> {

    List<FlowProgress> data;

    @Override
    public List<FlowProgress> getList() {
        return data;
    }

    public static class FlowProgress {

        private int id;
        private int parentId;
        private int status;
        private int trackType;
        private String trackName;
        private boolean isHandle;
        private String trackHandleTime;
        private int trackHandleResult;
        private String imageKind;
        private String imageUrl;
        private String imageTitle;

        private List<HandleUsers> handleUsers;

        @Override
        public String toString() {
            return "FlowProgress{" +
                    "id=" + id +
                    ", parentId=" + parentId +
                    ", status=" + status +
                    ", trackType=" + trackType +
                    ", trackName='" + trackName + '\'' +
                    ", isHandle=" + isHandle +
                    ", trackHandleTime='" + trackHandleTime + '\'' +
                    ", trackHandleResult=" + trackHandleResult +
                    ", imageKind='" + imageKind + '\'' +
                    ", imageUrl='" + imageUrl + '\'' +
                    ", imageTitle='" + imageTitle + '\'' +
                    ", handleUsers=" + handleUsers +
                    '}';
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getParentId() {
            return parentId;
        }

        public void setParentId(int parentId) {
            this.parentId = parentId;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public int getTrackType() {
            return trackType;
        }

        public void setTrackType(int trackType) {
            this.trackType = trackType;
        }

        public String getTrackName() {
            return trackName;
        }

        public void setTrackName(String trackName) {
            this.trackName = trackName;
        }

        public boolean isIsHandle() {
            return isHandle;
        }

        public void setIsHandle(boolean isHandle) {
            this.isHandle = isHandle;
        }

        public String getTrackHandleTime() {
            return trackHandleTime;
        }

        public void setTrackHandleTime(String trackHandleTime) {
            this.trackHandleTime = trackHandleTime;
        }

        public int getTrackHandleResult() {
            return trackHandleResult;
        }

        public void setTrackHandleResult(int trackHandleResult) {
            this.trackHandleResult = trackHandleResult;
        }

        public String getImageKind() {
            return imageKind;
        }

        public void setImageKind(String imageKind) {
            this.imageKind = imageKind;
        }

        public String getImageUrl() {
            return imageUrl;
        }

        public void setImageUrl(String imageUrl) {
            this.imageUrl = imageUrl;
        }

        public String getImageTitle() {
            return imageTitle;
        }

        public void setImageTitle(String imageTitle) {
            this.imageTitle = imageTitle;
        }

        public List<HandleUsers> getHandleUsers() {
            return handleUsers;
        }

        public void setHandleUsers(List<HandleUsers> handleUsers) {
            this.handleUsers = handleUsers;
        }

        public static class HandleUsers {
            private int flowApplyStepID;
            private String userName;
            private String userDept;
            private String userPost;
            private String userPhoto;
            private int userHandleResult;
            private String userHandleResultName;
            private String userHandleResultColor;
            private String userHandleTime;
            private String userRemark;
            private String imageKind;

            public int getFlowApplyStepID() {
                return flowApplyStepID;
            }

            public void setFlowApplyStepID(int flowApplyStepID) {
                this.flowApplyStepID = flowApplyStepID;
            }

            public String getUserName() {
                return userName;
            }

            public void setUserName(String userName) {
                this.userName = userName;
            }

            public String getUserDept() {
                return userDept;
            }

            public void setUserDept(String userDept) {
                this.userDept = userDept;
            }

            public String getUserPost() {
                return userPost;
            }

            public void setUserPost(String userPost) {
                this.userPost = userPost;
            }

            public String getUserPhoto() {
                return userPhoto;
            }

            public void setUserPhoto(String userPhoto) {
                this.userPhoto = userPhoto;
            }

            public int getUserHandleResult() {
                return userHandleResult;
            }

            public void setUserHandleResult(int userHandleResult) {
                this.userHandleResult = userHandleResult;
            }

            public String getUserHandleResultName() {
                return userHandleResultName;
            }

            public void setUserHandleResultName(String userHandleResultName) {
                this.userHandleResultName = userHandleResultName;
            }

            public String getUserHandleResultColor() {
                return userHandleResultColor;
            }

            public void setUserHandleResultColor(String userHandleResultColor) {
                this.userHandleResultColor = userHandleResultColor;
            }

            public String getUserHandleTime() {
                return userHandleTime;
            }

            public void setUserHandleTime(String userHandleTime) {
                this.userHandleTime = userHandleTime;
            }

            public String getUserRemark() {
                return userRemark;
            }

            public void setUserRemark(String userRemark) {
                this.userRemark = userRemark;
            }

            public String getImageKind() {
                return imageKind;
            }

            public void setImageKind(String imageKind) {
                this.imageKind = imageKind;
            }
        }
    }
}
