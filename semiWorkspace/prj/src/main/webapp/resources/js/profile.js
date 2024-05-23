document.querySelectorAll(".profile__status").forEach((statusElement) => {
  statusElement.addEventListener("click", (e) => {
    const status = statusElement.getAttribute("data-status");
    console.log(status);

    // jquery smth
  });
});
