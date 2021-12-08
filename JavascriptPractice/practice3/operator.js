// 1. String concatenation
console.log('my' + ' cat'); //새로운 문자열 만들기
console.log('1' + 2); // 문자열 + 숫자 = 문자열 + 문자열로 돼.
console.log(`string literals: 1 + 2 = ${1 + 2}`);// 변수값을 계산해서 스트링으로 포함해서 문자열을 만들게 돼.
console.log(`string literals: 

''''

1 + 2 = ${1 + 2}`);//이렇게 줄바꿈 하거나 중간에 문자를 넣어도
//그대로 문자열로 변환돼서 나와!

// 2. Numeric operators
console.log("ellie's \nbook");//줄바꿈은 \n, \t는 탭키
console.log('ellie\'s \nbook');//전부 ' 사용할거면 출력할거엔 \ 사용해줘
console.log(1 + 1);
console.log(1 - 1);
console.log(1 / 1);
console.log(1 * 1);
console.log(5 % 2); // reminder
console.log(2 ** 3);//exponentiation, 2의 3승

// 3. Increment and decrement operators
let counter = 2;
const preIncrement = ++counter;// counter = counter + 1;과 동일
                               // preIncrement = counter;
// counter++였으면 먼저 변수의 값인 2를 preIncrement에 할당한 후에
// counter을 3으로 올려주는것.  --는 빼주는거고 방법은 같아.

// 4. Assignment operators 할당하는 오퍼레이털즈
let x = 3;
let y = 6;
x += y; // x = x + y; 와 같은 뜻 -, *, /도 전부 마찬가지.

// 5. Comparison operators 비교하는 오퍼레이털즈
console.log(10 < 6);  // less than
console.log(10 <= 6); // less than or equal
console.log(10 > 6);  // greater than
console.log(10 >= 6); // greater than or equal

// 6. Logical operators; 
//    ||(or),  &&(and),  !(not)
const value1 = true;
const value2 = 4 < 2;

// ||(or), finds the first truthy value
/*
  얘는 처음으로 true가 나오면 거기서 멈춰.
  왜냐? 하나라도 true면 true기 때문에!
  그래서 애초에 value1이 true라서 체크함수의
  console.log의 악 이 출력이 안되는거야!
  그래서 연산을 많이하는 함수를 호출하거나 할때
  이런놈들을 제일 앞에두지 말고
  value1처럼 심플한 애들을 제일 앞에두고 복잡한건
  제일 뒤쪽으로 배치하는게 효율적인 코드 작성이야.
*/
console.log(`or: ${valure1 || value2 || check()}`);

function check() {
    for(let i = 0; i < 10; i++) {
        //wasting time
        console.log('악');
    }
    return true;
}// check라는 함수는 결국은 true 리턴하는 상태.

/* and 다 트루여야 트루야! 얘는 먼저 펄스가 나오면 어차피 펄스니
 실행이 안돼! 그래서 얘는 간편하게 null 체크같은걸 할때도
 많이 쓰여 오브젝트가 null이면 펄스가 되기때문에 
 뒤가 실행이 안되니 널 오브젝트가 널이 아닐때만 
 오브젝트의 썸띵이란 코드를 받아오게돼.
 */
if (nullableObject != null) {
    nullableObject.something;
} // 이런 뜻이야.

// !(not) 은 값을 반대로 바꿔줘.
console.log(!value1);  //즉, false 출력.

// 7. Equality
const stringFive = '5';
const numberFive = 5;

// ==는 loose equality, with type conversion
// 즉, 타입을 변경해서 검사를 한다! 스트링타입=넘버타입 이 되는거.
console.log(stringFive == numberFive);  // true
console.log(stringFive !== numberFive); // false

// === 는 strict equality, no type conversion
// 얘는 타입을 바꿔주지 않아 타입이 다르면 다른애들이야!
// 그래서 코딩할때는 ===을 사용해서 검사하는게 좋아.
console.log(stringFive == numberFive);  // false
console.log(stringFive !== numberFive); // true

// object equality by reference
/*
   오브젝트는 메모리에 탑재될때 레퍼런스 형태로 저장됨.
   ellie1과 2는 똑같은 데이터가 들어있는 오브젝트지만
   실제로 메모리에는 1과 2에는 각각 다른 레퍼런스가 들어있고
   그 다른 레퍼런스는 서로다른 오브젝트를 가리키고 있다.
   그리고 ellie3은 ellie1의 레퍼런스가 할당되어 있으니
   똑같은 레퍼런스를 가지고 있게 되는것.
*/
const ellie1 = { name: 'ellie'};
const ellie2 = { name: 'ellie'};
const ellie3 = ellie1;
console.log(ellie1 == ellie2);  // false 레퍼런스가 다르니
console.log(ellie1 === ellie2); // flase 같은 타입이던 아니던 레퍼런스값이 다르니까
console.log(ellie1 === ellie3); // true ellie1이 가지고 있는 레퍼런스 벨류를 ellie3으로
//할당했기 때문에 1과 3은 똑같은 레퍼런스를 가지고있으니까!

