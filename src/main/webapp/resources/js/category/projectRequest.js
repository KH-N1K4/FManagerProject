$(document).ready(function(){
  const suvMenuSelect = location.pathname.split('/')[4];
  if(suvMenuSelect != 0){
    document.getElementById('sub'+suvMenuSelect+'Box').classList.toggle('subMenu');
  }
})

$('.detailMenu').click(function(){
  console.log(document.getElementById('sub'+this.title+'Box'));
  console.log('sub'+this.title+'Box');
  document.getElementById('sub'+this.title+'Box').classList.toggle('subMenu');
});
const imageContent = document.getElementById('imageContent');
const pagination = document.getElementsByClassName('pagination')[0];
const paginationArea = document.getElementsByClassName('pagination-area')[0];

//location.pathname.split('/')[4];

$("#listOrder").change(function(){

  const listOrder= $("#listOrder").val();
  const budgetVar =  $("#budget").val();
  $.ajax({
      
    url: "/listOrderSelect",
    data: { 
      "listOrder"  : listOrder,
      "budget"  : budgetVar,
      "mainCategoryNo"  : mainCategoryNo,
      "subCategoryNo"  : subCategoryNo,
      "thirdCategoryNo"  : thirdCategoryNo
    },
    type: "POST", 
    dataType: "JSON", // 응답 데이터의 형식이 JSON이다. -> 자동으로 JS 객체로 변환
    success: (result) => {
        console.log(result.resultList);
        console.log(result.pagination);

        const locationVar =  location.pathname;
        history.pushState(null, null, "http://localhost/projectRequest/requestList/0/0/0?cp=1&listOrder="+listOrder+"&budget="+budgetVar+"");

        console.log(locationVar);
          $('.box').remove();
          for (let item of result.resultList) {
            const div = document.createElement("div"); //맨 처음 부모
            div.classList.add("box"); 
            imageContent.append(div);

            const div2 = document.createElement("div"); //두번째 image
            div2.setAttribute("id","image"); 
            div.append(div2); // div2 => div랑 a태그 자식으로
            
            const div3 = document.createElement("div"); //2번째 자식 img태그 들어가는 곳
            const img = document.createElement("img"); //2번째 자식 div에 img태그
            img.setAttribute("src",item.projectRequestfile);
            div3.append(img);
            div2.append(div3);

            const a = document.createElement("a"); //2번째 자식(두번째로 들어감) 
            a.setAttribute("href","/projectRequest/projectRequestDetail/"+item.projectRequestNo);
            a.classList.add("imageTitle"); 
            const div4 = document.createElement("div"); //a태그에 들어가는 div
            div4.classList.add("projectRequestTitle"); 
            div4.innerText = item.projectRequestTitle;
            const span = document.createElement("span"); //a태그에 들어가는 span
            span.classList.add("imageOthers"); 
            span.innerText= item.projectRequestSummary;
            const span2 = document.createElement("span"); //a태그에 들어가는 span
            span2.classList.add("imageOthers"); 
            span2.innerText = "예산: "+item.projectRequestBudgetString+"원";
            a.append(div4);
            a.append(span);
            a.append(span2);
            div2.append(a);
        }

        paginationArea.innerHTML='';
        if(result.listCount != 0){
          console.log('fff');
          const ul  = document.createElement("ul");
          ul.classList.add("pagination");
          paginationArea.append(ul);
          const li = document.createElement("li");
          const a = document.createElement("a");
          a.setAttribute("href",locationVar+"?cp=1"+"&listOrder="+listOrder+"&budget="+budgetVar);
          a.innerText="<<";
          ul.append(li);
          li.append(a);

          const li2 = document.createElement("li");
          const a2 = document.createElement("a");
          a2.setAttribute("href",locationVar+"?cp="+result.pagination.prevPage+"&listOrder="+listOrder+"&budget="+budgetVar);
          a2.innerText="<";
          ul.append(li2);
          li2.append(a2);
          
          for (let i = result.pagination.startPage; i <= result.pagination.endPage; i++){
            if(i == result.pagination.startPage){
              const li3 = document.createElement("li");
              const a3 = document.createElement("a");
              a3.classList.add("current");
              a3.innerText="1";
              ul.append(li3);
              li3.append(a3);
            }else{
              const li4 = document.createElement("li");
              const a4 = document.createElement("a");
              a4.setAttribute("href",locationVar+"?cp="+i+"&listOrder="+listOrder+"&budget="+budgetVar);
              a4.innerText=i;
              ul.append(li4);
              li4.append(a4);
            }

          }

          const li5 = document.createElement("li");
          const a5 = document.createElement("a");
          a5.setAttribute("href",locationVar+"?cp="+result.pagination.nextPage+"&listOrder="+listOrder+"&budget="+budgetVar);
          a5.innerText=">";
          ul.append(li5);
          li5.append(a5);

          const li6 = document.createElement("li");
          const a6 = document.createElement("a");
          a6.setAttribute("href",locationVar+"?cp="+result.pagination.maxPage+"&listOrder="+listOrder+"&budget="+budgetVar);
          a6.innerText=">>";
          ul.append(li6);
          li6.append(a6);

        }


    },
    error: () => {
        console.log("선택 에러")
    }


  });

});


