const names = ["Kush", "Mahesh", "Jitesh", "Prathamesh", "Digesh", "Lavesh", "Jayesh"];
const longNames = names.filter(name => name.length > 5);
const upperCaseNames = longNames.map(name => name.toUpperCase());
console.log(names);
console.log(upperCaseNames);
