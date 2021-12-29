function solution(numbers, hand) {
  //핸드폰 좌표
  const coordinate = {
    1: [0, 3], 2: [1, 3], 3: [2, 3],
    4: [0, 2], 5: [1, 2], 6: [2, 2],
    7: [0, 1], 8: [1, 1], 9: [2, 1],
    "*": [0,0], 0: [1, 0], "#": [2, 0],
  };

  let answer = "";
  let left_thumb = "*"; // 왼쪽 엄지 위치
  let right_thumb = "#"; // 오른쪽 엄지 위치

  for (let i = 0; i < numbers.length; i++) {
    // 1, 4, 7은 나머지가 1
    if (numbers[i] % 3 === 1) {
      answer += "L";
      left_thumb = numbers[i];
      // 0을 제외한 3, 6, 9는 나머지가 0
    } else if (numbers[i] !==0 && numbers[i] % 3 === 0) {
      answer += "R";
      right_thumb = numbers[i];
    } else {
      // 거리 비교
      // 왼쪽 엄지의 좌표
      const left_coordinate = coordinate[left_thumb];
      // 오른쪽 엄지의 좌표
      const right_coordinate = coordinate[right_thumb];
      // 현재 눌러야 하는 숫자의 좌표
      const target_coordinate = coordinate[numbers[i]];

      // 왼쪽 엄지와 타겟 좌표의 거리
      const left_target_distance = Math.abs(left_coordinate[0] 
        - target_coordinate[0]) + Math.abs(left_coordinate[1] - target_coordinate[1])

      // 오른쪽 엄지와 타겟 좌표의 거리
      const right_target_distance = Math.abs(right_coordinate[0]
        - target_coordinate[0]) + Math.abs(right_coordinate[1] - target_coordinate[1])

      // 왼쪽 엄지가 타겟번호와 가까움(누르는게 왼쪽)
      if (left_target_distance < right_target_distance) {
        answer += "L";
        left_thumb = numbers[i];

        // 오른쪽 엄지가 가까움
      } else if (left_target_distance > right_target_distance) {
        answer += "R";
        right_thumb = numbers[i];
      } else {
        // 왼쪽, 오른쪽 엄지가 타겟과의 거리가 같은 경우
        // 왼손잡이면 왼쪽 엄지로 누른다.
        if (hand === "left") {
          answer += "L";
          left_thumb = numbers[i];
          // 오른손 잡이면 오른쪽 엄지로 누른다.
        } else {
          answer += "R";
          right_thumb = numbers[i];
        }
      }
    }
  }
  return answer;
}