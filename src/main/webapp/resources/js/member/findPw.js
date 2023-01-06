const signInBtn = document.getElementById("signInBtn");

signInBtn.addEventListener("click",e=>{

    const memberEmail = document.querySelector("[name='memberEmail']");
    const memberName = document.querySelector("[name='memberName']");
    const memberTel = document.querySelector("[name='memberTel']");
    
    if(memberEmail.value.trim().length == 0){

        alert("이메일 항목은 필수입니다.");
        memberEmail.focus();
        e.preventDefault();
        return;
    }
   
    if(memberName.value.trim().length == 0){

        alert("이름 항목은 필수입니다.");
        memberName.focus();
        e.preventDefault();
        return;
    }
    if(memberTel.value.trim().length == 0){

        alert("전화번호 항목은 필수입니다.");
        memberTel.focus();
        e.preventDefault();
        return;
    }

    $.ajax({
        url:'/member/findPw',
        data: {'memberEmail':memberEmail.value,'memberName':memberName.value,'memberTel':memberTel.value},
        type: 'POST',
        success: (result)=>{
            if(result>0){
                alert("회원가입 시 등록된 이메일("+memberEmail.value+")로 임시 비밀번호를 발송해드렸습니다."+
                "\n\n임시 비밀번호로 로그인 하신 후 마이페이지에서 비밀번호를 변경하시기 바랍니다.");
                location.href="/member/login";
            } else{
                alert("입력하신 내용으로 일치하는 정보가 없습니다.");
            }
        }

    });



});