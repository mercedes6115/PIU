
const btns = document.querySelectorAll("button.btn");
const banner = document.querySelector(".swiper-imgWrapper1");
prevBtn = document.querySelector('.previous-button1'); //이전 버튼
nextBtn = document.querySelector('.next-button1'); //다음 버튼
var currentBannerIdx = 0; // 현재 슬라이드 인덱스 번호
var bannerCount=6; // 총 슬라이드 수

let bannerBackground11 = document.getElementById("bannerBackGround"); // 배너 뒷배경 왼쪽
let bannerBackgroundright = document.getElementById("banner-container-rightside"); // 배너 뒷배경 오른쪽

let bannerTexts=document.getElementById("advertising-text");

let CurrentBannerNumber=document.getElementById("CurrentBannerNumber");
var elem = document.getElementById("progress-bar-loading2");
console.log(CurrentBannerNumber);


let zeroIndex=[
    '01',
    '02',
    '03',
    '04',
    '05',
    '06'
]


let backImgs=[
'poster1.png',
'poster2.jpg',
'poster3.jpg',
'poster4.jpg',
'poster5.png',
'poster6.png'
]

var rightColorIndex=[ // 배너 오른쪽 색상 배열로 묶어줌
'#c9e9f6',
'#9bdbd8',
'#cefff2',
'#a6d0fc',
'#229f8c',
'#1691db'
]

var addsText=[ // 배너 문구
'플로깅은 여러분의 건강과 함께 환경을 개선해 나갑니다',
'"이삭을 줍는다(polcka upp)"는 뜻의 스웨덴어과 영어 조깅 (jogging)의 합성어',
'테스트 중입니다 광고 문구는 신경쓰지 말아주세요',
'이렇게 쉬운걸 왜 이제서야 하는거니',
'역시 사람은 심각한걸 느껴야 정신을 차립니다',
'정신 차립시다'
]



bannerWidth = 660; //슬라이드이미지 width
bannerMargin = 16; // 슬라이드간 margin



//Progress Bar
var i=0;
function move() {
  if (i == 0) {
    i = 1;
    var elem = document.getElementById("progress-bar-loading2");
    var width = 1;
    var id = setInterval(frame, 30);
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

//자동실행 다음 버튼과 진행바 실행
const intervalclick = function(){
    nextBtn.click();
    move();
  }
//4초 간격
const intervals = setInterval(intervalclick,4000);


// 다음 버튼 클릭시 이벤트 발생
nextBtn.addEventListener('click', function () {
    move();
    bannerBackground11.src=backImgs[currentBannerIdx];
    bannerBackground11.style.transition = `${0.5}s ease-out`;
    bannerBackgroundright.style.backgroundColor=rightColorIndex[currentBannerIdx];
    bannerBackgroundright.style.transition = `${0.5}s ease-out`;
    bannerTexts.innerText=addsText[currentBannerIdx];
    CurrentBannerNumber.innerText=zeroIndex[currentBannerIdx];

    if (currentBannerIdx <= bannerCount - 1) {
      //슬라이드이동
      banner.style.left = -(currentBannerIdx + 2) * (bannerWidth + bannerMargin) + 'px';
      banner.style.transition = `${0.5}s ease-out`; //이동 속도
    }
    if (currentBannerIdx == bannerCount - 1) {
      //마지막 슬라이드 일때
      setTimeout(function () {
        //0.5초동안 복사한 첫번째 이미지에서, 진짜 첫번째 위치로 이동
        banner.style.left = -(bannerWidth + bannerMargin) + 'px';
        banner.style.transition = `${0.5}s ease-out`;
      }, 100);
      currentBannerIdx = -1;
      bannerBackground11.src=backImgs[0];
    }
    currentBannerIdx += 1;
    console.log(currentBannerIdx);
  });


  prevBtn.addEventListener('click', function () {
    //이전 버튼 눌렀을때
    move();
    if (currentBannerIdx >= 0) {
        banner.style.left = -currentBannerIdx * (bannerWidth + bannerMargin) + 'px';
        banner.style.transition = `${0.5}s ease-out`;
        bannerTexts.innerText=addsText[currentBannerIdx];
        CurrentBannerNumber.innerText=zeroIndex[currentBannerIdx];
        bannerBackground11.src=backImgs[currentBannerIdx];
        bannerBackground11.style.transition = `${0.5}s ease-out`;
        bannerBackgroundright.style.backgroundColor=rightColorIndex[currentBannerIdx];
        bannerBackgroundright.style.transition = `${0.5}s ease-out`;
    }
    if (currentBannerIdx == 0) { // ===은 데이터타입까지 비교해주기 위함
      setTimeout(function () {
        banner.style.left = -bannerCount * (bannerWidth + bannerMargin) + 'px';
        banner.style.transition = `${0}s ease-out`;
      }, 500);
      currentBannerIdx = bannerCount;
    }
    currentBannerIdx -= 1;
  });


