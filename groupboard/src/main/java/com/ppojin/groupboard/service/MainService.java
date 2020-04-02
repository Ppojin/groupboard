package com.ppojin.groupboard.service;


import com.ppojin.groupboard.domain.MainVO;
import com.ppojin.groupboard.domain.SubscribeVO;

import java.util.List;

public interface MainService {
    // 그룹 생성
    void createGroup(MainVO mainVO) throws Exception;
    // 그룹 리스트
    List<MainVO> listAll(MainVO mainVO) throws Exception;
    // 초대코드
    String inviteCodeInput(SubscribeVO subscribeVO) throws Exception;
}
