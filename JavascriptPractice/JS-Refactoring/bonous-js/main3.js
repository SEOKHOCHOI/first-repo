// 연산자 보충

/*
    if문은 무언가가 true이면 실행, 아니면 실행X
    if(true) {
    console.log('true!');
}   실행

    if(false) {
    console.log('false!');
}   실행X

    if(false) {
    console.log('true!');
}   else {
    console.log('aslse!');  실행!
}

어떤 불리언 타입도 true가 될수있고 false가 될수있다.

숫자 0은 false다. 즉,
false: 0, -0, ''(텅빈 문자열), null(값이 없기때문에..), undefined

true: -1, 'false'(값이든 문자열), 텅빈 배열

프로그래밍 인어에서 데이터가 없거나 비어있는 애들은 false.
MDN 사이트 보면 잘 설명돼있어~
텅빈 배열은 오브젝트 자체이기 때문에 true야.
*/

/*
    num이라는 변수를 선언하고 값을 할당하지 않는다면?
    false 출력!

    let num;
    if(num) {
        console.log('true');
    } else {
        console.log('false');
    }

    num이라는것을 값을 선언하고 할당하지 않는다면
    여기에는 undefined이 할당되어져 있고 이건 false지?

    그래서 우리가 이것을 어떻게 할 수 있냐면?
    num이 트루이면 즉, num에 데이터가 있다면 num을 출력할거야라고
    num && console.log(num); 이렇게 작성가능해.
    &&의 and 연산자는 앞에가 true가 되어야지
    뒤가 실행이 돼.

    let num = 9;
    if(num) {
        console.log('true');
    }
    num && console.log(num);
    이제 넘이 데이터가 있으니까 넘이 true가 되니까
    뒤가 실행이 되어 9가 출력돼.
    
    그래서 and 연산자를 쓰는것은 if와 동일해!
    근데 한줄에 깔끔하게 되니 쓰는거야!

*/