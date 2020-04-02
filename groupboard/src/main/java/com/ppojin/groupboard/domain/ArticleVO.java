package com.ppojin.groupboard.domain;

import org.springframework.web.multipart.MultipartFile;

import java.sql.Date;
import java.util.List;

public class ArticleVO {
    private int articleID;
    private int userID;
    private int groupID;
    private String articleContent;
    private int articleType;
    private String articleUUID;
    private String articleUploadDate;
    private String articleUpdateDate;

    private List<LikeVO> likeVOList;
    private int likeCount;
    private boolean liked;

    private String userGravatarURL;
    private String userGravatar;
    private String userName;

    private List<ReplyVO> replyVOList;
    // 투표(insert)
    private List<String> voteItem;
    // 투표(select)
    private List<VoteVO> voteVOList;
    private int voteMultiple;
    private int voteCount;
    private boolean voted;

    //일정(insert)
    private String scheduleSubject;
    private String schedulePlace;
    private Date scheduleStartDate;
    private Date scheduleEndDate;

    //앨범(insert)
    private List<MultipartFile> albumPicList;

    private List<ImageVO> album;

    public List<ImageVO> getAlbum() {
        return album;
    }

    public void setAlbum(List<ImageVO> album) {
        this.album = album;
    }

    @Override
    public String toString() {
        return "ArticleVO{" +
                "articleID=" + articleID +
                ", userID=" + userID +
                ", groupID=" + groupID +
                ", articleContent='" + articleContent + '\'' +
                ", articleType=" + articleType +
                ", scheduleSubject='" + scheduleSubject + '\'' +
                ", schedulePlace='" + schedulePlace + '\'' +
                ", scheduleStartDate=" + scheduleStartDate +
                ", scheduleEndDate=" + scheduleEndDate +
                ", albumPicList=" + albumPicList +
                '}';
    }

    public List<MultipartFile> getAlbumPicList() {
        return albumPicList;
    }

    public void setAlbumPicList(List<MultipartFile> albumPicList) {
        this.albumPicList = albumPicList;
    }

    public String getScheduleSubject() {
        return scheduleSubject;
    }

    public void setScheduleSubject(String scheduleSubject) {
        this.scheduleSubject = scheduleSubject;
    }

    public String getSchedulePlace() {
        return schedulePlace;
    }

    public void setSchedulePlace(String schedulePlace) {
        this.schedulePlace = schedulePlace;
    }

    public int getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(int likeCount) {
        this.likeCount = likeCount;
    }

    public List<LikeVO> getLikeVOList() {
        return likeVOList;
    }

    public void setLikeVOList(List<LikeVO> likeVOList) {
        this.likeVOList = likeVOList;
    }

    public boolean getLiked() {
        return liked;
    }

    public void setLiked(boolean liked) {
        this.liked = liked;
    }

    public Date getScheduleStartDate() { return scheduleStartDate; }
    public void setScheduleStartDate(Date scheduleStartDate) { this.scheduleStartDate = scheduleStartDate; }
    public Date getScheduleEndDate() { return scheduleEndDate; }
    public void setScheduleEndDate(Date scheduleEndDate) { this.scheduleEndDate = scheduleEndDate; }
    public int getVoteCount() { return voteCount; }
    public void setVoteCount(int voteCount) { this.voteCount = voteCount; }
    public boolean isVoted() { return voted; }
    public void setVoted(boolean voted) { this.voted = voted; }
    public int getArticleID() { return articleID;}
    public void setArticleID(int articleID) throws Exception { this.articleID = articleID;}
    public int getUserID() { return userID;}
    public void setUserID(int userID) { this.userID = userID;}
    public int getGroupID() { return groupID;}
    public void setGroupID(int groupID) { this.groupID = groupID;}
    public String getArticleContent() { return articleContent;}
    public void setArticleContent(String articleContent) { this.articleContent = articleContent;}
    public int getArticleType() { return articleType;}
    public void setArticleType(int articleType) { this.articleType = articleType;}
    public String getArticleUUID() { return articleUUID;}
    public void setArticleUUID(String articleUUID) { this.articleUUID = articleUUID;}
    public String getArticleUploadDate() { return articleUploadDate;}
    public void setArticleUploadDate(String articleUploadDate) { this.articleUploadDate = articleUploadDate;}
    public String getArticleUpdateDate() { return articleUpdateDate;}
    public void setArticleUpdateDate(String articleUpdateDate) { this.articleUpdateDate = articleUpdateDate;}
    public String getUserGravatarURL() { return userGravatarURL;}
    public void setUserGravatarURL(String userGravatarURL) { this.userGravatarURL = userGravatarURL;}
    public String getUserGravatar() { return userGravatar;}
    public List<ReplyVO> getReplyVOList() { return replyVOList;}
    public void setReplyVOList(List<ReplyVO> replyVOList) { this.replyVOList = replyVOList;}
    public void setUserGravatar(String userGravatar) { this.userGravatar = userGravatar;}
    public String getUserName() { return userName;}
    public void setUserName(String userName) { this.userName = userName;}
    public List<String> getVoteItem() { return voteItem; }
    public void setVoteItem(List<String> voteItem) { this.voteItem = voteItem; }
    public int getVoteMultiple() { return voteMultiple; }
    public void setVoteMultiple(int voteMultiple) { this.voteMultiple = voteMultiple; }
    public List<VoteVO> getVoteVOList() { return voteVOList; }
    public void setVoteVOList(List<VoteVO> voteVOList) { this.voteVOList = voteVOList; }
}