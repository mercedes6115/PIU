let mainService = (function(){

    function doJjim(data, callback){
        $.ajax({
            url:"/store/jjim",
            type:"post",
            data: data,
            success : function (result) {
                if(callback){
                    callback(result)
                }
            }
        })
    }

    function deleteJjim(data,callback){
        $.ajax({
            url:"/store/jjim",
            type:"delete",
            data: data,
            success : function (result) {
                if(callback){
                    callback(result)
                }
            }
        })
    }

    function jjimCheck(callback) {
        $.ajax({
            url : "/store/jjim",
            type : "get",
            success : function (jjims) {
                if(callback){
                    callback(jjims)
                }
            }
        });
    }

    function mainLists(category, callback) {
        $.ajax({
            url : "/store/main",
            type: "post",
            data : {category : category},
            success: function (lists) {
                if(callback){
                    callback(lists)
                }
            }
        })
    }

    function jjimcount(listsNum, callback) {
        $.ajax({
            url: "/store/jjimCount?productNum="+listsNum,
            type : "get",
            async:false,  // ajax 안에 ajax를 사용할때는 동기식으로 바꿔줘야함
            success : function (count) {
                if(callback){
                    callback(count)
                }
            }
        })
    }

    // 프로젝트의 사진 가져오기
    function getFileLists(listsNum,callback) {
        $.ajax({
            url: "/productFile/list/"+listsNum,
            type : "get",
            async:false,  // ajax 안에 ajax를 사용할때는 동기식으로 바꿔줘야함
            success : function (files) {
                if(callback){
                    callback(files)
                }
            }
        })
    }

    return {doJjim:doJjim, deleteJjim:deleteJjim, jjimCheck:jjimCheck,mainLists:mainLists,
        jjimcount:jjimcount,getFileLists:getFileLists};
})();