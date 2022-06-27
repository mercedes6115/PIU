$('.creater').click(function (e) {
    e.preventDefault();
    console.log("버튼 누름")
    if(sessioncategory=="user"){
        alert("기업 회원만 이용가능합니다. 기업으로 회원가입해주세요.");

    }else{
        location.href="/user/center";
    }
})