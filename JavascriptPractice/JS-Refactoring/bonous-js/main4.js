// class

/*
    class Counter {
        constructor() {
            this.counter = 0;
        }

        increase() {
            this.counter++;
            console.log(this.counter);
        }
    }

    const collCounter = new Counter();
    coolCounter.increase();
    coolCounter.increase();
    coolCounter.increase();

    위의 코드를 순서대로 설명!

    Counter라는 class를 만들어보자.
    Counter을 처음에 생성이 되면 
    자체적으로 counter라는 변수가있는데 0부터 시작해.
    conter은 이 class를 이용해서 오브젝트를 만드는순간
    0으로 초기화 된다.

    그리고 이 class안에는 increase라는 함수가 하나있다.
    class에서 함수를 선언할때는 앞에
    function이라고 작성하지 않아도 된다.

    여기서 increase라는건 증가하는 함수인데
    이걸 호출할때마다 counter의 숫자를 하나씩
    증가할 것이다. 이걸 우리눈으로 확인하면서 하면
    좋으니까 console.log()안에 넣어준 것이다.

    클래스는 다양한 오브젝트를 만들기위한 청사진이다.
    자 이제 class를 이용해서 
    collCounter라는 변수에다가 오브젝트를 만들었다.
    그리고 new라는 연산자를 이용해서 Counter를 만들었다.

    그럼 constructor가 실행이 되는데 this.counter를 0으로 초기화하고
    그래서 counter에 0으로 데이터가 들어가게 되는데
    
    이상태에서 계속 increase라는 함수를 호출했다.
    호출할때마다 클래스안에있는 counter라는 데이터를
    하나씩 증가해서 숫자가 1씩 증가할것이다.

    counter가 숫자 5가 될때마다 알고싶다.
    누군가가 이 카운터를 숫자가 계속 증가했을때
    숫자가 5배속으로 증가될때마다 우리가 알고싶다.
    어떻게 하면 좋을까?

    첫번째 방법은 increase함수 자체에서 하는거다.

    class Counter {
        constructor() {
            this.counter = 0;
        }

        increase() {
            this.counter++;
            console.log(this.counter);
            if(this.counter % 5 === 0) {
                console.log('yo');
            }
        }
    }

    const collCounter = new Counter();
    coolCounter.increase();
    coolCounter.increase();
    coolCounter.increase();
    coolCounter.increase();
    coolCounter.increase(); //이러면 yo!가 출력이 된다.
    
    이렇게 하면 되는데.. 문제점이 있다.
    문제점은 카운터 클래스 자체에서 이렇게 하기때문에
    coolCounter를 쓰는사람이 이것을 조절할수가 없다.
    만약 내가 yo 말고 다른걸로 출력하고 싶다면?
    아니면 출력하는게 아니라 사용자에게 
    팝업을 보여주고싶다면?? 아니면 내가 조금 더 다양한걸 하고싶다면?
    그것을 컨트롤 할수있는게 전혀없지?

    그래서 뭐.. 우리가
    if(this.counter % 5 === 0) {
                console.log('yo');
            }
    이걸 콜백함수로 전달해도 되겠지.. 근데 
    increase() 의 괄호안에 콜백함수 이름을 뭐라고할꺼야?
    runIf5Times 뭐 이런식으로 이 콜백을 
    if(this.counter % 5 === 0) {
                console.log('yo');
            runIf5Times();     <<요기다 이렇게 호출하고
            }
    카운터에는 이제 인크리즈 할때마다 이 콜백함수를 전달하면 되겠지? 그럼
    밑에다가 function printSomething() {
        console.log('yo');
    } 이렇게 하면 되겠찌? 그리고 인크리즈 할때마다
    coolCounter.increase(printSomething); 
    이렇게 전부 함수를 전달해주면돼..

    class Counter {
        constructor() {
            this.counter = 0;
        }

        increase(runIf5Times) {
            this.counter++;
            console.log(this.counter);
            if(this.counter % 5 === 0) {
                runIf5Times();
            }
        }
    }

    const coolCounter = new Counter();
    function printSomething() {
        console.log('yo');
    }
    coolCounter.increase(printSomething);
    coolCounter.increase(printSomething);
    coolCounter.increase(printSomething);
    coolCounter.increase(printSomething);
    coolCounter.increase(printSomething);
    이렇게 말이지..
    그럼 이 전달된 함수는 숫자가 5배일때만 호출이 되겠지?

    그럼 만약 내가 숫자를 정확하게 알고싶으면..?
    그럼 runIf5Times(this.counter); 이렇게 ()안에
    디스카운터를 전달해주면 돼.
    그다음 function printSomething(num) 의 ()안에저렇게
    num이라는 숫자라는 인자를 받아서 숫자를 출력하면돼.
    바로밑에 console.log(`yo! ${num}`); 해주면
    yo! 5 이렇게 출력되겠지?
    coolCounter.increase(printSomething); 이걸 
    다섯번 더 추가해서 하게되면 
    6 7 8 9 10 한다음 yo! 10을 또 출력해주게 되겠지.

    이렇게 했을때의 장점:
    우리가 조절할수가 있따.만약에 프린터를 yo대신에
    Wow 이렇게 바꿀수도 있고 

    function alertNum(num) {
        alert(`Wow! ${num}`);
    } 그 후
    끝에 coolCounter.increase(alertNum);
    이렇게 해주면 실행해보면 숫자 10이되면 
    팝업으로 나오는걸 확인해 볼수가 있어.

    문제점: 
    increase라는 함수를 호출할때마다 얘네들을
    전달하려니까 너무 불편해..

    그래서 보통은 이런식으로 함수를 전달할때마다 하지않고
    constructor에서 콜백함수를 받아.
    constructor(runEveryFiveTimes) 이런식으로 콜백함수를
    받게되면 이 컨스트럭터도 함수기 때문에 함수에 인자로
    받아온 아이들을 이 클래스 자체에서 기억을 해야되기 때문에
    콜백이라는 변수에 저 에브리파이브타임즈를 할당할것.
    this.callback = runEveryFiveTimes; 이렇게..

    그래서 결국 이 Counter이라는 클래스 안에는 
    두가지의 데이터 타입이 들어가 있겠지?
    그리고 쿨카운터 인크리즈 할때마다 ()안에 뭐 안해줘도돼.

    그리고 카운터를 만들때 생성자에 우리가 원하는 
    콜백함수를 전달해준다.
    const coolCounter = new Counter(printSomething);
    이렇게 () 안에다.
    이 말은 coolCounter라는 오브젝트는 이 Counter라는
    클래스의 청사진을 이용해서 오브젝트를 만들었는데

    coolCounter은 이랑 동일하게 똑같이 카운터는 0부터
    시작하고 콜백은 프린트썸띵을 가리키고 있어.

    인크리즈가 호출될때마다 카운터가 5배가되면
    이 콜백함수 호출할거야. 호출할때 이 클래스 안에있는
    counter라는 데이터를 전달해준다.
    이 콜백은 결국 프린트썸띵이라는것을 가리키고 있기 때문에
    function printSomething(num) 얘가 수행이 되겠지?

    class Counter {
        constructor(runEveryFiveTimes) {
            this.counter = 0;
            this.callback = runEveryFiveTimes;
        }

        increase() {
            this.counter++;
            console.log(this.counter);
            if(this.counter % 5 === 0) {
                this.callback(this.counter);
            }
        }
    }

    function printSomething(num) {
        console.log(`Wow! ${num}`);
    }

    function alertNum(num) {
        alert(`alert! ${num}`);
    }
    const coolCounter = new Counter(alertNum);
    coolCounter.increase();
    coolCounter.increase();
    coolCounter.increase();
    coolCounter.increase();
    coolCounter.increase();

    이런식으로 클래스에 우리가 원하는 콜백함수를 전달하면서
    만들고 필요할때마다 들으면 된다.

    만약우리가 const coolCounter = nuw Counter();
    이렇게 alertNum이라는 콜백함수를 아무것도
    전달하지 않았다면 Counter라는 클래스는 이 클래스를
    만들때 콜백함수를 하나 전달받는데 
    constructor(runEveryFiveTimes)에서 저런에브리..부분이다.
    타입스크립트에선 이 타입스크립트 인자가 정말 꼭 필요한지
    아니면 전달해도 되고 전달하지 않아도 되는지를 
    타입에서 runEveryFiveTimes: function? 이런식으로
    명시할수있다. ? 마크를 하면 옵셔널이야!
    전달해도 되고 전달하지 않아도 돼.
    근데 JS는 그런게 없어. 
    
    그래서 우리가만약 Counter를 만들때 아무것도 전달하지 않으면
    runEveryFiveTimes라는 인자는 언디파인이 되겠지?
    즉, this.callback.. 이 클레스 안에 있는 콜백은
    언디파인이 되는거야. 그럼 타입 에러가 발생하게돼.
    콜백은 펑션이 아니고 언디파인이니까..
    그래서 if에서 this.callback이 데이터가 있는지 없는지..
    언디파인인지 아닌지를 확인해서 언디파인이 아닐때만 
    콜백을 불러야해.
    즉, 이 클래스를 만들때 만드는 사용자가 
    콜백함수를 등록 했으면 호출해주고 
    등록된 콜백함수가 없다면 호출하면 안된다.

    그래서 
      increase() {
            this.counter++;
            console.log(this.counter);
            if(this.counter % 5 === 0) {
                this.callback(this.counter);
                if(this.callback) {
                    this.callback(this.counter); 해주면 돼.
                }
            }
        }

   아니면 간단하게

     increase() {
            this.counter++;
            console.log(this.counter);
            if(this.counter % 5 === 0) {
                this.callback(this.counter);
                this.callback && this.callback(this.counter);
            }
        }
해주면 실행할수 있어.

        클래스에 우리가 원하는 기능을 다 정의하게 되면
        사용하는 사람이 자세하게 컨트롤 할수도없고
        재사용이 떨어져.
        하지만 callback함수를 이용해서 class를 만들게되면
        Counter를 쓰는 사람이 자기 입맛에 맞게 만들수있다.

        그래서 
        const printCounter = nuw Counter(printSomething);
        프린트 카운터는 5배가 될때마다 이렇게 프린트를 하게되고,

        똑같이 얼럴카운터를 만들면
        const alertCounter = nuw Counter(alertNum);
       이렇게 얼럴은 하게된다.

       즉, 하나의 클래스로 다양한 오브젝트를 만들어서
       서로 다른 기능을 수행하는 오브젝트를 만들수가 있다.
       이렇게 하면 이제 이 클래스의 재사용 가능성이 높아진다.

        핵심 키포인트는!!
        가능하면 클래스를 하나의 완전히 다 만들어진
        완전체로 만들기 보다는 우리가 레고로 조립을 해서
        원하는것을 만들수있는것처럼 우리가 원하는 기능을
        끼워 맞춰서 재조립이 가능하도록 만드는것이 좋다.
        그렇기 때문에 저렇게 콜백함수를 등록을 받는거다!

        포인터로 전달이 되어서 같은함수를 가리키고 있고..
        등록된 콜백이 있으면 그 콜백을 실행하는 
        이런 개념을 이해하는게 중요하다.

*/ 