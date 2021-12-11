// promise(약속)가 callback을 대체해서 어떻게 깔끔하게
// 작성할수 있는지 알아보자! 

/*
    Promise는 JS에서 제공하는 비동기를 간편하게
    처리할수있도록 도와주는 오브젝트다.
    정해진 장시간의 기능을 수행하고 나서
    정상적으로 기능이 수행이 되어졌다면 
    성공의 메시지와 함께 처리된 결과 값을 전달해주고,
    만약 기능을 수행하다 예상치못한 문제가 발생했다면
    에러를 전달해줘.

    한 가지 예를들어 설명하자면!
    드림코딩 아카데미에서 지금 준비중인 코스가 있는데
    언제 코스가 완료될지 모르는 시점이다.
    하지만 관심이 있는 학생분들은 이렇게 이메일을 통해서 미리
    등록할수있는 시스템이 있다고 가정해보자.<이게 Promise생성>

    그래서 영희학생분이 와 나 너무 관심있어 
    나 얼른 수업에 등록해야지 라고 등록을 완료하게 되면, <Promise에 등록>
    몇시간 또는 며칠의 시간이 지난다음에 
    코스가 드디어 오픈이 되면 바로 영희님께
    메일로 공지가 오게될거다. <Promise가 성공적으로 값을 전달함>

    영희님은 수업이 준비되기 전에 미리 등록을 해놨기 때문에
    수업이 완료되자마자 공지를 받을수가 있었다.

    수업이 이미 오픈된 뒤에 철수가 뒤늦게 사전 공지창을 발견하게돼. <이미 성공적으로 처리도니 Promise>
    뒤늦게 이메일 주소를 입력하고 등록을 하게 됩니다.
    하지만 수업은 이미 오픈이 되었기 때문에 
    기다릴 필요가 없이 바로 철수에게 메일로 공지가 오게되고,
    수업에 바로 참여할수가 있게 되는것이다.
*/

//이제 코드를 보며 어떻게 콜백을 쓰지 않고 프로미스 오브젝트를 통해서
//비동기 코드를 깔끔하게 처리할수 있는지에 대해서 코드로 알아보자.

'use strict';
/**
   오늘 노트할 promise는 바로 js안에 내장되어져있는 오브젝트다.
   프로미스 오브젝트는 비동기 오퍼레이션을 위해 쓰이는데,
   비동기적인 것을 수행할때 콜백함수 대신에 유용하게
   쓸수있는 그런 오브젝트다.

   프로미스는 딱 두가지만 포인트를 잡고 공부하면 된다.
   첫 번째는, state 상태 이다.
   이 프로세스가 무거운, 헤비한 오퍼레이션을 수행하고 있는 중인지
   아니면 이 기능 수행이 다 완료가 되어서 성공했는지 실패했는지
   이런 상태에 대해서 이해하는 것이 중요하다.

   두 번째는, 프로듀서와 컨슈머의 차이점을 아는것이다.
   우리가 원하는 데이터를 제공하는 사람과
   이 제공된 데이터를 쓰는 사람 필요로 하는사람인 컨슈머
   이 두가지의 차이점을 잘 이해하자.

   정보를 제공하는 프로듀서와 이 정보를 소비하는 소비자의 두가지
   다른 견해를 이해하면 좋겠다.
 */
// Promise is a JavaScript object for asynchronous operation.
/* 
    state: 프로미스의 상태는 프로미스가 만들어져서 
    우리가 지정한 오퍼레이션이 수행 중일때는 pending상태가 되고,
    이 오퍼레이션을 성공적으로 다 끝내게 되면 바로 
    fulfilled state가 된다. 완벽하게 완료한 상태겠지?
    아니면 파일을 찾을수가 없거나 네트워크에 문제가 생긴다면
    rejected 상태가 된다.
    
    그리고 프로미스에는 우리가 원하는 기능을 수행해서
    해당하는 데이터를 만들어내는 
    Producer, 즉 프로미스 오브젝트겠지? 이거봐
    우리가 원하는 데이터를 소비하는
    Consumer로 나누어진다.
    Producer vs Consumer
*/

// 1. Producer

//promise는 class이기 때문에 new라는 키워드를 이용해서
//object를 생성할 수가 있다.
//promise의 생성자를 보면 executor라는 콜백함수를 전달해줘야하는데
//이 콜백함수에는 또 다른 두가지의 콜백함수를 받는다.
//resolve: 기능을 정상적으로 수행해서 마지막에 
//   최종데이터를 전달하는 resolve 콜백함수와.
//reject: 기능을 수행하다가 중간에 문제가 생기면 호출하게될 reject
//const promise = new Promise((resolve, reject) => {});
//   이렇게하면 하면 프로미스 오브젝트를 만든것이다.

