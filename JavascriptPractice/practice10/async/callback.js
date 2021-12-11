//비동기 프로그래밍의 첫 시작! callback!
//콜백 지옥 체험
/*
    비동기 프로그래밍은 무엇인지
    어떻게 사용하는것이 더 좋은지
    현업에선 어떤경우에 어떻게 사용하는게 조금 더 맞는지
    공부해보자.

    1.callback, 2.promise, 3.async await
    이게 끝나면 네트워크 통신을 할때
    자신감있게 비동기처리 이용 가능하다!
*/
'use strict';

// JavaScrip is synchronous: 자바스크립트는 동기적인 아이다!
// Exeute the code block in order after hoisting.
  /*
    호이스팅이 된 이후부터 코드가 우리가 작성한
    순서에 맞춰서 하나하나씩 동기적으로 실행된다는 말!
  */
 /*
     hoisting: var 변수와 function declaration 함수 선언들이
              자동적으로 제일위로.. 선언들이 제일위로
              올라가는것이 호이스팅!

              그래서 호이스팅이된 이후부터 코드가 나타나는
              순서대로 자동적으로 실행이 된다. 라는말!
 */
console.log('1');
console.log('2');
console.log('3');
/*
    위 console은 순서대로 1 2 3 이 출력된다.
    synchronous는 정해진 순서에 맞게 
    코드가 실행되는 것이다.
*/

console.log('1');
setTimeout(function() {
   console.log('2');
}, 1000); //시간은 밀리세컨드..1000밀리 세컨드는 1초
console.log('3');
/*
    위의 setTimeout 이라는 웹API 예를보자.
    이것은 브라우저에서 제공되는 API로 
    우리가 지정한 시간이 지나면 우리가 전달한 함수..
    콜백함수는 호출하는 것이다.
    콜백함수라는건 우리가 전달해준 함수를 
    나중에 너가 불러줘~ 라는 개념 이었지?
    셋타임아웃이라는 함수에는 setTimeout(요기랑,요기엔) 
    (handler: TimerHandler 이라는 콜백함수와
    timeout?: num 어느정도시간에 타임아웃할건지
    시간을 지정해주는 인자들이 있다.)
    위의 경우 1초가 지나면 우리가 전달한 함수가 실행.
    그니까 1초후 console.log('2')를 출력할것

    근데 출력 해보니.. 1
                      3
                      2
    이 순서로 출력되네???? 자바스크립트 엔진은 코드를
    제일 위에서부터 밑으로 실행하게 되는데..
    console.log를 봤더니 1을 출력하래~ 그래서 1출력
    그 다음라인은 setTimeout이네? 얘는 브라우저API니까
    브라우저야 너에게 요청해 놓았어.. 
    1초뒤에 이 전달해준 콜백을 실행해줘~ 라고한 후
    응답을 기다리지 않고 바로!!
    console.log('3'); 으로 넘어가서 3을 출력해
    그 후 브라우저에서 1초의 시간이 지난 다음에 다시
    야 1초 지났어 콜백함수 실행해! 라고 얘기를 하면
    그때서야 console.log('2');를 출력하게 된다.

    Asynchronous는 비동기적으로 
    위의 setTimeout 사용했을 경우이다!
    언제 코드가 실행될지 예측할수 없는것을 말한다.

    위에서 우리가 전달하는 function (){console.log('2')}
    이 함수는 바로 실행되는 것이 아니라 setTimeout( ,1000);
    이라는 함수 안에 하나의 파라미터 인자로
    우리가 지정한 우리가 만든 함수를 전달해준다.
    그래서 지금 당장 실행하진 않고 
    니가 나중에 1초가 지난다음에 내 함수를 실행해줘!
    내 함수를 나중에 call.. 불러줘! 이렇게 해서
    나중에 다시 불러줘라고 해서 전달하는 
    이런 함수들을 Callback함수라고 하는것이다.

    그리고 보통 이런것들은 일일이 함수들을 선언하지 않고
    에로우 펑션으로 
    setTimeout(() => console.log('2'), 1000);
    간단하게 전달할수있어!
*/
//콜백도 항상 비동기일때만 쓰는게 아니라 2가지로 나눠져.

