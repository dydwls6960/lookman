document.addEventListener("DOMContentLoaded", () => {
  const inputRadios = document.querySelectorAll("input[name='address']");
  const memberNameEl = document.querySelector(".memberName");
  const phoneNumberEl = document.querySelector(".phoneNumber");
  const postcodeEl = document.querySelector(".postcode");
  const addressEl = document.querySelector(".address");
  const extraAddressEl = document.querySelector(".extraAddress");
  const detailedAddressEl = document.querySelector(".detailedAddress");
  const shippingReqEl = document.querySelector(".shippingReq");

  inputRadios.forEach((radio) => {
    radio.addEventListener("click", () => {
      const addressNo = radio.dataset.addressNo;

      $.ajax({
        url: "/app/address/rest",
        method: "GET",
        data: { addressNo },
        success: function (res) {
          console.log(res);
          memberNameEl.textContent = res.memberName;
          phoneNumberEl.textContent = res.phoneNo;
          postcodeEl.textContent = `(${res.postcode})`;
          addressEl.textContent = res.address;
          extraAddressEl.textContent = res.extraAddress;
          detailedAddressEl.textContent = res.detailedAddress;
          shippingReqEl.textContent = res.defaultReq;
        },
        error: function (data) {
          console.log(data);
        },
      });
    });
  });
});
