<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>save</title>
</head>
<body>

<form name="saveForm" action="${pageContext.request.contextPath}/account/save" method="post">
    姓名<input name="username" type="text">
    金额<input name="money" type="text">
    <input type="submit">
</form>
</body>
</html>
