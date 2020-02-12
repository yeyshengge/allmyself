<%--
  Created by IntelliJ IDEA.
  User: ymshe
  Date: 2019/11/8
  Time: 13:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ajax</title>
    <script src="/WEB-INF/js/jquery-3.3.1.min.js"></script>
    <script>
        var list = new Array();
        list.push({username: "zhangsan", age: 18});
        list.push({username: "lisi", age: 30});
        $.ajax({
            type: "POST",
            url: "${pageContext.request.contextPath}/user/test15",
            data: JSON.stringify(list),
            contentType: "application/json;charset=utf-8"
        });

    </script>
</head>
<body>

</body>
</html>
