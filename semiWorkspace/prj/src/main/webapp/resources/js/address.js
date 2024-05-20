function execDaumPostcode() {
  new daum.Postcode({
    oncomplete: function (data) {
      const postcode = document.querySelector("#postcode");
      const address = document.querySelector("#address");
      const address2 = document.querySelector("#address2");
      const extraAddress = document.querySelector("#extraAddress");
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
        extraAddress.value = extraAddr.trim();
      } else {
        extraAddress.value = "";
      }

      // 우편번호와 주소 정보를 해당 필드에 넣는다.
      postcode.value = data.zonecode;
      address.value = addr;
      // 커서를 상세주소 필드로 이동한다.
      address2.value = "";
      address2.focus();
    },
  }).open();
}

// MODAL
document.addEventListener("DOMContentLoaded", () => {
  const editBtns = document.querySelectorAll(".edit-btn");
  const defaultBtns = document.querySelectorAll(".default-btn");

  // 수정 버튼
  editBtns.forEach((btn) => {
    btn.addEventListener("click", () => {
      const memberNo = btn.dataset.memberNo;
      const addressNo = btn.dataset.addressNo;
      const postcode = btn.dataset.postcode;
      const address = btn.dataset.address;
      const detailedAddress = btn.dataset.detailedAddress;
      const extraAddress = btn.dataset.extraAddress;

      vex.dialog.open({
        message: "주소 수정",
        input: [
          `<input type="hidden" name="memberNo" id="memberNo" value="${memberNo}">`,
          `<input type="hidden" name="addressNo" id="addressNo"value="${addressNo}">`,
          `<div class="postcode-container"><input type="text" name="postcode" id="postcode" placeholder="우편번호*" required value="${postcode}">`,
          `<button type="button" onclick="execDaumPostcode()">우편번호
  검색</button></div>`,
          `<input type="text" name="address" id="address" placeholder="주소*" required value="${address}">`,
          `<input type="text" name="address2" id="address2" placeholder="상세주소*" required value="${detailedAddress}">`,
          `<input type="text" name="extraAddress" id="extraAddress" placeholder="참고사항" value="${extraAddress}">`,
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
            console.log("모달창 닫음.");
          } else {
            console.log(
              data.memberNo,
              data.addressNo,
              data.postcode,
              data.address,
              data.address2,
              data.extraAddress
            );
          }
        },
        afterOpen: function () {
          const form = document.querySelector(".vex-dialog-form");
          if (form) {
            form.setAttribute("action", "/app/member/address/edit");
            form.setAttribute("method", "post");
          }
        },
      });
    });
  });

  // 기본주소 버튼
  defaultBtns.forEach((btn) => {
    btn.addEventListener("click", () => {
      const memberNo = btn.dataset.memberNo;
      const addressNo = btn.dataset.addressNo;

      $.ajax({
        url: "/app/member/address/default",
        type: "post",
        data: { memberNo: memberNo, addressNo: addressNo },
        contentType: "application/x-www-form-urlencoded; charset=UTF-8",
        success: (res) => {
          if (res === "ok") {
            location.reload();
          } else {
            alert("업데이트 실패..");
          }
        },
        error: () => {
          alert("업데이트 실패...:", err);
        },
      });
    });
  });
});
