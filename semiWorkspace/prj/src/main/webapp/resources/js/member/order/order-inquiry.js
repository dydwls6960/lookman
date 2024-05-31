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
  // editBtns.forEach((btn) => {
  //   btn.addEventListener("click", () => {
  //     const productInquiryNo = btn.dataset.productInquiryNo;
  //     const memberNo = btn.dataset.memberNo;
  //     const title = btn.dataset.title;
  //     const questionContent = btn.dataset.questionContent;
  //     const privateYn = btn.dataset.privateYn;
  //     const source = btn.dataset.source;

  //     vex.dialog.open({
  //       message: "상품문의 수정",
  //       input: [
  //         `<input type="hidden" name="memberNo" id="memberNo" value="${memberNo}">`,
  //         `<input type="hidden" name="source" id="source" value="${source}">`,
  //         `<input type="hidden" name="productInquiryNo" id="productInquiryNo" value="${productInquiryNo}">`,
  //         `<input type="text" name="title" id="title" placeholder="제목" required value="${title}">`,
  //         `<textarea name="questionContent" id="questionContent" placeholder="내용" required>${questionContent}</textarea>`,

  //         `<div class="privateYn-container">
  //         <label class="privateYn-label">공개 여부</label>
  //         <div class="radio-outer-container">
  //           <div class="radio-container">
  //             <input type="radio" name="privateYn" id="public" value="N" ${
  //               privateYn === "N" ? "checked" : ""
  //             }>
  //             <label for="public">공개</label>
  //           </div>
  //           <div class="radio-container">
  //             <input type="radio" name="privateYn" id="private" value="Y" ${
  //               privateYn === "Y" ? "checked" : ""
  //             }>
  //             <label for="private">비공개</label>
  //           </div>
  //         </div>
  //       </div>`,
  //       ].join(""),
  //       buttons: [
  //         {
  //           text: "수정",
  //           type: "submit",
  //           className: "vex-dialog-button-primary vex-dialog-button vex-first",
  //           click: function () {
  //             const form = document.querySelector(".vex-dialog-form");
  //             if (form) {
  //               form.submit();
  //             }
  //           },
  //         },
  //         $.extend({}, vex.dialog.buttons.NO, { text: "취소" }),
  //       ],
  //       callback: function (data) {
  //         if (!data) {
  //           // console.log("모달창 닫음.");
  //         } else {
  //         }
  //       },
  //       afterOpen: function () {
  //         const form = document.querySelector(".vex-dialog-form");
  //         if (form) {
  //           form.setAttribute("action", "/app/inquiry/edit-question");
  //           form.setAttribute("method", "post");
  //         }
  //       },
  //     });
  //   });
  // });
});
