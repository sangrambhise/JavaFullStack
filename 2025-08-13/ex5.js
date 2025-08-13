var a1 = 10;
let b1 = 20;
const c1 = 30;
console.log("global scope");
console.log("a1 =", a1);
console.log("b1 =", b1);
console.log("c1 =", c1);
function scope() {
    a1 = 100;
    var a2 = 1;
    let b2 = 2;
    const c2 = 3;
    console.log("inside function");
    console.log("a1 =", a1);
    console.log("a2 =", a2);
    console.log("b2 =", b2); 
    console.log("c2 =", c2);
    if (true) {
        var a2 = 11
        let b2 = 22;
        const c2 = 33;
        console.log("if block");
        console.log("a2 =", a2);
        console.log("b2 =", b2);
        console.log("c2 =", c2);
    }
    console.log("after if block(but inside)");
    console.log("a2 =", a2);
    console.log("b2 =", b2);
    console.log("c2 =", c2);
}
scope();
console.log("outside function");
console.log("a1 =", a1);
console.log("b1 =", b1);
console.log("c1 =", c1);
