<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
  <!DOCTYPE html>
  <html>

  <head>
    <meta charset="UTF-8">
    <title>Lookman</title>
    <%@ include file="/WEB-INF/views/layout/util.jsp" %>
      <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/home.css">

  </head>

  <body>
    <div class="container">
      <%@ include file="/WEB-INF/views/layout/nav.jsp" %>

        <main class="main">
          <h1>환영합니다</h1>
          <a href="/app/user/login">로그인</a>
        </main>

        
      <%@ include file="/WEB-INF/views/layout/footer.jsp" %>
    </div>
  </body>

  </html>