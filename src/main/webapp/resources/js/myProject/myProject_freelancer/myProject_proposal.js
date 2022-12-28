const selecsortService = document.getElementById("srchOption1");
selecsortService.addEventListener("change",function(){
  document.forms["OptionfrmSearch"].submit();
});

$(document).ready(function(){
  
  /* 옵션 선택값으로 세팅 */
  var srchOption = document.getElementById("srchOption1").title;
  $("#srchOption1").val(srchOption).prop('selected', true);

});