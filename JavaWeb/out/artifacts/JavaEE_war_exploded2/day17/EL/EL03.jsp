<%--
  Created by IntelliJ IDEA.
  User: ymshe
  Date: 2019/10/10
  Time: 18:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>获取值</title>
</head>
<body>


<%
    session.setAttribute("name", "张三");
    session.setAttribute("age", "18");
    request.setAttribute("name", "李四");

%>


${sessionScope.name}
${requestScope.name}
${name}
<%-- 直接写name 如果重名的话，会输出域范围小的 --%>

</body>
</html>
