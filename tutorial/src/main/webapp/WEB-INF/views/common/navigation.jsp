<nav class="navbar navbar-default">
    <div class="container">
        <!-- 2.ヘッダ情報 -->
        <div class="navbar-header">
            <a class="navbar-brand">Tutorial</a>
        </div>
        <!-- 3.リストの配置 -->
        <ul class="nav navbar-nav">
            <li><a href="${pageContext.request.contextPath}">Top Page</a></li>
            <li><a href="${pageContext.request.contextPath}/todo/list">Todo List</a></li>
            <li><a href="${pageContext.request.contextPath}/todo/create?form">Add Todo</a></li>
            <li><a href="${pageContext.request.contextPath}">Shop Page</a></li>
            <li><a href="${pageContext.request.contextPath}/item/">Item</a></li>
            <li><a href="${pageContext.request.contextPath}/cart/">Cart</a></li>
        </ul>
        <!-- 4.ボタン -->
        <button type="button" class="btn btn-default navbar-btn">
            <span class="glyphicon glyphicon-envelope"></span>
        </button>
    </div>
</nav>