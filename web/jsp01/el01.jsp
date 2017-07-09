<%@ page import="com.bean.Course" %>
<%@ page import="com.bean.User" %>
<%--
  Created by IntelliJ IDEA.
  User: des
  Date: 2017/7/8
  Time: 15:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<html>
<head>
    <title>EL表达式</title>
</head>
<body>
        <!-- 访问Bean属性-->
        <%
            Course course = new Course();
            course.setCourseId(1);
            course.setCourseName("English");
            User u1 = new User();
            u1.setAge(18);
            u1.setCourse(course);
            u1.setName("Desvi");
            u1.setInterest(new String[]{"Sleeping","basketball","cooking"});
            request.setAttribute("user",u1);
        %>

        <%
            User u =(User)request.getAttribute("user");
            out.println(u.getName());
            out.println(u.getAge());
        %>
        <br><hr>
        <!--EL --->
        EL 表达式<br>
        姓名：${user.name} <br>
        年龄：${user.age} <br>
        课程名：${user.course.courseName}<br><br />
        <%
            request.setAttribute("userAge","age");
        %>
        ${user.interest[0]}
        age:${userAge}<hr>

        plus:${"123"+"456"}<br>  <!-- +只能做加运算，此处不能作为连结，579-->
        ${"123"=="123"}<br>
        ${"123"eq"123"}<br>

<!--empty-->
        <%
            request.setAttribute("str1","");
            List list=new ArrayList();
            list.add("ok");
            request.setAttribute("list1",list);
            request.setAttribute("obj",null);
        %>
        ${empty str1}<br>
        ${empty xx}<br>
        ${empty list1}<br>
        ${empty obj}

</body>
</html>
