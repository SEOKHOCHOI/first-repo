// 한 줄 주석
/*
    여러줄 주석
*/

// 전역 변수 -> window 객체의 멤버 변수
var v1;     // 변수 생성
v2 = 10;    // var 키워드 생략하여 변수 생성


console.log(typeof '1');
console.log(typeof 1);
console.log(typeof 1.1);
console.log(typeof true);
console.log(typeof undefined);
console.log(typeof function(){});
console.log(typeof null);
console.log(typeof NaN);
console.log(typeof infinity);
console.log(typeof Infinity);


function ex1() {
    /*
    * 영문자 알파벳 범위릐 ASCII 코드 번호를 입력받은 경우에만 해당하는 문자를
    * 출력하고 코드 범위를 벗어난 경우에는 "ASCII 코드 영문자 범위를 벗어났습니다."
    * 라는 메시지를 출력하도록 하시오.
    * 
    * 예 1.)
    *      영문자 범위의 ASCII 코드 번호 입력 : 65
    *      입력한 ASCII 코드 65 의 영문자는 'A' 입니다.
    * 
    * 예 2.)
    *      영문자 범위의 ASCII 코드 번호 입력 : 92
    *      ASCII 코드 영문자 범위를 벗어났습니다.
    */
    var res1 = document.getElementById("res1");
    var code = parseInt(prompt("영문자 범위의 ASCII 코드 번호 입력"));

    if(isNaN(code)) {
        res1.innerText = "숫자로만 입력하세요.";
    } else {
        if((code >= 65 && code <= 90) ||
                (code >= 97 && code <= 122)) {
            res1.innerText = "입력한 ASCII 코드 " + code + "의 영문자는 "
                + String.fromCharCode(code) + " 입니다.";
        } else {
            res1.innerText = "ASCII 코드 영문자 범위를 벗어났습니다.";
        }
    }
}

function ex2() {
    var res2 = document.getElementById("res2");
    var txt = "";
    for(var x = 0; x < 5; x++) {
        txt += x + "\n";
    }
    res2.innerText = txt;
}

function ex3() {
    var res2 = document.getElementById("res2");
    var txt = "";
    var x = 0;
    for(;;) {
        if(x >= 5) {
            break;
        }
        txt += x + "\n";
        x++;
    }
    res2.innerText = txt;
}

function ex4() {
    var res3 = document.getElementById("res3");
    var txt = "";
    var x = 0;
    while(true) {
        if(x >= 5) {
            break;
        }
        txt += x + "\n";
        x++;
    }
    res3.innerText = txt;
}

function ex5() {
    var res4 = document.getElementById("res4");
    var res5 = document.getElementById("res5");
    var txt1 = "";  var txt2 = "";
    var x = 0;
    while(true) {
        switch(x%2) {
            case 0:
                txt1 += x + "\n";   break;
            case 1:
                txt2 += x + "\n";   break;
            default:
                break;
        }
        if(x >= 20) {
            break;
        }
        x++;
    }
    res4.innerText = txt1;  res5.innerText = txt2;
}

function ex6() {
    var res6 = document.getElementById("res6");
    var txt = ""
    var arr = [1, 2, 3, 4, 5];

    for(var item in arr) {
        txt += arr[item] + " ";
    }

    res6.innerText = txt;
}

function ex7() {
    var res7 = document.getElementById("res7");
    var txt = ""
    var arr = [1, 2, 3, 4, 5];

    for(var item of arr) {
        txt += item + " ";
    }

    res7.innerText = txt;
}

function ex8() {
    var res8 = document.getElementById("res8");
    var txt = ""
    var obj = {"a": 1, "b": 2, "c": 3, "d": 4};

    for(var item in obj) {
        txt += item + ": " + obj[item] + " ";
    }

    res8.innerText = txt;
}

function ex9() {
    /*
     *  1 ~ 45 사이의 임의 값 생성(총 6개)
     */
    var res9 = document.getElementById("res9");
    var lotto = [];
    
    for(var idx = 0; idx < 6;) {
        var rand = randInt(45, 1);
        if(lotto.indexOf(rand) == -1) {
            lotto[idx] = rand;
            idx++
        }
    }
    lotto.sort(function(x, y) { return x - y; });
    res9.innerText = lotto.join(", ");
}

function randInt(max, min=0) {
    return Math.floor(Math.random() * (max - min + 1) + min);
}

// 가변길이 매개변수
function func1(x, ...args) {
    console.log(x);
    console.log(args);
    console.log(arguments);
}

var func2 = function(min, max) {
    return Math.floor(Math.random() * (max - min + 1) + min);
}

function func4(min, max) {
    return Math.floor(Math.random() * (max - min + 1) + min);
}

var func3 = func4;

function rand1To10(f) {
    return f(1, 10);
}

var r1 = rand1To10(func4);

var r2 = rand1To10(function(min, max) { // callback
    return Math.floor(Math.random() * (max - min + 1) + min);
});
