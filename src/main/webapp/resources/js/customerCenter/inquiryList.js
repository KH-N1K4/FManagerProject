

function selectChange() {

    // 페이징 처리 구역 
    const pagination = document.querySelector(".pagination");
    // 게시글 내용 영역
    const contentArea = document.querySelectorAll(".contentArea");
    // 진행상태 select
    const processStatus = document.getElementById("processStatusSelect");
    // 진행상태 selectBox value
    const table = document.getElementById("table");
    const optionVal = (processStatus.options[processStatus.selectedIndex].value);
    

    $.ajax({
        url: '/member/statusType',
        type: 'GET',
        data: { 'optionVal': optionVal },
        success: (map) => {
            if (map != null) {

                // selectBox가 체크가 되었을 때
                const options = processStatus.childNodes;
                for(o of options){
                    if(o.value == optionVal){
                        o.setAttribute("selected", true);
                    }
                }
                // 기존의 테이블 지워주기
                for (b of contentArea) {
                    console.log(b);
                    b.remove();
                }
                //완료!!
                if(document.querySelector('.pagination')!=null){

                    document.querySelector('.pagination').innerHTML = "";

                } 
                
                let i = 1;
                if(map.inquiryList.length != 0){ // 게시글이 존재할 때
                    for (userInquiry of map.inquiryList) {
                            const tr = document.createElement("tr");
                            tr.setAttribute("class","contentArea");
                            table.append(tr);

                            const td1 = document.createElement("td");
                            td1.innerText = i++;
                            tr.append(td1);

                            const td2 = document.createElement("td");
                            const a = document.createElement("a");
                            a.setAttribute('href', "/userInquiryDetail/"+ userInquiry.userInquiryNo + "?cp="+map.pagination.currentPage+ "&optionVal="+map.optionVal);
                            a.innerText = userInquiry.userInquiryTitle;
                            td2.append(a);
                            tr.append(td2);

                            const td3 = document.createElement("td");
                            td3.innerText = userInquiry.userInquiryCreateDate;
                            tr.append(td3);

                        if(userInquiry.inquiryRequest == null){  // 답변이 없을 때

                            const td4 = document.createElement("td");
                            const span = document.createElement("span");
                            td4.append(span);
                            span.setAttribute("class","question-wating");
                            span.innerText = '답변 대기';
                            tr.append(td4);

                        } else{ // 답변이 있을 때

                            const td4 = document.createElement("td");
                            const span = document.createElement("span");
                            td4.append(span);
                            span.setAttribute("class","question-answer");
                            span.innerText = '답변 완료';
                            tr.append(td4);
                        }
                        
                    }

                    // 페이징
                    const li1 = document.createElement("li");
                    const a1 = document.createElement("a");
                    a1.setAttribute('href', "/userInquiryList?cp=1"+ "&optionVal="+ map.optionVal);
                    a1.appendChild(document.createTextNode("<<"));
                    li1.append(a1);
                    pagination.append(li1);

                    

                    const li2 = document.createElement("li");
                    const a2 = document.createElement("a");
                    a2.setAttribute("href", "/userInquiryList?cp="+ map.pagination.prevPage+"&optionVal="+map.optionVal);
                    a2.appendChild(document.createTextNode("<"));
                    li2.append(a2);
                    pagination.append(li2);

                    console.log("startPage"+map.pagination.startPage);
                    console.log("endPage"+map.pagination.endPage);

                    /* 숫자가 안나와 */
                    for (i = map.pagination.startPage; i <= map.pagination.endPage; i++) {
                        const li3 = document.createElement("li");
                        if (i == map.pagination.currentPage) {
                            const a3 = document.createElement("a");
                            a3.classList.add("current");
                            a3.appendChild(document.createTextNode(i));
                            li3.append(a3);
                            pagination.append(li3);

                        } else {
                            const a3 = document.createElement("a");
                            a3.setAttribute("href", "/userInquiryList?cp=" + i + "&optionVal="+map.optionVal);
                            a3.appendChild(document.createTextNode(i));
                            li3.append(a3);
                            pagination.append(li3);
                        }
                    }

                    const li4 = document.createElement("li");
                    const a4 = document.createElement("a");
                    a4.setAttribute("href", "/userInquiryList?cp=" + "&optionVal="+map.optionVal);
                    a4.appendChild(document.createTextNode(">"));
                    li4.append(a4);
                    pagination.append(li4);

                    const li5 = document.createElement("li");
                    const a5 = document.createElement("a");
                    a5.setAttribute("href", "/userInquiryList?cp=" + "&optionVal="+map.optionVal);
                    a5.appendChild(document.createTextNode(">>"));
                    li5.append(a5);
                    pagination.append(li5);
                    
                } else{
                    const tr = document.createElement("tr");
                    tr.setAttribute("class","contentArea");
                    table.append(tr);

                    const td = document.createElement("td");
                    td.setAttribute("colspan","6");
                    td.innerText = '게시글이 존재하지 않습니다.';
                    tr.append(td);
                    
                }



            }

        }


    })
        
}


