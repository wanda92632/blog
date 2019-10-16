package com.zhifei.blog.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.zhifei.blog.entity.Article;
import com.zhifei.blog.entity.Comment;
import com.zhifei.blog.entity.User;
import com.zhifei.blog.service.ArticleService;
import com.zhifei.blog.service.CommentService;
import com.zhifei.blog.util.CommentUtil;

import java.time.LocalDate;


/**
 * @author ZhiFei
 */
@Controller
public class CommentController {
    @Autowired
    private ArticleService articleService;
    @Autowired
    private CommentService commentService;

    /**
     * 提交评论
     * @param comment
     * @return
     */
    @RequiresAuthentication
    @RequestMapping("/setComment")
    public String setComment(Comment comment, ModelMap modelMap){
        //获取Session中的用户信息
        Subject subject = SecurityUtils.getSubject();
        Session session = subject.getSession();
        User user = (User) session.getAttribute("user");

        comment.setUserId(user.getUserId());
        comment.setUserNickname(user.getUserNickname());
        comment.setUserIcon(user.getUserIcon());
        LocalDate localTime = LocalDate.now();
        comment.setCommentCreationTime(localTime.toString());
        commentService.setComment(comment);
        //获取博客文章
        Article article = articleService.getArticle(comment.getArticleId());
        modelMap.addAttribute("article",article);
        //获取评论
        CommentUtil.getArticleComment(modelMap,comment.getArticleId(),null,commentService);
        return "home/page/article";
    }
}
