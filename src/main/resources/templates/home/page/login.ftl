<!DOCTYPE html>
<html>
<head>
    <title>用户登录-知非博客</title>
    <link rel="shortcut icon" href="/img/favicon.ico"/>
    <link rel="bookmark" href="/img/favicon.ico"/>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/4.1.0/css/bootstrap.min.css">
    <link href="//netdna.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
    <script src="https://cdn.staticfile.org/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://cdn.staticfile.org/popper.js/1.12.5/umd/popper.min.js"></script>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/4.1.0/js/bootstrap.min.js"></script>
    <link href="/css/back.css" type="text/css" rel="stylesheet" charset="utf-8">
</head>
<body>
<#include "../public/part/header.ftl">
<section class="container h-100">
    <div class="row mt-5">
        <div class="col-md-4 mx-auto">
            <h1 class="text-center"><i class="fa fa-wikipedia-w"></i></h1>
            <h3 class="text-center text-muted">欢迎登陆</h3>
            <form action="/login" method="post">
                <div class="form-group">
                    <input class="form-control" type="text" name="userName" placeholder="用户名">
                </div>
                <div class="form-group">
                    <input class="form-control" type="password" name="password" placeholder="密码">
                </div>
                <div class="form-group form-check">
                    <label class="form-check-label text-danger"><#if (state??)>${state}</#if></label>
                </div>
                <button class="btn btn-lg btn-primary btn-block" type="submit">登入</button>
            </form>
        </div>
    </div>
</section>
</body>
</html>