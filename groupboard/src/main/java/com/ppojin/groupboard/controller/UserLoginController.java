package com.ppojin.groupboard.controller;

import com.ppojin.groupboard.domain.LoginDTO;
import com.ppojin.groupboard.domain.UserVO;
import com.ppojin.groupboard.service.UserService;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("user")
public class UserLoginController {

    private final UserService userService;

    @Autowired
    public UserLoginController(UserService userService) {
        this.userService = userService;
    }

    // 로그인 페이지
    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String loginGET(@ModelAttribute("loginDTO") LoginDTO loginDTO) {
        return "user/login";
    }

    // 로그인 처리
    @RequestMapping(value = "loginPost", method = RequestMethod.POST)
    public void loginPOST(LoginDTO loginDTO, Model model) throws Exception {
        UserVO userVO = userService.login(loginDTO);
        if (userVO == null || !BCrypt.checkpw(loginDTO.getUserPwd(), userVO.getUserPwd())) {
            return;
        }
        model.addAttribute("user", userVO);
    }

    @RequestMapping("logout")
    public String logout(HttpSession httpSession) throws Exception{
        httpSession.removeAttribute("login");
        httpSession.removeAttribute("currentGroup");
        return "redirect:/";
    }
}