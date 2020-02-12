<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ymshe
  Date: 2019/12/4
  Time: 20:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table>
    <tr>
        <th>id</th>
        <th>姓名</th>
        <th>金额</th>
    </tr>
    <c:forEach var="account" items="${list}" >
    <tr>
        <th>${account.id}</th>
        <th>${account.username}</th>
        <th>${account.money}</th>

    </tr>
    </c:forEach>
</table>
</body>
</html>
