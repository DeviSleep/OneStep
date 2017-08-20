/**
 * Created by des on 2017/7/5.
 */
function secMethod() {
    alert("js_demo1.js文件");
}

//转换函数：计算录入数值的平方
function getSquare() {
    var str = document.getElementById("txtdata").value;

    if (isNaN(str))
        alert("请输入数字！");
    else {
        var data = parseFloat(str);
        var result = data * data;
        alert(str + "平方是：" + result);
    }
}

//猜数字
function guessNumber() {
    var result = 10;
    var str = document.getElementById("txtnum").value;
    if (isNaN(str))
        alert('请输入数字');
    else {
        var data = parseFloat(str);
        var info = data > result ? "大了" : "小了";
        info = data == result ? "对了！" : info;
        alert("猜测结果：" + info)
    }
}