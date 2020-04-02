package com.ppojin.groupboard.controller;

import com.ppojin.groupboard.domain.UserVO;
import com.ppojin.groupboard.service.UserService;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
@RequestMapping("user")
public class UserRegisterController {

    private final UserService userService;

    @Autowired
    public UserRegisterController(UserService userService) {
        this.userService = userService;
    }

    // 회원가입 페이지
    @RequestMapping(value = "register", method = RequestMethod.GET)
    public String registerGET() throws Exception {
        return "user/register";
    }

    // 회원가입 처리
    @RequestMapping(value = "register", method = RequestMethod.POST)
    public String registerPOST(UserVO userVO, RedirectAttributes redirectAttributes) throws Exception {

        String hashedPw = BCrypt.hashpw(userVO.getUserPwd(), BCrypt.gensalt());
        userVO.setUserPwd(hashedPw);
        userService.register(userVO);
        redirectAttributes.addFlashAttribute("msg", "REGISTERED");

        return "redirect:/user/login";
    }
}