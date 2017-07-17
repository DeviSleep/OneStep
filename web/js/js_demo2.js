/**
 * Created by des on 2017/7/17.
 */
function validateUserName(){
    var name=document.getElementById("txtName").value;
    var reg=/^[a-zA-Z0-9]{3,6}$/;
    var isRight=reg.test(name);
    if (!isRight){
        alert("录入错误");
    }
}

 function validatePhone() {
    var phone=document.getElementById("txtPhone").value;
    var reg=/^\d{6}$/;
    var isRight=reg.test(phone);
    if(!isRight)
        alert("录入错误！");
     
 }

