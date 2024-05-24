<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<header>
	  	<div id="header-div">
		    <span style="font-size:30px;cursor:pointer;margin-right: 10px;" onclick="openNav()">
		      &#9776;
		    </span>
		    <a style="font-size:30px;cursor:pointer;" href="/app/admin/home"><img src="/app/resources/img/logo.svg"></a>
	      <span id="div-icon">
			<a href="/app/home"><img src="/app/resources/img/icon__home.svg"></a>
			<a class="clickable adminInfo"><img src="/app/resources/img/icon__profile.svg"></a>
			<a href="#"><img src="/app/resources/img/icon__settings.svg"></a>
		  </span>
		  <div id="dropdown-menu" class="dropdown-menu">
		    <a href="/app/profile">내 정보 보기</a>
		    <a href="/app/logout">로그아웃</a>
		  </div>
	  	</div>
  	</header>
  	<hr/>