/*
    보통은 프로미스 안에서 조금 헤비한 일들을 하겠지?
    왜냐하면 우리가 네트워크에서 데이터를 받아오거나
    파일에서 무언가 큰 데이터를 읽어오는 그런 과정은
    시간이 꽤 걸린다.
    그런걸 동기적으로 처리하게 되면 우리가 파일을 읽어오고
    네트워크에서 데이터를 받아오는 동안 
    그 다음라인에 코드가 실행되지 않기 때문에
    시간이 조금 걸리는 일들은 이렇게 프로미스를 만들어서
    비동기적으로 처리하는것이 좋아.
    
    그래서 네트워크 통신이나 파일을 읽어온다던지 이런것들은
    다 비동기적으로 처리하는 것이 좋아.
*/
const promise = new Promise((resolve, reject) => {
    //doing some heavy work (network, read files)
    console.log('doing something...');
});
/*
    위에서 알수있는 사실은 promise를 만드는 순간 
    우리가 전달한 excu~~라는 콜백함수가 바로 실행되는것을
    확인할수가 있었다.

    이 말은 즉슨 만약 우리가 이 프로미스 안에 
    네트워크 통신을 하는 그런 코드를 작성했다면 
    promise가 만들어지는 그 순간 
    바로 네트워크 통신을 수행하게 된다.

    여기서 우리가 배울수있는 중요한 포인트는 
    만약 네트워크 요청을 사용자가 요구했을 때만
    해야되는 경우라면 즉, 사용자가 버튼을 눌렀을때
    네트워크 요청을 해야되는 경우라면 이런 

    const promise = new Promise((resolve, reject) => {
    console.log('doing something...');
    });

    이런식으로 작성하게 되면 사용자가 요구하지도 않았는데
    불필요한 네트워크 통신이 일어날수있겠지?
    그래서 프로미스를 만드는 순간 그 안에 전달한
    엑스큐터라는 콜백함수가 바로 실행기 되기 때문에 
    이점을 조금 유의해서 공부해야한다.
*/
// 그러므로 이걸 유의하자!!
// 새로운 프로미스가 만들어 질때는 우리가 전달한 엑스큐터라는
// 콜백함수가 바로 실행이 된다. 자동적으로.. 
// when new Promise is created, the executor runs automatically.

//이제 위의 프로미스를 변형하고 이 프로미스 안에서
//네트워크 통신을 하는것처럼 셋타임아웃을 이용해서
//조금 시간에 딜레이를 주도록 해보자.
// 이 promise는 2초정도 어떤일을.. 무언가를 하다가 결국에는
// 일을 잘 마무리해서 resolve라는 콜백함수를 호출하면서
// ellie라는 값을 전달해주는 그런 promise야.
const promise = new Promise((resolve, reject) => {
    console.log('doing something...');
    setTimeout(() => {//성공적으로 수행시 리절브콜백함수 호출
        //resolve('ellie');//우리가 데이터를 받아왔는데 사용자 이름은 ellie였어~
                         //즉, 네트워크에서or파일에서 받아온 그리고 그것들을 가공한 데이터를 리졸브라는 콜백함수를 통해서 전달하면돼.
                        
        reject(new Error('no network'));                    
    }, 2000);
});
//바로 위처럼 promise라는 프로듀서를 만들어 놨으니
//이제 밑에선 이것을 이용하는 컨슈머를 만들어보자.

