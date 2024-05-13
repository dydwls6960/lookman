<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

  <nav class="nav nav-with-header">
    <a href="javascript:history.back()"> <img src="/app/resources/img/icon__arrow-left.svg" alt="Arrow left icon">
    </a>
    <div class="nav__title">
      <!-- TODO: add dynamic heading -->
      <!-- <strong>${pageTitle}</strong> -->
      <strong>마이 페이지</strong>
    </div>
    <div class="nav__icons">
      <!-- TODO: add userid -->
      <a href="/app/cart?userId=${userId}"> <img src="/app/resources/img/icon__cart.svg" alt="Cart icon">
      </a>
      <!-- TODO: add userid -->
      <a href="/app/member/settings?userId=${userId}"> <img src="/app/resources/img/icon__settings.svg"
          alt="Setting icon">
      </a>
    </div>
  </nav>