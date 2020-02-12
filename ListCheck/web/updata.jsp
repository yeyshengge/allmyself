<%--
  Created by IntelliJ IDEA.
  User: ymshe
  Date: 2019/10/11
  Time: 18:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<!-- 网页使用的语言 -->
<html lang="zh-CN">
<head>
    <%--<base href="<%=basePath%>"/>--%>
    <!-- 指定字符集 -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>修改用户</title>
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <script src="js/jquery-2.1.0.min.js"></script>
    <script src="js/bootstrap.min.js"></script>

    <script>
        window.onload = function () {
            name();
            password();
            gender();
            age();
            qq();
            email();
            jiguan();
        }

        function name() {
            var name = document.getElementById("name");
            name.placeholder = "${user.name}";
            name.value = "${user.name}";
        }

        function password() {
            var password = document.getElementById("password");
            password.value = "${user.password}";
        }

        function gender() {
            if ("${user.gender}" == "男") {
                var man = document.getElementById("man");
                man.checked = "checked";
            } else {
                var feman = document.getElementById("feman");
                feman.checked = "checked";
            }
        }

        function age() {
            var age = document.getElementById("age");
            age.value = "${user.age}";
        }

        function qq() {
            var qq = document.getElementById("qq");
            qq.value = "${user.qq}";
        }

        function email() {
            var email = document.getElementById("email");
            email.value = "${user.email}";
        }

        function jiguan() {
            if ("${user.address}" == "广东") {
                var guangdong = document.getElementById("guangdong");
                guangdong.selected = "selected";
            } else if ("${user.address}" == "广西") {
                var guangxi = document.getElementById("guangxi");
                guangxi.selected = "selected";
            } else if ("${user.address}" == "湖南") {
                var hunan = document.getElementById("hunan");
                hunan.selected = "selected";
            }
        }


    </script>
</head>
<body>
<div class="container" style="width: 400px;">
    <h3 style="text-align: center;">修改联系人</h3>
    <form action="${pageContext.request.contextPath}/UpdataServlet" method="post">
        <div class="form-group">
            <label for="name">姓名：</label>
            <input type="text" class="form-control" id="name" value="" name="name" readonly="readonly"
                   placeholder="请输入姓名"/>
        </div>

        <div class="form-group">
            <label for="name">密码：</label>
            <input type="text" class="form-control" value="" id="password" name="password" placeholder="请输入密码"/>
        </div>

        <div class="form-group">
            <label>性别：</label>
            <input type="radio" name="gender" id="man" value="男"/>男
            <input type="radio" name="gender" id="feman" value="女"/>女
        </div>

        <div class="form-group">
            <label for="age">年龄：</label>
            <input type="text" class="form-control" id="age" name="age" placeholder="请输入年龄"/>
        </div>

        <div class="form-group">
            <label>籍贯：</label>
            <select name="address" class="form-control">
                <option value="广东" id="guangdong">广东</option>
                <option value="广西" id="guangxi">广西</option>
                <option value="湖南" id="hunan">湖南</option>
            </select>
        </div>

        <div class="form-group">
            <label>QQ：</label>
            <input type="text" class="form-control" id="qq" name="qq" placeholder="请输入QQ号码"/>
        </div>

        <div class="form-group">
            <label>Email：</label>
            <input type="text" class="form-control" id="email" name="email" placeholder="请输入邮箱地址"/>
        </div>

        <div class="form-group" style="text-align: center">
            <input class="btn btn-primary" type="submit" value="提交"/>
            <input class="btn btn-default" type="reset" value="重置"/>
            <input class="btn btn-default" type="button" value="返回"/>
        </div>
    </form>
</div>
</body>
</html>