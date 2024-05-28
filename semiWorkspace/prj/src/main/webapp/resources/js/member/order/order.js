document.addEventListener("DOMContentLoaded", () => {
  const inputRadios = document.querySelectorAll("input[name='address']");

  inputRadios.forEach((radio) => {
    radio.addEventListener("click", () => {
      const addressNo = radio.dataset.addressNo;

      $.ajax({
        url: "/app/address/rest",
        method: "GET",
        data: { addressNo },
        success: function (data) {
          console.log(data);
        },
        error: function (data) {
          console.log(data);
        },
      });
    });
  });
});
