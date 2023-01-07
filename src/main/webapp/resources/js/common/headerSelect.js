$(function() {   // <input>요소에 문자가 입력될 때마다 호출됨.

  $("#search-input").keyup(function() {

    if ($(this).val().replace(" ","") == "")
		{
			document.getElementById("suggestion_box").style.display="none";
			return;
		}
    
    $.ajax({ // Ajax 요청을 작성하고 GET 방식으로 전송함.

      url: "/common/searchInput",

      data: { "keyword" : $(this).val().trim() },

      method: "GET"

    })       // Ajax 응답을 정상적으로 받으면 실행됨.

    .done(function(result) {

      //$("#suggestion_box").html(result);

    })

  })

});