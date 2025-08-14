function updateStatus() {
  const userId = localStorage.getItem("userId");
  const status = document.getElementById("status");
  if (userId) {
    status.textContent = `Logged in as ${userId}`;
  } else {
    status.textContent = "Not logged in yet";
  }
}

function login() {
  const userId = document.getElementById("userId").value;
  const password = document.getElementById("password").value;
  if (userId && password) {
    localStorage.setItem("userId", userId);
    updateStatus();
  } else {
    alert("Please enter both User ID and Password");
  }
}

function logout() {
  localStorage.removeItem("userId");
  updateStatus();
}

window.onload = updateStatus;
