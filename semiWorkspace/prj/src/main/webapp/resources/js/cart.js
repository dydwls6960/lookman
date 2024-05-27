document.addEventListener("DOMContentLoaded", () => {
  const checkAllBox = document.querySelector("#check-all");
  const checkboxes = document.querySelectorAll(".item-checkbox");
  const delBtns = document.querySelectorAll(".del-btn");

  // 전부선택박스
  checkAllBox.addEventListener("change", () => {
    const isChecked = checkAllBox.checked;
    checkboxes.forEach((checkbox) => {
      checkbox.checked = isChecked;
    });
  });

  // 개별 삭제버튼들
  delBtns.forEach((delBtn) => {
    console.log(delBtn);
    // vex modal confirm
  });
});
