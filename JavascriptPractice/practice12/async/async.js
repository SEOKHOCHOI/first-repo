// async, await
// clear style of using promise: 깔끔하게 promise를 사용할수있는 방법.
// 그렇다고 무조건 promise가 나쁘고, 
// async와 await으로 대체해서 사용해야 된다는 말이 아냐.
// promise를 유지해서 써야지 맞는 경우가 있고,
// async와 await으로 변환해야지 조금 더 깔끔해지는 경우가 있어.
// 이런 차이점은 계속 프로젝트를 하며 감을 찾아보자.

/*
    비동기의 하이라이트! 핵심! 꽃! async, await

    async와 await은
    promise를 조금더 간결하고 간편하고, 조금 더
    동기적으로 실행되는것처럼 보이게 만들어주는 아이야.

    practice11에서 promise를 여러가지 체이닝을 할수있다고 말했지?
    promise then 다른 promise then 이런식으로..
    체이닝을 계속해서 하게되면 코드가 좀 난잡해진다.

    이런거 위에 조금 더 간편한 API로 async와 await을 사용하면
    우리가 그냥 동기식으로 코드를 순서대로 작성하는 것처럼
    간편하게 작성할수있게 도와준다.

    async와 await은 새로운것이 추가된게 아니라
    기존에 존재하는 promise위에 조금 더 간편한 API를 제공하는데
    이렇게 기존에 존재하는 거 위에 또는
    기존에 존재하는것을 감싸서
    우리가 조금 더 간편하게 쓸 수 있는 API를 제공하는 것을
    syntactic sugar 이라고 한다.

    한 가지 더 좋은 예로는 클래스가 있었다.
    스크립트에서 class는 전혀 새로운것이 아니라
    프로토타입을 베이스로한 그 위에 살짝 덧붙여진
    그럴싸하게 보이는 syntactic sugar야.
*/

// 1. async 어떻게 쓸까?
//function fetchUser() {
    /* 사용자의 데이터를 백엔드에서 받아오는 함수.
       do network reqeust in 10 secs....
       네트워크 통신을 해서 백엔드에서 데이터를 받아오는데
       한 10초 정도 걸리는 코드가 있다고 가정해보자.
       없지만 있다고 가정해보는것~*/

  //     return 'ellie';//10초가 지나면 우리가 받아온 사용자의 이름을 리턴
    
