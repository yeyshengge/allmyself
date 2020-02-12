<%--
  Created by IntelliJ IDEA.
  User: ymshe
  Date: 2019/10/10
  Time: 14:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>内置对象</title>
</head>
<body>
<%
<%--

变量名                 真实类型                    作用
pageContext           PageContext                当前页面共享数据，还可以获取其他八个对象
request               HttpServletRequest         一次请求访问多个资源（转发）
session               HttpSession                一次会话的多个请求间
application           ServletContext             所有用户共享数据
response              HttpServletResponse        响应对象
page                  Object                     当前页面（Servlet）的对象this
out                   JspWriter                  输出对象到页面上
config                ServletConfig              Servlet的配置对象
exception             Throwable                  异常对象

--%>

%>

</body>
</html>
