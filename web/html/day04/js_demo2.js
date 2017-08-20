function validateUserName() {
    var name = document.getElementById("txtName").value;
    var reg = /^[a-zA-Z0-9]{3,6}$/;
    var isRight = reg.test(name);
    if (!isRight) {
        alert('录入 错误！');
    }
    console.log(isRight);
}

function validatePhone() {
    var phone = document.getElementById("txtPhone").value;
    var regex = new RegExp("^\\d{6}$");
    var isY = regex.test(phone);
    if (!isY) {
        alert('输入error！');
    } else {
        alert('ok');
    }
    console.log(isY);
}
//时间查询
function getDateRange(days) {
    var end = new Date();
    var endString = end.toLocaleDateString();
    //修改时间
    end.setDate(end.getDate() - days + 1);
    //显示结果
    var s = "开始日期：" + end.toLocaleDateString() + "\n";
    s += "结束日期：" + endString;
    alert(s);
    alert("toString() 默认：" + end.toString());
    alert("toLocaleTimeString() :" + end.toLocaleTimeString());


}

//方法重载
function myMethod() {
    if (arguments.length == 1) {
        //计算平方
        var n = parseInt(arguments[0]);
        alert(n + "的平方为：" + n * n);
    } else if (arguments.length == 2) {
        //计算求和
        var n = parseInt(arguments[0]);
        var m = parseInt(arguments[1]);
        var result = n + m;
        console.log(result);
        alert(n + "与" + m + "的和为：" + result);
    }

}
//数组排序
function sortArry() {
    var array = [34, 2, 14, 56, 43];
    array.sort(new Function("a", "b", "return a-b;"));
    alert(array.toString());

    //使用匿名函数
    array.sort(function (a, b) {
        return b - a;
    });
    alert(array.toString());
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

//删除操作
function delFunc() {
    var result = confirm("您确定要删除吗？");
    return result;
}

//显示时间
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

//页面定时跳转
var openTime;
function openWindowWait() {
    var openFunc = function () {
        window.open("http://hao123.com");
    }
    openTime = window.setTimeout(openFunc, 5000);
}
function cancelOpen() {
    window.clearTimeout(openTime);
}

//定义数组，存储图片路径
var imageArray = ["f1.jpg", "f2.jpg", "f3.jpg", "f4.jpg"];
var imageIndex = 1;
var imgTimer;
function startRotate() {
    var rotateFunc = function () {
        var image = document.getElementById("img1");
        image.src = imageArray[imageIndex];
        if (imageIndex == imageArray.length - 1)
            imageIndex = 0;
        else
            imageIndex++;
    };
    imgTimer = window.setInterval(rotateFunc, 3000);
}
function stopRotate() {
    window.clearInterval(imgTimer);
}






