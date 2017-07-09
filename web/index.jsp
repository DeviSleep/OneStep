<%--
  Created by IntelliJ IDEA.
  User: des
  Date: 2017/6/22
  Time: 0:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%
    //session验证
    Object uname=session.getAttribute("uname");
    if (uname==null){
        response.sendRedirect("login.jsp");
        return;
    }
%>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  $END$
      <h3>首页</h3>欢迎你：<%=uname.toString()%><br><br>
  </body>
</html>
