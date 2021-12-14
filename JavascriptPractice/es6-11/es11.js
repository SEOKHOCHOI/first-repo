// 1. Optional Chaining
/*
    console.log(person.job?.manager?.name);
*/
/*
    //첫번째 오브젝트
    const person1 = {
        name: 'Ellie',
        job: {
            title: 'S/W Engineer',
            manager: {
                name: 'Bob',
            },
        },
    };
    //두번째 오브젝트
    const person2 = {
        name: 'Bob',
    };

    job안에는 title도 있고 manager라는 또다른 오브젝트도
    들어가있다. 그리고 매니져의 이름은 Bob이다.

    person2는 아직 일을 구하지 못해서 job이 없는 상태다.

    // 나쁜함수1, 만약 이런 함수를 구현했다면 어떻게 될까?
    function printManager(person) {
        console.log(person.job.manager.name);
    }
    printManager(person1); //person1은 job도있고 manager도 있어 문제없이 출력돼.
    printManager(person2); //매니져가 존재않아서 얘는 오류나

    // 나쁜함수2
    function printManager(person) {
        console.log(
            person.job
            ? person.job.manager
              ? person.job.manager.name
              : undefined
            :undefined
        );
    }
    printManager(person1);
    printManager(person2);

    // 나쁜함수3
    function printManager(person) {
        console.log(person.job && person.job.manager && person.job.manager.name);
    //person의job가 있으면 person의 job의 manager가 있으면 그러면 person의 job의 manager의 name을 출력하는방식.
    }
    printManager(person1);
    printManager(person2);

    // 옵셔널체이닝! 좋은코드!
    function printManager(person) {
        console.log(person.job?.manager?.name);
        //person의 job이 있으면 manager가 있으면 name을 출력한다는 뜻.
    }
    printManager(person1);
    printManager(person2);
 */

// 2. Nullish Coalescing Operator
/*
    const name = '';
    const userName = name ?? 'Guest';
    console.log(userName);

    const num = 0;
    const message = num ?? 'undefined';
    console.log(message);
*/

/*
    // Logical OR operator
    const name = 'Ellie';
    const userName = name || 'Guest';
    console.log(userName);

    OR 연산자를 이용하면 깔끔하게 코딩할수있어.
    이런 OR이나 and연산자를 이용할때는 false의
    특징을 이해할 필요가 있어. 무엇이 false일지!

    즉, OR연산자는 name || 'Guest'에서
    앞에있는 name이 false일때만 뒤의 Guest가
    실행이돼.

    name이라는 값이 들어있으므로 즉, false가 아님으로
    Guest는 실행안되고 name의 값이 출력되어 지는걸
    확인할수있어.

    반대로
    const name = null;
    const userName = name || 'Guest';
    console.log(userName);

    name에 null이 할당이 되면 null은 false이므로
    뒤에있는 Guest가 할당이 되어서 Guest가 출력이 돼!.

    그래서 많은 개발자들이 어떤 특정한 값이 
    null이라면.. 정해져있지 않다면.. 기본적인 값을
    할당하도록 OR연산자를 많이 이용했지만..

    name이 null이거나 언디파인 일 경우
    즉, 아무런것도 지정되어져있지 않은 경우에만
    Guest를 할당하고 싶은데 '' 이렇게 문자열이 비어있는
    경우에도 false로 간주되기 때문에
    Guest가 할당이 되는것을 볼수가 있다.

    즉, 사용자가 아무런 이름을 쓰고 싶지 않을때
    그럴때도 Guest를 할당이 되는 참사를 맛볼수가있어.

    다른 예로는
    const name = 0; 이렇게 숫자가 0으로 지정이
    되어져 있음에도 불구하고 num || 'undefined';에서
    undefined으로 나오는걸 볼수가 있따.
    숫자 0이 할당 되었지만 0은 false로 간주되기 때문에
    뒤에것이 할당되는것이다.

    //그래서 조금더 명확하게 코딩하고 싶을때는
    //좋은코드 Nullish Coalescing이용
    const name = '';
    const userName = name ?? 'Guest';
    console.log(uerName);

    name ?? 'Guest'는 name이 있다면 이름을쓰고
    이름에 아무런 값이 없다면 Guest를 이용하자는 뜻이다.

    const num = 0;
    const message = num ?? 'undefined';
    console.log(message);

    이 경우엔 텅텅 비어진 문자열과 
    0이 출력되어지는걸 확인할수있다!
*/