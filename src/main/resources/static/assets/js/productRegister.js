//사이드바
$(document).ready(function () {
    $('#sidebar').load("adminSideBar.html");
});


//카테고리 체크박스 한개만 선택가능
function checkOnlyOne(element) {
    const checkboxes = document.getElementsByName("category");
    checkboxes.forEach((cb) => {
        cb.checked = false;
    })
    element.checked = true;
}


//입력 유효성 검사
function invalidItem() {
    let cnt = $("input[name=category]:checkbox:checked").length;
    //몇개 선택되어있는지 개발자 모드에서 확인해보세요.
    console.log(cnt);
    if (cnt < 1) {
        alert("한 개 이상을 선택하셔야 합니다.");
        return false;
    }else{
        return true;
    }
}



//상품 작성 할때 글자수 세기
$('.productName').keyup(function (e) {
    let content = $(this).val();

    // 글자수 세기
    if (content.length == 0 || content == '') {
        $('.textCount').text('0');
    } else {
        $('.textCount').text(content.length);
    }

    // 글자수 제한
    if (content.length > 250) {
        // 250자 부터는 타이핑 되지 않도록
        $(this).val($(this).val().substring(0, 250));
        // 250자 넘으면 알림창 뜨도록
        alert('글자수는 250자까지 입력 가능합니다.');
    };
});

//상품요약 작성 할때 글자수 세기
$('.summary').keyup(function (e) {
    let content = $(this).val();

    // 글자수 세기
    if (content.length == 0 || content == '') {
        $('.textCount1').text('0');
    } else {
        $('.textCount1').text(content.length);
    }

    // 글자수 제한
    if (content.length > 250) {
        // 250자 부터는 타이핑 되지 않도록
        $(this).val($(this).val().substring(0, 250));
        // 250자 넘으면 알림창 뜨도록
        alert('글자수는 250자까지 입력 가능합니다.');
    };
});


function handleOnClick()  {
    let like = confirm("정말 취소하시겠습니까?");
    document.getElementById('result').innerText = like;
}



// 강사님


//첨부파일 input태그 가져오기
const file0 = document.querySelector("input.attach0");
const file1 = document.querySelector("input.attach1");
const file2 = document.querySelector("input.attach2");
const file3 = document.querySelector("input.attach3");
const file4 = document.querySelector("input.attach4");
const thumbnail0 = document.querySelector("label[for='attach0'] div.thumb0");
const thumbnail1 = document.querySelector("label[for='attach1'] div.thumb1");
const thumbnail2 = document.querySelector("label[for='attach2'] div.thumb2");
const thumbnail3 = document.querySelector("label[for='attach3'] div.thumb3");
const thumbnail4 = document.querySelector("label[for='attach4'] div.thumb4");

//첨부파일이 등록되었다면 change이벤트 발생
file0.addEventListener("change", function(event){
    //특정 경로의 파일을 읽어올 때 사용.
    let reader = new FileReader();
    reader.readAsDataURL(event.target.files[0]);
    reader.onload = function(event){
        //등록된 파일의 경로에 작성된 파일의 타입검사
        if(event.target.result.includes("image")){
            console.log("이미지 파일입니다.");
            $(thumbnail0).text("");
            //등록된 파일의 경로로 대체
            thumbnail0.style.backgroundImage = "url(\"" + event.target.result + "\")";
            file1.disabled = false;
            $(thumbnail1).css("background-color","white");
            number1();

        }else{
            alert("이미지 파일이 아닙니다.");
            //미리 준비해놓은 이미지 경로로 대체
            $(thumbnail0).text("");
            thumbnail0.style.backgroundImage = "url(/images/error.png)";
        }
    }
});
function number1(){
    file1.addEventListener("change", function(event){
        //특정 경로의 파일을 읽어올 때 사용.
        let reader = new FileReader();
        reader.readAsDataURL(event.target.files[0]);
        reader.onload = function(event){
            //등록된 파일의 경로에 작성된 파일의 타입검사
            if(event.target.result.includes("image")){
                console.log("이미지 파일입니다.");
                $(thumbnail1).text("");
                //등록된 파일의 경로로 대체
                thumbnail1.style.backgroundImage = "url(\"" + event.target.result + "\")";
                file2.disabled = false;
                $(thumbnail2).css("background-color","white");
                number2()
            }else{
                alert("이미지 파일이 아닙니다.");
                //미리 준비해놓은 이미지 경로로 대체
                $(thumbnail1).text("");
                thumbnail1.style.backgroundImage = "url(/images/error.png)";
            }
        }
    });
}

