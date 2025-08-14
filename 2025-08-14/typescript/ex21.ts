class Box<T> {
  private value: T;

  constructor(value: T) {
    this.value = value;
  }

  getValue(): T {
    return this.value;
  }
}

const str1 = new Box<string>("Hi There");
console.log(str1.getValue());
const num1 = new Box<number>(1000);
console.log(num1.getValue());