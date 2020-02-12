<%--
  Created by IntelliJ IDEA.
  User: ymshe
  Date: 2019/11/8
  Time: 19:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>upload</title>
</head>
<body>
<form method="post" action="${pageContext.request.contextPath}/user/test21" enctype="multipart/form-data">
    文件名<input type="text" name="username">
    文件<input type="file" name="multipartFile">
    <input type="submit" value="提交">

</form>

</body>
</html>
