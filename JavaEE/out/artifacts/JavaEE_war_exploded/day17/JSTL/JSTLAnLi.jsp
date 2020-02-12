<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="day17.User" %><%--
  Created by IntelliJ IDEA.
  User: ymshe
  Date: 2019/10/10
  Time: 21:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>案例</title>
</head>
<body>
<%
    User user1 = new User(1, "张三", 18);
    User user2 = new User(2, "李四", 22);
    User user3 = new User(3, "王五", 17);
    User user4 = new User(4, "赵六", 38);

    List<User> list = new ArrayList<>();
    list.add(user1);
    list.add(user2);
    list.add(user3);
    list.add(user4);
    request.setAttribute("list", list);

%>
<table border="1px solid black">
    <tr>
        <td>ID</td>
        <td>姓名</td>
        <td>年龄</td>
    </tr>
    <C:forEach items="${list}" var="user" varStatus="s" >
        <c:if test="${s.count%2==0}">
            <tr bgcolor="red">
        </c:if>
        <c:if test="${s.count%2!=0}">
            <tr bgcolor="green">
        </c:if>
        <td>${user.id}</td>
        <td>${user.name}</td>
        <td>${user.age}</td>
        </tr>
    </C:forEach>
</table>


</body>
</html>
