package com.ppojin.groupboard.controller;

import com.ppojin.groupboard.old.domain.MainVO;
import com.ppojin.groupboard.old.domain.group.SubscribeVO;
import com.ppojin.groupboard.old.domain.UserVO;
import com.ppojin.groupboard.old.service.MainService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.io.File;

@Controller
@RequestMapping("main")
public class MainController {

    private static final Logger logger = LoggerFactory.getLogger(MainController.class);
    private final MainService mainService;

    @Autowired
    public MainController(MainService mainService) {
        this.mainService = mainService;
    }

    @RequestMapping("")
    public String index(Model model,
                        MainVO mainVO,
                        @SessionAttribute("login") UserVO userVO) {
        logger.info("list ...");

        mainVO.setUserID(userVO.getUserID());

        try {
            model.addAttribute("groupList", mainService.listAll(mainVO));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "main/index";
    }

    @PostMapping("createGroupPost")
    public String createGroupPost(
            MainVO mainVO,
            @SessionAttribute("login") UserVO userVO,
            @RequestParam("groupMainPic") MultipartFile groupMainPic,
            RedirectAttributes redirectAttributes,
            HttpServletRequest request) throws Exception {

        String rootPath = "/static/groupMainImage/";
        String path = request.getSession().getServletContext().getRealPath(rootPath);
        String savedName = groupMainPic.getOriginalFilename();
        String ext = savedName.substring(savedName.lastIndexOf( "." ));

        mainVO.setGroupImgExt(ext);
        mainVO.setUserID(userVO.getUserID());
        mainService.createGroup(mainVO);

        File target = new File(path, mainVO.getGroupID() + ext);
        FileCopyUtils.copy(groupMainPic.getBytes(), target);

        // Todo: 그룹 생성 메세지
//        return "redirect:/group/" + mainVO.getGroupID();
        return mainVO.getGroupID().toString();
    }

    @PostMapping("inviteCodeInput")
    public @ResponseBody String inviteCodeInput(
            HttpServletRequest request,
            @SessionAttribute("login") UserVO userVO,
            SubscribeVO svoPre) throws Exception{
        svoPre.setUserID(userVO.getUserID());
        try {
            String groupURL = mainService.inviteCodeInput(svoPre);
            return groupURL;
        } catch (Exception e) {
            System.out.println("에러 메시지 : " + e.getMessage());
            return "fail";
        }
    }
}