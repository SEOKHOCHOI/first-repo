// 1. Shorthand property names
/*
    const ellie3 = {
        name,
        age,
    };
*/

/*
    const ellie1 = {
        name: 'Ellie',
        age: '18';
    };

    const name = 'Ellie';
    const age = '18';

    const ellie2 = { //별로인코드
        name: name,
        age: age,
    };
    js에서 오브젝트는 항상 key와 value로 이루어져 있는데
    const name = 'Ellie';
    const age = '18';
    이렇게 name과 age라는 변수가 정의되어 있다면..
    내 앞에서 정의한 변수를 이용해서 새로운
    오브젝트를 만들려면 ellie2의 name이라는 값은 
    위의 name의 변수가 가리키고 있는 Ellie 값이 들어오게 되고,
    age라는 키의 값은 18이 들어온다. 이때 키와 value이름이
    동일한 경우에는 

    const ellie3 = { //좋은코드
        name,
        age,
    }
    이렇게 하나로만 깔끔하게 축약해서 작성이 가능해.

    이것을 출력해보면
    console.log(ellie1, ellie2, ellie3); 
    전부 똑같이 {name: "Ellie", age: "18"} 그대로 출력이돼.
*/

// 2. Destructuring Assignment
/*
    const { name, level } = student;
    const [first, second] = animals;
*/

/*
    이렇게 object의 key와 value에 접근하기 위해선
    항상 
    //object
    const student = {
        name: 'Anna',
        level: 1,
    };  <<이 오브젝트에 접근하기 위해서
    
    {  //별로인 코드
        const name = student.name;
        const level = student.level; 이렇게 복잡하게 작성했어야 했는데..
        console.log(name, level);
    }

    //좋은코드
    {
    const { name, level } = student;
    console.log(name, level);
    }
    이렇게 이용하게 되면 오브젝트에 있는 키의 이름을 
    괄호 안에 정의해 주고 있고 student라고 작성하게 되면
    이 student에 있는 key와 value들이 각각
    name과 level에 맞게 할당이 된다.
    이걸 출력해보면 Anna 1 이렇게 출력된다.

    이렇게 항상 object 안에 정의 된 key의 이름을
    동일하게 괄호안에 작성해서 선언해 주어야 하는데
    만약 다른이름으로 선언하고 싶다면
    오리지날 이름을 작성한 다음에 콜론을 이용해서 원하는
    이름을 작성하면 된다.

    이렇게 말이다. 
    const{ name: studentName, level: studentLevel} = student;
    console.log(studentName, studentLevel); 콘솔에도 새로운 이름으로 해줘!

    그리고 이건 오브젝트 뿐만 아니라 배열에서도 동일하게 쓸수있어.

    //array
    const animals = ['강아지', '고양이'];

    //안좋은 코드
    { 배열에 각각 접근하기 위해서는 animals 다음에 숫자 인덱스를 이용해서
        const first = animals[0]; 배열에 각각 접근했어야 했다..
        const second = animals[1];
        console.log(first, second);
    } 
    하지만 이제는 이렇게 간단히 해볼수 있다.
    //좋은코드
    {
        const [first, second] = animals;
        console.log(first, second);
    }
    배열에 들어있는 순서에 맞게 처음으로 선언된 
    first 라는 변수에는 첫번째인 강아지가,
    second에는 두번째들어있는 고양이가 이렇게
    순서대로 할당이 된다.

    즉, 
    오브젝트에 적용할때는 오브젝트에 {}이 괄호를 이용해야하고
    배열을 이용할때는 배열의 [] 이 괄호를 이용해야 한다.
*/

// 3. Spread Syntax   (정말 활용도 높아!)
/*
{
    const fruits = [...fruitsl, ...fruits2];
    const dog = { ...dog1, ...dog2 };
}
*/

