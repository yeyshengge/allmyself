<%--
  Created by IntelliJ IDEA.
  User: ymshe
  Date: 2019/10/9
  Time: 20:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录成功</title>
</head>
<body>
<%
    HttpSession session1 = request.getSession();
    Object username = session1.getAttribute("username");

%>
<%=
"登录成功 ：" + username + "欢迎你"
%>
</body>
</html>
