package com.ppojin.groupboard.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value="group/{groupID}")
public class GroupController {
//    private static final Logger logger = LoggerFactory.getLogger(GroupController.class);
//
//    private final ArticleService articleService;
//    private final ReplyService replyService;
//    private final LikeService likeService;
//    private final VoteService voteService;
//    private final ImageService imageService;
//    @Autowired
//    public GroupController( ArticleService articleService, ReplyService replyService, LikeService likeService, VoteService voteService, ImageService imageService ){
//        this.articleService = articleService;
//        this.replyService = replyService;
//        this.likeService = likeService;
//        this.voteService = voteService;
//        this.imageService = imageService;
//    };
//
//    // loute = /group/:gid
//    @RequestMapping(value="")
//    public String articleList(HttpServletResponse res, @SessionAttribute("currentGroup") MainVO mainVO) {
//        res.setContentType("application/json");
//        return articleService.getAllArticleList(mainVO);
//    }
//
//    // loute = /group/:gid/insertArticle
//    @PostMapping(value="insertArticle")
//    public @ResponseBody String gboardexInsertArticle ( @RequestBody ArticleVO articleVO ) throws Exception {
//        MainVO mainVO = (MainVO) request.getSession().getAttribute("currentGroup");
//        articleVO.setUserID(mainVO.getUserID());
//        articleVO.setGroupID(mainVO.getGroupID());
//        groupService.insertArticle(articleVO, request);
//        return "OK";
//    }
//    @PostMapping("removeArticle")
//    public @ResponseBody String removeArticle( @RequestParam("removeArticleID") int removeArticleID, HttpServletRequest request) throws Exception {
//        UserVO userVO = (UserVO) request.getSession().getAttribute("login");
//        int userID = userVO.getUserID();
//        groupService.removeArticle(removeArticleID, userID);
//        return "OK";
//    }
//    // =================================== /group/:gid/board ===================================
//
//    @PostMapping(value="like")
//    public @ResponseBody
//    String like( @RequestParam("articleID") int articleID, HttpServletResponse response, HttpServletRequest request, ArticleVO articleVO) throws Exception {
//        MainVO mainVO = (MainVO) request.getSession().getAttribute("currentGroup");
//        String result = groupService.like(articleID, mainVO.getUserID());
//        return result;
//    }
//    // =================================== ./like ===================================
//
//    // =================================== ./article ===================================
//
//    @PostMapping(value="insertReply")
//    public @ResponseBody
//    String gboardexInsertReply (
//            HttpServletResponse response,
//            HttpServletRequest request,
//            ReplyVO replyVO) throws Exception {
//
//        MainVO mainVO = (MainVO) request.getSession().getAttribute("currentGroup");
//
//        replyVO.setUserID(mainVO.getUserID());
//        replyVO.setGroupID(mainVO.getGroupID());
//
//        logger.info("댓글 등록 컨트롤러");
//        groupService.insertReply(replyVO);
//        return "OK";
//    }
//    // =================================== ./reply ===================================
//
//    @RequestMapping(value="invite")
//    public String listAllSubscriber(Model model, @SessionAttribute("currentGroup") MainVO mainVO) {
//        SubscribeVO subscribeVO = new SubscribeVO();
//        subscribeVO.setGroupID(mainVO.getGroupID());
//        try {
//            model.addAttribute("subscribeList", groupService.listAllSubscriber(subscribeVO));
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return "group/invite/index";
//    }
//
//    @PostMapping(value = "invite/createInviteCode")
//    public @ResponseBody
//    String createInviteCode (
//            HttpServletResponse response,
//            HttpServletRequest request) throws Exception{
//        MainVO mainVO = (MainVO) request.getSession().getAttribute("currentGroup");
//        SubscribeVO subscribeVO = new SubscribeVO();
//        subscribeVO.setGroupID(mainVO.getGroupID());
//
//        logger.info(subscribeVO.toString());
//
//        groupService.insertSubscribe(subscribeVO);
//
//        return "OK";
//    }
//    // =================================== ./invite ===================================
//
//    @PostMapping("insertVote")
//    public @ResponseBody
//    String insertVote(
//            @SessionAttribute("currentGroup") MainVO mainVO,
//            HttpServletResponse response,
//            HttpServletRequest request,
//            VoteDTO voteDTO) throws Exception {
//        voteDTO.setUserID(mainVO.getUserID());
//        groupService.insertVote(voteDTO);
//        return "OK";
//    }
//    // =================================== ./vote ===================================
//
//    @RequestMapping("calendar")
//    public String calender(@SessionAttribute("currentGroup") MainVO mainVO) {
//        return "group/calendar/index";
//    }
//
//    @PostMapping("calendar/listAllSchedule")
//    public @ResponseBody
//    Object listAllSchedule (@SessionAttribute("currentGroup") MainVO mainVO) throws Exception {
//        return groupService.listAllSchedule(mainVO.getGroupID());
//    }
//    // =================================== ./calender ===================================
//
//    @RequestMapping("admin")
//    public String admin () throws Exception {
//        return "group/admin/index";
//    }
//
//    @PostMapping("admin/removeGroup")
//    public @ResponseBody
//    String removeGroup (HttpServletRequest request) throws Exception {
//        MainVO mainVO = (MainVO) request.getSession().getAttribute("currentGroup");
//        UserVO userVO = (UserVO) request.getSession().getAttribute("login");
//        int groupID = mainVO.getGroupID();
//        int groupManagerID = mainVO.getGroupManager();
//        int userID = userVO.getUserID();
//        if (groupManagerID == userID){
//            groupService.removeGroup(groupID, userID);
//            return "SUCCESS";
//        } else {
//            return "FAIL";
//        }
//    }
//    // =================================== ./admin ===================================

}