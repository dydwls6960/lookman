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
              <div class="text__delivery">배송정보: ${requestScope.dto.shippingDetails}</div>
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
            <h2 class="inquiry__heading">Q&A 상품문의 (${requestScope.dto.inquiries.size()})</h2>
            <div id="accordion" class="inquiry__item">
              <c:forEach var="inquiry" items="${requestScope.dto.inquiries}">
                <h3 class="accordion__header">
                  <div class="inquiry__header">
                    <span class="inquiry-title">${inquiry.title}</span>
                    <div class="inquiry-info">
                    	
                    	<span class="inquiry-user">${inquiry.memberName}</span>
	                    <span class="inquiry-status">${inquiry.status}</span>
	                    <span class="inquiry-date">${inquiry.questionDate}</span>
	                    
                    </div>
                  </div>
                </h3>
                <div>
             		<c:if test="${sessionScope.loginMemberVo.memberNo eq inquiry.memberNo}">
                 		<div class="inquiry-controls">
	                 		<a href="/app/inquiry/edit/${inquiry.productInquiryNo}">수정</a>
	                 		<a href="/app/inquiry/delete/${inquiry.productInquiryNo}">삭제</a>
                 		</div>
                 	</c:if>
                  <p>${inquiry.questionContent}</p>
                  
                  <c:if test="${not empty inquiry.responseContent}">
	                  <div class="accordion__answer">
	                    <span class="accordion__answer--seller">
	                      ${inquiry.sellerName} <br> 
	                    </span>
	                    <p class="accordion__answer--content">${inquiry.responseContent}</p>
	                    <span class="accordion__answer--date">${inquiry.responseDate}</span>
	                  </div>
                  </c:if>
                </div>
              </c:forEach>
            </div>
          </section>

        </main>

        <%@ include file="/WEB-INF/views/layout/footer.jsp" %>

    </div>
  </body>

  </html>