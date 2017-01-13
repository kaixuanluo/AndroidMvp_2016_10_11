package com.example.admin.androidmvp_2016_10_11.module.response;

import com.example.admin.androidmvp_2016_10_11.common.module.BaseListModule;
import com.example.admin.androidmvp_2016_10_11.module.response.FlowSendResult.Data.Rows.FlowSend;

import java.util.List;

/**
 * 描述说明  <br/>
 * Author : luokaixuan <br/>
 * CreateDate : 2016/10/20 16:24 <br/>
 * Modified : luokaixuan <br/>
 * ModifiedDate : 2016/10/20 16:24 <br/>
 * Email : 1005949566@qq.com <br/>
 * Version 1.0
 */
public class FlowSendResult extends BaseListModule<FlowSend> {

    public Data getData() {
        return data;
    }

    Data data;

    @Override
    public List<FlowSend> getList() {
        return getData().getRows().getFlowSend();
    }

    public static class Data {

        Rows rows;

        public Rows getRows() {
            return rows;
        }

        public static class Rows {

            public List<FlowSend> getFlowSend() {
                return flowSend;
            }

            List<FlowSend> flowSend;

            public static class FlowSend {

                private int id;
                private String flowVID;
                private String name;
                private String startTime;
                private String endTime;
                private int status;
                private double flag;
                private boolean isDraft;
                private int isUrgency;
                private int recordStatus;
                private String createCode;
                private String createTime;
                private String updateCode;
                private String updateTime;
                private String processName;
                private String statusName;
                private String userName;
                private String url;

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public String getFlowVID() {
                    return flowVID;
                }

                public void setFlowVID(String flowVID) {
                    this.flowVID = flowVID;
                }

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public String getStartTime() {
                    return startTime;
                }

                public void setStartTime(String startTime) {
                    this.startTime = startTime;
                }

                public String getEndTime() {
                    return endTime;
                }

                public void setEndTime(String endTime) {
                    this.endTime = endTime;
                }

                public int getStatus() {
                    return status;
                }

                public void setStatus(int status) {
                    this.status = status;
                }

                public double getFlag() {
                    return flag;
                }

                public void setFlag(double flag) {
                    this.flag = flag;
                }

                public boolean isIsDraft() {
                    return isDraft;
                }

                public void setIsDraft(boolean isDraft) {
                    this.isDraft = isDraft;
                }

                public int getIsUrgency() {
                    return isUrgency;
                }

                public void setIsUrgency(int isUrgency) {
                    this.isUrgency = isUrgency;
                }

                public int getRecordStatus() {
                    return recordStatus;
                }

                public void setRecordStatus(int recordStatus) {
                    this.recordStatus = recordStatus;
                }

                public String getCreateCode() {
                    return createCode;
                }

                public void setCreateCode(String createCode) {
                    this.createCode = createCode;
                }

                public String getCreateTime() {
                    return createTime;
                }

                public void setCreateTime(String createTime) {
                    this.createTime = createTime;
                }

                public String getUpdateCode() {
                    return updateCode;
                }

                public void setUpdateCode(String updateCode) {
                    this.updateCode = updateCode;
                }

                public String getUpdateTime() {
                    return updateTime;
                }

                public void setUpdateTime(String updateTime) {
                    this.updateTime = updateTime;
                }

                public String getProcessName() {
                    return processName;
                }

                public void setProcessName(String processName) {
                    this.processName = processName;
                }

                public String getStatusName() {
                    return statusName;
                }

                public void setStatusName(String statusName) {
                    this.statusName = statusName;
                }

                public String getUserName() {
                    return userName;
                }

                public void setUserName(String userName) {
                    this.userName = userName;
                }

                public String getUrl() {
                    return url;
                }

                public void setUrl(String url) {
                    this.url = url;
                }
            }
        }
    }
}
