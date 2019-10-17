<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>知非博客-仪表盘</title>
    <link rel="shortcut icon" href="/img/favicon.ico"/>
    <link rel="bookmark" href="/img/favicon.ico"/>
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
    <link rel="stylesheet" href="/adminLTE/css/bootstrap.min.css" type="text/css" charset="UTF-8">
    <link rel="stylesheet" href="/adminLTE/css/font-awesome.min.css" type="text/css" charset="UTF-8">
    <link rel="stylesheet" href="/adminLTE/css/ionicons.min.css" type="text/css" charset="UTF-8">
    <link rel="stylesheet" href="/adminLTE/css/AdminLTE.min.css" type="text/css" charset="UTF-8">
    <link rel="stylesheet" href="/adminLTE/css/skin-blue.min.css" type="text/css" charset="UTF-8">

    <link rel="stylesheet" href="../css/back.css" type="text/css" charset="UTF-8">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->

    <!-- Google Font -->
    <link rel="stylesheet"
          href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700,300italic,400italic,600italic">
</head>
<body class="hold-transition skin-blue sidebar-mini">
<div class="wrapper">

    <!-- Main Header -->
    <header class="main-header">

        <!-- Logo -->
        <a href="/" class="logo" style="background-color: #222d32">
            <span class="logo-mini"><b>知非</b></span>
            <span class="logo-lg"><b>知非博客</b></span>
        </a>

        <!-- 顶部导航栏 -->
        <nav class="navbar navbar-static-top" style="background-color: #222d32" role="navigation">
            <!-- Sidebar toggle button-->
            <a href="#" class="sidebar-toggle" data-toggle="push-menu" role="button">
                <span class="sr-only">Toggle navigation</span>
            </a>
            <!-- 导航栏右侧菜单 -->
            <div class="navbar-custom-menu">
                <ul class="nav navbar-nav">
                    <!-- User Account Menu -->
                    <li class="dropdown user user-menu">
                        <!-- Menu Toggle Button -->
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                            <!-- The user image in the navbar-->
                            <img src="${user.userIcon}" class="user-image" alt="User Image">
                            <!-- hidden-xs hides the username on small devices so only the image appears. -->
                            <span class="hidden-xs">${user.userNickname}</span>
                        </a>
                        <ul class="dropdown-menu">
                            <!-- The user image in the menu -->
                            <li class="user-header" style="background-color: #222d32">
                                <img src="${user.userIcon}" class="img-circle" alt="User Image">

                                <p>
                                    待到秋来九月八，我花开后百花杀
                                    <small>——黄巢</small>
                                </p>
                            </li>
                            <!-- Menu Footer-->
                            <li class="user-footer">
                                <div class="pull-left">
                                    <a href="#" class="btn btn-default btn-flat">个人资料</a>
                                </div>
                                <div class="pull-right">
                                    <a href="/logout" class="btn btn-default btn-flat">注销登录</a>
                                </div>
                            </li>
                        </ul>
                    </li>
                    2
                </ul>
            </div>
        </nav>
    </header>
    <!-- 左侧侧边栏 -->
    <aside class="main-sidebar">

        <!-- 侧边栏: style can be found in sidebar.less -->
        <section class="sidebar">

            <!-- 侧边栏 用户面板 (optional) -->
            <div class="user-panel">
                <div class="pull-left image">
                    <img src="${user.userIcon}" class="img-circle" alt="User Image">
                </div>
                <div class="pull-left info">
                    <p>${user.userNickname}</p>
                    <!-- 用户状态 -->
                    <a href="/admin/adminPersonal"><i class="fa fa-circle text-success"></i>个人资料</a>
                </div>
            </div>

            <!-- 搜索表单 (Optional) -->
            <form action="#" method="get" class="sidebar-form">
                <div class="input-group">
                    <input type="text" name="q" class="form-control" placeholder="Search...">
                    <span class="input-group-btn">
              <button type="submit" name="search" id="search-btn" class="btn btn-flat"><i class="fa fa-search"></i>
              </button>
            </span>
                </div>
            </form>
            <!-- /.search form -->

            <!-- 侧边栏 菜单 -->
            <ul class="sidebar-menu" data-widget="tree">
                <li class="header">主导航</li>
                <!-- Optionally, you can add icons to the links -->
                <li class="treeview"><a href="/admin/index"><i class="fa fa-dashboard"></i> <span>仪表盘</span></a></li>
                <li class="treeview active">
                    <a href="#"><i class="fa fa-book"></i> <span>文章</span>
                        <span class="pull-right-container">
                <i class="fa fa-angle-left pull-right"></i>
              </span>
                    </a>
                    <ul class="treeview-menu">
                        <li><a href="/admin/adminAllArticle">文章管理</a></li>
                        <li><a href="/admin/writeArticle">写文章</a></li>
                    </ul>
                </li>
                <li class="treeview">
                    <a href="#"><i class="fa fa-user-o"></i> <span>用户</span>
                        <span class="pull-right-container">
                <i class="fa fa-angle-left pull-right"></i>
              </span>
                    </a>
                    <ul class="treeview-menu">
                        <li><a href="/admin/adminPersonal">个人资料</a></li>
                    </ul>
                </li>
            </ul>
            <!-- /.sidebar-menu -->
        </section>
        <!-- /.sidebar -->
    </aside>

    <!-- 页面内容 -->
    <div class="content-wrapper">
        <!-- 页面标题 -->
        <section class="content-header">
            <h1 id="header">
                文章编辑
                <h3 class="center">页面中间</h3>
            </h1>
            <ol class="breadcrumb">
                <li><a href="/admin/index"><i class="fa fa-dashboard"></i>首页</a></li>
                <li class="active">文章编辑</li>
            </ol>
        </section>

        <!-- 主要内容 -->
        <section class="content container-fluid">
            <div class="row">
                <form action="/setArticle" method="post">
                    <div class="col-md-9">
                        <div class="box box-primary">
                            <div class="row">
                                <div class="col-md-12">
                                    <div class="form-group hidden">
                                        <input type="text" id="articleId" class="form-control"
                                               name="articleId" value="<#if article?? >${article.articleId}</#if>"
                                               placeholder="文章Id">
                                    </div>
                                    <div class="form-group">
                                        <input type="text" id="title" class="form-control" name="title" maxlength="300"
                                               value="<#if article?? >${article.title}</#if>"
                                               placeholder="请输入文章标题" required>
                                    </div>
                                    <div class="form-group hidden">
                                        <input type="text" id="content" class="form-control"
                                               name="content"
                                               placeholder="请输入文章内容">
                                    </div>
                                    <div class="form-group hidden">
                                        <input type="text" id="introduction" class="form-control"
                                               name="introduction"
                                               placeholder="请输入文章简介">
                                    </div>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-12">
                                    <div id="div1" class="toolbar">
                                    </div>
                                    <div id="div2" class="text">
                                        <#if article?? >${article.content}</#if>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-3">
                        <div class="box box-primary">
                            <div class="box-header with-border">
                                <h3 class="box-title"><font style="vertical-align: inherit;"><font
                                                style="vertical-align: inherit;">发布</font></font></h3>
                            </div>
                            <!-- /.box-header -->
                            <div class="box-body">
                                <div class="form-group">
                                    <label><font style="vertical-align: inherit;"><font
                                                    style="vertical-align: inherit;">文章类型</font></font></label>
                                    <select name="categoryId" class="form-control">
                                        <#list categoryList as category>
                                            <option value="${category.categoryId}"><font
                                                        style="vertical-align: inherit;"><font
                                                            style="vertical-align: inherit;">${category.categoryName}</font></font>
                                            </option>
                                        </#list>
                                    </select>
                                </div>
                                <div class="form-group">
                                    <label><font style="vertical-align: inherit;"><font
                                                    style="vertical-align: inherit;">开启评论</font></font></label>
                                    <select class="form-control">
                                        <option><font style="vertical-align: inherit;"><font
                                                        style="vertical-align: inherit;">是</font></font></option>
                                        <option><font style="vertical-align: inherit;"><font
                                                        style="vertical-align: inherit;">否</font></font></option>
                                    </select>
                                </div>
                                <button id="btn1" class="btn btn-info pull-right"><font
                                            style="vertical-align: inherit;"><font
                                                style="vertical-align: inherit;">发布</font></font></button>
                            </div>
                        </div>
                    </div>
                </form>
            </div>
        </section>
    </div>
    <footer class="main-footer">
        Thanks for using <strong><a href="/index">知非</a></strong>
    </footer>
    <div class="control-sidebar-bg"></div>
</div>

<script src="https://cdn.staticfile.org/jquery/3.2.1/jquery.min.js"></script>
<script type="text/javascript" src="//unpkg.com/wangeditor/release/wangEditor.min.js" charset="UTF-8"></script>
<script src="/js/writeArticle.js"></script>
<script src="/adminLTE/js/bootstrap.min.js"></script>
<script src="/adminLTE/js/adminlte.min.js"></script>
</body>
</html>