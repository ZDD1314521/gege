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
    <title>孤寂reg</title>
    <script type="text/javascript" src="statics/js/jquery-1.8.3.min.js"></script>
    <%--js脚本；自动执行--%>
    <script type="text/javascript">
        $(function (){
            $.ajax({
                url:"/json/getUser",//访问的控制器：返回一个json对象
                type:"post",//提交方式
                dataType:"json",//返回值类型
                success: function (data){//结果处理
                    console.log(data.username);//peter
                    //将s1内容更换为data（json类型）的内容
                    $("s1").html("你好"+data.username+"!今天的日期是")
                }
            })

            //ajax
        })

    </script>
</head>
<body>
<div>
    <span id="s1">yyy</span>
</div>
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
