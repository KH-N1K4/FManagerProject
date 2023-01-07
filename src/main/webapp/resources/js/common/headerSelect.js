$(function() {   // <input>요소에 문자가 입력될 때마다 호출됨.

  $("#search-input").keyup(function() {

    if ($(this).val().replace(" ","") == "")
		{
			document.getElementById("suggestion_box").style.display="none";
			return;
		}
    
    $.ajax({ // Ajax 요청을 작성하고 GET 방식으로 전송함.

      url: "/common/searchInput",

      data: { 
        "keyword" : $(this).val().trim(),
      },

      method: "GET", 
      dataType: "JSON", // 응답 데이터의 형식이 JSON이다. -> 자동으로 JS 객체로 변환
      success: (result) => {
        var Category;
        console.log(result);
        if(result.length > 0){
          for(let i=0; result.length>i;i++){
            console.log(result[i]);
            Category =result[i].mainCategoryName +" > "+result[i].subCategoryName;

            document.getElementById("suggestion_box").innerHTML
            += "<div class='Category'>" + Category +" "+ "<span class='serviceTitleVar'>"+result[i].serviceTitle +"</span>"+ "</div>";

            // 최종적으로 목록을 화면에 보일 수 있도록 랜더링
            document.getElementById("suggestion_box").style.display = "block";

          }
        }
        
      }
      
    });       // Ajax 응답을 정상적으로 받으면 실행됨.


  })

});



