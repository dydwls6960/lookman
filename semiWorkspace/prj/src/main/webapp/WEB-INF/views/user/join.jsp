<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
  <!DOCTYPE html>
  <html>

  <head>
    <meta charset="UTF-8">
    <title>회원가입</title>
    <%@ include file="/WEB-INF/views/layout/util.jsp"%>
    
  </head>

  <body>
    <h1>회원가입</h1>
    <a href="/app/home">홈으로 돌아가기</a>
    <a href="/app/user/login">로그인</a>

    <form action="/app/user/join" method="post" class="form form__join">
      <div class="input form__join--id">
        <label for="id">아이디</label>
        <input type="email" name="id" id="id">
      </div>

      <div class="input form__join-pwd">
        <label for="pwd">비밀번호</label>
        <input type="password" name="pwd" id="pwd">
      </div>

      <div class="input form__join-pwd2">
        <label for="pwd2">비밀번호 확인</label>
        <input type="password" name="pwd2" id="pwd2">
      </div>

      <div class="input form__join--name">
        <label for="name">이름</label>
        <input type="text" name="name" id="name">
      </div>

      <div class="input form__join--phone">
        <label for="phone">전화번호</label>
        <input type="text" name="phone" id="phone">
      </div>

      <div class="input form__join--postcode">
        <label for="postcode">우편번호</label>
        <input type="text" name="postcode" id="postcode">
        <button type="button" onclick="console.log('api 호출')">우편번호 검색</button>
      </div>

      <div class="input form__join--address">
        <label for="address">주소</label>
        <input type="text" name="address" id="address">
      </div>

      <div class="input form__join--address2">
        <label for="address2">상세주소</label>
        <input type="text" name="address2" id="address2">
      </div>

      <div class="submit-btn form__join--submit-btn">
        <button type="submit">회원가입</button>
      </div>
    </form>

  </body>

  </html>