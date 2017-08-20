<%--
  Created by IntelliJ IDEA.
  User: des
  Date: 2017/7/7
  Time: 0:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>评论</title>
</head>
<body>

当前有<%=application.getAttribute("count").toString()%>人数在线
<a href="logout">logout</a>
<br><br>

<form action="comment" method="post">
    <fieldset>
        <legend>评论</legend>
        请输入评论：<textarea name="comment" style="vertical-align: middle;width: 140px;height: 55px"></textarea>
        <br>
        <input type="submit" value="发表评论"/>
    </fieldset>
</form>
</body>
</html>
