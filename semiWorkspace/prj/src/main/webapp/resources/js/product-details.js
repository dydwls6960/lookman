document.addEventListener("DOMContentLoaded", function() {
	new Splide("#image-carousel", {
		// rewind: true,
		type: 'loop', //롤링 끝나면 반복
		autoplay: true, //자동시작
		perPage: 1, //한 페이지에 노출되는 이미지
		perMove: 1, //슬라이드 이미지 개수
		arrows: true,
		drag: false, //드래그 비활성
		interval: 3000, //3000ms(3초) 마다 슬라이드
		pauseOnHover: false, //마우스 오버시 일시정지 비활성
		pauseOnFocus: false, //포커스시 일시정지 비활성
		pagination: false //페이지네이션 점 비활성
	}).mount();
});

