package com.ppojin.groupboard.persistence.group.article;

import com.ppojin.groupboard.domain.ArticleVO;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface ArticleDAO {
    List<ArticleVO> listAllArticle(int userID, int groupID) throws Exception;
    int insertArticle(ArticleVO articleVO, HttpServletRequest request) throws Exception;
    void removeArticle(int removeArticleID, int userID) throws Exception;
}
