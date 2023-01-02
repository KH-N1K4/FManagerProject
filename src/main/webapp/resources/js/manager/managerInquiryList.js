/* 회원 구분 select */
function selectChange() {
    const selectStatus = document.getElementById("selectStatus")
    const value = (selectStatus.options[selectStatus.selectedIndex].value);

    const inquiryTable = document.querySelector('question-list-table');
    const pagination = document.querySelector(".pagination");
    console.log(value);
   
    $.ajax({
        url: '/manager/inquiryStatus',
        type: 'GET',
        data: { 'value': value },
        success: (map) => {
            if (map != null) {

                const options=selectStatus.childNodes;
                for(o of options){
                    if(o.value==value){
                        o.setAttribute("selected", true);
                    }
                }
                const before = document.querySelectorAll('.question-list-table-content');
                for (b of before) {
                    b.remove();
                }
                document.querySelector('.pagination').innerHTML = "";


                        // <div class="question-list-table-content">
                        //     <div class="question-num">${managerInquiry.userInquiryNo}</div>
                        
                        //     <div class="question-title"><a href="/managerInquiryDetail/${managerInquiry.userInquiryNo}?cp=${pagination.currentPage}${sURL}">${managerInquiry.userInquiryTitle}</a></div>
                        //     <div class="question-date">${managerInquiry.userInquiryCreateDate}</div>
                        //     <div class="question-status">
                        //     <c:choose>
                        //         <c:when test="${managerInquiry.inquiryRequest == null}">
                        //             <span class="question-wating">답변 대기</span>
                        //         </c:when>
                        //         <c:when test="${managerInquiry.inquiryRequest != null}">
                        //             <span class="question-answer">답변 완료</span>
                        //         </c:when>
                        //     </c:choose>
                        //     </div>
                        // </div>


                
                for (inquiry of map.managerInquiryList) {
                    const table = document.createElement("div");
                    table.classList.add('question-list-table-content');

                    const child1 = document.createElement("div");
                    child1.classList.add('question-num');
                    child1.append(document.createTextNode(managerInquiry.userInquiryNo));

                    const child2 = document.createElement("div");
                    child2.classList.add('question-title');
                    const child2a = document.createElement("a");
                    child2a.setAttribute("href", "/managerInquiryDetail/${managerInquiry.userInquiryNo}?cp=${pagination.currentPage}${sURL}");
                    child2a.append(document.createTextNode(managerInquiry.userInquiryTitle));
                    child2.append(child2a);

                    const child3 = document.createElement("div");
                    child3.classList.add('question-date');
                    child3.append(document.createTextNode(managerInquiry.userInquiryCreateDate));

                    const child4 = document.createElement("div");
                    child4.classList.add('question-status');
                    child4.append(document.createTextNode(managerInquiry.inquiryRequest));

                    

                    table.append(child1);
                    table.append(child2);
                    table.append(child3);
                    table.append(child4);
                    inquiryTable.append(table);

                }

                /* 페이징 */
                const li1 = document.createElement("li");
                const a1 = document.createElement("a");
                a1.setAttribute('href', "/manager/memberList?cp=1${sURL}");
                a1.appendChild(document.createTextNode("<<"));
                li1.append(a1);
                pagination.append(li1);

                const li2 = document.createElement("li");
                const a2 = document.createElement("a");
                a2.setAttribute("href", "/manager/memberList?cp=${pagination.prevPage}${sURL}");
                a2.appendChild(document.createTextNode("<"));
                li2.append(a2);
                pagination.append(li2);

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
                        a3.setAttribute("href", "/manager/memberList?cp=${i}${sURL}");
                        a3.appendChild(document.createTextNode(i));
                        li3.append(a3);
                        pagination.append(li3);
                    }
                }

                const li4 = document.createElement("li");
                const a4 = document.createElement("a");
                a4.setAttribute("href", "/manager/memberList?cp=${pagination.nextPage}${sURL}");
                a4.appendChild(document.createTextNode(">"));
                li4.append(a4);
                pagination.append(li4);

                const li5 = document.createElement("li");
                const a5 = document.createElement("a");
                a5.setAttribute("href", "/manager/memberList?cp=${pagination.maxPage}${sURL}");
                a5.appendChild(document.createTextNode(">>"));
                li5.append(a5);
                pagination.append(li5);
                

                
                document.getElementById("inputValue").value=value;

                 
                
            }
        }
    });






};