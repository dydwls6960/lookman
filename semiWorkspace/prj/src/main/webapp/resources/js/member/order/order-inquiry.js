function returnHiddenInputElement(name, value) {
  const inputEl = document.createElement("input");
  inputEl.setAttribute("type", "hidden");
  inputEl.setAttribute("name", name);
  inputEl.setAttribute("value", value);
  return inputEl;
}
document.addEventListener("DOMContentLoaded", () => {
  const editBtns = document.querySelectorAll(".edit-btn");
  const delBtns = document.querySelectorAll(".delete-btn");

  // 삭제 버튼
  delBtns.forEach((btn) => {
    btn.addEventListener("click", () => {
      const memberNo = btn.dataset.memberNo;
      const orderInquiryNo = btn.dataset.orderInquiryNo;
      vex.dialog.confirm({
        message: "삭제하시겠습니까?",
        buttons: [
          $.extend({}, vex.dialog.buttons.YES, { text: "삭제" }),
          $.extend({}, vex.dialog.buttons.NO, { text: "취소" }),
        ],
        callback: function (data) {
          if (data) {
            const form = document.querySelector(".vex-dialog-form");
            form.submit();
          }
        },
        afterOpen: function () {
          const form = document.querySelector(".vex-dialog-form");
          form.setAttribute("method", "post");
          form.setAttribute("action", "/app/orders/inquiry/delete");
          const memberInput = returnHiddenInputElement("memberNo", memberNo);
          const orderInquiryNoInput = returnHiddenInputElement(
            "orderInquiryNo",
            orderInquiryNo
          );

          form
            .querySelector(".vex-dialog-input")
            .appendChild(orderInquiryNoInput);
          form.querySelector(".vex-dialog-input").appendChild(memberInput);
        },
      });
    });
  });

  // 수정 버튼
  editBtns.forEach((btn) => {
    btn.addEventListener("click", () => {
      const orderInquiryNo = btn.dataset.orderInquiryNo;
      const sellerNo = btn.dataset.sellerNo;
      const memberNo = btn.dataset.memberNo;
      const title = btn.dataset.title;
      const questionContent = btn.dataset.questionContent;
      // vex
      vex.dialog.open({
        message: "주문문의 수정",
        input: [
          `<input type="hidden" name="memberNo" id="memberNo" value="${memberNo}">`,
          `<input type="hidden" name="orderInquiryNo" id="orderInquiryNo" value="${orderInquiryNo}">`,
          `<input type="hidden" name="sellerNo" id="sellerNo" value="${sellerNo}">`,
          `<input type="text" name="title" id="title" placeholder="제목" value=${title} required>`,
          `<textarea name="questionContent" id="questionContent" placeholder="내용" required>${questionContent}</textarea>`,
        ].join(""),
        buttons: [
          {
            text: "추가",
            type: "submit",
            className: "vex-dialog-button-primary vex-dialog-button vex-first",
            click: function () {
              const form = document.querySelector(".vex-dialog-form");
              const title = form.querySelector("#title").value;
              const content = form.querySelector("#questionContent").value;
              if (form && title && content) {
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
          }
        },
        afterOpen: function () {
          const form = document.querySelector(".vex-dialog-form");
          if (form) {
            form.setAttribute("action", "/app/orders/inquiry/edit");
            form.setAttribute("method", "post");
          }
        },
      });
    });
  });
});
