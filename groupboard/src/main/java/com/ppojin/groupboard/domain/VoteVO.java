package com.ppojin.groupboard.domain;

public class VoteVO {
    private int voteItemID;
    private int articleID;
    private String voteItemValue;

    private int voteSelected;
    private int voteCount;

    @Override
    public String toString() {
        return "VoteVO{" +
                "voteItemID=" + voteItemID +
                ", articleID=" + articleID +
                ", voteItemValue='" + voteItemValue + '\'' +
                ", voteSelected=" + voteSelected +
                ", voteCount=" + voteCount +
                '}';
    }

    public int getArticleID() { return articleID; }
    public void setArticleID(int articleID) { this.articleID = articleID; }
    public int getVoteItemID() { return voteItemID; }
    public void setVoteItemID(int voteItemID) { this.voteItemID = voteItemID; }
    public String getVoteItemValue() { return voteItemValue; }
    public void setVoteItemValue(String voteItemValue) { this.voteItemValue = voteItemValue; }
    public int getVoteCount() { return voteCount; }
    public void setVoteCount(int voteCount) { this.voteCount = voteCount; }
    public int getVoteSelected() { return voteSelected; }
    public void setVoteSelected(int voteSelected) { this.voteSelected = voteSelected; }
}
