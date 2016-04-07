<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Cart</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/bootstrap/bootstrap-3.3.6-dist/css/bootstrap.min.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/jquery/jquery-1.12.1.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/bootstrap/bootstrap-3.3.6-dist/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container-fluid" id="wrapper">
<jsp:include page="/WEB-INF/views/common/navigation.jsp" />
    <%-- (16) --%>
    <spring:eval var="cart" expression="@sessionCart.cart" />
    <h1>Cart</h1>
    <c:choose>
        <c:when test="${ empty cart.cartItems }">
            <div>Cart is empty.</div>
        </c:when>
        <c:otherwise>
            CART ID :
            ${f:h(cart.cartId)}
            <form:form modelAttribute="cartForm">
                <table class="table table-hover">
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>ITEM CODE</th>
                            <th>QUANTITY</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="item"
                            items="${cart.cartItems}"
                            varStatus="rowStatus">
                            <tr>
                                <td>${f:h(item.itemId)}</td>
                                <td>${f:h(item.itemCode)}</td>
                                <td>
                                    <form:input
                                        path="cartItems[${rowStatus.index}].quantity" />
                                    <form:errors
                                        path="cartItems[${rowStatus.index}].quantity" />
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
                <%-- (17) --%>
                <form:button class="btn btn-info" name="edit">Save</form:button>
            </form:form>
        </c:otherwise>
    </c:choose>
    <c:if test="${ not empty cart.cartItems }">
        <div>
            <%-- (18) --%>
            <a href="${pageContext.request.contextPath}/order">Go to Order</a>
        </div>
    </c:if>
    <div>
        <a href="${pageContext.request.contextPath}/item">Back to Item</a>
    </div>
 </div>
</body>
</html>