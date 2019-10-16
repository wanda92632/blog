package com.zhifei.blog.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author ZhiFei
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Category {
    private Integer categoryId;
    private String categoryName;
    private String categoryColor;
    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryColor() {
        return categoryColor;
    }

    public void setCategoryColor(String categoryColor) {
        this.categoryColor = categoryColor;
    }
}
