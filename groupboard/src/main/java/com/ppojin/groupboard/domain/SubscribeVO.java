package com.ppojin.groupboard.domain;

import java.sql.Date;

public class SubscribeVO { private int subscribeID;
    private int groupID;
    private int userID;
    private String inviteCode;
    private Date inviteDate;
    private Date joinDate;
    private Date unsubscribeDate;

    private String userName;
    public String getUserName() { return userName; }
    public void setUserName(String userName) { this.userName = userName; }

    private String groupName;
    public String getGroupName() { return groupName; }
    public void setGroupName(String groupName) { this.groupName = groupName; }

    @Override
    public String toString() {
        return "SubscribeVO{" +
                "subscribeID=" + subscribeID +
                ", groupID=" + groupID +
                ", userID=" + userID +
                ", inviteCode='" + inviteCode + '\'' +
                ", inviteDate=" + inviteDate +
                ", joinDate=" + joinDate +
                ", unsubscribeDate=" + unsubscribeDate +
                ", userName='" + userName + '\'' +
                '}';
    }

    public int getSubscribeID() { return subscribeID; }
    public void setSubscribeID(int subscribeID) { this.subscribeID = subscribeID; }
    public int getGroupID() { return groupID; }
    public void setGroupID(int groupID) { this.groupID = groupID; }
    public int getUserID() { return userID; }
    public void setUserID(int userID) { this.userID = userID; }
    public String getInviteCode() { return inviteCode; }
    public void setInviteCode(String inviteCode) { this.inviteCode = inviteCode; }
    public Date getInviteDate() { return inviteDate; }
    public void setInviteDate(Date inviteDate) { this.inviteDate = inviteDate; }
    public Date getJoinDate() { return joinDate; }
    public void setJoinDate(Date joinDate) { this.joinDate = joinDate; }
    public Date getUnsubscribeDate() { return unsubscribeDate; }
    public void setUnsubscribeDate(Date unsubscribeDate) { this.unsubscribeDate = unsubscribeDate; }
}
