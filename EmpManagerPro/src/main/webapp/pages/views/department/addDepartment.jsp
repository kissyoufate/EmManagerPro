<%--
  Created by IntelliJ IDEA.
  User: Gary Wong
  Date: 2017/11/16
  Time: 22:08
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
    <title>添加部门</title>
    <base href="<%=basePath%>">
</head>
<body>
<div class="well alert-info" style="font-size: 20px">添加部门</div>
<div class="container">
    <form action="#" method="post">
        <div class="row">
            <div class="col-sm-8">
                <div class="form-group">
                    <label for="" class="col-sm-2 label-info">部门名称</label>
                    <input type="text" placeholder="请输入部门名称" class="col-sm-10 form-control">
                </div>
            </div>
        </div>
        <br>
        <div class="row">
            <div class="col-sm-9">
                <div class="form-group">
                    <label for="" class="col-sm-2 label-info">部门描述</label>
                    <textarea class="form-control col-sm-10" rows="5" placeholder="请输入部门描述"></textarea>
                </div>
            </div>
        </div>
        <br>
        <div class="form-inline">
            <input type="submit" value="添加部门" class="btn btn-success">
            <input type="reset" value="重置部门" class="btn btn-danger">
        </div>
    </form>
</div>
</body>
</html>