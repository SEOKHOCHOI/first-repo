// Objects
// one of the JavaScript's data types.
// a collection of related data and/or functionality.
// Nearly all objects in JavaScript are instances of Object

/*
  const name = 'ellie'; //변수 하나당 값을 하나만 담을수있음
  const age = 4; // 얘네를 출력하고 싶은 함수를 만든다면
  print(name, age); //이름과 나이를 각각 파라미터로 전달해줘야해.
  function print(name, age) { //그 후 함수를 정의해 쓸때도 두가지의 파라미터를 받아올수있도록 만들어야돼.
      console.log(name);
      console.log(age);
*/
//}//이렇게 하게되면 문제가 주소나,풀네임이나 라스트네임 이렇게 조금더
//인자가 많아지면 추가해야되는게 굉장히 많아져..
//이러면 관리하기도 힘들고 로지컬하게 그룹으로 묶어서 생각할수없어.

// 그래서 위의 상황을 개선하고자 object를 쓰는거야!
// const ellie = { name: 'ellie', age: 4 }; //이렇게 하면 오브젝트로 관리하면 되니까 
// 더이상 위 function print(name, age)처럼 name과 age를 받을수없고
// function print(person) { //이렇게 person이라는 데이터를 받아서
  //  console.log(person.name);
  //  console.log(person.age); //이렇게 해주면 돼.
//} // 전달, 호출할때도 ellie만 절달하면 되니까 간편하게 데이터관리가능해
// 즉,

// 1. Literals and properties
const obj1 = {}; //오브젝트를 만드는방법1 퀄리 브라켓이용
const obj2 = new Object(); //클래스이용.. 이렇게 뉴라는 키워드 중에서
//클래스 템플릿을 이용해서 이렇게 오브젝트를 만들수있음.
//obj1처럼 {}를 이용해서 만드는것을 object literal syntax 이라고하고
//ojb2처럼 new키워드 이용해서 만드는것을 object constructor syntax문법이라고해

function print(person) {
    console.log(person.name);
    console.log(person.age);
}
// js에선 바로 밑처럼 클래스가 없어도 {}이용해 바로 오브젝트를 생성할수있음.
const ellie = { name: 'ellie', age: 4 };
print(ellie); // 이런식으로 해주면 돼.

//js는 동적으로 타입이 런타임때 결정되는 언어라 밑에짓도 가능.
ellie.hasJob = true;//뒤늦게 하나의 프로퍼티를 추가할수있어.
console.log(ellie.hasJob);
//그래서 이미name과 age라는 오브젝트를 정의하였음에도 불구하고
// 그 뒤에 우리가 마음이 바뀌면 위에선 name과 age정보만 있음
//충분하다 생각하여 저것만 적었다가도 뒤늦게
//어? 일을 하는지 안하는지도 추가할까? 이렇게 생각해서
//위처럼 다시 ellie.hasJob = true;처럼 추가할수있어.
//이렇게 너무 동적으로 코딩하면 금방금방 하기에는 좋지만
//나중에 유지보수가 굉장히 힘들고 생각지도못한 에러발생할수있어.
//그러니 가능하면 이걸피해서 코딩해.

//심지어 삭제도 가능해..
//엘리의 잡을 마음을바꿔서 프로퍼티를 빼고싶으면
delete ellie.hasJob; // 이렇게 빼주고
console.log(ellie.hasJob); //동일한걸 출력하면
//undefined가 출력돼.

//여기서 중요하게 짚고 넘어가야될 포인트는 바로 오브젝트는
// 키와 벨류의 집합체 라는거야.
// object = { key : value };
// 이 말은 오브젝트는 키 우리가 접근할수있는 변수 프러펄티와
// 그 프로펄티가 가지고있는 값 요 두가지로 나누어진단거야.

//const ellie = { name: 'ellie', age: 4 }; 여기서보면
//총 2가지의 키와 그에 상응하는 value가 들어가있는데
//key는 name value는 ellie 또다른키는age value는 4
//이렇게 각각 들어가있는걸 볼수있어.

// 2. Computed properties, 계산된 프로퍼티즈란 말임.
/*
    우리가 오브젝트 안에 있는 데이터를 접근할때는
    닷 (.) 점을 이용해서 접근을 했는데<1방법>
    다른 방법도 있다.
    []안에 오브젝트 안에 있는 변수의 이름을 스트링형태로
    접근이 가능하다.<2방법>
*/
console.log(ellie.name); // 1방법
console.log(ellie['name']); // 2방법
//주의할점은 []안에는 name이 아니라 스트링타입인
//'name'으로 적어줘야해.
ellie['hasJob'] = true;
console.log(ellie.hasJob);

