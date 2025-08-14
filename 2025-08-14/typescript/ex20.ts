function pair<T, U>(first: T, second: U): [T, U] {
    return [first, second];
}
const a = pair<string, number>("Phone Number", 9753026754);
console.log(a);
const b = pair<boolean, number[]>(true,[20.32,64.12,20.98] );
console.log(b);
const c = pair<number[], string[]>([19,67,63], ["Raman", "Ritik","Jatin"]);
console.log(c);
