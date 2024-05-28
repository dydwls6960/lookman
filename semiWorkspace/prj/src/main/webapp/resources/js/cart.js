function returnHiddenInputElement(name, value) {
  const inputEl = document.createElement("input");
  inputEl.setAttribute("type", "hidden");
  inputEl.setAttribute("name", name);
  inputEl.setAttribute("value", value);
  return inputEl;
}

document.addEventListener("DOMContentLoaded", () => {
  const checkAllBox = document.querySelector("#check-all");
  const checkboxes = document.querySelectorAll(".item-checkbox");
  const delBtns = document.querySelectorAll(".del-btn");
  const delSelBtn = document.querySelector(".del-sel-button");

  // 선택삭제
  delSelBtn.addEventListener("click", () => {
    // get all memberNo and cartNo
    const checkedBoxes = document.querySelectorAll(".item-checkbox:checked");
    const delList = [];
    const memberNo = delSelBtn.dataset.memberNo;

    checkedBoxes.forEach((box) => {
      const cartNo = box.dataset.cartNo;
      delList.push(cartNo);
    });

    if (delList.length == 0) {
      alert("선택된 아이템이 없습니다.");
      return;
    }

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
        form.setAttribute("action", "/app/cart/delete/items");
        const memberInput = returnHiddenInputElement("memberNo", memberNo);
        form.querySelector(".vex-dialog-input").appendChild(memberInput);

        delList.forEach((cartNo) => {
          const cartNoInput = returnHiddenInputElement("cartNo", cartNo);
          form.querySelector(".vex-dialog-input").appendChild(cartNoInput);
        });
      },
    });
  });

  // 전부선택박스
  checkAllBox.addEventListener("change", () => {
    const isChecked = checkAllBox.checked;
    checkboxes.forEach((checkbox) => {
      checkbox.checked = isChecked;
    });
  });

  // 개별 삭제버튼들
  delBtns.forEach((btn) => {
    btn.addEventListener("click", () => {
      const memberNo = btn.dataset.memberNo;
      const cartNo = btn.dataset.cartNo;

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
          form.setAttribute("action", "/app/cart/delete");
          const memberInput = returnHiddenInputElement("memberNo", memberNo);
          const cartNoInput = returnHiddenInputElement("cartNo", cartNo);

          form.querySelector(".vex-dialog-input").appendChild(memberInput);
          form.querySelector(".vex-dialog-input").appendChild(cartNoInput);
        },
      });
    });
  });
});
