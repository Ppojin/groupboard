package com.ppojin.groupboard.persistence;

import com.ppojin.groupboard.controller.MainController;
import com.ppojin.groupboard.entity.user.UserDTO;
import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDAO{
    private static final Logger logger = LoggerFactory.getLogger(MainController.class);
    private static final String NAMESPACE = "com.ppojin.groupboard.mappers.user.UserMapper";
    private final SqlSession sqlSession;
    @Autowired
    public UserDAO(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }
    public void signUp(UserDTO userDTO) throws Exception{
        try{
            sqlSession.insert(NAMESPACE + ".registerNPNB", userDTO);
        } catch (Exception e){
            logger.error(String.format("Something went wrong : %s", e.toString()));
            throw e;
        }
    }
}
