
/* 제안하기 */
var booleanvar = false;
document.getElementById('proposalpriceInput').addEventListener("input", function(){
  if(this.value.trim().length != null || this.value.trim() != 0){
    console.log(this.value);
    var regExp = /^[0-9]+$/;
    console.log(regExp.test(this.value.trim()));
    if(regExp.test(this.value.trim())){
      console.log('변경');
      console.log(booleanvar);
      booleanvar = true;
    }else{
      booleanvar = false;
    }
  } 
});

document.getElementById('sendRequestBtn').addEventListener("click", function () {
  const proposalpriceInput= document.getElementById('proposalpriceInput').value;
  const proposalEditInput= document.getElementById('proposalEditInput').value;

  if(booleanvar){

    console.log('requestNoVar:'+requestNoVar);
    console.log('loginMemberNo:'+loginMemberNo);
    console.log('proposalpriceInput:'+proposalpriceInput);
    console.log('proposalEditInput:'+proposalEditInput);
    $.ajax({
        
      url: "/requestDetailSubmit",
      data: { 
        "requestNO"  : requestNoVar,
        "proposalpriceInput" : proposalpriceInput,
        "proposaleditInput": proposalEditInput,
        "proposalMemberNo": loginMemberNo
      },
      type: "POST", 
      dataType: "JSON", // 응답 데이터의 형식이 JSON이다. -> 자동으로 JS 객체로 변환
      success: (result) => {
          if(result == "제안하기 등록되었습니다."){
            alert(result);

            //리스트에 추가해야함
            proposalList.push({"freelancerNo":loginMemberNo})
            requestModal.classList.toggle('show');
            if (requestModal.classList.contains('show')) {
              body.style.overflow = 'hidden';
            }else{
              body.style.overflow = 'auto';
            }
            
          }
      },
      error: () => {
          console.log("제안하기 완료 실패")
      }
  
  
    });
  
  }else{
    alert('금액을 입력하세요.');
  }
  

});