const persons = [
    { name: "Ritik", age: 19, city: "Raipur" },
    { name: "Ramesh", age: 18, city: "Chennai" },
    { name: "Prathamesh", age: 16, city: "Jaipur" },
    { name: "Mitesh", age: 14, city: "Delhi" },
    { name: "Jitesh", age: 29, city: "Kolkata" }
];
const eligibleVoters = persons.filter(person => person.age >= 18);
console.log(eligibleVoters);

