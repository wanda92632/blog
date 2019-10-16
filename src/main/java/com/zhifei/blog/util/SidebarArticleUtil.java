package com.zhifei.blog.util;

import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;
import com.zhifei.blog.entity.Article;
import com.zhifei.blog.entity.Comment;
import com.zhifei.blog.service.ArticleService;
import com.zhifei.blog.service.CommentService;

import java.util.List;

/**
 * 获取侧边栏时间的最热文章
 *
 * @author ZhiFei
 */
public class SidebarArticleUtil {

    public static void getSidebarArticle(ModelMap mav, ArticleService articleService, CommentService commentService){
        //最热文章
        List<Article> popularArticle=articleService.queryPopularArticle();
        mav.addAttribute("popularArticle", popularArticle);
        //最新文章
        List<Article> latestArticle = articleService.queryLatestArticle();
        mav.addAttribute("latestArticle", latestArticle);
        //最新评论
        List<Comment> latestComment=commentService.queryLatestComment();
        mav.addAttribute("latestComment", latestComment);
    }
}
