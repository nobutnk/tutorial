<h1>Login Screen</h1>
<div id="loginForm">
<div class="container">

<c:if test="${param.error}">
    <t:messagesPanel messagesType="error"
        messagesAttributeName="SPRING_SECURITY_LAST_EXCEPTION"/>
</c:if>

<form:form
    action="${pageContext.request.contextPath}/login"
    method="post"
    modelAttribute="loginForm">

    <div class="form-group">
       <label for="username">User Name</label>
       <form:input id="username" path="username" class="form-control" />
       <form:errors path="username" cssClass="text-danger"/>
    </div>
        
    <div class="form-group">
        <label for="password">Password</label>
        <form:password id="password" path="password" class="form-control" />
        <form:errors path="password" cssClass="text-danger"/>
    </div>
   
    <form:button class="btn btn-info">Login</form:button>

</form:form>
</div>
</div>