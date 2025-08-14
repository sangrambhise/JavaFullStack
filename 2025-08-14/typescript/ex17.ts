class Calculator {
  addition(a: number, b: number): number {
    return a + b;
  }

  subtraction(a: number, b: number): number {
    return a - b;
  }
}

const a = new Calculator();
console.log(a.addition(100010, 99995))
console.log(a.subtraction(293300, 1425));