// equality - puzzler
//0,null,undefined,mt스트링???은 다 false로 간주됨.
console.log(0 == false);       // true
console.log(0 === false);      // false, 0이 불리언 타입이 아니기 때문에!
console.log('' == false);      // true
console.log('' === false);     // false, 빈문자열은 불리언 타입이 아니기 때문에!
console.log(null == undefined);// true
console.log(null === undefined);  // false, 둘은 타입은 다르니까!


// 8. Conditional operators: if
// if, else if, else
const name = 'ellie';
if(name === 'ellie') {
  console.log('Welcome, Ellie!');
} else if (name === 'coder') {
    console.log('You are amazing coder');
} else {
    console.log('unkwnon');
}

// 9. Ternary operator: ?   , if를 좀 더 간단히 사용가능.
// condition ? value1 : value2;
console.log(name === 'ellie' ? 'yes' : 'no'); //여기선 no
// ?의 좌측 ===가 true면 : 의 좌측실행 false면 우측실행.ㅓ
// 값을 할당하거나 간단히 출력할때 이걸 사용.
// 간단할때만 쓰고 복잡하면 이프나 스위치 사용.

// 10. Switch statement
// use for multiple if checks
// use for enum-like value check
// use for multiple type checks in TS
const browser = 'IE';
switch (browser) {
    case 'IE':
        console.log('go away!');
        break;
    case 'Chrome':
        console.log('love you!');
        break;
    case 'Firefox':
        console.log('love you!');
        break
// Chrome과 Firefox처럼 같은 메시지를 출력한다면 반복할 필요없이
/*
    case 'Chrome':
    case 'Firefox':
        console.log('love you!');
        break;
    이렇게 케이스를 묶어서 해주면 자동적으로 연달아 출력돼.
*/
    default:
        console.log('same all!');
        break;
}
//나중에 타입스크립트에서 정해져 있는 타입을 검사하거나
//이넘? 비슷한 아이들을 검사할땐 스위치를 쓰는게 가독성좋아.

// 11. Loops
// while loop, while the condition is truthy,
// body code is exeuted.
let i = 3;
while (i > 0) { //false 나오기 전까진 무한대로 반복!
    console.log(`while: ${i}`);
    i--;
} //결국 최정적으로 while: 1까지 출력되고 i는 0이 되는것.

// do while loop, body code is executed first,
// then check the condition.
do { //먼저 블럭 실행 후
    console.log(`do while: ${i}`);
    i--;
}while (i > 0); // 조건이 맞는지 검사
//그냥 while에서 i가 0이 됐음에도 
//do while: 0 이 출력이 되고 나서 while검사 후 멈추게 되는것.

// for loop, for(begin; condition; step)
//begin은 처음 딱 한 번만 실행됨.
for (i = 3; i > 0; i--) { //기존 존재하는 변수에 값 할당한 경우.
    console.log(`for: ${i}`);
}

for (let i = 3; i > 0; i = i - 2) {
    // inline variable declaration 블럭안에서 지역변수 선언해서 작성한것
    console.log(`inline variable for: ${i}`);
}

// nested loops
// i가 0일때 j를 0~9까지 돌리고
// i가 1일때 다시 j를 0~9까지 돌린다. 이걸 반복.
//근데 이렇게 네스팅해서 작성하게 되면
//O(n^2)이렇게 작성하는건 cpu에 안좋아서 피하는게 좋아.
for (let i = 0; i < 10; i++) {
    for (let j = 0; j < 10; j++) {
        console.log(`i: ${i}, j:${j}`);
    }
}

// break(루프완전끝), continue(지금껏만 스킵하고 다음으로 넘어가기) 퀴즈!! 루프안에서 얘네를써 루프를 끝낼수가 있는데..
// 01. 숫자를 0~10까지 짝수인 아이들만 print하는것을 continue이용해서 만들기

for(let i=0; i<11; i++){
    if(i % 2 !== 0){
        continue;
    }
    console.log(i);
}

// 02. 주어진 숫자의 범위 0~10까지 루핑하는걸 작성하고 숫자8보다 크면 멈추게하자.
for (let i = 0; i < 11; i++){
    if (i > 8) {
        break;
    }
    console.log(`i, ${i}`);
}