package com.ppojin.groupboard.persistence;

import com.ppojin.groupboard.domain.LoginDTO;
import com.ppojin.groupboard.domain.UserVO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Date;

@Repository
public class UserDAOImpl implements UserDAO {

    private static final String NAMESPACE = "com.hj.gboardex.mappers.user.UserMapper";

    private final SqlSession sqlSession;
    private Date dateNull;
    private String phoneNull;

    @Autowired
    public UserDAOImpl(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    // gravatar 용 hash 생성
    public static String hex(byte[] array) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < array.length; ++i) {
            sb.append(Integer.toHexString((array[i]
                    & 0xFF) | 0x100).substring(1,3));
        }
        return sb.toString();
    }
    public static String md5Hex (String message) {
        try {
            MessageDigest md =
                    MessageDigest.getInstance("MD5");
            return hex (md.digest(message.getBytes("CP1252")));
        } catch (NoSuchAlgorithmException e) {
        } catch (UnsupportedEncodingException e) {
        }
        return null;
    }

    // 회원가입
    @Override
    public void register(UserVO userVO) throws Exception {

        userVO.setUserGravatar(md5Hex(userVO.getUserEmail()));

        if (userVO.getUserBirthday() == dateNull || userVO.getUserPhone() == phoneNull) {
            if (userVO.getUserBirthday() == dateNull && userVO.getUserPhone() == phoneNull) {
                sqlSession.insert(NAMESPACE + ".registerNPNB", userVO);
            }else if(userVO.getUserBirthday() == dateNull){
                sqlSession.insert(NAMESPACE + ".registerNB", userVO);
            }else if(userVO.getUserPhone() == phoneNull){
                sqlSession.insert(NAMESPACE + ".registerNP", userVO);
            }
        }else{
            sqlSession.insert(NAMESPACE + ".register", userVO);
        }
    }

    // 로그인 처리
    @Override
    public UserVO login(LoginDTO loginDTO) throws Exception {
        return sqlSession.selectOne(NAMESPACE + ".login", loginDTO);
    }
}