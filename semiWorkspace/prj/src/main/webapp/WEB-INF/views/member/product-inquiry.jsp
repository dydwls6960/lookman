<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
  <!DOCTYPE html>
  <html>

  <head>
    <meta charset="UTF-8">
    <title>내 상품문의 관리</title>
    <%@ include file="/WEB-INF/views/layout/util.jsp" %>
      <link rel="stylesheet" href="/app/resources/css/common/nav-with-header.css">
      <link rel="stylesheet" href="/app/resources/css/reviews.css">


      <!-- vex modal -->
      <%@ include file="/WEB-INF/views/layout/vex-modal.jsp" %>
        <script type="text/javascript" src="/app/resources/js/review.js" defer></script>


  </head>

  <body>
    <div class="container">
      <%@ include file="/WEB-INF/views/layout/nav-with-header.jsp" %>

        <main class="main main-product-inquiry">
          
        </main>

        <%@ include file="/WEB-INF/views/layout/footer.jsp" %>

    </div>

  </body>

  </html>