<%--
  Created by IntelliJ IDEA.
  User: someo
  Date: 2021/11/26
  Time: 8:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>孤寂</title>
</head>
<body>
孤独百年，寂静如眠。
<h1>张某东</h1>
<form action="${pageContext.request.contextPath}/param2/reg" method="post">
      用户名<input name="username"><br>
       密码<input name="pwd"><br>
    年龄<input name="age"><br>
    <input type="submit" value="淦">

</form>
</body>
</html>
