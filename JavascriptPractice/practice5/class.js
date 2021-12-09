// 만약 JS에 class나 object가 없다면?
/*
  우리가 정의한 변수들이 여기저기 둥둥 떠다니며
  규모있는 프로젝트를 만들기 굉장히 힘들었을 거야.
  class는 조금 더 연관있는 데이터를 한데 묶어 놓는 컨테이너 같은 애야.
  class person{
      name;
      age;
      speak();
  }
  이렇게 person이라는 class안에는 이름과 나이라는 프로펄티즈가 들어있고
  speak! 말하는 펑션이 들어있어.
  
  이처럼 class 안에는 name과 age라는 속성(field)가 들어있고
  speak(); 말하는 행동(method)가 들어있어.

  즉,class 조금더 연관있는 데이터들을 묶어놓은..
  fields와 methods가 종합적으로 묶여있는걸 말하는데 
  간혹 class안에는 methods는 들어있지 않고 
  data만 즉, fields만 들어있는 경우도 있어. 이렇게도 많이쓰고
  이런아이를 data class라고해.

  이렇게 관련있는 변수나 함수들을 묶어놓은걸 class라고하고
  이 class 안에서도 내부적으로 보여지는 변수와
  밖에서 보일수있는 변수들을 나누어서 이런것들을
  인캡슐레이션 즉, 캡슐화 라고해.

  그리고 클레스를 이용해서 상속과 다양성을 
  일어날수있는데 이런모든것들이 가능한것이 객체지향 언어야.

  우리가 실제로 살아가고있는 이 세상에는 수많은 물체와 사물들이 존재하는데
  이렇게 프로그래밍을 할때도 사물과 물체들을
  클레스로 오브젝트로 정의해서 프로그래밍 하는것이
  조금더 자연스럽기 때문에 개발자들이 편하고 유연하게
  프로그래밍을 할수있게 도와주는거야.

  객체지향 언어로 프로그래밍을 잘하는 개발자는 
  이렇게 풀어야하는 문제나 구현해야 하는 기능들을
  객체로 잘 정의해서 만들수있는 개발자를 말해.
 */


/*
  class는 붕어빵을 만들수있는 틀!
  그래서 청사진이라고도 불리고 template이라고도 불려.
  class 자체에는 data가 들어있지 않고
  틀만 template만 정의해 놓는거야.
  이런 class에는 요런요런 data가 들어올수있어 라고..
  정의를 해놓고 한 번만 선언해.

  그래서 이 class를 이용해서 실제로 data를 넣어서 만드는 것이 바로
  object야!
  그래서 class를 이용하여 새로운 instance를 생성하면
  object가 되는거야.
  object는 class를 이용해서 굉장히 많이 만들수있고
  class는 정의만 한것이라서 실제로 메모리에 올라가진 않지만
  이렇게 실제로 데이터를 넣으면 
  이제 object는 메모리에도 올라가게돼.

  그래서우리가 붕어빵 이라는 class를 이용해서
  팥을 넣으면 팥붕어빵이 되고
  크림 data를 넣으면 크림 붕어빵이 되고 
  피자맛을 넣으면 피자붕어빵이 되는거야.
  이렇게 만들어진 붕어빵 자체는 object이고,

  이 붕어빵을 만들기 위해 우리가 정의한 
  붕어빵의 틀은 class 인거야.
*/

// JS에서 class 선언방법!!
'use strict';
// Object-oriendted programming
// class: template, 클레스는 템플릿에 속하고
// object: instance of a class, 위의 템플릿을 이용하여 실제로 데이터를 넣어만드는게 오브젝트
// JavaScript classes
//  - introduced in ES6, JS에선 ES6에 추가된거라 class도입된지 얼마안됨.
                       //class가 도입되기전엔 class 정의 않고 바로 object를 만들수있었고 이걸만들때 펑션을 이용해 템플릿만듬.
//  - syntactical sugar over prototype-based inheritance
//             즉, 기존에 존재하던 JS위에 추가된거라 완전히 새롭게가 아닌 기존에 존재하던
//                 프로토타입을 베이스로 한것에 기반해서 그 위에 간편하게 쓸수있도록 문법만 class가 추가된거.

