<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>知非博客-仪表盘</title>
    <link rel="shortcut icon" href="/img/favicon.ico" />
    <link rel="bookmark"href="/img/favicon.ico" />
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
    <link rel="stylesheet" href="/adminLTE/css/bootstrap.min.css" type="text/css" charset="UTF-8">
    <link rel="stylesheet" href="/adminLTE/css/font-awesome.min.css" type="text/css" charset="UTF-8">
    <link rel="stylesheet" href="/adminLTE/css/ionicons.min.css" type="text/css" charset="UTF-8">
    <link rel="stylesheet" href="/adminLTE/css/AdminLTE.min.css" type="text/css" charset="UTF-8">
    <link rel="stylesheet" href="/adminLTE/css/skin-blue.min.css" type="text/css" charset="UTF-8">

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
<body class="hold-transition  skin-blue sidebar-mini">
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
                <li class="active"><a href="/admin/index"><i class="fa fa-dashboard"></i> <span>仪表盘</span></a></li>
                <li class="treeview">
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
                仪表盘
            </h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> 首页</a></li>
                <li class="active">仪表盘</li>
            </ol>
        </section>

        <!-- 主要内容 -->
        <section class="content ">
            <div class="row">
                <div class="col-lg-3 col-xs-6">
                    <!-- small box -->
                    <div class="small-box bg-aqua">
                        <div class="inner">
                            <h3>${userSum}</h3>

                            <p>用户数</p>
                        </div>
                        <div class="icon">
                            <i class="fa fa-shopping-cart"></i>
                        </div>
                        <a href="#" class="small-box-footer">
                            查看更多 <i class="fa fa-arrow-circle-right"></i>
                        </a>
                    </div>
                </div>
                <!-- ./col -->
                <div class="col-lg-3 col-xs-6">
                    <!-- small box -->
                    <div class="small-box bg-green">
                        <div class="inner">
                            <h3>${articleSum}</h3>

                            <p>文章数</p>
                        </div>
                        <div class="icon">
                            <i class="ion ion-stats-bars"></i>
                        </div>
                        <a href="#" class="small-box-footer">
                            查看更多 <i class="fa fa-arrow-circle-right"></i>
                        </a>
                    </div>
                </div>
                <!-- ./col -->
                <div class="col-lg-3 col-xs-6">
                    <!-- small box -->
                    <div class="small-box bg-yellow">
                        <div class="inner">
                            <h3>${commentSum}</h3>

                            <p>评论数</p>
                        </div>
                        <div class="icon">
                            <i class="ion ion-person-add"></i>
                        </div>
                        <a href="#" class="small-box-footer">
                            查看更多 <i class="fa fa-arrow-circle-right"></i>
                        </a>
                    </div>
                </div>
                <!-- ./col -->
                <div class="col-lg-3 col-xs-6">
                    <!-- small box -->
                    <div class="small-box bg-red">
                        <div class="inner">
                            <h3>嘻嘻</h3>

                            <p>充数</p>
                        </div>
                        <div class="icon">
                            <i class="ion ion-pie-graph"></i>
                        </div>
                        <a href="#" class="small-box-footer">
                            查看更多 <i class="fa fa-arrow-circle-right"></i>
                        </a>
                    </div>
                </div>
                <!-- ./col -->
            </div>
        </section>
        <!-- /.content -->
    </div>
    <!-- /.content-wrapper -->

    <!-- 主页的页脚 -->
    <footer class="main-footer">
        <!-- To the right -->
        <!-- Default to the left -->
        Thanks for using <strong><a href="/index">知非</a></strong>
    </footer>

    <!-- /.control-sidebar -->
    <!-- Add the sidebar's background. This div must be placed
    immediately after the control sidebar -->
    <div class="control-sidebar-bg"></div>
</div>
<!-- ./wrapper -->

<!-- REQUIRED JS SCRIPTS -->

<!-- jQuery 3 -->
<script src="/adminLTE/js/jquery.min.js"></script>
<!-- Bootstrap 3.3.7 -->
<script src="/adminLTE/js/bootstrap.min.js"></script>
<!-- AdminLTE App -->
<script src="/adminLTE/js/adminlte.min.js"></script>

<!-- Optionally, you can add Slimscroll and FastClick plugins.
     Both of these plugins are recommended to enhance the
     user experience. -->
</body>
</html>