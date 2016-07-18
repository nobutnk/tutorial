<h1>Item</h1>
<div id="itemForm">

    <t:messagesPanel />
    <div class="container">
    
    <form:form action="${pageContext.request.contextPath}/item/add"
        modelAttribute="itemForm">
        
    <div class="form-group">
        <form:label path="itemCode">Item Code</form:label>
        <form:input path="itemCode" class="form-control"/>
        <form:errors path="itemCode" cssClass="text-danger"/>
    </div>
    <div class="form-group">
        <form:label path="quantity">Quantity</form:label> :
        <form:input path="quantity" class="form-control"/>
        <form:errors path="quantity" cssClass="text-danger"/>
    </div>
    
    <form:button class="btn btn-info">Add Cart</form:button>
    
</form:form>
</div>

</div>
<div>
    <a href="${pageContext.request.contextPath}/cart">Go to Cart</a>
</div>