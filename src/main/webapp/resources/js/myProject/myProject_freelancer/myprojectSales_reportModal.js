const Submit = document.getElementById("ajaxReview");
Submit.addEventListener("click", (e) => {
  
    var tradeNo = document.getElementById('tradeNo').value;
    var reportPersonNo =loginMemberNo;
    var reportedPersonNo;
    var reportContent = document.getElementById('reportContent').value;
    console.log(tradeNo);
    console.log(reportedPersonNo);
    console.log(reportContent);
    saleslistJSON.forEach(function(arg,i){
      if(arg.tradeNo == tradeNo){
        reportedPersonNo = arg.memberNo;
      } 
    });
    console.log(reportPersonNo);


    /* var form = $('#reportFilePath')[0];
    var formData = new FormData(form); */
    let formData = new FormData();
    formData.append("reportFile",$("#reportFilePath")[0].files[0]);
    formData.append("tradeNoIN",tradeNo);
    formData.append("reportPersonNoIN",reportPersonNo);
    formData.append("reportedPersonNoIN",reportedPersonNo);
    formData.append("reportContentIN",reportContent);

    $.ajax({
        
        url: "/reportSubmit",
        data : formData,
        type: "POST", 
        processData : false,
        contentType: false,
        cache: false,
        dataType: "JSON", // 응답 데이터의 형식이 JSON이다. -> 자동으로 JS 객체로 변환
        success: (result) => {
            console.log(result.messageIN);
            if(result.messageIN == "신고가 접수되었습니다."){
              alert(result.messageIN);
              modal.classList.toggle('show');
              document.querySelector('.fileRemove').style.display ="none";
              document.getElementById("reportBtn"+tradeNo).style.width = '80px';
              document.getElementById("reportBtn"+tradeNo).style.backgroundColor = "white";
              document.getElementById("reportBtn"+tradeNo).firstElementChild.innerText='신고내역';
              saleslistJSON.forEach(function(arg,i){
                if(arg.tradeNo == tradeNo){       
                  arg.tradeReportNo = result.tradeReportNo;
                  arg.reportFilePath = result.reportFilePath;
                  arg.reportContent = result.reportContent;
                  document.querySelector('#ajaxReview').disabled = true;
                  $('#finishBtn'+arg.tradeNo).remove();
                  if($('#sendBtn'+arg.tradeNo) != null){
                    $('#sendBtn'+arg.tradeNo).remove();
                  }
                  //수정본이 이상하다며 욕설
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

                } 
              });
            }
        },
        error: () => {
            console.log("신고 실패")
        }


    });

});
