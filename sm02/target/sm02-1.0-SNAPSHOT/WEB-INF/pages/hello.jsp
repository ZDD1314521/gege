<%@page isELIgnored="false" %>

<%--
  Created by IntelliJ IDEA.
  User: someo
  Date: 2021/11/27
  Time: 8:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div>
    <form method="post" enctype="multipart/form-data" action="${pageContext.request.contextPath }/user/upload">
        上传头像：<input type="file" name="image"><br>
        <input type="submit" value="上传">
    </form>
</div>
<div>
    <form method="post" enctype="multipart/form-data" action="${pageContext.request.contextPath }/user/upload2">
        上传图片1：<input type="file" name="image"><br>
        上传图片2：<input type="file" name="image"><br>
        上传图片3：<input type="file" name="image"><br>
        <input type="submit" value="批量上传">
    </form>
</div>
<div>
    <h2>点击图片完成下载</h2>
    <a href="${pageContext.request.contextPath}/user/download/buy.png">
        <image src="${pageContext.request.contextPath}/images/buy.png" width="300px"/>
    </a>
    <a href="${pageContext.request.contextPath}/user/download/clock.jpg">
        <image src="${pageContext.request.contextPath}/images/clock.jpg" width="300px"/>
    </a>
    <a href="${pageContext.request.contextPath}/user/download/n.png">
        <image src="${pageContext.request.contextPath}/images/n.png" width="300px"/>
    </a>
    <a href="${pageContext.request.contextPath}/user/download/tc.png">
        <image src="${pageContext.request.contextPath}/images/tc.png" width="300px"/>
    </a>
</div>

<%--hello,${requestScope.username}!!!!你今年${requestScope.age}岁了。--%>
hello,${sessionScope.username}!!!!<br>
你今年${sessionScope.age}岁了。



</form>
</body>
</html>