function number2(){
    file2.addEventListener("change", function(event){
        //특정 경로의 파일을 읽어올 때 사용.
        let reader = new FileReader();
        reader.readAsDataURL(event.target.files[0]);
        reader.onload = function(event){
            //등록된 파일의 경로에 작성된 파일의 타입검사
            if(event.target.result.includes("image")){
                console.log("이미지 파일입니다.");
                $(thumbnail2).text("");
                //등록된 파일의 경로로 대체
                thumbnail2.style.backgroundImage = "url(\"" + event.target.result + "\")";
                file3.disabled=false;
                $(thumbnail3).css("background-color","white");
                number3();
            }else{
                alert("이미지 파일이 아닙니다.");
                $(thumbnail2).text("");
                //미리 준비해놓은 이미지 경로로 대체
                thumbnail2.style.backgroundImage = "url(/images/error.png)";
            }
        }
    });
}

function number3(){
    file3.addEventListener("change", function(event){
        //특정 경로의 파일을 읽어올 때 사용.
        let reader = new FileReader();
        reader.readAsDataURL(event.target.files[0]);
        reader.onload = function(event){
            //등록된 파일의 경로에 작성된 파일의 타입검사
            if(event.target.result.includes("image")){
                console.log("이미지 파일입니다.");
                $(thumbnail3).text("");
                //등록된 파일의 경로로 대체
                thumbnail3.style.backgroundImage = "url(\"" + event.target.result + "\")";
                file4.disabled=false;
                $(thumbnail4).css("background-color","white");
                number4();
            }else{
                alert("이미지 파일이 아닙니다.");
                //미리 준비해놓은 이미지 경로로 대체
                $(thumbnail3).text("");
                thumbnail3.style.backgroundImage = "url(/images/error.png)";
            }
        }
    });
}
function number4() {
    file4.addEventListener("change", function (event) {
        //특정 경로의 파일을 읽어올 때 사용.
        let reader = new FileReader();
        reader.readAsDataURL(event.target.files[0]);
        reader.onload = function (event) {
            //등록된 파일의 경로에 작성된 파일의 타입검사
            if (event.target.result.includes("image")) {
                console.log("이미지 파일입니다.");
                $(thumbnail4).text("");
                //등록된 파일의 경로로 대체
                thumbnail4.style.backgroundImage = "url(\"" + event.target.result + "\")";
            } else {
                alert("이미지 파일이 아닙니다.");
                //미리 준비해놓은 이미지 경로로 대체
                $(thumbnail4).text("");
                thumbnail4.style.backgroundImage = "url(/images/error.png)";
            }
        }
    });
}

    //
    // function checkText(){
    //     const textAreaval=$("textarea[name='context']").val();
    //     if(textAreaval==null){
    //         alert("상품 상세 설명을 기입해주세요");
    //     }
    // }



$(".productbtn").on("click", function(e){
        e.preventDefault();
        if(!invalidItem()){
            return;
        }else{
        let formData =   new FormData();
        let inputFile = $("input[name='uploadFiles']");
        let files0 = inputFile[0].files;
        let files1 = inputFile[1].files;
        let files2 = inputFile[2].files;
        let files3 = inputFile[3].files;
        let files4 = inputFile[4].files;
        if(files0.length!=0){formData.append("uploadFiles", files0[0])}
        if(files1.length!=0){formData.append("uploadFiles", files1[0])}
        if(files2.length!=0){formData.append("uploadFiles", files2[0])}
        if(files3.length!=0){formData.append("uploadFiles", files3[0])}
        if(files4.length!=0){formData.append("uploadFiles", files4[0])}
        console.log("ajax");

        // for(let i=0; i<files.length; i++) {
        //     formData.append("uploadFiles", files[i]);
        // }
        $.ajax({
            url: "/productFile/upload",
            type: "post",
            data: formData,
            contentType: false,
            processData: false,
            async : false,
            success: function(files){
                let str = "";
                $.each(files, function(i, file){
                    str += "<input type='hidden' name='fileList[" + i + "].fileName' value='" + file.fileName + "'>"
                    str += "<input type='hidden' name='fileList[" + i + "].uuid' value='" + file.uuid + "'>"
                    str += "<input type='hidden' name='fileList[" + i + "].uploadPath' value='" + file.uploadPath + "'>"
                });
                $('#registerForm').append(str);
            }
        });
        registerForm.submit();
        }
});

