package com.ppojin.groupboard.domain;

import java.sql.Date;

public class ReplyVO {
    private int replyID;
    private int parentReplyID;
    private int articleID;
    private int groupID;
    private int userID;
    private String replyContent;
    private Date uploadDate;
    private Date updateDate;

    private String userName;
    private String userGravatar;
    private String userGravatarURL;

    @Override
    public String toString() {
        return "ReplyVO{" +
                "replyID=" + replyID +
                ", parentReplyID=" + parentReplyID +
                ", articleID=" + articleID +
                ", groupID=" + groupID +
                ", userID=" + userID +
                ", replyContent='" + replyContent + '\'' +
                ", uploadDate=" + uploadDate +
                ", updateDate=" + updateDate +
                ", userName='" + userName + '\'' +
                ", userGravatar='" + userGravatar + '\'' +
                ", userGravatarURL='" + userGravatarURL + '\'' +
                '}';
    }

    public int getReplyID() {
        return replyID;
    }

    public void setReplyID(int replyID) {
        this.replyID = replyID;
    }

    public int getParentReplyID() {
        return parentReplyID;
    }

    public void setParentReplyID(int parentReplyID) {
        this.parentReplyID = parentReplyID;
    }

    public int getArticleID() {
        return articleID;
    }

    public void setArticleID(int articleID) {
        this.articleID = articleID;
    }

    public int getGroupID() {
        return groupID;
    }

    public void setGroupID(int groupID) {
        this.groupID = groupID;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getReplyContent() {
        return replyContent;
    }

    public void setReplyContent(String replyContent) {
        this.replyContent = replyContent;
    }

    public Date getUploadDate() {
        return uploadDate;
    }

    public void setUploadDate(Date uploadDate) {
        this.uploadDate = uploadDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserGravatar() {
        return userGravatar;
    }

    public void setUserGravatar(String userGravatar) {
        this.userGravatarURL = "https://www.gravatar.com/avatar/" + userGravatar + "?d=identicon&f=y";
        this.userGravatar = userGravatar;
    }

    public String getUserGravatarURL() {
        return userGravatarURL;
    }

    public void setUserGravatarURL(String userGravatarURL) {
        this.userGravatarURL = userGravatarURL;
    }
}
