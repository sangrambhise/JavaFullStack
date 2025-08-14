var employees = [
    { eId: 101, eName: "Raman", salary: 68000 },
    { eId: 102, eName: "Ritik", salary: 49000 },
    { eId: 103, eName: "Chandu", salary: 95000 },
];
function display(empList) {
    empList.forEach(function (emp) {
        console.log("ID is ".concat(emp.eId, ", Name is ").concat(emp.eName, ", Salary is ").concat(emp.salary));
    });
    return empList.length;
}
var total = display(employees);
console.log("Total employees ".concat(total));
