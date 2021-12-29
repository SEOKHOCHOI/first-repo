const { arrayBuffer } = require('stream/consumers');

function solution(s) {
  let numbers = ['zero', 'one', 'two', 'three', 'four', 'five', 'six', 'seven', 'eight', 'nine'];
  let arr = [...s];
  let alphabet = [];

  if(!isNaN(s)) return Number(s);
  for (let i = 0; i < arr.length; i++) {
    if (isNaN(arr[i])) {
      alphabet.push(arr[i]);
    } else {
      continue;
    }
    let str = alphabet.join('')
    for (let j = 0; j < numbers.length; j++) {
      if (str === numbers[j]) {
        s = s.replace(str, j);
        alphabet = [];
      }
    }
  }
  return +s;
}

solution('432one')


// function solution(s) {
//   let numbers = ["zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"];
//   var answer = s;

//   for(let i=0; i< numbers.length; i++) {
//       let arr = answer.split(numbers[i]);
//       answer = arr.join(i);
//   }

//   return Number(answer);
// }