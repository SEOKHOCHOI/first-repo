// Function
// - fundamental building block in the program
//   프로그램을 구성하는 아주 기본적인 building block

// - subprogram can be used multiple times
//   subprogram으로도 불리며 여러번 재사용 가능한 장점가짐.

// - performs a task of calculates a value
//   한가지의 테스크나 어떠한 값을 계산하기 위해 쓰여짐.

// 1. Function declaration, JS에서 펑션을 정의하는 방법!
// function name(param1, param2) { body... return; }
// 이렇게 펑션이라는 키워드 이용하고 함수 이름 지정 후 
// ()안에 파라미터스를 쭉 나열한 다음 {} 안에
// body 함수안에 기본적인 비즈니스 로직을 작성한 후 
// return을 해주면 돼!

// one function === one thing
// 즉, 하나의 함수는 한가지의 일만 하도록 만들어야 해.

// naming: doSomething, command, verb
// 함수의 이름을 작성할땐 변수이름처럼 명사가 아니라
// 무언가를 동작하는것이기에 위처럼 do~, com~,나 동사 형태로 지정해야해
// 함수 이름을 정하기가 너무 어렵다면 혹시내가 함수안에서
// 너무 많은것들을 하고있진 않은지 생각해볼 필요가있어. 
// e.g. createCardAndPoint -> createCard, createPoint
// 위처럼 크리에이트카드엔드포인트처럼 두가지의 기능이있다면
// 이걸 좀 더 세분화 해서 나눌수있지 않을지 생각해 봐야해.

// function is object in JS
// JS에서 펑션은 오브젝트야! 중요한 포인트야.
// 그렇기 때문에 펑션을 변수에 할당하거나
// 파라미터로 전달이되고 함수를 리턴할수도 있게 되는것!

function printHello() { //펑션키워드를 쓰고 함수이름은 프린트헬로우고 ()안에파라미터는 하나도 받지않고
    console.log('Hello'); //콘솔에 헬로우 출력
} //위처럼 함수를 잘 정의후
printHello(); //이런식으로 함수를 호출할수있음 그럼 콘솔창에 헬로우뜸.
// 근데 위의 함수는 좀 쓸모가없음 헬로뿐이 출력 안되잖아?
// 그래서 좀 더 유용한 함수를 만드려면
function log(message) { //이렇게 파라미터로 메시지를 전달하면 이 전달된 메시지를 
    console.log(message); //화면에 출력하도록 만드는게 좋아
}
log('Hello'); //그래서 이렇게 log라는 함수를 호출하면서
//우리가 원하는 메시지를 ()안에 입력할수가 있어.
// 그럼 이게 출력이 돼!

// JS에선 타입이 없다고했지?
// 그렇기때문에 좀 아쉽게도 함수 자체에 인터페이스만 보았을때
// 메시지가 스트링을전달해야 하는지 숫자인지 명확하지않아
// 그래서 사용하는 사람이 
log(1234); // 이렇게 숫자를 전달할수도 있잖아?
// 다행히 숫자가 문자열로 변환이 되어 출력이 되기에 상관은 없지만,
// 다른 함수에서 타입이 중요한 경우에는
// JS는 조금 난해할수가 있어 그니까 나중에 TS배워

// 2. Parameters : 펑션에 전달되는 ()안에 적히는 파라미터들은
// 메모리에 벨류가 그대로 저장돼 있기 때문에 벨류가 전달이 되고
// 오브젝트 같은 경우 메모리에 레퍼런스가 저장이되니
// 그래서 레퍼런스가 전달이 되어져
function changeName(obj) { //체진지네임이라는 펑션은
    obj.name = 'coder';//전달된 오브젝트의이름을 coder로 무조건 변경하는 함수다.
}//그래서 우리가
const ellie = { name: 'ellie' };//ellie라는 const정의 후 이 ellie라는 오브젝트를 만들어 할당해주면
//메모리에는 이 오브젝트가 만들어진 레퍼런스가 들어가게 되고
//이 레퍼런스는 바로 이 오브젝트를 메모리 어딘가에 가리키고 있다.
changeName(ellie);//그래서 체인지네임 엘리를 전달하게 되면
//이 전달된 엘리가 가리키고 있는 곳의 이름을 coder로 변경하게됨.
console.log(ellie);//그래서 이렇게 출력하게되면 ellie의 이름이 coder로 변경된걸 볼수있어.
//그래서 오브젝트는 레퍼런스로 전달되기 때문에 
// 함수 안에서 오브젝트의값을 변경하게 되면 그 변경된 사항이
// 그대로 메모리에 적용이 되기 때문에 추후에 변경된 사항들을 확인가능.

