<%--
  Created by IntelliJ IDEA.
  User: des
  Date: 2017/7/4
  Time: 22:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <title>校验</title>
    <style type="text/css">
        .s1 {
            cursor: pointer;
        }
    </style>

</head>
<body>
验证码：<input name="vcode"/>
<img src="code" class="s1" title="点击更换" onclick="this.src='code?'+Math.random();"/>

</body>
</html>
