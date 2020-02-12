<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: ymshe
  Date: 2019/10/9
  Time: 17:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>案例</title>
</head>
<body>
<%! int sum = 0;
    String str = "";
%>
<%
    if (sum > 0) {
        out.write("你好，欢迎回来，上次访问时间为：" + str);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日　HH:mm:ss");
        Date date = new Date();
        String format = sdf.format(date);
        str = format;
    }


    if (sum == 0) {
        out.write("欢迎你第一次访问");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日　HH:mm:ss");
        Date date = new Date();
        String format = sdf.format(date);
        str = format;
        sum++;
    }


%>


</body>
</html>
