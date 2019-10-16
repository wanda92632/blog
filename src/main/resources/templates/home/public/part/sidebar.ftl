<div class="col-md-3 col-xs-12 text-size-14">
    <div class="card mb-2 shadow">
        <img class="card-img-top" src="/img/home.jpg" alt="Card image cap">
        <div class="card-body">
            <p class="card-text indentation">人常常会感受到内心的召唤，如果不去回应它，人就始终不能平静下来，如果去回应它，就意味着必须放弃很多心爱的人和物。<br/><span
                        class="float-right">——吕克·贝松《碧蓝海天》</span></p>
        </div>
    </div>
    <div class="card mb-2 shadow">
        <div class="card-header">
            <i class="fa fa-navicon"></i> 热门文章
        </div>
        <ul class="list-group list-group-flush">
            <#list popularArticle as article>
                <li class="list-group-item over-2"><a
                            href="/getArticleById?articleId=${article.articleId}">${article.title}</a></li>
            </#list>
        </ul>
    </div>
    <div class="card mb-2 shadow">
        <div class="card-header">
            <i class="fa fa-navicon"></i> 最新文章
        </div>
        <ul class="list-group list-group-flush">
            <#list latestArticle as article>
                <li class="list-group-item over-2"><a
                            href="/getArticleById?articleId=${article.articleId}">${article.title}</a></li>
            </#list>
        </ul>
    </div>
    <div class="card mb-2 shadow">
        <div class="card-header">
            <i class="fa fa-navicon"></i> 最新评论
        </div>
        <ul class="list-group list-group-flush">
            <#list latestComment as comment>
                <li class="list-group-item over-2"><a
                            href="/getArticleById?articleId=${comment.articleId}"><strong>${comment.userNickname}</strong>:${comment.commentContent}
                    </a></li>
            </#list>
        </ul>
    </div>
</div>