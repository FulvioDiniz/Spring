function login() {
    var email = document.getElementById("email").value;
    var senha = document.getElementById("senha").value;

    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function() {
        if (this.readyState == 4 && this.status == 200) {
            // Handle the response from the server-side function
        }
    };
    xhttp.open("POST", "/login/login", true);
    xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    xhttp.send("email=" + email + "&senha=" + senha);
}
