const fs = require('fs');
const inputData = fs.readFileSync('/dev/stdin').toString().split('\n');

const Num1 = inputData[0];
const Num2 = inputData[1];

const oneNum = Num2 % 10;
const tenNum = Math.floor((Num2 % 100) / 10);
const hundredNum = Math.floor(Num2 / 100);

console.log(Num1 * oneNum);
console.log(Num1 * tenNum);
console.log(Num1 * hundredNum);
console.log(Num1 * Num2);

// Error: ENOENT: no such file or directory, open '/dev/stdin'