// 1. Class declarations, 클레스 선언, 클레스 쓰는법
class Person {
    // constructor
    constructor(name, age) {
        // fields
        this.name = name;
        this.age = age;
    }
    // methods
    speak() {
        console.log(`$(this.name): hello!`);
    }
}
/*  위의 설명-
    class라는 키워드를 이용해 person이라는 class를 만들고
    constructor 생성자를 이용하여
    우리가 나중에 object를 만들때 필요한 데이터를 전달한다.
    그래서 전달받은 데이터를 class에 존재하는 두가지 필드
    name과 age에 우리가 전달된 데이터를 바로 할당해 준것.

    그래서 여기 class 에는 name과 age라는 fields가 있고
    speak() 라는 methods도 존재하게 돼.그리고
    그리고 speak 메소드 {} 안에 보면
    console.log(`$(this.name): hello!`); 가 있는데
    단순하게 이 class에 있는 this.name 이름을 출력하며
    hello! 인사하는 speak 이다.
    */
// 위처럼 잘 정리된 class를 이용하여 Object를 생성해보자.
const ellie = new Person('ellie', 20);
console.log(ellie.name);
console.log(ellie.age);
ellie.speak(); //이걸 이용하면 함수 호출가능.
/*
    새로운 object를 만들때는 new라는 키워드를 사용해.
    새로운 Person을 만들었는데 class의 constructor안에는
    이름 name과 나이 age라는 데이터가 전달되지?
    그래서 이름은 ellie이고 나이는20살이라고 해준거야.
    이러면 새로운 object가 만들어진 것이고,
    확인해보기위해 console에 찍으면(출력하게 되면)
    ellie
    20
    이렇게 출력이 돼.
    그리고 ellie에는 speak라는 메소드가 있지?
    그럼 함수 호출해 ellie: hello! 라고 출력돼.

    그리고 위 class의 speak()부분 console에서 
    this 라는것은 생성된 object, .name 이라고 하기때문에
    ellie의 이름이 출력되는거야.
*/

// 2. Getter and setters, 게터, 세터!
class User {
    constructor(firstName, lastName, age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }
//user의 age가 -1은 말이 안되기에 get 키워드 이용
//get으로 값 리턴 set으로 값 설정
    get age() { //사용자가 get age를 호출하게되면
        return this._age;//우리는 바로 return해주고
    }
    //set은 값을 설정하기 때문에 ()안에 value를 받아와야해.
    set age(value) { //새로운 value를 받으면 
        this._age = value; //이렇게 해주게 돼.
    }
} // 근데 이렇게하면 해주면 call stack이 초과되었다 에러가 발생할수있어.

const user1 = new User('Steve', 'Job', -1);
console.log(user1.age);
/*
    사람의 나이가 -1인건 말이 안되지?
    이렇게 class를 사용하는 사용자 또는 
    우리가 작성한 class를 옆에있는 동료가 잘못 사용해도
    좀 더 방어적 자세로 만들수있게 해주는게 게터와 세터야.
*/

/*
    위에서 우리가 get age() 즉, age라는 게터를 정의한 순간 
    class의 this.age는 메모리에 올라가있는 데이터를 읽어오는 것이 아니라
    바로 get age() 즉, 게터를 호출하게 돼.

    그리고 우리가 세터를 정의하는 순간 this.age = age;에서
    = 사인을 호출할때 즉 값을 할당할때 바로 메모리에 값을 할당하는 것이 아니라
    세터를 호출하게돼. 이 말은 우리가 세터안에서 
    전달된 value를 this.age에 할당할때
    메모리에 값을 업데이트 하는것이 아니라
    세터를 호출하게 되는거야. 즉 세터로 다시 돌아와서
    this.age=value;문장은 또 세터를 호출하고 이걸 무한반복하게돼.

    이걸 방지하기 위해선 게터와 세터안에 쓰여지는 변수의 이름을
    조금 다른이름으로 만들어줘야해. 보통은 _ 기호를 이용해서
    return this.age랑 this.age를 
    return this._age; 와 this._age = value; 로
    만들어주면 돼.

    User라는 class 안에는 총 세개의 필드가 있는데
    firstName하나 lastName 두개 그리고 _기호가 붙은 age 세개야.

    그래서 이제는 세터가 있기 때문에 세터안에 if이용하여
    set age(value) {
        if(vlaue < 0) {
            throw Error('age can not be negative');
        }
        this._age = value;
    }
    이렇게 - 값을 주면 어떡하냐고 공격적으로 경고를 줘도 되고,
    조금더 젠틀하게 하고싶다면
    set age(value) {
        this._age = value < 0 ? 0 : value ;
    } 
    이렇게 value가 -값이면 0을쓰고 아니면 
    지정된 value를 쓰겠다 처럼 적어줘도 돼.
    그럼 -1이라고 지정했지만 age는 0으로 저장돼.

    그리고! 필드는 기호가 들어간 _age라고 저장했지만 
    console.log(user1.age); 에서 .age라고 호출할수 있는 이유는
    그리고 this.age = age;처럼 .age에 값을 할당할수 있는것은
    내부적으로 게터와 세터를 이용하기 때문이야.
*/

