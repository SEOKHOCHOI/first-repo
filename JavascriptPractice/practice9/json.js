/*
    브라우저 위에서 동작하고 있는 웹사이트나 웹어플리케이션과 같은
    클라이언트들이 어떻게 서버와 통신할 수 있는지를
    정리한 것이 바로 HTTP 이다.

    http는 어떻게 이 하이퍼텍스트를 서로 주고받을수 
    있는지를 규약한 프로토콜의 하나이다.

    http는 클라이언트가 서버에게 데이터를 리퀘스트!
    요청할수가 있고, 서버 클라이언트가 요청한 것에 따라서
    그에맞는 응답을 클라이언트에게 보내주는 이런방식으로 진행되는것을 의미한다.

    그리고 여기서 하이퍼텍스트는 웹사이트에서 이용되어 지고있는
    링크들만 애기하는 것이 아니라 전반적으로 쓰여지고있는 리소스,
    문서나 이미지 파일 등 이런 아이들을 다 포함해서 말한다.

    이렇게 http를 이용해서 서버에게 데이터를 요청해서 받아올수
    있는 방법으로는 AJAX를 썼었다.
    얘는 웹페이지에서 동적으로 서버에게 데이터를 주고받을수
    있는 기술을 의미하는데 대표적인 예로는 XHR이 있다.

    XHR라는 오브젝트는 브라우저 API에서 제공하는 
    오브젝트중 하나로 이 오브젝트를 이용하면 간단하게
    서버에게 데이터를 요청하고 받아올수있다.

    최근 브라우저의 API에 추가된 fetch() API를 이용하면
    간편하게 데이터를 주고받을수가 있다.

    하지만 무조건 신규로 추가되었다해서 우리가 함부로
    사용할수 없다....

    AJAX, XHR에서 계속 반복해서 XML이 등장하고 있는데
    이 XML은 바로 html과 같은 마크업 언어중 하나이다.
    태그들을 이용해서 데이터를 나타내는데 
    html과 마찬가지로 데이터를 표현할수있는 한가지 방법이다.

    서버와 데이터를 주고 받을때는 xml뿐만 아니라 
    굉장히 다양한 파일포맷을 전달받을수 있는데..
    제이슨을 요즘에 많이 쓰고있다.

    그런데 왜 xml이라는 이름이 지어졌냐?
    그것은 바로 AJAX와 XHR이 활발히 개발되고 쓸 당시
    마이크로소프트사에 있는 아웃룩을 만드는 개발팀이
    활발히 참여해서 만들게 되었는데
    이때 아웃룩은 서버와 클라이언트 데이터 전송을 할때
    XML을 사용했는데 그래서 xml을 HttpRequest앞에다가
    붙여서 개발을 하게되어 XMLHttpRequest 즉 XHR이 된것이다.
    
    데이터를 주고받을때는 xml 뿐만 아니라 다양한 타입의
    데이터를 주고받을수 있기 때문에 xml이라고 이름앞에
    지은것은 굉장히 큰 실수 같은데.. 이것을 통해서
    우리가 함수나 클래스 오브젝트의 이름을 정할때
    특히 외부로 노출되는 api를 만들때는 api의 이름을
    명료하게 잘 지어야 된다는 교훈을 얻을수가 있다..

    다시 브라우저로 돌아와서.. 브라우저에서 서버와
    통신을 할때는 우리가 새로 추가된 fetch()라는 API를
    사용할수도 있고 아니면 요즘도 흔하게 많이 쓰여지고있는
    XHR 오브젝트를 이용해서 서버와 통신을 할수도있다.

    이 xml을 사용하면 불필요한 태그들이 너무 많이 들어가서
    파일의 사이즈도 커질뿐만 아니라 가독성도 좋지않아
    이제 xml은 많이 사용되어지고 있지 않고..

    xml대신에 요즘에는 제이슨을 많이 사용하고 있다!

    JSON: JavaScript Object Notation 의 약자다.
    그러므로 아 자바스크립트 오브젝트와 관련된 파일인가?
    라고 유추할수가 있는데 바로 1999년도 이크마 스크립트
    세번째 버전에 쓰여지는 오브젝트에서 큰 영감을 받아
    만들어진 데이터 포맷이야.

    자바스크립트에서 오브젝트를 보면 
    Object {key: value}
    이렇게 키와 밸류로 이루어져 있는데,
    JSON도 똑같이 키와 밸류로 이루어져 있다.

    제이슨은 브라우저 뿐만 아니라 모바일에서 
    서버와 데이터를 주고받을때, 또는 서버와 통신을 하지않아도
    오브젝트를 시스템에 저장할때도 이 제이슨 데이터 타입을 많이
    이용하고 있다.

    텍스트 위주로 정리를 하자면 
    JSON
    -simplest data interchange format
       데이터를 주고받을때 쓸수있는 가장 간단한 파일 포맷.

    -lightweight text-based structure: 택스트를 기반으로해 가벼워
    -easy to read: 사람 눈으로 읽기도 편하고
    -key-value pairs: 키와 밸류로 이루어진 파일포맷.
    -used for serialization and transmission of data betwwen the
     network the network connection
        데이터를 보통은 서버와 주고받을때 serialization을 위해서 써
        이건 직렬화 하다 라고 직역이 돼.. 그리고 데이터를 전송할때 쓰이고

    -independent programming language and platform
       이게 제일 중요한건데..
       프로그래밍언어나 플랫폼에 상관없이 쓸수있어.
       이 말은 c, cpp, c#, JAVA, python, php, go...
       이런 언어들이나 언어가 쓰여지고 있는 플랫폼에 
       상관없이 거의 대부분의 언어들이 
       제이슨으로 ~~재현된 오브젝트를 다시 그 언어에
       특징에 맞게 오브젝트로 변환하고 오브젝트를
       다시 serialization하는것을 지원해주거나 아니면
       많이 쓰여지고있는 외부 라이브러리를 통해서
       이런것들이 가능하게 돼.

    한가지 예를들면 우리의 웹어플리케이션에 토끼라는
    오브젝트가 있다면 이 토끼 오브젝트의 서버에 전송할 때는
    {key: value} 이렇게 토끼라는 오브젝트를 
    키와 밸류의 스트링 타입으로 변환해서 서버에 전송하게되고
    서버에서 다시 토끼를 받아올때도 {key: value} 
    이렇게 키와 밸류의 스트링 타입으로 토끼를 전송받아와서
    다시 토끼라는 오브젝트로 변환해서 브라우저에 표기하게돼.

    그렇다면 JSON의 공부 방법은?
    1. 오브젝트를 어떻게 직렬화(serialize)해서 JSON으로
    변환할지 
    
    2.그리고 다른 하나는 바로 직렬화된 제이슨을
    어떻게 deserialize해서 오브젝트로 다시 변환할건지
    
    이 두 가지를 중점적으로 공부하면 된다.
*/

