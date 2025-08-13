const cities = ["Delhi", "Mumbai", "Kolkata", "Bengaluru", "Chennai"];

function dropDown() {
  const dropdown = document.getElementById("dropDownCity");
  dropdown.length = 1;
  const sortedCities = cities.slice().sort();
  for (let i = 0; i < sortedCities.length; i++) {
    const city = sortedCities[i];
    const option = document.createElement("option");
    option.text = city;
    dropdown.add(option);
  }
}
