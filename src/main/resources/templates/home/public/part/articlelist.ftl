<#list articleList as article>
    <li class="mb-3">
        <div class="card shadow article">
            <div class="card-body p-3">
                <div>
                    <#--文章标题-->
                    <h6 class="card-title mb-2 over-2"><a
                                href="/getArticleById?articleId=${article.articleId}">
                            ${article.title}</a></h6>
                    <#--文章相关信息-->
                    <div class="over-1 mb-1 introduction">${article.introduction}</div>
                </div>
                <div>
                    <div class="text-muted text-size-12">
                        <ul class="list-group flex-row mx-0">
                            <li class="list-group-item border-0 p-0 mx-1">
                                <#--文章作者头像-->
                                <img class="img-fluid icon-article rounded-circle"
                                     src="${article.user.userIcon}"
                                     alt="头像">
                            </li>
                            <li class="list-group-item border-0 p-0 mx-1">
                                <#--文章作者昵称-->
                                <a class="text-muted"
                                   href="/userInfo?userId=${article.user.userId}">${article.user.userNickname}</a>
                            </li>
                            <li class="list-group-item border-0 p-0 mx-1 bg-${article.category.categoryColor} rounded">
                                <#--文章类型-->
                                <span class="px-1 text-white">${article.category.categoryName}</span>
                            </li>
                            <li class="list-group-item border-0 p-0 mx-1">
                                <#--阅读数-->
                                <i class="fa fa-eye"></i> ${article.viewed}
                            </li>
                            <li class="list-group-item border-0 p-0 mx-1">
                                <#--创建时间-->
                                ${article.creationTime}
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </li>
</#list>