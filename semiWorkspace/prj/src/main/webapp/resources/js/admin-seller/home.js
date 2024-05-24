function openNav() {
  document.getElementById("mySidenav").style.left = "0";
  document.getElementById("container").style.marginLeft = "250px";
  // 모바일 창 크기로 줄어들었을 때 아이콘 숨기기
    if (window.innerWidth <= 768) {
        document.getElementById("div-icon").style.display = "none";
    }
}

function closeNav() {
  document.getElementById("mySidenav").style.left = "-250px";
  document.getElementById("container").style.marginLeft = "0";
  // 현재 창이 모바일 창인지 확인
    if (window.innerWidth <= 768) {
        // 모바일 창이면 아이콘 다시 표시
        document.getElementById("div-icon").style.display = "flex";
    }
}

document.addEventListener('DOMContentLoaded', function() {
  var submenuLinks = document.querySelectorAll('.sidenav > ul > li > a');
  submenuLinks.forEach(function(link) {
    link.addEventListener('click', function(e) {
      var nextElement = link.nextElementSibling;
      if (nextElement && nextElement.tagName === 'UL') {
        e.preventDefault();
        if (nextElement.style.display === 'block') {
          nextElement.style.display = 'none';
          link.classList.remove('expanded');
          link.classList.add('collapsed');
        } else {
          document.querySelectorAll('.sidenav ul ul').forEach(function(submenu) {
            submenu.style.display = 'none'; // Close other submenus
          });
          document.querySelectorAll('.sidenav ul li a').forEach(function(otherLink) {
            otherLink.classList.remove('expanded');
            otherLink.classList.add('collapsed');
          });
          nextElement.style.display = 'block';
          link.classList.remove('collapsed');
          link.classList.add('expanded');
        }
      }
    });
  });
});

document.addEventListener('DOMContentLoaded', (event) => {
  const clickableElements = document.querySelectorAll('.clickable');
  const dropdownMenu = document.getElementById('dropdown-menu');
  const divIcon = document.getElementById('div-icon');

  clickableElements.forEach(element => {
    element.addEventListener('click', (event) => {
      event.preventDefault(); // 링크 클릭으로 인한 페이지 이동 방지
      const rect = divIcon.getBoundingClientRect();
      dropdownMenu.style.display = dropdownMenu.style.display === 'block' ? 'none' : 'block';
      dropdownMenu.style.width = rect.width + 'px';
      dropdownMenu.style.top = rect.bottom + 'px';
      dropdownMenu.style.left = rect.left + 'px';
    });
  });

  document.addEventListener('click', (event) => {
    if (!divIcon.contains(event.target) && !dropdownMenu.contains(event.target)) {
      dropdownMenu.style.display = 'none';
    }
  });
});

