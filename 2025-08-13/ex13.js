function validEmail() {
  const emailInput = document.getElementById("email");
  const emailError = document.getElementById("emailError");
  const email = emailInput.value.trim();
  const emailPattern = /^[^ ]+@[^ ]+\.[a-z]{2,3}$/;
  if (email === "") {
    emailError.innerText = "Email is required.";
    return false;
  } else if (!emailPattern.test(email)) {
    emailError.innerText = "Enter a valid email.";
    return false;
  } else {
    emailError.innerText = "";
    return true;
  }
}

function validPass() {
  const pinput=document.getElementById("password");
  const perror=document.getElementById("passwordError");
  const password=pinput.value.trim();
  if (password==="") {
    perror.innerText = "Password is required.";
    return false;
  } else {
    perror.innerText = "";
    return true;
  }
}

function handleLogin() {
  const emailValid=validEmail();
  const passwordValid=validPass();
  if (emailValid && passwordValid) {
    alert("Login successful!");
  } else {
    console.log("Validation failed");
  }
}
