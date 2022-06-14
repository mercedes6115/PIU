$('.btnCertify').on("click", function () {
    new daum.Postcode({
        oncomplete: function (data) {
            var addr = ''; //주소 변수
            if(data.userSelectedType ==='R'){
                addr = data.roadAddress;
            } else {
                addr = data.jibunAddress;
            }

            // 주소 정보를 해당 필드에 넣는다.
            document.getElementById("state").value = addr;
            $('.state-detail').focus();
        }
    }).open();
});

if($("#now-password").val()==""){
    $("#change-password").prop("readonly",true);
    $("#check-password").prop("readonly",true);
}


$(".pw").keyup(function(){
    let pass1 = $("#change-password").val();
    let pass2 = $("#check-password").val();
    let pass = $("#now-password").val();

    if(pass1 != "" && pass2 != ""){
        if(pass1 == pass2){
            $("#checkPw").html('비밀번호가 일치합니다');
            $("#checkPw").attr('color','green');
        } else{
            $("#checkPw").html('비밀번호가 일치하지 않습니다');
            $("#checkPw").attr('color','red');
        }
    }
    if(pass1 == "" || pass2 == ""){
        $("#checkPw").html('');
    }

    if(pass){
        $("#change-password").prop("readonly",false);
        $("#check-password").prop("readonly",false);
    }

})




$(".modify-ok").on("click", function(){
    let pass1 = $("#now-password").val();
    let pass2 = $("#change-password").val();
    let pass3 = $("#check-password").val();
    let phone = $("#phone").val();
    let addr1 = $("#state").val();
    let addr2 = $("#state-detail").val();

    if(pass1){
        if(pass2==""){
            alert("변경할 비밀번호를 입력해주세요");
            $("#change-password").focus();
            return false;
        }
        if(pass3==""){
            alert("비밀번호 확인을 입력해주세요");
            $("#check-password").focus();
            return false;
        }
    }

    if(addr1){
        if(addr2==""){
            alert("상세주소를 입력해주세요");
            $("#state-detail").focus();
            return false;
        }
    }


    if(phone){
        if(isNaN(phone)){
            alert("휴대폰번호를 숫자로만 입력해주세요.");
            $("#phone").focus();
            return false;
        }

        if(phone.length !=13){
            alert("휴대폰번호를 정확히 입력해주세요.");
            $("#phone").focus();
            return false;
        }
    }

})

$(".modify-check").on("click",function (){
    if($("#confirmPw").val()==""){
        alert("비밀번호를 입력해주세요");
        $("#confirmPw").focus();
        return false;
    }
})

const yslides_1 = document.querySelector('.yslides_1'); //전체 슬라이드 컨테이너
const slideImg_1 = document.querySelectorAll('.yslides_1 li'); //모든 슬라이드들
let currentIdx_1 = 0; //현재 슬라이드 index
const slideCount_1 = slideImg_1.length; // 슬라이드 개수
const prev_1 = document.querySelector('.prev_1'); //이전 버튼
const next_1 = document.querySelector('.next_1'); //다음 버튼
const slideWidth_1 = 267; //한개의 슬라이드 넓이
const slideMargin_1 = 0; //슬라이드간의 margin 값

//전체 슬라이드 컨테이너 넓이 설정
yslides_1.style.width = (slideWidth_1 + slideMargin_1) * slideCount_1 + 'px';

function moveSlide_1(num_1) {
    yslides_1.style.left = -num_1 * 267 + 'px';
    currentIdx_1 = num_1;
    console.log(currentIdx_1);
}


prev_1.addEventListener('click', function () {
    /*첫 번째 슬라이드로 표시 됐을때는
    이전 버튼 눌러도 아무런 반응 없게 하기 위해
    currentIdx !==0일때만 moveSlide 함수 불러옴 */

    if (currentIdx_1 !== 0) moveSlide_1(currentIdx_1 - 1);
});

next_1.addEventListener('click', function () {
    /* 마지막 슬라이드로 표시 됐을때는
    다음 버튼 눌러도 아무런 반응 없게 하기 위해
    currentIdx !==slideCount - 1 일때만
    moveSlide 함수 불러옴 */
    if (currentIdx_1 < slideCount_1 - 3) {
        moveSlide_1(currentIdx_1 + 1);
        yslides_1.style.transition = `${0.5}s ease-out`; //이동 속도

    }
});

