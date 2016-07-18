<spring:eval var="cart" expression="@sessionCart.cart" />
<h1>Order</h1>
<table class="table table-hover">
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
    <form:button class="btn btn-info">Order</form:button>
</form:form>
<div>
    <a href="${pageContext.request.contextPath}/cart">Back to Cart</a>
</div>
<div>
    <a href="${pageContext.request.contextPath}/item">Back to Item</a>
</div>