refund();

/* 작업 상태 구분 */
function selectChange() {

    const selectWorkStatus = document.getElementById("selectWorkStatus")
    const status = (selectWorkStatus.options[selectWorkStatus.selectedIndex].value);
    const tradeListTable = document.querySelector('#manager-buy-table');
    const pagination = document.querySelector(".pagination");

    $.ajax({
        url: '/manager/tradeStatus',
        type: 'GET',
        data: { 'status': status },
        success: (map) => {

            if(map!=null){
                
                if (document.getElementById("search-query") != null) { // 검색창이 존재할 때
                    const params = new URL(location.href).searchParams;
                    // 주소에서 쿼리스트링만 분리한 객체
    
                    const query = params.get("query");
    
                    // input에 이전 검색어를 값으로 추가
                    document.getElementById("search-query").value = "";
    
                }

                const options = selectWorkStatus.childNodes;
                for (o of options) {
                    if (o.value == status) {
                        o.setAttribute("selected", true);
                    }
                }
                const before = document.querySelectorAll('.manager-buy-table-content');
                for (b of before) {
                    b.remove();
                }
                document.querySelector('.pagination').innerHTML = "";
    

                if (map.tradeList.length==0) {
                    const table = document.createElement("div");
                    table.classList.add('manager-buy-table-content');
                    table.classList.add('center');
                    table.appendChild(document.createTextNode("거래 내역이 존재하지 않습니다."));
                    tradeListTable.append(table);
                } else{

                    for (trade of map.tradeList) {
                        const table = document.createElement("div");
                        table.classList.add('manager-buy-table-content');
        
                        const child1 = document.createElement("div");
                        child1.classList.add('manager-num');
                        child1.append(document.createTextNode(trade.paymentDate));
        
                        const child2 = document.createElement("div");
                        child2.classList.add('manager-trade-num');
                        child2.append(document.createTextNode(trade.tradeNo));
        
                        const child3 = document.createElement("div");
                        child3.classList.add('manager-service-name');
                        const child3a = document.createElement("a");
                        child3a.classList.add('detailBtn');
                        child3a.append(document.createTextNode(trade.serviceTitle));
                        child3.append(child3a);
        
                        const child4 = document.createElement("div");
                        child4.classList.add('manager-expert');
                        child4.append(document.createTextNode(trade.userName));
        
                        const child5 = document.createElement("div");
                        child5.classList.add('manager-work-status');
                        child5.append(document.createTextNode(trade.workStatusString));
        
                        const child6 = document.createElement("div");
                        child6.classList.add('manager-division');
                        child6.append(document.createTextNode(trade.paymentTypeString));
        
                        const child7 = document.createElement("div");
                        child7.classList.add('manager-division');
                        child7.append(document.createTextNode(trade.paymentPrice));
        
                        const child8 = document.createElement("div");
                        child8.classList.add('manager-option');
                        
                        if(trade.workStatus==1){
                            const btn = document.createElement("a");
                            btn.classList.add("btn");
                            btn.classList.add("refund");
                            btn.append(document.createTextNode("환불"));
                            child8.append(btn);
                        } 
                        if(trade.workStatus==4){
                            const btn = document.createElement("a");
                            btn.classList.add("btn");
                            btn.classList.add("calculate");
                            btn.append(document.createTextNode("정산"));
                            child8.append(btn);
                        } 
        
                        table.append(child1);
                        table.append(child2);
                        table.append(child3);
                        table.append(child4);
                        table.append(child5);
                        table.append(child6);
                        table.append(child7);
                        table.append(child8);
                        tradeListTable.append(table);
        
                    }
        
        
                    /* 페이징 */
                    const li1 = document.createElement("li");
                    const a1 = document.createElement("a");
                    a1.setAttribute('href', "/manager/tradeList?cp=1"+"&value="+status);
                    a1.appendChild(document.createTextNode("<<"));
                    li1.append(a1);
                    pagination.append(li1);
        
                    const li2 = document.createElement("li");
                    const a2 = document.createElement("a");
                    a2.setAttribute("href", "/manager/tradeList?cp=" + map.pagination.prevPage+"&value="+status);
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
                            a3.setAttribute("href", "/manager/tradeList?cp=" + i+"&value="+status);
                            a3.appendChild(document.createTextNode(i));
                            li3.append(a3);
                            pagination.append(li3);
                        }
                    }
        
                    const li4 = document.createElement("li");
                    const a4 = document.createElement("a");
                    a4.setAttribute("href", "/manager/tradeList?cp=" + map.pagination.nextPage+"&value="+status);
                    a4.appendChild(document.createTextNode(">"));
                    li4.append(a4);
                    pagination.append(li4);
        
                    const li5 = document.createElement("li");
                    const a5 = document.createElement("a");
                    a5.setAttribute("href", "/manager/tradeList?cp=" + map.pagination.maxPage+"&value="+status);
                    a5.appendChild(document.createTextNode(">>"));
                    li5.append(a5);
                    pagination.append(li5);
                    
        
                    
                    document.getElementById("inputStatus").value=status;


                }

            }







        }

    });


}








/* 검색 결과 남겨 놓기 */
(() => {
    const inputQuery = document.getElementById("search-query");

    if (inputQuery != null) { // 검색창이 존재할 때
        const params = new URL(location.href).searchParams;
        // 주소에서 쿼리스트링만 분리한 객체

        const query = params.get("query");

        // input에 이전 검색어를 값으로 추가
        inputQuery.value = query;

    }
})();



/* 환불하기 모달 오픈 */
function refund(){
    const refundBtn = document.querySelectorAll(".refund");
    const body = document.querySelector('#mainBody');
    const tradeModal = document.querySelector(".trade-modal");
    const modalClose = document.querySelector(".modalClose");
    
    for(r of refundBtn){
        r.addEventListener("click", e => {

            const tradeNo = e.target.parentElement.previousElementSibling.previousElementSibling.previousElementSibling.previousElementSibling.previousElementSibling.previousElementSibling.innerText;
            console.log(tradeNo);

            $.ajax({
                url : '/manager/tradeInfo',
                data : {'tradeNo':tradeNo},
                type: 'GET',
                success: (tradeInfo)=>{
                    if(tradeInfo!=null){
                        if(!tradeModal.classList.contains('show')){
                            tradeModal.classList.add('show');
                            body.style.overflow='hidden';
                        } 
                    }
                }

            });
            
            
        
        });
    }

}

/* 정산하기 */

