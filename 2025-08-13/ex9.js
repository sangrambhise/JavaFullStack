const persons = [
  { name: "Ritik", age: 19, city: "Raipur" },
  { name: "Ramesh", age: 18, city: "Chennai" },
  { name: "Prathamesh", age: 16, city: "Jaipur" },
  { name: "Mitesh", age: 14, city: "Delhi" },
  { name: "Jitesh", age: 29, city: "Kolkata" }
];
const res = [];
for (let i = 0; i < persons.length; i++) {
  const person = persons[i];
  const l1 = {
    name: person.name,
    age: person.age,
    city: person.city,
    status: person.age >= 18 ? "Adult" : "Minor"
  };
  res.push(l1);
}
console.log(res);
