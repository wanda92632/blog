package com.zhifei.blog.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;
import com.zhifei.blog.entity.Comment;
import com.zhifei.blog.service.CommentService;

import java.util.List;

/**
 * @author ZhiFei
 */
public class CommentUtil {

    @Autowired
    CommentService commentService;

    /**
     * 获取文章评论
     * @param articleId
     * @param page
     */
    public static void getArticleComment(ModelMap mav, Integer articleId, String page, CommentService commentService){
        //当前页面号,若为空则默认为第一页
        if(page==null||page==""){
            page="1";
        }
        //评论总数
        int commentCount=commentService.getCommentByArticleId(articleId);
        //可分为多少页
        int pageCount=commentCount/9;
        pageCount=commentCount%9==0?pageCount:pageCount+1;
        //页数
        int num = Integer.valueOf(page);
        List<Comment> commentList = commentService.getComment(articleId,(num-1)*9);
        //总页面数
        mav.addAttribute("pageCount",pageCount);
        //当前页面
        mav.addAttribute("page", page);
        //评论列表
        mav.addAttribute("commentList", commentList);
    }
}
