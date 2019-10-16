package com.zhifei.blog.controller;

import com.zhifei.blog.entity.Category;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.zhifei.blog.entity.Article;
import com.zhifei.blog.entity.ArticleCategory;
import com.zhifei.blog.entity.User;
import com.zhifei.blog.service.*;

import java.util.List;

/**
 * @author ZhiFei
 */
@Controller
public class AdminController {
    @Autowired
    private UserService userService;
    @Autowired
    private ArticleService articleService;
    @Autowired
    private CommentService commentService;
    @Autowired
    private CategoryService categoryService;

    /**
     * 进入用户界面
     *
     * @return
     */
    @RequiresRoles("user")
    @RequiresAuthentication
    @RequestMapping("/admin/index")
    public String adminIndex(ModelMap modelMap) {
        int articleSum = articleService.queryArticleSum();
        int commentSum=commentService.queryCommentSum();
        int userSum=userService.queryUserSum();
        modelMap.addAttribute("articleSum",articleSum);
        modelMap.addAttribute("commentSum",commentSum);
        modelMap.addAttribute("userSum",userSum);
        return "/admin/index";
    }

    /**
     * 查看用户信息
     */
    @RequiresRoles("user")
    @RequiresAuthentication
    @RequestMapping("/admin/adminPersonal")
    public String adminPersonal(ModelMap modelMap) {
        //获取Session中的用户信息
        Subject subject = SecurityUtils.getSubject();
        Session session = subject.getSession();
        User user = (User) session.getAttribute("user");

        modelMap.addAttribute("user", user);
        return "/admin/adminPersonal";
    }

    /**
     * 查看提交的全部文章
     *
     * @return
     */
    @RequiresRoles("user")
    @RequiresAuthentication
    @RequestMapping("/admin/adminAllArticle")
    public String adminAllArticle(ModelMap modelMap) {
        //获取Session中的用户信息
        Subject subject = SecurityUtils.getSubject();
        Session session = subject.getSession();
        User user = (User) session.getAttribute("user");
        List<Article> articleList = articleService.getAllArticleByUserID(user.getUserId());
        modelMap.addAttribute("articleList", articleList);
        return "admin/adminAllArticle";
    }

    /**
     * 写文章
     *
     * @return
     */
    @RequiresRoles("user")
    @RequiresAuthentication
    @RequestMapping("/admin/writeArticle")
    public String writeArticle(ModelMap modelMap) {
        List<Category> categoryList = categoryService.getAllCategory();
        modelMap.addAttribute("categoryList",categoryList);
        return "admin/writeArticle";
    }
}
