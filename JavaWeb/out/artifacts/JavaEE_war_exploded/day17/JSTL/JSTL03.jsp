<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: ymshe
  Date: 2019/10/10
  Time: 20:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>foreach标签</title>
</head>
<body>
<c:forEach begin="1" end="10" varStatus="s" step="1" var="i">

    ${i} <h3>${s.index}</h3>  <h5> ${s.count}</h5>
    <h1>看看我</h1>
</c:forEach>


<%
    List list = new ArrayList<>();
    list.add(111);
    list.add(222);
    request.setAttribute("list", list);

%>

<c:forEach items="${list}" var="str">
    ${str}
</c:forEach>
</body>
</html>
