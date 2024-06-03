<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div id="mySidenav" class="sidenav">
    <a href="javascript:void(0)" class="closebtn" onclick="closeNav()">&times;</a>
    <ul>
      <li>
        <a href="#" class="collapsed">회원관리 <span class="indicator">&#9654;</span></a>
        <ul>
          <li><a href="/app/admin/member">회원 목록</a></li>
          <li><a href="/app/admin/order">주문 목록</a></li>
        </ul>
      </li>
      <li>
        <a href="#" class="collapsed">판매자관리 <span class="indicator">&#9654;</span></a>
        <ul>
          <li><a href="/app/admin/seller">판매자 목록</a></li>
          <li><a href="#">상품 목록</a></li>
          <!--  <li><a href="#">판매자 수수료</a></li> -->
        </ul>
      </li>
      <!-- 
      <li>
        <a href="#" class="collapsed">고객센터 <span class="indicator">&#9654;</span></a>
        <ul>
          <li><a href="#">신고문의 리스트</a></li>
        </ul>
      </li>
       -->
      <li>
        <a href="#" class="collapsed">통계분석 <span class="indicator">&#9654;</span></a>
        <ul>
          <li><a href="/app/admin/statistics">통계</a></li>
          <!-- 
          <li><a href="#">판매자 통계</a></li>
          <li><a href="#">주문 통계</a></li>
           -->
        </ul>
      </li>
      <li>
        <a href="#" class="collapsed">사이트관리 <span class="indicator">&#9654;</span></a>
        <ul>
          <li><a href="#">카테고리 관리</a></li>
          <li><a href="#">아이콘 관리</a></li>
          <li><a href="#">FAQ 관리</a></li>
          <li><a href="#">QNA 관리</a></li>
        </ul>
      </li>
    </ul>
  </div>