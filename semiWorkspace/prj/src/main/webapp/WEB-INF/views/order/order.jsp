<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
  <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
    <!DOCTYPE html>
    <html>

    <head>
      <meta charset="UTF-8">
      <title>주문</title>
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
            <h1 class="heading">Order / Payment</h1>
            <section class="order__shipping">
              <h3>배송 정보</h3>
              <div class="shipping-info">
                <span>배송지</span>
                <div class="shipping-info__select">
                  <c:forEach var="address" items="${requestScope.dto.addresses}" varStatus="status">
                    <c:if test="${address.defaultAddressYn eq 'Y'}">
                      <div class="address-radio-container">
                        <input type="radio" name="address" id="address${status.index}"
                          data-address-no="${address.addressNo}" checked>
                        <label for="address${status.index}">집</label>
                      </div>
                    </c:if>
                    <c:if test="${address.defaultAddressYn eq 'N'}">
                      <div class="address-radio-container">
                        <input type="radio" name="address" id="address${status.index}"
                          data-address-no="${address.addressNo}">
                        <label for="address${status.index}">${requestScope.dto.memberName}님의 배송지</label>
                      </div>
                    </c:if>
                  </c:forEach>
                </div>
              </div>

              <div class="shipping-info">
                <span>이름 / 연락처</span>
                <div class="shipping-info__contact">
                  <span class="memberName">${requestScope.dto.memberName}</span>
                  <span class="phoneNumber">${requestScope.dto.phoneNumber}</span>
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
                  <input class="shippingReq" type="text" value="${requestScope.dto.addresses[0].defaultShippingReq}">
                </div>
              </div>

            </section>

            <section class="order__details">
              <h3>상품 정보</h3>
              <table class="cart__table">
                <thead>
                  <tr class="cart__table--header">
                    <th>상품명(옵션)</th>
                    <th>가격</th>
                    <th>수량</th>
                    <th>주문가격</th>
                  </tr>
                </thead>
                <tbody>

                  <c:forEach var="detail" items="${requestScope.dto.details}">
                    <tr>
                      <td>
                        <div class="product-details">
                          <a href="/app/products/${detail.productNo}" class="product-link"><img
                              class="product-detail__img" src="/app/resources/img/product/${detail.thumbnailFilename}"
                              alt="Product image"></a>
                          <div class="product-detail__text">
                            <p class="cart__seller-product">[${detail.sellerName}]
                              ${detail.productName}</p>
                            <%-- <p class="cart__product-name">${detail.productName}</p> --%>
                              <p class="cart__order-options">옵션: ${detail.colorName} /
                                ${detail.sizeName} / 재고 ${detail.inventoryQuantity}개 남음</p>
                          </div>
                        </div>
                      </td>
                      <td class="cart__price">
                        <fmt:formatNumber value="${detail.productPrice}" type="number" pattern="#,##0" />원
                      </td>
                      <td class="cart__order-quantity">${detail.orderQuantity}</td>
                      <td class="cart__order-price">
                        <fmt:formatNumber value="${detail.orderPrice}" type="number" pattern="#,##0" />원
                      </td>
                    </tr>
                  </c:forEach>
                </tbody>
                <tfoot>
                  <td>합계</td>
                  <td></td>
                  <td></td>
                  <td>
                    <fmt:formatNumber value="${requestScope.dto.totalPrice}" type="number" pattern="#,##0" />원
                  </td>
                </tfoot>
              </table>
            </section>

            <section class="order__payment">
              <h3>결제</h3>
              <div class="payment-info">
                <span>총 금액</span>
                <div class="payment-info__contact">
                  <span class="total-price">
                    <fmt:formatNumber value="${requestScope.dto.totalPrice}" type="number" pattern="#,##0" />원
                  </span>
                </div>
              </div>

              <div class="payment-info">
                <span>결제 수단</span>
                <div class="payment-info__method">
                  <div class="address-radio-container">
                    <input type="radio" name="payment-method" id="kakao" checked="checked">
                    <label for="kakao">카카오페이</label>
                  </div>
                  <div class="address-radio-container">
                    <input type="radio" name="payment-method" id="normal" disabled>
                    <label for="normal">일반결제</label>
                  </div>
                  <div class="address-radio-container">
                    <input type="radio" name="payment-method" id="toss" disabled>
                    <label for="toss">토스페이</label>
                  </div>
                </div>
              </div>

              <button type="button" id="pay-btn">결제하기</button>
            </section>

          </main>
          <%@ include file="/WEB-INF/views/layout/footer.jsp" %>
      </div>
    </body>

    </html>