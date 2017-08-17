<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>级联下拉列表</title>
    <script type="text/javascript" src="../js/my.js"></script>
    <script type="text/javascript">
        function getCity(v1) {
            var xhr = getXhr();
            xhr.onreadystatechange = function () {
                if (xhr.readyState == 4 && xhr.status == 200) {
                    var txt = xhr.responseText;
                    var strs = txt.split(";");
                    console.log(strs);
                    $f('s2').innerHTML = "";
                    for (i = 0; i < strs.length; i++) {
                        var str1s = strs[i].split(",");
                        var op = new Option(str1s[0], str1s[1]);
                        $f('s2').options[i] = op;
                    }
                }
            };
            xhr.open("get", "getCity.do?name=" + v1, true);
            xhr.send(null);
        }
    </script>
</head>
<body>
<!-- Ajax实现级联下拉列表 -->
<select id="s1" style="width:120px;" onchange="getCity(this.value);">
    <option value="bj">北京</option>
    <option value="sh">上海</option>
    <option value="gz">广州</option>
</select>
<select id="s2" style="width: 120px;">
</select>
</body>
</html>