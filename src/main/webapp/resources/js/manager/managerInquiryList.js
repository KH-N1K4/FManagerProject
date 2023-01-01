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

                
                // if (document.getElementById("search-key") != null) { // 검색창이 존재할 때
                //     const params = new URL(location.href).searchParams;
                //     // 주소에서 쿼리스트링만 분리한 객체
                    
                //     document.getElementById("search-query").value="";
                //     const key = params.get("key");
                    
                //     const option = document.querySelectorAll("#search-key > option");
                //     for (let op of option) {

                //         // option의 value와 key가 일치할 때
                //         if (op.value == key) {
                //             // op.setAttribute("selected", true)
                //             op.selected = false;
                //         }
                //     }
                    
                // }
                

                
                for (inquiry of map.managerInquiryList) {
                    const table = document.createElement("div");
                    table.classList.add('question-list-table-content');

                    const child1 = document.createElement("div");
                    child1.classList.add('question-num');
                    child1.append(document.createTextNode(member.memberNo));

                    const child2 = document.createElement("div");
                    child2.classList.add('question-title');
                    const child2a = document.createElement("a");
                    child2a.classList.add('infoBtn');
                    child2a.append(document.createTextNode(member.memberName));
                    child2.append(child2a);

                    const child3 = document.createElement("div");
                    child3.classList.add('member-division');
                    child3.append(document.createTextNode(member.memberType));

                    const child4 = document.createElement("div");
                    child4.classList.add('member-grade');
                    child4.append(document.createTextNode(member.freelancerGrade));

                    const child5 = document.createElement("div");
                    child5.classList.add('member-enrollDate');
                    child5.append(document.createTextNode(member.memberEnrollDate));

                    const child6 = document.createElement("div");
                    child6.classList.add('member-delete');
                    const child6a = document.createElement("a");
                    child6a.classList.add('deleteBtn');
                    child6a.append(document.createTextNode("탈퇴"));
                    child6.append(child6a);

                    table.append(child1);
                    table.append(child2);
                    table.append(child3);
                    table.append(child4);
                    table.append(child5);
                    table.append(child6);
                    memberTable.append(table);

                }

                modalShow();
                deleteMember();

                console.log(map.pagination);

                /* 페이징 */
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
                

                
                document.getElementById("inputValue").value=value;

                 
                
            }
        }
    });






};