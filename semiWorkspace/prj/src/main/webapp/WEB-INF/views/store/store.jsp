<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
  <!DOCTYPE html>
  <html>

  <head>
    <meta charset="UTF-8">
    <title>스토어</title>
    <%@ include file="/WEB-INF/views/layout/util.jsp" %>
      <link rel="stylesheet" href="/app/resources/css/common/nav.css">
      <link rel="stylesheet" href="/app/resources/css/store.css">

      <script src="/app/resources/js/store.js" defer></script>
  </head>

  <body>
    <div class="container">
      <%@ include file="/WEB-INF/views/layout/nav.jsp" %>
        <main class="main main-seller">
          <div class="seller__container">
            <c:forEach items="${requestScope.svoList}" var="svo">
              <a href="/app/search-by-store?sellerNo=${svo.sellerNo}" class="seller__item">
                <div class="seller__item--container">
                  <span class="seller-name">${svo.name}</span>
                  <span class="seller-info">${svo.info}</span>
                </div>
              </a>
            </c:forEach>
          </div>
        </main>

        <%@ include file="/WEB-INF/views/layout/footer.jsp" %>
    </div>
  </body>

  </html>