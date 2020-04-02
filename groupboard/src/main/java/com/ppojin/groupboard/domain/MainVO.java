package com.ppojin.groupboard.domain;

import java.sql.Date;

public class MainVO {
    private Integer groupID;
    private int groupManager;
    private String groupName;
    private String groupSummary;
    private Date groupCreateDate;
    private int groupColor;
    private String groupImgExt;

    private int userID;
    private String groupColorStr;
    private String groupImageURL;

    @Override
    public String toString() {
        return "MainVO{" +
                "groupID=" + groupID +
                ", groupManager=" + groupManager +
                ", groupName='" + groupName + '\'' +
                ", groupSummary='" + groupSummary + '\'' +
                ", groupCreateDate=" + groupCreateDate +
                ", groupColor=" + groupColor +
                ", groupImgExt='" + groupImgExt + '\'' +
                ", userID=" + userID +
                ", groupColorStr='" + groupColorStr + '\'' +
                '}';
    }

    public String getGroupImgExt() {
        return groupImgExt;
    }

    public void setGroupImageURL(String ext){
        this.groupImageURL = "/static/groupMainImage/" + groupID + ext;
    }
    public String getGroupImageURL(){
        return groupImageURL;
    }

    public void setGroupImgExt(String groupImgExt) {
        this.groupImgExt = groupImgExt;
        setGroupImageURL(groupImgExt);
    }

    public void setGroupColorStr(String groupColorStr) {
        this.groupColorStr = groupColorStr;
    }

    public Integer getGroupID() {
        return groupID;
    }

    public void setGroupID(Integer groupID) {
        this.groupID = groupID;
    }

    public int getGroupManager() {
        return groupManager;
    }

    public void setGroupManager(int groupManager) {
        this.groupManager = groupManager;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getGroupSummary() {
        return groupSummary;
    }

    public void setGroupSummary(String groupSummary) {
        this.groupSummary = groupSummary;
    }

    public Date getGroupCreateDate() {
        return groupCreateDate;
    }

    public void setGroupCreateDate(Date groupCreateDate) {
        this.groupCreateDate = groupCreateDate;
    }

    public int getGroupColor() {
        return groupColor;
    }

    public void setGroupColor(int groupColor) {
        this.setGroupColorStr(groupColor);
        this.groupColor = groupColor;
    }

    public String getGroupColorStr(){ return groupColorStr; }

    public void setGroupColorStr(int groupColor){
        switch (groupColor){
            case 0: this.groupColorStr="navy"; break;
            case 1: this.groupColorStr="indigo"; break;
            case 2: this.groupColorStr="primary"; break;
            case 3: this.groupColorStr="olive"; break;
            case 4: this.groupColorStr="lime"; break;
            case 5: this.groupColorStr="warning"; break;
            case 6: this.groupColorStr="danger"; break;
            case 8: this.groupColorStr="gray"; break;
            case 9: this.groupColorStr="black"; break;
            default: this.groupColorStr="light";
        }
    }
    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }
}
