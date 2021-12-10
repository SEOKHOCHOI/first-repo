// 알아두면 도움되는 유용한 배열 API

// Q1. make a string out of an array
//     주어진 배열을 스트링으로 변환하라.
// 사용 API: join 함수
// 배열에 있는 모든 애들을 더해 스트링으로 리턴하는것!
{
    const fruits = ['apple', 'banana', 'orange']; //주어진 배열임
    const result = fruits.join(); //(여기에 구분자 넣어도 안넣어도ok)
    console.log(result); // apple,banana,orange  딱 이렇게 출력됨.
    
    const result = fruits.join(', and '); //구분자를 원하는 방식으로 넣어주며..
    console.log(result); // apple, and banana, and orange  딱 이렇게 출력돼.
}

// Q2. make an array out of a string
//      주어진 string을 array로 변환하라. 
// 스트링 안에 있는 유용한 API: split 사용.
// split은 구분자인 separator, limit(얘는해도되고 안해도돼) 총 2가지 파라미터를 전달받아.
{
    const fruits = '사과, 키위, 바나나, 체리'; //주어진 스트링
    const result = fruits.split(','); //콤마단위로 나눈다는 표시()에 해줌
    console.log(result);// ["사과", " 키위", " 바나나", " 체리"] 그대로 출력됨.

    const result = fruits.split(',', 2); //limit파라미터사용! 첫번째 2개의 배열 전달받고 싶다!
    console.log(result); //["사과", " 키위"] 이대로 출력됨.

    const result = fruits.split();//필수적으로 해줘야하는 구분자를 안해주면?
    console.log(result);//["사과, 키위, 바나나, 체리"] 이대로 출력돼. 문자열 전체가 배열 한곳에 들어가버려.
}

// Q3. make this array look like this: [5, 4, 3, 2 ,1]
//     주어진 배열의 순서를 거꾸로 만들어라!
// array안의 API: reverse 사용.
{
    const array = [1, 2, 3, 4, 5]; //주어진 배열
    const result = array.reverse(); // 거꾸로!!
    console.log(result); // [5, 4, 3, 2, 1] 그대로 출력
    
    //위에서 리턴된 배열의 값이 순서가 바꼈는데 사실은
    //이 함수를 호출한 array.. 배열자체도 순서가 바껴있어.
    console.log(array);// [5, 4, 3, 2, 1] 그대로 출력

    //그러니 reverse는 배열자체를 변화시키고
    //리턴값도 변화된 배열자체를 리턴하는구나
    //라고 이해하면 돼.
}

// Q4. make new array without the first two elements
//    주어진 배열에서 1,2번째 요소를제외한 새로운배열 만들기
// splice는 배열 자체에서 데이터를 삭제하게되는거 기억하지?
// 하지만 문제는 변형이 아닌 새로운 배열을 만드는거야 splice는 그래서 안돼.
// API: slice 사용  
//    배열의 특정한 부분을 리턴하는 애야.
//    배열의 시작idex인 start와 어디까지할건지의 index인 end로 ()안에 지정 가능하고 둘다 써도되고 안써도돼.
//    end는 exclusive해서0,2면 2는 제외하고 0부터 1까지만 전달돼.
{
    const array = [1, 2, 3, 4, 5];
    const result = array.splice(0, 2); //0번부터 2개를삭제
    console.log(result); //[1, 2]  , 삭제된게 출력됨
    console.log(array); // [3, 4, 5] , 남은게 출력됨

    const result = array.slice(2, 5)//즉 2번째부터 4까지 받아와
    console.log(result); // [3, 4, 5] 출력돼.
    console.log(array); // 그대로 [1, 2, 3, 4, 5] 출력돼.

    //즉, splice는 배열 자체를 수정하지만
    // slice는 배열에서 원하는 부분만 return해서 받아와.
}

//앞으로 나오는 퀴즈는 밑에 class를 이용할것이다.
//이름,나이,수업등록했는지안했는지,점수 총 네가지의 프로퍼티즈가 들어있다.
class Student {
    constructor(name, age, enrolled, score) {
        this.name = name;
        this.age = age;
        this.enrolled = enrolled;
        this.score = score;
    }
}
const students = [
    new Student('A', 29, true, 45),
    new Student('B', 28, false, 80),
    new Student('C', 30, true, 90),
    new Student('D', 40, false, 66),
    new Student('E', 18, true, 88),
]

