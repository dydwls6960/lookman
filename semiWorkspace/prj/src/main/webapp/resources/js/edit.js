function validateForm(e) {
  // 비밀번호 일치
  const pwdInput = document.querySelector("#newPwd").value;
  const pwd2Input = document.querySelector("#confirmNewPwd").value;

  // 새 비밀번호 지정할 때
  if (pwdInput || pwd2Input) {
    if (pwdInput !== pwd2Input) {
      alert("비밀번호와 비밀번호 확인이 다릅니다.");
      e.preventDefault();
      return;
    }

    // 비밀번호 강도 검사
    const passwordPattern =
      /^(?=.*[A-Za-z])(?=.*\d)(?=.*[@$!%*#?&])[A-Za-z\d@$!%*#?&]{8,}$/;
    if (!passwordPattern.test(pwdInput)) {
      alert(
        "비밀번호는 최소 8자 이상이어야 하며, 문자, 숫자, 특수문자를 포함해야 합니다."
      );
      e.preventDefault();
      return;
    }
  }

  // 전화번호 형식 검사
  const phoneInput = document.querySelector("#phone").value;
  const phonePattern = /^01[0-9]{8,9}$/;
  if (!phonePattern.test(phoneInput)) {
    alert("유효한 전화번호 형식이 아닙니다.");
    e.preventDefault();
    return;
  }
}

document.addEventListener("DOMContentLoaded", () => {
  // 회원가입 form 제출할 때 유효성검사
  document
    .querySelector(".form__join")
    .addEventListener("submit", validateForm);
});

console.log("hello world");