// 3. Fields (public, private), 너무 최근에 추가된거라 많이쓰진않음
// Too soon!
// https://developer.mozilla.org/en-U5/docs/Web/JavaScript/
// 컨스트럭털 즉, 생성자를 쓰지 않고 필드를 정의할 수가 있어.
// 그냥 정의하면 퍼블릭! 외부에서 접근이 가능하고
// #기호를 붙이게 되면 프라이빗 필드! 
// 즉 클래스 내부에서만 값이 보여지고 접근,변경이 가능하지만
// 외부에선 읽을수도 변경할수도 없게돼.
class Experiment {
    publicField = 2;
    #privateField = 0;
}
const experiment = new Experiment();
console.log(experiment.publicField); //2라고나오지만
console.log(experiment.privateField);//undefined라고 나옴

// 4. Static properies and methods
// Too soon! 아직 쓰긴힘들고 알고만 있자.
class Article {
    static publisher = 'Dream Coding';
    constructor(articleNumber) {
        this.articleNumber = articleNumber;
    }

    static printPublisher() {
        console.log(Article.publisher);
    }
}
/*
    class 안에 있는 필드와 메소드들은 새로운 오브젝트를
    만들때마다 그대로 복제되어 값만 우리가 지정된 값으로
    변경이 되어 만들어지는데 간혹 이런 오브젝트에 상관없이
    data에 상관없이 class가 가지고있는 고유한 값과
    이런 data에 상관없이 동일하게 반복적으로 사용되어지는
    메소드가 있을수 있지? 그런것들을
    위처럼 static 이라는 키워드를 이용하여 붙이면
    오브젝트에 상관없이 클레스 자체에 연결되어있다.
*/
//무슨 말이냐면
const article1 = new Article(1);
const article2 = new Article(2);
console.log(article1.publisher); //얜 안되고
console.log(Article.publisher);//얘는 돼.
Article.printPublisher(); // 함수 호출
/*
    위처럼 알티클 1,2라는 오브젝트를 만들게 되면
    만약 우리가 스테틱을 사용하지 않았다면 
    오브젝트를 이용하여 
    console.log(article1.publisher);
    article1오브젝트에 publisher를 출력할수 있었겠지만
    static을 사용했기에 undefined가 나온다.
    이 말은 static은 오브젝트마다 할당되어지는것이 아니라
    class자체에 즉, Article이라는 클레스 자체에 붙어있기 때문임.
    그래서 article1이 아니라 Article 클레스 바꿔 적어줘야
    Dream Coding이 출력돼.
    그래서 static 함수를 호출할때도 
    클래스이름인 Article을 이용해서 호출해주면 돼.

    나중에 TS를 할때도 많이 쓰이는데
    오브젝트에 상관없이 들어오는 데이터에 상관없이
    공통적으로 class에서 쓸수있는 거라면
    static과 static 메소드를 이용하여 작성하는것이
    메모리의 사용을 좀더 줄여줄수있겠지?
*/

// 5. Inheritance, 상속과 다양성
// a way for one class to extend another class.
/*
    만약 우리가 브라우저에 다양한 도형들을 그릴수있는
    웹어플리케이션을 만든다고 가정해보고
    직사각형 삼각형 이런애들을 그린다고 가정해보자.

    그럼 이런 아이들을 클래스로 정의할때
    어떻게 만들수 있을까? 
    얘네들을 각각 나타낼수있는 속성을 보면
    너비, 높이, 색상등이 있다.
    그리고 공통적으로 색칠한다던가 하는 다양한 메소드들이 있을텐데
    가만보면 계속 반복되어지는 그런것들이 있는데
    도형마다의 너비와 높이, 너비와 높이, 너비와 높이...
    이렇게 반복되어지는 애들을 따로만들어
    동일한 것들을 계속 반복하는 것보다
    도형이라는 공통점을 생각하여 얘네를 한번에 빡 정의한후
    Shape에 공통적으로 쓰이는 속성값을 계속 재사용하면
    더 간편할거다! 재사용이 가능하니 유지보수도 쉬울것이다!
*/
class Shape { //shape이란 클레스를 만들고
    constructor(width, height, color) { //3가지의 필드가 있고
        this.width = width;
        this.height = height;
        this.color = color;
    }
    