const yslides_2 = document.querySelector('.yslides_2'); //전체 슬라이드 컨테이너
const slideImg_2 = document.querySelectorAll('.yslides_2 li'); //모든 슬라이드들
let currentIdx_2 = 0; //현재 슬라이드 index
const slideCount_2 = slideImg_2.length; // 슬라이드 개수
const prev_2 = document.querySelector('.prev_2'); //이전 버튼
const next_2 = document.querySelector('.next_2'); //다음 버튼
const slideWidth_2 = 267; //한개의 슬라이드 넓이
const slideMargin_2 = 0; //슬라이드간의 margin 값

//전체 슬라이드 컨테이너 넓이 설정
yslides_2.style.width = (slideWidth_2 + slideMargin_2) * slideCount_2 + 'px';

function moveSlide_2(num_2) {
    yslides_2.style.left = -num_2 * 267 + 'px';
    currentIdx_2 = num_2;
}

prev_2.addEventListener('click', function () {
    /*첫 번째 슬라이드로 표시 됐을때는
    이전 버튼 눌러도 아무런 반응 없게 하기 위해
    currentIdx !==0일때만 moveSlide 함수 불러옴 */

    if (currentIdx_2 !== 0) moveSlide_2(currentIdx_2 - 1);
});

next_2.addEventListener('click', function () {
    /* 마지막 슬라이드로 표시 됐을때는
    다음 버튼 눌러도 아무런 반응 없게 하기 위해
    currentIdx !==slideCount - 1 일때만
    moveSlide 함수 불러옴 */
    if (currentIdx_2 < slideCount_2 - 3) {
        moveSlide_2(currentIdx_2 + 1);
        yslides_2.style.transition = `${0.5}s ease-out`; //이동 속도

    }
});

const yslides_3 = document.querySelector('.yslides_3'); //전체 슬라이드 컨테이너
const slideImg_3 = document.querySelectorAll('.yslides_3 li'); //모든 슬라이드들
let currentIdx_3 = 0; //현재 슬라이드 index
const slideCount_3 = slideImg_3.length; // 슬라이드 개수
const prev_3 = document.querySelector('.prev_3'); //이전 버튼
const next_3 = document.querySelector('.next_3'); //다음 버튼
const slideWidth_3 = 267; //한개의 슬라이드 넓이
const slideMargin_3 = 0; //슬라이드간의 margin 값

//전체 슬라이드 컨테이너 넓이 설정
yslides_3.style.width = (slideWidth_3 + slideMargin_3) * slideCount_3 + 'px';

function moveSlide_3(num_3) {
    yslides_3.style.left = -num_3 * 267 + 'px';
    currentIdx_3 = num_3;
}

prev_3.addEventListener('click', function () {
    /*첫 번째 슬라이드로 표시 됐을때는
    이전 버튼 눌러도 아무런 반응 없게 하기 위해
    currentIdx !==0일때만 moveSlide 함수 불러옴 */

    if (currentIdx_3 !== 0)   moveSlide_3(currentIdx_3 - 1);
});

next_3.addEventListener('click', function () {
    /* 마지막 슬라이드로 표시 됐을때는
    다음 버튼 눌러도 아무런 반응 없게 하기 위해
    currentIdx !==slideCount - 1 일때만
    moveSlide 함수 불러옴 */
    if (currentIdx_3 < slideCount_3 - 3) {
        moveSlide_3(currentIdx_3 + 1);
        yslides_3.style.transition = `${0.5}s ease-out`; //이동 속도

    }
});

const yslides_4 = document.querySelector('.yslides_4'); //전체 슬라이드 컨테이너
const slideImg_4 = document.querySelectorAll('.yslides_4 li'); //모든 슬라이드들
let currentIdx_4 = 0; //현재 슬라이드 index
const slideCount_4 = slideImg_4.length; // 슬라이드 개수
const prev_4 = document.querySelector('.prev_4'); //이전 버튼
const next_4 = document.querySelector('.next_4'); //다음 버튼
const slideWidth_4 = 267; //한개의 슬라이드 넓이
const slideMargin_4 = 0; //슬라이드간의 margin 값

//전체 슬라이드 컨테이너 넓이 설정
yslides_4.style.width = (slideWidth_4 + slideMargin_4) * slideCount_4 + 'px';

function moveSlide_4(num_4) {
    yslides_4.style.left = -num_4 * 267 + 'px';
    currentIdx_4 = num_4;
}

