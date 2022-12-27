

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