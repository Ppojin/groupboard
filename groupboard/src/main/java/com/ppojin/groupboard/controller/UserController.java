package com.ppojin.groupboard.controller;

import com.ppojin.groupboard.entity.user.SigninDTO;
import com.ppojin.groupboard.entity.user.AuthTokenVO;
import com.ppojin.groupboard.entity.user.UserDTO;
import com.ppojin.groupboard.entity.user.UserEntity;
import com.ppojin.groupboard.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Map;


@RestController
@RequestMapping("/api/user")
@Configuration
@EnableWebSecurity
public class UserController extends WebSecurityConfigurerAdapter {
    private static final Logger logger = LoggerFactory.getLogger(MainController.class);
    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
    @Autowired AuthenticationManager authenticationManager;
    @Autowired UserService userService;

    // 회원가입 처리
    @RequestMapping(value = "singup", method = RequestMethod.POST)
    public Map<String, Object> signUP (@RequestBody UserDTO userDTO) throws Exception {
        return userService.signUp(userDTO);
    }

//    // 로그인 처리
//    @RequestMapping(value = "singin", method = RequestMethod.POST)
//    public void loginPOST(UserDTO userDTO, HttpSession httpSession) throws Exception {
//        if(httpSession.getAttribute("user") != null){
//            userService.signIn(userDTO, httpSession);
//        }
//    }
    @PostMapping(value="signin")
    public AuthTokenVO signin(@RequestBody SigninDTO signinDTO, HttpSession session) {
        String email = signinDTO.getEmail();
        String pwd = signinDTO.getPwd();
        UserEntity userEntity = userService.readUser(email, pwd);

        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(email, pwd);
        Authentication authentication = authenticationManager.authenticate(token);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        session.setAttribute(
                HttpSessionSecurityContextRepository.SPRING_SECURITY_CONTEXT_KEY,
                SecurityContextHolder.getContext()
        );

        return new AuthTokenVO(userEntity.getEmail(), userEntity.getAuthorities(), session.getId());
    }

    @RequestMapping("singout")
    public String logout(HttpSession httpSession) throws Exception{
        httpSession.removeAttribute("login");
        httpSession.removeAttribute("currentGroup");
        return "redirect:/";
    }

}