// 2. Consumers: then, catch, finally를 이용해서
//           값을 받아올수가 있다. 무슨말 이냐고?
/*
    우리가 앞에 promise라는 변수를 만들었지?
    이것을 이용해서 promise 값이 정상적으로 수행이 된다면
    then 그러면 이제 내가 값을 받아올 거야. 
    어떤 value 값을 받아와서 우리가 원하는 기능을 수행하는 
    이 콜백함수를 전달해주면돼. 
    promise.then((value) => {

    }); 이렇게..

    여기서 (value)라는 파라미터는 프로미스가 정상적으로
    잘 수행이 되어서 마지막으로 resolve 콜백함수에서
    전달된 ellie라는 값이 여기 들어오겠지?
    그래서 value가 들어오면 우리가 이걸 console.log(value); 출력
    해보면 2초 후 ellie 라고 출력될거야.

    즉, then 이라는것은 프로미스가 정상적으로 잘 수행이 되어서
    마지막에 최종적으로 resolve 라는 콜백함수를 통해서
    전달한 이 값이 then(value)의 파라미터로  
    전달되어져 들어오는걸 볼수있어.

    resolve말고 reject를 쓰게되면?
    
    만약 우리가 네트워크를 하다가 무언가 실패다 치고
    그래서 resolve 대신에 reject를 호출해보자.
    이 reject는 보통 Error라는 오브젝트를 통해서 값을 전달하는데,
    reject(new Error())여기서 이 Error라는 클레스는
    js에서 제공하는 오브젝트중 하나이다. 그래서 에러는
    무언가 에러가 발생했다는걸 나타내는 오브젝트 이다.
    보통 에러 오브젝트에는 어떤 에러가 발생했는지 이유를
    잘 명시해서 작성해돼.
    우리는 no network 네트워크가 없었어~ 로 작성해보자.

    이러고 에러의 메시지를 읽어보면 Uncaught 
    잡히지 않은 에러가 발생했다고 떠.이 말은
    
    promise.then(value => {
    console.log(value);
    });
    여기서 then 이라는것을 이용해서 
    성공적인 케이스만 다뤘기 때문인데,
    여기서 에러 핸들링을 어떻게 잘 할 수 있느냐..

    첫 번째 우리가 promise에서 then이라는 
    API를 이용해서 성공적인 케이스를 잘 다뤘다면,

    catch라는 함수를 이용해서 에러가 발생했을때
    어떻게 처리할건지 callback함수를 등록해주면 돼.
    .catch(error => {
    console.log(error);
  });
   이런식으로.. 이러면  더이상 에러가 발생하지 않고
   우리가 받아온 Error: no network 가 
   콘솔로그에 출력되는걸 확인해볼수가 있어.

   가끔 이걸 헷갈려하는 사람이 있는데
   promise에 then을 호출하게 되면 then은 결국
   똑같은 promise를 return하기 때문에 
   그 리턴된 promise에 catch를 다시 호출할수가 있는거야!
   이걸 체이닝 이라고 하는데 
   array 공부할때도 API들을 묶고 묶어서 결국은 map도
   똑같은 array를 return 하기 때문에 리턴된 array에
   sort함수를 호출하고 sort함수에서 return된
   문자열에 join을 이용한것처럼.. (배열노트 마지막부분 봐)
   프로미스에서도 then을 호출하게 되면 다시 promise가
   리턴이 되고 리턴된 프로미스에 catch를 등록하는거야.

*/

promise
  .then(value => {
    console.log(value);
  })
  .catch(error => {
    console.log(error);
  })
  .finally(() => {//얘는 성공하던 실패하던 상관없이 무조건 마지막에 호출되어지는애야. 
    console.log('finally'); //아무런 인자를 받지않고 콘솔로그를 출력하게되면 앞에 실패던 성공이던 마지막에 출력돼.
});//성공하던 실패하던 상관없이 어떤기능을 마지막에 수행하고 싶을때 파이널리를 쓰자!

// 3. Promise chaining
const fetchNumber = new Promise((resolve, reject) => {//서버에서 숫자를 받아오는 새로운 프로미스
    setTimeout(()=> resolve(1), 1000); //1초 있다 숫자1 전달
});

fetchNumber           //참고로 처음 num에는 1전달되고 2가 곱해져 2가되는거임.
.then(num => num * 2)//fetchNumber가 성공적으로 잘 수행이되면 그 숫자로 2배로 곱하고
.then(num => num * 3)//다시 그숫자로 3으로 곱하고
.then(num => { //그리고 그 숫자를 다른 서버에 보내서 다른 숫자로 변환된 값을 받아오자
    return new Promise((resolve, reject) => {//이 프로미스는 다른서버와 통신하겠지?
        setTimeout(() => resolve(num -1), 1000);
    });
})//이렇게 한 다음에 그 숫자를
.then(num => console.log(num));//출력해보도록 하자!

//then은 값을 바로 전달할수도 있고 promise를 전달해도 돼.
//최종적으로 출력되는데 걸리는시간은 셋타임아웃에서 1초, 밑에셋타임아웃에서1초니 총 2초 걸려

//이렇게 프로미스를 체이닝 했을때 어떻게 에러를 핸들링할수있을까?


// 4. Error Handling

/*
const getHen = () =>
  new Promise((resolve, reject) => {
      setTimeout(() => resolve('닭'), 1000);
  });
const getEgg = hen =>
  new Promise((resolve, reject) => {
      setTimeout(() => resolve(`${hen} => 달걀`), 1000);
  });
const cook = egg =>
  new Promise((resolve, reject) => {
      setTimeout(() => resolve(`${egg} => 후라이`), 1000);
  });

/*
/*
  위는 총 세가지의 promise를 return하는 함수이다.
  getHen은 닭을 리턴
  getEgg는 hen을 받아서 그 hen으로부터 달걀을 리턴
  cook은 egg를 받아서 egg로 부터 후라이를 만드는 함수.

  그리고 각각 이것을 서버에서 닭을 받아오고
  달걀을 받아오고 요리까지 하는거로 가정해서 해보자.
*/

