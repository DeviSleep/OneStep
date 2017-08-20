/**
 * Created by des on 2017/7/30.
 */
//验证账号的录入
function valiAccount() {
    document.getElementById("txtAccount").className = "txt";
    var account = document.getElementById("txtAccount").value;
    var reg = /^[A-Za-z0-9]{1,10}$/;
    var error = reg.test(account);

    var spanObj = document.getElementById("accountInfo");
    if (error) {
        spanObj.innerHTML = "";
        spanObj.className = "vali_success";
    } else {
        spanObj.innerHTML = "10 长度以内的字母数字的组合";
        spanObj.className = "vali_fail";
    }
    return error;
}

function valiPhone() {
    document.getElementById("txtPhone").className = "txt";
    var phone = document.getElementById("txtPhone").value;

    var reg = /^\d{3}-\d{8}$/;
    var error = reg.test(phone);
    var spanObj = document.getElementById("phoneInfo");
    if (error) {
        spanObj.innerHTML = "";
        spanObj.className = "vali_success";

    } else {
        spanObj.innerHTML = "形如:010-12345678";
        spanObj.className = "vali_fail";
    }
    return error;
}

//验证各项的录入
function validateDates() {
    var r1 = valiAccount();
    var r2 = valiPhone();
    return r1 && r2;
}

// 减少数量
function decrease(btnObj) {
    var nodes = btnObj.parentNode.childNodes;
    for(var i=0;i<nodes.length;i++){
        var oldCount = parseInt(nodes[i].value);
        if(nodes[i].nodeName == "INPUT" && nodes[i].type == "text"){
            if(oldCount>=1){
                var newCount = oldCount-1;
                nodes[i].value = newCount;
            }
        }
    }
    calculate();
}

//增加数量
function increase(btnObj) {
    var nodes = btnObj.parentNode.childNodes;
    for(var i=0;i<nodes.length;i++){
        if(nodes[i].nodeName == "INPUT" && nodes[i].type == "text"){
            var oldCount = parseInt(nodes[i].value);
            var newCount = oldCount+1;
            nodes[i].value = newCount;
        }
    }
    calculate();
}

// 计算小计及总计
function calculate() {
    var total = 0;
    var tableObj = document.getElementById("shoppingCart");
    var trNodes = tableObj.getElementsByTagName("tr");
    //从第二行统计到倒数第二行
    for(var i=1;i<trNodes.length-1;i++){
        var tr = trNodes[i];
        var price = tr.getElementsByTagName("td")[1].innerHTML;
        var quantity = tr.getElementsByTagName("input")[1].value;
        var sum = parseFloat(price) * parseFloat(quantity);
        tr.getElementsByTagName("td")[3].innerHTML = sum.toFixed(2);
        total += sum;
    }
    //显示总计
    trNodes[trNodes.length-1].getElementsByTagName("td")[1].innerHTML = total.toFixed(2);
}

// 动态创建页面元素
function addNewNode() {
    var div = document.getElementById("div1");
    var linkNode = document.createElement("a");
    linkNode.href = "https://hao123.com";
    linkNode.innerHTML = "hao123";
    div.appendChild(linkNode);

    var newBtn = document.createElement("input");
    newBtn.type = "button";
    newBtn.value = "new button";
    newBtn.onclick = function () { alert("Hello cq"); };
    div.insertBefore(newBtn,document.getElementById("btn1"));
}

//
var projectArray = new Array();
projectArray[0] = ["请选择"];
projectArray[1] = ["CoreJava","Oracle","JSP","JDBC"];
projectArray[2] = ["PS","CSS"];
projectArray[3] = ["PHP","MySql","Jquery"];
function classChanged() {
    var i = document.getElementById("selClass").selectedIndex;
    var data = projectArray[i];

    var selObj = document.getElementById("selProject");
    //删除原有选项
    while (selObj.childNodes.length>0){
        selObj.removeChild(selObj.lastChild);
    }
    //循环数组，写入新的option对象
    for(var i=0;i<data.length;i++){
        var optionObj = document.createElement("option");
        optionObj.value = i;
        optionObj.innerHTML = data[i];
        selObj.appendChild(optionObj);
    }
}

//
function classChangedByHTMLDOM() {
    var i = document.getElementById("selClass2").selectedIndex;
    var data = projectArray[1];

    var selObject = document.getElementById("selProject2");
    //删除，但此处有问题，暂时
    selObject.options.length  = 0;
    for(var i=0;i<data.length;i++){
        var optionObj =  new Option(data[i],i);
        selObject.options[i] = optionObj;
    }
}
