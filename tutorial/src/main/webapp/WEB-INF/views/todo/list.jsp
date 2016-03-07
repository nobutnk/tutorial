<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Todo List</title>
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
    <h1>Todo List</h1>
    <div id="todoForm">
        <form:form
           action="${pageContext.request.contextPath}/todo/create"
            method="post" modelAttribute="todoForm">
            <form:input path="todoTitle" />
            <form:button>Create Todo</form:button>
        </form:form>
    </div>
    <hr />
    <div id="todoList">
    <table class="table table-hover">
    <thead>
    <tr>
        <th>id</th>
        <th>title</th>
        <th>detail</th>
        <th>finished</th>
        <th>updated_at</th>
        <th>created_at</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${todos}" var="todo">
    <c:choose>
        <c:when test="${todo.finished}">
            <c:set var="trStyle" value="warning" />
        </c:when>
        <c:otherwise>
            <c:set var="trStyle" value="" />
        </c:otherwise>
    </c:choose>
    <tr class="${trStyle}">
        <td>${f:h(todo.todoId)}</td>
        <td>${f:h(todo.todoTitle)}</td>
        <td>${f:h(todo.todoDetail)}</td>
        <td>${f:h(todo.finished)}</td>
        <td><fmt:formatDate pattern="yyyy/MM/dd HH:mm:ss" value="${todo.updatedAt}" /></td>
        <td><fmt:formatDate pattern="yyyy/MM/dd HH:mm:ss" value="${todo.createdAt}" /></td>
    </tr>
    </c:forEach>
    </tbody>
    </table>
    </div>
 </div>
</body>
</html>