/**
 *
 * Created by des on 2017/8/21.
 */
//为表格添加行
function addRow() {
    var table = document.getElementById("table1");
    var row = table.insertRow(table.rows.length);
    //为行添加name单元
    var nameCell = row.insertCell(0);
    nameCell.innerHTML = document.getElementById("txtName").value;
    var priceCell = row.insertCell(1);
    priceCell.innerHTML = document.getElementById("txtPrice").value;

    var buttonCell = row.insertCell(2);
    var button = document.createElement("input");
    button.type = "button";
    button.value = "删除";
    button.onclick = function () { delFunc(this); }
    buttonCell.appendChild(button);
}

//删除按钮的单击事件
function delFunc(btnObj) {
    var trObj = btnObj.parentNode.parentNode;
    var name = trObj.cells[0].innerHTML;
    var isDel = confirm("真的要删除产品"+name+"吗？");
    if(!isDel){
        return;
    }
    trObj.parentNode.removeChild(trObj);
}

//使用Location对象
function testLocation(index) {
    var url = "https://baidu.com.cn";
    switch(index){
        case  1:
            location.href = url;
            break;
        case  2:
            location.replace(url);
            break;
    }

}
//
function testNavigator() {
    var showtext = "Navigator对象属性列表：\n";
    for(var propname in navigator){
        showtext += propname + ":" + navigator[propname] + "\n";
    }
    document.getElementById("txtInfo").innerHTML = showtext;
}