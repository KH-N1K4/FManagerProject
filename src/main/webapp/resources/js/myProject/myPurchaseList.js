
reportModal();
reviewModal();



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
  

  
  
  $('.noSalesSevice').click(function(){
  
    alert('판매 중인 서비스가 아닙니다.');
  
  });


/* 완료버튼 */
const finishBtn = document.querySelectorAll(".finishBtn");
const selectType = document.getElementById("selectType");
const type = (selectType.options[selectType.selectedIndex].value);
const searchDate1 = document.getElementById("searchDate1");
const searchDate2 = document.getElementById("searchDate2");
const searchInput = document.getElementById("searchInput");
const selecttbody = document.getElementById("selecttbody");
const pagination = document.querySelector(".pagination");

for(f of finishBtn){
  f.addEventListener("click",e=>{
    
    if(confirm('작업을 완료하시겠습니까?')){
      
      const tradeNo = e.target.id;
  
      $.ajax({
        url:'/member/myProject/memberDone',
        data: {'tradeNo':tradeNo},
        success: (resultMap)=>{
          if(resultMap!=null){
            
            const options = selectType.childNodes;
            for(o of options) {
              if(o.value=resultMap.type){
                o.setAttribute("selected", true);
              }
            }

            searchDate1.value=resultMap.searchDate1;
            searchDate2.value=resultMap.searchDate2;
            searchInput.value=resultMap.searchInput;

            selecttbody.innerHTML="";

            if(document.querySelector('.pagination')!=null){

              document.querySelector('.pagination').innerHTML = "";
            } 

            if(resultMap.purchaseList.length==0){
              const tr = document.createElement("tr");
              tr.classList.add("suggestionTable");
              const td = document.createElement("td");
              td.setAttribute("colspan",6);
              td.setAttribute("style","text-align:center;");
              td.append(document.createTextNode(" 구매한 서비스가 없습니다. "));
              tr.append(td);
              selecttbody.append(tr);
            } else{

              var i = 0;

              for(purchase of resultMap.purchaseList){

                const tr = document.createElement("tr");
                tr.classList.add("suggestionTable");

                const td1 = document.createElement("td");
                td1.classList.add("tc");
                const span1 = document.createElement("span");
                span1.classList.add("num");
                i=i+1;
                span1.append(document.createTextNode(i));
                td1.append(span1);
                tr.append(td1);

                const td2 = document.createElement("td");
                td2.classList.add("tl");  
                const div2 = document.createElement("div");
                div2.classList.add("suggestion_name_area");
                div2.classList.add("td_link");

                if(purchase.seviceDeleteFlag=='N' && purchase.serviceStatus == 2){
                  
                  const a1 = document.createElement("a");
                  a1.setAttribute("href", "/category/"+purchase.mainCategoryNo+"/"+purchase.subCategoryNo+"/"+purchase.thirdCategoryNo+"/"+purchase.serviceNo);
                  a1.setAttribute("id", "serviceName");
                  a1.classList.add("serviceName");
                  a1.classList.add("serviceNameAtag");
                  a1.setAttribute("target","_blank");
                  a1.append(document.createTextNode(purchase.serviceTitle));
                  div2.append(a1);

                } else{
                  const span2 = document.createElement("span");
                  span2.setAttribute("id", "serviceName");
                  span2.classList.add("serviceName");
                  span2.classList.add("noSalesSevice");
                  span2.append(document.createTextNode(purchase.serviceTitle));
                  div2.append(span2);
                }

                td2.append(div2);
                tr.append(td2);

                const td3 = document.createElement("td");
                td3.classList.add("tc");  
                const div3 = document.createElement("div");
                div3.classList.add("expert_name_area");
                div3.classList.add("td_link");
                const a3 = document.createElement("a");
                a3.setAttribute("id","expertName");
                a3.classList.add("expertName");
                a3.append(document.createTextNode(purchase.freelancerName));
                div3.append(a3);
                td3.append(div3);
                tr.append(td3);
                
                const td4 = document.createElement("td");
                td4.classList.add("tc");
                const span4 = document.createElement("span");
                span4.classList.add("num");
                if(purchase.workCount>purchase.serviceEditNum){
                  span4.append(document.createTextNode(purchase.serviceEditNum+"/"+purchase.serviceEditNum));
                } else {
                  span4.append(document.createTextNode(purchase.workCount+"/"+purchase.serviceEditNum));
                }
                td4.append(span4);
                tr.append(td4);

                const td5 = document.createElement("td");
                td5.classList.add("tc");
                const span5 = document.createElement("span");
                span5.classList.add("text");
                span5.append(document.createTextNode(purchase.workProgress));
                td5.append(span5);
                tr.append(td5);

                const td6 = document.createElement("td");
                td6.classList.add("tc");

                const reportBtn = document.createElement("a");
                reportBtn.setAttribute("id","reportBtn");
                reportBtn.classList.add("reportBtn");
                reportBtn.classList.add("btn_type");
                reportBtn.append(document.createTextNode("신고"));

                const finishBtn = document.createElement("a");
                finishBtn.setAttribute("id",purchase.tradeNo);
                finishBtn.classList.add("finishBtn");
                finishBtn.classList.add("btn_type");
                finishBtn.append(document.createTextNode("완료"));

                const reviewCreateBtn = document.createElement("a");
                reviewCreateBtn.setAttribute("id","reviewCreateBtn");
                reviewCreateBtn.classList.add("reviewCreateBtn");
                reviewCreateBtn.append(document.createTextNode("리뷰하기"));

                if(purchase.workCount==0){
                  td6.append(reportBtn);
                } else if(purchase.workCount>=1 && purchase.memberDoneFL==1 && purchase.workStatus!=3){
                  td6.append(finishBtn);
                  td6.append(document.createTextNode(" "));
                  td6.append(reportBtn);
                } else if(purchase.workStatus==4){
                  td6.append(reviewCreateBtn);
                }
                tr.append(td6);

                const tradeNo = document.createElement("input");
                tradeNo.setAttribute("type","hidden");
                tradeNo.setAttribute("id","hiddenTradeNo");
                tradeNo.setAttribute("value",purchase.tradeNo);
                tr.append(tradeNo);

                const memberName = document.createElement("input");
                memberName.setAttribute("type","hidden");
                memberName.setAttribute("id","hiddenMemberName");
                memberName.setAttribute("value",purchase.memberName);
                tr.append(memberName);

                const memberNo = document.createElement("input");
                memberNo.setAttribute("type","hidden");
                memberNo.setAttribute("id","hiddenMemberNo");
                memberNo.setAttribute("value",purchase.memberNo);
                tr.append(memberNo);

                const tradeReportNo = document.createElement("input");
                tradeReportNo.setAttribute("type","hidden");
                tradeReportNo.setAttribute("id","hiddenTradeReportNo");
                tradeReportNo.setAttribute("value",purchase.tradeReportNo);
                tr.append(tradeReportNo);

                const filePath = document.createElement("input");
                filePath.setAttribute("type","hidden");
                filePath.setAttribute("id","hiddenFilePath");
                filePath.setAttribute("value",purchase.filePath);
                tr.append(filePath);

                const tradeReportTypeName = document.createElement("input");
                tradeReportTypeName.setAttribute("type","hidden");
                tradeReportTypeName.setAttribute("id","hiddenTradeReportTypeName");
                tradeReportTypeName.setAttribute("value",purchase.tradeReportTypeName);
                tr.append(tradeReportTypeName);

                const reportContent = document.createElement("input");
                reportContent.setAttribute("type","hidden");
                reportContent.setAttribute("id","hiddenReportContent");
                reportContent.setAttribute("value",purchase.tradeReportTypeName);
                tr.append(reportContent);

                selecttbody.append(tr);

              }

              reportModal();
              reviewModal();

              /* 페이징 */
              const li1 = document.createElement("li");
              const a1 = document.createElement("a");
              a1.setAttribute('href', "/member/myProject/myPurchaseList?cp=1" + "&type=" + type+ "&searchDate1=" + searchDate1+ "&searchDate2=" + searchDate2+ "&searchInput=" + searchInput);
              a1.appendChild(document.createTextNode("<<"));
              li1.append(a1);
              pagination.append(li1);

              const li2 = document.createElement("li");
              const a2 = document.createElement("a");
              a2.setAttribute("href", "/member/myProject/myPurchaseList?cp=" + resultMap.pagination.prevPage + "&type=" + type+ "&searchDate1=" + searchDate1+ "&searchDate2=" + searchDate2+ "&searchInput=" + searchInput);
              a2.appendChild(document.createTextNode("<"));
              li2.append(a2);
              pagination.append(li2);

              /* 숫자가 안나와 */
              for (i = resultMap.pagination.startPage; i <= resultMap.pagination.endPage; i++) {
                  const li3 = document.createElement("li");
                  if (i == resultMap.pagination.currentPage) {
                      const a3 = document.createElement("a");
                      a3.classList.add("current");
                      a3.appendChild(document.createTextNode(i));
                      li3.append(a3);
                      pagination.append(li3);

                  } else {
                      const a3 = document.createElement("a");
                      a3.setAttribute("href", "/member/myProject/myPurchaseList?cp=" + i + "&type=" + type+ "&searchDate1=" + searchDate1+ "&searchDate2=" + searchDate2+ "&searchInput=" + searchInput);
                      a3.appendChild(document.createTextNode(i));
                      li3.append(a3);
                      pagination.append(li3);
                  }
              }

              const li4 = document.createElement("li");
              const a4 = document.createElement("a");
              a4.setAttribute("href", "/member/myProject/myPurchaseList?cp=" + resultMap.pagination.nextPage + "&type=" + type+ "&searchDate1=" + searchDate1+ "&searchDate2=" + searchDate2+ "&searchInput=" + searchInput);
              a4.appendChild(document.createTextNode(">"));
              li4.append(a4);
              pagination.append(li4);

              const li5 = document.createElement("li");
              const a5 = document.createElement("a");
              a5.setAttribute("href", "/member/myProject/myPurchaseList?cp=" + resultMap.pagination.maxPage + "&type=" + type+ "&searchDate1=" + searchDate1+ "&searchDate2=" + searchDate2+ "&searchInput=" + searchInput);
              a5.appendChild(document.createTextNode(">>"));
              li5.append(a5);
              pagination.append(li5);

            }

          }
  
        }
  
      });

    }

  });
}

