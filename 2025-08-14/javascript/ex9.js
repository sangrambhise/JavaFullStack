function sum(a, b, c) {
  return a + b + c;
}
const arr = [1, 2, 3];
const res = sum(...arr);
console.log("Sum of array ", res);
