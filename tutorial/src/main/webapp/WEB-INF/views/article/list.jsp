<h1>Article List</h1>
<div id="articleForm">
    <%-- messages --%>
    <t:messagesPanel/>
    <div class="container">
    <a href="${pageContext.request.contextPath}/article/upload?form">Upload Article</a>
    </div>
<hr />
    <div class="container" id="articleList">
    <table class="table table-hover">
    <thead>
    <tr>
        <th>id</th>
        <th>description</th>
        <th>filename</th>
        <th>contentType</th>
        <th>updated_at</th>
        <th>created_at</th>
        <th>operation</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${articles}" var="article">
    
    <tr>
        <td>${f:h(article.articleId)}</td>
        <td>${f:h(article.description)}</td>
        <td>${f:h(article.filename)}</td>
        <td>${f:h(article.contentType)}</td>
        <td><fmt:formatDate pattern="yyyy/MM/dd HH:mm:ss" value="${article.updatedAt}" /></td>
        <td><fmt:formatDate pattern="yyyy/MM/dd HH:mm:ss" value="${article.createdAt}" /></td>
        <td><input
                type="button" value="download" class="btn btn-info" id="download-${f:h(article.articleId)}"
                data-n="${f:h(article.articleId)}">
            <input
                type="button" value="delete" class="btn btn-warning" id="delete-${f:h(article.articleId)}"
                data-n="${f:h(article.articleId)}" data-m='<fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss.SSS" value="${article.updatedAt}" />'>
                </td>
    </tr>
    </c:forEach>
    </tbody>
    </table>
    
    <script type="text/javascript">
    jQuery('[id^=download-]').click(function(){
        $('#downloadArticleId').val($(this).data("n"));
        $('#downloadArticleForm').submit();
    });
    jQuery('[id^=delete-]').click(function(){
        $('#deleteArticleId').val($(this).data("n"));
        $('#deleteUpdatedAt').val($(this).data("m"));
        $('#deleteArticleForm').submit();
    });
    </script>
    
    <%-- for update form --%>
    <form:form id="downloadArticleForm" method="get" action="${pageContext.request.contextPath}/article/download">
        <input type="hidden" name="articleId" id="downloadArticleId">
        <input type="hidden" name="form" >
    </form:form>
    <%-- /for update form --%>
    <%-- for delete form --%>
    <form:form id="deleteArticleForm" method="post" action="${pageContext.request.contextPath}/todo/delete">
        <input type="hidden" name="articleId" id="deleteArticleId">
        <input type="hidden" name="updatedAt" id="deleteUpdatedAt">
    </form:form>
    <%-- /for delete form --%>
    </div>
</div>