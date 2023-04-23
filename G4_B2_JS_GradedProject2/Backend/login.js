const LoggedIn = sessionStorage.getItem("userLoggedIn");

function checkLogin(LoggedIn, hrefUrl) {
  if (LoggedIn) {
    alert("user already authenticated!");
    window.location.replace(hrefUrl);
  }
}
checkLogin(LoggedIn, "./resume.html");

const userDetails = {
  username: "admin",
  password: "admin@123",
};

localStorage.setItem("userCred", JSON.stringify(userDetails));
const getCred = JSON.parse(localStorage.getItem("userCred"));

const passVer = () => {
  const user = document.getElementById("username").value;
  const password = document.getElementById("password").value;
  const loginForm = document.getElementById("loginForm");

  if (user == "" && password == "") {
   alert("Please enter username and password!");
  } else if (getCred["username"] == user && getCred["password"] == password) {
    sessionStorage.setItem("userLoggedIn", true);
    window.location.replace("./resume.html");
  } else {
    loginForm.reset();
    alert("Incorrect password or username!");
  }
};

document.getElementById("submitbutton").addEventListener("click", passVer);
