/**
 * Created by des on 2017/7/30.
 */
//验证账号的录入
function valiAccount() {
    document.getElementById("txtAccount").className="txt";
    var account= document.getElementById("txtAccount").value;
    var reg= /^[A-Za-z0-9]{1,10}$/;
    var error= reg.test(account);

    var spanObj= document.getElementById("accountInfo");
    if(error){
        spanObj.innerHTML="";
        spanObj.className="vali success";
    }else {
        spanObj.innerHTML="10 长度以内的字母数字的组合";
        spanObj.className="vali fail";
    }
    return error;
}

function valiPhone() {
    document.getElementById("txtPhone").className="txt";
    var phone= document.getElementById("txtPhone").value;

    var reg= /^\d{3}-\d{8}$/;
    var error= reg.test(phone);
    var spanObj= document.getElementById("phoneInfo");
    if(error){
        spanObj.innerHTML="";
        spanObj.className="vali success";

    }else {
        spanObj.innerHTML="形如:010-12345678";
        spanObj.className="vali fail";
    }
    return error;
}

//验证各项的录入
function validateDates() {
    var r1=valiAccount();
    var r2=valiPhone();
    return r1 && r2;
}