/* 신고 모달 */
function reportModal(){
  const reportBtn = document.querySelectorAll('.reportBtn');
  const body = document.querySelector('#mainBody');
  const reportModal = document.querySelector('.report-modal');
  const reportModalClose = document.querySelector(".reportModal_close");

  for(r of reportBtn){
    
    r.addEventListener("click",e=>{

      reportModal.classList.toggle("show"); 
      if (reportModal.classList.contains('show')) {
        body.style.overflow = 'hidden';
      }

      document.getElementById("serviceTitle").value= e.target.parentElement.previousElementSibling.previousElementSibling.previousElementSibling.previousElementSibling.children[0].children[0].innerText;
      document.getElementById("tradeNo").value=e.target.parentElement.nextElementSibling.value;
      document.getElementById("memberName").value=e.target.parentElement.nextElementSibling.nextElementSibling.value;
      document.getElementById("memberNo").value=e.target.parentElement.nextElementSibling.nextElementSibling.nextElementSibling.value;
      document.getElementById("reportContent").setAttribute("readonly", false);

      if(document.querySelector(".fileRemove").classList.contains("none")){
        document.querySelector(".fileRemove").classList.remove("none");
      }
      
      document.getElementById("reportContent").value="";
      document.getElementById('reportFilePath1').value='';
      
      if(!document.querySelector(".ajaxReview").classList.contains("show")){
        document.querySelector(".ajaxReview").classList.add("show");
      }

      const div = document.createElement("div");
      div.classList.add("list_content"); 
      div.classList.add("fileaddDiv"); 
      const a = document.createElement("a");
      const fileadd= document.getElementById("fileadd");

      fileadd.innerHTML="";
      
      if(e.target.parentElement.nextElementSibling.nextElementSibling.nextElementSibling.nextElementSibling.value!=0){
        
        document.getElementById("selectType").value=e.target.parentElement.nextElementSibling.nextElementSibling.nextElementSibling.nextElementSibling.nextElementSibling.nextElementSibling.value;
        document.getElementById("reportContent").value=e.target.parentElement.nextElementSibling.nextElementSibling.nextElementSibling.nextElementSibling.nextElementSibling.nextElementSibling.nextElementSibling.value;
        document.getElementById("reportContent").setAttribute("readonly", true);
        const src = e.target.parentElement.nextElementSibling.nextElementSibling.nextElementSibling.nextElementSibling.nextElementSibling.value;
        a.setAttribute("href", src);
        a.setAttribute("target", "_blank");//target="_blank"
        a.style.textDecoration ="none";
        a.style.color ="black";
        a.style.fontSize ="12px";
        a.innerText = "업로드 파일 다운로드";

        if(document.querySelector(".ajaxReview").classList.contains("show")){
          document.querySelector(".ajaxReview").classList.remove("show");
        }

        if(src != null){
          /* document.querySelector('#reportFilePath').value = arg.reportFilePath; */
          
          fileadd.append(div);
          div.append(a);

        }


      
      }
      



      reportModalClose.addEventListener("click",()=>{
        if (reportModal.classList.contains('show')) {
          reportModal.classList.remove('show');
        }

        if (!reportModal.classList.contains('show')) {
            body.style.overflow = 'visible';
        }
      });

    });

  }

}





