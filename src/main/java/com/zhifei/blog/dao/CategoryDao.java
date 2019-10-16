package com.zhifei.blog.dao;

import com.zhifei.blog.entity.ArticleCategory;
import com.zhifei.blog.entity.Category;

import java.util.List;

public interface CategoryDao {

    /**
     * 获取所有类别
     */
    List<Category> getAllCategory();
}
