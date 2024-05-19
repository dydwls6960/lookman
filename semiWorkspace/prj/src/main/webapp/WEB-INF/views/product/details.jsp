<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
  <!DOCTYPE html>
  <html>

  <head>
    <meta charset="UTF-8">
    <title>Lookman 상품정보</title>
    <%@ include file="/WEB-INF/views/layout/util.jsp" %>
      <%@ include file="/WEB-INF/views/layout/splide.jsp" %>
        <script src="https://code.jquery.com/ui/1.13.3/jquery-ui.js"></script>
        <link rel="stylesheet" href="https://code.jquery.com/ui/1.13.3/themes/base/jquery-ui.css">
		<link rel="stylesheet" href="/app/resources/css/product-details.css">
        <script defer>
          $(function () {
            $("#accordion").accordion();
          });
        </script>
  </head>

  <body>
    <div class="container">
      <%@ include file="/WEB-INF/views/layout/nav-search.jsp" %>
        <main class="main main-details">

          <section id="image-carousel" class="splide" aria-label="Beautiful Images">
            <div class="splide__track">
              <ul class="splide__list">
                <c:forEach var="img" items="${requestScope.dto.images}">
                  <li class="splide__slide">
                    <img src="/app/resources/img/product/${img.filename}" alt="product image">
                  </li>
                </c:forEach>
              </ul>
            </div>
          </section>

          <section class="details__text">
            <div class="details__text--upper">
              <span class="text__seller">${requestScope.dto.sellerName}</span>
              <h1 class="text__name">${requestScope.dto.productName}</h1>
            </div>
            <span class="text__price">${requestScope.dto.price}원</span>
            <p class="text__details">${requestScope.dto.details}</p>

            <div class="details__text--lower">
              <div class="text__delievery">배송정보: ${requestScope.dto.shippingDetails}</div>
              <span class="text__review">
                구매후기: &nbsp;<img src="/app/resources/img/icon__star.svg" alt="starIcon" class="review__star">
                ${requestScope.dto.avgRating} / <a href="#details__review">${requestScope.dto.reviewCnt}개</a>
              </span>
              <span class="text__hit">조회수: ${requestScope.dto.hit}</span>
            </div>
          </section>

          <section class="details__imgs">
            <c:forEach var="img" items="${requestScope.dto.images}">
              <img loading="lazy" alt="img" src="/app/resources/img/product/${img.filename}">
            </c:forEach>
          </section>


          <section class="details__review" id="details__review">
            <h2 class="review__heading">구매후기 (${requestScope.dto.reviewCnt})</h2>
            <c:forEach var="review" items="${requestScope.dto.reviews}">
              <div class="review__item">
                <div class="review__item--upper">
                  <span>${review.memberName}</span>
                  <div class="upper__div">
                    <img src="/app/resources/img/rating__stars.svg" alt="stars svg">
                    <div class="upper__div--text">
                      <span class="review__date">${review.createdDate}</span>
                      <a href="/app/report/${review.memberNo}" class="review__report">신고</a>
                    </div>
                  </div>
                </div>
                <div class="review__item--mid">
                  <img src="/app/resources/img/product/${requestScope.dto.thumbnailFilename}" alt="img"
                    class="review__img">
                  <div class="img-div__text">
                    <div class="review__name">
                      ${requestScope.dto.productName}
                    </div>
                    <div class="review__category">
                      ${review.productSize} / ${review.productColor} / ${review.orderQuantity}개 구매
                    </div>
                  </div>
                </div>
                <div class="review__item--lower">
                  <p class="review__content">
                    ${review.content}
                  </p>
                </div>
              </div>
            </c:forEach>
          </section>

          <section class="details__inquiry">
            <h2 class="inquiry__heading">Q&A 상품문의 (19)</h2>
            <div id="accordion" class="inquiry__item">
              <h3 class="accordion__header">배송언제오나요?</h3>
              <div>
                <p> Mauris mauris ante, blandit et, ultrices a, suscipit eget, quam. Integer
                  ut neque. Vivamus nisi metus, molestie vel, gravida in, condimentum sit
                  amet, nunc. Nam a nibh. Donec suscipit eros. Nam mi. Proin viverra leo ut
                  odio. Curabitur malesuada. Vestibulum a velit eu ante scelerisque vulputate.
                </p>
              </div>
              <h3>siasiasia?</h3>
              <div>
                <p> Mauris mauris ante, blandit et, ultrices a, suscipit eget, quam. Integer
                  ut neque. Vivamus nisi metus, molestie vel, gravida in, condimentum sit
                  amet, nunc. Nam a nibh. Donec suscipit eros. Nam mi. Proin viverra leo ut
                  odio. Curabitur malesuada. Vestibulum a velit eu ante scelerisque vulputate.
                </p>
              </div>
              <h3>siazzzsiasia?</h3>
              <div>
                <p> Mauris mauris ante, blandit et, ultrices a, suscipit eget, quam. Integer
                  ut neque. Vivamus nisi metus, molestie vel, gravida in, condimentum sit
                  amet, nunc. Nam a nibh. Donec suscipit eros. Nam mi. Proin viverra leo ut
                  odio. Curabitur malesuada. Vestibulum a velit eu ante scelerisque vulputate.
                </p>
              </div>
            </div>
          </section>

        </main>

        <%@ include file="/WEB-INF/views/layout/footer.jsp" %>

    </div>
  </body>

  </html>