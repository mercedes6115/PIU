let $uemail = $('input#email');
let $upw = $('input#password');
let $upw2 = $('input#password_check');
let emailPass = true;  // 테스트용으로 true
let pwPass = false;
let namePass = false;
let phonePass = false;
let statePass = false;
let phoneCheckPass = false; // sms 확인용
let corpPass = false;

// 이메일 휴요성 검사
function checkEmail(){
    var email =  $('input#email').value
    var exptext = /^[A-Za-z0-9_\.\-]+@[A-Za-z0-9\-]+\.[A-Za-z0-9\-]+/;
        if(exptext.test(email)==false){
            //이메일 형식이 알파벳+숫자@알파벳+숫자.알파벳+숫자 형식이 아닐경우			
            $('span#emailCheck_text').empty().text("이메일 형식이 아닙니다.").css("color", "green");
            $('input#email').focus();
            return false;
        }
}

function checkPw(){
    if($("input#password").val().length < 8){
        $('span#pwCheck_text_first').text("8자 이상 입력해주세요").css("color", "red");
    }else{
        $('span#pwCheck_text_first').text("가능한 비밀번호 형식입니다").css("color", "green");
    }
}

$upw.blur(function () {
    checkPw();
})



//  db처리를 할수 없으므 테스트용으로 주석처리
// // 이메일 중복 확인(메세지 출력)
// $uemail.blur(function () {
//     let $uemailval = $uemail.val();
//     if (!$uemailval) { // 아이디 입력칸이 비어 있을 경우
//         $('span#emailCheck_text').empty().text("아이디를 입력해 주세요").css("color", "red");
//         emailPass = false;
//         return;
//     } else {
//         checkEmail(); 
//         $.ajax({
//             url: "/컨트롤러 경로",
//             type: "post",
//             data: {email: $uemailval},
//             success: function (result) {
//                 if (!result) {
//                     $('span#emailCheck_text').empty().text("사용 가능한 아이디 입니다.").css("color", "green");
//                     emailPass = true;
//                 } else {
//                     $('span#emailCheck_text').empty().text("이미 사용 중인 아이디 입니다.").css("color", "red");
//                     emailPass = false;
//                 }
//             },
//             error: function (xhr, status, er) {
//                 console.log(xhr, status, er);
//             }
//         })
//     }
// });

// 비밀번호 확인검사
// 비밀번호 정규식 추가해야함
$upw2.blur(function () {
    let $upwval = $upw.val();
    let $upw2val = $upw2.val();
    if (!$upwval || !$upw2val) {
        $('span#pwCheck_text').text("비밀번호를 입력해주세요").css("color", "red");
        pwPass = false;
        return;
    }
    if ($upwval != $upw2val) {
        $('span#pwCheck_text').text("비밀번호가 일치하지 않습니다").css("color", "red");
        pwPass = false;
        return;
    } else {
        $('span#pwCheck_text').empty().text("사용가능한 비밀번호입니다").css("color", "green");
        pwPass = true;
    }
});



// 이름확인
$("input#name").blur(function () {
    if (!$("input#name").val()) {
        $('span#nameCheck_text').text("이름를 입력해주세요").css("color", "red");
        namePass = false;
        return;
    } else {
        $('span#nameCheck_text').text(" "); //입력시 삭제
        namePass = true;
    }
});

// 전화번호확인 (추가기능 수정 필요)
$("input#phone").blur(function () {
    if (!$("input#phone").val()) {
        $('span#phoneCheck_text').text("전화번호를 입력해주세요").css("color", "red");
        phonePass = false;
        return;
    } else {
        $('span#phoneCheck_text').text(" "); //입력시 삭제
        phonePass = true;
    }
});

// 주소확인 (추가기능 수정 필요)
$("input#state-detail").blur(function () {
    if (!$("input#state").val()) {
        $('span#stateCheck_text').text("주소를 입력해주세요").css("color", "red");
        statePass = false;
        return;
    } else {
        $('span#stateCheck_text').text(" "); //입력시 삭제
        statePass = true;
    }
});


// 제출시 문제 있을 경우 막기(일반회원) -첫번째
$("#submit-user").on("click", function (e) {
    if (!emailPass) {
        alert("이메일을 다시 확인해주세요");
        return false;
    } else if (!pwPass) {
        alert("비밀번호를 다시 확인해주세요")
        return false;
    } else if (!phonePass) {
        alert("전화번호를 다시 확인해주세요")
        return false;
    } else if (!namePass) {
        alert("이름를 다시 확인해주세요")
        return false;
    } else if (!statePass) {
        alert("주소를 다시 확인해주세요")
        return false;
    } else {
        $(".join-firststep").hide();
        $(".join-secondstep").show();
    }
});


// 주소 검색
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
            document.getElementById("state-detail").focus();
        }
    }).open();
});


$("input#phone-check").on("keyup", function (e) {
    if ($("input#phone-check").val().length == 6) {
        $("button#phone-check-button").css("background-color", "rgb(204, 69, 0)");
        $("button#phone-check-button").val("확인")
    } else {
        $("button#phone-check-button").css("background-color", "rgb(222, 222, 222)");
        $("button#phone-check-button").val("입력필요");

    }
})

// 인증번호 보내기
$('#sendPhone').click(function () {
    let phoneNumber = $('#phone2').val();
    alert('인증번호 발송 완료!')
    $.ajax({
        type: "GET",
        url: "/reply/single",  // restController로 보낼것
        data: {
            "phoneNumber": phoneNumber
        },
        success: function (res) {
            $('#phone-check-button').on("click", function () {
                if ($.trim(res) == $('#phone-check').val()) {
                    alert('인증성공!');
                    phoneCheckPass = true;
                } else {
                    alert('인증번호가 올바르지 않습니다!');
                }
            })
        }
    })
});

// 최종제출(일반회원)
$("#submit-user-final").on("click", function () {
    if (!phoneCheckPass) {
        alert('휴대폰 인증이 완료되지 않았습니다');
        return;
    } else {
        $.ajax({
            type: "POST",
            url: "/컨트롤러/joinUser",  // userVO랑 연결된 컨트롤러
            data: {
                userEmail:$("#email"),
                userPassword:$("#password"),
                userNickname:$("#name"),
                userPhone:$("#phone"),
                userAddress:$("#state") + $("#state-detail")
            }
        })
    }
})

// 최종제출(기업)
$("#submit-corp").on("click", function () {
    if (!emailPass) {
        alert("이메일을 다시 확인해주세요");
        return false;
    } else if (!pwPass) {
        alert("비밀번호를 다시 확인해주세요")
        return false;
    } else if (!phonePass) {
        alert("전화번호를 다시 확인해주세요")
        return false;
    } else if (!namePass) {
        alert("이름를 다시 확인해주세요")
        return false;
    } else if (!statePass) {
        alert("주소를 다시 확인해주세요")
        return false;
    } else if(!corpPass) {
        alert("사업자 등록증을 입력해주세요")
        return false;
    } else {
        $.ajax({
            type: "POST",
            url: "/컨트롤러/joinCorp",  // userCorpVO랑 연결된 컨트롤러
            data: {
                companyEmail:$("#email"),
                companyPassword:$("#password"),
                companyName:$("#name"),
                companyPhone:$("#phone"),
                companyCorphone:$("#phone-corp") ,
                companyAddress:$("#state") + $("#state-detail"),
                companyBusinessNumber:"미정"
            }
        })
    }
})





// 먼저 썻던 전화번호, 인증폼에서 이용
$("#phone").change(function () {
    $('#phone2').val($(this).val());
});



