//------------------------------공통----------------------//

//scroll top
// $('.gotoTop').click(function(){
//     $('html, body').animate({scrollTop : 0},300);
// });
let replyService = (function(){
    function getList(productNum, callback, error){
        // let page = param.page || 1;
        // $.getJSON("/reply/list/" + param.bno + "/" + page, function(replyPageDTO){
        //     if(callback){
        //         callback(replyPageDTO.total, replyPageDTO.list);
        //     }
        // }).fail(function(xhr, status, er){
        //     if(error){
        //         error(er);
        //     }
        // });
        $.ajax({
            url: "/reviewList/" + productNum,
            type: "get",
            dataType: "json",
            success: function(productReviewVO){
                if(callback){
                    callback(productReviewVO);
                }
            }
        });
    }

    return {getList: getList};
})();
// -------------------------payment 페이지-------------------//

//개인정보 동의 모달
let modal = document.getElementById("agree_modal");
let agreebtn = document.getElementById("agree_detail");
var span = document.getElementsByClassName("close")[0];
let modal_close = document.getElementById("modal_close_btn");

agreebtn.onclick = function(){
    modal.style.display = "block";
}
span.onclick = function() {
    modal.style.display = "none";
}
modal_close.onclick = function(){
    modal.style.display = "none";
}


// 배송정보 받는사람 유효성
$('#personname').blur(function(){
    $("#personname_check").show();
    let $personname = $('#personname').val();
    if(!$personname){
        $("#personname_check").empty().text("주문자 명을 입력해주세요");
    }else{
        $("#personname_check").hide();
    }
});

//배송정보 받는사람 휴대폰 번호 유효성
$('#personphone').blur(function(){
    $("#personphone_check").show();
    let $personphone = $('#personphone').val();
    if(!$personphone || $personphone.length!=11 || !$.isNumeric($personphone) ){
        $("#personphone_check").empty().text("정확한 전화번호를 입력하세요");
    }else{
        $("#personphone_check").hide();
    }
});


//주소검색
window.onload = function(){
    document.getElementById("personaddrbtn").addEventListener("click", function(){ //주소입력칸을 클릭하면
        //카카오 지도 발생
        new daum.Postcode({
            oncomplete: function(data) { //선택시 입력값 세팅
                document.getElementById("personaddr").value = data.address; // 주소 넣기
                document.querySelector("input#addr_detail").focus(); //상세입력 포커싱
            }
        }).open();
    });
}


//개인정보 동의(모달창에서)
$('#modal_close_btn').click(function(){
    $('#agree').prop("checked", true);
})


// -----------------------pickitupStoreDetail 페이지-------------------//
// -----------------------pickitupItemChoose 페이지-------------------//