// 3. Default parameters (added in ES6) ES6에서 추가됨!
function showMessage(message, from) { //쇼메시지 펑션을 보면 메시지와 프롬 두가지의 파라미터스를 받아오지?
    console.log(`${message} by ${from}`);//그래서 이 메시지가 누구로부터 왔는지 출력을하게 되는데..
}
showMessage('Hi!');//여기서보면 쇼메시지 호출할때 하나만.. 메시지만 전달되는걸 볼수있지?
//그렇기에 메시지는 출력이 잘 되니만 from은 정의되어져 있지 않기 때문에
// 언디파인드로 나오는걸 볼수있어.
// 그래서 예전엔 이렇게 파라미터값이 전달되지 않을걸 대비하여
/* 
   if (from === undefined) { //프롬이 언디파인이면
       from = 'unkown'; //우리가 원하는 가장 기본적인 언노운 이라는 스트링을 추가하자
   } // 그럼 프론 언노운 이렇게 출력되는걸 볼수있는데..
*/
//이제는 저럴 필요 없이 파라미터  옆에 원하는 디폴트값을 지정해두면돼.
/*
   function showMessage(message, from = 'unknown')이렇게! from옆에 보이지?
   이러면 사용자가 파라미터를 전달하지 않을때 저 언노운값이 대체되어 사용되어져.
*/

// 4. Rest parameters (added in ES6)
function printAll(...args) { //이렇게 닷닷닷 연달아...세개를 작성하게 되면
    //레스트 파라미털즈 라고 불리는데 이건 배열형태로 전달이 돼!
    for (let i = 0; i < args.length; i++) {
        console.log(args[i]);
    } 
}
printAll('dream', 'coding', 'ellie'); // 그래서 printAll이란 함수를 호출할때
// 인자를 총 세개를 전달했지? 그래서 지금 위의 args는 
// 세개의 값이 담겨져 있는 배열이야 배열형태로 전달이돼!
// 그래서 for루프를 이용해서 처음부터 args의 갯수만큼 
// 빙글빙글 돌면서 처음출력 두번째출력 세번째출력을 하게 돼.
// dream
// coding
// ellie  이렇게 출력돼.
//보너스로.. 이렇게 배열같은걸 출력할때는 for루프 말고
/*
    for (const arg of args) {
        console.log(arg);   
    } 

    이렇게 간단하게 출력할수도있어.
    args의 있는 모든 값들이 차례대로 하나씩 arg에 지정이 되면서
    arg를 출력하게 되는것!
*/
// 더 간단한건 배열을 배우면
// args.forEach((arg) => console.log(arg));
// 위처럼 배열에 forEach라는 함수형 언어를 이용해 출력해도 괜찮아!

//다음으로 넘어가기전 위에서 펑션은 오브젝트의 일종이다.라고했었지?
//무슨말 이냐면 우리가 위에서 printAll이라는 함수를 선언했잖아?
//콘솔에서 여기서 닷(.)을 누르면 함수가 오브젝트로 전환이 되기 때문에
//프린트올의 속성값들을 확인해볼수가있어 나중에 오브젝트,프로토타입을 다룰때 다시보자.

// 5. Local scope, 스코프에 대해 한번더 정의해보자
// 이 개념을 이해하자
// 밖에서는 안이 보이지 않고 안에서는 박을 볼 수 있다.
// 블럭안에서 변수 선언시 이건 지역변수! 안에서만 접근 가능
// 밖에서 이걸 출력시 에러남
// 근데 안에서는 글로벌메시지를 볼수있고 출력가능! 이게 바로 scope!
// 이 원칙은 어디서나 적용돼.
// 함수 안에서 또 다른 함수를 선언할수 있는데 같은 원칙에 따라
// 자식함수는 부모에게서 정의된 메시지들을 확인할수있는데
// 부모상에서 자식에게 정의된 챠일드메시지를 확인하려 하면 에러발생됨.
let globalMessage = 'global'; // global variable
function printMessage() {
    let message = 'hello';
    console.log(message); // local variable
    console.log(globalMessage);
    function printAnother() { //얘가 자식함수
       console.log(message); //부모꺼 가능
       let childMessage = 'hello';
    }
    //이렇게 리턴타입이 없는 함수들은
    return undefined;//가 들어간것과 똑같다. 이걸 생략가능하다.
    //console.log(hildMessage); 이렇게 자식꺼 지위치에서 하려면 에러남.
} //중첩된 함수에서 자식의 함수가 부모함수에 정의된 변수에
// 접근이 가능한 것들이 바로 클로져야! 후에 공부해보자.
printMessage();

// 6. Retrun a value
function sum (a, b) { //파라미터로 값들을 전달 받아서
    return a + b; //계산된 값을 리턴할수가 있다.
}
const result = sum(1, 2); //썸이라는 함수를 호출하게되면 3이 리턴된다.
console.log(`sum ${sum(1, 2)}`);

// 7. Early return, early exit   현업에서 쓰이는 팁!!
// 위처럼 얼리 리턴, exit해라 라는 코드지적질을 받을수있는데 그말은
// bad
function upgradeUser(user) { // 업그레이드유절이라는 함수 안에서
    if (user.point > 10) { //유저의 포인트가 10초과일 경우에만 업그레이드를 진행하는 로직이 있다면
        //블럭안에서 로직을 많이 작성하면 가독성이 떨어져.
        //그래서 이런 경우에는 if와 else를 많이 쓰기보다는..
        // long upgrade logic...
    }
}

