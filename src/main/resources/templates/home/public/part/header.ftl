<header class="navbar navbar-expand-lg sticky-top bg-white">
    <button class="navbar-toggler nav-button" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
            aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <i class="fa fa-bars"></i>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mx-auto">
            <li class="nav-item">
                <a class="nav-link" href="/">主页</a>
            </li>
            <#list categoryList as category>
                <li class="nav-item">
                    <a class="nav-link"
                       href="/getArticleByCategory?categoryName=${category.categoryName}">${category.categoryName}</a>
                </li>
            </#list>
        </ul>
        <div class="mx-auto">
            <ul class="navbar-nav">
                <li class="nav-item mr-5">
                    <form action="/getArticleByTitle" method="get" class="form-inline my-0 my-lg-0">
                        <div class="input-group mb-0">
                            <div class="input-group-prepend border text-muted">
                                <button class="btn btn-link  my-0 my-sm-0" type="submit"><i class="fa fa-search"></i>
                                </button>
                            </div>
                            <input class="form-control mr-sm-0" name="title" type="search" placeholder="请输入搜索的内容">
                        </div>
                    </form>
                </li>
                <@shiro.notAuthenticated>
                    <li class="nav-item">
                        <a class="nav-link" href="/registered">注册</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/loginPage">登录</a>
                    </li>
                </@shiro.notAuthenticated>
                <@shiro.authenticated>
                    <li class="dropdown">
                        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button"
                           data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            <#if user?? >${user.userNickname}</#if>
                        </a>
                        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                            <a class="dropdown-item" href="/admin/adminPersonal">个人资料</a>
                            <a class="dropdown-item" href="/admin/index">用户中心</a>
                            <a class="dropdown-item" href="/logout">注销</a>
                        </div>
                    </li>
                </@shiro.authenticated>
            </ul>
        </div>
    </div>
</header>