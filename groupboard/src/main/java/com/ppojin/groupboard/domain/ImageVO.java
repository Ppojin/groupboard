package com.ppojin.groupboard.domain;

import java.sql.Date;

public class ImageVO {
    private int imageID;
    private int groupID;
    private int articleID;
    private int userID;
    private Date uploadDate;
    private String filePath;

    @Override
    public String toString() {
        return "ImageVO{" +
                "imageID=" + imageID +
                ", groupID=" + groupID +
                ", articleID=" + articleID +
                ", userID=" + userID +
                ", uploadDate=" + uploadDate +
                ", filePath='" + filePath + '\'' +
                '}';
    }

    public int getImageID() {
        return imageID;
    }

    public void setImageID(int imageID) {
        this.imageID = imageID;
    }

    public int getGroupID() {
        return groupID;
    }

    public void setGroupID(int groupID) {
        this.groupID = groupID;
    }

    public int getArticleID() {
        return articleID;
    }

    public void setArticleID(int articleID) {
        this.articleID = articleID;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public Date getUploadDate() {
        return uploadDate;
    }

    public void setUploadDate(Date uploadDate) {
        this.uploadDate = uploadDate;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }
}
