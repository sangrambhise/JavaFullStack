class Stack<T> {
  private items: T[] = [];

  push(item: T): void {
    this.items.push(item);
  }

  pop(): T | undefined {
    return this.items.pop();
  }

  peek(): T | undefined {
    return this.items[this.items.length - 1];
  }

}

const stackNum = new Stack<number>();
stackNum.push(27);
stackNum.push(39);
stackNum.push(41);
console.log(stackNum.peek());  
console.log(stackNum.pop());

