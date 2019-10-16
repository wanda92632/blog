<!DOCTYPE html>
<html>
<head>
    <title>知非博客</title>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="shortcut icon" href="/img/favicon.ico"/>
    <link rel="bookmark" href="/img/favicon.ico"/>
    <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/4.1.0/css/bootstrap.min.css">
    <link href="//netdna.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
    <link href="/css/back.css" type="text/css" rel="stylesheet" charset="utf-8">
</head>
<body>
<#include "../public/part/header.ftl">
<section class="container mt-4">
    <div class="row">
        <div class="col-md-9 col-xs-12 ">
            <ul class=" list-group px-0">
                <#if (articleList?size!=0)>
                <#--文章列表-->
                    <#include "../public/part/articlelist.ftl">
                    <#if (articleList?size!=0)>
                    <#--分页按钮-->
                        <#include "../public/part/pageList-home.ftl">
                    </#if>

                </#if>
                <#if (articleList?size==0)>
                    <li class="text-center text-muted">
                        没有更多了
                    </li>
                </#if>
            </ul>
        </div>
        <#--侧边栏-->
        <#include "../public/part/sidebar.ftl">
    </div>
</section>

<script src="https://cdn.staticfile.org/jquery/3.2.1/jquery.min.js"></script>
<script src="https://cdn.staticfile.org/popper.js/1.12.5/umd/popper.min.js"></script>
<script src="https://cdn.staticfile.org/twitter-bootstrap/4.1.0/js/bootstrap.min.js"></script>
<script src="/js/script.js"></script>
</body>
</html>