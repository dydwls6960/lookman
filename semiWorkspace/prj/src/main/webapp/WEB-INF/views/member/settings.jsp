<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
  <!DOCTYPE html>
  <html>

  <head>
    <meta charset="UTF-8">
    <title>Lookman | 내 설정</title>
    <%@ include file="/WEB-INF/views/layout/util.jsp" %>
      <link rel="stylesheet" href="/app/resources/css/common/nav-with-header.css">

      <link rel="stylesheet" href="/app/resources/css/settings.css">
  </head>

  <body>
    <div class="container">
      <%@ include file="/WEB-INF/views/layout/nav-with-header-cart.jsp" %>
        <main class="main main-settings">
          <div class="settings__upper">
            <span class="settings__name">${requestScope.loginMemberVo.name}님, 환영합니다.</span>
            <span class="settings__email">${requestScope.loginMemberVo.id}</span>
            <span class="settings__phone">${requestScope.loginMemberVo.phoneNo}</span>
          </div>
          <div class="settings__lower">
            <a href="/app/member/edit" class="settings__link">내 정보 수정</a>
            <a href="/app/member/review" class="settings__link">내 리뷰 관리</a>
            <a href="/app/member/product-inquiry" class="settings__link">내 상품문의 관리</a>
            <a href="/app/member/order-inquiry" class="settings__link">내 주문문의 관리</a>
            <a href="/app/member/address" class="settings__link">배송지 관리</a>
            <a href="/app/member/logout" class="settings__link">로그아웃</a>
          </div>
        </main>

        <%@ include file="/WEB-INF/views/layout/footer.jsp" %>
    </div>
  </body>

  </html>