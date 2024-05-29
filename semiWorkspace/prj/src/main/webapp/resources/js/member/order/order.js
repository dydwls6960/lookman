document.addEventListener("DOMContentLoaded", () => {
  const inputRadios = document.querySelectorAll("input[name='address']");
  const memberNameEl = document.querySelector(".memberName");
  const phoneNumberEl = document.querySelector(".phoneNumber");
  const postcodeEl = document.querySelector(".postcode");
  const addressEl = document.querySelector(".address");
  const extraAddressEl = document.querySelector(".extraAddress");
  const detailedAddressEl = document.querySelector(".detailedAddress");
  const shippingReqEl = document.querySelector(".shippingReq");
  const payBtn = document.querySelector("#pay-btn");

  const payment = (
    memberEmail,
    memberName,
    memberPhone,
    memberAddr,
    memberPostcode,
    makeMerchantUid,
    totalPrice,
    concatProdName,
    selectedPaymentMethod,
    memberNo,
    addressNo,
    shippingReq
  ) => {
    if (confirm("구매 하시겠습니까?")) {
      IMP.init("imp13251138");
      IMP.request_pay(
        {
          pg: selectedPaymentMethod,
          pay_method: "card",
          merchant_uid: "IMP" + makeMerchantUid,
          name: concatProdName,
          amount: totalPrice,
          buyer_email: memberEmail,
          buyer_name: memberName,
          buyer_tel: memberPhone,
          buyer_addr: memberAddr,
          buyer_postcode: memberPostcode,
        },
        async function (data) {
          if (data.success) {
            console.log(data);

            // collect product data
            const productDetails = [];
            document
              .querySelectorAll(".product-name")
              .forEach((productNameEl) => {
                const productNo = productNameEl.dataset.productNo;
                const inventoryNo = productNameEl.dataset.inventoryNo;
                const quantity = productNameEl
                  .closest("tr")
                  .querySelector(".cart__order-quantity")
                  .textContent.trim();

                productDetails.push({
                  productNo,
                  inventoryNo,
                  quantity,
                });
              });

            // cardCompanyNo
            let cardCompanyNo;
            switch (data.pg_provider) {
              case "kakaopay":
                cardCompanyNo = 1;
                break;
              case "payco":
                cardCompanyNo = 2;
                break;
              case "tosspayments":
                cardCompanyNo = 3;
                break;
            }

            // include memberNo, shippingReq, addressNo to data
            data.memberNo = memberNo;
            data.addressNo = addressNo;
            data.shippingReq = shippingReq;
            data.productDetails = productDetails;
            data.cardCompanyNo = cardCompanyNo;

            // make api call to backend to save data
            $.ajax({
              url: "/app/payment/success",
              method: "POST",
              contentType: "application/json; charset=utf-8",
              data: JSON.stringify(data),
              success: function (res) {
                console.log(res);
                if (res.message === "success") {
                  window.location.href = "/app/payment/success?success=true";
                } else {
                  alert("결제 실패 했습니다.");
                }
              },
              error: function (err) {
                console.log(err);
              },
            });
          } else if (res.success == false) {
            alert(res.error_msg);
          }
        }
      );
    } else {
      console.log("falsefalse");
      return false;
    }
  };
  payBtn.addEventListener("click", () => {
    // 구매자 정보
    const totalPrice = payBtn.dataset.totalPrice;
    const memberNo = payBtn.dataset.memberNo;
    const addressNo = payBtn.dataset.addressNo;
    const shippingReq = payBtn.dataset.shippingReq;

    const memberName = payBtn.dataset.memberName;
    const memberEmail = payBtn.dataset.memberId;
    const memberPhone = payBtn.dataset.memberPhone;
    const memberAddr = document
      .querySelector(".shipping-info__address")
      .textContent.replace(/\s+/g, " ")
      .trim();
    const memberPostcode = document
      .querySelector(".postcode")
      .textContent.replace(/[()]/g, "");

    // UID
    const today = new Date();
    const hours = today.getHours();
    const minutes = today.getMinutes();
    const seconds = today.getSeconds();
    const milliseconds = today.getMilliseconds();
    const makeMerchantUid =
      `${hours}` + `${minutes}` + `${seconds}` + `${milliseconds}`;

    // 상품명
    const productNames = document.querySelectorAll(".product-name");
    const productArray = Array.from(productNames).map((el) => el.textContent);
    let concatProdName = "";
    if (productArray.length === 1) {
      concatProdName = productArray[0];
    } else if (productArray.length > 1) {
      concatProdName = `${productArray[0]} 외 ${productArray.length - 1}건`;
    }

    // imp
    let IMP = window.IMP;

    // determine which pg
    const selectedPaymentMethod = document.querySelector(
      'input[name="payment-method"]:checked'
    ).id;

    payment(
      memberEmail,
      memberName,
      memberPhone,
      memberAddr,
      memberPostcode,
      makeMerchantUid,
      totalPrice,
      concatProdName,
      selectedPaymentMethod,
      memberNo,
      addressNo,
      shippingReq
    );
  });

  inputRadios.forEach((radio) => {
    radio.addEventListener("click", () => {
      const addressNo = radio.dataset.addressNo;

      $.ajax({
        url: "/app/address/rest",
        method: "GET",
        data: { addressNo },
        success: function (res) {
          memberNameEl.textContent = res.memberName;
          phoneNumberEl.textContent = res.phoneNo;
          postcodeEl.textContent = `(${res.postcode})`;
          addressEl.textContent = res.address;
          extraAddressEl.textContent = res.extraAddress;
          detailedAddressEl.textContent = res.detailedAddress;
          shippingReqEl.textContent = res.defaultReq;
          console.log(res);
          // update pay-btn dataset
          payBtn.dataset.addressNo = res.addressNo;
          payBtn.dataset.shippingReq =
            res.defaultReq == shippingReqEl.value.trim()
              ? res.defaultReq
              : shippingReqEl.value;
        },
        error: function (data) {
          alert(data);
        },
      });
    });
  });
});
