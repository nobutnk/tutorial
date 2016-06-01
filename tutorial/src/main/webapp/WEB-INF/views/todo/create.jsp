<h1>Add Todo</h1>
<div id="todoForm">
    <t:messagesPanel />
    <div class="container">
    
    <%-- for action --%>
    <c:choose>
        <c:when test="${!empty todoForm.todoId}">
            <c:set var="targetAction" value="update" />
        </c:when>
        <c:otherwise>
            <c:set var="targetAction" value="create" />
        </c:otherwise>
    </c:choose>
    <%-- /for action --%>
    
    
    <form:form
       action="${pageContext.request.contextPath}/todo/${targetAction}"
        method="post" modelAttribute="todoForm">
        
        <form:errors path="*" element="div" cssClass="error-message-list" />
        <div class="form-group">
            <label for="todoTitle">Title</label>
            <form:input path="todoTitle" class="form-control maxlength" maxlength="30"/>
            <form:errors path="todoTitle" cssClass="text-danger"/>
        </div>
        <div class="form-group">
            <label for="todoCategory">Category</label>
            <form:select path="todoCategory" class="form-control">
                <form:option value="" label="--Select--" />
                <form:options items="${CL_TODO_CATEGORIES}" />
            </form:select>
        </div>
        <div class="form-group">
            <label for="todoDetail">Detail</label>
            <form:input path="todoDetail" class="form-control maxlength" maxlength="100"/>
            <form:errors path="todoDetail" cssClass="text-danger"/>
        </div>
        <script type="text/javascript">
        $(function () {
            $('.maxlength').maxlength({
                alwaysShow: true,
                threshold: 1,
                warningClass: "label label-success",
                limitReachedClass: "label label-danger"
            });
        });
        </script>
        <div class="form-group">
            <label for="dueDate">DueDate</label>
            <div class="input-group date" id="datetimepicker">
                <form:input path="dueDate" class="form-control"/>
                <span class="input-group-addon">
                    <span class="glyphicon glyphicon-calendar"></span>
                </span>
            </div>
            <form:errors path="dueDate" cssClass="text-danger"/>
        </div>
        <script type="text/javascript">
        $(function () {
            $('#datetimepicker').datepicker({
                format: "yyyy-mm-dd",
                autoclose: true
            });
        });
        </script>
        <div class="form-group">
            <label for="parties">parties</label>
            <form:select path="parties" class="form-control" multiple="true">
                <form:option value="" label="--Select--" />
                <form:options items="${CL_PARTIES}" />
            </form:select>
        </div>
        <div class="form-group">
            <label for="publicTodo">public</label>
            <form:checkbox path="publicTodo" class="form-control" label="公開" value="true"/>
            <form:errors path="publicTodo" cssClass="text-danger"/>
        </div>
        
        <form:button class="btn btn-info">Create Todo</form:button>
    </form:form>
    </div>
</div>