// Synchronous callback: 즉각적,동기적으로 실행
function printImmediately(print) {
    print();
}
printImmediately(() => console.log('hello'));
/*
    콜백을 파라미터 인자로 받아서 이를 처리하는
    함수를 만들어 보았다.

    printImmediately라는 함수를 만들어서
    printImmediately(print) 뭔지 모르지만 print하는
    콜백을 받아서..
    printImmediately(print) {
        print()
    }
    그 콜백을 이렇게 바로 실행하는 함수를 만들어보았다.

    function printImmediately(print) {
    print();
}
    printImmediately()
    함수를 이용할땐 printImmediately() 를 호출하자.
    print라는 콜백함수를 전달받지? js는 타입이 아니라서
    어떤 타입의 콜백함수를 받는지는 예측할수없지만

    아무런 인자가 전달되지않고 간단하게 console.log를
    출력하는 함수를 전달해보자.
    printImmediately(() => console.log('hello'));

    그래서 이걸 출력해보면 hello가 바로 출력이 된다.
    우리가 앞에 작성했던 2가 1초뒤에 출력되는걸 볼수있다.

    js엔진이 어떻게 했을까?
    1.함수의 선언은 호이스팅이 된다고 했으니까
      function printImmediately(print) {
      print();
      } 이렇게
      함수의 선언을 제일 위로 올려놨을거야.
    2.그리고 순서대로 함수가 선언이 되었고
      1을 출력하고
      setTimeout(() => console.log('2'), 1000);을
      브라우저에게 요청하고(setTimeout얘를)
      바로 또 3을 출력하고
      바로 printImmediately(() => console.log('hello'));
      함수를 호출해서 위의 function printImmediately(print){
          pirnt();
      }
      도 바로 print 하니까 1,3,hello 그다음
      setTimeout(()=>console.log('2'))부분의 2가
      실행이 되면서 2가 출력이돼.

*/

// Aynchronous callback: 나중에,언제실행될지 예측불가
 function printWithDelay(pirnt, timeout) {
     setTimeout(print, timeout);
 }
 printWithDelay(() => console.log('async callback'), 2000);

 /*
    일단 함수에 print와 얼마정도 timeout을 하고싶은지
    인자를 2개 받아오고 

    setTimeout(pirnt, timeout);
    브라우저 API를 이용해서 우리가 원하는 
    (print 라는 콜백함수를 호출,
        timeout 이라는 인자 전달) 해서..
    그래서 이 pirntWithDelay함수는 결국은 
    setTimeout을 감싸고있는.. 랩핑하는 함순데
    전달받은 print와 timeout을 결국에는
    setTimeout에 요청하는거다.

    그리고 호출하고 싶다면
    printWithDelay(() => console.log('async callback'), 2000);
    처럼 console.log('async callback')
    우리가 원하는기능을 동작하는 콜백함수를 전달해
    시간은 2초정도네.

    그럼 위에꺼까지 합쳐서
    1
    3
    hello
    2
    async callback   
    이 순서로 출력이 돼.

    출력 순서는!
    1.모든 함수의 선언은 호이스팅 되기 때문에
      Synchronous callback의 
      function printImmediatley(print){}가 제일위로 그다음
      Asynchronous callback의
      function printWithDelay(print, timeout){}가 위로가고
    2. console.log('1'); 출력 (동기)
    3. setTimeout(()=> console.log('2'), 1000); 브라우저에게 요청해놓고~(비동기)
    4. console.log('3'); 출력 (동기)
    5. printImmediately(() => console.log('hello')); (동기)가
       호출 되었으니까 Synchronous callback의 
       function printImmediately(print){pirnt()};함수를
       호출해서 바로 출력하니까 hello 출력.
    6. printWithDelay(() => console.log('async callback'), 2000) (비동기)도
       브라우저에게 요청!
    7. 브라우저에서 1초의 시간이 지난 다음에는
       3.번의 setTimeout의 콜백함수 실행해서 '2' 출력.
    8. 2초 뒤에는 6.의 콜백함수 실행해서 async callback 출력.
 */

//콜백함수는 위처럼 유용하게 쓰일때도 있지만
//콜백지옥! 콜백함수들을 계속 네스팅..묶어나가서 
//콜백함수 안에서 다른 콜백함수를 부르고부르고부르고부르고
//하면서 콜백지옥이 생겨.

//콜백지옥 예제! Callback Hell example

