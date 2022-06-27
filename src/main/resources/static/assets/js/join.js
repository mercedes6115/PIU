let $uemail = $('input#email');
let $upw = $('input#password');
let $upw2 = $('input#password_check');
let emailPass = true;  // 테스트용으로 true
let pwPass = false;
let namePass = false;
let $unickname=$('input#nickname');
let phonePass = false;
let statePass = false;
let phoneCheckPass = false; // sms 확인용
let corpPass = false;
let businessNumberPass=false;
let businessPhonePass=false;


//input에 keyup 이벤트 등록
$uemail.bind("change keyup input", function(){
    //keyup 이벤트 발생 시 해당 input의 value 가져오기.
    let $uemailval = $uemail.val();
    //실시간 검색이 필요한 table의 모든 행(tr) 숨김 처리
    if (!$uemailval) { // 아이디 입력칸이 비어 있을 경우
        $('span#emailCheck_text').empty().text("아이디를 입력해 주세요").css("color", "red");
        emailPass = false;
        return;
    }
    checkEmail();
});

// 이메일 유효성 검사
function checkEmail(){
    var email =  $('input#email').val();
    console.log(email);
    var exptext = /^([0-9a-zA-Z_\.-]+)@([0-9a-zA-Z_-]+)(\.[0-9a-zA-Z_-]+){1,2}$/;
    console.log(exptext.test(email));
    if(!exptext.test(email)) {
        //이메일 형식이 알파벳+숫자@알파벳+숫자.알파벳+숫자 형식이 아닐경우
        $('span#emailCheck_text').empty().text("이메일 형식이 아닙니다.").css("color", "red");
        $('input#email').focus();
        $('#emailCheck').attr('disabled', true);
        return false;
    }

    $('span#emailCheck_text').empty().text("올바른 이메일 형식입니다.").css("color", "green");
    $('#emailCheck').attr('disabled', false);
    emailPass = true;
}




$("#emailCheck").on("click",function () {
    let $uemailval = $uemail.val();
    $.ajax({
        url: "/userR/emailMatching",
        type: "post",
        data: {email: $uemailval},
        success: function (result) {
            if (result===0) {
                console.log(result);
                $('span#emailCheck_text').empty().text("사용 가능한 아이디 입니다.").css("color", "green");
                emailPass = true;
            } else {
                $('span#emailCheck_text').empty().text("이미 사용 중인 아이디 입니다.").css("color", "red");
                emailPass = false;
            }
        },
        error: function (xhr, status, er) {
            console.log(xhr, status, er);
        }
    })

})

// 비밀번호 유효성검사
function checkPw(){
    if($("input#password").val().length < 8){
        $('span#pwCheck_text_first').text("8자 이상 입력해주세요").css("color", "red");
        $('span#pwCheck_text').text(" ").css("color", "red");
    }else{
        $('span#pwCheck_text_first').text("가능한 비밀번호 형식입니다").css("color", "green");
    }
}

// 비밀번호 유효성 검사 적용
$upw.blur(function () {
    checkPw();
})

// 비밀번호 확인검사
$upw2.blur(function () {
    let $upwval = $upw.val();
    let $upw2val = $upw2.val();
    if (!$upwval || !$upw2val) {
        $('span#pwCheck_text').text("비밀번호를 입력해주세요").css("color", "red");
        pwPass = false;
        return;
    }else if($("input#password").val().length < 8){
        $('span#pwCheck_text').text("선 비밀번호 조건이 맞지 안습니다").css("color", "red");
    }else if ($upwval != $upw2val) {
        $('span#pwCheck_text').text("비밀번호가 일치하지 않습니다").css("color", "red");
        pwPass = false;
        return;
    } else {
        $('span#pwCheck_text').empty().text("비밀번호가 일치합니다.").css("color", "green");
        pwPass = true;
    }
});



// 닉네임확인
$("input#nickname").blur(function () {
    if (!$("input#nickname").val()) {
        $('span#nameCheck_text').text("이름를 입력해주세요").css("color", "red");
        namePass = false;
        return;
    } else {
        $('span#nameCheck_text').text(" "); //입력시 삭제
        namePass = true;
    }
});
// 닉네임 중복 체크
$("#nameCheck").on("click",function () {
    let $unicknameval = $unickname.val();
    $.ajax({
        url: "/userR/nicknameMatching",
        type: "post",
        data: {nickname: $unicknameval},
        success: function (result) {
            if (result===0) {
                console.log(result);
                $('span#nameCheck_text').empty().text("사용 가능한 닉네임 입니다.").css("color", "green");
                namePass = true;
            } else {
                $('span#nameCheck_text').empty().text("이미 사용 중인 닉네임 입니다.").css("color", "red");
                namePass = false;
            }
        },
        error: function (xhr, status, er) {
            console.log(xhr, status, er);
        }
    })

})

