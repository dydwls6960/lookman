<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
  <!DOCTYPE html>
  <html>

  <head>
    <meta charset="UTF-8">
    <title>장바구니</title>
    <%@ include file="/WEB-INF/views/layout/util.jsp" %>

      <!-- vex modal -->
      <%@ include file="/WEB-INF/views/layout/vex-modal.jsp" %>

        <link rel="stylesheet" href="/app/resources/css/common/nav-with-header.css">
        <link rel="stylesheet" href="/app/resources/css/member/order/order.css">
        <script src="/app/resources/js/member/order/order.js" defer></script>
  </head>

  <body>
    <div class="container">
      <%@ include file="/WEB-INF/views/layout/nav-with-header-settings.jsp" %>
        <main class="main main-order">
          <h1>Order / Payment</h1>
          <div class="order__shipping">
            <h3>배송 정보</h3>
            <div class="shipping-info">
              <span>배송지</span>
              <div class="shipping-info__select">
                <c:forEach var="address" items="${requestScope.dto.addresses}" varStatus="status">
                  <c:if test="${address.defaultAddressYn eq 'Y'}">
                    <input type="radio" name="address" id="address${status.index}"
                      data-address-no="${address.addressNo}" checked>
                    <label for="address${status.index}">집</label>
                  </c:if>
                  <c:if test="${address.defaultAddressYn eq 'N'}">
                    <input type="radio" name="address" id="address${status.index}"
                      data-address-no="${address.addressNo}">
                    <label for="address${status.index}">${requestScope.dto.memberName}님의 배송지</label>
                  </c:if>
                </c:forEach>
              </div>
            </div>

            <div class="shipping-info">
              <span>이름 / 연락처</span>
              <div class="shipping-info__contact">
                <span>${requestScope.dto.memberName}</span>
                <span>${requestScope.dto.phoneNumber}</span>
              </div>
            </div>

            <div class="shipping-info">
              <span>주소</span>
              <div class="shipping-info__address">
                <span class="postcode">(${requestScope.dto.addresses[0].postcode})</span>
                <span class="address">${requestScope.dto.addresses[0].address}</span>
                <span class="extraAddress">${requestScope.dto.addresses[0].extraAddress}</span>
                <span class="detailedAddress">${requestScope.dto.addresses[0].detailedAddress}</span>
              </div>
            </div>

            <div class="shipping-info">
              <span>배송 요청사항</span>
              <div class="shipping-info__requirements">
                <select name="req" id="req">
                  <option value="?" selected="selected">${requestScope.dto.addresses[0].defaultShippingReq}</option>
                  <option value="1">부재 시 집 앞에 놔주세요</option>
                </select>
              </div>
            </div>

          </div>

        </main>
        <%@ include file="/WEB-INF/views/layout/footer.jsp" %>
    </div>
  </body>

  </html>