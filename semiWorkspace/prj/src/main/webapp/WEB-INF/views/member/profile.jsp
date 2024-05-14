<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
  <!DOCTYPE html>
  <html>

  <head>
    <meta charset="UTF-8">
    <title>마이프로필</title>
    <%@ include file="/WEB-INF/views/layout/util.jsp" %>

      <link rel="stylesheet" href="/app/resources/css/common/nav-with-header.css">
      <link rel="stylesheet" href="/app/resources/css/profile.css">

      <script src="/app/resources/js/profile.js" defer></script>
  </head>

  <body>
    <div class="container">
      <%@ include file="/WEB-INF/views/layout/nav-with-header.jsp" %>

        <main class="main main-profile">
          <section class="profile__header--container">
            <div class="profile__header">
              <h1 class="profile__header--heading">주문·배송</h1>
              <p>최근순의 주문 내역입니다</p>
            </div>
            <div class="profile__statuses">
              <div class="profile__status status-active" data-status="입금/결제">
                <span class="profile__status--name">입금/결제</span>
                <span class="profile__status--count">3건</span>
              </div>
              <div class="profile__status" data-status="배송준비중">
                <span class="profile__status--name">배송준비중</span>
                <span class="profile__status--count">0건</span>
              </div>
              <div class="profile__status" data-status="배송중">
                <span class="profile__status--name">배송중</span>
                <span class="profile__status--count">0건</span>
              </div>
              <div class="profile__status" data-status="배송완료">
                <span class="profile__status--name">배송완료</span>
                <span class="profile__status--count">0건</span>
              </div>
              <div class="profile__status" data-status="취소">
                <span class="profile__status--name">취소</span>
                <span class="profile__status--count">0건</span>
              </div>
            </div>
          </section>


          <section class="profile__orders">
            <div class="profile__order">
              <div class="order__upper">
                <div class="order__upper--img">
                  <img src="/app/resources/img/product/img-1.jpg" alt="Product img" class="order__img">
                </div>
                <div class="order__upper--text">
                  <span class="text-seller">
                    포유바잉
                  </span>
                  <div class="text-container">
                    <span class="text-status">
                      <strong>배송중</strong>
                    </span>
                    <span class="text-name">
                      [해외] 문스타 스니커즈 810s 에잇텐스 ET028 PROTET 단화 신발 슈즈 남녀
                    </span>
                    <div class="text-categories">
                      <span class="text-color">블랙</span>
                      <span class="text-dash">/</span>
                      <span class="text-size">260</span>
                      <span class="text-dash">/</span>
                      <span class="text-quantity">1개</span>
                    </div>
                  </div>
                  <span class="text-price">
                    <strong>108,900원</strong>
                  </span>
                </div>
              </div>
              <div class="order__lower">
                <button class="order__inquire-btn">문의</button>
                <button class="order__cancel-btn">주문취소 요청</button>
              </div>
            </div>

            <div class="profile__order">
              <div class="order__upper">
                <div class="order__upper--img">
                  <img src="/app/resources/img/product/img-2.jpg" alt="Product img" class="order__img">
                </div>
                <div class="order__upper--text">
                  <span class="text-seller">
                    포유바잉
                  </span>
                  <div class="text-container">
                    <span class="text-status">
                      <strong>배송중</strong>
                    </span>
                    <span class="text-name">
                      [해외] 문스타 스니커즈 810s 에잇텐스 ET028 PROTET 단화 신발 슈즈 남녀
                    </span>
                    <div class="text-categories">
                      <span class="text-color">블랙</span>
                      <span class="text-dash">/</span>
                      <span class="text-size">260</span>
                      <span class="text-dash">/</span>
                      <span class="text-quantity">1개</span>
                    </div>
                  </div>
                  <span class="text-price">
                    <strong>108,900원</strong>
                  </span>
                </div>
              </div>
              <div class="order__lower">
                <button class="order__inquire-btn">문의</button>
                <button class="order__cancel-btn">주문취소 요청</button>
              </div>
            </div>

            <div class="profile__order">
              <div class="order__upper">
                <div class="order__upper--img">
                  <img src="/app/resources/img/product/img-3.jpg" alt="Product img" class="order__img">
                </div>
                <div class="order__upper--text">
                  <span class="text-seller">
                    포유바잉
                  </span>
                  <div class="text-container">
                    <span class="text-status">
                      <strong>배송중</strong>
                    </span>
                    <span class="text-name">
                      [해외] 문스타 스니커즈 810s 에잇텐스 ET028 PROTET 단화 신발 슈즈 남녀
                    </span>
                    <div class="text-categories">
                      <span class="text-color">블랙</span>
                      <span class="text-dash">/</span>
                      <span class="text-size">260</span>
                      <span class="text-dash">/</span>
                      <span class="text-quantity">1개</span>
                    </div>
                  </div>
                  <span class="text-price">
                    <strong>108,900원</strong>
                  </span>
                </div>
              </div>
              <div class="order__lower">
                <button class="order__inquire-btn">문의</button>
                <button class="order__cancel-btn">주문취소 요청</button>
              </div>
            </div>
          </section>

        </main>

        <%@ include file="/WEB-INF/views/layout/footer.jsp" %>
    </div>
  </body>

  </html>