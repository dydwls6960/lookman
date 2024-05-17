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



        </main>

        <%@ include file="/WEB-INF/views/layout/footer.jsp" %>

    </div>
  </body>

  </html>