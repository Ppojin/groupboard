package com.ppojin.groupboard.persistence;


import com.ppojin.groupboard.domain.LoginDTO;
import com.ppojin.groupboard.domain.UserVO;

public interface UserDAO {

    // 회원가입 처리
    void register(UserVO userVO) throws Exception;

    // 로그인 처리
    UserVO login(LoginDTO loginDTO) throws Exception;
}