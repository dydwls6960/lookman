<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
  <!DOCTYPE html>
  <html>

  <head>
    <meta charset="UTF-8">
    <title>내 주소 관리</title>
    <%@ include file="/WEB-INF/views/layout/util.jsp" %>
      <link rel="stylesheet" href="/app/resources/css/common/nav-with-header.css">

      <!-- 다음 주소 api -->
      <script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js" defer></script>

      <!-- vex modal -->
	    <%@ include file="/WEB-INF/views/layout/vex-modal.jsp" %>
      <link rel="stylesheet" href="/app/resources/css/address.css">
      <script type="text/javascript" defer src="/app/resources/js/address.js"></script>

  </head>

  <body>
    <div class="container">
      <%@ include file="/WEB-INF/views/layout/nav-with-header-only.jsp" %>

        <main class="main main-address">
          <div class="address__header">
            <h2>내 주소</h2>
            <button class="add-btn" type="button" data-member-no="${sessionScope.loginMemberVo.memberNo}">주소 추가</button>
          </div>
          <h3>주소</h3>

          <c:forEach var="dto" items="${requestScope.addresses}">
            <div class="address__item">
              <div class="address__upper">
                <div class="address-user">
                  <span class="address__name">${dto.memberName}</span>
                  <div>|</div>
                  <span class="address__number">${dto.phoneNo}</span>
                </div>
                <div class="address-controls">
                  <button class="edit-btn" type="button" data-member-no="${dto.memberNo}"
                    data-address-no="${dto.addressNo}" data-postcode="${dto.postcode}" data-address="${dto.address}"
                    data-detailed-address="${dto.detailedAddress}" data-extra-address="${dto.extraAddress}">수정</button>
                  <button class="delete-btn" type="button" data-member-no="${dto.memberNo}"
                    data-address-no="${dto.addressNo}">삭제</button>
                </div>
              </div>

              <div class="address__med">
                <div class="address-container">
                  <div class="address__med--general">${dto.address} (${dto.postcode})</div>
                  <div class="address__med--detail">${dto.detailedAddress}</div>
                  <c:if test="${not empty dto.extraAddress}">
                    <div class="address__med--extra">${dto.extraAddress}</div>
                  </c:if>
                </div>
                <div class="address-controls__default" data-micromodal-trigger="modal-1">
                  <button class="default-btn" type="button" data-member-no="${dto.memberNo}"
                    data-address-no="${dto.addressNo}"
                    onclick="updateDefaultAddress(${dto.memberNo}, ${dto.addressNo})">기본주소 지정</button>
                </div>
              </div>
              <c:if test="${dto.defaultYn eq 'Y'}">
                <div class="address__lower">
                  <span class="badge__default-address">기본주소</span>
                </div>
              </c:if>
            </div>
          </c:forEach>
        </main>

        <%@ include file="/WEB-INF/views/layout/footer.jsp" %>

    </div>

  </body>

  </html>