package com.ppojin.groupboard.persistence;


import com.ppojin.groupboard.domain.MainVO;
import com.ppojin.groupboard.domain.SubscribeVO;

import java.util.List;

public interface MainDAO {
    // 그룹 생성
    void createGroup(MainVO mainVO) throws Exception;
    // 그룹 목록 조회
    List<MainVO> listAll(MainVO mainVO) throws Exception;
    // 초대코드
    String inviteCodeInput(SubscribeVO subscribeVO) throws Exception;
}
