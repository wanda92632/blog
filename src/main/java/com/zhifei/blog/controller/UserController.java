package com.zhifei.blog.controller;

import com.zhifei.blog.entity.Article;
import com.zhifei.blog.entity.Category;
import com.zhifei.blog.entity.User;
import com.zhifei.blog.service.ArticleService;
import com.zhifei.blog.service.CategoryService;
import com.zhifei.blog.service.UserService;
import com.zhifei.blog.shiro.PasswordHelper;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;


/**
 * @author ZhiFei
 */
@Controller
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private ArticleService articleService;
    @Autowired
    private PasswordHelper passwordHelper;
    /**
     * 跳转注册页面
     * @return
     */
    @RequestMapping("/registered")
    public String registeredPage(ModelMap modelMap) {
        //导航栏文章分类
        List<Category> categoryList = categoryService.getAllCategory();
        modelMap.addAttribute("categoryList",categoryList);
        return "/home/page/registered";
    }

    /**
     * 用户注册
     * @param user
     * @return
     */
    @RequestMapping("/userRegister")
    public String userRegistered(User user) {
        user.setUserIcon("upload\\item\\user\\1\\2019062702025165147.jpg");
        passwordHelper.encryptPassword(user);
        userService.userRegistered(user);
        return "redirect:/";
    }

    /**
     * 更新用户数据
     *
     * @param userData
     * @return
     */
    @RequiresRoles("user")
    @RequestMapping(value = "/upUserData", method = RequestMethod.POST)
    public String upUserData(User userData) {
        //获取Session中的用户信息
        Subject subject = SecurityUtils.getSubject();
        Session session = subject.getSession();
        User currentUser = (User) session.getAttribute("user");
        User user = new User();
        user.setUserId(currentUser.getUserId());
        user.setUserNickname(userData.getUserNickname());
        user.setUserEmail(userData.getUserEmail());
        userService.upUserData(user);
        return "redirect:/logout";
    }

    /**
     * 更新用户头像
     *
     * @return
     * @throws IllegalStateException
     */
    @RequiresRoles("user")
    @RequestMapping(value = "/upUserIcon", method = RequestMethod.POST)
    public String upUserIcon(@RequestParam("file") MultipartFile file) throws IOException {
        //获取Session中的用户信息
        Subject subject = SecurityUtils.getSubject();
        Session session = subject.getSession();
        User user = (User) session.getAttribute("user");
        if (file != null) {
            userService.upUserIcon(String.valueOf(user.getUserId()), file.getInputStream());
        }
        return "redirect:/logout";
    }


    /**
     * 其他用户查看用户信息
     * @param userId
     * @return
     */
    @RequestMapping(value = "/userInfo",method = RequestMethod.GET)
    public String userInfo(Integer userId,ModelMap modelMap){
        User user = userService.getUserData(userId);
        Integer articleSum= articleService.queryArticleSumByUserId(userId);
        List<Article> articleList = articleService.getAllArticleByUserID(userId);
        //导航栏文章分类
        List<Category> categoryList = categoryService.getAllCategory();
        modelMap.addAttribute("categoryList",categoryList);
        modelMap.addAttribute("user",user);
        modelMap.addAttribute("articleSum",articleSum);
        modelMap.addAttribute("articleList",articleList);
        return "home/page/userInfo";
    }


}
