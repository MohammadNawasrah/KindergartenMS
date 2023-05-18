 function button(number) {
        var a = document.getElementById("nextBage");
        var text = document.getElementById("alertText");
        text.setAttribute("class", "text-center fw-bold");
        if (number == 0) {
          text.innerHTML = "تاكيد اضافه الطلاب";
          a.setAttribute("onclick","handleFileUpload()");
          a.setAttribute("data-dismiss","modal")
        }
        if (number == 1) {
          a.setAttribute("onclick", "getData()");
          text.innerHTML = "الذهاب لرؤيه معلومات الطلاب";
        }
        if (number == 2) {
          a.setAttribute("href", "delall");
          text.innerHTML = "تأكيد عملية التهيئة";
        }
        if (number == 3) {
          a.setAttribute("href", "datadigram");
          text.innerHTML = "الذهاب لرؤيه التقارير";
        }
        if (number == 4) {
          a.setAttribute("href", "simple_upload2");
          text.innerHTML = "تأكيد تحميل الملف";
        }
        if (number == 5) {
          a.setAttribute("href", "simple_upload");
          text.innerHTML = "تأكيد تحميل الملف";
        }
      }
function getData(){
        event.preventDefault(); // Prevent the default navigation

        // Create a form dynamically
        const form = document.createElement('form');
        form.method = 'Get';
        form.action = 'http://kg.host/admin/student_info'; // Specify the URL for the POST request

        // Add any additional form fields as needed
        const input1 = document.createElement('input');
        input1.type = 'hidden';
        input1.name = 'param1';
        input1.value = 'value1';
        form.appendChild(input1);

        const input2 = document.createElement('input');
        input2.type = 'hidden';
        input2.name = 'param2';
        input2.value = 'value2';
        form.appendChild(input2);

        // Append the form to the document body and submit it
        document.body.appendChild(form);
        form.submit();
      }