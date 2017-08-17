<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>ajax post请求</title>
    <script src="../js/my.js" type="text/javascript"></script>
    <script type="text/javascript">
        function getText() {
            //发送post类型请求
            var xhr = getXhr();
            xhr.onreadystatechange = function () {
                if (xhr.readyState == 4 && xhr.status == 200) {
                    alert(xhr.responseText);
                }
            };
            xhr.open("post", "post_text.do", true);
            xhr.setRequestHeader('content-type', 'application/x-www-form-urlencoded');
            xhr.send("uname=Dr.");
        }
    </script>
</head>
<body>
<!-- 使用Ajax对象发送POST类型请求，并获取文本 -->
<input type="button" onclick="getText();" value="Post请求"/>

</body>
</html>