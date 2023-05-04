var meta = document.querySelectorAll('meta')[2];
var body = document.querySelectorAll('body')[0];
var button = document.getElementById("signInB");
var width = screen.width;
function clicks() {
    var inputUsername=document.getElementById("inputUsername").value;
    var inputPassword=document.getElementById("inputPassword").value;
    if (inputUsername=="mohammad"&inputPassword=="123456") {
        window.location.href="/menu.html";
    }
}
meta.setAttribute("content", `width=device-width`);