package com.example.admin.androidmvp_2016_10_11.module.response;

import com.example.admin.androidmvp_2016_10_11.common.module.BaseListModule;
import com.example.admin.androidmvp_2016_10_11.module.response.MailResult.Data.Mail;

import java.util.List;

/**
 * 描述说明  <br/>
 * Author : luokaixuan <br/>
 * CreateDate : 2016/10/11 17:19 <br/>
 * Modified : luokaixuan <br/>
 * ModifiedDate : 2016/10/11 17:19 <br/>
 * Email : 1005949566@qq.com <br/>
 * Version 1.0
 */
public class MailResult extends BaseListModule<Mail> {

    @Override
    public List<Mail> getList() {
        return getData().getRows();
    }

    Data data;

    public Data getData() {
        return data;
    }

    public static class Data {

        List<Mail> rows;

        public List<Mail> getRows() {
            return rows;
        }

        public static class Mail {

            @Override
            public String toString() {
                return "Mail{" +
                        "id='" + id + '\'' +
                        ", mailType='" + mailType + '\'' +
                        ", sendName='" + sendName + '\'' +
                        ", sendCode='" + sendCode + '\'' +
                        ", title='" + title + '\'' +
                        ", content='" + content + '\'' +
                        ", recvTime='" + recvTime + '\'' +
                        ", isRead='" + isRead + '\'' +
                        ", isUrgent='" + isUrgent + '\'' +
                        ", isHasAttachment='" + isHasAttachment + '\'' +
                        ", isReceipt='" + isReceipt + '\'' +
                        ", recverNames='" + recverNames + '\'' +
                        ", recverCodes='" + recverCodes + '\'' +
                        ", to=" + to +
                        ", cc=" + cc +
                        ", bcc=" + bcc +
                        ", attachmetinfos=" + attachmetinfos +
                        '}';
            }

            private String id;
            private String mailType;
            private String sendName;
            private String sendCode;
            private String title;
            private String content;
            private String recvTime;
            private String isRead;
            private String isUrgent;
            private String isHasAttachment;
            private String isReceipt;
            private String recverNames;
            private String recverCodes;

            private List<ToEntity> to;

            private List<CcEntity> cc;

            private List<BccEntity> bcc;

            private List<AttachmetinfosEntity> attachmetinfos;

            public void setId(String id) {
                this.id = id;
            }

            public void setMailType(String mailType) {
                this.mailType = mailType;
            }

            public void setSendName(String sendName) {
                this.sendName = sendName;
            }

            public void setSendCode(String sendCode) {
                this.sendCode = sendCode;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public void setContent(String content) {
                this.content = content;
            }

            public void setRecvTime(String recvTime) {
                this.recvTime = recvTime;
            }

            public void setIsRead(String isRead) {
                this.isRead = isRead;
            }

            public void setIsUrgent(String isUrgent) {
                this.isUrgent = isUrgent;
            }

            public void setIsHasAttachment(String isHasAttachment) {
                this.isHasAttachment = isHasAttachment;
            }

            public void setIsReceipt(String isReceipt) {
                this.isReceipt = isReceipt;
            }

            public void setRecverNames(String recverNames) {
                this.recverNames = recverNames;
            }

            public void setRecverCodes(String recverCodes) {
                this.recverCodes = recverCodes;
            }

            public void setTo(List<ToEntity> to) {
                this.to = to;
            }

            public void setCc(List<CcEntity> cc) {
                this.cc = cc;
            }

            public void setBcc(List<BccEntity> bcc) {
                this.bcc = bcc;
            }

            public void setAttachmetinfos(List<AttachmetinfosEntity> attachmetinfos) {
                this.attachmetinfos = attachmetinfos;
            }

            public String getId() {
                return id;
            }

            public String getMailType() {
                return mailType;
            }

            public String getSendName() {
                return sendName;
            }

            public String getSendCode() {
                return sendCode;
            }

            public String getTitle() {
                return title;
            }

            public String getContent() {
                return content;
            }

            public String getRecvTime() {
                return recvTime;
            }

            public String getIsRead() {
                return isRead;
            }

            public String getIsUrgent() {
                return isUrgent;
            }

            public String getIsHasAttachment() {
                return isHasAttachment;
            }

            public String getIsReceipt() {
                return isReceipt;
            }

            public String getRecverNames() {
                return recverNames;
            }

            public String getRecverCodes() {
                return recverCodes;
            }

            public List<ToEntity> getTo() {
                return to;
            }

            public List<CcEntity> getCc() {
                return cc;
            }

            public List<BccEntity> getBcc() {
                return bcc;
            }

            public List<AttachmetinfosEntity> getAttachmetinfos() {
                return attachmetinfos;
            }

            public static class ToEntity {
                private String name;
                private String address;

                @Override
                public String toString() {
                    return "ToEntity{" +
                            "name='" + name + '\'' +
                            ", address='" + address + '\'' +
                            '}';
                }

                public void setName(String name) {
                    this.name = name;
                }

                public void setAddress(String address) {
                    this.address = address;
                }

                public String getName() {
                    return name;
                }

                public String getAddress() {
                    return address;
                }
            }

            public static class CcEntity {
                private String name;
                private String address;

                @Override
                public String toString() {
                    return "CcEntity{" +
                            "name='" + name + '\'' +
                            ", address='" + address + '\'' +
                            '}';
                }

                public void setName(String name) {
                    this.name = name;
                }

                public void setAddress(String address) {
                    this.address = address;
                }

                public String getName() {
                    return name;
                }

                public String getAddress() {
                    return address;
                }
            }

            public static class BccEntity {
                private String name;
                private String address;

                @Override
                public String toString() {
                    return "BccEntity{" +
                            "name='" + name + '\'' +
                            ", address='" + address + '\'' +
                            '}';
                }

                public void setName(String name) {
                    this.name = name;
                }

                public void setAddress(String address) {
                    this.address = address;
                }

                public String getName() {
                    return name;
                }

                public String getAddress() {
                    return address;
                }
            }

            public static class AttachmetinfosEntity {
                private String id;
                private String name;
                private String realname;
                private String type;
                private String size;

                @Override
                public String toString() {
                    return "AttachmetinfosEntity{" +
                            "id='" + id + '\'' +
                            ", name='" + name + '\'' +
                            ", realname='" + realname + '\'' +
                            ", type='" + type + '\'' +
                            ", size='" + size + '\'' +
                            '}';
                }

                public void setId(String id) {
                    this.id = id;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public void setRealname(String realname) {
                    this.realname = realname;
                }

                public void setType(String type) {
                    this.type = type;
                }

                public void setSize(String size) {
                    this.size = size;
                }

                public String getId() {
                    return id;
                }

                public String getName() {
                    return name;
                }

                public String getRealname() {
                    return realname;
                }

                public String getType() {
                    return type;
                }

                public String getSize() {
                    return size;
                }
            }

        }
    }
}
