<%--
  Created by IntelliJ IDEA.
  User: ymshe
  Date: 2019/10/11
  Time: 8:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="zh-CN">
<head>
    <meta charset="utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <title>首页</title>

    <!-- 1. 导入CSS的全局样式 -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <!-- 2. jQuery导入，建议使用1.9以上的版本 -->
    <script src="js/jquery-2.1.0.min.js"></script>
    <!-- 3. 导入bootstrap的js文件 -->
    <script src="js/bootstrap.min.js"></script>
    <script type="text/javascript">
    </script>
</head>
<body>
<div align="center">

    <div>
        <h1>欢迎你成功登陆： <span id="span">${username}</span></h1>
    </div>


    <a
            href="${pageContext.request.contextPath}/PageServlet" style="text-decoration:none;font-size:33px">查询所有用户信息
    </a>
    <script>
        var test = document.getElementById("span");
        var i = 0;

        function fun() {
            i++;
            if (i % 7 == 0) {
                test.style.color = "red";
            } else if (i % 7 == 1) {
                test.style.color = "blue";
            } else if (i % 7 == 2) {
                test.style.color = "yellow";
            } else if (i % 7 == 3) {
                test.style.color = "green";
            } else if (i % 7 == 4) {
                test.style.color = "black";
            } else if (i % 7 == 5) {
                test.style.color = "white";
            } else {
                test.style.color = "pink";
            }
            var date = Math.random() * 500;
            setTimeout("fun()", date);
        }

        fun();


    </script>
</div>
</body>
</html>
