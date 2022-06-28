let slide1 = document.querySelector('.slides1');
let slideImg1 = document.querySelectorAll('.slides1 li');
let currentIdx1 = 0;
slideCount1 = slideImg1.length;


prev1 = document.querySelector('.prev1'); //이전 버튼
next1 = document.querySelector('.next1'); //다음 버튼
slideWidth1 = 276; //슬라이드이미지 넓이
slideMargin1 = 20; //슬라이드 끼리의 마진값
makeClone1(); // 처음이미지와 마지막 이미지 복사 함수
initfunction1(); //슬라이드 넓이와 위치값 초기화 함수


function makeClone1() {
  let cloneSlide_first1 = slideImg1[0].cloneNode(true);
  let cloneSlide_last1 = slide1.lastElementChild.cloneNode(true);
  slide1.append(cloneSlide_first1);
  slide1.insertBefore(cloneSlide_last1, slide1.firstElementChild);
}

function initfunction1() {
  slide1.style.width = (slideWidth1 + slideMargin1) * (slideCount1+2) + 'px';
  slide1.style.left = -(slideWidth1 + slideMargin1) + 'px';
}

next1.addEventListener('click', function () {
  //다음 버튼 눌렀을때
  if (currentIdx1 <= slideCount1-4) {
    //슬라이드이동
    slide1.style.left = -(currentIdx1 + 2) * (slideWidth1 + slideMargin1) + 'px';
    slide1.style.transition = `${0.5}s ease-out`; //이동 속도
  }
  if (currentIdx1 == slideCount1-4) {
    //마지막 슬라이드 일때
    setTimeout(function () {
      //0.5초동안 복사한 첫번째 이미지에서, 진짜 첫번째 위치로 이동
      slide1.style.left = -(slideWidth1 + slideMargin1) + 'px';
      slide1.style.transition = `${0}s ease-out`;
    }, 0);
    currentIdx1 = -1;
  }
  currentIdx1 += 1;
});
prev1.addEventListener('click', function () {
  //이전 버튼 눌렀을때
  if (currentIdx1 >= 0) {
    slide1.style.left = -currentIdx1* (slideWidth1 + slideMargin1) + 'px';
    slide1.style.transition = `${0.5}s ease-out`;
  }
  if (currentIdx1 == 0) {
    setTimeout(function () {
      slide1.style.left = -(slideCount1-3) * (slideWidth1 + slideMargin1) + 'px';
      slide1.style.transition = `${0}s ease-out`;
    }, 0)
    currentIdx1 = slideCount1-3;
  }
  currentIdx1 -= 1;
});




let slide2 = document.querySelector('.slides2');
let slideImg2 = document.querySelectorAll('.slides2 li');
let currentIdx2 = 0;
slideCount2 = slideImg2.length;
prev2 = document.querySelector('.prev2'); //이전 버튼
next2 = document.querySelector('.next2'); //다음 버튼
slideWidth2 = 276; //슬라이드이미지 넓이
slideMargin2 = 20; //슬라이드 끼리의 마진값
makeClone2(); // 처음이미지와 마지막 이미지 복사 함수
initfunction2(); //슬라이드 넓이와 위치값 초기화 함수

