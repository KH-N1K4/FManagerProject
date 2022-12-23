/* 카테고리 */
$(function(){
  $('select[name="srchOption1"] ').on('change', function()  {
      let optionType = $("select[name='srchOption3']");
      optionType.empty();


      $("option:selected", this).each(function(){
        var selectValue = $(this).val(); //main category 에서 선택한 값
        optionType.append("<option value='' selected='' disabled>전체</option>");
        if(selectValue == 0){
          for(var i=0;i<listSize;i++){
            optionType.append("<option value='"+list[i].thirdCategoryNo+"'>"+list[i].thirdCategoryName+"</option>");
          }
        }else{

          for(var i=0;i<listSize;i++){
            console.log(list[i]);
              if(selectValue == list[i].mainCategoryNo){  
                optionType.append("<option value='"+list[i].thirdCategoryNo+"'>"+list[i].thirdCategoryName+"</option>");
                  
              }
          }

        }
    });

  });
});


