<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
  <!DOCTYPE html>
  <html>

  <head>
    <meta charset="UTF-8">
    <title>찜한 상품</title>
    <%@ include file="/WEB-INF/views/layout/util.jsp" %>
      <link rel="stylesheet" href="/app/resources/css/common/nav-with-header.css">
      <link rel="stylesheet" href="/app/resources/css/favorite.css">

  </head>

  <body>
    <div class="container">
      <%@ include file="/WEB-INF/views/layout/nav-with-header-cart.jsp" %>
        <main class="main main-favorite">
          <h1 class="heading">찜한 상품</h1>
          <div class="favorite-items">
            <c:forEach var="dto" items="${requestScope.dtoList}">
              <div class="favorite-item">
                <a href="/app/products/${dto.productNo}">
                  <img class="favorite-item__img" src="/app/resources/img/product/${dto.thumbnailFilename}"
                    alt="${dto.productName}">
                </a>
                <div class="favorite-item__text">
                  <div class="text-seller"><a href="/app/search-by-store?sellerNo=${dto.sellerNo}">
                      ${dto.sellerName}
                    </a></div>
                  <div class="text-product">
                    <a class="text-product__name"
                      href="/app/products/${dto.productNo}"><strong>${dto.productName}</strong></a>
                    <p class="text-product__price">${dto.price}원</p>
                    <div class="text-product__fav-cnt">
                      <svg width="12" height="12" viewBox="0 0 24 24" fill="none" xmlns="http://www.w3.org/2000/svg">
                        <path
                          d="M22.5 9.18803C22.5016 9.90226 22.3616 10.6097 22.088 11.2695C21.8144 11.9293 21.4128 12.5282 20.9062 13.0318L12.5344 21.5274C12.4646 21.5983 12.3814 21.6545 12.2897 21.693C12.1979 21.7314 12.0994 21.7511 12 21.7511C11.9005 21.7511 11.8021 21.7314 11.7103 21.693C11.6186 21.6545 11.5354 21.5983 11.4656 21.5274L3.09374 13.0318C2.07307 12.0124 1.49917 10.6292 1.49829 9.18666C1.49741 7.74409 2.06963 6.36026 3.08905 5.33959C4.10848 4.31892 5.49161 3.74502 6.93418 3.74414C8.37674 3.74326 9.76057 4.31548 10.7812 5.3349L12 6.47397L13.2272 5.33115C13.9888 4.57327 14.958 4.05803 16.0122 3.85049C17.0665 3.64296 18.1586 3.75242 19.1507 4.16507C20.1428 4.57771 20.9904 5.27504 21.5865 6.16902C22.1826 7.06299 22.5005 8.11354 22.5 9.18803Z"
                          fill="#D81159" />
                      </svg>
                      <span>${dto.favoriteCnt}</span>
                    </div>
                  </div>
                </div>
              </div>
            </c:forEach>
          </div>
        </main>

        <%@ include file="/WEB-INF/views/layout/footer.jsp" %>
    </div>
  </body>

  </html>