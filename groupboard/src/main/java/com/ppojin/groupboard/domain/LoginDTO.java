package com.ppojin.groupboard.domain;

public class LoginDTO {

    private String userEmail;
    private String userPwd;
    private boolean useCookie;

    @Override
    public String toString() {
        return "LoginDTO{" +
                "userEmail='" + userEmail + '\'' +
                ", userPwd='" + userPwd + '\'' +
                ", useCookie=" + useCookie +
                '}';
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    public boolean isUseCookie() {
        return useCookie;
    }

    public void setUseCookie(boolean useCookie) {
        this.useCookie = useCookie;
    }

}