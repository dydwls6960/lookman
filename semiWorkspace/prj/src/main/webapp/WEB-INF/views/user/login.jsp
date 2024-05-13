<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
  <!DOCTYPE html>
  <html>

  <head>
    <meta charset="UTF-8">
    <title>로그인</title>
    <%@ include file="/WEB-INF/views/layout/util.jsp" %>
      <link rel="stylesheet" href="/app/resources/css/login.css">

  </head>

  <body>
    <div class="container">
      <%@ include file="/WEB-INF/views/layout/nav-mini.jsp" %>
      

      <main class="main main-login">
        <img src="/app/resources/img/logo.svg" alt="Logo image">
        <form action="/app/user/login" method="post" class="form form__login">
          <input type="email" name="id" id="id" placeholder="아이디 (이메일)">
          <input type="password" name="pwd" id="pwd" placeholder="비밀번호">
          <div class="submit-btn form__login--submit-btn"><button type="submit">로그인</button></div>
        </form>
        <div class="login__links">
          <a href="/user/find">아이디 · 비밀번호 찾기</a>
          <span>|</span>
          <a href="/user/join">회원가입</a>
        </div>
      </main>

      <%@ include file="/WEB-INF/views/layout/footer.jsp" %>
    </div>

  </body>

  </html>