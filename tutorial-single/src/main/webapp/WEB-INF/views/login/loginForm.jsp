<h1>Login Screen</h1>
<div id="loginForm">
<div class="container">

<c:if test="${param.error}">
    <t:messagesPanel messagesType="error"
        messagesAttributeName="SPRING_SECURITY_LAST_EXCEPTION"/>
</c:if>

<form:form
    action="${pageContext.request.contextPath}/login"
    method="post">

    <div class="form-group">
       <label for="username">User Name</label>
       <input type="text" id="username" name="username" class="form-control" >
    </div>
        
    <div class="form-group">
        <label for="password">Password</label>
        <input type="password" id="password" name="password" class="form-control" >
    </div>
   
    <button class="btn btn-info">Login</button>

</form:form>

<div>
    <a href="${pageContext.request.contextPath}/signup?form">Signup</a>
</div>

</div>
</div>