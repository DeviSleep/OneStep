<%--
  Created by IntelliJ IDEA.
  User: des
  Date: 2017/6/29
  Time: 21:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>login</title>
    <style type="text/css">
        .s1 {
            cursor: pointer;
        }
    </style>
</head>
<body>

<form action="login.do" method="post">
    用户名:<input name="uname"/><br><br>
    密码:<input name="pwd" type="password"/><br><br>
    验证码：<input name="vcode"/>
    <img src="code" class="s1" title="点击更换" onclick="this.src='code?'+Math.random();"/>
    <Br><br>
    <input type="submit" value="登录"/>
</form>

</body>
</html>
