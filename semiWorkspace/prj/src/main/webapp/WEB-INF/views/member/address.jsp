<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
  <!DOCTYPE html>
  <html>

  <head>
    <meta charset="UTF-8">
    <title>내 주소 관리</title>
    <%@ include file="/WEB-INF/views/layout/util.jsp" %>
      <link rel="stylesheet" href="/app/resources/css/common/nav-with-header.css">

      <link rel="stylesheet" href="/app/resources/css/address.css">
  </head>

  <body>
    <div class="container">
      <%@ include file="/WEB-INF/views/layout/nav-with-header-only.jsp" %>

        <main class="main main-address">
          <div class="address__header">
            <h2>내 주소</h2>
            <button class="add-btn" type="button">주소 추가</button>
          </div>
          <h3>주소</h3>
          <div class="address__item">
            <div class="address__upper">
              <div class="address-user">
                <span class="address__name">김태우</span>
                <div>|</div>
                <span class="address__number">01036207737</span>
              </div>
              <div class="address-controls">
                <button class="edit-btn" type="button">수정</button>
                <button class="delete-btn" type="button">삭제</button>
              </div>
            </div>

            <div class="address__med">
              <div class="address-container">
                <div class="address__med--general">경기 용인시 기흥구 기흥역로 16 (17066)</div>
                <div class="address__med--detail">107동 202호</div>
                <div class="address__med--extra">(구갈동, 기흥역지웰푸르지오)</div>
              </div>
              <div class="address-controls__default">
                <button class="default-btn" type="button">기본주소 지정</button>
              </div>
            </div>

            <div class="address__lower">
              <span class="badge__default-address">기본주소</span>
            </div>

          </div>
        </main>

        <%@ include file="/WEB-INF/views/layout/footer.jsp" %>

    </div>

  </body>

  </html>