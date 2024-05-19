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
            <span>김태우님, 환영합니다.</span>
            <span>taewookim02@gmail.com</span>
          </div>
          <div class="settings__lower">
            <a href="#">내 정보 수정</a>
            <a href="#">배송지 관리</a>
            <a href="#">내가 쓴 리뷰</a>
            <a href="#">로그아웃</a>
          </div>
        </main>

        <%@ include file="/WEB-INF/views/layout/footer.jsp" %>
    </div>
  </body>

  </html>