// 기업번호
$("input#businessNumber").blur(function () {
    if (!$("input#businessNumber").val()) {
        $('span#businessNumberCheck_text').text("사업자번호 입력해주세요").css("color", "red");
        businessNumberPass = false;
        return;
    } else {
        $('span#businessNumberCheck_text').text(" "); //입력시 삭제
        businessNumberPass = true;
    }
});
// 기업 전화번호
$("input#phone-corp").blur(function () {
    if (!$("input#phone-corp").val()) {
        $('span#businessPhoneCheck_text').text("사업자번호 입력해주세요").css("color", "red");
        businessPhonePass = false;
        return;
    } else {
        $('span#businessPhoneCheck_text').text(" "); //입력시 삭제
        businessPhonePass = true;
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

$("#phone").bind("change keyup input", function() {
    $(this).val( $(this).val().replace(/[^0-9]/g, "").replace(/(^02|^0505|^1[0-9]{3}|^0[0-9]{2})([0-9]+)?([0-9]{4})$/,"$1-$2-$3").replace("--", "-") );
});
$("#phone-corp").bind("change keyup input", function() {
    $(this).val( $(this).val().replace(/[^0-9]/g, "").replace(/(^02|^0505|^1[0-9]{3}|^0[0-9]{2})([0-9]+)?([0-9]{4})$/,"$1-$2-$3").replace("--", "-") );
});



// 먼저 썻던 전화번호, 인증폼에서 이용
$("#phone").change(function () {
    $('#phone2').val($(this).val());
    $('#phone').val().replace(/-/g, "");
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

// 인증번호 검사(미완)
$("input#phone-check").on("keyup", function () {
    console.log($(this).val().length);
    console.log($(this).val().length == 6);
    if ($(this).val().length == 6) {
        console.log("확인 성공");
        $("#phone-check-button").css("background-color", "rgb(204, 69, 0)");
        $("#phone-check-button").val("확인");
    } else {
        console.log("확인 실패");
        $("#phone-check-button").css("background-color", "rgb(222, 222, 222)");
        $("#phone-check-button").val("입력필요");

    }
})

// 인증번호 보내기
$('#sendPhone').click(function () {
    let phoneNumber = $('#phone2').val();
    alert('인증번호 발송 완료!');
    $.ajax({
        type: "GET",
        url: "/sms/single",  // restController로 보낼것
        data: {
            "phoneNumber": phoneNumber
        },
        success: function (res) {
            $('#phone-check-button').on("click", function () {
                console.log("확인버튼 누름");
                console.log(res);
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
    console.log($('#phone2').val());
    console.log($('#phone2').val().replace(/-/g, ""));
    console.log($('#phone').val().replace(/-/g, ""));

    $('#phone').val().replace(/-/g, "");
    if (!phoneCheckPass) {
        alert('휴대폰 인증이 완료되지 않았습니다');
        return;
    }

    $('')
    console.log($('#joinForm'));
    let enpw=btoa($('input[name=password]').val());
    $('input[name=password]').val(enpw);
    console.log($('input[name=password]').val())
    joinForm.submit();
    alert("환영합니다. 회원가입이 완료되었습니다.");

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
        let enpw=btoa($('input[name=password]').val());
        $('input[name=password]').val(enpw);
        joinForm.submit();
    }
})


let regex = new RegExp("(.*?)\.(exe|sh|zip|alz)");

function checkExtension(fileName, fileSize){
    if(regex.test(fileName)){
        alert("업로드 할 수 없는 파일의 형식입니다.");
        return false;
    }
    if(fileSize >= 5242880){
        alert("파일 사이즈 초과");
        return false;
    }
    return true;
}

$("input[type='file']").on("change",function () {

    let formData = new FormData();
    let inputFile = $("input[name='uploadFile']");
    let files = inputFile[0].files;
    console.log(files);
    for(let i=0; i<files.length; i++){
        if(!checkExtension(files[i].name, files[i].size)){ return; }
        formData.append("uploadFile", files[i]);
    }
    $.ajax({
        url: "/userFile/businessFileUpload",
        type: "post",
        data: formData,
        contentType: false,
        processData: false,
        success: function(data){
            console.log(data);
            console.log(data.profileFileName);
            console.log(data.profileUploadPath);

            $('input[name=profileFileName]').val(data.profileFileName);
            $('input[name=profileUploadPath]').val(data.profileUploadPath);

        }
    });

})

// 입력받은 파일 이름 넘기기
$(document).ready(function(){
    var fileTarget = $('.upload-hidden');

    fileTarget.on('change', function(){
        if(window.FileReader){
            var filename = $(this)[0].files[0].name;
        } else {
            var filename = $(this).val().split('/').pop().split('\\').pop();
        }

        $(this).siblings('#business-number').val(filename);

        corpPass =true;
    });
});

