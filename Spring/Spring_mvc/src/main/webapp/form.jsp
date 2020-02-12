<%--
  Created by IntelliJ IDEA.
  User: ymshe
  Date: 2019/11/8
  Time: 10:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>form</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/user/test14" method="post">
    <input type="text" name="list[0].username">
    <input type="text" name="list[0].age">
    <input type="text" name="list[1].username">
    <input type="text" name="list[1].age">
    <input type="submit" value="提交">
</form>
</body>
</html>
