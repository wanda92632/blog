package com.zhifei.blog.service.impl;

import com.zhifei.blog.entity.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import com.zhifei.blog.dao.CategoryDao;
import com.zhifei.blog.service.CategoryService;

import java.util.List;

@Service
@CacheConfig(cacheNames="'category'")
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryDao categoryDao;
    /**
     * 过去全部文章
     *
     * @return
     */
    @Cacheable(key = "'categoryList'")
    @Override
    public List<Category> getAllCategory() {
        return categoryDao.getAllCategory();
    }
}
