function secondMethod() {
    alert('hello world in script file.');
}
//转换函数：计算录入数值的平方
function getSquare() {
    var str = document.getElementById("txtData").value;
    if (isNaN(str)) {
        alert('请输入数值');
    } else {
        var data = parseFloat(str);
        var result = data * data;
        alert(result);
    }
}
//猜数字
function guessNumber() {
    var result = 10;
    //得到用户的录入
    var str = document.getElementById("txtNumber").value;
    if (isNaN(str)) {
        alert('请输入数字');
    } else {
        var data = parseFloat(str);
        var info = data > result ? "大了" : "小了";
        info = data == result ? "猜对了" : info;
        alert(info);
    }
}
//求阶乘
function getFac() {
    var result = 1;
    for (var i = 1; i <= 10; i++) {
        result *= i;
    }
    alert('10的阶乘为：' + result);
}

//查找并替换文本框中录入的字符串js为*
function searchStringAndReplace() {
    var str = document.getElementById("txtString").value;
    var index = str.indexOf("js", 0);
    while (index > -1) {
        str = str.replace("js", "*");
        index = str.indexOf("js", index + 1);
    }
    document.getElementById("txtString").value = str;
}
//使用正则表达式操作文本
function stringRegex() {
    var str = document.getElementById("txtString").value;
    var result = str.match(/js/gi);
    document.getElementById("txtString").value = str.replace(/js/gi, "*");
    alert("替换了" + result.length + '处。');
}
//数组操作
function operateArray(t) {
    //拆分为数组
    var array = document.getElementById("txtNumbers").value.split(",");
    //判断操作类型
    switch (t) {
        case 1:
            array.reverse();
            break;
        case 2:
            array.sort();
            break;
        case 3:
            array.sort(sortFunc);
            break;
    }
    alert(array.toString());
}
//定义排序规则
function sortFunc(a, b) {
    return a - b;
}

//得到随机数
function getRandomNumber() {
    var max = parseInt(document.getElementById("txtMax").value);
    var min = parseInt(document.getElementById("txtMin").value);
    var ran = Math.random();
    var data = Math.floor(ran * (max - min)) + min;
    alert(data);
}
//计算资产折旧
function calculateDepreciation() {
    var money = parseFloat(document.getElementById("txtPrice").value);
    var rate = parseFloat(document.getElementById("txtRate").value);
    var year = parseFloat(document.getElementById("txtYear").value);
    var s = "年限              剩余价值\n";
    for (var i = 1; i <= year; i++) {
        var r = money * Math.pow((1 - rate), i);
        s += i + "       " + r + "       " + r.toFixed(2) + "\n"
    }
    document.getElementById("txtResult").innerHTML = s;
}


