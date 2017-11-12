<%--
  Created by IntelliJ IDEA.
  User: Gary Wong
  Date: 2017/11/12
  Time: 20:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>文件上传</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/upload" method="post" enctype="multipart/form-data">
    <input type="file" name="file"><br>
    <input type="submit" value="上传">
</form>
<p style="color: red">${error}</p>
</body>
</html>
