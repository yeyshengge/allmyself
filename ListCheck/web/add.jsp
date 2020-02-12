<%--
  Created by IntelliJ IDEA.
  User: ymshe
  Date: 2019/10/12
  Time: 15:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- HTML5文档-->
<!DOCTYPE html>
<!-- 网页使用的语言 -->
<html lang="zh-CN">
<head>
    <!-- 指定字符集 -->
    <meta charset="utf-8">
    <!-- 使用Edge最新的浏览器的渲染方式 -->
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <!-- viewport视口：网页可以根据设置的宽度自动进行适配，在浏览器的内部虚拟一个容器，容器的宽度与设备的宽度相同。
    width: 默认宽度与设备的宽度相同
    initial-scale: 初始的缩放比，为1:1 -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>添加用户</title>

    <!-- 1. 导入CSS的全局样式 -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <!-- 2. jQuery导入，建议使用1.9以上的版本 -->
    <script src="js/jquery-2.1.0.min.js"></script>
    <!-- 3. 导入bootstrap的js文件 -->
    <script src="js/bootstrap.min.js"></script>
    <script>
        window.onload = function () {
            var form = document.getElementById("form");
            form.onsubmit = function () {
                return check_n() && check_p() && check_s() && check_p();
            }

            document.getElementById("name").onblur = check_n;
            document.getElementById("password").onblur = check_p;
            document.getElementById("age").onblur = check_a;
            document.getElementById("qq").onblur = check_q;
        }

        function check_q() {
            var qq = document.getElementById("qq").value;
            var exp_q = /^\d{6,12}$/;
            var q = exp_q.test(qq);
            var qs = document.getElementById("qs");
            if (q) {
                qs.innerText = "正确,√";
                qs.style.color = "green";
            } else {
                qs.innerText = "请输入6-12位数字";
                qs.style.color = "red";
            }
            return q;
        }

        function check_a() {
            var age = document.getElementById("age").value;
            var exp_s = /^\d{1,3}$/;
            var a = exp_s.test(age);
            var as = document.getElementById("as");
            if (a) {
                as.innerText = "正确,√";
                as.style.color = "green";
            } else {
                as.innerText = "请输入1-3位数字";
                as.style.color = "red";
            }
            return a;
        }


        function check_p() {
            var password = document.getElementById("password").value;
            var exp_p = /^[0-9a-zA-Z_]{6,8}$/;
            var p = exp_p.test(password);
            var ps = document.getElementById("ps");
            if (p) {
                ps.innerText = "正确,√";
                ps.style.color = "green";
            } else {
                ps.innerText = "请输入6-8位字母或数字";
                ps.style.color = "red";
            }
            return p;
        }


        //检查用户名
        function check_n() {
            var name = document.getElementById("name").value;
            var exp_n = /^\w{2,8}$/;
            var n = exp_n.test(name);
            var us = document.getElementById("us");
            if (n) {
                us.innerText = "正确,√";
                us.style.color = "green";
            } else {
                us.style.color = "red";
                us.innerHTML = "请输入2-8位英文字符";
            }
            return n;
        }


    </script>
</head>
<body>
<div class="container">
    <center><h3>添加联系人页面</h3></center>
    <form action="${pageContext.request.contextPath}/AddServlet" method="post" id="form">
        <div class="form-group">
            <label for="name">姓名：</label>
            <input type="text" class="form-control" id="name" name="name" placeholder="请输入姓名">
            <span id="us"></span>
        </div>

        <div class="form-group">
            <label for="name">密码：</label>
            <input type="password" class="form-control" id="password" name="password" placeholder="请输入密码">
            <span id="ps"></span>
        </div>

        <div class="form-group">
            <label>性别：</label>
            <input type="radio" name="sex" value="男" checked="checked"/>男
            <input type="radio" name="sex" value="女"/>女
            <span id="ss"></span>
        </div>

        <div class="form-group">
            <label for="age">年龄：</label>
            <input type="text" class="form-control" id="age" name="age" placeholder="请输入年龄">
            <span id="as"></span>
        </div>

        <div class="form-group">
            <label>籍贯：</label>
            <select name="address" class="form-control" id="jiguan">
                <option value="广东" name="广东">广东</option>
                <option value="广西" name="广西">广西</option>
                <option value="湖南" name="湖南">湖南</option>
            </select>
        </div>

        <div class="form-group">
            <label for="qq">QQ：</label>
            <input type="text" class="form-control" id="qq" name="qq"  placeholder="请输入QQ号码"/>
            <span id="qs"></span>
        </div>

        <div class="form-group">
            <label>Email：</label>
            <input type="email" class="form-control" name="email" placeholder="请输入邮箱地址"/>
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