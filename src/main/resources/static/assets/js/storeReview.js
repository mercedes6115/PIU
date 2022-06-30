let reviewService = (function(){


    function getReviewList(productNum,callback) {
        $.ajax({
            url: "/store/reviewLists/" + productNum,
            type: "get",
            dataType: "json",
            success: function (reviews) {
                if(callback){
                    callback(reviews);
                }
            }
        });
    }


    function getReviewFiles(reviewNum, callback) {
        $.ajax({
            url: "/productReviewFile/list/" + reviewNum,
            type: "get",
            success: function (files) {
                if (callback){
                    callback(files)
                }
            }
        })
    }

    function reviewFileUpload(formData, callback) {
        $.ajax({
            url: "/productReviewFile/upload",
            type: "post",
            data: formData,
            contentType: false,
            processData: false,
            async: false,
            success: function (files) {
                if (callback){
                    callback(files)
                }
            }
        })
    }
    function reviewDelete(num) {
        $.ajax({
            url: "/store/reviewDelete?num=" + num,
            type: "get",
            success: function (res) {
                location.href = "/store/goReviewList/"+productNum;
            }
        })

    }

    return {getReviewList:getReviewList,getReviewFiles:getReviewFiles,reviewFileUpload:reviewFileUpload,reviewDelete:reviewDelete};
})();