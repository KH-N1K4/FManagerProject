



// 진행 상태 변경
function selectStatusChange() {
    const selectStatus = document.getElementById("selectStatus");
    const status = (selectStatus.options[selectStatus.selectedIndex].value);
    const selectType = document.getElementById("selectType");
    const type = (selectType.options[selectType.selectedIndex].value);
    const tradeReportTable = document.querySelector('#question-list-table');
    const pagination = document.querySelector(".pagination");
    console.log(status);

    

    $.ajax({
        url: '/manager/tradeReportStatus',
        type: 'GET',
        data: { 'status': status,'type': type },
        success: (resultMap) => {
            if (resultMap != null) {

                if (document.getElementById("search-query") != null) { // 검색창이 존재할 때
                    
                    document.getElementById("search-query").value = "";

                }

                const option1 = selectStatus.childNodes;
                for (o of option1) {
                    if (o.value == status) {
                        o.setAttribute("selected", true);
                    }
                }
                const option2 = selectType.childNodes;
                for (o of option2) {
                    if (o.value == type) {
                        o.setAttribute("selected", true);
                    }
                }

                const before = document.querySelectorAll(".question-list-table-content");
                for (b of before) {
                    b.remove();
                }

                document.querySelector(".pagination").innerHTML = "";

                if (resultMap.tradeReportList.length == 0) {
                    const table = document.createElement("div");
                    table.classList.add('question-list-table-content');
                    table.classList.add('center');
                    table.appendChild(document.createTextNode("게시글이 존재하지 않습니다."));
                    tradeReportTable.append(table);
                } else {

                    for (tradeReport of resultMap.tradeReportList) {

                        const table = document.createElement("div");
                        table.classList.add('question-list-table-content');

                        const child1 = document.createElement("div");
                        child1.classList.add('question-num');
                        const child1a = document.createElement("a");
                        child1a.setAttribute("href", "/manager/tradeReportDetail/"+ tradeReport.tradeReportNo);
                        child1a.classList.add("reportDetailBtn");
                        child1a.append(document.createTextNode(tradeReport.tradeReportNo));
                        child1.append(child1a);
                        table.append(child1);

                        const child2 = document.createElement("div");
                        child2.classList.add('question-no');
                        child2.append(document.createTextNode(tradeReport.tradeNo));
                        table.append(child2);

                        const child3 = document.createElement("div");
                        child3.classList.add('question-type');
                        child3.append(document.createTextNode(tradeReport.tradeReportTypeName));
                        table.append(child3);

                        const child4 = document.createElement("div");
                        child4.classList.add('question-report');
                        child4.append(document.createTextNode(tradeReport.tradeReportMemberName));
                        table.append(child4);

                        const child5 = document.createElement("div");
                        child5.classList.add('question-reported');
                        child5.append(document.createTextNode(tradeReport.tradeReportedMemberName));
                        table.append(child5);

                        const child6 = document.createElement("div");
                        child6.classList.add('question-date');
                        child6.append(document.createTextNode(tradeReport.tradeReportCreateDate));
                        table.append(child6);




                        const child7 = document.createElement("div");
                        child7.classList.add('question-status');

                        if (tradeReport.refundFlag == 'N') {
                            const span = document.createElement("span");
                            span.classList.add("question-wating");
                            span.append(document.createTextNode("답변 대기"));
                            child7.append(span);
                            table.append(child7);
                        } else {
                            const span = document.createElement("span");
                            span.classList.add("question-answer");
                            span.append(document.createTextNode("해결 완료"));
                            child7.append(span);
                            table.append(child7);
                        }

                        tradeReportTable.append(table); 

                    }

                    /* 페이징 */
                    const li1 = document.createElement("li");
                    const a1 = document.createElement("a");
                    a1.setAttribute('href', "/manager/tradeReportList?cp=1" + "&status=" + status+"&type=" + type);
                    a1.appendChild(document.createTextNode("<<"));
                    li1.append(a1);
                    pagination.append(li1);

                    const li2 = document.createElement("li");
                    const a2 = document.createElement("a");
                    a2.setAttribute("href", "/manager/tradeReportList?cp=" + resultMap.pagination.prevPage + "&status=" + status+"&type=" + type);
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
                            a3.setAttribute("href", "/manager/tradeReportList?cp=" + i + "&status=" + status+"&type=" + type);
                            a3.appendChild(document.createTextNode(i));
                            li3.append(a3);
                            pagination.append(li3);
                        }
                    }

                    const li4 = document.createElement("li");
                    const a4 = document.createElement("a");
                    a4.setAttribute("href", "/manager/tradeReportList?cp=" + resultMap.pagination.nextPage + "&status=" + status+"&type=" + type);
                    a4.appendChild(document.createTextNode(">"));
                    li4.append(a4);
                    pagination.append(li4);

                    const li5 = document.createElement("li");
                    const a5 = document.createElement("a");
                    a5.setAttribute("href", "/manager/tradeReportList?cp=" + resultMap.pagination.maxPage + "&status=" + status+"&type=" + type);
                    a5.appendChild(document.createTextNode(">>"));
                    li5.append(a5);
                    pagination.append(li5);

                }



                document.getElementById("inputStatus").value=status;
                document.getElementById("inputType").value=type;

                /* 회원 번호 선택 시 숫자만 보내기 */
                const inquirySearchFrm = document.getElementById("inquirySearch");
                if(inquirySearchFrm != null){
                    inquirySearchFrm.addEventListener("submit",e=>{
                        
                        const select = document.getElementById("search-key");
                        const input = document.getElementById("search-query");

                        if (select.options[select.selectedIndex].value == 'tn' || select.options[select.selectedIndex].value == 'rn'){
                            const regEx = /[0-9]/g;
                            if(!regEx.test(input.value)){
                                input.value="";
                                alert('숫자만 입력해주세요.')
                                e.preventDefault();
                            }

                        }

                    });
                }



            }
        }

    });
}





/* 검색 결과 남겨 놓기 */
(() => {
    const select = document.getElementById("search-key");
    const input = document.getElementById("search-query");
    const option = document.querySelectorAll("#search-key > option");

    if (select != null) { // 검색창이 존재할 때
        const params = new URL(location.href).searchParams;
        // 주소에서 쿼리스트링만 분리한 객체
        
        const key = params.get("key");
        const query = params.get("query");
        
        // input에 이전 검색어를 값으로 추가
        input.value = query;
        
        // select에서 이전 검색한 key의 값과 일치하는 option태그에
        // selected 속성 추가
        for (let op of option) {
            
            // option의 value와 key가 일치할 때
            if (op.value == key) {
                // op.setAttribute("selected", true)
                op.selected = true;
            }
        }

    }
})();


/* 회원 번호 선택 시 숫자만 보내기 */
const inquirySearchFrm = document.getElementById("inquirySearch");
if(inquirySearchFrm != null){
    inquirySearchFrm.addEventListener("submit",e=>{
        
        const select = document.getElementById("search-key");
        const input = document.getElementById("search-query");

        if (select.options[select.selectedIndex].value == 'tn' || select.options[select.selectedIndex].value == 'rn'){
            const regEx = /^[0-9]$/g;
            if(!regEx.test(input.value)){
                input.value="";
                alert('숫자만 입력해주세요.')
                e.preventDefault();
            }

        }

    });
}