//good 경우!
function upgradeUser(user) {
    if (user.point <= 10) {
        return;
    }//이런식을 조건이 맞지 않을땐 빨리 return해서 함수를 종료하고
    //조건이 맞을때만 그다음 와서 필요한 로직들을
    // long upgrade logic... 이렇게 쭉 실행하는것이 더 좋다.
}

// 1. Function expression
const print = function () { //함수선언과 동시에 프린트라는 변수에 할당.
    //이렇게 펑션에 아무 이름이 없고 펑션이라는 키워드를 이용해서 파라미터와 블럭을 이용하고
    //함수의 이름이 없이 필요한부분만작성해 변수에 할당한것을 anonymous function 이라고한다.
    //이때 우리가 원한다면 function print() 라고 함수의 이름을 써줬어도 돼. 이걸 네임드 펑션 이라고 해. 
    console.log('print');
}; // 이렇게 함수를 print에 할당하게 되면 print라는 변수에
print(); //함수를 호출하듯이 ()이렇게 호출하게 되면 프린트가 출력이돼.
const printAgain = print; //그리고 다른변수에 이렇게 print를 또 할당하게되면
//printAgain은 위의 fuction을 가리키고 있기 때문에
printAgain();//이렇게 다시 함수를 호출하는것처럼 부르면 print가 출력돼.
const sumAgain = sum;//위에서 sum이라는 펑션을 만들었었는데 이것도 썸어게인이라는 변수에 다시 할당하게되면
console.log(sumAgain(1, 3));//이렇게 동일하게 호출할수가있어.
/*
    이렇게 Function Expression과 function declaration의 가장 큰 차이점은
    Frunction Expression은 위처럼 function이 print에 할당된 다음부터
    호출이 가능한 반면에(print를 선언하기전에 호출하면 에러뜸), 
    function declaration은 hoisted가 돼!
    즉, 얘는 함수가 선언되기 이전에 호출해도 된다는거야.
    이것은 자바스크립트 엔진이 선언된것을 제일 위로 올려주기 때문이야.
    이러한 차이점 등이 있어.
*/

// 2. Callback function using function expression
function randomQuiz(answer, printYes, printNo) { //정담과, 맞으면예스, 틀리면노를 호출하게될 함수 상황에 맞게 함수불름 이런걸 콜백펑션이라함!
    if(answer === 'love you') {
        printYes();//정답이면 printYes라는 callback함수 호출
    } else {
        printNo();//노면 얘 호출
    }
}

const printYes = function() { // anonymous function
    console.log('yes!');
};

//밑처럼 이름을 쓰는 경우는 디버깅을 할때
//디벙깅의 stack traces에 함수의 이름을 나오게 하기위함이다.
const printno = function print() { //named function
    console.log('no!');
    print();//또는 함수안에서 자신스스로 또다른 함수를 호출할때
    //네임드펑션을 사용. 이런걸 recursions라고하는데
    //이러면 프로그램이 죽으니 피보나치수열이나
    //반복되는 평균값계산처럼 정말 필요할때 써라.
};
randomQuiz('wrong', printYes, printNo);
randomQuiz('love you', printYes, printNo); 

//Arrow function, 함수를 간결하게 만들어주는 너무좋은놈!
//always anonymous 명심!!
const simplePrint = function() {
    console.log('simplePrint!');
};  //이렇게 펑션익스프레션을 쓰게되면 
// function이라는 키워드도 써야하고 {} 써야하는 번거로움이 있는데,
// 에러 평션은 밑처럼 간단하게 해준다. 펑션키워드랑 블럭이필요x.
const simplePrint = () => console.log('simplePrint!');
//이렇게 해주면 끝!!
const add = (a, b) => a + b;
//위처럼 파라미터는 a,b숫자를 받아서 리턴값은 a+b인데 이걸
//펑션 익스프레이션으로 바꾸게 되면
const add = function (a, b) {
    return a+b;
};  //이렇게 해줘야해서 귀찮아!
//함수형 프로그래밍인 배열이나 리스트같은걸 볼때 그래서 Arrow펑션이 좋아!
//물론 함수 안에서 조금 더 다양한 작업이 필요해서 블럭이 필요하다면
const simpleMultiply = (a, b) => {
    //do something more
    return a * b;// 대신블럭을쓰게되면 return을써서 값을 리턴해 줘야해.
};  // 이런식으로 블럭을 넣어서 처리할수도 있어

// IIFE: Immediately Invoked Function Expression
// 함수를 선언하게 되면 따로 hello();라고 함수를 호출을해줘야하잖아?
// 하지만 선언함과 동시에 바로 호출하려면 
// 함수의 선언을 괄호로 묶은후 함수를 호출하듯이 해주면 
// 바로 함수가 호출되는걸 볼수가있어.
(function hello() {
    console.log('IIFE');
})();  // 전체를()로 묶꼬 ();이렇게 함수호출하듯이 해준걸 말하는거임!