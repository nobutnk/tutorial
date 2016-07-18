<h1>Article Upload</h1>
<div id="articleForm">
    <t:messagesPanel />
    <div class="container">
    
    <form:form
        action="${pageContext.request.contextPath}/article/upload"
        method="post"
        modelAttribute="articleForm" enctype="multipart/form-data">
        
        <form:errors path="*" element="div" cssClass="error-message-list" />
        <div class="form-group">
            <label for="file">File</label>
            <form:input type="file" path="file" class="form-control"/>
            <form:errors path="file" cssClass="text-danger"/>
        </div>
        <div class="form-group">
            <label for="description">description</label>
            <form:input path="description" class="form-control" />
            <form:errors path="description" cssClass="text-danger"/>
        </div>
        <form:button class="btn btn-info">Upload Article</form:button>
    </form:form>
    </div>
</div>