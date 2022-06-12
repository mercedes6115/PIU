


let slides = document.querySelector('.slides');
let slideImg = document.querySelectorAll('.slides li');

let bannerBackground = document.querySelector('.banner-background');
let bannerBackground2 = document.querySelector('.myProgress');
console.log(bannerBackground);
currentIdx = 0;
slideCount = slideImg.length;
prev = document.querySelector('.prev'); //이전 버튼
next = document.querySelector('.next'); //다음 버튼
slideWidth = 550; //슬라이드이미지 넓이

let width11 = document.querySelector('#slideShow').offsetWidth;
console.log(width11);
slideMargin = 100; //슬라이드 끼리의 마진값
makeClone(); // 처음이미지와 마지막 이미지 복사 함수
initfunction(); //슬라이드 넓이와 위치값 초기화 함수
function makeClone() {
  let cloneSlide_first = slideImg[0].cloneNode(true);
  let cloneSlide_last = slides.lastElementChild.cloneNode(true);
  slides.append(cloneSlide_first);
  slides.insertBefore(cloneSlide_last, slides.firstElementChild);
  
}
function initfunction() {
  slides.style.width = (slideWidth + slideMargin) * (slideCount + 2) + 'px';
  slides.style.left = -(slideWidth + slideMargin) + 'px';
}
next.addEventListener('click', function () {
  //다음 버튼 눌렀을때

  move();
  if (currentIdx <= slideCount - 1) {
    //슬라이드이동
    slides.style.left = -(currentIdx + 2) * (slideWidth + slideMargin) + 'px';
    slides.style.transition = `${0.5}s ease-out`; //이동 속도
  }
  if (currentIdx === slideCount - 1) {
    //마지막 슬라이드 일때
    setTimeout(function () {
      //0.5초동안 복사한 첫번째 이미지에서, 진짜 첫번째 위치로 이동
      slides.style.left = -(slideWidth + slideMargin) + 'px';
      slides.style.transition = `${0}s ease-out`;
    }, 500);
    currentIdx = -1;
  }
  currentIdx += 1;
});
prev.addEventListener('click', function () {
  //이전 버튼 눌렀을때

  if (currentIdx >= 0) {
    slides.style.left = -currentIdx * (slideWidth + slideMargin) + 'px';
    slides.style.transition = `${0.5}s ease-out`;
  }
  if (currentIdx === 0) {
    prev1.disabled=true;
    setTimeout(function () {
      slides.style.left = -slideCount * (slideWidth + slideMargin) + 'px';
      slides.style.transition = `${0}s ease-out`;
    }, 500);
    currentIdx = slideCount;
  }
  currentIdx -= 1;
});



const intervalclick = function(){
  next.click();
  move();
}

var colorIndex=[
  '#1F89FF',
  '#3088e9',
  '#3a85d8',
  '#4385cd',
  '#417ab8',
  '#3b6fa9',
  '#4c7fb8'
]


function move() {
  if (i == 0) {
    i = 1;
    var elem = document.getElementById("myBar");
    var width = 1;
    var id = setInterval(frame, 2500);
    function frame() {
      if (width >= 100) {
        clearInterval(id);
        i = 0;
      } else {
        width++;
        elem.style.width = width + "%";
      }
    }
  }
}

const intervals = setInterval(intervalclick,2500);


function colorChange(){
  const rand = Math.floor(Math.random() * 10);
  var colorIndex=[
  '#1F89FF',
  '#478ad5',
  '#3590c0',
  '#347395',
  '#129de7',
  '#129de7',
  '#91b9e6',
  '#b7d2f1;',
  '#0b3e78',
  '#bcd3ec;'

  ]
bannerBackground.style.backgroundColor=colorIndex[rand];
bannerBackground.style.transition = `${0.5}s ease-out`;
console.log(colorIndex[rand]);
}

function changeBanner(){
  let timer = setInterval('colorChange()',2000);
  console.log("123");
}

changeBanner();
