let qnaService = (function(){


    function getUserinfo(userNum, callback) {
        $.ajax({
            url: "/store/userInfo?userNum=" + userNum,
            type: "get",
            async: false,
            success: function (user) {
                if(callback){
                    callback(user)
                }
            }
        })
    }


    function qnaList(param, callback) {
        $.ajax({
            url: "/store/qnaList/" + param.productNum + "/" + param.pageNum,
            type: "get",
            dataType: "json",
            success: function (qnaDTO) {
                if(callback){
                    callback(qnaDTO);
                }
            }
        })
    }

    function qnaCommentList(qnaNum,callback) {
        $.ajax({
            url: "/store/qnaCommentList/" + qnaNum,
            type: "get",
            async: false,
            success: function (qnaCommentLists) {
                if(callback){
                    callback(qnaCommentLists)
                }
            }
        });
    }

    function qnaDelete(num) {
        $.ajax({
            url: "/store/qnaDelete?num=" + num,
            type: "get",
            success: function (res) {
                showQnaList(pageNum);
            }
        })
    }

    function qnaCommentWrite(data) {
        $.ajax({
            url: "/store/qnaCommentWrite",
            type: "post",
            data: JSON.stringify(data),
            contentType: "application/json",
            success: function (comment) {

            }
        })
    }

    function qnaCommentUpdate(data) {
        $.ajax({
            url: "/store/qnaCommentUpdate",
            type: "post",
            data: data,
            success: function (result) {

            }
        });
    }

    function qnaCommentDelete(qnaCommentNum) {
        $.ajax({
            url:"/store/qnaCommentDelete?qnaCommentNum="+qnaCommentNum,
            type : "get",
            success : function (res) {
            }
        })
    }

    return {getUserinfo:getUserinfo,qnaList:qnaList,qnaCommentList:qnaCommentList,
        qnaDelete:qnaDelete,qnaCommentWrite:qnaCommentWrite,
        qnaCommentUpdate:qnaCommentUpdate,qnaCommentDelete:qnaCommentDelete};
})();