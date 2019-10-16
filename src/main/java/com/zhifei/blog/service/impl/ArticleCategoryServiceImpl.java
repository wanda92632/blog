package com.zhifei.blog.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zhifei.blog.dao.ArticleCategoryDao;
import com.zhifei.blog.entity.ArticleCategory;
import com.zhifei.blog.service.ArticleCategoryService;

/**
 * @author ZhiFei
 */
@Service
public class ArticleCategoryServiceImpl implements ArticleCategoryService {
    @Autowired
    private ArticleCategoryDao articleCategoryDao;
    /**
     * 建立文章文章类型关系
     *
     * @param articleCategory
     */
    @Override
    public void setArticleCategory(ArticleCategory articleCategory) {
        articleCategoryDao.setArticleCategory(articleCategory);
    }

    /**
     * 删除关系-文章Id
     *
     * @param articleId
     */
    @Override
    public void deleteRelationByArticleId(Integer articleId) {
        articleCategoryDao.deleteRelationByArticleId(articleId);
    }


}
