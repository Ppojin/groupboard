package com.ppojin.groupboard.service;

import com.ppojin.groupboard.controller.MainController;
import com.ppojin.groupboard.entity.user.UserDTO;
import com.ppojin.groupboard.entity.user.UserEntity;
import com.ppojin.groupboard.mapper.UserMapper;
import com.ppojin.groupboard.persistence.UserDAO;
import org.mindrot.jbcrypt.BCrypt;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.*;

@Service("UserService")
public class UserServiceImpl implements UserService {
    private static final Logger logger = LoggerFactory.getLogger(MainController.class);
    private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Autowired UserDAO userDAO;
    @Autowired UserMapper userMapper;

    final AuthenticationManager authenticationManager;
    public UserService(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    public Map<String, Object> signUp(UserDTO userDTO) {
        Map<String, Object> result = new HashMap<String, Object>();
        try{
            userDAO.signUp(userDTO);
            result.put("result", "SUCCEED");
            return result;
        } catch (Exception e) {
            result.put("result", "FAILED");
            return result;
        }
    }

//    public HttpSession signIn(UserDTO userDTO, HttpSession httpSession) {
//        UserEntity userEntity = userDAO.signIn(userDTO);
//        if (userEntity.isCorrectPwd(userDTO.getPwd())) {
//            return httpSession;
//        } else {
//            httpSession.setAttribute("user", userEntity.toString());
//            return httpSession;
//        }
//    }

    public UserEntity readUser(String email, String pwd) {
        pwd = BCrypt.hashpw(pwd, BCrypt.gensalt());
        UserEntity userEntity = userMapper.readUser(email, pwd);
//        userEntity.setAuthorities(userMapper.readAuthority(email));
        return userEntity;
    }

    @Override
    public UserEntity loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity userEntity = userMapper.readUser(username);
        userEntity.setAuthorities(getAuthorities(username));

        return userEntity;
    }

    public PasswordEncoder passwordEncoder() {
        return this.passwordEncoder;
    }

    @Override
    public Collection<GrantedAuthority> getAuthorities(String username) {
        List<String> string_authorities = userMapper.readAuthority(username);
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        for (String authority : string_authorities) {
            authorities.add(new SimpleGrantedAuthority(authority));
        }
        return authorities;
    }
}
