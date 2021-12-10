// 자료구조중 하나인 배열에 대해 알아보자! array!
/*
  토끼와 당근이 있다고 하자.. 토끼와 당근이 너무 많다면
  우리가 일상생활에선 바구니 같은걸 이용해서
  토끼는 토끼끼리 당근은 당근끼리 비슷한 종류의 물건을 
  담아놓을것이다.

  비슷한 종류의 데이터를 묶어서 한데다 보관해놓는것!
  이런걸 '자료구조' 라고 한다.

  자료구조에는 어떤 방식으로 어떤형식으로 data를 담느냐에 따라
  굉장히 다양한 타이틀이 있다.

  근데 비슷한 형태의 data를 묶어놓는건 object 라고 했지?
  object와 자료구조의 차이점은 뭘까?

  object는 여기에서 토끼와 또는 당근이 될수있다.
  이런 토끼와 당근 object는 각각의 특징들이 있다.
  
  토끼는 동물이며 귀 두개인 프로펄티가 있을수 있고, 
  먹는다, 뛴다 라는 함수들..메소드가 들어있을수있다.

  당근은 이런 프로펄티만 있을수 있다.
  채소고..주황색이고 비타민c가있고..
  하지만 당근 자체로는 어떠한 행동을 할수없기때문에
  메소드가 없을수도 있다.

  이렇게 object는 서로 연관된 특징과 
  또는 행동들을 묶어놓는것을 말한다.

  여기에서!!! 이런 토끼와 당근들 
  토끼면 토끼끼리 당근이면 당근끼리..
  비슷한 타입의 object들을 묶어놓는것을 '자료구조'라고한다.

  보통 다른 언어에선 이런 자료구조에는 동일한
  타입의 object를 담을수만있다.
  이렇게 타입이 있는 언어에서는 동일한 타입의
  data만 담을수가 있다.

  하지만 JavaScript는 dynamically typed language지?!

  타입이 동적으로 정의가 되어.. 그래서 이러한 타입이
  없기때문에.. 토끼 당근 이런걸 한 바구니에 담을수있어..
  한 바구니 안에 다양한 종류의 data를 담을수있다는거야.
  물론 가능은 하지만 이런식으로 프로그래밍하는건 좋지않아.

  나중에 공부를 더 해야하는 부분이 자료구조와 알고리즘이야.
  이렇게 물건들을 한데 담아놓은 자료구조들 중에서도
  새로운 데이터를 자료구조에 삽입할때 얼마나 효율적으로
  삽입할수있는지.. 삭제할때도 검색할때도 정렬할때도
  어떤 알고리즘을 써서 정렬을 할수 있는지 이런
  효율성을 같이 공부해주면 너무너무 좋다.
  이런것들이 나중에 programmer's나 인터뷰 문제에서도
  종종 등장해.

  나중에 어떤 문제를 해결하냐에 따라서
  많은 자료구조들 중에 어떤자료구조를 선택하는지 
  그 선택할때 검색과 삽입삭제정렬 이런 속도들을 고려해서
  선택해서 잘 사용하는게 정말 중요해.
*/

/*  즉, 배열이란?
   배열은 ㅁㅁㅁㅁㅁ 이렇게 칸칸이 촘촘이 모여있는
   자료구조를 말한다.

   그리고 포인트는 여기에 인덱스가 지정이 되어져 있다.
   위는 0 1 2 3 4 이다. 0부터 센다.
   그리고 배열의 사이즈는 5개다.
   텅텅 비어진 박스가 5개가 있고 이 박스들은 서로 모여있고
   박스에 인덱스 번호가 매겨져 있다.
   저 안에 위에서 말했던 토끼들을 담고 당근들을 담는거다.

   배열의 포인트는 인덱스라고 했지?
   2번째있는 토끼랑 3번째 있는 당근을 삭제하고 싶다면
   바로 인덱스로 접근이 가능하기에 쑥 빼버리면 삭제가 가능해.
   그래서 삽입과 삭제가 너무너무 편해.
*/
'use strict';

