console.log(sURL);
console.log(key);
console.log(key == "");

/* 모달 */
modalShow();

/* 회원 구분 select */
function selectChange() {
    const selectmemberType = document.getElementById("selectmemberType")
    const value = (selectmemberType.options[selectmemberType.selectedIndex].value);
    const memberTable = document.querySelector('#member-manage-table');
    const pagination = document.querySelector(".pagination");


    $.ajax({
        url: '/manager/memberType/',
        type: 'GET',
        data: { 'value': value },
        success: (map) => {
            if (map != null) {
                console.log(map);
                const before = document.querySelectorAll('.member-manage-table-content');
                for (b of before) {
                    b.remove();
                }
                document.querySelector('.pagination').innerHTML = "";

                for (member of map.memberList) {
                    const table = document.createElement("div");
                    table.classList.add('member-manage-table-content');

                    const child1 = document.createElement("div");
                    child1.classList.add('member-num');
                    child1.append(document.createTextNode(member.memberNo));

                    const child2 = document.createElement("div");
                    child2.classList.add('member-name');
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



                /* 페이징 */
                const li1 = document.createElement("li");
                const a1 = document.createElement("a");
                a1.setAttribute('href', "/manager/memberList?cp=1");
                a1.appendChild(document.createTextNode("<<"));
                li1.append(a1);

                const li2 = document.createElement("li");
                const a2 = document.createElement("a");
                a2.setAttribute("href", "/manager/memberList?cp=" + pagination.prevPage);
                a2.appendChild(document.createTextNode("<"));
                li2.append(a2);

                /* 숫자가 안나와 */
                const li3 = document.createElement("li");
                for (i = pagination.startPage; i <= pagination.endPage; i++) {
                    if (i == pagination.currentPage) {
                        const a3 = document.createElement("a");
                        a3.classList.add("current");
                        a3.appendChild(document.createTextNode(i));
                        li3.append(a3);
                    } else {
                        const a3 = document.createElement("a");
                        a3.setAttribute("href", "/manager/memberList?cp=" + i);
                        a3.appendChild(document.createTextNode(i));
                        li3.append(a3);
                    }
                }

                const li4 = document.createElement("li");
                const a4 = document.createElement("a");
                a4.setAttribute("href", "/manager/memberList?cp=" + pagination.nextPage);
                a4.appendChild(document.createTextNode(">"));
                li4.append(a4);

                const li5 = document.createElement("li");
                const a5 = document.createElement("a");
                a5.setAttribute("href", "/manager/memberList?cp=" + pagination.maxPage);
                a5.appendChild(document.createTextNode(">>"));
                li5.append(a5);


                pagination.append(li1);
                pagination.append(li2);
                pagination.append(li3);
                pagination.append(li4);
                pagination.append(li5);




            }
        }
    });






};




/* 회원 탈퇴 */
const deleteBtn = document.querySelector(".deleteBtn");

deleteBtn.addEventListener("click", e => {
    const memberNo = e.target.parentElement.previousElementSibling.previousElementSibling.previousElementSibling.previousElementSibling.previousElementSibling.innerText;

    $.ajax({
        url: 'manager/memberDelete',
        date: { 'memberNo': memberNo },
        success: (result) => {
            if (result > 0) {

            } else {

            }
        }
    });

});





/* 모달 함수 */
function modalShow() {
    const btnOpenPopup = document.querySelectorAll('.infoBtn');
    const body = document.querySelector('#mainBody');
    const memberModal = document.querySelector('.member-modal');
    const freelancer = document.querySelector('.freelancerArea');
    const modalClose = document.querySelector('.modal_close');
    for (m of btnOpenPopup) {

        m.addEventListener("click", e => {

            const memberNo = e.target.parentElement.previousElementSibling.innerText;
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

                        $("#checkbox > input").prop("checked", false);

                        if (member.memberInterest != null) {
                            interest = member.memberInterest.split(',');
                            for (i of interest) {
                                document.querySelectorAll("#checkbox > input")[i - 1].checked = true;
                            }
                        }
                        if (member.freelancerFlag == 'Y') {
                            freelancer.classList.add('show');
                            document.getElementById("freelancerIntroduction").innerText = member.freelancerIntroduction;
                            document.getElementById("freelancerRegionName").innerText = member.regionName;
                            document.getElementById("freelancerPeriod").innerText = member.freelancerPeriod;
                            document.getElementById("freeContactTime1").innerText = member.freeContactTime1;
                            document.getElementById("freeContactTime2").innerText = member.freeContactTime2;
                            document.getElementById("freelancerBankName").value = member.freelancerBankName;
                            document.getElementById("freelancerAccount").value = member.freelancerAccountNo;
                        } else{
                            freelancer.classList.remove('show');
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