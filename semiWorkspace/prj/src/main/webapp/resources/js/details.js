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
  const addBtn = document.querySelector(".add-btn");
  const colorSelect = document.querySelector("#color");
  const sizeSelect = document.querySelector("#size");
  const actionItemsContainer = document.querySelector(
    ".details__action--items"
  );

  sizeSelect.addEventListener("change", (e) => {
    // get data from selected options
    const productNo = sizeSelect.dataset.productNo;
    const sizeNo = sizeSelect.value;
    const sizeName = sizeSelect.selectedOptions[0].textContent;
    const price = sizeSelect.selectedOptions[0].dataset.price;
    const inventoryNo = sizeSelect.selectedOptions[0].dataset.inventoryNo;
    const colorNo = colorSelect.value;
    const colorName = colorSelect.selectedOptions[0].textContent;

    // 이미 추가 되었는지 검사
    const existingItem = actionItemsContainer.querySelector(
      `.details__action--item[data-inventory-no="${inventoryNo}"]`
    );
    if (existingItem) {
      alert("이미 추가되었습니다.");
      resetSelectedOptions();
      return;
    }

    // create element
    const actionItem = document.createElement("div");
    actionItem.classList.add("details__action--item");

    // create span
    const spanEl = document.createElement("span");
    spanEl.textContent = `${colorName}, ${sizeName}`;

    // create quantity input
    const quantityEl = document.createElement("input");
    quantityEl.setAttribute("type", "number");
    quantityEl.setAttribute("min", "1");
    quantityEl.setAttribute("name", "item-quantity");
    quantityEl.classList.add("item-quantity");
    quantityEl.value = "1";
    quantityEl.setAttribute("max", "3");

    // create price,close container
    const priceCloseContainer = document.createElement("div");
    priceCloseContainer.classList.add("item-price-close-container");
    const priceSpanEl = document.createElement("span");
    priceSpanEl.textContent = price + "원";
    priceSpanEl.classList.add("order-price");
    const closeBtnEl = document.createElement("button");
    closeBtnEl.classList.add("close-btn");
    closeBtnEl.innerHTML = "&times;";
    priceCloseContainer.appendChild(priceSpanEl);
    priceCloseContainer.appendChild(closeBtnEl);

    // append item elements
    actionItem.appendChild(spanEl);
    actionItem.appendChild(quantityEl);
    actionItem.appendChild(priceCloseContainer);
    actionItem.setAttribute("data-inventory-no", inventoryNo);
    actionItem.setAttribute("data-price", price);

    // append to items container
    actionItemsContainer.appendChild(actionItem);

    // 셀렉트 옵션 리셋
    resetSelectedOptions();

    // 총 가격 업데이트
    updateTotalPrice();

    // 갯수 변화
    // TODO: function to listen to quantity change
    quantityEl.addEventListener("input", () => {
      updateOrderPrice(actionItem);
      updateTotalPrice();
    });
  });

  // TODO: function to listen to close-btn click

  function updateOrderPrice(item) {
    const quantity = item.querySelector(".item-quantity").value;
    const price = item.getAttribute("data-price").replace(",", "");
    const orderPriceSpan = item.querySelector(".order-price");

    const updatedPrice = quantity * price;
    orderPriceSpan.textContent = `${updatedPrice.toLocaleString()}원`;
  }

  function resetSelectedOptions() {
    // 색상 선택 리셋
    colorSelect.value = "";
    // 사이즈 선택 리셋
    sizeSelect.innerHTML =
      '<option value="" disabled selected>옵션 선택</option>';
  }

  function updateTotalPrice() {
    let totalPrice = 0;
    const actionItems = document.querySelectorAll(".details__action--item");
    actionItems.forEach((item) => {
      const quantity = item.querySelector(".item-quantity").value;
      const price = item.dataset.price.replace(",", "");

      totalPrice += quantity * price;
    });
    const totalPriceSpan = document.querySelector(".total-price");
    totalPriceSpan.textContent = `${totalPrice.toLocaleString()}원`;
  }

  // 상품 색상 옵션 선택
  colorSelect.addEventListener("change", (e) => {
    const colorNo = colorSelect.value;
    const productNo = colorSelect.dataset.productNo;

    $.ajax({
      url: "/app/get-size",
      data: { colorNo, productNo },
      contentType: "application/x-www-form-urlencoded; charset=UTF-8",
      success: (data) => {
        // reset sizeSelect
        sizeSelect.innerHTML = "";

        // placeholder
        const placeholderEl = document.createElement("option");
        placeholderEl.value = "";
        placeholderEl.setAttribute("disabled", "");
        placeholderEl.setAttribute("selected", "");
        placeholderEl.textContent = "옵션 선택";
        sizeSelect.appendChild(placeholderEl);

        data.forEach((dto) => {
          // append options to sizeSelect
          console.log(dto);
          const optionEl = document.createElement("option");
          optionEl.value = dto.sizeNo;
          optionEl.textContent = dto.sizeName;
          optionEl.setAttribute("data-inventory-no", dto.inventoryNo);
          optionEl.setAttribute("data-price", dto.productPrice);
          if (optionEl.inventoryQuantity < 1) {
            optionEl.setAttribute("disabled", "");
          }

          sizeSelect.appendChild(optionEl);
        });
      },
      error: (err) => {
        console.log(err);
      },
    });
  });

  if (addBtn) {
    // 질문 추가 버튼
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
  }

  // 삭제 버튼
  delBtns.forEach((btn) => {
    btn.addEventListener("click", () => {
      const memberNo = btn.dataset.memberNo;
      const productInquiryNo = btn.dataset.productInquiryNo;
      const productNo = btn.dataset.productNo;

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
          form.setAttribute("action", "/app/inquiry/delete");
          const memberInput = returnHiddenInputElement("memberNo", memberNo);
          const productInquiryNoInput = returnHiddenInputElement(
            "productInquiryNo",
            productInquiryNo
          );
          const productNoInput = returnHiddenInputElement(
            "productNo",
            productNo
          );

          form
            .querySelector(".vex-dialog-input")
            .appendChild(productInquiryNoInput);
          form.querySelector(".vex-dialog-input").appendChild(memberInput);
          form.querySelector(".vex-dialog-input").appendChild(productNoInput);
        },
      });
    });
  });
  // 수정 버튼
  editBtns.forEach((btn) => {
    btn.addEventListener("click", () => {
      const productInquiryNo = btn.dataset.productInquiryNo;
      const memberNo = btn.dataset.memberNo;
      const title = btn.dataset.title;
      const questionContent = btn.dataset.questionContent;
      const privateYn = btn.dataset.privateYn;
      const productNo = btn.dataset.productNo;

      vex.dialog.open({
        message: "상품문의 수정",
        input: [
          `<input type="hidden" name="memberNo" id="memberNo" value="${memberNo}">`,
          `<input type="hidden" name="productInquiryNo" id="productInquiryNo" value="${productInquiryNo}">`,
          `<input type="hidden" name="productNo" id="productNo" value="${productNo}">`,
          `<input type="text" name="title" id="title" placeholder="제목" required value="${title}">`,
          `<textarea name="questionContent" id="questionContent" placeholder="내용" required>${questionContent}</textarea>`,

          `<div class="privateYn-container">
          <label class="privateYn-label">공개 여부</label>
          <div class="radio-outer-container">
            <div class="radio-container">
              <input type="radio" name="privateYn" id="public" value="N" ${
                privateYn === "N" ? "checked" : ""
              }>
              <label for="public">공개</label>
            </div>
            <div class="radio-container">
              <input type="radio" name="privateYn" id="private" value="Y" ${
                privateYn === "Y" ? "checked" : ""
              }>
              <label for="private">비공개</label>
            </div>
          </div>
        </div>`,
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
          }
        },
        afterOpen: function () {
          const form = document.querySelector(".vex-dialog-form");
          if (form) {
            form.setAttribute("action", "/app/inquiry/edit-question");
            form.setAttribute("method", "post");
          }
        },
      });
    });
  });

  // 싱품 수량 input type="text"인데, text 못넣고 숫자만 넣게 하기
  const itemQuantityInput = document.querySelector(".item-quantity");
  if (itemQuantityInput) {
    itemQuantityInput.addEventListener("input", (e) => {
      itemQuantityInput.value = itemQuantityInput.value.replace(/[^0-9]/g, "");
    });
  }
});
