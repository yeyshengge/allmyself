<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>choose标签</title>
</head>
<body>
<%
  request.setAttribute("week",6);
%>

<%--
choose     相当于  wtitch
when       相当于  case
otherwish  相当于  default


--%>
<c:choose>
    <c:when test="${week==1}">星期一</c:when>
    <c:when test="${week==2}">星期二</c:when>
    <c:when test="${week==3}">星期三</c:when>
    <c:when test="${week==4}">星期四</c:when>
    <c:when test="${week==5}">星期五</c:when>
    <c:when test="${week==6}">星期六</c:when>
    <c:when test="${week==7}">星期日</c:when>
    <c:otherwise>你的输入有误</c:otherwise>
</c:choose>



</body>
</html>
