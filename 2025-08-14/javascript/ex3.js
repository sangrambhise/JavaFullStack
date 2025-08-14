class Util {
static getDate() {
  const today = new Date();
  const dd = ('0' + today.getDate()).slice(-2);
  const mm = ('0' + (today.getMonth() + 1)).slice(-2);
  const yyyy = today.getFullYear();
  return `${dd}-${mm}-${yyyy}`;
}

  static getPIValue() {
    return Math.PI;
  }

  static convertC2F(celsius) {
    return (celsius * 9/5) + 32;
  }

  static getFibonacci(n) {
    if (n <= 0) return [];
    if (n === 1) return [0];
    const fib = [0, 1];
    for (let i = 2; i < n; i++) {
      fib.push(fib[i - 1] + fib[i - 2]);
    }
    return fib;
  }
}
console.log("Date ", Util.getDate());
console.log("PI's value is ", Util.getPIValue());
console.log("°F ", Util.convertC2F(25));
console.log("Fibonacci numbers ", Util.getFibonacci(5));