// JSON
// JavaScript Object Notation

//tip: 동일한 이름의 함수가 전달되는 매개변수가 차이가있는걸
//     오버로딩 Overloading 이라고 한다.
//함수의 이름은 동일하지만 어떤 파라미터를 전달하냐
//몇개의 파라미터를 전달하냐에 따라
//각각 다른 방식으로 호출이 가능해.

// 1. Object to JSON: 오브젝트를 제이슨으로 변환하는 방법
// stringfy(obj)
let json = JSON.stringify(true); //불리언 타입의 프리미티브 타입도 json으로 변환 가능.
console.log(json); //true로 출력

json = JSON.stringify(['apple', 'banana']);//배열을 변환해보자
console.log(json);//배열타입처럼 보이면서 ''가아니라""로 나와져.["apple","banana"] 출력돼.

const rabbit = {  //rabbit라는 object를 json으로 변환
    name: 'tori',
    color: 'white',
    size: null,
    birthDate: new Date(), //Date라는 오브젝트 정의
    symbol: symbol("id"),//js에만있는 심볼같은 특별한 데이타도 json에 포함안돼.
    jump: () => { //jump라는 함수야.얘는json에 포함안돼.오브젝트에 있는 데이터가 아니기때문이야.
        console.log(`${name} can jump!`);
    },
};//이걸 json으로 변환하면?
json = JSON.stringify(rabbit);
console.log(json);// {}안에 "" 이용해 출력들이될거야.
//좀더 json으로 변환되는걸 통제하고 싶다면
json = JSON.stringify(rabbit, ['name', 'color']);//배열에 프로펄티 이름과 색만 전달하여 json으로 하고싶을때
console.log(json);// {"name":"tori","color":"white"} 만 출력.

