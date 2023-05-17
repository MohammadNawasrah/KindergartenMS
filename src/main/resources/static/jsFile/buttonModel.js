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
          a.setAttribute("href", "tableInfo");
          text.innerHTML = "الذهاب لرؤيه معلومات التلاميذ";
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