package com.ppojin.groupboard.domain;

import java.util.List;

public class VoteDTO {
    private int articleID;
    private List<Integer> voteItemIDList;
    private int userID;

    private int voteItemID;

    @Override
    public String toString() {
        return "VoteDTO{" +
                "articleID=" + articleID +
                ", voteItemIDList=" + voteItemIDList +
                ", userID=" + userID +
                ", voteItemID=" + voteItemID +
                '}';
    }

    public List<Integer> getVoteItemIDList() {
        return voteItemIDList;
    }

    public void setVoteItemIDList(List<Integer> voteItemIDList) {
        this.voteItemIDList = voteItemIDList;
    }

    public int getArticleID() {
        return articleID;
    }

    public void setArticleID(int articleID) {
        this.articleID = articleID;
    }

    public int getVoteItemID() {
        return voteItemID;
    }

    public void setVoteItemID(int voteItemID) {
        this.voteItemID = voteItemID;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }
}
