<h1>Order Complete</h1>
ORDER ID :
${f:h(order.orderId)}
<table class="table table-hover">
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
                <td>${f:h(item.itemId)}</td>
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