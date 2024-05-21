document.addEventListener("DOMContentLoaded", () => {
  const editBtns = document.querySelectorAll(".edit-btn");

  editBtns.forEach((btn) => {
    btn.addEventListener("click", () => {
      const memberNo = btn.dataset.memberNo;
      const reviewNo = btn.dataset.reviewNo;
      const rating = btn.dataset.rating;
      const content = btn.dataset.content;

      vex.dialog.open({
        message: "리뷰 수정",
        input: [
          `<input type="hidden" name="memberNo" id="memberNo" value="${memberNo}">`,
          `<input type="hidden" name="reviewNo" id="reviewNo"value="${reviewNo}">`,
          `<input type="number" name="rating" id="rating" placeholder="주소*" required value="${rating}">`,
          `<input type="text" name="content" id="content" placeholder="내용" required value="${content}">`,
        ].join(""),
        buttons: [
          {
            text: "수정",
            type: "submit",
            className: "vex-dialog-button-primary vex-dialog-button vex-first",
            click: function () {
              const form = document.querySelector(".vex-dialog-form");
              if (form) {
                form.submit();
              }
            },
          },
          $.extend({}, vex.dialog.buttons.NO, { text: "취소" }),
        ],
        callback: function (data) {
          if (!data) {
            // console.log("모달창 닫음.");
          } else {
            console.log(
              data.memberNo,
              data.addressNo,
              data.postcode,
              data.address,
              data.address2,
              data.extraAddress
            );
          }
        },
        afterOpen: function () {
          const form = document.querySelector(".vex-dialog-form");
          if (form) {
            form.setAttribute("action", "/app/member/review/edit");
            form.setAttribute("method", "post");
          }
        },
      });
    });
  });
});
