const banner = document.querySelector(".swiper-imgWrapper1");
prevBtn = document.querySelector('.previous-button1'); //이전 버튼
nextBtn = document.querySelector('.next-button1'); //다음 버튼

// console.log(prevBtn);
// console.log(nextBtn);
var currentBannerIdx = 0; // 현재 슬라이드 인덱스 번호
var bannerCount = 6; // 총 슬라이드 수

let bannerBackground11 = document.getElementById("bannerBackGround"); // 배너 뒷배경 왼쪽
let bannerBackgroundright = document.getElementById("banner-container-rightside"); // 배너 뒷배경 오른쪽

let bannerTexts = document.getElementById("advertising-text");

let CurrentBannerNumber = document.getElementById("CurrentBannerNumber");
var elem = document.getElementById("progress-bar-loading2");
// console.log(CurrentBannerNumber);


let zeroIndex = [
    '01',
    '02',
    '03',
    '04',
    '05',
    '06'
]


let backImgs = [
    '#c9e9f6',
    '#9bdbd8',
    '#cefff2',
    '#a6d0fc',
    '#229f8c',
    '#1691db'
]

var rightColorIndex = [ // 배너 오른쪽 색상 배열로 묶어줌
    '#ff0000',
    '#00fff1',
    '#005e45',
    '#007bff',
    '#00ffd9',
    '#003352'
]

var addsText = [ // 배너 문구
    '1번 플로깅은 여러분의 건강과 함께 환경을 개선해 나갑니다',
    '2번 "이삭을 줍는다(polcka upp)"는 뜻의 스웨덴어과 영어 조깅 (jogging)의 합성어',
    '3번 테스트 중입니다 광고 문구는 신경쓰지 말아주세요',
    '4번 이런 사이트 어떤가요',
    '5번 내용입니다',
    '6번 '
]


bannerWidth = 660; //슬라이드이미지 width
bannerMargin = 16; // 슬라이드간 margin


//Progress Bar
var i = 0;
let check = 0;
let width = 1

function frame() {
    console.log("늘어나기 시작")
    if (width >= 100) {
        clearInterval(idk);
        i = 0;
    } else {
        width++;
        elem.style.width = width + "%";
    }
}

let idk = setInterval(frame, 30);
function move() {
    console.log("현재 위치 : " + currentBannerIdx);


    if (i == 0) {
        i = 1;
        var elem = document.getElementById("progress-bar-loading2");
        width = 1;
        if(check == 1){
            clearInterval(idk);
            clearInterval(intervals);
            check = 0;
            i = 0;
            width=1;
            idk = setInterval(frame, 30);
            intervals = setInterval(intervalclick, 3500);
            console.log("늘어나는거 초기화")
        }
        frame();
    }
}

// move();
nextBtn.click();

//자동실행 다음 버튼과 진행바 실행
const intervalclick = function () {
    nextBtn.click();
}
//4초 간격
let intervals = setInterval(intervalclick, 3500);


// 다음 버튼 클릭시 이벤트 발생
nextBtn.addEventListener('click', function () {
    check = 1;
    currentBannerIdx += 1;
    if (currentBannerIdx == bannerCount) {
        //마지막 슬라이드 일때
        setTimeout(function () {
            //0.5초동안 복사한 첫번째 이미지에서, 진짜 첫번째 위치로 이동
            // banner.style.left = -(bannerWidth + bannerMargin) + 'px';
            banner.style.left = -(bannerWidth + bannerMargin) + 'px';
            banner.style.transition = `${0}s ease-out`;
        }, 100);
        currentBannerIdx = 0;
        bannerBackground11.style.backgroundColor = rightColorIndex[0];

    }
    move();
    bannerBackground11.style.backgroundColor = rightColorIndex[currentBannerIdx];
    bannerBackground11.style.transition = `${0.5}s ease-out`;
    bannerBackgroundright.style.backgroundColor = rightColorIndex[currentBannerIdx];
    bannerBackgroundright.style.transition = `${0.5}s ease-out`;
    bannerTexts.innerText = addsText[currentBannerIdx];
    CurrentBannerNumber.innerText = zeroIndex[currentBannerIdx];
    // console.log("번호 : " + currentBannerIdx);
    // console.log("내용 : " + addsText[currentBannerIdx]);
    if (currentBannerIdx <= bannerCount - 1) {
        //슬라이드이동
        banner.style.left = -(currentBannerIdx + 1) * (bannerWidth + bannerMargin) + 'px';
        banner.style.transition = `${0.5}s ease-out`; //이동 속도
    }


    // console.log(currentBannerIdx);
});

//이전 버튼 눌렀을때
prevBtn.addEventListener('click', function () {
    check=1;
    currentBannerIdx -= 1;
    if (currentBannerIdx == -1) { // ===은 데이터타입까지 비교해주기 위함
        setTimeout(function () {
            banner.style.left = -bannerCount * (bannerWidth + bannerMargin) + 'px';
            banner.style.transition = `${0}s ease-out`;
        }, 500);
        currentBannerIdx = bannerCount-1;
    }
    move();
    bannerBackground11.style.backgroundColor = rightColorIndex[currentBannerIdx];
    bannerBackground11.style.transition = `${0.5}s ease-out`;
    bannerBackgroundright.style.backgroundColor = rightColorIndex[currentBannerIdx];
    bannerBackgroundright.style.transition = `${0.5}s ease-out`;
    bannerTexts.innerText = addsText[currentBannerIdx];
    CurrentBannerNumber.innerText = zeroIndex[currentBannerIdx];
    // console.log("이전 누름 번호 : " + currentBannerIdx);
    // console.log("내용 : " + addsText[currentBannerIdx]);
    if (currentBannerIdx >= 0) {
        banner.style.left = -(currentBannerIdx+1) * (bannerWidth + bannerMargin) + 'px';
        banner.style.transition = `${0.5}s ease-out`;
    }
});


