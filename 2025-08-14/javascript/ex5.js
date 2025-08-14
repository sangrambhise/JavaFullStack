class Vehicle {
  constructor(make, model, year) {
    this.make = make;
    this.model = model;
    this.year = year;
  }
  getInfo() {
    return `Make: ${this.make}, Model: ${this.model}, Year: ${this.year}`;
  }
}

class Car extends Vehicle {
  constructor(make, model, year, numDoors) {
    super(make, model, year);
    this.numDoors = numDoors;
  }
  getInfo() {
    return `${super.getInfo()}, Doors: ${this.numDoors}`;
  }
}

const car1 = new Car("Toyota", "Fortuner", 2011, 4);
console.log(car1.getInfo());
