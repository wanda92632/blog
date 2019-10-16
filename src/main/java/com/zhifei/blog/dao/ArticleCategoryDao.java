package com.zhifei.blog.dao;

import com.zhifei.blog.entity.ArticleCategory;
import org.apache.ibatis.annotations.Param;

/**
 * @author ZhiFei
 */
public interface ArticleCategoryDao {

    /**
     * 添加文章&文章类别关系
     */
    void setArticleCategory(@Param("articleCategory") ArticleCategory articleCategory);

    /**
     * 删除关系-文章Id
     * @param articleId
     */
    void deleteRelationByArticleId(@Param("articleId") Integer articleId);

}
