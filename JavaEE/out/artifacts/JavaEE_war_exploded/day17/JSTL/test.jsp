<%@ page import="java.util.List" %>
<%@ page import="day17.User" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: ymshe
  Date: 2019/10/31
  Time: 15:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>


<%
    request.setAttribute("number", 6);
%>

<%--c:if标签，test里面是true才执行里面的语句--%>
<%--c:if标签没有else标签，如果想要，只能写两个c:if标签--%>

<c:if test="${number%2==0}">
    ${number}是偶数
</c:if>
<c:if test="${number%2==1}">
    ${number}是奇数
</c:if>

<hr>

<%
    request.setAttribute("num", 2);
%>

<c:choose>
    <c:when test="${num ==1 }">星期一</c:when>
    <c:when test="${num ==2 }">星期二</c:when>
    <c:when test="${num ==3 }">星期三</c:when>
    <c:when test="${num ==4 }">星期四</c:when>
    <c:when test="${num ==5 }">星期五</c:when>
    <c:when test="${num ==6 }">星期六</c:when>
    <c:when test="${num ==7 }">星期日</c:when>
    <c:otherwise>输入有误</c:otherwise>
</c:choose>


<hr>
<c:forEach begin="1" end="10" step="1" var="i">${i}</c:forEach>

<hr>
<%
    List<User> list = new ArrayList<>();
    User user1 = new User(1, "张三", 23);
    User user2 = new User(1, "李四", 24);
    User user3 = new User(1, "王五", 25);
    list.add(user1);
    list.add(user2);
    list.add(user3);
    request.setAttribute("list", list);
%>

<table border="1px solid black">
    <tr>
        <td>编号</td>
        <td>姓名</td>
        <td>年龄</td>
    </tr>
    <c:forEach items="${list}" var="user">
        <tr>
            <td>${user.id}</td>
            <td>${user.name}</td>
            <td>${user.age}</td>
        </tr>

    </c:forEach>

</table>



</body>
</html>