// Array!

// 1. Declaration 배열을 어떻게 만들고 어떻게 선언하냐?!

//이렇게 new라는 키워드를 이용해서 오브젝트를 만드는것처럼 하면 배열을 만들수있고
const arr1 = new Array(); 
const arr2 = [1, 2]; //이게더 흔하게쓰이는데 []이용해 데이터를 넣어 배열만들수있어.

// 2. Index position 인덱스를 통해 어떻게 배열에 접근하죠?!
const fruits = ['사과', '바나나'];
console.log(fruits);
console.log(fruits.length);
console.log(fruits[0]);//[]안에 해당 인덱스 넣어 여긴 사과
console.log(fruits[1]);// 바나나
console.log(fruits[3]);// undefined 
//그래서 배열의 첫번째 찾을땐0, 마지막 찾을땐 랭쓰-1을쓴다.
console.log(fruits.length - 1); //배열의 마지막! 바나나

console.clear();//이전의 log들 다 지우기
// 3. Looping over an array, 배열안의 전체적인 데이터를 빙글빙글 돌며 출력해보자.
// print all truits
// a. for
for (let i = 0; i < fruits.length; i++) {
    console.log(fruits[i]);
}

// b. for of
//fruit이라는 변수에 fruits안의 데이터를 한번씩 순차적으로 할당하며 블럭을 시행
for(let fruit of fruits) {
    console.log(fruits);
}

// c. forEach, 얘는 (callbackfn)콜백함수를 받아옴
// 우리가 전달한 이 함수를 벨류 하나하나 마다 호출해주는구나~
// 콜백함수엔 총 세가지의 인자가 들어오는구나~
// value index 그리고 전체적인 배열..
//윈도우 컨트롤, 맥은 커맨드를 누르고 forEach클릭해서 확인해
fruits.forEach(function (fruit, index, array) { //얘는 ()안에 펑션을 전달할수있음
    console.log(fruit, index, array);//출력하고싶은거 ()안에표시 fruit만이면 이거만 적으면 돼.
});//forEach에서 보통은 array안받아와 그러니 적은 두개다 지워도돼.
// 그리고 위에껀 이름없는 에로우 펑션이니까..펑션과 괄호 생략해서
// fruits.forEach((fruit, index) => console.log(fruit, index)); 해줘도돼.
// index도 출력하기 싫으면 지워~
// 즉, forEach는 배열안에 들어있는 value들 마다 내가 전달한 함수들을 출력!

// 4. Addtion, deletion, copy 배열에 넣고,빼고,복사
// AP는...push: add an item to the end, 어떤 value들을 배열의 가장끝에 두고싶다!
fruits.push('딸기', '복숭아'); //두개 더 추가해보자.
console.log(fruits);//그럼 네개가 출력돼.["사과", "바나나", "딸기", "복숭아"]

// pop: remove an item from the end, 배열의 제일 뒤에서부터 아이템을 지우고싶다!
fruits.pop(); //제일 뒤에있던 복숭아를 하나 지워줘.
//fruits.pop();하나를더빼려면 한번더이렇게써줘 그럼딸기도지워져.
console.log(fruits);//사과,바나나,딸기만 출력돼.

// unshift: add an item to the benigging,앞에서 아이템 넣기
fruits.unshift('딸기', '레몬');//앞에 이놈들 추가돼.
console.log(fruits);//["딸기", "레몬", "사과", "바나나", "딸기"] 출력돼.

// shift: remove an item from the benigging,앞에서 아이템 빼기
fruits.shift();//제일 앞에놈인 딸기 빼줘. 한번더 해주면 레몬 지워져.
console.log(fruits);//["레몬", "사과", "바나나", "딸기"]

