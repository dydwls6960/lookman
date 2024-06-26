<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
  <!DOCTYPE html>
  <html>

  <head>
    <meta charset="UTF-8">
    <title>회원가입</title>
    <%@ include file="/WEB-INF/views/layout/util.jsp" %>
      <link rel="stylesheet" href="/app/resources/css/join.css">

      <!-- 다음 주소 api -->
      <script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js" defer></script>
      <script src="/app/resources/js/join.js" defer></script>

  </head>

  <body>
    <div class="container">
      <%@ include file="/WEB-INF/views/layout/nav-mini.jsp" %>

        <main class="main main-join">
          <img src="/app/resources/img/logo.svg" alt="Logo image">
          <form action="/app/member/join" method="post" class="form form__join">
            <input type="email" name="id" id="id" placeholder="아이디 (이메일)*" required>
            <button type="button" onclick="checkDuplicateId()">중복검사</button>

            <input type="password" name="pwd" id="pwd" placeholder="비밀번호*" required>

            <input type="password" name="pwd2" id="pwd2" placeholder="비밀번호 확인*" required>

            <input type="text" name="name" id="name" placeholder="이름*" required>

            <input type="tel" name="phone" id="phone" placeholder="전화번호 ('-' 없이)*" minlength="8" maxlength="11"
              required>

            <input type="text" name="postcode" id="postcode" placeholder="우편번호*" required>
            <button type="button" class="" onclick="execDaumPostcode()">우편번호
              검색</button>

            <input type="text" name="address" id="address" placeholder="주소*" required>

            <input type="text" name="address2" id="address2" placeholder="상세주소*" required>

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