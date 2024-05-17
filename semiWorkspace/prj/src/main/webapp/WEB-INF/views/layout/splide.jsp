<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<script
	src="
      https://cdn.jsdelivr.net/npm/@splidejs/splide@4.1.4/dist/js/splide.min.js
      "></script>
<link
	href="
      https://cdn.jsdelivr.net/npm/@splidejs/splide@4.1.4/dist/css/splide.min.css
      "
	rel="stylesheet">


<script type="text/javascript" defer>
	document.addEventListener("DOMContentLoaded", function() {
		new Splide("#image-carousel", {
			// rewind: true,
			type : 'loop', //롤링 끝나면 반복
			autoplay : true, //자동시작
			perPage : 1, //한 페이지에 노출되는 이미지
			perMove : 1, //슬라이드 이미지 개수
			arrows : true,
			drag : false, //드래그 비활성
			interval : 4000, //3000ms(3초) 마다 슬라이드
			pauseOnHover : false, //마우스 오버시 일시정지 비활성
			pauseOnFocus : false, //포커스시 일시정지 비활성
			pagination : true
		//페이지네이션 점 비활성
		}).mount();
	});
</script>

<style type="text/css">
.splide__slide img {
	width: 100%;
	height: 448px;
	object-fit: cover;
}

#image-carousel {
	grid-column: span 3;
}
</style>