/* 리뷰 모달 */
function reviewModal(){
  const reviewCreateBtn = document.querySelectorAll('.reviewCreateBtn');
  const body = document.querySelector('#mainBody');
  const reviewModal = document.querySelector('.review-modal');
  const reviewModalClose = document.querySelector(".reviewModal_close");

  for(r of reviewCreateBtn){
    
    r.addEventListener("click",e=>{

      reviewModal.classList.toggle("show"); 
      if (reviewModal.classList.contains('show')) {
        body.style.overflow = 'hidden';
      }

      document.getElementById("serviceTitle3").value= e.target.parentElement.previousElementSibling.previousElementSibling.previousElementSibling.previousElementSibling.children[0].children[0].innerText;
      document.getElementById("tradeNo3").value=e.target.parentElement.nextElementSibling.value;


      reviewModalClose.addEventListener("click",()=>{
        if (reviewModal.classList.contains('show')) {
          reviewModal.classList.remove('show');

          document.getElementById("reviewContent").value="";
          document.getElementById("reviewFilePath").value="";
          document.getElementById("reviewPoint").value=1;
        }

        if (!reviewModal.classList.contains('show')) {
            body.style.overflow = 'visible';
        }
      });
    });

  }

}





/* 신고 버튼 누를 때 */
const tradeReportFrm = document.getElementById("tradeReportFrm");
tradeReportFrm.addEventListener("submit",e=>{

  if(tradeReportType.value==0){
    alert("문의 타입을 선택해주세요.");
    e.preventDefault();
  }else {
      if(!confirm('해당 거래를 신고하시겠습니까?')){
        e.preventDefault();
      }
  }
});

const reviewfrm = document.getElementById("reviewfrm");
reviewfrm.addEventListener("submit",e=>{

  if(!confirm('리뷰를 등록하시겠습니까?')){
    
    e.preventDefault();
  }

});




