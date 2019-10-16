package com.zhifei.blog.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

/**
 * @author ZhiFei
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Article {
    private Integer articleId;
    private String title;
    private String introduction;
    private String content;
    private Integer viewed;
    private String creationTime;
    private String updateTime;

    private User user;
    private Category category;
}