/*
    const obj1 = { key: 'key1' };
    const obj2 = { key: 'key2' };
    const array = [obj1, obj2];

    위의 obj들을 담고있는 배열을 복사하기 위해선
    어떻게 할 수 있을까?
    물론 많은 방법들이 있겠지만 스프레드 신텍스를
    이용하면 간단히 가능하다.

    //array copy
    const arrayCopy = [] 이렇게 새로운 배열을 만들고
    array에 있는 배열의 아이템들을 하나하나씩 
    복사해 올수가 있는데 하나하나씩 복사해 올때는
    배열에 들어있는 map이나 forEach같은걸 
    이용해 올수도 있겠지만 스프레드 신텍스를 이용하면
    간단하게 ...array 만으로 간단하게 배열을
    복사해올수 있다. 
    const arrayCopy = [...array]; 
    이렇게 말이다!

    이 ...은 array에 들어있는 아이템들 하나하나씩
    각각 낱개로 가져와서 복사해 오는것을 말한다.

    그래서 각각 
    const arrayCopy = [...array];
    console.log[array, arrayCopy]; 
    array와 arrayCopy를 출력해보면 동일한 아이들이
    출력되는것을 볼수가 있다.

    이렇게 배열을 복사해 오면서 새로운 아이템을 추가하고
    싶다면? 스프레드 신텍스를 ...array를 쓴 다음에
    추가하고자 하는 아이템을 작성해 주면돼.
    const arrayCopy2 = [...array, { key: 'key3 }];
    이렇게 말이다!!
    출력해보면 새로 추가된 아이템인 key3가 들어있는걸
    확인해 볼 수 있다.

    전에 공부한 부분인데 오브젝트를 가리키고 있는 변수는
    실제로 이 오브젝트를 담고있는것이 아니라
    오브젝트가 들어있는 메모리의 주소의 값을 가지고있다.
    그래서 ...array에 복사 돼 온 아이들은 
    주소값만 복사되어서 오는 거기 때문에
    실제로는 전부다 동일한 오브젝트를 가리키고 있다.
    그래서 obj1.key = 'newKey';
    이렇게 obj1에 있는 key의 값을 변경하게 된다면
    array, arrayCopy, arrayCopy2 세가지 전부다
    값이 변경되어져 있는걸 확인해볼수가 있다.

    그래서 정말 중요한 포인트는,
    이 Spread 연산자는 
    오브젝트 안에 들어있는 아이들을 모두 다 하나씩
    복사해 오는것이 아니라 이 오브젝트가 
    가리키고 있는 주소의 참조값만!!!!!
    복사해서 오기 때문에 스프레드 오퍼레이터 ...array를
    이용해 복사해 온다고 해도 원래의
    오브젝트를 변경하게 되면 전부다 영향이 갈수있기 때문에
    이점을 꼭 유의해야 한다.
*/
/*
    활용 예제

    // object copy
    const obj3 = { ...obj1 };
    console.log(obj3);
    배열뿐만 아니라 이렇게 오브젝트도 카피할수있다.
    object는 오브젝트의 괄호인 {}를 이용해야 한다.
    출력해보면 오브젝트의 값이 복사돼 오는걸
    확인해볼수 있다.

    // array concatenation
    모든것을 하나로 합칠수 있는 concatenation!
    const fruits1 = ['복숭아', '딸기'];
    const fruits2 = ['바나나', '키위'];
    const fruits = [...fruits1, ...fruits2];
    console.log(fruits);
    이러면 하나로 병합된 ["복숭아", "딸기", "바나나", "키위"] 배열이 출력된다.

    // object merge, 당연히 오브젝트도 병합이 가능해!
    const dog1 = { dog1: '슈나' };
    const dog2 = { dog2: '비글' };
    const dog = { ...dog1, ...dog2 };
    console.log(dog);
    한가지 주의해야 하는점은 만약 key가 동일한
    오브젝트를 병합한다면 제일 뒤에오는 아이가 
    앞에오는 아이를 덮어씌운다!
    이 경우엔 dog2가 dog1을 덮어씌우게 될것임.
*/

// 4. Default parameters
/*
    function printMessage(message = 'default message') {
        console.log(message);
    }
*/

/*
    function printMessage(message) 이렇게 함수를 정의할때
    ()안에 message라는 인자를 받아오는 경우라면 
    printMessage('hello'); 이렇게 정상적으로 인자를 전달하는

    function printMessage(message = 'default message') {
        console.log(message);
    }
    printMessage('hello); 
    이런 경우라면 상관 없지만

    printMessage(); 이렇게 함수를 호출할때 아무런 인자를 전달하지
    않으면 undefined라는 알수없는 메시지가 출력된다.

    이렇게 아무런 인자가 전달되지 않을 경우에 
    defult messge를 출력하고 싶다면

    function printMessage(message = 'default message') {
        if (message == null) {
            message = 'default message';
        }
        console.log(message);
    }
    printMessage();
    많이들 이렇게 if문 추가해서 작성하고 있는데

    이제 디폴트파라미털스를 이용하면 아주 간편히 작성가능!
    이렇게!!
    function printMessage(message = 'default message') {
        console.log(message);
    }
    printMessage('hello');
    printMessage();

    저렇게 message인자 다음에 = 'default message'라고
    초기값을 지정해 줌으로써 
    인자가 전달될때는 인자의 값을 
    인자가 전달되지 않을때는 기본적으로 설정된 
    default message 이 값을 이용하게 돼.
*/

// 5. Ternary Operator
/*
    const component = isCat ? '고양이' : '강아지';
*/

/*
    const isCat = true;
    이렇게 isCat이라는 변수가 true인지 false인지에 따라서
    다른 component를 정의하고 싶다면?

    //안좋은 코드
    let component;  //이렇게 component변수를 정의한 후..
    if (isCat) {
        component = '고양이';
    } else {
        component = '강아지';
    }
    console.log(component);

    //이용해서 간단히!
    const component = isCat ? '고양이' : '강아지';
    console.log(component);
    
    true면 고양이 false면 강아지 출력됨!
    아니면 사용하고자 하는부분에 직접적으로 작성해도 돼.
    이렇게
    console.log(isCat ? '고양이' : '강아지');

    리액트에서 굉장히 많이 쓰이고있다!!!
*/

// 6. Template literals
/*
    `Today weather is ${weather} and temparature is ${temparature}.
*/

/*
    const weather = '흐림';
    const temparature = '16도C';

    //안좋은 코드
    console.log(
        'Today weather is ' + weather + ' and temparature is ' + temparature + '.'
    );  굉장히 지저분해 보이는 방식이지?

    //좋은 코드
    console.log(`Today weather is ${weather} and temparature is ${temparature}.);
*/