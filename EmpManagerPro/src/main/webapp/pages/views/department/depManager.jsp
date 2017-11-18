<%--
  Created by IntelliJ IDEA.
  User: Gary Wong
  Date: 2017/11/16
  Time: 22:07
  To change this template use File | Settings | File Templates.
--%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="../../css/bootstrap.min.css">
    <link rel="stylesheet" href="../../css/style.css">
    <script src="../../js/jquery-3.2.1.min.js"></script>
    <script src="../../js/bootstrap.min.js"></script>
    <title>部门管理</title>
    <base href="<%=basePath%>">
</head>
<body>
<div class="well" style="font-size: 20px">部门管理</div>
<!--部门管理头,包含搜索部门 添加部门-->
<div class="emp_serch">
    <form action="queryDep" class="form-inline" method="post">
        <input type="text" placeholder="请输入部门名称" class="form-control" name="dep_name">
        <input type="submit" value="搜索" class="btn btn-success">
        <a href="pages/views/department/addDepartment.jsp" class="btn btn-info">添加部门</a>
    </form>
</div>
<div class="well alert-info" style="margin-top: 20px">部门信息一览</div>
<!--部门信息表-->
<div class="container">
    <table class="table table-hover table-bordered">
        <tr>
            <th>部门编号</th>
            <th>部门名称</th>
            <th>部门描述</th>
            <th>操作</th>
        </tr>
        <tr>
            <td>1</td>
            <td>技术部</td>
            <td>全是辣鸡程序员</td>
            <td>
                <a href="pages/views/department/editDepartment.jsp" class="btn btn-sm">编辑</a>
                <a href="#" class="btn btn-sm">删除</a>
            </td>
        </tr>
        <tr>
            <td>1</td>
            <td>设计部</td>
            <td>全是辣鸡美工</td>
            <td>
                <a href="#" class="btn btn-sm">编辑</a>
                <a href="#" class="btn btn-sm">删除</a>
            </td>
        </tr>
        <tr>
            <td>1</td>
            <td>销售部</td>
            <td>全是傻逼</td>
            <td>
                <a href="#" class="btn btn-sm">编辑</a>
                <a href="#" class="btn btn-sm">删除</a>
            </td>
        </tr>
    </table>
</div>
</body>
</html>
