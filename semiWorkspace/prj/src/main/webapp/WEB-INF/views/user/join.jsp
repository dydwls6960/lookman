<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
  <!DOCTYPE html>
  <html>

  <head>
    <meta charset="UTF-8">
    <title>회원가입</title>
    <%@ include file="/WEB-INF/views/layout/util.jsp" %>
      <link rel="stylesheet" href="/app/resources/css/join.css">
      <script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js" defer></script>
      <script src="/app/resources/js/join.js" defer></script>

  </head>

  <body>
    <div class="container">
      <%@ include file="/WEB-INF/views/layout/nav-mini.jsp" %>

        <main class="main main-join">
          <img src="/app/resources/img/logo.svg" alt="Logo image">
          <form action="/app/user/join" method="post" class="form form__join">
            <input type="email" name="id" id="id" placeholder="아이디">
            <button type="button" onclick="console.log('api 호출')">중복검사</button>

            <input type="password" name="pwd" id="pwd" placeholder="비밀번호">

            <input type="password" name="pwd2" id="pwd2" placeholder="비밀번호 확인">

            <input type="text" name="name" id="name" placeholder="이름">

            <input type="text" name="phone" id="phone" placeholder="전화번호">

            <input type="text" name="postcode" id="postcode" placeholder="우편번호">
            <button type="button" onclick="console.log('api 호출')">우편번호
              검색</button>

            <input type="text" name="address" id="address" placeholder="주소">

            <input type="text" name="address2" id="address2" placeholder="상세주소">

            <input type="text" name="extraAddress" id="extraAddress" placeholder="참고사항">

            <div class="submit-btn form__join--submit-btn">
              <button type="submit">회원가입</button>
            </div>
          </form>
        </main>

        <%@ include file="/WEB-INF/views/layout/footer.jsp" %>

    </div>

  </body>

  </html>