<!DOCTYPE html>
<html>
<head>
    <title>知非博客-用户中心</title>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="shortcut icon" href="/img/favicon.ico"/>
    <link rel="bookmark" href="/img/favicon.ico"/>
    <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/4.1.0/css/bootstrap.min.css">
    <link href="//netdna.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
    <link href="/css/back.css" type="text/css" rel="stylesheet" charset="utf-8">
</head>
<body>
<#include "../public/part/header.ftl">
<section class="container">
    <div class="row mt-5">
        <div class="col-md-3 col-xs-12">
            <div class="card">
                <div class="card-body">
                    <img class="card-img-top" src="/img/home.jpg" alt="Card image cap">
                    <ul class="list-group">
                        <li class="list-group-item">用户昵称：${user.userNickname}</li>
                        <li class="list-group-item">用户邮箱：${user.userEmail}</li>
                        <li class="list-group-item">最后访问：${user.lastVisit}</li>
                        <li class="list-group-item">文章数：${articleSum}</li>
                    </ul>
                </div>
            </div>
        </div>
        <div class="col-md-9 col-xs-12">
            <ul class="list-group bg-white">
                <table class="table">
                    <thead>
                    <tr>
                        <th scope="col"></th>
                        <th scope="col">文章标题</th>
                        <th scope="col">文字类型</th>
                        <th scope="col">访问量</th>
                        <th scope="col">创建日期</th>
                    </tr>
                    </thead>
                    <tbody>
                    <#list articleList as article>
                        <tr>
                            <th scope="row">${article?index}</th>
                            <td>${article.title}</td>
                            <td>${article.category.categoryName}</td>
                            <td>${article.viewed}</td>
                            <td>${article.creationTime}</td>
                        </tr>
                    </#list>
                    </tbody>
                </table>
            </ul>
        </div>
    </div>
</section>


<script src="https://cdn.staticfile.org/jquery/3.2.1/jquery.min.js"></script>
<script src="https://cdn.staticfile.org/popper.js/1.12.5/umd/popper.min.js"></script>
<script src="https://cdn.staticfile.org/twitter-bootstrap/4.1.0/js/bootstrap.min.js"></script>
<script src="/js/script.js"></script>
</body>
</html>