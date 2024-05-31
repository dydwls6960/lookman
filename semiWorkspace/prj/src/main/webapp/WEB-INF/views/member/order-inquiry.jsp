<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>내 주문문의 관리</title>
    <%@ include file="/WEB-INF/views/layout/util.jsp"%>
    <link rel="stylesheet" href="/app/resources/css/common/nav-with-header.css">
    <link rel="stylesheet" href="/app/resources/css/inquiry.css">

    <!-- vex modal -->
    <%@ include file="/WEB-INF/views/layout/vex-modal.jsp"%>
    <script type="text/javascript" src="/app/resources/js/member/order-inquiry.js" defer></script>
</head>

<body>
    <div class="container">
        <%@ include file="/WEB-INF/views/layout/nav-with-header.jsp"%>

        <main class="main main-product-inquiry">
            <section class="inquiry" id="inquiry">
                <h2 class="inquiry__heading">주문문의 (${requestScope.oidtoList.size()})</h2>
                <c:forEach var="inquiry" items="${requestScope.oidtoList}">
                    <div class="inquiry__item">
                        <div class="inquiry__item--upper">
                            <span>${inquiry.memberName}</span>
                            <div class="upper__div">
                                <div class="upper__div--text">
                                    <span class="inquiry__date"> 
                                        <c:if test="${not empty inquiry.responseDate}">
                                            ${inquiry.responseDate}
                                        </c:if>
                                        <c:if test="${empty inquiry.responseDate}">
                                            ${inquiry.askDate}
                                        </c:if>
                                    </span>
                                </div>
                                <div class="upper__div--btns">
                                    <button type="button" class="edit-btn"
                                        data-order-inquiry-no="${inquiry.orderInquiryNo}"
                                        data-member-no="${inquiry.memberNo}"
                                        data-title="${inquiry.title}"
                                        data-question-content="${inquiry.questionContent}"
                                        >수정</button>
                                    <button type="button" class="delete-btn"
                                        data-product-inquiry-no="${inquiry.orderInquiryNo}"
                                        data-member-no="${inquiry.memberNo}">삭제</button>
                                </div>
                            </div>
                        </div>
                        <div class="inquiry__item--mid">
                            <a href="/app/products/${inquiry.productNo}">
                                <img src="/app/resources/img/product/${inquiry.thumbnailFilename}"
                                    alt="img" class="inquiry__img">
                            </a>
                            <div class="img-div__text">
                                <div class="inquiry__name">${inquiry.title}</div>
                                <div class="inquiry__category">문의 상태: ${inquiry.status}</div>
                            </div>
                        </div>
                        <div class="inquiry__item--lower">
                            <p class="inquiry__content">${inquiry.questionContent}</p>
                            <c:if test="${not empty inquiry.responseContent}">
                                <p class="inquiry__response">답변: ${inquiry.responseContent}</p>
                            </c:if>
                        </div>
                    </div>
                </c:forEach>
            </section>
        </main>

        <%@ include file="/WEB-INF/views/layout/footer.jsp"%>
    </div>
</body>

</html>
