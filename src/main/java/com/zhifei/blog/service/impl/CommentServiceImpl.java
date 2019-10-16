package com.zhifei.blog.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zhifei.blog.dao.CommentDao;
import com.zhifei.blog.entity.Comment;
import com.zhifei.blog.service.CommentService;

import java.util.List;

/**
 * @author ZhiFei
 */
@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    CommentDao commentDao;

    /**
     * 获取评论
     * @param articleId
     * @param begin
     * @return
     */
    @Override
    public List<Comment> getComment(Integer articleId,Integer begin){
        List<Comment> commentList = commentDao.getComment(articleId,begin);
        return commentList;
    }

    /**
     * 提交评论
     * @param comment
     */
    @Override
    public void setComment(Comment comment)
    {
        commentDao.setComment(comment);
    }

    /**
     * 查看文章评论数
     * @param articleId
     * @return
     */
    @Override
    public Integer getCommentByArticleId(Integer articleId){
        return commentDao.getCommentByArticleId(articleId);
    }

    /**
     * 查询文章总数
     * @return
     */
    @Override
    public Integer queryCommentSum() {
        return commentDao.queryCommentSum();
    }

    /**
     * 查询最新评论
     *
     * @return
     */
    @Override
    public List<Comment> queryLatestComment() {
        return commentDao.queryLatestComment();
    }


}
