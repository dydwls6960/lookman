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

  const askBtns = document.querySelectorAll(".ask-btn");
  const revBtns = document.querySelectorAll(".review-btn");
  if (askBtns) {
    askBtns.forEach((btn) => {
      btn.addEventListener("click", () => {
        // get data
        const orderDetailNo = btn.dataset.orderDetailNo;
        const sellerNo = btn.dataset.sellerNo;
        const memberNo = btn.dataset.memberNo;

        // vex
        vex.dialog.open({
          message: "주문문의 추가",
          input: [
            `<input type="hidden" name="memberNo" id="memberNo" value="${memberNo}">`,
            `<input type="hidden" name="orderDetailNo" id="orderDetailNo" value="${orderDetailNo}">`,
            `<input type="hidden" name="sellerNo" id="sellerNo" value="${sellerNo}">`,
            `<input type="text" name="title" id="title" placeholder="제목" required>`,
            `<textarea name="questionContent" id="questionContent" placeholder="내용" required></textarea>`,
          ].join(""),
          buttons: [
            {
              text: "추가",
              type: "submit",
              className:
                "vex-dialog-button-primary vex-dialog-button vex-first",
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
              form.setAttribute("action", "/app/orders/inquiry/insert");
              form.setAttribute("method", "post");
            }
          },
        });
      });
    });
  }
  if (revBtns) {
    revBtns.forEach((btn) => {
      btn.addEventListener("click", () => {
        const memberNo = btn.dataset.memberNo;
        const ordersNo = btn.dataset.ordersNo;
        const productNo = btn.dataset.productNo;

        // vex
        vex.dialog.open({
          message: "리뷰 작성",
          input: [
            `<input type="hidden" name="memberNo" id="memberNo" value="${memberNo}">`,
            `<input type="hidden" name="ordersNo" id="ordersNo" value="${ordersNo}">`,
            `<input type="hidden" name="productNo" id="productNo" value="${productNo}">`,
            `<input type="number" min="1" step="1" max="5" name="rating" id="rating" value="1" placeholder="평점*" required>`,
            `<textarea name="content" id="content" placeholder="내용" required></textarea>`,
          ].join(""),
          buttons: [
            {
              text: "추가",
              type: "submit",
              className:
                "vex-dialog-button-primary vex-dialog-button vex-first",
              click: function () {
                const form = document.querySelector(".vex-dialog-form");
                const rating = form.querySelector("#rating").value;
                const content = form.querySelector("#content").value;
                console.log(rating);
                if (form && rating && content && rating >= 1 && rating <= 5) {
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
              form.setAttribute("action", "/app/member/review/insert");
              form.setAttribute("method", "post");
            }
          },
        });
      });
    });
  }
});

/*
addBtn.addEventListener("click", () => {
      const sellerNo = addBtn.dataset.sellerNo;
      const orderDetailNo = addBtn.dataset.orderDetailNo;
      const memberNo = addBtn.dataset.memberNo;

      vex.dialog.open({
        message: "상품문의 추가",
        input: [
          `<input type="hidden" name="memberNo" id="memberNo" value="${memberNo}">`,
          `<input type="hidden" name="orderDetailNo" id="orderDetailNo" value="${orderDetailNo}">`,
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
