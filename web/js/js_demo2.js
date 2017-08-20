/**
 * Created by des on 2017/7/17.
 */
function validateUserName() {
    var name = document.getElementById("txtName").value;
    var reg = /^[a-zA-Z0-9]{3,6}$/;
    var isRight = reg.test(name);
    if (!isRight) {
        alert("录入错误");
    }
}

function validatePhone() {
    var phone = document.getElementById("txtPhone").value;
    var reg = /^\d{6}$/;
    var isRight = reg.test(phone);
    if (!isRight)
        alert("录入错误！");

}

//时间查询
function getDateRange(days) {
    var end = new Date();
    var endString = end.toLocaleDateString();
    end.setDate(end.getDate() - days + 1);
    var s = "开始日期为：" + end.toLocaleDateString() + "\n";
    s += "结束日期为：" + endString;
    alert(s);
}

function myMethod() {
    if (arguments.length == 1) {
        var n = parseInt(arguments[0]);
        alert(n + "的平方为：" + n * n);

    } else if (arguments.length == 2) {
        var n = parseInt(arguments[0]);
        var m = parseInt(arguments[1]);
        var result = n + m;
        alert(n + "与" + m + "的和为：" + result);
    }
}

function sortArry() {
    var arry = [34, 2, 14, 23, 53, 62];
    //使用Function对象
    arry.sort(new Function("a", "b", "return a-b;"));
    alert(arry.toString());

    //使用匿名函数
    arry.sort(function (a, b) {
        return b - a;
        alert(arry.toString());
    });
}

//简单计算器
function simpleCal(str) {
    if (str == "=") {
        var result = eval(document.getElementById("txtData").value);
        document.getElementById("txtData").value = result;
    } else {
        document.getElementById("txtData").value += str;
    }
}

//模拟删除操作
function delFunc() {
    var result = confirm("您确定要删除嘛？");
    return result;
}

//-----------------------------显示时间，启动，停止时钟------------------------//
function showTime() {
    var now = new Date();
    document.getElementById("spanTime").innerHTML = now.toLocaleTimeString();
}
var timer;
function startClock() {
    timer = window.setInterval(showTime, 1000);
}
function stopClock() {
    window.clearInterval(timer);
}
//-----------------------------------------------------------------------

var openTimer;
function openNewWait() {
    var openFunc = function () {
        window.open("http://baidu.com");
    };
    openTimer = window.setTimeout(openFunc, 5000);
}
function cancelOpen() {
    window.clearTimeout(openTimer);
}

