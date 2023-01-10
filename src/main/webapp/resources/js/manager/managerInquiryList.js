
function selectChange() {

    // 페이징 처리 구역 
    const pagination = document.querySelector(".pagination");
    // 게시글 내용 영역
    const contentArea = document.querySelectorAll(".question-list-table-content");
    // 진행상태 select
    const processStatus = document.getElementById("processStatus");
    // 진행상태 selectBox value
    const optionVal = (processStatus.options[processStatus.selectedIndex].value);

    const table = document.getElementById("question-list-table");

    $.ajax({
        url: '/manager/statusType',
        type: 'GET',
        data: { 'optionVal': optionVal },
        success: (map) => {
            if (map != null) {

                // selectBox가 체크가 되었을 때
                const options = processStatus.childNodes;
                for (o of options) {
                    if (o.value == optionVal) {
                        o.setAttribute("selected", true);
                    }
                }
                // 기존의 테이블 지워주기
                for (b of contentArea) {
                    console.log(b);
                    b.remove();
                }

                //게시물 없을 때 게시글 존재하지 않습니다 지우기
                if(document.getElementsByClassName("contentList")[0] != null){
                    document.getElementsByClassName("contentList")[0].remove();
                }
                

                //완료!!
                if (document.querySelector('.pagination') != null) {

                    document.querySelector('.pagination').innerHTML = "";

                }

                if (map.managerInquiryList.length != 0) { // 게시글이 존재할 때
                
                    console.log('아????')    
                    console.log(map.managerInquiryList)
                    console.log(map.managerInquiryList.length)
                    for (managerInquiry of map.managerInquiryList) {

                        const div = document.createElement("div");
                        div.setAttribute("class", "question-list-table-content");
                        table.append(div);

                        const child1 = document.createElement("div");
                        child1.setAttribute("class", "question-num");
                        child1.innerText = managerInquiry.userInquiryNo;
                        div.append(child1);

                        const child2 = document.createElement("div");
                        child2.setAttribute("class", "question-title");
                        const a = document.createElement("a");
                        a.setAttribute('href', "/managerInquiryDetail/" + managerInquiry.userInquiryNo + "?cp=" + map.pagination.currentPage + "&optionVal=" + optionVal);
                        a.innerText = managerInquiry.userInquiryTitle;
                        child2.append(a);
                        div.append(child2);

                        const child3 = document.createElement("div");
                        child3.setAttribute("class", "question-date");
                        child3.innerText = managerInquiry.userInquiryCreateDate;
                        div.append(child3);


                        if (managerInquiry.inquiryRequest == null) {  // 답변이 없을 때

                            const child4 = document.createElement("div");
                            child4.setAttribute("class", "question-status");
                            const span = document.createElement("span");
                            span.setAttribute("class", "question-wating");
                            span.innerText = '답변 대기';
                            child4.append(span);
                            div.append(child4);

                        } else { // 답변이 있을 때

                            const child4 = document.createElement("div");
                            child4.setAttribute("class", "question-status");
                            const span = document.createElement("span");
                            span.setAttribute("class", "question-answer");
                            span.innerText = '답변 완료';
                            child4.append(span);
                            div.append(child4);
                        }

                    }

                        // 페이징
                        const li1 = document.createElement("li");
                        const a1 = document.createElement("a");
                        a1.setAttribute('href', "/manager/managerInquiryList?cp=1" + "&optionVal=" + optionVal);
                        a1.appendChild(document.createTextNode("<<"));
                        li1.append(a1);
                        pagination.append(li1);


                        const li2 = document.createElement("li");
                        const a2 = document.createElement("a");
                        a2.setAttribute("href", "/manager/managerInquiryList?cp=" + map.pagination.prevPage + "&optionVal=" + optionVal);
                        a2.appendChild(document.createTextNode("<"));
                        li2.append(a2);
                        pagination.append(li2);

                        console.log("startPage" + map.pagination.startPage);
                        console.log("endPage" + map.pagination.endPage);

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
                                a3.setAttribute("href", "/manager/managerInquiryList?cp=" + i + "&optionVal=" + optionVal);
                                a3.appendChild(document.createTextNode(i));
                                li3.append(a3);
                                pagination.append(li3);
                            }
                        }

                        const li4 = document.createElement("li");
                        const a4 = document.createElement("a");
                        a4.setAttribute("href", "/manager/managerInquiryList?cp=" +map.pagination.nextPage+ "&optionVal=" + optionVal);
                        a4.appendChild(document.createTextNode(">"));
                        li4.append(a4);
                        pagination.append(li4);

                        const li5 = document.createElement("li");
                        const a5 = document.createElement("a");
                        a5.setAttribute("href", "/manager/managerInquiryList?cp=" +map.pagination.maxPage+ "&optionVal=" + optionVal);
                        a5.appendChild(document.createTextNode(">>"));
                        li5.append(a5);
                        pagination.append(li5);

                    } else { // 게시글이 없을 때
                    
                        const div = document.createElement("div");
                        div.setAttribute("class", "contentList");
                        div.innerText = '게시글이 존재하지 않습니다.';
                        table.append(div);
                    }

            }    


        }    

    })



}