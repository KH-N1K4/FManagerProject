const keyword = document.querySelector("#search-input");
const keywords = document.querySelector("#suggestion_box");

function closeKeywords() {
  keywords.style.display = "none"
  keywords.innerHTML = ""
}

//$(function() {   // <input>요소에 문자가 입력될 때마다 호출됨.

  $("#search-input").keyup(function(e) {
    
    if(e.key === "Escape") {
      closeKeywords()
    }

    if ($(this).val().trim() == "")
		{
			document.getElementById("suggestion_box").style.display="none";
			return;
		}

    if(e.keyCode==13){
      document.forms["SearchfrmMain"].submit();
    }

    const selectedKeyword = keywords.querySelector("div.selected");
    if((e.key === "ArrowUp" || e.key === "ArrowDown") && keywords.style.display === "block") {
      let target
      const keywordsList = keywords.querySelectorAll("div");
      const initIndex = e.key === "ArrowUp" ? keywordsList.length - 1 : 0
      const adjacentSibling = selectedKeyword && (e.key === "ArrowUp" ? selectedKeyword.previousElementSibling : selectedKeyword.nextElementSibling)
      
      if(adjacentSibling) {
          target = adjacentSibling
      } else {
          target = keywordsList.item(initIndex)
      } 
      selectedKeyword && selectedKeyword.classList.remove("selected")
      target.classList.add("selected")
      keyword.value = target.firstElementChild.textContent
      
    }
    
    if(e.key !== "ArrowUp" && e.key !== "ArrowDown"){
        $.ajax({ // Ajax 요청을 작성하고 GET 방식으로 전송함.

          url: "/common/searchInput",
    
          data: { 
            "keyword" : $(this).val().trim(),
          },
    
          method: "GET", 
          dataType: "JSON", // 응답 데이터의 형식이 JSON이다. -> 자동으로 JS 객체로 변환
          success: (result) => {
            document.getElementById("suggestion_box").innerHTML='';
            var Category;
            console.log('kkkk');
            if(result.length > 0){
              for(let i=0; result.length>i;i++){
                console.log(result[i]);
                Category =result[i].mainCategoryName +" > "+result[i].subCategoryName;
    
                document.getElementById("suggestion_box").innerHTML
                += "<div class='Category'>" + Category +"&nbsp;&nbsp;"+ "<strong class='serviceTitleVar'>"+result[i].serviceTitle +"</strong>"+ "</div>";
    
                // 최종적으로 목록을 화면에 보일 수 있도록 랜더링
                document.getElementById("suggestion_box").style.display = "block";
    
              }
    
            }

            
          }
          
        });       // Ajax 응답을 정상적으로 받으면 실행됨.
      

    }

    

  
  });

//});


document.addEventListener("click", e => {
  // 요구사항 3 - 마우스로 다른 곳을 클릭하여 input이 focus를 잃어버리는 경우 추천 검색어 창이 닫여야 합니다.
  const closestKeywords = e.target.closest(".keywords") // 부모 요소 중에 keywords 클래스를 가진 부모가 있는지 확인
  if(!closestKeywords && keywords.style.display === "block") {
      closeKeywords()
  }
})
keywords.addEventListener("click", e => {
  // 요구사항 4 - 마우스로 추천 검색어를 누르면 커서가 위치한 검색어가 입력창에 반영되어야 합니다.
  console.log(e.target);
  if(e.target.firstElementChild != null){
    keyword.value = e.target.firstElementChild.textContent;
  }else{
    keyword.value = e.target.textContent;
  }
  // 

  
})


document.getElementById('searchButton').addEventListener('click', () => {


  document.forms["SearchfrmMain"].submit();
});

