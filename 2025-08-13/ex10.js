const persons = [
    { name: "Ritik", age: 19, city: "Raipur" },
    { name: "Ramesh", age: 18, city: "Chennai" },
    { name: "Prathamesh", age: 16, city: "Jaipur" },
    { name: "Mitesh", age: 14, city: "Delhi" },
    { name: "Jitesh", age: 29, city: "Kolkata" }
];

const res = persons.map(person => ({
  name: person.name,
  age: person.age,
  city: person.city,
  status: person.age >= 18 ? "Adult" : "Minor"
}));

console.log(res);
