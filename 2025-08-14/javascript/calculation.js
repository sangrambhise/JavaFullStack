import { multiply, divide } from './operations.js';
console.log(multiply(25, 5)); 
try {
  console.log(divide(10, 0));
} catch (error) {
  console.error(error.message);
}
