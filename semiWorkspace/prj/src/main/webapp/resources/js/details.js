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
  const buyBtn = document.querySelector(".buy-btn");
  const favBtn = document.querySelector(".fav-btn");
  const cartBtn = document.querySelector(".cart-btn");

  // 좋아요 버튼
  favBtn.addEventListener("click", () => {
    const productNo = favBtn.dataset.productNo;
    const memberNo = favBtn.dataset.memberNo;
    if (!memberNo) {
      return (window.location.href = "/app/member/login");
    }

    $.ajax({
      url: "/app/member/favorite",
      method: "POST",
      contentType: "application/x-www-form-urlencoded; charset=UTF-8",
      data: {
        memberNo,
        productNo,
      },
      success: (data) => {
        console.log(data);
        if (data === "ok") {
          favBtn.classList.toggle("active");
          if (favBtn.classList.contains("active")) {
            favBtn.innerHTML = `<svg width="24" height="24" viewBox="0 0 24 24" fill="none" xmlns="http://www.w3.org/2000/svg">
            <path d="M22.5 9.18803C22.5016 9.90226 22.3616 10.6097 22.088 11.2695C21.8144 11.9293 21.4128 12.5282 20.9062 13.0318L12.5344 21.5274C12.4646 21.5983 12.3814 21.6545 12.2897 21.693C12.1979 21.7314 12.0994 21.7511 12 21.7511C11.9005 21.7511 11.8021 21.7314 11.7103 21.693C11.6186 21.6545 11.5354 21.5983 11.4656 21.5274L3.09374 13.0318C2.07307 12.0124 1.49917 10.6292 1.49829 9.18666C1.49741 7.74409 2.06963 6.36026 3.08905 5.33959C4.10848 4.31892 5.49161 3.74502 6.93418 3.74414C8.37674 3.74326 9.76057 4.31548 10.7812 5.3349L12 6.47397L13.2272 5.33115C13.9888 4.57327 14.958 4.05803 16.0122 3.85049C17.0665 3.64296 18.1586 3.75242 19.1507 4.16507C20.1428 4.57771 20.9904 5.27504 21.5865 6.16902C22.1826 7.06299 22.5005 8.11354 22.5 9.18803Z" fill="#D81159"/>
            </svg>
            `;
          } else {
            favBtn.innerHTML = `<svg width="24" height="24" viewBox="0 0 24 24" fill="none" xmlns="http://www.w3.org/2000/svg">
            <path d="M20.9064 5.34352C19.8874 4.32714 18.5075 3.75557 17.0683 3.75381C15.6291 3.75206 14.2478 4.32025 13.2264 5.33415L12.0001 6.47321L10.7729 5.3304C9.75176 4.31209 8.3679 3.74115 6.92577 3.74317C5.48365 3.74519 4.10139 4.32001 3.08308 5.34118C2.06478 6.36235 1.49383 7.74621 1.49585 9.18833C1.49788 10.6305 2.0727 12.0127 3.09386 13.031L11.4704 21.5304C11.5402 21.6013 11.6234 21.6575 11.7151 21.696C11.8069 21.7344 11.9053 21.7541 12.0048 21.7541C12.1043 21.7541 12.2027 21.7344 12.2945 21.696C12.3862 21.6575 12.4694 21.6013 12.5392 21.5304L20.9064 13.031C21.9254 12.0114 22.4978 10.6288 22.4978 9.18727C22.4978 7.74572 21.9254 6.36316 20.9064 5.34352ZM19.8423 11.9773L12.0001 19.931L4.15324 11.9698C3.41478 11.2313 2.99991 10.2297 2.99991 9.1854C2.99991 8.14106 3.41478 7.13948 4.15324 6.40102C4.8917 5.66256 5.89327 5.2477 6.93761 5.2477C7.98196 5.2477 8.98353 5.66256 9.72199 6.40102L9.74074 6.41977L11.4892 8.04634C11.628 8.17549 11.8105 8.2473 12.0001 8.2473C12.1897 8.2473 12.3723 8.17549 12.5111 8.04634L14.2595 6.41977L14.2782 6.40102C15.0172 5.66306 16.019 5.24887 17.0634 5.24957C18.1077 5.25028 19.109 5.66581 19.847 6.40477C20.585 7.14373 20.9991 8.14558 20.9984 9.18992C20.9977 10.2343 20.5822 11.2356 19.8432 11.9735L19.8423 11.9773Z" fill="#333333"/>
            </svg>
            `;
          }
        }
      },
      error: (err) => {
        console.log(err);
      },
    });
  });

  // 장바구니 버튼
  cartBtn.addEventListener("click", () => {
    const actionItems = document.querySelectorAll(".details__action--item");

    if (actionItems.length === 0) {
      alert("옵션을 선택해주세요.");
      return;
    }

    let data = {
      items: [],
    };

    // forEach actionItems
    actionItems.forEach((item) => {
      const inventoryNo = item.dataset.inventoryNo;
      const quantity = item.querySelector(".item-quantity").value;
      data.items.push({ inventoryNo: inventoryNo, quantity: quantity });
    });
    console.log(data);

    // TODO:
    // post to url
    $.ajax({
      url: url,
      data: { colorNo, productNo },
      contentType: "application/x-www-form-urlencoded; charset=UTF-8",
      success: (data) => {
        alert(data, "success!");
      },
      error: (err) => {
        console.log(err);
      },
    });
  });

  // 구매버튼
  buyBtn.addEventListener("click", () => {
    const actionItems = document.querySelectorAll(".details__action--item");

    if (actionItems.length === 0) {
      alert("옵션을 선택해주세요.");
      return;
    }

    let urlParams = new URLSearchParams();

    // forEach actionItems
    actionItems.forEach((item) => {
      const inventoryNo = item.dataset.inventoryNo;
      const quantity = item.querySelector(".item-quantity").value;
      urlParams.append(`items[${inventoryNo}]`, quantity);
    });
    // append url string
    const url = `/app/orders/order-form?${urlParams.toString()}`;
    console.log(url);

    // redirect to url
    window.location.href = url;
  });

  // 사이즈 옵션
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
    quantityEl.addEventListener("input", () => {
      updateOrderPrice(actionItem);
      updateTotalPrice();
    });

    // 옵션 삭제
    closeBtnEl.addEventListener("click", () => {
      actionItem.remove();
      updateTotalPrice();
    });
  });

  // 아이템 하나의 가격 업데이트
  function updateOrderPrice(item) {
    const quantity = item.querySelector(".item-quantity").value;
    const price = item.getAttribute("data-price").replace(",", "");
    const orderPriceSpan = item.querySelector(".order-price");

    const updatedPrice = quantity * price;
    orderPriceSpan.textContent = `${updatedPrice.toLocaleString()}원`;
  }

  // 셀렉트 옵션 리셋
  function resetSelectedOptions() {
    // 색상 선택 리셋
    colorSelect.value = "";
    // 사이즈 선택 리셋
    sizeSelect.innerHTML =
      '<option value="" disabled selected>옵션 선택</option>';
  }

  // 총가격 업데이트
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
