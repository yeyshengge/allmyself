<%@ page import="day17.User" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: ymshe
  Date: 2019/10/31
  Time: 11:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%
    request.setAttribute("name", "张三");
    session.setAttribute("name", "李四");
    User user = new User();
    user.setName("王五");
    user.setAge(18);
    user.setId(1);
    List list = new ArrayList<>();
    list.add("aaa");
    list.add("bbb");
    list.add(user);
    request.setAttribute("list", list);
%>
<h1>user对象</h1>
${user.name}
${user.age}
${user.id}
${user.birth}


<h1>dad</h1>
${sessionScope.name}
</body>
</html>
<h2>list集合演示</h2>
${list[0]}
${list[1]}
${list[2].name}
${list[2].id}
${list[2].age}

<h4>empty</h4>
${empty list}    \${empty list}

${not empty list} \${not empty list}

<h5>动态获取虚拟目录</h5>
${pageContext.request.contextPath}
${pageContext.request.contextPath}
${pageContext.request.comtextPath}
${pageContext.request.contextPath}
${pageContext.request.contextPath}