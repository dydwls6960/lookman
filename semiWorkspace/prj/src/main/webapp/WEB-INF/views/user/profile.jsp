<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
  <!DOCTYPE html>
  <html>

  <head>
    <meta charset="UTF-8">
    <title>마이프로필</title>
    <%@ include file="/WEB-INF/views/layout/util.jsp" %>

      <link rel="stylesheet" href="/app/resources/css/common/nav-with-header.css">
      <link rel="stylesheet" href="/app/resources/css/profile.css">
  </head>

  <body>
    <div class="container">
      <%@ include file="/WEB-INF/views/layout/nav-with-header.jsp" %>

      <main class="main main-profile">
        <nav id="profile_nac">
        </nav>

        <div id="profile_nav_menu">
          <a href="">입금/결제<br>0건</a>
          <a href="">배송준비중<br>0건</a>
          <a href="">배송중<br>0건</a>
          <a href="">배송완료<br>0건</a>
          <a href="">취소/교환/환불<br>0건</a>
        </div>
      </main>
      <%@ include file="/WEB-INF/views/layout/footer.jsp" %>
    </div>
  </body>

  </html>