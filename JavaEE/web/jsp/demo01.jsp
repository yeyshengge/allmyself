<%--
  Created by IntelliJ IDEA.
  User: ymshe
  Date: 2019/10/9
  Time: 17:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>demo01</title>
</head>
<body>

<% System.out.println("hello jsp");//int a = 6; %>  <!-- 作用在Service方法中,Service方法可以定义什么，该脚本就能定义什么-->
<%! int a = 5; %>       <!-- 定义成员变量或成员方法 -->
<%= ++a %>   <!-- 作用在Service方法中,会输出到页面，输出语句可以定义什么，该脚本就能输出什么 -->



<% out.write("out.write也啦啦啦");%>
<% out.print("out.write也啦啦啦");%>
<% response.getWriter().write("啦啦啦");%>  <!-- 该输出语句永远打印在第一行 -->
<h1> HELLO JSP</h1>
</body>
</html>
