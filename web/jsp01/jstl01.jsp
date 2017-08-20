<%@ page import="com.bean.Employee" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%--
  Created by IntelliJ IDEA.
  User: des
  Date: 2017/7/8
  Time: 18:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<html>
<head>
    <title>JSTL</title>
    <style type="text/css">
        .s1 {
            color: red
        }

        .s2 {
            color: purple
        }
    </style>
</head>
<body>

<%
    Employee emp = new Employee();
    emp.setGender("m");
    emp.setName("Lucky");
    request.setAttribute("emp", emp);

    Employee emp2 = new Employee();
    emp2.setName("Cool");
    emp2.setGender("f");
    List<Employee> emps = new ArrayList<Employee>();
    emps.add(emp);
    emps.add(emp2);
    request.setAttribute("emps", emps);
%>
if标签：
<hr>
员工姓名：${emp.name}<br>
员工性别：<c:if test='${emp.gender=="m"}' var="rs" scope="request">男</c:if>
<c:if test="${!rs}">女</c:if><br>
<c:if test="true">ok</c:if>
<%--<h4>${emp.gender}=="m"</h4>--%>
<%--<h4>${emp.gender}=='m'</h4>--%>


<hr>
choose标签：<br>
员工性别：
<c:choose>
    <c:when test="${emp.gender=='m'}">男</c:when>
    <c:otherwise>女</c:otherwise>
</c:choose>


<hr>
<br>
forEach标签：1：<br>
<c:forEach var="emp" items="${emps}">
    姓名：${emp.name} &nbsp; &nbsp;
    性别：${emp.gender}<br>
    <hr>
</c:forEach>
forEach标签：2：<br>
<c:forEach items="${emps}" var="emp" varStatus="s">
    <!--奇偶行显示颜色交替-->
    <p class="s${s.index%2+1}">
        姓名：${emp.name} &nbsp; &nbsp;
        性别：${emp.gender} &nbsp; &nbsp;
        count:${s.count} &nbsp; &nbsp;
        index:${s.index}&nbsp; &nbsp;
    </p>
</c:forEach>

</body>
</html>
