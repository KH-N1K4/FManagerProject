var now_utc = Date.now() // 지금 날짜를 밀리초로
// getTimezoneOffset()은 현재 시간과의 차이를 분 단위로 반환
var timeOff = new Date().getTimezoneOffset()*60000; // 분단위를 밀리초로 변환
// new Date(now_utc-timeOff).toISOString()은 '2022-05-11T18:09:38.134Z'를 반환
var today = new Date(now_utc-timeOff).toISOString().split("T")[0];
document.getElementById("searchDate1").setAttribute("max", today); //min날짜를 today로 하면 어제 날짜부터 선택 불가
document.getElementById("searchDate2").setAttribute("max", today);

$(document).ready(function(){
    /* 옵션 선택값으로 세팅 */
    var selectType = document.getElementById("selectType").title;
    if(selectType!=""){
      $("#selectType").val(selectType);
    }
  
    /* 옵션 선택값으로 세팅 */
    var searchDate1 = document.getElementById("searchDate1").title;
    $("#searchDate1").val(searchDate1);
  
    /* 옵션 선택값으로 세팅 */
    var searchDate2 = document.getElementById("searchDate2").title;
    $("#searchDate2").val(searchDate2);
  
  });

  $("#selectType").change(function(){
    $('#searchInput').val('');
  });
  

  
  
  $('.noSalesSevice').click(function(){
  
    alert('판매 중인 서비스가 아닙니다.');
  
  });


/* 완료버튼 */
const finishBtn = document.querySelectorAll(".finishBtn");
for(f of finishBtn){
  f.addEventListener("click",e=>{
    
    if(confirm('작업 완료?')){
      
      const tradeNo = e.target.id;
  
      $.ajax({
        url:'/myProject/memberDone',
        data: {'tradeNo':tradeNo},
        success: (result)=>{
          if(result>0){
  
          }
  
  
        }
  
      });
      
    }

  });
}

/* 취소 모달 */






/* 신고 모달 */






/* 리뷰 모달 */

