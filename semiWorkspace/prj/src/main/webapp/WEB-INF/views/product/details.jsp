<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
  <!DOCTYPE html>
  <html>

  <head>
    <meta charset="UTF-8">
    <title>Lookman 상품정보</title>
    <%@ include file="/WEB-INF/views/layout/util.jsp" %>
      <%@ include file="/WEB-INF/views/layout/splide.jsp" %>

        <link rel="stylesheet" href="/app/resources/css/product-details.css">

  </head>

  <body>
    <div class="container">
      <%@ include file="/WEB-INF/views/layout/nav-search.jsp" %>
        <main class="main main-details">

          <section id="image-carousel" class="splide" aria-label="Beautiful Images">
            <div class="splide__track">
              <ul class="splide__list">
                <li class="splide__slide">
                  <img src="/app/resources/img/product/img-1.jpg" alt="">
                </li>
                <li class="splide__slide">
                  <img src="/app/resources/img/product/img-2.jpg" alt="">
                </li>
                <li class="splide__slide">
                  <img src="/app/resources/img/product/img-3.jpg" alt="">
                </li>
              </ul>
            </div>
          </section>

          <section class="details__text">
            <div class="details__text--upper">
              <span class="text__seller">${requestScope.pvo.sellerNo}</span>
              <h1 class="text__name">${requestScope.pvo.name}</h1>
            </div>
            <span class="text__price">${requestScope.pvo.price}원</span>
            <p class="text__details">${requestScope.pvo.details}</p>

            <div class="details__text--lower">
              <div class="text__delievery">배송정보: 아디다스는 명절간 (2/8~2/10) 배송이 되지 않습니다.</div>
              <span class="text__review">
                구매후기: &nbsp;<img src="/app/resources/img/icon__star.svg" alt="starIcon" class="review__star"> 4.5 / <a
                  href="#details__review">3개</a>
              </span>
              <span class="text__hit">조회수: ${requestScope.pvo.hit}</span>
            </div>
          </section>

          <section class="details__imgs">
            <img alt="img" src="/app/resources/img/product/img-3.jpg">
            <img alt="img-1" src="/app/resources/img/product/img-4.jpg">
            <img alt="img" src="/app/resources/img/product/img-5.jpg">
          </section>


          <section class="details__review" id="details__review">
            <h2 class="review__heading">구매후기 (3)</h2>
            <div class="review__item">
              <div class="review__item--upper">
                <span>김철수</span>
                <div class="upper__div">
                  <img src="/app/resources/img/rating__stars.svg" alt="stars svg">
                  <div class="upper__div--text">
                    <span class="review__date">2024.05.17</span>
                    <a href="/app/report/4" class="review__report">신고</a>
                  </div>
                </div>
              </div>
              <div class="review__item--mid">
                <img src="/app/resources/img/product/img-1.jpg" alt="img" class="review__img">
                <div class="img-div__text">
                  <div class="review__name">
                    따뜻한 바람막이 (비 막아주는 소재)
                  </div>
                  <div class="review__category">
                    L / 검정색 / 2개 구매
                  </div>
                </div>
              </div>
              <div class="review__item--lower">
                <p class="review__content">
                  어우 너무 좋은 제품이네요어우 너무 좋은 제품이네요어우 너무 좋은 제품이네요어우 너무 좋은 제품이네요어우 너무 좋은 제품이네요어우 너무 좋은 제품이네요어우 너무 좋은 제품이네요어우
                  너무 좋은 제품이네요어우 너무 좋은 제품이네요어우 너무 좋은 제품이네요어우 너무 좋은 제품이네요어우 너무 좋은 제품이네요어우 너무 좋은 제품이네요어우 너무 좋은 제품이네요어우 너무
                  좋은 제품이네요어우 너무 좋은 제품이네요어우 너무 좋은 제품이네요어우 너무 좋은 제품이네요
                </p>
              </div>
            </div>
            <div class="review__item">
              <div class="review__item--upper">
                <span>김철수</span>
                <div class="upper__div">
                  <img src="/app/resources/img/rating__stars.svg" alt="stars svg">
                  <div class="upper__div--text">
                    <span class="review__date">2024.05.17</span>
                    <a href="/app/report/4" class="review__report">신고</a>
                  </div>
                </div>
              </div>
              <div class="review__item--mid">
                <img src="/app/resources/img/product/img-1.jpg" alt="img" class="review__img">
                <div class="img-div__text">
                  <div class="review__name">
                    따뜻한 바람막이 (비 막아주는 소재)
                  </div>
                  <div class="review__category">
                    L / 검정색 / 2개 구매
                  </div>
                </div>
              </div>
              <div class="review__item--lower">
                <p class="review__content">
                  어우 너무 좋은 제품이네요어우 너무 좋은 제품이네요어우 너무 좋은 제품이네요어우 너무 좋은 제품이네요어우 너무 좋은 제품이네요어우 너무 좋은 제품이네요어우 너무 좋은 제품이네요어우
                  너무 좋은 제품이네요어우 너무 좋은 제품이네요어우 너무 좋은 제품이네요어우 너무 좋은 제품이네요어우 너무 좋은 제품이네요어우 너무 좋은 제품이네요어우 너무 좋은 제품이네요어우 너무
                  좋은 제품이네요어우 너무 좋은 제품이네요어우 너무 좋은 제품이네요어우 너무 좋은 제품이네요
                </p>
              </div>
            </div>
            <div class="review__item">
              <div class="review__item--upper">
                <span>김철수</span>
                <div class="upper__div">
                  <img src="/app/resources/img/rating__stars.svg" alt="stars svg">
                  <div class="upper__div--text">
                    <span class="review__date">2024.05.17</span>
                    <a href="/app/report/4" class="review__report">신고</a>
                  </div>
                </div>
              </div>
              <div class="review__item--mid">
                <img src="/app/resources/img/product/img-1.jpg" alt="img" class="review__img">
                <div class="img-div__text">
                  <div class="review__name">
                    따뜻한 바람막이 (비 막아주는 소재)
                  </div>
                  <div class="review__category">
                    L / 검정색 / 2개 구매
                  </div>
                </div>
              </div>
              <div class="review__item--lower">
                <p class="review__content">
                  어우 너무 좋은 제품이네요어우 너무 좋은 제품이네요어우 너무 좋은 제품이네요어우 너무 좋은 제품이네요어우 너무 좋은 제품이네요어우 너무 좋은 제품이네요어우 너무 좋은 제품이네요어우
                  너무 좋은 제품이네요어우 너무 좋은 제품이네요어우 너무 좋은 제품이네요어우 너무 좋은 제품이네요어우 너무 좋은 제품이네요어우 너무 좋은 제품이네요어우 너무 좋은 제품이네요어우 너무
                  좋은 제품이네요어우 너무 좋은 제품이네요어우 너무 좋은 제품이네요어우 너무 좋은 제품이네요
                </p>
              </div>
            </div>
            <div class="review__item">
              <div class="review__item--upper">
                <span>김철수</span>
                <div class="upper__div">
                  <img src="/app/resources/img/rating__stars.svg" alt="stars svg">
                  <div class="upper__div--text">
                    <span class="review__date">2024.05.17</span>
                    <a href="/app/report/4" class="review__report">신고</a>
                  </div>
                </div>
              </div>
              <div class="review__item--mid">
                <img src="/app/resources/img/product/img-1.jpg" alt="img" class="review__img">
                <div class="img-div__text">
                  <div class="review__name">
                    따뜻한 바람막이 (비 막아주는 소재)
                  </div>
                  <div class="review__category">
                    L / 검정색 / 2개 구매
                  </div>
                </div>
              </div>
              <div class="review__item--lower">
                <p class="review__content">
                  어우 너무 좋은 제품이네요어우 너무 좋은 제품이네요어우 너무 좋은 제품이네요어우 너무 좋은 제품이네요어우 너무 좋은 제품이네요어우 너무 좋은 제품이네요어우 너무 좋은 제품이네요어우
                  너무 좋은 제품이네요어우 너무 좋은 제품이네요어우 너무 좋은 제품이네요어우 너무 좋은 제품이네요어우 너무 좋은 제품이네요어우 너무 좋은 제품이네요어우 너무 좋은 제품이네요어우 너무
                  좋은 제품이네요어우 너무 좋은 제품이네요어우 너무 좋은 제품이네요어우 너무 좋은 제품이네요
                </p>
              </div>
            </div>
          </section>

        </main>

        <%@ include file="/WEB-INF/views/layout/footer.jsp" %>

    </div>
  </body>

  </html>