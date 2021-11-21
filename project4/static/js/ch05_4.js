function randInt(max, min=0) {
    return Math.floor(Math.random() * (max - min + 1) + min);
}

function createLottoBall() {
    var ball = document.createElement("span");
    ball.className = "lotto-num"
    return ball
}

function genLotto() {
    var lotto = [];
    
    for(var idx = 0; idx < 6;) {
        var rand = randInt(45, 1);
        if(lotto.indexOf(rand) == -1) {
            lotto[idx] = rand;
            idx++
        }
    }
    lotto.sort(function(x, y) { return x - y; });

    var len = document.getElementById("lotto_number").getElementsByTagName("span").length;
    for(var idx = 0; idx < len; idx++) {
        document.getElementById("lotto_number").children[0].remove();
    }

    for(var i = 0; i < lotto.length; i++) {
        var item = createLottoBall();
        item.classList.add("bg-" + (Math.floor((lotto[i] - 1) / 10) + 1));
        item.innerText = lotto[i];
        document.getElementById("lotto_number").append(item);
    }

    var info = document.getElementsByClassName("info")[0];
    var dayMap = {1:"월요일", 2:"화요일", 3:"수요일", 4:"목요일", 5:"금요일"
        , 6:"토요일", 0:"일요일"};
    var date = new Date();
    info.innerText = date.getFullYear() + "년 " + (date.getMonth() + 1) + "월 ";
    info.innerText += date.getDate() + "일 " + dayMap[date.getDay()];
    info.innerText += " " + date.getHours() + ":" + date.getMinutes() + ":" + date.getSeconds();
    navigator.geolocation.getCurrentPosition(
        function(pos) {
            info.innerText += "\n위도 : " + pos.coords.latitude + "\n";
            info.innerText += "경도 : " + pos.coords.longitude;
        }
    );
}

window.addEventListener("load", function() {
    var btn = document.getElementById("create_btn");
    btn.addEventListener("blur", function() {
        console.log(this.innerText + " 포커스 해제 이벤트 발생!!!");
    });

    var inputNumber = document.getElementById("input-number");
    inputNumber.addEventListener("focus", function() {
        this.placeholder = "로또 번호를 입력하세요. 1, 2, 3, ...";
    });
    inputNumber.addEventListener("blur", function() {
        this.placeholder = "";
        this.readOnly = true;
    });
    inputNumber.addEventListener("dblclick", function() {
        this.readOnly = false;
    });
    inputNumber.addEventListener("contextmenu", function(event) {
        event.preventDefault();
        alert("마우스 오른쪽 클릭 감지!");
    });
    inputNumber.addEventListener("mouseenter", function() {
        console.log("마우스를 감지하였습니다.");
    });
    inputNumber.addEventListener("mouseleave", function() {
        console.log("마우스가 영역을 벗어났습니다.");
    });
    inputNumber.addEventListener("mousemove", function(event) {
        console.log("x 축 : " + event.x + "| y 축 : " + event.y);
    });
    inputNumber.addEventListener("wheel", function(event) {
        var currentColor;
        if(!this.style.backgroundColor) {
            currentColor = "rgb(255, 0, 0)";
        } else {
            currentColor = this.style.backgroundColor;
        }

        currentColor = currentColor.substr(4);
        currentColor = currentColor.substr(0, currentColor.length - 1);
        currentColor = currentColor.split(",");

        currentColor[0] = parseInt(currentColor[0]);
        currentColor[1] = parseInt(currentColor[1]);
        currentColor[2] = parseInt(currentColor[2]);

        if(event.deltaY > 0) { // 휠을 아래로 내림
            if(currentColor[0] < 255) {
                currentColor[0] += 16;
                if(currentColor[0] > 255) {
                    currentColor[0] = 255;
                }
            } else if(currentColor[0] == 255 && currentColor[1] < 255) {
                currentColor[1] += 16;
                if(currentColor[1] > 255) {
                    currentColor[1] = 255;
                }
            } else if(currentColor[0] == 255 && currentColor[1] == 255 && currentColor[2] < 255) {
                currentColor[2] += 16;
                if(currentColor[2] > 255) {
                    currentColor[0] = 0;
                    currentColor[1] = 0;
                    currentColor[2] = 0;
                }
            }
            this.style.backgroundColor = "rgb(" + currentColor.join(", ") + ")";
        } else { // 휠을 위로 올림
            if(currentColor[0] > 0) {
                currentColor[0] -= 16;
                if(currentColor[0] < 0) {
                    currentColor[0] = 255;
                }
            } else if(currentColor[0] == 0 && currentColor[1] > 0) {
                currentColor[1] -= 16;
                if(currentColor[1] < 0) {
                    currentColor[1] = 255;
                }
            } else if(currentColor[0] == 0 && currentColor[1] == 0 && currentColor[2] > 0) {
                currentColor[2] -= 16;
                if(currentColor[2] < 0) {
                    currentColor[0] = 255;
                    currentColor[1] = 255;
                    currentColor[2] = 255;
                }
            }
            this.style.backgroundColor = "rgb(" + currentColor.join(", ") + ")";
        }
    });
    inputNumber.addEventListener("keyup", function() {
        console.log("키를 누르고 띄었을 때 감지");
    });
    inputNumber.addEventListener("keydown", function() {
        console.log("키를 눌렀을 때 감지");
    });
    // inputNumber.addEventListener("input", function() {
    //     console.log(this.value);
    // });
})
