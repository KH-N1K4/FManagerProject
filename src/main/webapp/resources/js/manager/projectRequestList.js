
deleteService();


/* 옵션 변경 시 */
function selectChange() {
    const selectServiceStatus = document.getElementById("selectServiceStatus");
    const status = (selectServiceStatus.options[selectServiceStatus.selectedIndex].value);
    const serviceTable = document.querySelector('#service-list-table');
    const pagination = document.querySelector(".pagination");
    console.log(status);

    if (document.getElementById("search-key") != null) { // 검색창이 존재할 때
        const params = new URL(location.href).searchParams;
        // 주소에서 쿼리스트링만 분리한 객체
        
        document.getElementById("search-query").value="";
        const key = params.get("key");
        
        const option = document.querySelectorAll("#search-key > option");
        for (let op of option) {

            // option의 value와 key가 일치할 때
            if (op.value == key) {
                // op.setAttribute("selected", true)
                op.selected = false;
            }
        }
        
    }

    $.ajax({
        url: '/manager/requestType',
        type: 'GET',
        data: { 'status': status },
        success: (map) => {
            if (map != null) {
                console.log(map);

                const options = selectServiceStatus.childNodes;
                for (o of options) {
                    if (o.value == status) {
                        o.setAttribute("selected", true);
                    }
                }

                const before = document.querySelectorAll(".service-list-table-content");
                for (b of before) {
                    b.remove();
                }
                
                if(document.querySelector(".pagination")!=null){

                    document.querySelector(".pagination").innerHTML = "";
                }

                

                if (map.requestList.length==0) {
                    const table = document.createElement("div");
                    table.classList.add('service-list-table-content');
                    table.classList.add('center');
                    table.appendChild(document.createTextNode("해당 의뢰가 존재하지 않습니다."));
                    serviceTable.append(table);
                } else {

                    for (request of map.requestList) {

                        const table = document.createElement("div");
                        table.classList.add('service-list-table-content');

                        const child1 = document.createElement("div");
                        child1.classList.add('service-num');
                        child1.append(document.createTextNode(request.projectRequestNo));

                        const child2 = document.createElement("div");
                        child2.classList.add('service-title');
                        const child2a = document.createElement("a");
                        child2a.classList.add('detailBtn');
                        child2a.setAttribute("href", "/manager/requestDetail/"+request.projectRequestNo);
                        child2a.append(document.createTextNode(request.projectRequestTitle));
                        child2.append(child2a);

                        const child3 = document.createElement("div");
                        child3.classList.add('service-status');
                        child3.append(document.createTextNode(request.projectRequestStatusString));

                        const child4 = document.createElement("div");
                        child4.classList.add('service-button');
                        const child4a = document.createElement("a");
                        child4a.classList.add('service-button-value');
                        child4a.append(document.createTextNode("삭제"));
                        child4.append(child4a);

                        table.append(child1);
                        table.append(child2);
                        table.append(child3);
                        table.append(child4);
                        serviceTable.append(table);

                    }
                    deleteService();
    
                    /* 페이징 */
                    const li1 = document.createElement("li");
                    const a1 = document.createElement("a");
                    a1.setAttribute('href', "/manager/requestList?cp=1" + "&value=" + status);
                    a1.appendChild(document.createTextNode("<<"));
                    li1.append(a1);
                    pagination.append(li1);
    
                    const li2 = document.createElement("li");
                    const a2 = document.createElement("a");
                    a2.setAttribute("href", "/manager/requestList?cp=" + map.pagination.prevPage + "&value=" + status);
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
                            a3.setAttribute("href", "/manager/requestList?cp=" + i + "&value=" + status);
                            a3.appendChild(document.createTextNode(i));
                            li3.append(a3);
                            pagination.append(li3);
                        }
                    }
    
                    const li4 = document.createElement("li");
                    const a4 = document.createElement("a");
                    a4.setAttribute("href", "/manager/requestList?cp=" + map.pagination.nextPage + "&value=" + status);
                    a4.appendChild(document.createTextNode(">"));
                    li4.append(a4);
                    pagination.append(li4);
    
                    const li5 = document.createElement("li");
                    const a5 = document.createElement("a");
                    a5.setAttribute("href", "/manager/requestList?cp=" + map.pagination.maxPage + "&value=" + status);
                    a5.appendChild(document.createTextNode(">>"));
                    li5.append(a5);
                    pagination.append(li5);

                }

                document.getElementById("inputStatus").value=status;

                /* 회원 번호 선택 시 숫자만 보내기 */
                const serviceSearchFrm = document.getElementById("serviceSearch");
                if(serviceSearchFrm != null){
                    serviceSearchFrm.addEventListener("submit",e=>{
                        
                        const select = document.getElementById("search-key");
                        const input = document.getElementById("search-query");

                        if (select.options[select.selectedIndex].value == 'no'){
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
















/* 서비스 삭제 */
function deleteService() {
    const deleteBtn = document.querySelectorAll(".service-button-value");

    for (d of deleteBtn) {
        d.addEventListener("click", e => {
            if (confirm("정말로?")) {

                const projectRequestNo = e.target.parentElement.previousElementSibling.previousElementSibling.previousElementSibling.innerText;
                $.ajax({
                    url: '/manager/requestDelete',
                    data: { 'projectRequestNo': projectRequestNo },
                    type: 'GET',
                    success: (result) => {
                        if (result > 0) {
                            selectChange();
                        } else {

                        }
                    }
                });
            }

        });
    }

}



/* 회원 번호 선택 시 숫자만 보내기 */
const serviceSearchFrm = document.getElementById("serviceSearch");
if(serviceSearchFrm != null){
    serviceSearchFrm.addEventListener("submit",e=>{
        
        const select = document.getElementById("search-key");
        const input = document.getElementById("search-query");

        if (select.options[select.selectedIndex].value == 'no'){
            const regEx = /[0-9]/g;
            if(!regEx.test(input.value)){
                input.value="";
                alert('숫자만 입력해주세요.')
                e.preventDefault();
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