    draw() {
        console.log(`drawing ${this.color} color of`);
    }

    getArea() {
        return width * this.height;
    } 
} //드로우와 겟에리아로 메소드는 총 2개가 있다.
//우리가 만약 렉탱글이라는 클래스를 만들고싶다면
//계속 반복하기 보다는 extends라는 클래스를 이용해보자.
class Rectangle extends Shape {} //이럼 shape에서 정의한 필드와 메소드가 자동적으로 렉탱글에 포함된다.
class Triangle extends Shape {//여러개 할땐 요렇게 늘려주면돼.
    //트라이앵글을 그릴때 조금 색다르게 그려고보고싶다면
    draw() { //이렇게 트라이앵글에서 draw 메소드 오버라이딩 해주면돼.
            super.draw(); //얘가 부모의 메소드도 호출해.
        console.log('삼각형모양');
    //근데 draw라는 메소드를 오버라이딩 했기 때문에
    //더이상 트라이앵글에선 shape에 정의된 draw함수가 호출되지 않아.
    //공통적으로 정의한 draw도 려주며 조금더 색다르게 그려주고 싶었다면
    //super.draw(); 를위처럼 적어줘야해.
}
    getArea() {
        return (width * this.height) / 2; //얘 덕분에 200으로 나올걸?
    } // 위가 오버라이딩!

    toString() {
        return `Triangle: color: ${this.color}`;
    }//이럼 object object보다 좀더 의미있는 데이터가 출력되겠지?
}
    const rectangle = new Rectangle(20, 20, 'blue');
rectangle.draw(); // 이러면 증명이 될것이다.
console.log(rectangle.getArea());//20과20을 곱하니 400호출될것.
const triangle = new Triangle(20, 20, 'red');
triangle.draw(); // 이러면 증명이 될것이다.
//이러면 공통되는 애들 하나하나 작성할  필요가 없다! 재사용 가능!
//draw쪽 console 한곳에서만 수정해줘도 모두 동일하게 적용돼.
console.log(triangle.getArea());//얘도 400호출
//근데 틀렸지? 삼각형 구하는방식은 다르니까! 이때 다양성이 빛을내는거야.
//우리가 필요한 함수만 재 정의해서 사용할수가 있어!!
//이걸 오버라이딩 이라고 해!! 위에 트라이앵글 extends 쉐입 부분처럼하는거야.

// 6. Class checking: instanceOf
console.log(rectangle instanceof Rectangle);// true
console.log(triangle instanceof Rectangle); // false
console.log(triangle instanceof Triangle);  // true
console.log(triangle instanceof Shape);     // true, 우리가 Shape을 상속잖아!
console.log(triangle instanceof Object);    // true, 우리가 js에서 만든 오든 오브젝트 클레스 들은
                                            //       이 js에 있는 오브젝트를 상속한것이다.
// Object 위에다 커맨드나 컨트롤 키를 누르고 클릭을 하면
// 정의된 부분으로 갈수가 있는데 js의 모든 오브젝트는 이 오브젝트를 상속한것이다.
console.log(triangle.toString());
// 이 말은 우리가 어떤 오브젝트던지 공통적으로 존재하는
// 메소드를 쓸수있다는 이야기다. 우의 투스트링 처럼
// 그래서 우리가 트라이앵글에서 오브젝트에있는
// toSting을 오버라이딩 할수가 있다. 해뒀으니 가서봐라.
 /*
    콘솔안에서 왼쪽에있는 오브젝트 rectangle이
    오른쪽에 있는 클래스의 Rectangle의 
    인스턴스 인지 아닌지 즉, 이 rectangle 오브젝트가
    Rectangle 클래스를 이용해서 만들어진 아이인지 아닌지
    확인하는 것이다!
    그래서 true와 false를 return 한다.
*/

// 자바스크립트 object들
/*
    JavaScript MDN.web docs의 reference 페이지
    이 사이트에선
    js 내부에 포함되어있는 오브젝트들을 볼수있어.
    카테고리화로 묶여져 있어.
*/

// Fun quiz time!
// function calculate (command, a ,b)
// command: add, substract, divide, aultiply, remainder

function calculate(command, a, b) {
    switch (command) {
        case 'add':
            return a + b;
        case 'divide':
            return a / b;
        case 'multiply':
            return a * b;
        case 'remainder':
            return a % b;
        default:
            throw Error('unkonwn command');    
    }
}//정해진 데이터 처리할땐 if보다 switch가 더 좋아.
console.log(calculate('add', 2, 3));