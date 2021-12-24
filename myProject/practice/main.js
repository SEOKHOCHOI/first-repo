// 버튼 클릭시의 이벤트 처리

/* html 안에있는 클래스 노드들 중에 navbar__toogleBtn이라는
    클래스를 가진 아이를 찾아서 토글버튼에 연결시켜주는것.
*/
const $toogleBtn = document.querySelector('.navbar__toogleBtn');
const $menu = document.querySelector('.navbar__menu');
const $icons = document.querySelector('.navbar__icons');

// 토글버튼이 클릭 될때마다 이벤트 처리
// 클릭이 될때마다 여기 지정한 함수를 호출해줘 라는 뜻.
$toogleBtn.addEventListener('click', () => {
    /*
    메뉴와 icons에 있는 클래스 리스트중에 active리스트를 토글링할것.
    이 말은 마우스를 클릭했을때 메뉴와 아이콘에 클래스가 active가 없다면
    active를 추가해주고 있다면 active를 빼주는 일을 할 것.
    */
    $menu.classList.toggle('active');
    $icons.classList.toggle('active');
});