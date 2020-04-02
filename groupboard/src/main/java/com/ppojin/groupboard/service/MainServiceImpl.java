package com.ppojin.groupboard.service;

import com.ppojin.groupboard.domain.MainVO;
import com.ppojin.groupboard.domain.SubscribeVO;
import com.ppojin.groupboard.persistence.MainDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("MainService")
public class MainServiceImpl implements MainService {

    private final MainDAO mainDAO;

    @Autowired
    public MainServiceImpl(MainDAO mainDAO) {
        this.mainDAO = mainDAO;
    }

    @Override
    public void createGroup(MainVO mainVO) throws Exception {
        mainDAO.createGroup(mainVO);
    }

    @Override
    public List<MainVO> listAll(MainVO mainVO) throws Exception{
        return mainDAO.listAll(mainVO);
    }

    @Override
    public String inviteCodeInput(SubscribeVO subscribeVO) throws Exception{
        return mainDAO.inviteCodeInput(subscribeVO);
    }
}
