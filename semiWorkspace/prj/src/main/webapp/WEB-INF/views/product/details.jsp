<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
  <!DOCTYPE html>
  <html>

  <head>
    <meta charset="UTF-8">
    <title>Lookman 상품정보</title>
    <%@ include file="/WEB-INF/views/layout/util.jsp" %>
      <%@ include file="/WEB-INF/views/layout/splide.jsp" %>
        <%@ include file="/WEB-INF/views/layout/vex-modal.jsp" %>
          <script src="/app/resources/js/details.js" defer></script>


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
                  <li class="splide__slide"><img src="/app/resources/img/product/${img.filename}" alt="product image">
                  </li>
                </c:forEach>
              </ul>
            </div>
          </section>

          <section class="details__text">
            <div class="details__info">
              <div class="details__text--upper">
                <span class="text__seller">${requestScope.dto.sellerName}</span>
                <h1 class="text__name">${requestScope.dto.productName}</h1>
              </div>
              <span class="text__price">${requestScope.dto.price}원</span>
              <p class="text__details">${requestScope.dto.details}</p>
              <div class="details__text--lower">
                <span class="text__delivery">배송정보:
                  ${requestScope.dto.shippingDetails}</span>
                <span class="text__review"> 구매후기: &nbsp;<img src="/app/resources/img/icon__star.svg" alt="starIcon"
                    class="review__star"> ${requestScope.dto.avgRating} / <a
                    href="#details__review">${requestScope.dto.reviewCnt}개</a>
                </span> <span class="text__hit">조회수: ${requestScope.dto.hit}</span>
              </div>
            </div>
            <div class="details__action">
              <div class="details__action--upper">
                <div class="details__action--options">
                  <select name="color" id="color" class="option-select">
                    <option value="" disabled selected>옵션 선택</option>
                    <c:forEach var="idto" items="${requestScope.dto.inventoryDetails}">                    
                    	<option value="${idto.colorNo}">${idto.colorName}</option>
                    </c:forEach>
                  </select>
                  <select name="size" id="size" class="option-select">
                    <option value="" disabled selected>옵션 선택</option>
                    <c:forEach var="idto" items="${requestScope.dto.inventoryDetails}">                    
                    	<option value="${idto.sizeNo}">${idto.sizeName}</option>
                    </c:forEach>
                  </select>
                  <div class="details__action--items">
                    <div class="details__action--item">
                      <span>검정, S</span>
                      <input type="text" name="item-quantity" class="item-quantity" value="1" maxlength="3">
                      <div class="item-price-close-container">
                        <span>18,900원</span>
                        <button class="close-btn">&times; </button>
                      </div>
                    </div>
                    <div class="details__action--item">
                      <span>빨강, L</span>
                      <input type="text" name="item-quantity" class="item-quantity" value="1" maxlength="3">
                      <div class="item-price-close-container">
                        <span>28,900원</span>
                        <button class="close-btn">&times; </button>
                      </div>
                    </div>
                  </div>
                </div>
                <div class="details__action--total">
                  <span class="total-label">총 상품 금액</span>

                  <span class="total-price">47,800원</span>
                </div>
              </div>


              <div class="details__action--buttons">
                <button class="buy-btn">구매</button>
                <button class="fav-btn"><svg width="24" height="24" viewBox="0 0 24 24" fill="none"
                    xmlns="http://www.w3.org/2000/svg">
                    <path
                      d="M20.9064 5.34352C19.8874 4.32714 18.5075 3.75557 17.0683 3.75381C15.6291 3.75206 14.2478 4.32025 13.2264 5.33415L12.0001 6.47321L10.7729 5.3304C9.75176 4.31209 8.3679 3.74115 6.92577 3.74317C5.48365 3.74519 4.10139 4.32001 3.08308 5.34118C2.06478 6.36235 1.49383 7.74621 1.49585 9.18833C1.49788 10.6305 2.0727 12.0127 3.09386 13.031L11.4704 21.5304C11.5402 21.6013 11.6234 21.6575 11.7151 21.696C11.8069 21.7344 11.9053 21.7541 12.0048 21.7541C12.1043 21.7541 12.2027 21.7344 12.2945 21.696C12.3862 21.6575 12.4694 21.6013 12.5392 21.5304L20.9064 13.031C21.9254 12.0114 22.4978 10.6288 22.4978 9.18727C22.4978 7.74572 21.9254 6.36316 20.9064 5.34352ZM19.8423 11.9773L12.0001 19.931L4.15324 11.9698C3.41478 11.2313 2.99991 10.2297 2.99991 9.1854C2.99991 8.14106 3.41478 7.13948 4.15324 6.40102C4.8917 5.66256 5.89327 5.2477 6.93761 5.2477C7.98196 5.2477 8.98353 5.66256 9.72199 6.40102L9.74074 6.41977L11.4892 8.04634C11.628 8.17549 11.8105 8.2473 12.0001 8.2473C12.1897 8.2473 12.3723 8.17549 12.5111 8.04634L14.2595 6.41977L14.2782 6.40102C15.0172 5.66306 16.019 5.24887 17.0634 5.24957C18.1077 5.25028 19.109 5.66581 19.847 6.40477C20.585 7.14373 20.9991 8.14558 20.9984 9.18992C20.9977 10.2343 20.5822 11.2356 19.8432 11.9735L19.8423 11.9773Z"
                      fill="#333333" />
                  </svg>
                </button>
                <button class="cart-btn"><svg width="24" height="24" viewBox="0 0 24 24" fill="none"
                    xmlns="http://www.w3.org/2000/svg">
                    <path
                      d="M20.25 3.75H3.75C3.35218 3.75 2.97064 3.90804 2.68934 4.18934C2.40804 4.47064 2.25 4.85218 2.25 5.25V18.75C2.25 19.1478 2.40804 19.5294 2.68934 19.8107C2.97064 20.092 3.35218 20.25 3.75 20.25H20.25C20.6478 20.25 21.0294 20.092 21.3107 19.8107C21.592 19.5294 21.75 19.1478 21.75 18.75V5.25C21.75 4.85218 21.592 4.47064 21.3107 4.18934C21.0294 3.90804 20.6478 3.75 20.25 3.75ZM20.25 18.75H3.75V5.25H20.25V18.75ZM16.5 8.25C16.5 9.44347 16.0259 10.5881 15.182 11.432C14.3381 12.2759 13.1935 12.75 12 12.75C10.8065 12.75 9.66193 12.2759 8.81802 11.432C7.97411 10.5881 7.5 9.44347 7.5 8.25C7.5 8.05109 7.57902 7.86032 7.71967 7.71967C7.86032 7.57902 8.05109 7.5 8.25 7.5C8.44891 7.5 8.63968 7.57902 8.78033 7.71967C8.92098 7.86032 9 8.05109 9 8.25C9 9.04565 9.31607 9.80871 9.87868 10.3713C10.4413 10.9339 11.2044 11.25 12 11.25C12.7956 11.25 13.5587 10.9339 14.1213 10.3713C14.6839 9.80871 15 9.04565 15 8.25C15 8.05109 15.079 7.86032 15.2197 7.71967C15.3603 7.57902 15.5511 7.5 15.75 7.5C15.9489 7.5 16.1397 7.57902 16.2803 7.71967C16.421 7.86032 16.5 8.05109 16.5 8.25Z"
                      fill="#333333" />
                  </svg>
                </button>
              </div>
            </div>
          </section>

          <section class="details__imgs">
            <c:forEach var="img" items="${requestScope.dto.images}">
              <img loading="lazy" alt="img" src="/app/resources/img/product/${img.filename}">
            </c:forEach>
          </section>


          <section class="details__review" id="details__review">
            <h2 class="review__heading">구매후기
              (${requestScope.dto.reviewCnt})</h2>
            <c:forEach var="review" items="${requestScope.dto.reviews}">
              <div class="review__item">
                <div class="review__item--upper">
                  <span>${review.memberName}</span>
                  <div class="upper__div">
                    <img src="/app/resources/img/rating__stars.svg" alt="stars svg">
                    <div class="upper__div--text">
                      <span class="review__date">${review.createdDate}</span> <a href="/app/report/${review.memberNo}"
                        class="review__report">신고</a>
                    </div>
                  </div>
                </div>
                <div class="review__item--mid">
                  <img src="/app/resources/img/product/${requestScope.dto.thumbnailFilename}" alt="img"
                    class="review__img">
                  <div class="img-div__text">
                    <div class="review__name">${requestScope.dto.productName}
                    </div>
                    <div class="review__category">${review.productSize} /
                      ${review.productColor} / ${review.orderQuantity}개 구매</div>
                  </div>
                </div>
                <div class="review__item--lower">
                  <p class="review__content">${review.content}</p>
                </div>
              </div>
            </c:forEach>
          </section>

          <section class="details__inquiry">
            <h2 class="inquiry__heading">Q&A 상품문의
              (${requestScope.dto.inquiries.size()})</h2>
            <div id="accordion" class="inquiry__item">
              <c:forEach var="inquiry" items="${requestScope.dto.inquiries}">
                <h3 class="accordion__header">
                  <div class="inquiry__header">
                    <span class="inquiry-title">${inquiry.title}</span>
                    <div class="inquiry-info">

                      <span class="inquiry-user">${inquiry.memberName}</span> <span
                        class="inquiry-status">${inquiry.status}</span> <span
                        class="inquiry-date">${inquiry.questionDate}</span>

                    </div>
                  </div>
                </h3>
                <div>
                  <c:if test="${sessionScope.loginMemberVo.memberNo eq inquiry.memberNo}">
                    <div class="inquiry-controls">
                      <button type="button" class="edit-btn" data-product-no="${inquiry.productNo}"
                        data-product-inquiry-no="${inquiry.productInquiryNo}" data-member-no="${inquiry.memberNo}"
                        data-title="${inquiry.title}" data-question-content="${inquiry.questionContent}"
                        data-private-yn="${inquiry.privateYn}">수정</button>
                      <button type="button" class="delete-btn" data-product-no="${inquiry.productNo}"
                        data-product-inquiry-no="${inquiry.productInquiryNo}" data-member-no="${inquiry.memberNo}">
                        삭제
                        </butto>
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


            <c:if test="${not empty sessionScope.loginMemberVo}">
              <button class="add-btn" data-member-no="${sessionScope.loginMemberVo.memberNo}"
                data-seller-no="${requestScope.dto.sellerNo}" data-product-no="${requestScope.dto.productNo}"
                type="button">질문하기</button>
            </c:if>
          </section>

        </main>

        <%@ include file="/WEB-INF/views/layout/footer.jsp" %>

    </div>
  </body>

  </html>