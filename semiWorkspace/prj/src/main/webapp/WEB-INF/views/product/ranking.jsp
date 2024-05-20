<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
  <!DOCTYPE html>
  <html>

  <head>
    <meta charset="UTF-8">
    <title>Lookman</title>
    <%@ include file="/WEB-INF/views/layout/util.jsp" %>
      <link rel="stylesheet" href="/app/resources/css/home.css">
      <script src="/app/resources/js/ranking.js" defer></script>
  </head>

  <body>
    <!-- <a href="/app/member/login">로그인</a> -->
    <div class="container">

      <%@ include file="/WEB-INF/views/layout/nav.jsp" %>



        <main class="main main-list">
          <c:forEach var="dto" items="${requestScope.dtoList}">

            <div class="main-list--item">
              <a href="/app/products/${dto.productNo}">
                <div class="item-container">
                  <div class="item-container__img">
                    <img loading="lazy" src="/app/resources/img/product/${dto.thumbnailFilename}" alt="Product image">
                  </div>
                  <div class="item-container__desc">
                    <div class="item-container__desc--price">${dto.price}원</div>
                    <p class="item-container__desc--name">${dto.sellerName} | ${dto.productName}</p>
                    <div class="item-container__desc--rating">
                      <div class="rating-star">
                        <svg width="8" height="8" viewBox="0 0 8 8" fill="none" xmlns="http://www.w3.org/2000/svg">
                          <g opacity="0.8" clip-path="url(#clip0_84_119)">
                            <path
                              d="M7.32154 3.58871L5.91529 4.80214L6.34373 6.61683C6.36737 6.71534 6.36128 6.81865 6.32624 6.9137C6.29119 7.00876 6.22876 7.09129 6.14684 7.15088C6.06491 7.21047 5.96716 7.24444 5.86593 7.2485C5.76471 7.25257 5.66455 7.22654 5.57811 7.17371L3.99998 6.20246L2.42092 7.17371C2.33449 7.22624 2.23445 7.25202 2.1334 7.2478C2.03235 7.24359 1.9348 7.20957 1.85304 7.15003C1.77129 7.0905 1.70897 7.0081 1.67395 6.91322C1.63893 6.81833 1.63276 6.71521 1.65623 6.61683L2.08623 4.80214L0.679981 3.58871C0.603511 3.52262 0.548207 3.43546 0.520975 3.33813C0.493743 3.24079 0.49579 3.13759 0.52686 3.04142C0.55793 2.94524 0.616647 2.86034 0.695677 2.79734C0.774707 2.73433 0.870548 2.69601 0.971231 2.68714L2.81498 2.53839L3.52623 0.817144C3.56473 0.723337 3.63025 0.643097 3.71447 0.586625C3.79869 0.530153 3.8978 0.5 3.9992 0.5C4.1006 0.5 4.19971 0.530153 4.28393 0.586625C4.36815 0.643097 4.43367 0.723337 4.47217 0.817144L5.18311 2.53839L7.02686 2.68714C7.12774 2.69568 7.22386 2.73379 7.30318 2.79671C7.38249 2.85963 7.44148 2.94455 7.47274 3.04085C7.50401 3.13714 7.50616 3.24052 7.47893 3.33803C7.4517 3.43555 7.3963 3.52285 7.31967 3.58902L7.32154 3.58871Z"
                              fill="#FFC633" />
                          </g>
                          <defs>
                            <clipPath id="clip0_84_119">
                              <rect width="8" height="8" fill="white" />
                            </clipPath>
                          </defs>
                        </svg>

                      </div>
                      <div class="rating-number">
                        <span class="rating-number__avg">${dto.avgRating}</span> <span
                          class="rating-number__cnt">(${dto.reviewCnt})</span>
                      </div>
                    </div>

                  </div>
                </div>
              </a>
            </div>

          </c:forEach>
        </main>


        <%@ include file="/WEB-INF/views/layout/footer.jsp" %>
    </div>
  </body>

  </html>