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
});
