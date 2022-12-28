

$(document).ready(function(){
  
  /* 옵션 선택값으로 세팅 */
  var srchOption = document.getElementById("srchOption1").title;
  $("#srchOption1").val(srchOption).prop('selected', true);

  /* 옵션 선택값으로 세팅 */
  var srchOption2 = document.getElementById("srchOption2").title;
  $("#srchOption2").val(srchOption2).prop('selected', true);

});

$('#searchInput').keyup(function(){
    var txt = $(this).val();
    if(txt != ''){  //빈줄이 아니면 
        $('#searchboxInclude').children().remove();

        list.forEach(function(arg){
            if(arg.serviceTitle.indexOf(txt) > -1 ){
                $('#searchboxInclude').append(
                    $('<div>').text(arg.serviceTitle).attr({'key':arg.serviceNo})
                );		
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

        list.forEach(function(arg){
          $('#searchboxInclude').append(
            $('<div>').text(arg.serviceTitle).attr({'key':arg.serviceNo})
          );		
      
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

      list.forEach(function(arg){
          if(arg.serviceTitle.indexOf(txt) > -1 ){
              $('#searchboxInclude').append(
                  $('<div>').text(arg.serviceTitle).attr({'key':arg.serviceNo})
              );		
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

      list.forEach(function(arg){
        $('#searchboxInclude').append(
          $('<div>').text(arg.serviceTitle).attr({'key':arg.serviceNo})
        );		
    
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



/* 신고하기 */
const body = document.querySelector('body');
const modal = document.querySelector('.reportModal');
const modalClose = document.querySelector('.reportModal_close');

$('.reportBtn').click(function(){
  document.querySelector('#ajaxReview').style.backgroundColor = '#538126';
  document.querySelector('#reportContent').value = "";
  document.querySelector('#reportFilePath').value = "";
  document.querySelector('.fileRemove').style.display ="block";
  $(".fileaddDiv").remove();
  const tradeNoValue = this.title;
  $('#memberName').val(loginMemberName);
  document.querySelector('#tradeNo').value = this.title;
  saleslist.forEach(function(arg,i){
    if(arg.tradeNo == tradeNoValue){
      document.querySelector('#serviceTitle').value = arg.serviceTitle;
      console.log(arg.tradeReportNo);
      console.log(arg);
      console.log(arg.tradeReportNo != 0);

      if(arg.tradeReportNo != 0){
        document.querySelector('#reportContent').value = arg.reportContent.replace(/(<br>|<br\/>|<br \/>)/g, '\r\n');
        //.replace(/(<br>|<br\/>|<br \/>)/g, '\r\n');
        document.querySelector('.fileRemove').style.display ="none";
        if(arg.reportFilePath != null){
          /* document.querySelector('#reportFilePath').value = arg.reportFilePath; */
          const div = document.createElement("div");
          div.classList.add("list_content"); 
          div.classList.add("fileaddDiv"); 
          const a = document.createElement("a");
          a.setAttribute("href", arg.reportFilePath);
          a.setAttribute("target", "_blank");//target="_blank"
          a.style.textDecoration ="none";
          a.style.color ="black";
          a.style.fontSize ="12px";
          a.innerText = "업로드 파일 다운로드";
          const fileadd= document.getElementById("fileadd");
          fileadd.append(div);
          div.append(a);

        }
        document.querySelector('#ajaxReview').disabled = true;
        document.querySelector('#ajaxReview').style.backgroundColor = 'gray';
      }else{
        document.querySelector('#ajaxReview').disabled = false;
        $(".fileaddDiv").remove();
      }

    } 
  });
    modal.classList.toggle('show');
    if (modal.classList.contains('show')) {
      body.style.overflow = 'hidden';
    }
});

modalClose.addEventListener('click', () => {
  modal.classList.toggle('show');

  if (modal.classList.contains('show')) {
    body.style.overflow = 'hidden';
  }
});

/* 발송하기 */
$('.sendBtn').click(function(){
  const tradeNoValue = this.title;
  $.ajax({
        
    url: "/sendworkSubmit",
    data: { 
      "tradeNo"  : tradeNoValue,
    },
    type: "POST", 
    dataType: "JSON", // 응답 데이터의 형식이 JSON이다. -> 자동으로 JS 객체로 변환
    success: (result) => {
        console.log(result);
        console.log(tradeNoValue);
        if(result == "작업물 발송이 완료되었습니다."){
          alert(result);
          saleslist.forEach(function(arg){
            if(arg.tradeNo == tradeNoValue){
              console.log("더하기 전:"+arg.workCount);
              arg.workCount = arg.workCount+1;
              console.log("더하기 후:"+arg.workCount);
              if(arg.workCount == arg.serviceEditNum+1){
                document.getElementById('serviceEditNum'+arg.tradeNo).innerText = (arg.workCount-1)+"/"+arg.serviceEditNum;
              }else{
                document.getElementById('serviceEditNum'+arg.tradeNo).innerText = arg.workCount+"/"+arg.serviceEditNum;
              }

              if(arg.workCount > arg.serviceEditNum){
                $('#sendBtn'+arg.tradeNo).remove();
              }
              
            } 
          });
          
        }
    },
    error: () => {
        console.log("발송 실패")
    }


  });

});


/* 완료하기 */
$('.finishBtn').click(function(){
  const tradeNoValue = this.title;
  $.ajax({
        
    url: "/finishSubmit",
    data: { 
      "tradeNo"  : tradeNoValue,
    },
    type: "POST", 
    dataType: "JSON", // 응답 데이터의 형식이 JSON이다. -> 자동으로 JS 객체로 변환
    success: (result) => {
        console.log(result);
        console.log(tradeNoValue);
        if(result == "작업상태가 완료로 변경되었습니다."){
          alert(result);
          $('#finishBtn'+tradeNoValue).remove();
          $('#sendBtn'+tradeNoValue).remove();
          $('#reportBtn'+tradeNoValue).remove();
          
        }
    },
    error: () => {
        console.log("작업상태 완료 실패")
    }


  });

});



