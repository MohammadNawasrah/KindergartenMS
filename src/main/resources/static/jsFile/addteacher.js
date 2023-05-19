
$(document).ready(function() {

var button=document.getElementById("submitButton");
button.setAttribute("data-toggle","modal");
button.setAttribute("data-target","#myModal");
$('#submitButton').on('click', function() {
const name =  document.getElementById("name").value;
const password = document.getElementById("password").value;
const userName = document.getElementById("username").value;
var button=document.getElementById("respon");
if (name === "") {

button.innerHTML="لا يسمح ان يكون فارغا";
return;
}
var button=document.getElementById("respon");
if (password === "") {

button.innerHTML="لا يسمح ان يكون فارغا";
return;
}

if (userName === "") {

button.innerHTML="لا يسمح ان يكون فارغا";
return;
}
const formData = {
name: name,
password: password,
userName: userName
};

$.ajax({
url: 'http://kg.host/admin/addNewTeacher',
type: 'POST',
contentType: 'application/json;charset=UTF-8',
data: JSON.stringify(formData),
success: function(response) {
$('#responseContainer').html('<p>Form submitted successfully</p>');

console.log('Response:', response);
},
error: function(xhr, status, error) {
let errorMessage = 'Error submitting form: ';
if (xhr.responseText) {
  try {
    const errorResponse = JSON.parse(xhr.responseText);
    errorMessage += errorResponse.message;
  } catch (parseError) {
    errorMessage += xhr.responseText;
  }
} else {
  errorMessage += error;
}
$('#responseContainer').html('<p>' + errorMessage + '</p>');
    // Create the SVG elements
    var svg1 = document.createElementNS("http://www.w3.org/2000/svg", "svg");
svg1.innerHTML = `<circle class="path circle" fill="none" stroke="#D06079" stroke-width="6" stroke-miterlimit="10" cx="65.1" cy="65.1" r="62.1"/>
              <line class="path line" fill="none" stroke="#D06079" stroke-width="6" stroke-linecap="round" stroke-miterlimit="10" x1="34.4" y1="37.9" x2="95.8" y2="92.3"/>
              <line class="path line" fill="none" stroke="#D06079" stroke-width="6" stroke-linecap="round" stroke-miterlimit="10" x1="95.8" y1="38" x2="34.4" y2="92.2"/>`;
              svg1.setAttribute("viewBox","0 0 130.2 130.2");
var svg2 = document.createElementNS("http://www.w3.org/2000/svg", "svg");
svg2.setAttribute("viewBox","0 0 130.2 130.2");
svg2.innerHTML = `<circle class="path circle" fill="none" stroke="#73AF55" stroke-width="6" stroke-miterlimit="10" cx="65.1" cy="65.1" r="62.1"/>
              <polyline class="path check" fill="none" stroke="#73AF55" stroke-width="6" stroke-linecap="round" stroke-miterlimit="10" points="100.2,40.2 51.5,88.8 29.8,67.5 "/>`;


var container=document.getElementById("header");
if(xhr.responseText=="userName is already exist"){
    button.innerHTML="اسم المستخدم موجود مسبقا";
    container.innerHTML="";
    container.appendChild(svg1);

}
else if(xhr.responseText=="Congratulation add new teacher"){
    button.innerHTML="تم اضافة استاذ جديد";
    container.innerHTML="";
    container.appendChild(svg2);}
console.error(errorMessage);
}
});
});
});