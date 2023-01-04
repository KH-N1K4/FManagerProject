


// 페이징 처리 구역 
const pagination = document.querySelector(".pagination");
// 게시글 내용 영역
const contentArea = document.querySelectorAll(".contentArea");
// 진행상태 select
const processStatus = document.getElementById("processStatus");
// 진행상태 selectBox value
const value = (processStatus.options[processStatus.selectedIndex].value);


function selectChange() {

    $.ajax({
        url: '/member/statusType',
        type: 'GET',
        data: { 'value': value },
        success: (map) => {

            if (map != null) {

                // selectBox가 체크가 되었을 때
                const options = processStatus.childNodes;
                for(o of options){
                    if(o.value == value){
                        o.setAttribute("selected", true);
                    }
                }
                // 기존의 테이블 지워주기
                for (b of contentArea) {
                    b.remove();
                }

                if(document.querySelector('.pagination')!=null){

                    document.querySelector('.pagination').innerHTML = "";
                } 

                if(map.inquiryList != null){

                    for (inquiry of map.inquiryList) {
                        
                        const tr = document.createElement("tr");
                        tr.setAttribute("id","contentArea");

                        const td1 = document.createElement("td");
                        td1.append(document.createTextNode(userinquiry.userInquiryNo));
                        const td2 = document.createElement("td");
                        const a = document.createElement("a");
                        a.setAttribute('href', "/userInquiryDetail/${userInquiryNo}?cp=1"+"&value="+value);

                        const td3 = document.createElement("td");
                        const td4 = document.createElement("td");
                        const td5 = document.createElement("td");

                        inquiryStatus

                    }

                    // 페이징
                    const li1 = document.createElement("li");
                    const a1 = document.createElement("a");
                    a1.setAttribute('href', "/manager/memberList?cp=1"+"&value="+value);
                    a1.appendChild(document.createTextNode("<<"));
                    li1.append(a1);
                    pagination.append(li1);

                    const li2 = document.createElement("li");
                    const a2 = document.createElement("a");
                    a2.setAttribute("href", "/manager/memberList?cp=" + map.pagination.prevPage+"&value="+value);
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
                            a3.setAttribute("href", "/manager/memberList?cp=" + i+"&value="+value);
                            a3.appendChild(document.createTextNode(i));
                            li3.append(a3);
                            pagination.append(li3);
                        }
                    }

                    const li4 = document.createElement("li");
                    const a4 = document.createElement("a");
                    a4.setAttribute("href", "/manager/memberList?cp=" + map.pagination.nextPage+"&value="+value);
                    a4.appendChild(document.createTextNode(">"));
                    li4.append(a4);
                    pagination.append(li4);

                    const li5 = document.createElement("li");
                    const a5 = document.createElement("a");
                    a5.setAttribute("href", "/manager/memberList?cp=" + map.pagination.maxPage+"&value="+value);
                    a5.appendChild(document.createTextNode(">>"));
                    li5.append(a5);
                    pagination.append(li5);
                    
                }


            }

        },
        error:()=>{

            console.log("실패");
        }




    })
        
}


