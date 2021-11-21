function ex1() {
    /*
     * 사용자가 입력한 정수 값의 총합을 구하시오.
     */
    var input1 = document.getElementById("input1").value;
    var out1 = document.getElementById("out1");
    
    var tot = 0;
    for(var num of input1.split(",")) {
        tot += parseInt(num);
    }
    
    out1.innerText = tot;
}

function ex2() {
    /*
     * 사용자가 입력한 값이 리스트의 목록이 되도록 하기.
     */
    var input2 = document.getElementById("input2").value;
    var out2 = document.getElementById("out2");

    var sList = "<ul>";
    for(var item of input2.split(",")) {
        sList += "<li>" + item.trim() + "</li>";
    }
    
    out2.innerHTML = sList + "</ul>";
}