prev_4.addEventListener('click', function () {
    /*첫 번째 슬라이드로 표시 됐을때는
    이전 버튼 눌러도 아무런 반응 없게 하기 위해
    currentIdx !==0일때만 moveSlide 함수 불러옴 */

    if (currentIdx_4 !== 0) moveSlide_4(currentIdx_4 - 1);
});

next_4.addEventListener('click', function () {
    /* 마지막 슬라이드로 표시 됐을때는
    다음 버튼 눌러도 아무런 반응 없게 하기 위해
    currentIdx !==slideCount - 1 일때만
    moveSlide 함수 불러옴 */
    if (currentIdx_4 < slideCount_4 - 3) {
        moveSlide_4(currentIdx_4 + 1);
        yslides_4.style.transition = `${0.5}s ease-out`; //이동 속도

    }
});

const yslides_5 = document.querySelector('.yslides_5'); //전체 슬라이드 컨테이너
const slideImg_5 = document.querySelectorAll('.yslides_5 li'); //모든 슬라이드들
let currentIdx_5 = 0; //현재 슬라이드 index
const slideCount_5 = slideImg_5.length; // 슬라이드 개수
const prev_5 = document.querySelector('.prev_5'); //이전 버튼
const next_5 = document.querySelector('.next_5'); //다음 버튼
const slideWidth_5 = 267; //한개의 슬라이드 넓이
const slideMargin_5 = 0; //슬라이드간의 margin 값

//전체 슬라이드 컨테이너 넓이 설정
yslides_5.style.width = (slideWidth_5 + slideMargin_5) * slideCount_5 + 'px';

function moveSlide_5(num_5) {
    yslides_5.style.left = -num_5 * 267 + 'px';
    currentIdx_5 = num_5;
}

prev_5.addEventListener('click', function () {
    /*첫 번째 슬라이드로 표시 됐을때는
    이전 버튼 눌러도 아무런 반응 없게 하기 위해
    currentIdx !==0일때만 moveSlide 함수 불러옴 */

    if (currentIdx_5 !== 0) moveSlide_5(currentIdx_5 - 1);
});

next_5.addEventListener('click', function () {
    /* 마지막 슬라이드로 표시 됐을때는
    다음 버튼 눌러도 아무런 반응 없게 하기 위해
    currentIdx !==slideCount - 1 일때만
    moveSlide 함수 불러옴 */
    if (currentIdx_5 < slideCount_5 - 3) {
        moveSlide_5(currentIdx_5 + 1);
        yslides_5.style.transition = `${0.5}s ease-out`; //이동 속도

    }
});

const yslides_6 = document.querySelector('.yslides_6'); //전체 슬라이드 컨테이너
const slideImg_6 = document.querySelectorAll('.yslides_6 li'); //모든 슬라이드들
let currentIdx_6 = 0; //현재 슬라이드 index
const slideCount_6 = slideImg_6.length; // 슬라이드 개수
const prev_6 = document.querySelector('.prev_6'); //이전 버튼
const next_6 = document.querySelector('.next_6'); //다음 버튼
const slideWidth_6 = 267; //한개의 슬라이드 넓이
const slideMargin_6 = 0; //슬라이드간의 margin 값

//전체 슬라이드 컨테이너 넓이 설정
yslides_6.style.width = (slideWidth_6 + slideMargin_6) * slideCount_6 + 'px';

function moveSlide_6(num_6) {
    yslides_6.style.left = -num_6 * 267 + 'px';
    currentIdx_6 = num_6;
}

prev_6.addEventListener('click', function () {
    /*첫 번째 슬라이드로 표시 됐을때는
    이전 버튼 눌러도 아무런 반응 없게 하기 위해
    currentIdx !==0일때만 moveSlide 함수 불러옴 */

    if (currentIdx_6 !== 0) moveSlide_6(currentIdx_6 - 1);
});

next_6.addEventListener('click', function () {
    /* 마지막 슬라이드로 표시 됐을때는
    다음 버튼 눌러도 아무런 반응 없게 하기 위해
    currentIdx !==slideCount - 1 일때만
    moveSlide 함수 불러옴 */
    if (currentIdx_6 < slideCount_6 - 3) {
        moveSlide_6(currentIdx_6 + 1);
        yslides_6.style.transition = `${0.5}s ease-out`; //이동 속도

    }
});


