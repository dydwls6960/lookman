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
        <link rel="stylesheet" href="/app/resources/css/cart.css">
        <script src="/app/resources/js/member/cart/cart.js" defer></script>

  </head>

  <body>
    <div class="container">
      <%@ include file="/WEB-INF/views/layout/nav-with-header-settings.jsp" %>
        <main class="main main-cart">
          <h1>장바구니</h1>
          <table class="cart__table">
            <thead>
              <tr class="cart__table--header">
                <th>전체 ${requestScope.dtoList.size()}개</th>
                <th><input type="checkbox" name="check-all" id="check-all" checked></th>
                <th>상품명(옵션)</th>
                <th>가격</th>
                <th>수량</th>
                <th>총가격</th>
                <th>주문관리</th>
              </tr>
            </thead>
            <tbody>
              <c:forEach var="dto" items="${requestScope.dtoList}">
                <tr>
                  <td>${dto.rownum}</td>
                  <td class="checkbox-td"><input class="item-checkbox" type="checkbox" name="${dto.cartNo}"
                      id="${dto.cartNo}" data-cart-no="${dto.cartNo}" data-member-no="${dto.memberNo}" checked></td>
                  <td>
                    <div class="product-details">
                      <a href="/app/products/${dto.productNo}" class="product-link"><img class="product-detail__img"
                          src="/app/resources/img/product/${dto.thumbnailFilename}" alt="Product image"></a>
                      <div class="product-detail__text">
                        <p class="cart__seller-product">[${dto.sellerName}]
                          ${dto.productName}</p>
                        <%-- <p class="cart__product-name">${dto.productName}</p> --%>
                          <p class="cart__order-options">옵션: ${dto.colorName} /
                            ${dto.sizeName} / 재고 ${dto.inventoryQuantity}개 남음</p>
                      </div>
                    </div>
                  </td>
                  <td class="cart__price">${dto.price}</td>
                  <td class="cart__order-quantity">${dto.orderQuantity}</td>
                  <td class="cart__order-price">${dto.orderPrice}</td>
                  <td><button class="del-btn" data-cart-no="${dto.cartNo}"
                      data-member-no="${dto.memberNo}">삭제하기</button></td>
                </tr>
              </c:forEach>
            </tbody>
          </table>
          <button class="del-sel-button" data-member-no="${sessionScope.loginMemberVo.memberNo}">선택삭제</button>

          <div class="order-btn-container">
            <button class="order-btn" data-member-no="${sessionScope.loginMemberVo.memberNo}">주문하기</button>
          </div>

        </main>
        <%@ include file="/WEB-INF/views/layout/footer.jsp" %>
    </div>
  </body>

  </html>