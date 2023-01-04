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
  
  
  $('#searchInput').keyup(function(){
    var txt = $(this).val();
    if(txt != ''){  //빈줄이 아니면 
        $('#searchboxInclude').children().remove();
  
        list.forEach(function(arg){
          if($("#selectType").val() == arg.mainCategoryNo){
            if(arg.serviceTitle.indexOf(txt) > -1 ){
              $('#searchboxInclude').append(
                  $('<div>').text(arg.serviceTitle).attr({'key':arg.serviceNo})
              );		
            }
          }
          if($("#selectType").val()==0){
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
          if($("#selectType").val() == arg.mainCategoryNo){
            if(arg.serviceTitle.indexOf(txt) > -1 ){
              $('#searchboxInclude').append(
                  $('<div>').text(arg.serviceTitle).attr({'key':arg.serviceNo})
              );		
            }
          }
          if($("#selectType").val()==0){
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
          if($("#selectType").val() == arg.mainCategoryNo){
            if(arg.serviceTitle.indexOf(txt) > -1 ){
              $('#searchboxInclude').append(
                  $('<div>').text(arg.serviceTitle).attr({'key':arg.serviceNo})
              );		
            }
          }
          if($("#selectType").val()==0){
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
          if($("#selectType").val() == arg.mainCategoryNo){
            if(arg.serviceTitle.indexOf(txt) > -1 ){
              $('#searchboxInclude').append(
                  $('<div>').text(arg.serviceTitle).attr({'key':arg.serviceNo})
              );		
            }
          }
          if($("#selectType").val()==0){
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
  
  
  $('.noSalesSevice').click(function(){
  
    alert('판매 중인 서비스가 아닙니다.');
  
  });
