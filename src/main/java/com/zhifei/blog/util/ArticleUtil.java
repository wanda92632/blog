package com.zhifei.blog.util;

import com.zhifei.blog.entity.Article;
import com.zhifei.blog.service.ArticleService;
import org.springframework.ui.ModelMap;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * @author ZhiFei
 */
public class ArticleUtil {

    public static final int COUNT = 9;

    /**
     * 分类获取文章(标题)
     *
     * @param mav
     * @param articleService
     * @param title
     * @param page
     */
    public static void getArticleTitle(ModelMap mav, ArticleService articleService, String title, String page) {
        //当前页面号,若为空则默认为第一页
        if (page == null || "".equals(page)) {
            page = "1";
        }
        if (title != null && !Objects.equals("", title)) {
            //文章总数
            int articleCount = articleService.getArticleCountByTitle(title);
            //可分为多少页
            int pageCount = articleCount / COUNT;
            pageCount = articleCount % COUNT == 0 ? pageCount : pageCount + 1;
            //页数
            Integer num = Integer.valueOf(page);
            //类别文章
            List<Article> articleList = articleService.queryArticleByTitle(title, (num - 1) * COUNT);
            //总页面数
            mav.addAttribute("pageCount", pageCount);
            //当前页面号
            mav.addAttribute("page", page);
            //文章列表
            mav.addAttribute("articleList", articleList);
        } else {
            mav.addAttribute("pageCount", 0);
            //当前页面号
            mav.addAttribute("page", page);
            //文章列表
            mav.addAttribute("articleList", Collections.emptyList());
        }
    }

    /**
     * 分类获取文章(类别)
     *
     * @param mav
     * @param articleService
     * @param categoryName
     * @param page
     */
    public static void getArticleCategoryName(ModelMap mav, ArticleService articleService, String categoryName, String page) {
        //当前页面号,若为空则默认为第一页
        if (page == null || "".equals(page)) {
            page = "1";
        }
        if (categoryName != null && !Objects.equals("", categoryName)) {
            //文章总数
            int articleCount = articleService.getArticleCountByCategoryName(categoryName);
            //可分为多少页
            int pageCount = articleCount / COUNT;
            pageCount = articleCount % COUNT == 0 ? pageCount : pageCount + 1;
            //页数
            Integer num = Integer.valueOf(page);
            //类别文章
            List<Article> articleList = articleService.queryArticleByCategory(categoryName, (num - 1) * COUNT);
            //总页面数
            mav.addAttribute("pageCount", pageCount);
            //当前页面号
            mav.addAttribute("page", page);
            //文章列表
            mav.addAttribute("articleList", articleList);
        } else {
            //总页面数
            mav.addAttribute("pageCount", 0);
            //当前页面号
            mav.addAttribute("page", page);
            //文章列表
            mav.addAttribute("articleList", Collections.emptyList());
        }

    }


    /**
     * 获取主页文章获取
     *
     * @param mav
     * @param articleService
     * @param page
     * @return
     */
    public static void getHomeArticle(ModelMap mav, ArticleService articleService, String page) {
        //当前页面号,若为空则默认为第一页
        if (page == null || page == "") {
            page = "1";
        }
        //文章总数
        int articleCount = articleService.queryArticleSum();
        //可分为多少页
        int pageCount = articleCount / 9;
        pageCount = articleCount % 9 == 0 ? pageCount : pageCount + 1;
        //页数
        int num = Integer.valueOf(page);
        Article article = articleService.getArticle(6);
        List<Article> articleList = articleService.getHomeArticle((num - 1) * 9);
        articleList.add(0, article);
        //总页面数
        mav.addAttribute("pageCount", pageCount);
        //当前页面号
        mav.addAttribute("page", page);
        //文章列表
        mav.addAttribute("articleList", articleList);
    }

}
