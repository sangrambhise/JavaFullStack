function separateFirstRest(...args) {
  const [f1, ...rest] = args;
  return {
    f1: f1,
    rest: rest
  };
}
console.log(separateFirstRest(96, 46, 34, 20,21)); 