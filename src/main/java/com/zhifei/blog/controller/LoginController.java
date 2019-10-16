package com.zhifei.blog.controller;

import com.zhifei.blog.util.IPUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.zhifei.blog.entity.*;
import com.zhifei.blog.service.*;
import com.zhifei.blog.util.ArticleUtil;
import com.zhifei.blog.util.SidebarArticleUtil;
import com.zhifei.blog.vo.LoginData;

import javax.servlet.http.HttpServletRequest;
import java.net.InetAddress;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author ZhiFei
 */
@Controller
public class LoginController {
    @Autowired
    private UserService userService;
    @Autowired
    private ArticleService articleService;
    @Autowired
    private LoginLogService loginLogService;
    @Autowired
    private CommentService commentService;
    @Autowired
    private CategoryService categoryService;

    /**
     * 默认页面
     *
     * @param request
     * @return
     */
    @RequestMapping("/index")
    public String loginPage(HttpServletRequest request) {
        String ip = IPUtil.getIpAddress(request);
        String time = LocalDateTime.now().toString();
        LoginLog loginLog = new LoginLog();
        loginLog.setUserId(-1);
        loginLog.setIp(ip);
        loginLog.setVisit(time);
        loginLogService.setLoginLog(loginLog);
        return "redirect:/";
    }

    /**
     * 跳转主页
     *
     * @param request
     * @return
     */
    @RequestMapping("/")
    public String homePage(HttpServletRequest request, String page, ModelMap modelMap) {
        ArticleUtil.getHomeArticle(modelMap,articleService,page);
        //导航栏文章分类
        List<Category> categoryList = categoryService.getAllCategory();
        modelMap.addAttribute("categoryList",categoryList);
        //获取侧边栏文章
        SidebarArticleUtil.getSidebarArticle(modelMap,articleService,commentService);
        return "/home/page/home";
    }

    /**
     * 跳转登录页面
     *
     * @return
     */
    @RequestMapping("/loginPage")
    public String login(ModelMap modelMap) {
        //导航栏文章分类
        List<Category> categoryList = categoryService.getAllCategory();
        modelMap.addAttribute("categoryList",categoryList);
        return "/home/page/login";
    }


    /**
     * 用户登录
     *
     * @param request
     * @param loginData
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String userLogin(HttpServletRequest request, LoginData loginData,ModelMap modelMap) {
        UsernamePasswordToken token = new UsernamePasswordToken(loginData.getUserName(), loginData.getPassword());
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(token);
        } catch (IncorrectCredentialsException ice) {
            System.out.println("登陆失败");
            List<Category> categoryList = categoryService.getAllCategory();
            modelMap.addAttribute("categoryList",categoryList);
            modelMap.addAttribute("state","密码错误");
            return "/home/page/login";
        } catch (UnknownAccountException uae) {
            System.out.println("登陆失败");
            List<Category> categoryList = categoryService.getAllCategory();
            modelMap.addAttribute("categoryList",categoryList);
            modelMap.addAttribute("state","用户不存在");
            return "/home/page/login";
        }
        //查询用户信息
        User user = userService.findUserByUserName(loginData.getUserName());
        //更新用户信息
        String ip = IPUtil.getIpAddress(request);
        String time = LocalDateTime.now().toString();
        user.setLastIP(ip);
        user.setLastVisit(time);
        //添加登录日志
        LoginLog loginLog = new LoginLog();
        loginLog.setUserId(user.getUserId());
        loginLog.setIp(ip);
        loginLog.setVisit(time);
        loginLogService.setLoginLog(loginLog);
        //存入session
        Session session = subject.getSession();
        session.setAttribute("user", user);
        userService.upUserData(user);
        return "redirect:/";
    }

}

