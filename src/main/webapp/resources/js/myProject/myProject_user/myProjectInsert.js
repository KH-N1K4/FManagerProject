const projectRequestfrm =  document.getElementById("projectRequestfrm");

if(inquiryInsert != null ){

    inquiryInsert.addEventListener("submit",function(event){

        const titleInput =  document.getElementById("titleInput");
        if (titleInput.value.trim().length == 0) {
            alertAndFocus(titleInput, "제목을 입력해주세요.");
            event.preventDefault();  
            return;
        }

        const contentInput =  document.getElementById("contentInput");
        if (contentInput.value.trim().length == 0) {
            alertAndFocus(contentInput, "문의 내용을 입력해주세요.");
            event.preventDefault();  
            return;
        }

    })

    // 경고창 출력 + 포커스 이동 + 값 삭제 
    function alertAndFocus(input, str) {
        alert(str);
        input.focus();
        input.value;
    }


}