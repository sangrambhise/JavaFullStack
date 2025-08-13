function isPalindrome(str) {
  const str1 = str.toLowerCase();
  const str2 = str1.reverse();
  return str1 === str2;
}
console.log(isPalindrome("Racecar"));
console.log(isPalindrome("Hello"));
