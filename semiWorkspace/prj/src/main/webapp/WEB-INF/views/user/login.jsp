<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
  <!DOCTYPE html>
  <html>

  <head>
    <meta charset="UTF-8">
    <title>로그인</title>
    <%@ include file="/WEB-INF/views/layout/util.jsp"%>
    
  </head>

  <body>

    <h1>로그인!</h1>
    <a href="/app/home">홈으로 돌아가기</a>
    <a href="/app/user/join">회원가입</a>

    <form action="/app/user/login" method="post" class="form form__login">
      <div class="input form__login--id">
        <label for="id">아이디</label>
        <input type="email" name="id" id="id" placeholder="아이디">
      </div>

      <div class="input form__login--pwd">
        <label for="pwd">비밀번호</label>
        <input type="password" name="pwd" id="pwd" placeholder="비밀번호">
      </div>

      <div class="submit-btn form__login--submit-btn"><button type="submit">로그인</button></div>
    </form>

  </body>

  </html>