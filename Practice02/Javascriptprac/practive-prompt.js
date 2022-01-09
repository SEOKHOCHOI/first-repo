let aaa;
aaa = 5;
console.log(aaa);
aaa = 8;
console.log(aaa);

const bb;
console.log(bb);
// bb = 5; // 에러 -> 상수 이기때문에 선언과 동시 초기화

// window.prompt() // 다이얼로그 박스에 입력창
// prompt("프롬프트 다이얼로그에 표시될 문자열")

const promptMessage = "프롬프트에 표시될 문자열";
const result = prompt(promptMessage);
console.log(result);
// 사용자가 입력한 문자열 값이 result에 들어감.
