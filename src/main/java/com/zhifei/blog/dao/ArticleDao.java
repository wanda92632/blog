package com.zhifei.blog.dao;

import com.zhifei.blog.entity.Article;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author ZhiFei
 */
public interface ArticleDao {
    /**
     * 获取文章-文章ID
     * @param articleId
     * @return
     */
    Article getArticle(@Param("articleId") int articleId);

    /**
     * 提交文章
     * @param article
     */
    void setArticle(@Param("article") Article article);

    /**
     * 更新文章
     *
     * @param article
     */
    void updateArticle(@Param("article") Article article);

    /**
     * 增加文章阅读数
     * @param articleId
     */
    void addArticleViewed(@Param("articleId") int articleId);

    /**
     *获取文章-用户ID
     * @param userId
     * @return
     */
    List<Article> getAllArticleByUserID(@Param("userId") Integer userId);

    /**
     * 删除文章
     * @param articleId
     */
    void deleteArticle(@Param("articleId") Integer articleId);

    /**
     * 获取主页文章
     * @param begin
     * @return
     */
    List<Article> getHomeArticle(@Param("begin") int begin);

    /**
     * 查询文章-标题
     * @param title
     * @param begin
     * @return
     */
    List<Article> queryArticleByTitle(@Param("title") String title, @Param("begin") int begin);

    /**
     * 查询文章-标题数量
     * @param title
     * @return
     */
    int queryArticleByTitleCount(@Param("title") String title);

    /**
     * 查询文章-类别
     * @param categoryName
     * @param begin
     * @return
     */
    List<Article> queryArticleByCategory(@Param("categoryName") String categoryName, @Param("begin") int begin);

    /**
     * 查询文章-类别数量
     * @param categoryName
     * @return
     */
    int queryArticleByCategoryCount(@Param("categoryName") String categoryName);
    /**
     * 查询文章总数
     * @return
     */
    int queryArticleSum();

    /**
     * 获取最新文章
     * @return
     */
    List<Article> queryLatestArticle();

    /**
     * 获取热门文章
     * @return
     */
    List<Article> queryPopularArticle();

    /**
     * 查询用户发表文章数
     * @param userId
     * @return
     */
    Integer queryArticleSumByUserId(@Param("userId") Integer userId);
}
