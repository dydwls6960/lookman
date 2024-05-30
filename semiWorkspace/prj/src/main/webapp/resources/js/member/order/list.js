document.addEventListener("DOMContentLoaded", () => {
  // get param
  // http://127.0.0.1:8888/app/orders/list?statusNo=1
  function getQueryParam(param) {
    const urlParams = new URLSearchParams(window.location.search);
    return urlParams.get(param);
  }

  const statusNo = getQueryParam("statusNo");

  switch (statusNo) {
    case "1":
      document
        .querySelector('[data-status="입금/결제"]')
        .classList.add("status-active");
      break;
    case "3":
      document
        .querySelector('[data-status="배송준비중"]')
        .classList.add("status-active");
      break;
    case "4":
      document
        .querySelector('[data-status="배송중"]')
        .classList.add("status-active");
      break;
    case "5":
      document
        .querySelector('[data-status="배송완료"]')
        .classList.add("status-active");
      break;
    case "6":
      document
        .querySelector('[data-status="취소"]')
        .classList.add("status-active");
      break;
    default:
      break;
  }

  const askBtn = document.querySelector(".ask-btn");
  const revBtn = document.querySelector(".review-btn");
  if (askBtn) {
    askBtn.addEventListener("click", () => {
      console.log("helo");
      // get data

      // vex

      // ajax
    });
  }
  if (revBtn) {
    revBtn.addEventListener("click", () => {
      console.log("helo");
      // get data

      // vex

      // ajax
    });
  }
});

/*
addBtn.addEventListener("click", () => {
      const sellerNo = addBtn.dataset.sellerNo;
      const productNo = addBtn.dataset.productNo;
      const memberNo = addBtn.dataset.memberNo;

      vex.dialog.open({
        message: "상품문의 추가",
        input: [
          `<input type="hidden" name="memberNo" id="memberNo" value="${memberNo}">`,
          `<input type="hidden" name="productNo" id="productNo" value="${productNo}">`,
          `<input type="hidden" name="sellerNo" id="sellerNo" value="${sellerNo}">`,
          `<input type="text" name="title" id="title" placeholder="제목" required>`,
          `<textarea name="questionContent" id="questionContent" placeholder="내용" required></textarea>`,

          `<div class="privateYn-container">
          <label class="privateYn-label">공개 여부</label>
          <div class="radio-outer-container">
            <div class="radio-container">
              <input type="radio" name="privateYn" id="public" value="N" checked>
              <label for="public">공개</label>
            </div>
            <div class="radio-container">
              <input type="radio" name="privateYn" id="private" value="Y">
              <label for="private">비공개</label>
            </div>
          </div>
        </div>`,
        ].join(""),
        buttons: [
          {
            text: "추가",
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
          }
        },
        afterOpen: function () {
          const form = document.querySelector(".vex-dialog-form");
          if (form) {
            form.setAttribute("action", "/app/inquiry/insert");
            form.setAttribute("method", "post");
          }
        },
      });
    });

*/
