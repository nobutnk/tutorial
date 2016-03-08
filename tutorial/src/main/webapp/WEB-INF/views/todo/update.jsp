<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Update Todo</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/bootstrap/bootstrap-3.3.6-dist/css/bootstrap.min.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/jquery/jquery-1.12.1.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/bootstrap/bootstrap-3.3.6-dist/js/bootstrap.min.js"></script>
<style type="text/css">
.strike {
    text-decoration: line-through;
}
</style>
</head>
<body>
<div class="container-fluid" id="wrapper">
<jsp:include page="/WEB-INF/views/common/navigation.jsp" />
    <h1>Update Todo</h1>
    <div id="todoForm">
        <t:messagesPanel />
        <div class="container">
        
        
        <form:form
           action="${pageContext.request.contextPath}/todo/update"
            method="post" modelAttribute="todoForm">
            
            <form:errors path="*" element="div" cssClass="error-message-list" />
            <div class="form-group">
                <label for="todoId">Id</label>
                <form:input path="todoId" class="form-control" readonly="true"/>
                <form:errors path="todoId" cssClass="text-danger"/>
            </div>
            <div class="form-group">
                <label for="todoTitle">Title</label>
                <form:input path="todoTitle" class="form-control" value="${f:h(todo.todoTitle)}"/>
                <form:errors path="todoTitle" cssClass="text-danger"/>
            </div>
            <div class="form-group">
                <label for="todoDetail">Detail</label>
                <form:input path="todoDetail" class="form-control" value="${f:h(todo.todoDetail)}"/>
                <form:errors path="todoDetail" cssClass="text-danger"/>
            </div>
            <form:hidden path="updatedAt" value="${todo.updatedAt}" />
            <form:button>Update Todo</form:button>
        </form:form>
        </div>
    </div>
    <hr />
</div>
</body>
</html>