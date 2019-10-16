package com.zhifei.blog.dao;

import com.zhifei.blog.entity.Comment;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author ZhiFei
 */
public interface CommentDao {
    /**
     * 获取评论
     * @param articleId
     * @param begin
     * @return
     */
    List<Comment> getComment(@Param("articleId") Integer articleId, @Param("begin") Integer begin);

    /**
     * 提交评论
     * @param comment
     */
    void setComment(@Param("comment") Comment comment);

    /**
     * 查询文章评论数
     * @param articleId
     * @return
     */
    Integer getCommentByArticleId(@Param("articleId") Integer articleId);

    /**
     * 查询评论总数
     * @return
     */
    int queryCommentSum();

    /**
     * 最新的评论
     * @return
     */
    List<Comment> queryLatestComment();
}
