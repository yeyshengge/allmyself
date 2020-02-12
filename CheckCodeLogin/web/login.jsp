<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
    <style>
        div {
            color: red;
        }
    </style>
    <script>
        window.onload = function () {
            var img = document.getElementById("img");

            img.onclick = function () {
                img.src = "/CheckCodeServlet?time="+new Date().getTime();
            }


        }


    </script>
</head>
<body>
<form action="/LoginServlet" method="post">

    <table>
        <tr>
            <td>用户名</td>
            <td><input type="text" name="username"></td>
        </tr>
        <tr>
            <td>密码</td>
            <td><input type="password" name="password"></td>
        </tr>
        <tr>
            <td colspan="2">
                <img id="img" src="/CheckCodeServlet">
            </td>
        </tr>
        <tr>
            <td>验证码</td>
            <td>
                <input type="text" name="checkcode">
            </td>
        </tr>
        <tr>
            <td>
                <input type="submit" value="提交">
            </td>
            <td>
                <div><%=request.getAttribute("login_error") == null ? "" : request.getAttribute("login_error")%>
                </div>
                <div><%=request.getAttribute("code_error") == null ? "" : request.getAttribute("code_error")%>
                </div>
            </td>
        </tr>

    </table>

</form>
</body>
</html>
