<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>if标签</title>
</head>
<body>
<%
    List list = new ArrayList<>();
    list.add(1);
    request.setAttribute("list", list);
    request.setAttribute("number", 4);
%>
<c:if test="${not empty list}">
    遍历list
</c:if>
<c:if test="${number%2==0}">
    是偶数
</c:if>
<c:if test="${number%2==1}">
    是奇数
</c:if>
</body>
</html>
