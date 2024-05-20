document.addEventListener("DOMContentLoaded", () => {
  const editBtns = document.querySelectorAll(".edit-btn");

  editBtns.forEach((btn) => {
    btn.addEventListener("click", (e) => {
      const memberNo = btn.dataset.memberNo;
      const addressNo = btn.dataset.addressNo;
      const postcode = btn.dataset.postcode;
      const address = btn.dataset.address;
      const detailedAddress = btn.dataset.detailedAddress;
      const extraAddress = btn.dataset.extraAddress;

      vex.dialog.open({
        // message: "Enter your username and password:",
        input: [
          `<input type="hidden" name="memberNo" value="${memberNo}"`,
          `<input type="hidden" name="addressNo" value="${addressNo}">`,
          `<div class="postcode-container"><input type="text" name="postcode" id="postcode" placeholder="우편번호*" required value="${postcode}">`,
          `<button type="button" class="" onclick="execDaumPostcode()">우편번호
  검색</button></div>`,
          `<input type="text" name="address" id="address" placeholder="주소*" required value="${address}">`,
          `<input type="text" name="address2" id="address2" placeholder="상세주소*" required value="${detailedAddress}">`,
          `<input type="text" name="extraAddress" id="extraAddress" placeholder="참고사항" value="${extraAddress}">`,
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
