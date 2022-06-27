
let $uemail = $('input#email');
let $upw = $('input#password');
let emailPass = true;  // 테스트용으로 true
let pwPass = false;
let corpPass = false;

// 인풋 창에 아무것도 없으면 경고문 띄우기
$("#email").blur(function(){
    let email= $("#email").val();
    if(!email){
        $(".letshow1").css({"display":"flex", "margin-top":"5px"});
    }
});
$("#pw").blur(function(){
    let userpw= $("#pw").val();
    if(!userpw){
        $(".letshow2").css({"display":"flex", "margin-top":"5px"});
    }
});

// 경고문 떠있다가 키보드 눌리면 경고문 사라지게 하기
$("#pw").keypress(function(){
    let userpw= $("#pw").val();
    $(".letshow2").css({"display":"none"});
});
$("#email").keypress(function(){
    let email= $("#email").val();
    $(".letshow1").css({"display":"none"});
});

// 아무것도 없는 상태에서 로그인 버튼 누를 경우
// 정보가 디비와 다를 경우
// 로그인 성공 경우
$(document).ready(function () {
    $(".loginbutton").click(function (e) {
        let userpw= $("#pw").val();
        let email= $("#email").val();
        console.log(email);
        console.log(userpw);

        if(!email){
            $(".letshow1").css({"display":"flex", "margin-top":"5px"});
            e.preventDefault();

        }

        if(!userpw){
            $(".letshow2").css({"display":"flex", "margin-top":"5px"});
            e.preventDefault();
        }

        if(!email || !userpw) {
            e.preventDefault();
            return;
        }
        let enpw=btoa($('input[name=password]').val());
        $('input[name=password]').val(enpw);
        loginForm.submit();

    });
});

// function loginCheckDB(email,userpw){
//     console.log(email);
//     console.log(userpw);
//     if(email=="id@na" && userpw=="pw"){
//         alert("로그인 성공");
//     }
//
//     if( email!="id@na" || userpw!="pw"){
//         alert("아이디와 비밀번호를 확인하세요");
//     }
//
//
// }































