package com.ppojin.groupboard.controller;

import com.ppojin.groupboard.domain.*;
import com.ppojin.groupboard.service.group.GroupService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@RequestMapping(value="group/{groupID}")
public class GroupController {
    private static final Logger logger = LoggerFactory.getLogger(GroupController.class);
    private final GroupService groupService;
    @Autowired
    public GroupController(GroupService groupService){this.groupService = groupService;};

    @RequestMapping(value="")
    public String gboardex(Model model, @SessionAttribute("currentGroup") MainVO mainVO) {
        int userID = mainVO.getUserID();
        int groupID = mainVO.getGroupID();

        try {
            List<ArticleVO> articleVOList = groupService.listAllArticle(userID, groupID);
            for (ArticleVO articleVO : articleVOList) {
                articleVO.setUserGravatarURL("https://www.gravatar.com/avatar/" + articleVO.getUserGravatar() + "?d=identicon&f=y");
                
                int articleID = articleVO.getArticleID();
                
                List<ReplyVO> replyVOList = groupService.listAllReply(articleID);
                articleVO.setReplyVOList(replyVOList);

                List<LikeVO> likeVOList = groupService.likeVOList(articleID, userID);
                articleVO.setLikeVOList(likeVOList);
                articleVO.setLiked(false);
                int likeCount = 0;
                if(likeVOList != null){
                    for(LikeVO likeVO : likeVOList){
                        if(likeVO.getUserID() == userID){
                            articleVO.setLiked(true);
                        }
                        likeCount += 1;
                    }
                }
                articleVO.setLikeCount(likeCount);

                if (articleVO.getArticleType() == 1){
                    VoteDTO voteDTO = new VoteDTO();
                    voteDTO.setArticleID(articleID);
                    voteDTO.setUserID(userID);
                    articleVO = groupService.voteArticle(articleVO, voteDTO);
                    for (VoteVO voteVO : articleVO.getVoteVOList()) {
                        if (voteVO.getVoteSelected() != 0) {
                            articleVO.setVoted(true);
                        }
                    }
                } else if (articleVO.getArticleType() == 3){
                    articleVO.setAlbum(groupService.listAllImage(articleID));
                }
            }
            model.addAttribute("contentList", articleVOList);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "group/board/index";
    }
    // =================================== /group/:gid/board ===================================

    @PostMapping(value="like")
    public @ResponseBody
    String like(
            @RequestParam("articleID") int articleID,
            HttpServletResponse response,
            HttpServletRequest request,
            ArticleVO articleVO) throws Exception {
        logger.info("좋아용");
        MainVO mainVO = (MainVO) request.getSession().getAttribute("currentGroup");
        String result = groupService.like(articleID, mainVO.getUserID());
        return result;
    }
    // =================================== ./like ===================================

    @PostMapping(value="insertArticle")
    public @ResponseBody
    String gboardexInsertArticle (
            HttpServletResponse response,
            HttpServletRequest request,
            ArticleVO articleVO) throws Exception {
        logger.info("게시글 등록 컨트롤러");
        MainVO mainVO = (MainVO) request.getSession().getAttribute("currentGroup");
        articleVO.setUserID(mainVO.getUserID());
        articleVO.setGroupID(mainVO.getGroupID());
        logger.info(articleVO.toString());
        groupService.insertArticle(articleVO, request);
        return "OK";
    }
    @PostMapping("removeArticle")
    public @ResponseBody
    String removeArticle(
            @RequestParam("removeArticleID") int removeArticleID,
            HttpServletRequest request) throws Exception {
        UserVO userVO = (UserVO) request.getSession().getAttribute("login");
        int userID = userVO.getUserID();
        groupService.removeArticle(removeArticleID, userID);
        return "OK";
    }
    // =================================== ./article ===================================

    @PostMapping(value="insertReply")
    public @ResponseBody
    String gboardexInsertReply (
            HttpServletResponse response,
            HttpServletRequest request,
            ReplyVO replyVO) throws Exception {

        MainVO mainVO = (MainVO) request.getSession().getAttribute("currentGroup");

        replyVO.setUserID(mainVO.getUserID());
        replyVO.setGroupID(mainVO.getGroupID());

        logger.info("댓글 등록 컨트롤러");
        groupService.insertReply(replyVO);
        return "OK";
    }
    // =================================== ./reply ===================================

    @RequestMapping(value="invite")
    public String listAllSubscriber(Model model, @SessionAttribute("currentGroup") MainVO mainVO) {
        SubscribeVO subscribeVO = new SubscribeVO();
        subscribeVO.setGroupID(mainVO.getGroupID());
        try {
            model.addAttribute("subscribeList", groupService.listAllSubscriber(subscribeVO));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "group/invite/index";
    }

    @PostMapping(value = "invite/createInviteCode")
    public @ResponseBody
    String createInviteCode (
            HttpServletResponse response,
            HttpServletRequest request) throws Exception{
        MainVO mainVO = (MainVO) request.getSession().getAttribute("currentGroup");
        SubscribeVO subscribeVO = new SubscribeVO();
        subscribeVO.setGroupID(mainVO.getGroupID());

        logger.info(subscribeVO.toString());

        groupService.insertSubscribe(subscribeVO);

        return "OK";
    }
    // =================================== ./invite ===================================

    @PostMapping("insertVote")
    public @ResponseBody
    String insertVote(
            @SessionAttribute("currentGroup") MainVO mainVO,
            HttpServletResponse response,
            HttpServletRequest request,
            VoteDTO voteDTO) throws Exception {
        voteDTO.setUserID(mainVO.getUserID());
        groupService.insertVote(voteDTO);
        return "OK";
    }
    // =================================== ./vote ===================================

    @RequestMapping("calendar")
    public String calender(@SessionAttribute("currentGroup") MainVO mainVO) {
        return "group/calendar/index";
    }

    @PostMapping("calendar/listAllSchedule")
    public @ResponseBody
    Object listAllSchedule (@SessionAttribute("currentGroup") MainVO mainVO) throws Exception {
        return groupService.listAllSchedule(mainVO.getGroupID());
    }
    // =================================== ./calender ===================================

    @RequestMapping("admin")
    public String admin () throws Exception {
        return "group/admin/index";
    }

    @PostMapping("admin/removeGroup")
    public @ResponseBody
    String removeGroup (HttpServletRequest request) throws Exception {
        MainVO mainVO = (MainVO) request.getSession().getAttribute("currentGroup");
        UserVO userVO = (UserVO) request.getSession().getAttribute("login");
        int groupID = mainVO.getGroupID();
        int groupManagerID = mainVO.getGroupManager();
        int userID = userVO.getUserID();
        if (groupManagerID == userID){
            groupService.removeGroup(groupID, userID);
            return "SUCCESS";
        } else {
            return "FAIL";
        }
    }
    // =================================== ./admin ===================================

}