
const goToListbtn = document.getElementById("goToListbtn");

goToListbtn.addEventListener("click",() => {

        const queryString = location.search;
        const url = "/manager/managerInquiryList" + queryString;

        location.href = url;

});


document.getElementById("commentBtn").addEventListener("click",()=>{
        const inputComment = document.getElementById("inputComment").value;
        const comment = document.getElementById("comment");

        $.ajax({

                url : '/managerInquiryDetail',
                type : 'POST',
                data : { 'inputComment': inputComment,
                        'userInquiryNo': userInquiryNo},
                success : (result) => {

                        if(result != null) {
                                
                                document.getElementById("commentInput").remove();
                                const table = document.createElement("table");
                                const tr = document.createElement("tr");
                                const th = document.createElement("th");
                                th.setAttribute("class","writer");
                                th.innerText = '작성자'; 
                                const td = document.createElement("td");
                                td.setAttribute("class","writerContent");
                                td.innerText = memberName;
                                comment.append(table);
                                table.append(tr);
                                tr.append(th);
                                tr.append(td);

                                const tr2 = document.createElement("tr");
                                const th2 = document.createElement("th");
                                th2.innerText = '답변 내용';
                                const td2 = document.createElement("td");
                                td2.innerText = inputComment;
                                table.append(tr2);
                                tr2.append(th2);
                                tr2.append(td2);

                                const tableHead = document.getElementById("tableHead"); 
                                document.getElementById("requestStatusView").remove();
                                const th3 = document.createElement("th");
                                const span = document.createElement("span");
                                span.innerText ="답변 완료";
                                tableHead.append(th3);
                                th3.append(span);
                                th3.setAttribute("id","requestStatusView");
                                span.setAttribute("class","question-answer");


                        /*  <table>
                                <tr>
                                        <th style="width:150px">작성자</th>
                                        <%-- 로그인 세션에서 값 얻어오기 --%>
                                        <td style="width:850px">${loginMember.memberName}</td>
                                </tr>
                                <tr>
                                        <th>답변 내용</th>
                                        <td class="textArea">${managerInquiry.inquiryRequest}</td>
                                </tr>
                        </table> */
                        }                        
                },
                error: ()=>{
                        console.log("댓글 등록이 실패");
                }


        })





});



