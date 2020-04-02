package com.ppojin.groupboard.service;


import com.ppojin.groupboard.domain.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface GroupService {
    List<ArticleVO> listAllArticle(int userID, int groupID) throws Exception;
    int insertArticle(ArticleVO articleVO, HttpServletRequest request) throws Exception;

    List<ReplyVO> listAllReply(int articleID) throws Exception;
    void insertReply(ReplyVO replyVO) throws Exception;

    List<SubscribeVO> listAllSubscriber(SubscribeVO subscribeVO) throws Exception;
    void insertSubscribe(SubscribeVO subscribeVO) throws Exception;

    ArticleVO voteArticle(ArticleVO articleVO, VoteDTO voteDTO) throws Exception;
    void insertVote(VoteDTO voteDTO) throws Exception;

    List<ScheduleVO> listAllSchedule(int groupID) throws Exception;

    void removeArticle(int removeArticleID, int userID) throws Exception;

    List<ImageVO> listAllImage(int articleID) throws  Exception;

    List<LikeVO> likeVOList(int articleID, int userID) throws Exception;

    String like(int articleID, int userID) throws Exception;

    String removeGroup(int groupID, int userID) throws Exception;
}
