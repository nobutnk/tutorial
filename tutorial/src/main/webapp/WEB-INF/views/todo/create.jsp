<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Add Todo</title>
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
    <h1>Add Todo</h1>
    <div id="todoForm">
        <t:messagesPanel />
        <div class="container">
        <form:form
           action="${pageContext.request.contextPath}/todo/create"
            method="post" modelAttribute="todoForm">
            <div class="form-group">
                <label for="todoTitle">Title</label>
                <form:input path="todoTitle" class="form-control"/>
                <form:errors path="todoTitle" />
            </div>
            <div class="form-group">
                <label for="todoDetail">Detail</label>
                <form:input path="todoDetail" class="form-control"/>
                <form:errors path="todoDetail" />
            </div>
            <form:button>Create Todo</form:button>
        </form:form>
        </div>
    </div>
    <hr />
</div>
</body>
</html>