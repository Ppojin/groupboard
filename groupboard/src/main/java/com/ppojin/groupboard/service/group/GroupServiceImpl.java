package com.ppojin.groupboard.service.group;

import com.ppojin.groupboard.domain.*;
import com.ppojin.groupboard.persistence.group.GroupDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Service("GroupService")
public class GroupServiceImpl implements GroupService{
    private static final Logger logger = LoggerFactory.getLogger(GroupServiceImpl.class);
    private final GroupDAO groupDAO;
    @Autowired
    public GroupServiceImpl(GroupDAO groupDAO){this.groupDAO = groupDAO;}

    @Override
    public List<ArticleVO> listAllArticle(int userID, int groupID) throws Exception{
        return groupDAO.listAllArticle(userID, groupID);
    }

    @Override
    public int insertArticle(ArticleVO articleVO, HttpServletRequest request) throws Exception{
        try{
            return groupDAO.insertArticle(articleVO, request);
        } catch (Exception e){
            logger.info(""+e);
            return -1;
        }
    }
    @Override
    public void removeArticle(int removeArticleID, int userID) throws Exception {
        groupDAO.removeArticle(removeArticleID, userID);
    }

    @Override
    public List<ImageVO> listAllImage(int articleID) throws Exception {
        return groupDAO.listAllImage(articleID);
    }


    @Override
    public List<ReplyVO> listAllReply(int articleID) throws Exception{
        return groupDAO.listAllReply(articleID);
    }
    @Override
    public void insertReply(ReplyVO replyVO) throws Exception{
        groupDAO.insertReply(replyVO);
    }

    @Override
    public List<SubscribeVO> listAllSubscriber(SubscribeVO subscribeVO) throws Exception{
        return groupDAO.listAllSubscribe(subscribeVO);
    }
    @Override
    public void insertSubscribe(SubscribeVO subscribeVO) throws Exception{
        groupDAO.insertSubscribe(subscribeVO);
    }

    @Override
    public ArticleVO voteArticle(ArticleVO articleVO, VoteDTO voteDTO) throws Exception{
        return groupDAO.voteArticle(articleVO, voteDTO);
    }
    @Override
    public void insertVote(VoteDTO voteDTO) throws Exception{
        try{
            groupDAO.insertVote(voteDTO);
        } catch (Exception e){
            System.out.println(e);
        }
    }

    @Override
    public List<ScheduleVO> listAllSchedule(int groupID) throws Exception{
        try {
            return groupDAO.listAllSchedule(groupID);
        } catch (Exception e){
            logger.info(""+e);
            return groupDAO.listAllSchedule(groupID);
        }
    }

    @Override
    public List<LikeVO> likeVOList(int articleID, int userID) throws Exception {
        return groupDAO.likeVOList(articleID,userID);
    }

    @Override
    public String like(int articleID, int userID) throws Exception {
        return groupDAO.like(articleID, userID);
    }
    @Override
    public String removeGroup(int groupID, int userID) throws Exception{
        return groupDAO.removeGroup(groupID, userID);
    }
}
