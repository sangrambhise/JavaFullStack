export function multiply(a, b) {
  return a * b;
}

export function divide(a, b) {
  if (b === 0) {
    throw new Error("divide by zero error");
  }
  return a / b;
}
