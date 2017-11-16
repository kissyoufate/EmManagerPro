<%--
  Created by IntelliJ IDEA.
  User: Gary Wong
  Date: 2017/11/16
  Time: 22:01
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
    <title>员工管理</title>
    <base href="<%=basePath%>">
</head>
<body>
<div class="well" style="font-size: 20px">员工管理</div>

<!--员工的头,包含搜索,添加等功能-->
<div class="emp_top">
    <div class="emp_serch">
        <form action="" class="form-inline">
            <input type="text" class="form-control" placeholder="请输入部门名称">
            <input type="submit" value="查询" class="btn btn-success" style="width: 100px">
            <a href="pages/views/empolyee/addEmpolyee.jsp" style="position: relative;width: 100px" class="btn btn-info">添加</a>
        </form>
    </div>
</div>

<!--员工的列表展示-->
<div class="well alert-info" style="margin-top: 20px">员工信息一览</div>
<div class="container">
    <table class="table table-hover table-bordered">
        <tr>
            <th>员工编号</th>
            <th>员工姓名</th>
            <th>员工性别</th>
            <th>员工年龄</th>
            <th>联系方式</th>
            <th>操作</th>
        </tr>
        <tr>
            <td>1</td>
            <td>张扬</td>
            <td>男</td>
            <td>65</td>
            <td>12345678</td>
            <td>
                <a href="pages/views/empolyee/editEmpolyee.jsp" class="btn btn-sm">编辑</a>
                <a href="#" class="btn btn-sm">删除</a>
            </td>
        </tr>
        <tr>
            <td>1</td>
            <td>张扬</td>
            <td>男</td>
            <td>65</td>
            <td>12345678</td>
            <td>
                <a href="#" class="btn btn-sm">编辑</a>
                <a href="#" class="btn btn-sm">删除</a>
            </td>
        </tr>
        <tr>
            <td>1</td>
            <td>张扬</td>
            <td>男</td>
            <td>65</td>
            <td>12345678</td>
            <td>
                <a href="#" class="btn btn-sm">编辑</a>
                <a href="#" class="btn btn-sm">删除</a>
            </td>
        </tr>
    </table>
</div>
</body>
</html>
