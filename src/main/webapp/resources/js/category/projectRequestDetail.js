const requestModal= document.getElementsByClassName('requestModal')[0];
const body = document.querySelector('body');
const modalClose = document.querySelector('.requestModal_close');
if(document.getElementById('requestBtn') != null){
  document.getElementById('requestBtn').addEventListener("click", function () {
    var booleanVar = false;
    proposalList.forEach(function(arg){
      if(arg.freelancerNo == loginMemberNo){
        booleanVar = true;
        console.log(arg.freelancerNo);
        console.log(loginMemberNo);
      }
    });
  
    if(booleanVar){
      alert('제안 보낸 이력이 있는 프로젝트 의뢰입니다.')
    }else{
      console.log(loginMemberNo)
      if(loginMemberNo == ''){
        if(confirm('로그인 후 사용가능합니다. 로그인 창으로 이동하시겠습니까?')){
          location.href ='/member/login';
          //document.getElementById('requestBtn').setAttribute("href",'/member/login');
        }
      }else{
        if(freelancerFL=='N'){
          alert('프리랜서 등록 후 가능합니다.')
        }else{
            //proposalListJson.push({"freelancerNo":loginMemberNo});
            /*  요청사항에 들어갈 값들  */
            document.getElementById('proposalpriceInput').value ='';
            document.getElementById('proposalEditInput').value ='';
            requestModal.classList.toggle('show');
            if (requestModal.classList.contains('show')) {
              body.style.overflow = 'hidden';
            }else{
              body.style.overflow = 'auto';
            }
        }
        
  
  
  
  
      }  
    }
  
  });
}

modalClose.addEventListener('click', () => {
  requestModal.classList.toggle('show');

  if (requestModal.classList.contains('show')) {
    body.style.overflow = 'hidden';
  }else{
    body.style.overflow = 'auto';
  }
});


if(document.getElementById('stopBtn') != null){
/* 의뢰중지 */
    document.getElementById('stopBtn').addEventListener("click", function () {
      document.getElementById('layerStopRequest').style.display = 'block';
    });

}

if(document.getElementById('layerStopRequest') != null){
  $(".layerStopRequestBtn").click(function() {
    $.ajax({
          
      url: "/requestStopSubmit",
      data: { 
        "requestNO"  : requestNoVar
      },
      type: "POST", 
      dataType: "JSON", // 응답 데이터의 형식이 JSON이다. -> 자동으로 JS 객체로 변환
      success: (result) => {
          if(result == "내 의뢰 내리기가 완료되었습니다."){
            alert(result);
            location.href ="/projectRequest/requestList/0/0/0";
          }
      },
      error: () => {
          console.log("내 의뢰 내리기 실패")
      }


    });
  });

  $("._hideLayer").click(function() {
    document.getElementById("layerStopRequest").style.display = "none";
  });
}