$("#budget").change(function(){
  const listOrder= $("#listOrder").val();
  const budgetVar =  $("#budget").val();
  $.ajax({
      
    url: "/listOrderSelect",
    data: { 
      "listOrder"  : listOrder,
      "budget"  : budgetVar,
      "mainCategoryNo"  : mainCategoryNo,
      "subCategoryNo"  : subCategoryNo,
      "thirdCategoryNo"  : thirdCategoryNo
    },
    type: "POST", 
    dataType: "JSON", // 응답 데이터의 형식이 JSON이다. -> 자동으로 JS 객체로 변환
    success: (result) => {
        console.log(result.resultList);
        console.log(result.pagination);
        console.log(budgetVar);

        const locationVar =  location.pathname;
        history.pushState(null, null, "http://localhost/projectRequest/requestList/0/0/0?cp=1&listOrder="+listOrder+"&budget="+budgetVar+"");

        console.log(locationVar);
          $('.box').remove();
          for (let item of result.resultList) {
            const div = document.createElement("div"); //맨 처음 부모
            div.classList.add("box"); 
            imageContent.append(div);

            const div2 = document.createElement("div"); //두번째 image
            div2.setAttribute("id","image"); 
            div.append(div2); // div2 => div랑 a태그 자식으로
            
            const div3 = document.createElement("div"); //2번째 자식 img태그 들어가는 곳
            const img = document.createElement("img"); //2번째 자식 div에 img태그
            img.setAttribute("src",item.projectRequestfile);
            div3.append(img);
            div2.append(div3);

            const a = document.createElement("a"); //2번째 자식(두번째로 들어감) 
            a.setAttribute("href","/projectRequest/projectRequestDetail/"+item.projectRequestNo);
            a.classList.add("imageTitle"); 
            const div4 = document.createElement("div"); //a태그에 들어가는 div
            div4.classList.add("projectRequestTitle"); 
            div4.innerText = item.projectRequestTitle;
            const span = document.createElement("span"); //a태그에 들어가는 span
            span.classList.add("imageOthers"); 
            span.innerText= item.projectRequestSummary;
            const span2 = document.createElement("span"); //a태그에 들어가는 span
            span2.classList.add("imageOthers"); 
            span2.innerText = "가격: "+item.projectRequestBudgetString+"원";
            a.append(div4);
            a.append(span);
            a.append(span2);
            div2.append(a);
        }

        paginationArea.innerHTML='';
        if(result.listCount != 0){
          console.log('fff');
          const ul  = document.createElement("ul");
          ul.classList.add("pagination");
          paginationArea.append(ul);
          const li = document.createElement("li");
          const a = document.createElement("a");
          a.setAttribute("href",locationVar+"?cp=1"+"&listOrder="+listOrder+"&budget="+budgetVar);
          a.innerText="<<";
          ul.append(li);
          li.append(a);

          const li2 = document.createElement("li");
          const a2 = document.createElement("a");
          a2.setAttribute("href",locationVar+"?cp="+result.pagination.prevPage+"&listOrder="+listOrder+"&budget="+budgetVar);
          a2.innerText="<";
          ul.append(li2);
          li2.append(a2);
          
          for (let i = result.pagination.startPage; i <= result.pagination.endPage; i++){
            if(i == result.pagination.startPage){
              const li3 = document.createElement("li");
              const a3 = document.createElement("a");
              a3.classList.add("current");
              a3.innerText="1";
              ul.append(li3);
              li3.append(a3);
            }else{
              const li4 = document.createElement("li");
              const a4 = document.createElement("a");
              a4.setAttribute("href",locationVar+"?cp="+i+"&listOrder="+listOrder+"&budget="+budgetVar);
              a4.innerText=i;
              ul.append(li4);
              li4.append(a4);
            }

          }

          const li5 = document.createElement("li");
          const a5 = document.createElement("a");
          a5.setAttribute("href",locationVar+"?cp="+result.pagination.nextPage+"&listOrder="+listOrder+"&budget="+budgetVar);
          a5.innerText=">";
          ul.append(li5);
          li5.append(a5);

          const li6 = document.createElement("li");
          const a6 = document.createElement("a");
          a6.setAttribute("href",locationVar+"?cp="+result.pagination.maxPage+"&listOrder="+listOrder+"&budget="+budgetVar);
          a6.innerText=">>";
          ul.append(li6);
          li6.append(a6);

        }


    },
    error: () => {
        console.log("선택 에러")
    }


  });

});