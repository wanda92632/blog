package com.zhifei.blog.service;

import com.zhifei.blog.entity.ArticleCategory;
import com.zhifei.blog.entity.Category;

import java.util.List;

public interface CategoryService {
    /**
     * 过去全部文章
     * @return
     */
    public List<Category> getAllCategory();
}