//먼저사용자의 데이터를 백엔드.. 서버에게서 받아오는 클레스 작성
class UserStorage { //여긴 총 2가지 API가 있다고 가정하자.
    //id와password를 받아오고 로그인이 정상적으로 이루어졌다면
    //onSuccess라는 콜백함수를 사용자의 데이터와 함께 호출해주고,
    //만약 로그인이 실패했다면.. 존재하지 않는
    //사용자거나 비밀번호가 틀렸다거나,네트워크에 문제가있거나해서 에러가 발생시 
    //onError이라는 콜백함수를 호출.
    loginUser(id, password, onSuccess, onError){//이런 함수 하나와
        //백엔드와 직접통신하는건 추우게 노트할것이고
        //이런 실제 백엔드가 없기 때문에..
        //setTimeout이라는 API를 이용해서 어느정도
        //시간의 딜레이를주며 네트워크 통신을 하는것처럼 만들어보자
        setTimeout(() => {//loginUser함수 호출시 2초뒤 이 코드블럭이 실행돼.
            //코드는 id가 ellie이고 비밀번호가 dream이거나
            //id가 coder이고 비밀번호가 academy면 
            //전달받은 onSuccess라는 콜백 불러주는데 id를 전달해줌 
            //아닐시 onError콜백을 불러주며
            // Error라는 오브젝트를 만들어서 not found라고 전달해줄것.
            if(
                (id === 'ellie' && password === 'dream') ||
                (id === 'coder' && password === 'academy')
            ) {
                onSuccess(id);
            } else {
              onError(new Error('not found'));
            }
        }, 2000);
    }

    /*
    user로 사용자의 데이터를 받아서 사용자마다 가지고있는
    어드민 이라던지 게스트라던지 그런 역할들을 서버에게
    다시 요청해서 정보를 받아오는 API가 있다고 생각하자.

    원래는 사용자가 로그인하면 이 로그인하는 사용자 
    정보안에 관련된 정보들을 한번에 백엔드에서 받아오는것이
    맞다!

    하지만 우리 예로 백엔드가 예전에 만들어져서..
    너무너무 오래전에 설계가 되어서.. 
    사용자의 역할을 따로 네트워크 요청을 해서
    다시 받아와야되는 나쁜 백엔드라고 가정해보자..

    그래서 사용자의 역할을 잘 받아온다면 위랑 똑같이
    onSuccess라는 콜백함수를 사용자역할과 함께 호출하고,

    만약 문제가 있다면 onError 호출한다.
    */
    getRoles(user, onSuccess, onError){//이런 함수 하나가 있다.
        setTimeout(() => { //사용자가 역할을 받아올때 1초뒤 이 코드블럭 시행돼.
            if(user === 'ellie') {
                onSuccess({ name: 'ellie', role: 'admin' });
            } else {
                onError(new Error('no access'));
            }
        });
    }
}

// 자 이제 위의 class UserStorage를 이용해서 코딩을 한번 해보자..
/*
    1. id와 password를 입력을 받아올것! 이것을 이용해서
    2. 첫번째로는 서버에게 로그인해줘! 즉, 로그인을 해볼것이고
    3. 로그인이 성공적으로 된다면우리가 로그인한 사용자의 id를 
       onSuccess(id)에서 다시 받아오지? 이 받아온 아이디를 이용해서
       Roles.. 역할을 다시 요청해서 받아올거임.
    4. getRoles에 역할을 요청해서 역할이 성공적으로 받아와지면
       우리에겐 사용자의 오브젝트가 있겠지? onSuccess에 이름과 역할이 들어있는..
       얘네들을 출력해보는것을 간단히 해보자.
*/

const userStorage = new UserStorage(); //이걸 이용해 백엔드와 통신해볼거임.
const id = prompt('enter tour id');//사용자에게 id를 받아올건데 브라우저API중 하나인 prompt를 이용해보자
const password = prompt('enter your passrod');
userStorage.loginUser(//첫번째론 로그인해보자.
    id, 
    password, 
    user => {
        userStorage.getRoles(
            user,
            userWithRole => {
                alert(`Hello ${userWithRole.name}, you have a ${userWithRole.role} role`);
            },
            error => {
                console.log(error);
            }
        );
    },
    error => {
        console.log(error);
    }
);

//위의 문제는 무엇일까?
/*
    콜백을 이용해서..
    콜백함수 안에서 무언가 다른것을 호출하고
    그 안에서 또다른 콜백을 전달하고
    그 안에서 만약 다른것을 호출하고 전달전달하면,
    이것이 바로 콜백지옥이야!!

    콜백지옥의 문제점은
    첫번째론 읽기가 너무 거북해.. 가독성이 너무 떨어져
    어디에 어떤식으로 연결되어있는지 한눈에 가늠하기도 어렵고
    비즈니스 로직을 한눈에 이해하는것도 너무너무 어려워.

    지금 위의 코드에서 아~ 로그인을 한다음에
    그 로그인한 데이터를 이용해서 사용자의 역할을 받아오는구나.
    이것을 한눈에 알아보기가 굉장히 어렵다는 말..

    그리고 나중에 에러가 발생하거나 디버깅을 해야할 경우에도
    굉장히 어렵다. 무슨 문제가 생기면 어디 에러에서
    처리해야 하는지 체인이 길어지면 길어질수록
    디버깅하고 문제를 분석하는것도 어렵고
    유지보수도 어려워서 콜백지옥이라는 말이 나온것이야!
*/