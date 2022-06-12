function chkPW(){
    
    if($("#ChangePW").val().length < 8){
        alert("8자리이상으로 입력해주세요.");
        return false;
    }else if($("#ChangePW").val() !=$("#ChagePWCheck").val()){
        alert("비밀번호가 일치하지 않습니다.");
        return false;
    }else if($("#ChangePW").val()==$("#ChagePWCheck").val()){
        alert("비밀번호 변경 완료되었습니다.");
        return true;
    }

}