//}
//const user = fetchUser();
//console.log(user);
/*
    콘솔로그에 이렇게 출력을 하게 되면..
    이렇게 무언가 오래걸리는 코드를 비동기적인 처리를
    전혀 하지 않으면 JS엔진은 동기적으로 코드를 수행하기 때문에
    즉, 한 줄 한줄씩 한줄이 끝나야지 그 다음줄로 넘어가는
    동기적인 처리를 하기때문에.. 어? fetchUser가
    호출이 되었네?? 함수가 선언된 곳으로(function쪽) 가서
    이 함수의 코드 블럭을 실행 하겠지?
    그래서 얘가 한줄이 수행이 되면서 10초가 걸리니까
    이게 끝날때까지 10초동안 여기에 머무르고 있다가
    10초가 지나서 성공적으로 네트워크 데이터를 
    받아오게 되면 그제서야 다음 줄로 넘어가면서 
    ellie가 return이 돼.
    그리고 이 return된 코드가 const user에 할당이 되고
    그 다음 라인으로 이제 넘어가서 ellie가 출력된다.

    우리가 여기서 비동기적인 처리를 전혀 하지 않으면
    사용자의 데이터를 받아오는데 10초가 걸리기 때문에 
    만약 이 뒤에서 웹페이지의 UI를 표시하는 그런 기능을
    수행하는 코드들이 있다면 이것이 끝나는 동안
    데이터가 웹페이지에 표시되지 않기 때문에 
    사용자는 10초정도 텅텅비어있는 웹페이지만 보게될거야.

    이렇게 오래걸리는 일들은 비 동기적으로 처리할 수 있게
    해줘야 하는데 practice11에선 이것을 promise로
    펑션안에 return new Promise()이렇게 만들었었다. 
    야 내가 언제 유저의 데이터를 받아올진 모르겠지만 
    내가 약속할게 이 promise라는 오브젝트를 가지고 있으면
    여기에 너가 대인 이라는 콜백함수만 등록해놓으면
    유저의 데이터가 준비되는대로 니가 등록한 콜백함수를
    내가 불러줄게~ 이렇게 약속하는 거였다.
    
    return new Promise((resolve, reject) => {
        return 'ellie';
    });
    이 코드 블럭 안에있는 것들이 비동기적으로 수행이 됐었다.
    resolve와 reject를 호출하지 않고 그냥 return을
    하게되면 promise가 팬딩상태가 되어있는것을 볼수있다.

    promise에는 상태가  펜딩이거나 완료되었거나 실패한 이런상태가
    있었는데 지금 바로 위처럼 적어도 아무것도 
    호출하지 않았기 때문에 게속 팬딩된 상태로 남아있어.
    결과값도 아무것도 없을거야.

    그래서 꼭 promise안에는 resolve나 reject를
    이용해서 완료를 해줘야해.
    그래서 return을 resolve('ellie'); 로 바꿔줘.
    이렇게 바꾸게 되면 이제 promise가 
    풀필로 바뀌게 되면서 이제 결과는 ellie로 변화됐어.

    그래서 fetchUser라는 것은 결국은 promise를 
    return하기 때문에, 우리가 then이라는 콜백함수를 이용해서
    user.then(console.log); 이렇게 하면된다.

    위처럼 promise를 이용하는게 아니어도 조금 더 
    간편하게 비동기를 작성할 수 있는 방법은?
    
    바로 함수앞에 aysnc라는 키워드를 붙이는거다.

    그래서 위처럼 번거롭게 promise를 쓰지 않아도
    자동적으로  함수 안에 있는 코드 블럭들이
    promise로 변환이 되어져.
    이럼 fetchUser가 promise를 return해.

*/
// 이렇게 하라는 말이야.
async function fetchUser() {
    return 'ellie';
}
const user = fetchUser();
user.then(console.log);
console.log(user);

/*
    다시말해 async라는 키워드를 함수앞에쓰면 
    코드블럭{}이 자동으로 promise로 바뀐다!!!!!
*/

// 2. await 기다려! 

/*
    await이라는 키워드는 async가 붙은
    함수 안에서만 쓸 수가 있는데,

    첫번째 delay라는 함수는 promise를 return하는데
    정해진 ms(밀리세컨드)가 지나면 resolve를 호출하는
    그런 promise를 return하게 돼.

    그래서 getApple에는 3초를 전달했기 때문에
    3초가 지나면 resolve를 호출하는 그런 promise가 전달이 되겠지?
    자 여기서!! await 이라는 키워드를 await dely() 여따가
    쓰게되면 delay(3000)가 끝날때까지 기다려줘!!
    그래서 3초가 지난후에 사과를 return하는 
    promise가 만들어지겠지??? async라는 키워드가 함수앞에 붙었으니까?

    그리고 getBanana는 다시 async로 promise를 만드는 함수인데
    얘도 3초있다가 바나나를 return하는 함수야.
    이걸 굳이 promise를 쓰는 함수로 만들어 보자면
    function getBanana() { 여기안에선 프로미스를 리턴할거야.
        return delay(3000)   //3초가 된다음에..
        .then(() => '바나나' )//어떤 값을 받아오는지 상관없고 결국에는 바나나를 리턴하는 함수.
    }
    이렇게 체이닝을 하는것보다 밑에처럼..
    동기적인 코드를 쓰는것처럼 async를 써서 만들게되면
    아 딜레이가 끝날때까지 기다렸다가 바나나를 리턴한다
    라고 더 쉽게 이해할수가 있겠지?
*/
function delay(ms) {
    return new Promise(resolve => setTimeout(resolve, ms));
}

async function getApple() {
    await delay(3000);
    //throw 'error'; //이러면 에러가 발생하니 밑에서 해결해보자.
    return '사과';
}

async function getBanana() {
    await delay(3000);
    return '바나나';
}

