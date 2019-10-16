package com.zhifei.blog.service;

import com.zhifei.blog.entity.Comment;

import java.util.List;

/**
 * @author ZhiFei
 */
public interface CommentService {

    /**
     * 获取评论
     * @param articleId
     * @return
     */
    List<Comment> getComment(Integer articleId, Integer begin);

    /**
     * 提交评论
     * @param comment
     */
    void setComment(Comment comment);

    /**
     * 文章评论数
     * @param articleId
     * @return
     */
    Integer getCommentByArticleId(Integer articleId);

    /**
     * 查询文章总数
     * @return
     */
    Integer queryCommentSum();

    /**
     * 查询最新评论
     * @return
     */
    List<Comment> queryLatestComment();
}
