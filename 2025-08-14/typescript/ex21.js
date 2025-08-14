var Box = /** @class */ (function () {
    function Box(value) {
        this.value = value;
    }
    Box.prototype.getValue = function () {
        return this.value;
    };
    return Box;
}());
var str1 = new Box("Hi There");
console.log(str1.getValue());
var num1 = new Box(1000);
console.log(num1.getValue());