function makeClone2() {
  let cloneSlide_first2 = slideImg2[0].cloneNode(true);
  let cloneSlide_last2 = slide2.lastElementChild.cloneNode(true);
  slide2.append(cloneSlide_first2);
  slide2.insertBefore(cloneSlide_last2, slide2.firstElementChild);
}
function initfunction2() {
  slide2.style.width = (slideWidth2 + slideMargin2) * (slideCount2 + 2) + 'px';
  slide2.style.left = -(slideWidth2 + slideMargin2) + 'px';
}
next2.addEventListener('click', function () {
  //다음 버튼 눌렀을때
  if (currentIdx2 <= slideCount2 - 4) {
    //슬라이드이동
    slide2.style.left = -(currentIdx2 + 2) * (slideWidth2 + slideMargin2) + 'px';
    slide2.style.transition = `${0.5}s ease-out`; //이동 속도
  }
  if (currentIdx2 == slideCount2 - 4) {
    //마지막 슬라이드 일때
    setTimeout(function () {
      //0.5초동안 복사한 첫번째 이미지에서, 진짜 첫번째 위치로 이동
      slide2.style.left = -(slideWidth2 + slideMargin2) + 'px';
      slide2.style.transition = `${0}s ease-out`;
    }, 0);
    currentIdx2 = -1;
  }
  currentIdx2 += 1;
});
prev2.addEventListener('click', function () {
  //이전 버튼 눌렀을때
  // console.log(currentIdx2);
  if (currentIdx2 >= 0) {
    slide2.style.left = -currentIdx2 * (slideWidth2 + slideMargin2) + 'px';
    slide2.style.transition = `${0.5}s ease-out`;
  }
  if (currentIdx2 == 0) {
    setTimeout(function () {
      slide2.style.left = -(slideCount2-3) * (slideWidth2 + slideMargin2) + 'px';
      slide2.style.transition = `${0}s ease-out`;
    }, 0);
    currentIdx2 = slideCount2-3;
  }
  currentIdx2 -= 1;
});










let slide3 = document.querySelector('.slides3');
let slideImg3 = document.querySelectorAll('.slides3 li');
let currentIdx3 = 0;
slideCount3 = slideImg3.length;
prev3 = document.querySelector('.prev3'); //이전 버튼
next3 = document.querySelector('.next3'); //다음 버튼
slideWidth3 = 276; //슬라이드이미지 넓이
slideMargin3 = 20; //슬라이드 끼리의 마진값
makeClone3(); // 처음이미지와 마지막 이미지 복사 함수
initfunction3(); //슬라이드 넓이와 위치값 초기화 함수

function makeClone3() {
  let cloneSlide_first3 = slideImg3[0].cloneNode(true);
  let cloneSlide_last3 = slide3.lastElementChild.cloneNode(true);
  slide3.append(cloneSlide_first3);
  slide3.insertBefore(cloneSlide_last3, slide3.firstElementChild);
}
function initfunction3() {
  slide3.style.width = (slideWidth3 + slideMargin3) * (slideCount3 + 2) + 'px';
  slide3.style.left = -(slideWidth3 + slideMargin3) + 'px';
}
next3.addEventListener('click', function () {
  //다음 버튼 눌렀을때
  if (currentIdx3 <= slideCount3 - 4) {
    // console.log(currentIdx3);
    //슬라이드이동
    slide3.style.left = -(currentIdx3 + 2) * (slideWidth3 + slideMargin3) + 'px';
    slide3.style.transition = `${0.5}s ease-out`; //이동 속도
  }
  if (currentIdx3 == slideCount3 - 4) {
    //마지막 슬라이드 일때
    setTimeout(function () {
      //0.5초동안 복사한 첫번째 이미지에서, 진짜 첫번째 위치로 이동
      slide3.style.left = -(slideWidth3 + slideMargin3) + 'px';
      slide3.style.transition = `${0}s ease-out`;
    }, 0);
    currentIdx3 = -1;
  }
  currentIdx3 += 1;
});
prev3.addEventListener('click', function () {
  //이전 버튼 눌렀을때
  if (currentIdx3 >= 0) {
    slide3.style.left = -currentIdx3 * (slideWidth3 + slideMargin3) + 'px';
    slide3.style.transition = `${0.5}s ease-out`;
  }
  if (currentIdx3 == 0) {
    setTimeout(function () {
      slide3.style.left = -(slideCount3-3) * (slideWidth3 + slideMargin3) + 'px';
      slide3.style.transition = `${0}s ease-out`;
    }, 0);
    currentIdx3 = slideCount3-3;
  }
  currentIdx3 -= 1;
})
