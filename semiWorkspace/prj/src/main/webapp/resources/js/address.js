document.addEventListener("DOMContentLoaded", () => {
  const editBtns = document.querySelectorAll(".edit-btn");
  editBtns.forEach((btn) => {
    btn.addEventListener("click", (e) => {
      vex.dialog.open({
        // message: "Enter your username and password:",
        input: [
          `<div class="postcode-container"><input type="text" name="postcode" id="postcode" placeholder="우편번호*" required>`,
          `<button type="button" class="" onclick="execDaumPostcode()">우편번호
  검색</button></div>`,
          `<input type="text" name="address" id="address" placeholder="주소*" required>`,
          `<input type="text" name="address2" id="address2" placeholder="상세주소*" required>`,
          `<input type="text" name="extraAddress" id="extraAddress" placeholder="참고사항">`,
        ].join(""),
        buttons: [
          $.extend({}, vex.dialog.buttons.YES, { text: "수정" }),
          $.extend({}, vex.dialog.buttons.NO, { text: "취소" }),
        ],
        callback: function (data) {
          if (!data) {
            console.log("Cancelled");
          } else {
            console.log("Username", data.username, "Password", data.password);
          }
        },
      });
    });
  });
});