//위의 모든 과일흘 한번에 다 따오는 함수를 만들자.
/*
    기존의 프로미스 체인을 이용하게되면
    function pickFruits() {
        return getApple()
        .then(apple //사과가 받아와지면 이걸이용해서 => {
           return getBanana()  //바나나를 받아오겠지? 그리고 바나나가 되면 그러면 이제 이걸 리턴하고
           .then(banana => `${apple} + ${banana}`); //애플과 바나나를 동시에 묶어주는애를 리턴할것이다.
        });
    }
    pickFruits().then(console.log); //이걸 최종적으로 부를대는 pickFruits불러 
                        // 다받아와지면 .then(console.log)에 출력
    그럼 이제 6초정도 기다려야 되겠지? 그럼 사과 + 바나나 이렇게 출력돼!

    이걸 보니까 콜백지옥이 떠오르지 않아???

    이렇게 promise도 너무너무 중첩적으로 체이닝을 하게되면
    콜백지옥과 비슷한 문제점이 발생해.

    그래서 이제 밑에는 async라는 키워드를 이용해보자.
    너무 간단한걸 알거야.

    try, catch로 에러처리하는것도봐!
*/
async function pickFruits() {
  // try {
    const apple = await getApple();
    const banana = await getBanana();
  // } catch() {
//}
    return `${apple} + ${banana}`;
}

pickFruits().then(console.log);

//위에서 한가지 문제점이 있다!
// 4. await 병렬 처리
/*
    위에서 사과를 받는데에 몇초가 걸리고
    바나나를 받는데에 몇초가 걸린다.

    그 말은 pickFruits에서
    사과를 받는데 기다려 했으니 몇초가 지나고
    getBanana가 호출이 되며 또 몇초가 소요된다.

    이렇게 순차적으로 진행하게 되면 비효율적이다
    바나나와 사과를 받아오는데에는 서로 연관이
    되어있지 않기때문에 서로 기다릴필요가 전혀 없다.

    여기에서 이것을 개선하려면 
    첫번째로 applePromise를 만들고..
    이렇게 바로 만들면 promise를 만드는 순간 바로
    promise 안에 들어있는 코드 블럭이 시행된다.

    그리고 또 bananaPromise를 만들고.. 그럼 promise가 시행이돼.
    그래서 이것을 awiat getApple에서 getApple을
    applePromise;로 바꾸고 banana도 bananaPromise로
    바꿔줘 그다음 여기서 동기화를 시켜주는거야.

    이렇게 시행하게되면 한번에 병렬적으로 실행돼!

    즉,
    async function pickFruits() {
        const applePromise = getApple();
        const bananaPromise = getBanana();
        const apple = await applePromise;
        const banana = await bananaPromise;
        return `${apple} + ${banana}`;
    }
    pickFruits().then(console.log);

    이렇게 바꿔주면돼.

    근데 위처럼 동시다발적으로 수행이 가능한 경우에..
    즉, 바나나를 다운받는데 사과가 필요없고 반대도 마찬가지인 경우
    병렬적으로 기능을 수행할수있는 경우에는..

    Promise에서 제공하는 유용한 API사용하면 돼.
    저렇게 더럽게 안하고..

    promise에 있는 all 이라는 API를 쓰면 돼!
    이것은 promise 배열을 전달하게 되면 
    모든 프로미스들이 병렬적으로 다 받을때까지
    모아주는 아이다.

    배열을 스트링으로 묶을수있는건 join 이다.

    Promise에 잇는 race 라는 API는
    배열에 전달된 프로미스 중에서 
    가장 먼저 값을 리턴하는 아이만 전달이 되어진다.
*/

// 5. useful Promise APIs
function pickAllFruits() {
    return Promise.all([getApple(), getBanana()])//배열 전달하게 되고 다 받아지면
    .then(fruits => fruits.join(' + '))//이렇게 다 받아진 배열이 다시 전달이돼.
}
pickAllFruits().then(console.log);  // 사과 + 바나나 출력돼.

// 어떤 것이든 상관없이 먼저 따지는 첫 번째 과일만 받아오는건?
// 그냥 위랑 상관없이 사과따는데2초 바난 따는데 1초 걸린다 가정해보자.
function pickOnlyOne() {
    return Promise.race([getApple(), getBanana()]);
}
pickOnlyOne().then(console.log); // 바나나 출력된다.