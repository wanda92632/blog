package com.zhifei.blog.controller;

import com.zhifei.blog.entity.Article;
import com.zhifei.blog.entity.Category;
import com.zhifei.blog.entity.User;
import com.zhifei.blog.service.ArticleCategoryService;
import com.zhifei.blog.service.ArticleService;
import com.zhifei.blog.service.CategoryService;
import com.zhifei.blog.service.CommentService;
import com.zhifei.blog.util.ArticleUtil;
import com.zhifei.blog.util.CommentUtil;
import com.zhifei.blog.util.IPUtil;
import com.zhifei.blog.util.SidebarArticleUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;


/**
 * @author ZhiFei
 */
@Controller
public class ArticleController {
    @Autowired
    private ArticleService articleService;
    @Autowired
    private CommentService commentService;
    @Autowired
    private ArticleCategoryService articleCategoryService;
    @Autowired
    private CategoryService categoryService;
    @Resource
    private StringRedisTemplate template;

    /**
     * 提交文章
     *
     * @param article
     * @return
     */
    @RequiresRoles("user")
    @RequestMapping(value = "/setArticle", method = RequestMethod.POST)
    public String submitArticle(Article article, Integer categoryId) {
        //获取Session中的用户信息
        Subject subject = SecurityUtils.getSubject();
        Session session = subject.getSession();
        User user = (User) session.getAttribute("user");
        //截取文章-简介
        String introduction = article.getIntroduction();
        int length = introduction.length() < 300 ? introduction.length() : 300;
        introduction = introduction.substring(0, length);
        //文章类别
        Category category = new Category();
        category.setCategoryId(categoryId);
        article.setCategory(category);
        article.setIntroduction(introduction);
        LocalDate localTime = LocalDate.now();
        if(article.getArticleId()==null){
            //新增文章
            //作者信息
            article.setUser(user);
            //创建时间
            article.setCreationTime(localTime.toString());
            articleService.setArticle(article);
        }else {
            //修改文章
            article.setUpdateTime(localTime.toString());
            articleService.updateArticle(article);
        }
        //清除缓存中的key
        template.opsForHash().delete("uploadFile", user.getUserId().toString());
        return "redirect:/";
    }

    /**
     * 更新文章
     *
     * @param articleId
     * @param modelMap
     * @return
     */
    @RequestMapping("/updateArticle")
    public String updateArticle(Integer articleId, ModelMap modelMap) {
        List<Category> categoryList = categoryService.getAllCategory();
        modelMap.addAttribute("categoryList", categoryList);
        Article article = articleService.getArticle(articleId);
        modelMap.addAttribute("article", article);
        System.out.println(article);
        return "admin/writeArticle";
    }

    /**
     * 查看文章
     *
     * @param articleId
     * @return
     */
    @RequestMapping("/getArticleById")
    public String get(HttpServletRequest request, Integer articleId, String page, ModelMap modelMap) {
        String ip = IPUtil.getIpAddress(request);
        //缓存key
        String key = articleId.toString() + ip;
        //判断24小时内是否访问过
        if (Objects.equals(template.hasKey(key), false)) {
            template.opsForValue().setIfAbsent(key, String.valueOf(LocalDate.now()), 24, TimeUnit.HOURS);
            //添加已阅读数
            articleService.addArticleViewed(articleId);
        }
        //获取博客文章
        Article article = articleService.getArticle(articleId);
        modelMap.addAttribute("article", article);
        //获取评论
        CommentUtil.getArticleComment(modelMap, articleId, page, commentService);
        //获取侧边栏文章
        SidebarArticleUtil.getSidebarArticle(modelMap, articleService, commentService);
        //导航栏文章分类
        List<Category> categoryList = categoryService.getAllCategory();
        modelMap.addAttribute("categoryList", categoryList);
        return "home/page/article";
    }

    /**
     * 删除文章
     *
     * @param articleId
     * @return
     */
    @RequiresRoles("user")
    @RequestMapping(value = "/deleteArticle", method = RequestMethod.POST)
    public String deleteArticle(Integer articleId) {
        articleCategoryService.deleteRelationByArticleId(articleId);
        articleService.deleteArticle(articleId);
        return "redirect:admin/adminAllArticle";
    }

    /**
     * 查找文章--标题
     *
     * @param title
     * @return
     */
    @RequestMapping(value = "/getArticleByTitle")
    public String getArticleByTitle(String title, String page, ModelMap modelMap) {
        //类别文章
        ArticleUtil.getArticleTitle(modelMap, articleService, title, page);
        //获取侧边栏文章
        SidebarArticleUtil.getSidebarArticle(modelMap, articleService, commentService);
        //导航栏文章分类
        List<Category> categoryList = categoryService.getAllCategory();
        modelMap.addAttribute("categoryList", categoryList);
        return "/home/page/home";
    }

    /**
     * 查找文章-类别
     *
     * @param categoryName
     * @return
     */
    @RequestMapping(value = "/getArticleByCategory", method = RequestMethod.GET)
    public String getArticleByCategory(String categoryName, String page, ModelMap modelMap) {
        //类别文章
        ArticleUtil.getArticleCategoryName(modelMap, articleService, categoryName, page);
        //获取侧边栏文章
        SidebarArticleUtil.getSidebarArticle(modelMap, articleService, commentService);
        //导航栏文章分类
        List<Category> categoryList = categoryService.getAllCategory();
        modelMap.addAttribute("categoryList", categoryList);
        return "/home/page/home";
    }
}
