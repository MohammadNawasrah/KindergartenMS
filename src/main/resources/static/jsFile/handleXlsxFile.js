  function handleFileUpload() {
        const input = document.getElementById("excelFileInput");
        const file = input.files[0];

        if (file) {
          const reader = new FileReader();

          reader.onload = function (e) {
            const data = new Uint8Array(e.target.result);
            const workbook = XLSX.read(data, { type: "array" });
            const worksheet = workbook.Sheets[workbook.SheetNames[0]];
            const jsonData = XLSX.utils.sheet_to_json(worksheet, {
              header: 1,
              raw: false,
              dateNF: "yyyy/mm/dd", // Specify the date format
            });

            // Post each data entry
            jsonData.slice(1).forEach(entry => {
              const payload = {
                name: entry[0],
                numberPhone: entry[1],
                dateOfBirth: formatDate(entry[2]), // Fix the date format
                idCode: entry[3],
                teacherId: entry[4],
              };
              console.log(payload);
              // Post the data to the specified URL
              fetch("http://kg.host/admin/addStudentPage", {
                method: "POST",
                headers: {
                  "Content-Type": "application/json;charset=UTF-8", // Specify the charset
                },
                body: JSON.stringify(payload),
              })
                .then(response => {
                  if (response.ok) {
                    console.log("Data posted successfully");
                  } else {
                    console.error("Error posting data:", response.status);
                  }
                })
                .catch(error => {
                  console.error("Error posting data:", error);
                });
            });
          };

          reader.readAsArrayBuffer(file);
        }
      }

      function formatDate(dateString) {
        // Check if the date string contains slashes or dashes
        const delimiter = dateString.includes("/") ? "/" : "-";

        const [day, month, year] = dateString.split(delimiter);
        return `${year.padStart(4, "20")}-${month.padStart(
          2,
          "0"
        )}-${day.padStart(2, "0")}`;
      }