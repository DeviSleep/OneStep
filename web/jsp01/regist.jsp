<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>注册</title>
    <script type="text/javascript" src="../js/my.js"></script>
    <script type="text/javascript">
        function check_name() {
            var xhr = getXhr();
            xhr.onreadystatechange = function () {
                if (xhr.readyState == 4 && xhr.status == 200) {
                    document.getElementById("name_msg").innerHTML = xhr.responseText;
                }
            };
            xhr.open("post", "check_name.do", true);
            xhr.setRequestHeader("content-type", "application/x-www-form-urlencoded");
            var uname = document.getElementById("uname");
            document.getElementById("name_msg").innerHTML = "正在检查……";
            xhr.send("uname=" + uname.value);
        }
    </script>
</head>
<body>
<!-- 验证注册信息的 用户名是否可用 -->
<form action="" method="post">
    <fieldset>
        <legend>注册信息</legend>
        用户名：<input name="uname" id="uname"/>
        <input type="button" value="检查一下吧" onclick="check_name();"/>
        <span id="name_msg" style="color: red;"></span>
        <br/><br>
        <input type="submit" value="注册"/>
    </fieldset>
</form>
</body>
</html>