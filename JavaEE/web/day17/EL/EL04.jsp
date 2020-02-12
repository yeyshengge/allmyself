<%@ page import="day17.User" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.Map" %><%--
  Created by IntelliJ IDEA.
  User: ymshe
  Date: 2019/10/10
  Time: 19:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>获取对象的值</title>
</head>
<body>
<%
    User u = new User(1, "张三", 20);
    request.setAttribute("u", u);


    List list = new ArrayList<>();
    list.add("a");
    list.add("b");
    list.add(u);
    request.setAttribute("list", list);

    Map map = new HashMap<>();
    map.put("name", "张三map");
    map.put("age", "18map");
    map.put("user", u);
    request.setAttribute("map", map);

%>
<%--  域名称.键名.属性名  --%>

${requestScope.u.name}<br>
${requestScope.u.id}<br>
${requestScope.u.age}<br>

<h1>获取List集合</h1>
${list[0]}<br>
${list[1]}<br>
${list[2].name}<br>
${list[2].age}<br>
<h1>获取Map集合</h1>
${map.name}<br>
${map.age}<br>
${map.user.name}<br>
${map.user.age}<br>
</body>
</html>
