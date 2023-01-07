var now_utc = Date.now() // 지금 날짜를 밀리초로
// getTimezoneOffset()은 현재 시간과의 차이를 분 단위로 반환
var timeOff = new Date().getTimezoneOffset()*60000; // 분단위를 밀리초로 변환
// new Date(now_utc-timeOff).toISOString()은 '2022-05-11T18:09:38.134Z'를 반환
var today = new Date(now_utc-timeOff).toISOString().split("T")[0];
document.getElementById("searchDate1").setAttribute("max", today); //min날짜를 today로 하면 어제 날짜부터 선택 불가
document.getElementById("searchDate2").setAttribute("max", today);

$(document).ready(function(){
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