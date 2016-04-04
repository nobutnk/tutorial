<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Order Complete</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/bootstrap/bootstrap-3.3.6-dist/css/bootstrap.min.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/jquery/jquery-1.12.1.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/bootstrap/bootstrap-3.3.6-dist/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container-fluid" id="wrapper">
<jsp:include page="/WEB-INF/views/common/navigation.jsp" />

    <h1>Order Complete</h1>
    ORDER ID :
    ${f:h(order.id)}
    <table border="1">
        <thead>
            <tr>
                <th>ID</th>
                <th>ITEM CODE</th>
                <th>QUANTITY</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="item" items="${order.orderItems}"
                varStatus="rowStatus">
                <tr>
                    <td>${f:h(item.id)}</td>
                    <td>${f:h(item.itemCode)}</td>
                    <td>${f:h(item.quantity)}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <br>
    <div>
        <a href="${pageContext.request.contextPath}/item">Back to Item</a>
    </div>
  </div>
</body>
</html>