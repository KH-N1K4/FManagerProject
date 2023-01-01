var now_utc = Date.now() // 지금 날짜를 밀리초로
// getTimezoneOffset()은 현재 시간과의 차이를 분 단위로 반환
var timeOff = new Date().getTimezoneOffset()*60000; // 분단위를 밀리초로 변환
// new Date(now_utc-timeOff).toISOString()은 '2022-05-11T18:09:38.134Z'를 반환
var today = new Date(now_utc-timeOff).toISOString().split("T")[0];
document.getElementById("startDate").setAttribute("max", today); //min날짜를 today로 하면 어제 날짜부터 선택 불가
document.getElementById("endtDate").setAttribute("max", today);

$(document).ready(function(){
  /* 옵션 선택값으로 세팅 */
  var srchOption = document.getElementById("srchOption1").title;
  $("#srchOption1").val(srchOption).prop('selected', true);

  /* 옵션 선택값으로 세팅 */
  var startDate = document.getElementById("startDate").title;
  $("#startDate").val(startDate).prop('selected', true);

  /* 옵션 선택값으로 세팅 */
  var endtDate = document.getElementById("endtDate").title;
  $("#endtDate").val(endtDate).prop('selected', true);

});

$("#srchOption1").change(function(){
  $('#searchInput').val('');
});


$('#searchInput').keyup(function(){
  var txt = $(this).val();
  if(txt != ''){  //빈줄이 아니면 
      $('#searchboxInclude').children().remove();

      list.forEach(function(arg){
        if($("#srchOption1").val() == arg.mainCategoryNo){
          if(arg.serviceTitle.indexOf(txt) > -1 ){
            $('#searchboxInclude').append(
                $('<div>').text(arg.serviceTitle).attr({'key':arg.serviceNo})
            );		
          }
        }
        if($("#srchOption1").val()==0){
          if(arg.serviceTitle.indexOf(txt) > -1 ){
            $('#searchboxInclude').append(
                $('<div>').text(arg.serviceTitle).attr({'key':arg.serviceNo})
            );		
          }
        }

      });
      $('#searchboxInclude').children().each(function(){ //자동완성 div 각각 클릭시
          $(this).click(function(){
              $('#searchInput').val($(this).text());
              $('#searchboxInclude').children().remove();	
          });
      });			
  } else {
      $('#searchboxInclude').children().remove();

      /* list.forEach(function(arg){
        $('#searchboxInclude').append(
          $('<div>').text(arg.serviceTitle).attr({'key':arg.serviceNo})
        );		
    
      }); */
      list.forEach(function(arg){
        if($("#srchOption1").val() == arg.mainCategoryNo){
          if(arg.serviceTitle.indexOf(txt) > -1 ){
            $('#searchboxInclude').append(
                $('<div>').text(arg.serviceTitle).attr({'key':arg.serviceNo})
            );		
          }
        }
        if($("#srchOption1").val()==0){
          if(arg.serviceTitle.indexOf(txt) > -1 ){
            $('#searchboxInclude').append(
                $('<div>').text(arg.serviceTitle).attr({'key':arg.serviceNo})
            );		
          }
        }

      });
    
      $('#searchboxInclude').children().each(function(){
        $(this).click(function(){
          $('#searchInput').val($(this).text());
          $('#searchboxInclude').children().remove();	
        });
      });
  }  
});


/* 입력창 포커스시 서비스명 다 출력 */
$('#searchInput').click(function(){
  var txt = $(this).val();
  if(txt != ''){  //빈줄이 아니면 
      $('#searchboxInclude').children().remove();

      /* list.forEach(function(arg){
          if(arg.serviceTitle.indexOf(txt) > -1 ){
              $('#searchboxInclude').append(
                  $('<div>').text(arg.serviceTitle).attr({'key':arg.serviceNo})
              );		
          }
      }); */
      list.forEach(function(arg){
        if($("#srchOption1").val() == arg.mainCategoryNo){
          if(arg.serviceTitle.indexOf(txt) > -1 ){
            $('#searchboxInclude').append(
                $('<div>').text(arg.serviceTitle).attr({'key':arg.serviceNo})
            );		
          }
        }
        if($("#srchOption1").val()==0){
          if(arg.serviceTitle.indexOf(txt) > -1 ){
            $('#searchboxInclude').append(
                $('<div>').text(arg.serviceTitle).attr({'key':arg.serviceNo})
            );		
          }
        }

      });
      $('#searchboxInclude').children().each(function(){ //자동완성 div 각각 클릭시
          $(this).click(function(){
              $('#searchInput').val($(this).text());
              $('#searchboxInclude').children().remove();	
          });
      });			
  } else {
      $('#searchboxInclude').children().remove();

      /* list.forEach(function(arg){
        $('#searchboxInclude').append(
          $('<div>').text(arg.serviceTitle).attr({'key':arg.serviceNo})
        );		
    
      }); */
      list.forEach(function(arg){
        if($("#srchOption1").val() == arg.mainCategoryNo){
          if(arg.serviceTitle.indexOf(txt) > -1 ){
            $('#searchboxInclude').append(
                $('<div>').text(arg.serviceTitle).attr({'key':arg.serviceNo})
            );		
          }
        }
        if($("#srchOption1").val()==0){
          if(arg.serviceTitle.indexOf(txt) > -1 ){
            $('#searchboxInclude').append(
                $('<div>').text(arg.serviceTitle).attr({'key':arg.serviceNo})
            );		
          }
        }

      });
    
      $('#searchboxInclude').children().each(function(){
        $(this).click(function(){
          $('#searchInput').val($(this).text());
          $('#searchboxInclude').children().remove();	
        });
      });
  } 

});

/* 입력창 포커스아웃시 제거 안됨*/
$('#searchboxRelative').mouseleave(function(){
  
  $('#searchboxInclude').children().remove();

});
