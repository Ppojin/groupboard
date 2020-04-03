package com.ppojin.groupboard.persistence.group.article;

import com.ppojin.groupboard.commons.util.UploadFileUtils;
import com.ppojin.groupboard.domain.ArticleVO;
import com.ppojin.groupboard.domain.ImageVO;
import com.ppojin.groupboard.domain.VoteVO;
import com.ppojin.groupboard.persistence.group.GroupDAOImpl;
import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.sql.Date;
import java.util.Calendar;
import java.util.List;
import java.util.UUID;

public class ArticleDAOImpl implements ArticleDAO {
    private static final Logger logger = LoggerFactory.getLogger(GroupDAOImpl.class);
    private static final String NAMESPACE = "com.ppojin.groupboard.mappers.service";
    private final SqlSession sqlSession;

    @Autowired
    public ArticleDAOImpl(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    @Override
    public List<ArticleVO> listAllArticle(int userID, int groupID) throws Exception{
        ArticleVO articleVO = new ArticleVO();
        articleVO.setUserID(userID);
        articleVO.setGroupID(groupID);
        return sqlSession.selectList(NAMESPACE + ".ArticleMapper.listAllArticle", articleVO);
    }
    private int insertAVO_ReturnAID(String mapper, ArticleVO articleVO){
        sqlSession.insert(mapper, articleVO);
        int articleID = sqlSession.selectOne(NAMESPACE + ".ArticleMapper.selectOneArticleID", articleVO);
//        logger.info("게시글 등록됨 \n articleUUID = " + articleVO.getArticleUUID() + "\n articleID = " + articleID);
        return articleID;
    }
    @Override
    public int insertArticle(ArticleVO articleVO, HttpServletRequest request) throws Exception{
        int articleID = -1;
        String articleUUID = UUID.randomUUID().toString();
        articleVO.setArticleUUID(articleUUID);
        switch (articleVO.getArticleType()){
            case 0:
                // 게시글 저장
                articleID = insertAVO_ReturnAID(NAMESPACE + ".ArticleMapper.insertArticle", articleVO);
                return articleID;
            case 1:
                articleID = insertAVO_ReturnAID(NAMESPACE + ".ArticleMapper.insertVote", articleVO);
                List<String> voteItemList = articleVO.getVoteItem();
                logger.info(""+articleVO.getVoteMultiple());//테스트
                VoteVO voteVO = new VoteVO();
                for (String voteItem : voteItemList) {
                    voteVO.setVoteItemValue(voteItem);
                    voteVO.setArticleID(articleID);
                    sqlSession.insert(NAMESPACE + ".VoteMapper.insertVoteItem", voteVO);
                }
                logger.info("투표글 등록됨");
                return articleID;
            case 2:
                Calendar cal = Calendar.getInstance();
                cal.setTime(articleVO.getScheduleEndDate());
                cal.add(Calendar.DAY_OF_YEAR,1);
                articleVO.setScheduleEndDate(new Date(cal.getTimeInMillis()));
                cal.setTime(articleVO.getScheduleStartDate());
                cal.add(Calendar.DAY_OF_YEAR,1);
                articleVO.setScheduleStartDate(new Date(cal.getTimeInMillis()));
                articleID = insertAVO_ReturnAID(NAMESPACE + ".ArticleMapper.insertSchedule", articleVO);
                logger.info("일정글 등록됨");
                return articleID;
            case 3:
                articleID = insertAVO_ReturnAID(NAMESPACE + ".ArticleMapper.insertSchedule", articleVO);
                List<MultipartFile> albumPicList = articleVO.getAlbumPicList();
                for (MultipartFile albumPic : albumPicList){
//                    logger.info(albumPic.getOriginalFilename());
                    String filePath = UploadFileUtils.uploadFile(albumPic, request);
                    ImageVO imageVO = new ImageVO();
                    imageVO.setGroupID(articleVO.getGroupID());
                    imageVO.setUserID(articleVO.getUserID());
                    imageVO.setArticleID(articleID);
                    imageVO.setFilePath(filePath);
                    imageVO.setGroupID(articleVO.getGroupID());
//                    logger.info(imageVO.toString());
                    logger.info("filepath = " + filePath);
                    sqlSession.insert(NAMESPACE + ".ImageMapper.insertImage", imageVO);
                }
                logger.info("앨범글 등록됨");
                return articleID;
//            case 4:
//                logger.info("장소글 등록됨");
//                return articleID;
//            case 5:
//                logger.info("지출글 등록됨");
//                return articleID;
//            case 6:
//                logger.info("회비글 등록됨");
//                return articleID;
        }
        return -1;
    }
    @Override
    public void removeArticle(int removeArticleID, int userID) throws Exception {
        ModelAndView mav = new ModelAndView("removeDTO");
        int num = sqlSession.selectOne(NAMESPACE + ".ArticleMapper.getUserIDFromArticle", removeArticleID);
        logger.info(String.valueOf(num));
        if(userID == num){
            sqlSession.delete(NAMESPACE + ".ArticleMapper.deleteArticle", removeArticleID);
            logger.info("삭제성공");
        }
    }
}
