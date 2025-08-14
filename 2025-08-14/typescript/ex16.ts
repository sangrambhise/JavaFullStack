interface Employee {
  eId: number;
  eName: string;
  salary: number;
}

const employees: Employee[] = [
  { eId: 101, eName: "Raman", salary: 68000 },
  { eId: 102, eName: "Ritik", salary: 49000 },
  { eId: 103, eName: "Chandu", salary: 95000 },
];

function display(empList: Employee[]): number {
  for (let i = 0; i < empList.length; i++) {
    const emp = empList[i];
    console.log(`ID is ${emp.eId}, Name is ${emp.eName}, Salary is ${emp.salary}`);
  }
  return empList.length;
}

const total = display(employees);
console.log(`Total employees ${total}`);
