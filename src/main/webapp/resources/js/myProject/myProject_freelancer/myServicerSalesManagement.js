

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

});

/* 입력창 포커스아웃시 제거 */
$('#searchInput').blur(function(){

  $('#searchboxInclude').children().remove();

});



/* 신고하기 */
const body = document.querySelector('body');
const modal = document.querySelector('.reportModal');
const modalClose = document.querySelector('.reportModal_close');

$('.reportBtn').click(function(){
  const tradeNoValue = this.title;
  $('#memberName').val(loginMemberName);
  document.querySelector('#tradeNo').value = this.title;
  saleslist.forEach(function(arg,i){
    if(arg.tradeNo == tradeNoValue){
      document.querySelector('#serviceTitle').value = arg.serviceTitle;
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