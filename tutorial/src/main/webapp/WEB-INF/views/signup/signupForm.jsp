<h1>Sign Up</h1>
<div id="loginForm">
<div class="container">

<form:form
    action="${pageContext.request.contextPath}/signup"
    method="post"
    modelAttribute="signupForm">

    <div class="form-group">
       <label for="username">E-mail</label>
       <form:input id="email" path="email" class="form-control" />
       <form:errors path="email" cssClass="text-danger"/>
    </div>
        
    <div class="form-group">
        <label for="password">Password</label>
        <form:password id="password" path="password" class="form-control" />
        <form:errors path="password" cssClass="text-danger"/>
    </div>
    
    <div class="form-group">
        <label for="password">Password (Confirm)</label>
        <form:password id="confirmPassword" path="confirmPassword" class="form-control" />
        <form:errors path="confirmPassword" cssClass="text-danger"/>
    </div>
    
    <div class="form-group">
        <botDetect:captcha
            id="springFormCaptcha"
            codeLength="3"
            imageWidth="150"
            imageStyles="graffiti, graffiti2"/>
        <form:input id="captchaCodeText" 
                path="captchaCodeText" 
                value="${message.captchaCodeTextBox}"/>
        <form:errors path="captchaCodeText" cssClass="text-danger"/>
    </div>
   
    <form:button class="btn btn-info">SignUp</form:button>

</form:form>
</div>
</div>