// Q5. find a student with the score 90, 점수가90점인 학생을 찾아라!
// API: find
// predicate, thisArg디스알규먼트 두가지 인자 전달됨.
// predicate는 함수고 콜백함수받아 함수에는(this,value,index,obj)네가지 인자 전달되고
// 값이 불리언값으로 정의되는 함수를 전달해주면돼.
// find는 첫번째로 찾아진 요소를 리턴해
// predicate가 true일때 즉, 전달된 콜백함수가 트루가되면 (나중에 호출할게~ 라고해서 콜백함수라 불려짐)
// 찾자마자 찾아진 아이를 리턴, 찾지 못하면 undefined 리턴
// predicate 콜백함수는 배열에있는 모든 요소들마다 순차적으로 호출이 되어져.
// 그래서 이 호출되어지는 콜백함수가 true리턴시
// 바로 함수를 멈추가 true가된 그 요소를 return해.
{
    //value라는걸 student안에 들어있는 모든학생들..
    //student=value=item 뭐로든 불러도돼 펑션의 ()안에..
    const result = students.find(function(student, index) {
        console.log(student, index);
        //총 다섯명의 학생이 있으니 다섯번 호출돼 출력될것이다.
        /* 한 명만 예를 들면
            Student {name: "A", age: 29, 블라블라 led: true, sore:45}
            0  <<얘는 인덱스.
        */
       //const result = students.find((student) => student.score === 90);
       //에로우 펑션 쓰면 이렇게돼.

        return student.score === 90; //90이면 return이 true
        //콜백함수가 리턴을 트루로 하게되면 당장 find 메소드가 멈추게되고
        //첫번째로 트루가된 스튜던트를 리턴하게돼.
        //여기선 세번째에서 90점이니 3번째 스튜던트가 리턴되며 find함수가 멈춰.
    });
    console.log(result); //3번재놈 출력돼.
} 

// Q6. make an array of enrolled students
//    학생들중 수업에 등록한 학생들만 골라내어 배열을 만들어
// API: filter
// 콜백함수 전달해서 콜백함수가 true인 아이들만 모아
// 새로운 배열을 전달해주는 그런아이임.
{
    const result = students.filter((student) => student.enrolled);
    //enrolled이 되면 true니까 true된 아이들만 전달받는것.
    console.log(result); // 총3명의 학생이 출력돼 A,C,E 얘네야
}

// Q7. make an array containing only the students' scores
//    학생들의 배열에서 점수만 쏙쏙 뽑아와서 점수만 들어있는 새로운 배열을 만들자.
// result should be: [45, 80, 90, 66, 88]
// students안에 API: map
/*
    students안에 있는 배열을 맵핑을 할건데 map 이라는건
    배열안에 들어있는 요소 한가지 한가지를
    다른것으로 변환해 주는 것이다.

    1, 2, 3 세가지 아이템이 든 배열이 있다치면
    맵은 지정된 콜백함수를 호출하면서 1,2,3 각각의 요소들이
    함수를 거쳐서 새로운 값으로 변환하는것을 말한다.
    우리가 전달한 콜백함수가 어떤일을 하느냐에 따라서
    1,2,3 이 다른값으로 맵핑되어져 만들어진다. 
    펑션 fn이 *2 를 해주는 함수라면 1,2,3이 각각 2,4,6이 된다.

    이 문제에선 주어진 students라는 오브젝트를
    바로 score로만 변환해서 만들면 돼.
*/
{
    const result = students.map((student) => student);
    console.log(result);//전달한 펑션이받은값을 그대로 리턴했으니 똑같이 총 5명의 학생이 들어있음.

    const result = students.map((student) => student.score);//이래야 점수만 리턴돼.
    console.log(result); // 점수만 들어있음 배열이 나와
    //student.score *2 해주면 2배가된 점수가 나올거야.
    //그리고 콜백함수로 전달되는 인자는 value, item 
    //이런거 말고 최대한 이해하기 쉽게 지금처럼 student 이런식으로 써.
}

// Q8. check if there is a student with the score lower than 50
//    확인해라 점수가 50점보다 낮은학생이 학생들중 있는지없는지
//    true가 리턴되게 만들면 되겠지?
// 배열에 있는 API: some 이용
//   some은 배열의 요소중에서 콜백함수가 return이 true가 되는애가 
//   있는지 없는지 확인해 주는것.
{
    console.clear();
    const result = students.some((student) => student.score < 50);
    console.log(result); // true 라고 출력
    //콜백함수는 배열에있는 요소들 하나하나 다 시행이 되는데
    //학생들중 50점보다 낮은학생이 한 명이라도 있으면
    //true가 return이 되는것

    //every: 배열의 모든 요소들이 조건을 충족해야 true를 리턴
    const result2 = students.every((student) => student.score < 50);
    console.log(result2);//모두50밑은 아니니 false 출력

    //every를 써서 문제를 풀고싶다면 이렇게!
    const result3 = !students.every((student) => student.score >= 50);
    console.log(result3);
    //50점보다 낮은아이 있는지 없는지 판단후 있으니 모든학생들이 50점보다 높다면
    //true가 되어 !로 인해 false로 변경, 낮은애가 있다면 false가 되어 true로 변경돼.
}

