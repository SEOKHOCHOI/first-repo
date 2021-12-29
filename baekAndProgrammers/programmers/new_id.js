function solution(new_id) {
  let answer = new_id;
  answer = answer.toLowerCase(); // 대문자 -> 소문자
  answer = answer.replace(/[^a-z0-9-_.]/g, "");  // replace는 문자열 치환
  answer = answer.replace(/\.+/g, ".");
  answer = answer.replace(/^\.|\.$/g, "");

  if (answer === "") {
    answer += "a";
  }

  if (answer.length > 15) {
    answer = answer.substring(0, 15);
  }
  answer = answer.replace(/\.$/, "");

  while (answer.length < 3) {
    answer += answer.charAt(answer.length - 1);
  }
  return answer;
}