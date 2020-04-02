package com.ppojin.groupboard.domain;

import java.sql.Date;

public class UserVO {
    private int userID;
    private String userEmail;
    private String userName;
    private String userPwd;
    private Date userBirthday;
    private String userPhone;
    private Date userJoinDate;
    private String userGravatar;

    @Override
    public String toString() {
        return "UserVO{" +
                "userID=" + userID +
                ", userEmail='" + userEmail + '\'' +
                ", userName='" + userName + '\'' +
                ", userPwd='" + userPwd + '\'' +
                ", userBirthday=" + userBirthday +
                ", userPhone='" + userPhone + '\'' +
                ", userJoinDate=" + userJoinDate +
                ", userGravatar='" + userGravatar + '\'' +
                '}';
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    public Date getUserBirthday() {
        return userBirthday;
    }

    public void setUserBirthday(Date userBirthday) {
        this.userBirthday = userBirthday;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public Date getUserJoinDate() {
        return userJoinDate;
    }

    public void setUserJoinDate(Date userJoinDate) {
        this.userJoinDate = userJoinDate;
    }

    public String getUserGravatar() {
        return userGravatar;
    }

    public void setUserGravatar(String userGravatar) {
        this.userGravatar = userGravatar;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }
}