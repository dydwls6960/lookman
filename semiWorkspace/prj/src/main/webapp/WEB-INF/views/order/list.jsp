<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
  <!DOCTYPE html>
  <html>

  <head>
    <meta charset="UTF-8">
    <title>마이프로필</title>
    <%@ include file="/WEB-INF/views/layout/util.jsp" %>

      <link rel="stylesheet" href="/app/resources/css/common/nav-with-header.css">
      <link rel="stylesheet" href="/app/resources/css/member/order/list.css">

      <%@ include file="/WEB-INF/views/layout/vex-modal.jsp" %>
        <script src="/app/resources/js/member/order/list.js" defer></script>
  </head>

  <body>
    <div class="container">
      <%@ include file="/WEB-INF/views/layout/nav-with-header.jsp" %>

        <main class="main main-profile">
          <section class="profile__header--container">
            <div class="profile__header">
              <h1 class="profile__header--heading">주문·배송</h1>
              <p>최근순의 주문 내역입니다</p>
            </div>
            <div class="profile__statuses">
              <c:forEach var="status" items="${statusDtoList}">
                <a href="/app/orders/list?statusNo=${status.statusNo}" class="status__link">
                  <div class="profile__status status-${status.statusNo}" data-status="${status.statusName}">
                    <span class="profile__status--name">${status.statusName}</span> <span
                      class="profile__status--count">${status.count}건</span>
                  </div>
                </a>
              </c:forEach>
            </div>
          </section>




          <section class="profile__orders">
            <c:if test="${not empty requestScope.dtoList}">
              <table class="orders__table">
                <thead>
                  <tr class="orders__table--header">
                    <th>상품명(옵션)</th>
                    <th>주문날짜</th>
                    <th>주문번호</th>
                    <th>가격(수량)</th>
                    <th>총가격</th>
                    <th>주문상태</th>
                    <th>관리</th>
                  </tr>
                </thead>
                <tbody>
                  <c:forEach var="dto" items="${requestScope.dtoList}">
                    <tr>
                      <td>
                        <div class="product-details">
                          <a href="/app/products/${dto.productNo}" class="product-link">
                            <img class="product-detail__img" src="/app/resources/img/product/${dto.thumbnailFilename}"
                              alt="Product image">
                          </a>
                          <div class="product-detail__text">

                            <p class="orders__seller"><a
                                href="/app/search-by-store?sellerNo=${dto.sellerNo}">[${dto.sellerName}]</a></p>
                            <p class="orders__product"><a
                                href="/app/products/${dto.productNo}"><strong>${dto.productName}</strong></a></p>
                            <p class="orders__order-options">옵션: ${dto.colorName} /
                              ${dto.sizeName}</p>
                          </div>
                        </div>
                      </td>
                      <td class="orders__date">${dto.orderDate}</td>
                      <td>${dto.ordersNo}</td>
                      <td class="orders__price-quantity">${dto.productPrice}원<br><span
                          class="orders-quantity">${dto.orderDetailQuantity}개</span></td>
                      <td class="orders__total-price">${dto.orderDetailPrice}원</td>
                      <td class="orders__status">${dto.orderDetailStatusName}</td>
                      <td class="action-td">
                        <button class="ask-btn" data-order-detail-no="${dto.orderDetailNo}">주문 문의</button>
                        <br>
                        <button class="review-btn" data-order-detail-no="${dto.orderDetailNo}">리뷰 작성</button>
                      </td>
                    </tr>
                  </c:forEach>
                </tbody>
              </table>
            </c:if>
            <c:if test="${empty requestScope.dtoList}">
              <h3 class="empty-heading">목록이 비어있습니다.</h3>
            </c:if>
          </section>

        </main>

        <%@ include file="/WEB-INF/views/layout/footer.jsp" %>
    </div>
  </body>

  </html>