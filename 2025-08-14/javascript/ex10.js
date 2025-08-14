function sum1(...numbers) {
  return numbers.reduce((total, num) => total + num, 0);
}
console.log(sum1(20,100,40)); 