//콜백함수 이용한 좀 더 세밀한 통제
json = JSON.stringify(rabbit, (key, value) => {
    console.log(`key: ${key}, value: ${value}`);
    return value; //모든 키와 밸류들이 콜백함수에 전달되는걸 확인 가능 젤첨으로 토끼의 오브젝트를싸고있는 제일 최상의것이 전달됨.
/*
    return key === 'name' ? 'ellie' : value;
    key가 name이 들어오면 무조건 ellie로 설정하고 
    name이 아닌경우에는 원래 오리지널 value로 설정.
    이렇게 좀 더 세밀하게 통제가능.
*/
});
console.log(json);

// 2. JSON to Object: 제이슨을 오브젝트로 변환하는 방법
// parse(json)
console.clear();
json = JSON.stringify(rabbit); //이렇게 object>json 했었잖아?
const obj = JSON.parse(json, (key, value) => {
    console.log(`key: ${key}, value: ${value}`);
    return key === 'birthDate' ? new Date(value) : value;
}); // 이러면 json>object 끝!parse이용해 변환하고싶은 json을 전달해주기만 하면돼!
console.log(obj);
rabbit.jump();//이건 json으로 변환이 안됐었지?
obj.jump();//그래서 json>obj 만든것에는 jump라는 API가 없어
          // 그래서 이걸 출력하면 에러 발생해.

/*
    토끼라는 오브젝트를 json으로 변환할때는
    함수가 전혀 포함되어있지 않았어.
    데이터들만 json으로 갔다가 다시 json을 obj로
    변환했으니까 당연히 점프메소드는 포함되어있지 않아.
    그래서 obj에는 점프라는 기능이 없어.
    이 점을 유의해서 코딩해야해.
*/
//토끼에 birthDate라는 오브젝트가 있었는데 이건
//Date라는 오브젝트야. 그래서 여기서
//getDate라는 date안에 존재하는 오브젝트를 쓸수있어.
console.log(rabbit.birthDate.getDate());//29라는 숫자가 나와
//반대로 json>obj한 birthDate을 출력하게 되면 에러가 발생해.
//birthDate는 스트링 이기 때문이야.
console.log(obj.birthDate.getDate()); //2021-12-~~~날짜 출력
//json으로 만든 데이터 자체에 있는 스트링이 오브젝트에
//할당이 된거임.

//유용한 사이트
/*
1. JSON Diff : 문제 디버깅 할때 유용
    서버에게 요청했을때 첫번째로 받아온 데이터와
    두번째로 받아온 데이터가 어떤게 다른지 잘 모를때
    그럴때 비교해보면 좋은데 Compare버튼을 누르면
    뭐가 바꼈는지 나와!

2. JSON Beatufier : 
    가끔 서버에서 받아온 json을 복사해서 붙여넣으면
    포맷이 망가지는 경우가 있어.
    물론 비쥬얼스튜디오 코드에서 json 파일을 만들어서
    복사 붙여넣기해서 포맷하면 되지만 
    이런 웹사이트에서 할수도있어.
    붙여넣은 다음에 Beautify 버튼을 클릭하면
    포맷이 이쁘게 만들어지는걸 볼수있어.

3. JSON Parser :
    json 타입을 object 형태로 확인해 보고싶을때 사용.
    왼쪽에 json을 붙여넣고 JSON Parser버튼을 누르면
    json으로부터 오브젝트가 어떻게 표기되어지는지
    눈으로 쉽게 확인할수가 있어.

4. JSON Validator :
    이렇게 json을 붙여넣어서 Validate를 누르면
    아 이것은 유용한 json 데이터야
    내가 만약에 여기서 콤마 하나를 빼먹었다.
    여기서 validate를 누르면 어 여기서 문제가생겼네?
    이런걸 나타내줘.
    그래서 약간 json이 이상할때 이런곳에 와서
    확인해보면 좋아.

실제로 현업에서 프로젝트를할때는 회사마다 다르겠지만
json 데이터가 굉장히 클수가있어.
그래서 여러방식을 통해 최대한 서버와 주고받는
데이터의 양을 줄여서하는 트릭들이 많이있으니 
공부해보자.
*/