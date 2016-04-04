<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Item</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/bootstrap/bootstrap-3.3.6-dist/css/bootstrap.min.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/jquery/jquery-1.12.1.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/bootstrap/bootstrap-3.3.6-dist/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container-fluid" id="wrapper">
<jsp:include page="/WEB-INF/views/common/navigation.jsp" />
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
        
        <form:button>Add</form:button>
        
    </form:form>
    </div>
    
    </div>
    <div>
        <a href="${pageContext.request.contextPath}/cart">Go to Cart</a>
    </div>
  </div>
</body>
</html>