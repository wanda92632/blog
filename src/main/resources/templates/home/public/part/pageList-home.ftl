<li class="mb-3">
    <div class="col-md-12 mb-5 text-size-12">
        <nav aria-label="Page navigation example">
            <ul class="pagination justify-content-center">
                    <#if page?number == 1 >
                        <li class="page-item disabled">
                            <a class="page-link" href="/?page=${page?number - 1}">上一页</a>
                        </li>
                    </#if>

                    <#if page?number!=1 >
                        <li class="page-item">
                            <a class="page-link" href="/?page=${page?number-1}">上一页</a>
                        </li>
                    </#if>


                    <#if (page?number>1)>
                        <#list 1..(page?number-1) as i>
                            <li class="page-item">
                                <a class="page-link" href="/?page=${i}">${i}</a>
                            </li>
                        </#list>
                    </#if>

                <#--当前页标签-->
                    <li class=" page-item active">
                        <a class="page-link" href="/?page=${page}">${page}</a>
                    </li>

                <#--后续页标签-->
                    <#if pageCount?number gt page?number >
                        <#list (page?number+1)..(pageCount?number) as i>
                            <li class="page-item">
                                <a class="page-link" href="/?page=${i}">${i}</a>
                            </li>
                        </#list>
                    </#if>

                    <#if page?number==pageCount?number>
                        <li class=" page-item disabled">
                            <a class="page-link" href="/?page=${page?number+1}">下一页</a>
                        </li>
                    </#if>

                    <#if pageCount?number gt page?number>
                        <li class=" page-item">
                            <a class="page-link" href="/?page=${page?number+1}">下一页</a>
                        </li>
                    </#if>
            </ul>
        </nav>
    </div>
</li>