// note!! 
/*
    shift와 unshift는 pop과 push보다 정말정말 너무 느리다!

    배열에 아이템들이 들어있을때 뒤에서부터 넣고 빼는것은
    빈 공간에 데이터를 넣었다 지웠다 하기때문에
    기존에 들어있는 데이터들은 움직이지 않아도 되어서
    한 공간에 인덱스를 이용해 넣고빼고가 가능하기에
    정말 빠른기능 빠른 오퍼레이션을 진행할수있다.

    반대로
    앞에서 데이터를 넣게 되려면.. 2개짜리에 1개를 추가하는거로 예를들면
    두번째데이터를 먼저 세번째로 옮겨와서 넣고 그다음
    첫번째데이터를 두번째로 옮겨와서 넣고 텅텅비게 만든후
    새로운 데이터를 거기에 집어넣어야해.

    데이터를 삭제할때는 첫번째있는 아이템을 지우고
    두번째를 첫번째로 옮기고.. 세번째를 두번째로옮겨.

    그래서 배열의 길이가 길면 길수록
    쉬프하다 당겨오다 움직이다 이런일들을 반복해야하기에
    느려!
*/

// splice: remove an item by index position,아이템을 지정된 포지션에서 지우는법!
fruits.push('딸기', '복숭아', '레몬');//참고로 이미지써도 문자열임.
console.log(fruits);//["레몬", "사과", "바나나", "딸기", "딸기", "복숭아", "레몬"] 출력
fruits.splice(1);//(이거 포함해서 어디서부터지울지 시작하는 인덱스번호, 몇개나지울건지(이건지정해도되고 안해도 돼.))
//fruits.splice(1, 1);이면 사과 하나만 지워져.
console.log(fruits);//0부터 시작하는데 위에서 1부터지웠으니 사과부터 다지워짐. 레몬만 출력됨.

/*
    fruits.splice(1, 1, '멜론', '수박');
    console.log(fruits);

    위처럼 하면 첫번째인 사과가 지워지고
    지워진 자리에 멜론과 수박이 쏙 들어가게 돼. 
    그러면서 앞에껀 그대로고 원래껀 뒤로 밀려.

    ["레몬", "멜론", "수박", "바나나", "딸기", "딸기", "복숭아", "레몬"]
    출력돼.
*/

// combine two arrays,두가지의 배열을 묶어만들기!
const fruits2 = ['배', '코코넛'];//기존에있던 fruits 배열에 concat!
const newFruits = fruits.concat(fruits2);//이럼 새로묶여진 배열이 합해져서 리턴돼.
console.log(newFruits); //위에너무 기니까 fruits에 사과,바나나만 있다고가정하고..
//합해져서 ["사과", "바나나", "배", "코코넛"] 이렇게 네개가 출력돼.
//fruits2가 fruits의 뒤쪽에 붙네..즉,
//concat을 호출하는배열 + 새로전달된배열 이렇게 되는거네.

// 5. Searching, 검사..검색할수있는 API
// find the index
// 배열안에 어떤값이 몇번째 인덱스에 있는지 알고싶을때 유용해.
console.clear();
console.log(fruits);
console.log(fruits.indexOf('사과')); //indexOf: 사과가 몇번째에 있는지 알려줘.0부터세!
console.log(fruits.includes('수박'));//includes: 배열에 수박이 있는지 없는지 true나 false로 리턴하는 함수야.
console.log(fruits.indexOf('사람'));//얘는 없는값 출력하면 -1이 출력돼.

// lastIndexOf
console.clear();
/*
    만약 똑같은 사과가 0번째와 4번째에 들어있다면?
    그때
    console.log(fruits.indexOf('사과'));
    를 해주면 0번째가 나온다. 즉, indexOf는
    제일 첫번째로 해당하는 값을 만나면 그 값이
    들어있는 index를 return하게 돼.

    반대로
    lastIndexOf는 제일 마지막에 들어있는 값의 index를 출력해.
    console.log(fruits.lastIndexOf('사과'));
    해주면 4 가 출력돼.
*/