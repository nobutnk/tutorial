<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Home</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/bootstrap/bootstrap-3.3.6-dist/css/bootstrap.min.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/jquery/jquery-1.12.1.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/bootstrap/bootstrap-3.3.6-dist/js/bootstrap.min.js"></script>
</head>
<body>
<jsp:include page="/WEB-INF/views/common/navigation.jsp" />
    <div class="container-fluid" id="wrapper">
        <h1>Hello world!</h1>
        <span class="label label-info">The time on the server is ${serverTime}.</span>
        
        <h2>Menu</h2>
        <ul>
            <li><a href="${pageContext.request.contextPath}/todo/list">Todo List</a></li>
        </ul>
    </div>
</body>
</html>