/*
    위의 방법1, 2의 사용순간
    <1방법> 쓸때는 코딩하는 그 순간 우리가 정말 그 키에
    해당하는 값을 받아오고 싶을때 이걸써서 코딩하고

    <2방법> 쓸때는 우리가 정확하게 어떤 키가 필요한지
    모를때 즉, 런타임에서 결정될때 이걸 사용한다.

    그래서 코딩할때는 그냥 <1방법>을 쓰는게맞아.
    출력하는 경우에도 그냥 닷을 써서 name으로 출력하는
    경우가 맞고 우리가 실시간으로 원하는 키의 값을
    받아오고 싶다면 <2방법>을 쓰면 돼.
*/
// 한 가지 예를들면 printValue라는 함수가 있다고하자 이 함수는
function printValue(obj, key) {//오브젝트와 키를 받아서
    console.log(obj[key]);//오브젝트에 있는 키에 상응하는 value를 출력하는 함수다.
}//그래서 언제 어떤키를 받을지 모르는거야.
/*
    예를들면 이 원하는 키를 사용자에게 인풋을 받아서 
    출력해야 되는 함수라면 printValue(, 요깄는) key는 어떤걸 출력할지
    코딩하는 이 시점에는 우리는 전혀 모른다.
    그래서  console.log(obj.key);라고 하면 이 console코드가
    하고있는것은 오브젝트에 key라는 프로펄티가 들어있니?
    아니 없어~ 가 되니 위처럼 []써서 바꿔줘야돼.
    나중에 동적으로 key의 관련된 value를 받아와야할때
    유용하게 쓸수있어.
*/
printValue(ellie, 'name');//key는 항상 스트링타입.
printValue(ellie, 'gae');

// 3. Property value shorthand
const person1 = { name: 'bob', age: 2 };
const person2 = { name: 'steve', age: 3 };
const person3 = { name: 'dave', age: 4 };
const person4 = makePerson('ellie', 30);
console.log(person4);
//위처럼 person1,2,3 세가지의 오브젝트를 생성해 놓았는데
//네번째 사람을 만들고 싶다면? 
/*
    함수를 만들자! 그럼 위처럼 번거롭게 만들지않고 함수호출로 가능.
    name과 age라는 값을 받아서
    함수안에서 오브젝트를 만들어서 return해주는것!
    그리고 Property value shorthand 기능에 의해
    name: name,
    age: age,
    이렇게가 아닌 왼쪽 key와 오른쪽 value의 이름이 동일하다면
    밑처럼 key를 생략 가능해.
    이렇게만 해도 오브젝트 생성돼.

    여기서 잘 살펴보면 makePerson은 전에 살펴본 class같은 아이야
    그래서 이전에 js에 class가 없을때는 
    이런식으로 많이 작성이 되었어.

    그리고!! 이렇게 다른 계산을 하지않고
    순수하게 오브젝트를 생성하는 함수들은
    보통 우리가 Person처럼 대문자로 시작하도록 함수들을 만들어.
    그리고 밑처럼 return이라는 값을 하지않고
    this.name = name;
    this.age = age; 로 작성해줘.
    즉, makePerson이 아니라
    function Person(name, age) {
        //이부분에서 생략된것은 우리가 새로운
        오브젝트를 만들어서 this={};
        디스에다 네임이라는 새로운 프로펄티를 넣고
        this.name = name;
        this.age = age;
        //결국은 return this; 이렇게 디스를 리턴하는 함수가생략된거야.
    }
    해주면 된다는 말이야.
    이렇게하면 js엔진이 알아서 오브젝트를 생성해줘.
    호출도 당연히 이름바꿨으니
    make~~가 아니라 Person으로 해야겠지?
    그리고 이것을 바로
    4. Constructor Function 이라고해!
*/
function makePerson(name, age) {
    return {
        name,
        age,
    }
}

// 5. in operator: property existence check (key in obj)
// 이건 해당하는 오브젝트안에 key가 있는지 없는지 확인하는것!
// 그래서 name이라는 키가 value 오브젝트 안에 잇는지 확인해보면
console.log('name' in ellie); // true 라고 출력돼!
//그래서 간단하게 키가 있는지 없는지 확인할수있는 키워드야.
//정의하지 않은 어떤키를 사용하면 false라고 나올거야.
//여기서만약 우리가 정의하지 않은 키에 접근! 하게되면
console.log(ellie.random); //undefined 이 출력돼.

// 6. for..in vs for..of 프로젝트할때 굉장히 유용해!
// for (key in obj)
console.clear(); //이렇게 clear을 이용하면 이전것들이 다 지워져.
for(key in ellie) { //이건 ellie가 가지고있는 키들이
    //이 블럭을 돌때마다 키들이 key라는 지역변수에 할당이 되어져.
    console.log(key);//그래서 이러면 ellie안의 모든 key들이 출력돼.
}//모든 키드를 받아와서 일들을 처리하고싶을때 for in을 쓰면 좋아.

