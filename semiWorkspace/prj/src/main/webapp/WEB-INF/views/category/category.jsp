<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
  <!DOCTYPE html>
  <html>

  <head>
    <meta charset="UTF-8">
    <title>카테고리</title>
    <%@ include file="/WEB-INF/views/layout/util.jsp" %>
      <link rel="stylesheet" href="/app/resources/css/common/nav.css">
      <link rel="stylesheet" href="/app/resources/css/category.css">
      <script src="/app/resources/js/category.js" defer></script>
  </head>

  <body>
    <div class="container">
      <%@ include file="/WEB-INF/views/layout/nav.jsp" %>
        <main class="main main-category">
          <div class="catagory__container">
            <c:forEach items="${requestScope.cvoList}" var="cvo">
              <a href="/app/search-by-category?categoryNo=${cvo.categoryNo}" class="category__item">${cvo.name}</a>
            </c:forEach>
          </div>
        </main>

        <%@ include file="/WEB-INF/views/layout/footer.jsp" %>
    </div>
  </body>

  </html>