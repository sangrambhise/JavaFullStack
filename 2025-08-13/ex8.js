const employees = [
    { name: "Ramesh", role: "Manager", id: 101, salary: 70000 },
    { name: "Jitesh", role: "Developer", id: 102, salary: 50000 },
    { name: "Lavesh", role: "QA", id: 103, salary: 50000 },
    { name: "Raju", role: "Manager", id: 104, salary: 95000 },
    { name: "Birju", role: "Developer", id: 105, salary: 71000 },
    { name: "Pankaj", role: "Manager", id: 106, salary: 100000 }
];
const managers = employees.filter(emp => emp.role == "Manager").reduce((total, emp) => total + emp.salary, 0);
console.log(managers);
