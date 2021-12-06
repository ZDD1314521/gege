
<%--
  Created by IntelliJ IDEA.
  User: chenmingxiang
  Date: 2021/11/13
  Time: 8:41
  To change this template use File | Settings | File Templates.
--%>生活不止眼前的苟且，还有诗和远方。
<%--<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" language="java" %>
<html>
<body><h2>Hello World!</h2>
<form action="${pageContext.request.contextPath}/user/login.do" method="post">
    <label>账号：</label><input name="username"/>
    <label>密码：</label><input name="pwd"/>
    <input type="submit" value="登录"/>
</form>
<a href="${pageContext.request.contextPath}/user/delete.do">删除操作</a>
</body>
</html>--%>

<%@ page pageEncoding="UTF-8" isELIgnored="false" contentType="text/html; charset=UTF-8" %>
<html>
<head>
    <title>登录(首页)</title>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath }/statics/css/style.css" />
</head>
<body class="login_bg">
<section class="loginBox">
    <header class="loginHeader">
        <h1>超市订单管理系统</h1>
    </header>
    <section class="loginCont">
        <form class="loginForm" action="${pageContext.request.contextPath }/user/login"  name="actionForm" id="actionForm"  method="post" >
<%--        <form class="loginForm" action="${pageContext.request.contextPath }/testMeV"  name="actionForm" id="actionForm"  method="post" >--%>
            <div class="info">${msg}</div>
            <div class="inputbox">
                <label >用户名：</label>
                <input type="text" class="input-text" id="userCode" name="username" placeholder="请输入用户名" required/>
            </div>
            <div class="inputbox">
                <label >密&nbsp&nbsp&nbsp&nbsp码：</label>
                <input type="password" id="userPassword" name="pwd" placeholder="请输入密码" required/>
            </div>
            <div class="subBtn">
                <input type="submit" value="登录"/>
                <input type="reset" value="重置"/>
            </div>
            <a href="${pageContext.request.contextPath}/index.jsp">执行删除功能</a>
        </form>
    </section>
</section>
</body>
</html>

<%--
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>牛逼</title>
</head>
<body>
<h2>老北鼻</h2>
<form action="${pageContext.request.contextPath}/user/login" method="get">
    <label>账号：</label><input name="username"/>
    <label>密码：</label><input name="age"/>
    <input type="submit" value="登录">
</form>
<a href="${pageContext.request.contextPath}/user/delete">删除操作</a>
</body>
</html>
--%>
