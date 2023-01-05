const requestModal= document.getElementsByClassName('requestModal')[0];
const body = document.querySelector('body');
const modalClose = document.querySelector('.requestModal_close');

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


modalClose.addEventListener('click', () => {
  requestModal.classList.toggle('show');

  if (requestModal.classList.contains('show')) {
    body.style.overflow = 'hidden';
  }else{
    body.style.overflow = 'auto';
  }
});