<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
  <!DOCTYPE html>
  <html>

  <head>
    <meta charset="UTF-8">
    <title>내 주소 관리</title>
    <%@ include file="/WEB-INF/views/layout/util.jsp" %>
      <link rel="stylesheet" href="/app/resources/css/common/nav-with-header.css">
      <link rel="stylesheet" href="/app/resources/css/reviews.css">


      <!-- vex modal -->
      <%@ include file="/WEB-INF/views/layout/vex-modal.jsp" %>
        <script type="text/javascript" src="/app/resources/js/review.js" defer></script>


  </head>

  <body>
    <div class="container">
      <%@ include file="/WEB-INF/views/layout/nav-with-header.jsp" %>

        <main class="main main-review">
          <section class="review" id="review">
            <h2 class="review__heading">구매후기 (${requestScope.reviews.size()})</h2>
            <c:forEach var="review" items="${requestScope.reviews}">
              <div class="review__item">
                <div class="review__item--upper">
                  <span>${review.memberName}</span>
                  <div class="upper__div">
<!--                     <img src="/app/resources/img/rating__stars.svg" alt="stars svg"> -->
					<span><span style="color: #FFC633;">&#9733;</span> ${review.rating}</span>
                    <div class="upper__div--text">
                      <span class="review__date">
                        <c:if test="${not empty review.editedDate}">
                          ${review.editedDate}
                        </c:if>
                        <c:if test="${empty review.editedDate}">
                          ${review.createdDate}
                        </c:if>
                      </span>
                    </div>
                    <div class="upper__div--btns">
                      <button type="button" class="edit-btn" data-rating="${review.rating}"
                        data-content="${review.content}" data-review-no="${review.reviewNo}"
                        data-member-no="${review.memberNo}">수정</button>
                      <button type="button" class="delete-btn" data-review-no="${review.reviewNo}"
                        data-member-no="${review.memberNo}">삭제</button>
                    </div>
                  </div>
                </div>
                <div class="review__item--mid">
                  <a href="/app/products/${review.productNo}"><img
                      src="/app/resources/img/product/${review.thumbnailFilename}" alt="img" class="review__img"></a>
                  <div class="img-div__text">
                    <div class="review__name">
                      ${review.productName}
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
        </main>

        <%@ include file="/WEB-INF/views/layout/footer.jsp" %>

    </div>

  </body>

  </html>