
deleteService();
modalShow();


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

                        const child22 = document.createElement("div");
                        child22.classList.add('service-name');
                        const child22a = document.createElement("a");
                        child22a.classList.add('infoBtn');
                        child22a.append(document.createTextNode(request.memberName));
                        child22.append(child22a);

                        const child222 = document.createElement("input");
                        child222.setAttribute("type","hidden");
                        child222.setAttribute("id","projectRequestNo");
                        child222.value=request.memberNo;

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
                        table.append(child22);
                        table.append(child222);
                        table.append(child3);
                        table.append(child4);
                        serviceTable.append(table);

                    }
                    deleteService();
                    modalShow();
    
                    /* 페이징 */
                    const li1 = document.createElement("li");
                    const a1 = document.createElement("a");
                    a1.setAttribute('href', "/manager/projectRequestList?cp=1" + "&value=" + map.status);
                    a1.appendChild(document.createTextNode("<<"));
                    li1.append(a1);
                    pagination.append(li1);
    
                    const li2 = document.createElement("li");
                    const a2 = document.createElement("a");
                    a2.setAttribute("href", "/manager/projectRequestList?cp=" + map.pagination.prevPage + "&value=" + map.status);
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
                            a3.setAttribute("href", "/manager/projectRequestList?cp=" + i + "&value=" + map.status);
                            a3.appendChild(document.createTextNode(i));
                            li3.append(a3);
                            pagination.append(li3);
                        }
                    }
    
                    const li4 = document.createElement("li");
                    const a4 = document.createElement("a");
                    a4.setAttribute("href", "/manager/projectRequestList?cp=" + map.pagination.nextPage + "&value=" + map.status);
                    a4.appendChild(document.createTextNode(">"));
                    li4.append(a4);
                    pagination.append(li4);
    
                    const li5 = document.createElement("li");
                    const a5 = document.createElement("a");
                    a5.setAttribute("href", "/manager/projectRequestList?cp=" + map.pagination.maxPage + "&value=" + map.status);
                    a5.appendChild(document.createTextNode(">>"));
                    li5.append(a5);
                    pagination.append(li5);

                }

                document.getElementById("inputStatus").value=map.status;

                /* 회원 번호 선택 시 숫자만 보내기 */
                const requestSearchFrm = document.getElementById("requestSearch");
                if(requestSearchFrm != null){
                    requestSearchFrm.addEventListener("submit",e=>{
                        
                        const select = document.getElementById("search-key");
                        const input = document.getElementById("search-query");

                        if (select.options[select.selectedIndex].value == 'no'){
                            const regEx = /^[0-9]+$/;
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

                const projectRequestNo = e.target.parentElement.previousElementSibling.previousElementSibling.value;
                console.log(projectRequestNo);
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
const requestSearchFrm = document.getElementById("requestSearch");
if(requestSearchFrm != null){
    requestSearchFrm.addEventListener("submit",e=>{
        
        const select = document.getElementById("search-key");
        const input = document.getElementById("search-query");

        if (select.options[select.selectedIndex].value == 'no'){
            const regEx = /^[0-9]+$/;
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





/* 회원 정보 보기 */
function modalShow() {
    const btnOpenPopup = document.querySelectorAll('.infoBtn');
    const body = document.querySelector('#mainBody');
    const memberModal = document.querySelector('.member-modal');
    const modalClose = document.querySelector('.modal_close');
    for (m of btnOpenPopup) {

        m.addEventListener("click", e => {

            const memberNo = e.target.parentElement.nextElementSibling.value;
            console.log(memberNo);

            $.ajax({
                url: '/manager/memberDetail',
                data: { 'memberNo': memberNo },
                type: 'GET',
                success: (member) => {
                    if (member != null) {
                        memberModal.classList.toggle('show');

                        if (memberModal.classList.contains('show')) {
                            body.style.overflow = 'hidden';
                        }
                        document.getElementById("memberNickname").value = member.memberNickname
                        document.getElementById("memberEmail").value = member.memberEmail
                        document.getElementById("memberTel").value = member.memberTel
                        document.getElementById("memberJob").value = member.memberJob
                        document.getElementById("profile-image").setAttribute("src",member.memberProfile) 

                        $("#checkbox > input").prop("checked", false);

                        if (member.memberInterest != null) {
                            interest = member.memberInterest.split(',');
                            for (i of interest) {
                                document.querySelectorAll("#checkbox > input")[i - 1].checked = true;
                            }
                        }
                        

                    } else {
                        console.log('오류');
                    }
                },
                error: () => { console.log('에러'); }
            });



        });
        modalClose.addEventListener('click', () => {
            if (memberModal.classList.contains('show')) {
                memberModal.classList.remove('show');
            }

            if (!memberModal.classList.contains('show')) {
                body.style.overflow = 'visible';
            }

        });
    }
};