const postcode = document.querySelector("#postcode");
const address = document.querySelector("#address");
const address2 = document.querySelector("#address2");
const extraAddress = document.querySelector("#extraAddress");

function execDaumPostcode() {
  new daum.Postcode({
    oncomplete: function (data) {
      // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

      // 각 주소의 노출 규칙에 따라 주소를 조합한다.
      // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
      var addr = ""; // 주소 변수
      var extraAddr = ""; // 참고항목 변수

      //사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
      if (data.userSelectedType === "R") {
        // 사용자가 도로명 주소를 선택했을 경우
        addr = data.roadAddress;
      } else {
        // 사용자가 지번 주소를 선택했을 경우(J)
        addr = data.jibunAddress;
      }

      // 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
      if (data.userSelectedType === "R") {
        // 법정동명이 있을 경우 추가한다. (법정리는 제외)
        // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
        if (data.bname !== "" && /[동|로|가]$/g.test(data.bname)) {
          extraAddr += data.bname;
        }
        // 건물명이 있고, 공동주택일 경우 추가한다.
        if (data.buildingName !== "" && data.apartment === "Y") {
          extraAddr +=
            extraAddr !== "" ? ", " + data.buildingName : data.buildingName;
        }
        // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
        if (extraAddr !== "") {
          extraAddr = " (" + extraAddr + ")";
        }
        // 조합된 참고항목을 해당 필드에 넣는다.
        extraAddress.value = extraAddr;
      } else {
        extraAddress.value = "";
      }

      // 우편번호와 주소 정보를 해당 필드에 넣는다.
      postcode.value = data.zonecode;
      address.value = addr;
      // 커서를 상세주소 필드로 이동한다.
      address2.focus();
    },
  }).open();
}

function checkDuplicateId() {
  const id = document.querySelector("#id").value;
  if (!id) {
    alert("아이디를 입력하세요.");
    return;
  }

  // 이메일 형식 검사
  const emailPattern = /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/;
  if (!emailPattern.test(id)) {
    alert("유효한 이메일 형식이 아닙니다.");
    return;
  }

  $.ajax({
    url: "/app/member/id-dup",
    type: "get",
    data: { id: id },
    contentType: "application/x-www-form-urlencoded; charset=UTF-8",
    success: (res) => {
      if (res === "ok") {
        alert("사용 가능한 아이디입니다.");
        document.getElementById("id").dataset.checked = "true";
      } else {
        alert("이미 사용 중인 아이디입니다.");
        document.getElementById("id").dataset.checked = "false";
      }
    },
    error: () => {
      alert("중복 검사 실패...");
      document.getElementById("id").dataset.checked = "false";
    },
  });
}

function validateForm(e) {
  // 아이디 중복검사
  const idInput = document.querySelector("#id");
  if (idInput.dataset.checked !== "true") {
    alert("아이디 중복 검사를 완료해주세요.");
    e.preventDefault();
    return;
  }

  // 이메일 형식 검사
  const emailPattern = /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/;
  if (!emailPattern.test(idInput.value)) {
    alert("유효한 이메일 형식이 아닙니다.");
    e.preventDefault();
    return;
  }

  // 비밀번호 일치
  const pwdInput = document.querySelector("#pwd").value;
  const pwd2Input = document.querySelector("#pwd2").value;
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

  // 전화번호 형식 검사
  const phoneInput = document.querySelector("#phone").value;
  const phonePattern = /^01[0-9]{8,9}$/;
  if (!phonePattern.test(phoneInput)) {
    alert("유효한 전화번호 형식이 아닙니다.");
    e.preventDefault();
    return;
  }
}

function changeCheckStatus(e) {
  const idInput = document.querySelector("#id");
  idInput.dataset.checked = "false";
}

document.addEventListener("DOMContentLoaded", () => {
  // 회원가입 form 제출할 때 유효성검사
  document
    .querySelector(".form__join")
    .addEventListener("submit", validateForm);

  // 아이디 중복검사 후 또 바꿨을 때 유효성검사
  document.querySelector("#id").addEventListener("change", changeCheckStatus);
});