/*

getHen() //먼저 닭을 받아오고 그다음에 닭이 받아와지면
.then(hen => getEgg(han))//전달받은 닭을 이용해서 getEgg라는 함수 호출, 그리고 이게 정상적으로 수행되면
.then(egg => cook(egg))//받아온 달걀을 가지고 요리를 한다. 요리가 다완료된 다음에는
.then(meal => console.log(mean));//요리가되면 무자열이 출력되지? 요리된 음식을 콘솔로그에 출력해보자.

*/
//그럼 시간이 3초 소요된 후에  닭 => 달걀 => 후라이  이거 그대로 출력됨.

/*
  위의 코드를 조금 깔끔하게 작성할수 있는데
  콜백함수를 전달할때 받아오는 value를 => getEgg(hen) 이렇게
  다른함수로 바로 하나를 호출하는 경우에는 생략이 가능하다.
  .then(getEgg) 이런식으로 말이다. 그럼 자동적으로
  then에서 받아오는 벨류를 바로 getEgg라는 함수에 전달해서
  암묵적으로 전달해서 호출해준다. 한가지만 받아서 그대로
  전달하는경우에는 생략이 가능한거 알고있어~ 그럼 코드는 밑에처럼 작성돼.

  getHen() //
    .then(getEgg)
    .then(cook)
    .then(console.log); //밀을받아와서 콘솔로그에 출력하는거니 얘도 생략가능.

 getHEn() 옆에 //해준 이유는 프리티어 포맷에서 한줄로 바꿔주는데
 getHen().then(getEgg).then(cook).then(console.log);
 이렇게 작성되는걸 방지한거야 가독성안좋아.

*/

//만약 달걀을 받아오는 부분에서 실패한다면??
// 에러 무시하고 그냥 적어두자.
//getEgg쪽 setTimeout부분 reject로 수정했어.
const getHen = () =>
  new Promise((resolve, reject) => {
      setTimeout(() => resolve('닭'), 1000);
  });
const getEgg = hen =>
  new Promise((resolve, reject) => {
      setTimeout(() => reject(new Error(`error! ${hen} => 달걀`)), 1000);
  });
const cook = egg =>
  new Promise((resolve, reject) => {
      setTimeout(() => resolve(`${egg} => 후라이`), 1000);
  });

/*
    이런경우엔
      getHen() //
    .then(getEgg)
    .then(cook)
    .then(console.log);
    에서 어떠한 에러 핸들링도 하지 않았기에 
    Uncaught 에러가 발생할거야.
    그러니 제일 마지막에 catch작성해줘.

    그럼 달걀을 받아오는 부분인 .then(getEgg)에서 에러가 발생 했지만
    이 에러가 제일 밑 catch로 전달되면서
    Error: eorror! 닭 => 달걀 at promise.js:줄위치
    이런식으로 catch가 잡혀지는걸 볼수있어.
*/
getHen() //
.then(getEgg)
//우리가 준비한 다른 재료로 교체를 하고싶을시 에러를 잘 핸들링 하고싶을시
.catch(error => {
    return'빵'; 
}); //계란을 받아오는것에 문제가 생겨도 전체적은 프로미스 체인은 문제가 발생하지 않도록 빵꾸 처리를 해주는것.
//.then(cook)
//.then(console.log);
//.catch(console.log);
//문제 바로 다음에 catch 작성해서 해도돼. 그럼 바로바로 문제처리 가능해.


//이제 callback에서 했던 콜백지옥 해결해보자
//콜백지옥 예제! Callback Hell example.
class UserStorage { 
    loginUser(id, password){//얘는 더이상 콜백함수 전달받을 필요없어.
          return new Promise((resolve, reject) =>{
            setTimeout(() => {
                if(
                    (id === 'ellie' && password === 'dream') ||
                    (id === 'coder' && password === 'academy')
                ) {
                    resolve(id);
                } else {
                  reject(new Error('not found'));
                }
            }, 2000);
          });
        
    }

    
    getRoles(user){
        return new Promise((resolve, reject) => {
            setTimeout(() => { 
                if(user === 'ellie') {
                    resolve({ name: 'ellie', role: 'admin' });
                } else {
                    reject(new Error('no access'));
                }
            });
        });
    }
}


const userStorage = new UserStorage();
const id = prompt('enter tour id');
const password = prompt('enter your passrod');
userStorage.loginUser(id, password)
.then(userStorage.getRoles)
.then(user => alert(`Hello ${user.name}, you have a ${suer.role} role`));
//.catch(console.log); << catch 부분 추가 공부하자.
