$('.creater').click(function (e) {
    e.preventDefault();
    console.log("버튼 누름")
    if (sessioncategory == "user") {
        alert("기업 회원만 이용가능합니다. 기업으로 회원가입해주세요.");

    } else {
        location.href = "/group/main";
    }
})

if(url == "store") {
    $('.nav-container').css("display", "none");
    $('.menu-plogging').css("color", "black");
    $('.menu-store').css("color","#1F89FF");
} else {
    $('.nav-container').css("display", "block");
    $('.menu-plogging').css("color", "#1F89FF");
    $('.menu-store').css("color","black");
}




$(function () {
    $(document).mousedown(function (e) {
        if ($(".CategoryListWrapper").is(":visible")) {
            $(".CategoryListWrapper").each(function () {
                var l_position = $(this).offset();
                l_position.right = parseInt(l_position.left) + ($(this).width());
                l_position.bottom = parseInt(l_position.top) + parseInt($(this).height());

                if( ( l_position.left <= e.pageX && e.pageX <= l_position.right )
                    && ( l_position.top <= e.pageY && e.pageY <= l_position.bottom ) ) {
                } else {
                    $(this).hide();
                }
            });
        }
    });
    $(".nav-category-text-wrap").click(function () {
        if (!$(".CategoryListWrapper").is(":visible")) {
            $(".CategoryListWrapper").show();
        }
    });
});


$(".search-icon111").val().split("/")[0];

