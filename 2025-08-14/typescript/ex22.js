var Stack = /** @class */ (function () {
    function Stack() {
        this.items = [];
    }
    Stack.prototype.push = function (item) {
        this.items.push(item);
    };
    Stack.prototype.pop = function () {
        return this.items.pop();
    };
    Stack.prototype.peek = function () {
        return this.items[this.items.length - 1];
    };
    return Stack;
}());
var stackNum = new Stack();
stackNum.push(27);
stackNum.push(39);
stackNum.push(41);
console.log(stackNum.peek());
console.log(stackNum.pop());