console.clear(); 
// Q9. compute students' average score
//    학생들의 평균점수를 구하라.
//배열에 있는 API: reduce 이용.
// callback함수를 전달하고 또는 initialValue를 전달할수도 있다.
// callback 함수는 배열안의 모든 요소들마다 호출이된다.
// callback 함수에서 return 되는 값은 함께 누적된 그 결과값을 return한다.
// 즉, 뭔가 함께 모아놓을때 쓰는거구나~ 하고 감을 잡으면 돼.

//reduce는 우리가 원하는 시작점부터 모든 배열을 돌면서
//어떤 값을 누적할때 쓰는거구나~ 라고 보면돼.
{
const result = students.reduce((prev, curr) => {
    console.log('------'); //연속해나오니 구분위해..
    console.log(prev);// prev는 우리가 밑에 return한 값이 다음에 호출될때 prev로 연결되어져
                      // 즉, 우리가 리턴하는 값들이 순차적으로 prev로 전달되는거야.

    console.log(curr);// curr은 배열하나하나씩 순차적으로 curr에 전달돼.
    return prev + curr.score; //여기서 콜백함수는 리턴값을 해줘야해.
}, 0);//0부터 시작,이거안적으면 A부터 시작이었음.
    console.log(result); //최종적으로 369 출력

/*  reduceRight 은 배열의 제일 뒤에서부터 시작하는것.
    순서가 거꾸로 호출되어져.
*/
//위의 것들을 간단하게 만들면 
const result = students.reduce((prev, curr) => prev + curr.score, 0);
console.log(result / students.length);//평균값을 구해야하니 총 갯수를 나눠줘.
}

// Q10. make a string containing all the scores
//     학생들의 모든 점수를 스트링으로 변환하여 만드는것.
// result should be: '45, 66, 80, 88, 90'
// 위에서 쓴 애들을 묶어서 써보자!
// map, 
{
    //1. 학생들의 배열을 먼저 점수로 변환해야하니 맵핑
    //   점수들만 들어있는 배열이 만들어짐.
/*      const result = students.map((student) => student.score);
        console.log(result); // [45, 80, 90, 66, 88] 출력돼.
*/
    //2. 그 리턴된 배열에 있는 join을 쓰게되면 string으로 바껴
/*
        const result = students.map((student) => student.score).join(); //끝에요거..
        console.log(result); // 45,80,90,66,88 출력돼.
*/
//map이나 이런아이들은 서로 배열 그 자체를 return 하기때문에
//이렇게 오퍼레이션들을.. API를 섞어서 호출할수가있어.

//여기서만약 점수가 50점 이상인 아이들만 출력하고 싶다면?
// 똑같이 filter을 이용! 최종적으로 다 적용해서 써주면..
    const result = students
        .map((student) => student.score)
        .filter((score) => score >= 50) //50저 이하인 아이들 제외되어 join돼!
        .join();
        console.log(result);
}// 이런10번같은걸 함수형 프로그래밍 이라고 말해.

// Bonus! do Q10 sorted in ascending order
// result should be: '45, 66, 80, 88, 90'
// 학생들으 점수를 정렬해서.. 즉, 낮은점수가
// 제일 먼저 나오게하여 string으로 변환하는것.
// sort: 콜백함수에는 a,b 이전값과 현재값이 전달이돼.
//      만약 - 값을 리턴하게되면 첫번째가 뒤에꺼보다 
//      작다고 간주되어져서 정렬이 돼.
{
    const result = students.map(student => student.score)
    .sort((a, b) => a - b)
    //위의 sort는 학생 a와 b라는 값이 전달이 되는데
    //a에서 b를 뺏을때 즉, b가 a보다 크다면 우리가 원하는대로 솔팅이 될것임.
    .join();//그리고 솔팅된 아이를 조인해서 string으로 변환하면 돼. 
   console.log(result);
   //만약 점수가 큰것이 앞에 나오게 하고싶다고하면
   //반대로 b - a로 해줬으면 돼.
}

//api는 기술 면접에서도 많이 물어보니 잘 외워!