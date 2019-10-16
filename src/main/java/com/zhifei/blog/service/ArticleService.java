package com.zhifei.blog.service;

import com.zhifei.blog.entity.Article;

import java.util.List;

/**
 * @author ZhiFei
 */
public interface ArticleService {

    /**
     * 获取文章
     * @param articleId
     * @return
     */
    Article getArticle(int articleId);

    /**
     * 提交文章
     * @param article
     */
    void setArticle(Article article);


    /**
     * 更新文章
     *
     * @param article
     */
    void updateArticle(Article article);

    /**
     * 获取主页文章
     * @param begin
     * @return
     */
    List<Article> getHomeArticle(int begin);

    /**
     * 删除文章
     * @param articleId
     */
    void deleteArticle(Integer articleId);

    /**
     * 获取用户的所有文章
     * @param userId
     * @return
     */
    List<Article> getAllArticleByUserID(Integer userId);

    /**
     * 增加已阅读数
     * @param articleId
     */
    void addArticleViewed(Integer articleId);

    /**
     * 查询文章-标题
     * @param title
     * @param begin
     * @return
     */
    List<Article> queryArticleByTitle(String title, int begin);

    /**
     * 查询文章-标题数量
     * @param title
     * @return
     */
    int getArticleCountByTitle(String title);

    /**
     * 查询文章-类别
     * @param categoryName
     * @param begin
     * @return
     */
    List<Article> queryArticleByCategory(String categoryName, int begin);

    /**
     * 查询文章-类别数量
     * @param categoryName
     * @return
     */
    int getArticleCountByCategoryName(String categoryName);

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
    Integer queryArticleSumByUserId(Integer userId);
}
