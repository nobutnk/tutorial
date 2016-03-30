<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>OrderItem List</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/bootstrap/bootstrap-3.3.6-dist/css/bootstrap.min.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/jquery/jquery-1.12.1.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/bootstrap/bootstrap-3.3.6-dist/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container-fluid" id="wrapper">
<jsp:include page="/WEB-INF/views/common/navigation.jsp" />
    <h1>OrderItem List</h1>
    <div id="todoForm">
        <%-- messages --%>
        <t:messagesPanel/>
    <hr />
        <div class="container" id="orderItemList">
        <table class="table table-hover">
        <thead>
        <tr>
            <th>id</th>
            <th>name</th>
            <th>category</th>
            <th>finished</th>
            <th>operation</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${items}" var="item">
        
        <%-- for style --%>
        <c:choose>
            <c:when test="${todo.finished}">
                <c:set var="trStyle" value="warning" />
            </c:when>
            <c:otherwise>
                <c:set var="trStyle" value="" />
            </c:otherwise>
        </c:choose>
        <%-- /for style --%>
        
        <tr class="${trStyle}">
            <td>${f:h(item.itemId)}</td>
            <td>${f:h(item.itemName)}</td>
            <td>${f:h(CL_ITEM_CATEGORIES[item.itemCategory])}</td>
            <td>${f:h(item.finished)}</td>
            <td><input
                    type="button" value="add" class="btn btn-info" id="add-${f:h(item.itemId)}"
                    data-n="${f:h(item.itemId)}">
                    </td>
        </tr>
        </c:forEach>
        </tbody>
        </table>
        
        <a href="${pageContext.request.contextPath}/orderitem/list?csv">Download csv</a>
        
        <script type="text/javascript">
        jQuery('[id^=add-]').click(function(){
            $('#addItemId').val($(this).data("n"));
            $('#addItemForm').submit();
        });
        </script>
        
        <%-- for add form --%>
        <form:form id="addItemForm" method="get" action="${pageContext.request.contextPath}/orderitem/add">
            <input type="hidden" name="itemId" id="addItemId">
            <input type="hidden" name="form" >
        </form:form>
        <%-- /for add form --%>
        </div>
    </div>
 </div>
</body>
</html>