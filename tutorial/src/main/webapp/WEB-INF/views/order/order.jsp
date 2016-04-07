<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Order Form</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/bootstrap/bootstrap-3.3.6-dist/css/bootstrap.min.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/jquery/jquery-1.12.1.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/bootstrap/bootstrap-3.3.6-dist/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container-fluid" id="wrapper">
<jsp:include page="/WEB-INF/views/common/navigation.jsp" />

    <spring:eval var="cart" expression="@sessionCart.cart" />
    <h1>Order</h1>
    <table border="1">
        <thead>
            <tr>
                <th>ID</th>
                <th>ITEM CODE</th>
                <th>QUANTITY</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="item" items="${cart.cartItems}"
                varStatus="rowStatus">
                <tr>
                    <td>${f:h(item.itemId)}</td>
                    <td>${f:h(item.itemCode)}</td>
                    <td>${f:h(item.quantity)}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <form:form modelAttribute="orderForm">
        <%-- (19) --%>
        <form:button>Order</form:button>
    </form:form>
    <div>
        <a href="${pageContext.request.contextPath}/cart">Back to Cart</a>
    </div>
    <div>
        <a href="${pageContext.request.contextPath}/item">Back to Item</a>
    </div>
 </div>
</body>
</html>