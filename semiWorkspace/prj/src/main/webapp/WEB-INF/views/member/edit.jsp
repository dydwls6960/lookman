<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
  <!DOCTYPE html>
  <html>

  <head>
    <meta charset="UTF-8">
    <title>회원정보 수정</title>
    <%@ include file="/WEB-INF/views/layout/util.jsp" %>
      <link rel="stylesheet" href="/app/resources/css/join.css">
      <style type="text/css">
        .main-join {
          padding: 48px 0;
        }

        #id {
          grid-column: span 2;
        }
      </style>
      <script src="/app/resources/js/edit.js" defer></script>
      <link rel="stylesheet" href="/app/resources/css/common/nav-with-header.css">

  </head>

  <body>
    <div class="container">
      <%@ include file="/WEB-INF/views/layout/nav-with-header.jsp" %>

        <main class="main main-join">
          <!-- <img src="/app/resources/img/logo.svg" alt="Logo image"> -->
          <form action="/app/member/edit" method="post" class="form form__join">
            <input type="hidden" name="memberNo" value="${requestScope.loginMemberVo.memberNo}">
            <input type="email" name="id" id="id" placeholder="아이디 (이메일)*" value="${requestScope.loginMemberVo.id}"
              readonly required>

            <input type="password" name="currentPwd" placeholder="현재 비밀번호*" required>
            <input type="password" id="newPwd" name="newPwd" placeholder="새 비밀번호 (선택)">
            <input type="password" id="confirmNewPwd" name="confirmNewPwd" placeholder="새 비밀번호 확인 (선택)">

            <input type="text" name="name" id="name" placeholder="이름*" value="${requestScope.loginMemberVo.name}"
              required>
            <input type="tel" name="phone" id="phone" placeholder="전화번호 ('-' 없이)*"
              value="${requestScope.loginMemberVo.phoneNo}" minlength="8" maxlength="11" required>

            <div class="submit-btn form__join--submit-btn">
              <button type="submit">회원정보 수정</button>
            </div>
          </form>
        </main>

        <%@ include file="/WEB-INF/views/layout/footer.jsp" %>

    </div>

  </body>

  </html>