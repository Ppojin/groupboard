package com.ppojin.groupboard.domain;

public class GroupDTO {
    private int userID;
    private Integer groupID;

    public GroupDTO(int userID, Integer groupID) {
        this.userID = userID;
        this.groupID = groupID;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public Integer getgroupID() {
        return groupID;
    }

    public void setgroupID(Integer groupID) {
        this.groupID = groupID;
    }
}
