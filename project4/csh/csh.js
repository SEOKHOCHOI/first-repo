window.onload = function(){
    document.getElementById("id").addEventListener("blur", check);
    document.getElementById("ps").addEventListener("blur", check);
    document.getElementById("o").addEventListener("blur", check);
}

function check(){

    if(ps){
    alert("영문자 대/소문자 특수문자, 숫자 포함 8 ~ 32자");
    }
    
    if(id.value != id.value){

        alert('정보가 일치하지 않습니다.');

        return false;
    }

    if(ps.value != o.value){

        alert('정보가 일치하지 않습니다.');

        return false;
    }

    this.nextElementSibling.classList.remove("hidden");
    this.nextElementSibling.nextElementSibling.classList.remove("hidden");


}