// for (value of iterable)
// 얘는 오브젝트를 쓰는것이 아니라 배열, 리스트
// 이렇게 순차적으로 하는 아이들을 써 예를들면
const array = [1, 2, 3, 4]; 
//위 데이터의 모든값들을 찍으려면 예전같으면
/*  for(let i = 0; i < array.length; i++) {
    console.log(array[i]);
}
이런식으로 했어야 했는데 좋진않아 출력은 되겠지만
그러니까 이제 밑처럼 쉽게할수있는 방법이 있어.
바로 for of 쓰는거야!
이렇게 하면 array에 있는 모든 값들이
value에 할당 되면서 블럭안에서 순차적으로 출력하거나
값을 계산할수가있어.
*/
for (value of array) {
    console.log(value);
}

// 7. Fun cloning
// Object.assign(dest, [obj1, obj2, obj3...])
const user = { name: 'ellie', age: '20' };
const user2 = user;
/*
    user라는 곳에 오브젝트를 만들어놓고
    user2가 user를 가리키게 해놓았다.
    그럼 메모리에는 user라는 변수는 메모리를 가리키고 있는데
    메모리에는 레퍼런스 ref가 들어있지?
    이 ref는 실제로 name은 ellie고 age는 20이라는
    이런 오브젝트를 가리키고 있는 레퍼런스가 들어있어.
    그리고 user2의 변수는 user가 할당이 되어졌지?
    그 말은 user안에 들어있는 이 ref즉 레퍼런스의 값이
    user2에도 동일하게 할당된다는 말이야. 그래서
    user2에도 동일한 ref가 들어있어 그리고 
    이 동일한 ref도 똑같은 ellie 오브젝트를
    가리키고 있어.
*/
//여기서 만약 user2의 이름을 coder로 바꾼다면?
user2.name = 'coder';
console.log(user.name);//그럼 user의 이름도 ellie에서 coder로 바껴
// user2가 가리키고있는 ellie를 coder로 바꾸니 당연히 동일한걸 원래
// 보고있는 user가 가리키는것도 바뀌는거야.
// 이런식으로 말고 정말 오브젝트를 복제할수있는 방법은?
// 바로 밑의 이것이다!

// old way
/*
    예전에 이런것을 할때는 텅텅비어져있는 오브젝트를
    밑의 const user3 = {}; 이렇게
    먼저 만들고 앞에서 배운 for in을 써서
    오브젝트를 빙글빙글 돌며 메뉴얼 적으로 
    수동적으로 할당해주는 방법이 있어.
*/
const user3 = {};
for (key in user) { //그래서
    user3[key] = user[key]; //user3의 key에는 user에 있던 value를 할당해주는것.
} //돌때 첫번째 키는 name이 되고 두번째키는 age가 되겠지?
//그래서 첫번째 이름일때는 user3에 새로운 프로펄티 name을 추가할건데
//값은 기존에 있는 user의 key 이름에 있는 value 즉
//변경되어진 coder 이걸 위에서 지우면 ellie가 할당돼.
//두번째로 돌때는 user3에 age라는 프로펄티가 
//추가가 되고 값은 user에 있는 20이 할당되는것.

console.clear();//이전에 출력되어진 log는 지워보쟈.
console.log(user3); //이렇게 새로만들어진 user3을 찍으면 값들이 복사되어져있는걸 확인할수있어.

// 다른 방법으론? 오브젝트에 있는 assign을 쓰는것!
// assign은 복사하고자 하는 target과 
// 복사를 하려고하는 source를 같이 전달해줘야하고
// return값은 타겟과 복사하고자 하는것이 통합된 아이야.
// 그래서 타겟을 만들면 텅텅비어져있는걸 정의한다음에
const user4 = {}; //이렇게
Object.assign(user4, user);//user4전달해서 바로 복사하고자하는
//오브젝트인 user 오브젝트를 전달하면돼. 그래서 
console.log(user4);//하면 복사된 ellie가 나오는걸 볼수있어.

//전달하는 오브젝트의 값은 텅텅비어져있고 
//리턴되는 값은 두개가 섞인게 리턴이 되니까
const user4 = Object.assign({}, user);
//이런식으로 return값을 받아와서 작성해도 돼.
console.log(user4);

// another example
// 어사인 함수의 인터페이스를 살펴보니 여러개의 소스를 
// 전달할수도 있었어.
const fruit1 = { color: 'red' };
const fruit2 = { color: 'blue', size: 'big' };
//둘의 공통적 프로펄티는 color
//size라는 새로운 프로펄티가 fruit2에 들어있어
const mixed = Object.assign({}, fruit1, fruit2);
//그래서 저 둘은 섞은게 mixed라는 변수야
console.log(mixed.color); // blue 출력
console.log(mixed.size);  // big 출력
//뒤의 나오는 아이일수록 앞에 동일한 프로펄티가 있다면
//값을 계속 덮어 씌우기 때문이야. 뒤에 fruit3 색이 블랙
//인 아이를 같이 섞게되면 플룻2에 나와있던 
//프로펄티를 계속 덮어 씌우니 색은 블랙으로 나와!
