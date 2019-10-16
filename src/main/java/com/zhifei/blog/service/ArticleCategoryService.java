package com.zhifei.blog.service;

import com.zhifei.blog.entity.ArticleCategory;

/**
 * @author ZhiFei
 */
public interface ArticleCategoryService {

    /**
     * 建立文章文章类型关系
     * @param articleCategory
     */
    public void setArticleCategory(ArticleCategory articleCategory);

    /**
     * 删除关系-文章Id
     * @param articleId
     */
    public void deleteRelationByArticleId(Integer articleId);


}
