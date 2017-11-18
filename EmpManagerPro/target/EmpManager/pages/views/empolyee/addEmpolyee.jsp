<%--
  Created by IntelliJ IDEA.
  User: Gary Wong
  Date: 2017/11/16
  Time: 21:58
  To change this template use File | Settings | File Templates.
--%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <base href="<%=basePath%>">
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="../../css/bootstrap.min.css">
    <link rel="stylesheet" href="../../css/style.css">
    <script src="pages/js/jquery-3.2.1.min.js"></script>
    <script src="pages/js/bootstrap.min.js"></script>
    <title>添加员工</title>
</head>
<body>
<div class="well alert-info" style="font-size: 20px">添加员工</div>
<div class="container">
    <form action="#" method="post">
        <div class="row">
            <div class="col-sm-9">
                <div class="form-inline">
                    <label for="" class="col-sm-2 control-label">员工名称</label>
                    <input type="text" placeholder="请输入员工名称" class="form-control">
                </div>
            </div>
        </div>
        <br>
        <div class="row">
            <div class="col-sm-9">
                <div class="form-inline">
                    <label for="" class="col-sm-2 control-label">员工性别</label>
                    <select name="" id="" class="form-control">
                        <option>男</option>
                        <option>女</option>
                    </select>
                </div>
            </div>
        </div>
        <br>
        <div class="row">
            <div class="col-sm-9">
                <div class="form-inline">
                    <label for="" class="col-sm-2 control-label">员工年龄</label>
                    <input type="text" class="form-control" placeholder="请输入员工年龄">
                </div>
            </div>
        </div>
        <br>
        <div class="row">
            <div class="col-sm-9">
                <div class="form-inline">
                    <label for="" class="control-label col-sm-2">联系方式</label>
                    <input type="text" class="form-control col-sm-10" placeholder="请输入电话号码">
                </div>
            </div>
        </div>
        <br>
        <div class="form-inline">
            <input type="submit" value="添加员工" class="btn btn-success">
            <input type="reset" value="重置员工" class="btn btn-danger">
        </div>
    </form>
</div>
</body>
</html>
