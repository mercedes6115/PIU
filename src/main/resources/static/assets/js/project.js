
// 현재 위치 강조
let $currentPlace = $('.menus').find('a');
$currentPlace.click(function(){
    $currentPlace.removeClass('active');
    if(!$(this).hasClass('active')) {
        $(this).addClass('active');
    }
})

// 내부 페이지 이동

var pIntroOffset = $(".pIntroduceFrame").offset().top - 150;
var gIntroOffset = $(".gIntroduceFrame").offset().top - 200;
var qnaOffset = $(".qnaFrame").offset().top - 150;
var guideOffset = $(".useGuideFrame").offset().top;

var currentScroll = document.documentElement.scrollTop;
if(currentScroll < pIntroOffset) {
    if(!$currentPlace.hasClass('active')) {
        $currentPlace.addClass('active');
    }
}

function modal(id) {
    var zIndex = 9999;
    var modal = document.getElementById(id);

    // 모달 div 뒤에 희끄무레한 레이어
    var bg = document.createElement('div');
    bg.setStyle({
        position: 'fixed',
        zIndex: zIndex,
        left: '0px',
        top: '0px',
        width: '100%',
        height: '100%',
        overflow: 'auto',
        // 레이어 색갈은 여기서 바꾸면 됨
        backgroundColor: 'rgba(0,0,0,0.4)'
    });
    document.body.append(bg);

    // 닫기 버튼 처리, 시꺼먼 레이어와 모달 div 지우기
    modal.querySelector('.modal_close_btn').addEventListener('click', function() {
        bg.remove();
        modal.style.display = 'none';
        console.log("들어옴");
    });

    modal.setStyle({
        position: 'fixed',
        display: 'block',
        boxShadow: '0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19)',

        // 시꺼먼 레이어 보다 한칸 위에 보이기
        zIndex: zIndex + 1,

        // div center 정렬
        top: '50%',
        left: '50%',
        transform: 'translate(-50%, -50%)',
        msTransform: 'translate(-50%, -50%)',
        webkitTransform: 'translate(-50%, -50%)'
    });
}

// Element 에 style 한번에 오브젝트로 설정하는 함수 추가
Element.prototype.setStyle = function(styles) {
    for (var k in styles) this.style[k] = styles[k];
    return this;
};


document.getElementById('applyBtn').addEventListener('click', function() {
    modal('applyModal')
});

$(".moveIntroduce").click(function(){
    $("html, body").animate({scrollTop: pIntroOffset}, 0);
    console.log("들어옴");
});
$(".moveGroup").click(function(){
    $("html, body").animate({scrollTop: gIntroOffset}, 0);
});
$(".moveCommunity").click(function(){
    $("html, body").animate({scrollTop: qnaOffset}, 0);
});
$(".moveGuide").click(function(){
    $("html, body").animate({scrollTop: guideOffset}, 0);
});


// 댓글 등록 버튼 클릭시
$(document).ready(function() {

    $('button.qContentAddBtn').on("click", function () {
        let qnaNum = $(this).attr('name');
        let $comment = $('#' + qnaNum).val();
        $.ajax({
            url: "/projectQnA/" + qnaNum ,
            type: "post",
            // data: JSON.stringify({comment:$comment}),
            // contentType: "application/json",
            success: function(result){
                alert(result.content);
            }

        });
    })
});