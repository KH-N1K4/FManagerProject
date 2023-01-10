

function selectChange() {
    const selectStatus = document.getElementById("selectStatus");
    const status = (selectStatus.options[selectStatus.selectedIndex].value);
    const memberReportTable = document.querySelector('#question-list-table');
    const pagination = document.querySelector(".pagination");
    console.log(status);

    $.ajax({
        url: '/manager/memberReportType',
        type: 'GET',
        data: { 'status': status },
        success: (map) => {
            if (map != null) {

                if (document.getElementById("search-query") != null) { // 검색창이 존재할 때
                    
                    document.getElementById("search-query").value = "";

                }

                const options = selectStatus.childNodes;
                for (o of options) {
                    if (o.value == status) {
                        o.setAttribute("selected", true);
                    }
                }

                const before = document.querySelectorAll(".question-list-table-content");
                for (b of before) {
                    b.remove();
                }

                document.querySelector(".pagination").innerHTML = "";

                if (map.memberReportList.length == 0) {
                    const table = document.createElement("div");
                    table.classList.add('question-list-table-content');
                    table.classList.add('center');
                    table.appendChild(document.createTextNode("게시글이 존재하지 않습니다."));
                    memberReportTable.append(table);
                } else {

                    for (memberReport of map.memberReportList) {

                        const table = document.createElement("div");
                        table.classList.add('question-list-table-content');

                        const child1 = document.createElement("div");
                        child1.classList.add('question-num');
                        child1.append(document.createTextNode(memberReport.memberReportNo));
                        table.append(child1);

                        const child2 = document.createElement("div");
                        child2.classList.add('question-date');
                        child2.append(document.createTextNode(memberReport.memberReportCreateDate));
                        table.append(child2);

                        const child3 = document.createElement("div");
                        child3.classList.add('question-title');
                        const child3a = document.createElement("a");
                        child3a.setAttribute("href", "/manager/memberReportDetail/"+ memberReport.memberReportNo);
                        child3a.append(document.createTextNode(memberReport.memberReportTitle));
                        child3.append(child3a);
                        table.append(child3);

                        const child4 = document.createElement("div");
                        child4.classList.add('question-report');
                        child4.append(document.createTextNode(memberReport.reportMemberName));
                        table.append(child4);

                        const child5 = document.createElement("div");
                        child5.classList.add('question-reported');
                        child5.append(document.createTextNode(memberReport.reportedMemberName));
                        table.append(child5);

                        const child6 = document.createElement("div");
                        child6.classList.add('question-status');

                        if (memberReport.memberReportRequest == null) {
                            const span = document.createElement("span");
                            span.classList.add("question-wating");
                            span.append(document.createTextNode("답변 대기"));
                            child6.append(span);
                            table.append(child6);
                        } else {
                            const span = document.createElement("span");
                            span.classList.add("question-answer");
                            span.append(document.createTextNode("해결 완료"));
                            child6.append(span);
                            table.append(child6);
                        }

                        memberReportTable.append(table);

                    }

                    /* 페이징 */
                    const li1 = document.createElement("li");
                    const a1 = document.createElement("a");
                    a1.setAttribute('href', "/manager/memberReportList?cp=1" + "&value=" + map.status);
                    a1.appendChild(document.createTextNode("<<"));
                    li1.append(a1);
                    pagination.append(li1);

                    const li2 = document.createElement("li");
                    const a2 = document.createElement("a");
                    a2.setAttribute("href", "/manager/memberReportList?cp=" + map.pagination.prevPage + "&value=" + map.status);
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
                            a3.setAttribute("href", "/manager/memberReportList?cp=" + i + "&value=" + map.status);
                            a3.appendChild(document.createTextNode(i));
                            li3.append(a3);
                            pagination.append(li3);
                        }
                    }

                    const li4 = document.createElement("li");
                    const a4 = document.createElement("a");
                    a4.setAttribute("href", "/manager/memberReportList?cp=" + map.pagination.nextPage + "&value=" + map.status);
                    a4.appendChild(document.createTextNode(">"));
                    li4.append(a4);
                    pagination.append(li4);

                    const li5 = document.createElement("li");
                    const a5 = document.createElement("a");
                    a5.setAttribute("href", "/manager/memberReportList?cp=" + map.pagination.maxPage + "&value=" + map.status);
                    a5.appendChild(document.createTextNode(">>"));
                    li5.append(a5);
                    pagination.append(li5);

                }


                document.getElementById("inputStatus").value=map.status;




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




