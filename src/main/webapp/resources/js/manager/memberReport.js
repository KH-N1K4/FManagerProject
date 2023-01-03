
const goToListbtn = document.getElementById("goToListbtn");

goToListbtn.addEventListener("click",() => {

        const queryString = location.search;
        const url = "/manager/memberReportList" + queryString;

        location.href = url;

});


document.getElementById("commentBtn").addEventListener("click",()=>{

    const memberReportRequest = document.getElementById("inputComment").value;

    $.ajax({
        url: '/manager/memberReportRequest',
        type: 'POST',
        data: {'memberReportNo':memberReportNo,'memberReportRequest':memberReportRequest },
        success: (result)=>{
            if(result>0){
                document.getElementById("commentInput").remove();
                const comment = document.createElement("input")
                comment.setAttribute("type","test");
                comment.setAttribute("value",memberReportRequest);
                comment.classList.add("inputComment");
                comment.setAttribute("readonly","true");
                comment.setAttribute("id","memberReportRequest");

                document.getElementById("comment").append(comment);

                document.getElementById("memberReportRequest").value=memberReportRequest;

                document.querySelector(".question-wating").classList.add("question-answer");
                document.querySelector(".question-wating").classList.remove("question-wating");
                document.querySelector(".question-answer").innerText="답변 완료";
            }
        }

    });

});

