<%@ page import="entity.User" %><%--
  Created by IntelliJ IDEA.
  User: ymshe
  Date: 2019/10/11
  Time: 10:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <title>用户信息管理系统</title>

    <!-- 1. 导入CSS的全局样式 -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <!-- 2. jQuery导入，建议使用1.9以上的版本 -->
    <script src="js/jquery-2.1.0.min.js"></script>
    <!-- 3. 导入bootstrap的js文件 -->
    <script src="js/bootstrap.min.js"></script>
    <style type="text/css">
        td, th {
            text-align: center;
        }
    </style>
    <script>
        window.onload = function () {
            var cb = document.getElementsByName("checkbox");
            cb[0].onclick = function () {
                for (var i = 0; i < cb.length; i++) {
                    if (cb[0].checked == false) {
                        cb[i].checked = false;
                    }
                    if (cb[0].checked == true) {
                        cb[i].checked = true;
                    }
                }
            }
            var form = document.getElementById("form");
            var btn = document.getElementById("btn_delete");
            btn.onclick = function () {
                if (confirm("你确定要删除吗？")) {
                    form.submit();
                }
            }
        }


        function deleter(id) {
            if (confirm("你确定要删除吗？")) {
                location.href = "${pageContext.request.contextPath}/DeleteServlet?id=" + id;
            }
        }


    </script>
</head>
<body>
<div class="container">
    <h3 style="text-align: center">用户信息列表</h3>
    <div>
        <form method="post" action="${pageContext.request.contextPath}/PageServlet"
              style="float: left;margin-bottom: 20px">
            姓名：<input type="text" value="${search_name}" id="search_name" name="search_name">
            地址：<input type="text" value="${search_address}" id="search_address" name="search_address">
            <input type="submit" value="提交">
        </form>


        <a href="add.jsp">
            <button id="btn_add" style="color: white; background-color: green; float: right;margin-bottom: 20px">添加信息
            </button>
        </a>
        <a href="javascript:sure()">
            <button id="btn_delete"
                    style="color: white; background-color: green; float: right;margin-bottom: 20px ;margin-right: 10px">
                删除选中
            </button>
        </a>
    </div>
    <form id="form" method="get" action="${pageContext.request.contextPath}/XuanZhongServlet">
        <table border="1" class="table table-bordered table-hover">
            <tr class="success">
                <th><input type="checkbox" id="douxuan" name="checkbox"></th>
                <th>编号</th>
                <th>姓名</th>
                <th>性别</th>
                <th>年龄</th>
                <th>籍贯</th>
                <th>QQ</th>
                <th>邮箱</th>
                <th>操作</th>
            </tr>

            <c:forEach items="${list}" varStatus="s" var="u">
                <tr>
                    <th><input type="checkbox" name="checkbox" value="${u.id}"></th>
                    <td>${s.count}</td>
                    <td>${u.name}</td>
                    <td>${u.gender}</td>
                    <td>${u.age}</td>
                    <td>${u.address}</td>
                    <td>${u.qq}</td>
                    <td>${u.email}</td>
                    <td><a class="btn btn-default btn-sm"
                           href="${pageContext.request.contextPath}/HuiXieServlet?id=${u.id}">修改</a>&nbsp;<a
                            class="btn btn-default btn-sm" href="javascript:deleter(${u.id})">删除</a></td>
                </tr>
            </c:forEach>

        </table>
    </form>
    <nav aria-label="Page navigation">
        <ul class="pagination">
            <c:if test="${page.currentPage ==1 }">
            <li class="disabled">
                </c:if>
                <c:if test="${page.currentPage !=1 }">
            <li>

                </c:if>
                <a href="${pageContext.request.contextPath}/PageServlet?pg=${page.currentPage -1 }&rows=5&search_name=${search_name}&search_address=${search_address}"
                   aria-label="Previous">
                    <span aria-hidden="true">&laquo;</span>
                </a>
            </li>
            <c:forEach begin="1" end="${page.totalepage}" step="1" var="i">
                <c:if test="${page.currentPage==i}">
                    <li class="active"><a
                            href="${pageContext.request.contextPath}/PageServlet?pg=${i}&rows=5&search_name=${search_name}&search_address=${search_address}">${i}</a>
                    </li>
                </c:if>
                <c:if test="${page.currentPage!=i}">
                    <li>
                        <a href="${pageContext.request.contextPath}/PageServlet?pg=${i}&rows=5&search_name=${search_name}&search_address=${search_address}">${i}</a>
                    </li>
                </c:if>
            </c:forEach>
            <c:if test="${page.currentPage==page.totalepage}">
            <li class="disabled">
                </c:if>
                <c:if test="${page.currentPage!=page.totalepage}">
            <li>
                </c:if>
                <a href="${pageContext.request.contextPath}/PageServlet?pg=${page.currentPage +1 }&rows=5&search_name=${search_name}&search_address=${search_address}"
                   aria-label="Next">
                    <span aria-hidden="true">&raquo;</span>
                </a>
            </li>
            <li>
                <a href="${pageContext.request.contextPath}/PageServlet?pg=1&rows=5<%--&search_name=${search_name}&search_address=${search_address}--%>">
                    <span>共${page.totalCount}条,当前第${page.currentPage}页,点我查看所有</span>
                </a>
            </li>
        </ul>
    </nav>
</div>
<script>


</script>
</body>
</html>
