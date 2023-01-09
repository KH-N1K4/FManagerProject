


function selectChange() {

    // 페이지 처리 구역 
    const pagination = document.querySelector(".pagination");
    // 생성할 구역을 포함하는 div
    const tbody = document.getElementById("selecttbody");
    // 생성할 구역 
    const content = document.querySelectorAll(".suggestionTable");
    // 카테고리 selectBox
    const srchOption = document.getElementById("srchOption");
    // 진행상태 selectBox value
    const optionVal = (srchOption.options[srchOption.selectedIndex].value);


    $.ajax({
        url: '/member/categoryTypeSelect_suggest',
        type: 'GET',
        data: { 'optionVal': optionVal },
        success: (map) => {

            if (map != null) {
                // select check 값 얻어오기
                const options = srchOption.childNodes;
                for (o of options) {
                    if (o.value == optionVal) {
                        o.setAttribute("selected", true);
                    }
                }
                // 기존의 테이블 지워주기
                for (b of content) {
                    console.log(b);
                    b.remove();
                }

                // 페이지 처리 구역 삭제
                if (document.querySelector('.pagination') != null) {

                    document.querySelector('.pagination').innerHTML = "";

                }
                console.log(map.proposal);
                console.log(map.proposal.length);

                if (map.proposal.length != 0) {  // 게시글이 존재할 때


                    for (proposal of map.proposal) {

                        const tr = document.createElement("tr");
                        tr.setAttribute("class", "suggestionTable");
                        tr.setAttribute("id", "suggestionTable");
                        tbody.append(tr);

                        const td1 = document.createElement("td");
                        td1.setAttribute("class", "tc");
                        tr.append(td1);

                        const span1 = document.createElement("span");
                        span1.setAttribute("class", "num");
                        span1.innerText = proposal.proposalNo;
                        td1.append(span1);

                        const td2 = document.createElement("td");
                        td2.setAttribute("class", "tl");
                        tr.append(td2);

                        const div1 = document.createElement("div");
                        div1.setAttribute("class", "suggestion_name_area td_link");
                        td2.append(div1);

                        const a = document.createElement("a");
                        a.setAttribute("class", "suggestionName");
                        a.setAttribute("href", "/projectRequest/projectRequestDetail/"+proposal.projectRequestNo);
                        a.setAttribute("id", "suggestionName");
                        a.innerText = proposal.projectRequestTitle;
                        div1.append(a);

                        const td3 = document.createElement("td");
                        td3.setAttribute("class", "tc");
                        tr.append(td3);

                        const div2 = document.createElement("div");
                        div2.setAttribute("class", "expert_name_area td_link");
                        td3.append(div2);

                        const a2 = document.createElement("a");
                        a2.setAttribute("class", "expertName");
                        a2.setAttribute("href", "/service/freelancerDetail/"+proposal.freelancerNo);
                        a2.setAttribute("id", "expertName");
                        a2.innerText = proposal.freelancerName;
                        div2.append(a2);

                        const td4 = document.createElement("td");
                        td4.setAttribute("class", "tc");
                        tr.append(td4);

                        const span2 = document.createElement("span");
                        span2.setAttribute("class", "text");
                        span2.innerText = proposal.gradeName;
                        td4.append(span2);

                        const td5 = document.createElement("td");
                        td5.setAttribute("class", "tc");
                        tr.append(td5);

                        const span3 = document.createElement("span");
                        span3.setAttribute("class", "text");
                        span3.innerText = proposal.proposalPrice + "원";
                        td5.append(span3);

                        const td6 = document.createElement("td");
                        td6.setAttribute("class", "tc");
                        tr.append(td6);

                        const span4 = document.createElement("span");
                        span4.setAttribute("class", "num");
                        span4.innerText = proposal.proposalEditNum;
                        td6.append(span4);

                        const td7 = document.createElement("td");
                        td7.setAttribute("class", "tc");
                        td7.setAttribute("id", "proposalStatus");
                        tr.append(td7);

                        const span5 = document.createElement("span");
                        span5.setAttribute("class", "text");
                        span5.innerText = proposal.proposalAdoptStatus;
                        td7.append(span5);

                        const td8 = document.createElement("td");
                        td8.setAttribute("class", "tc");
                        tr.append(td8);

                        if(proposal.proposalAdoptStatus == '대기 중'){
    
                            const button = document.createElement("button");
                            button.setAttribute("id", "chooseBtn");
                            button.setAttribute("class", "chooseBtn");
                            button.innerText = "채택";
                            td8.append(button);
                            
                        }

                    }

                    // 페이징
                    const li1 = document.createElement("li");
                    const a1 = document.createElement("a");
                    a1.setAttribute('href', "/member/myProject/myReceiveList?cp=1" + "&optionVal=" + optionVal);
                    a1.appendChild(document.createTextNode("<<"));
                    li1.append(a1);
                    pagination.append(li1);


                    const li2 = document.createElement("li");
                    const a2 = document.createElement("a");
                    a2.setAttribute("href", "/member/myProject/myReceiveList?cp=" + map.pagination.prevPage + "&optionVal=" + optionVal);
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
                            a3.setAttribute("href", "/member/myProject/myReceiveList?cp=" + i + "&optionVal=" + optionVal);
                            a3.appendChild(document.createTextNode(i));
                            li3.append(a3);
                            pagination.append(li3);
                        }
                    }

                    const li4 = document.createElement("li");
                    const a4 = document.createElement("a");
                    a4.setAttribute("href", "/member/myProject/myReceiveList?cp=" + "&optionVal=" + optionVal);
                    a4.appendChild(document.createTextNode(">"));
                    li4.append(a4);
                    pagination.append(li4);

                    const li5 = document.createElement("li");
                    const a5 = document.createElement("a");
                    a5.setAttribute("href", "/member/myProject/myReceiveList?cp=" + "&optionVal=" + optionVal);
                    a5.appendChild(document.createTextNode(">>"));
                    li5.append(a5);
                    pagination.append(li5);


                } else { // 게시글이 존재하지 않을 때 

                    const tr = document.createElement("tr");
                    tr.setAttribute("class", "suggestionTable");
                    tbody.append(tr);

                    const td = document.createElement("td");
                    td.setAttribute("colspan", "8");
                    td.innerText = "받은 제안이 없습니다.";
                    tr.append(td);
                }


            }
        }

    })
}




const suggestionTable = document.getElementById("suggestionTable");


suggestionModal();

// 채택하기 모달
function suggestionModal() {

    const body = document.querySelector('body');
    const suggestionModal = document.querySelector('.suggestionModal');


        $(document).on("click",'.chooseBtn', e => {

            document.getElementById("tradeRequest").value="";

            // modal 창에 show가 있으면 생성 없으면 삭제 
            suggestionModal.classList.toggle("show");

            if (suggestionModal.classList.contains('show')) {
                body.style.overflow = 'hidden';
            }

            console.log(e.target.nextElementSibling);

            document.getElementById("text1").innerText = e.target.nextElementSibling.innerText;
            document.getElementById("text2").innerText = e.target.nextElementSibling.nextElementSibling.innerText;
            document.getElementById("text3").innerText = e.target.nextElementSibling.nextElementSibling.nextElementSibling.innerText + "일";
            document.getElementById("text4").innerText = e.target.nextElementSibling.nextElementSibling.nextElementSibling.nextElementSibling.innerText + "원";
            document.getElementById("varProposalNo").innerText = e.target.title;

            $(document).on("click",'.deleteBox', () => {

                if (suggestionModal.classList.contains('show')) {
                    suggestionModal.classList.remove('show');
                }
                if (!suggestionModal.classList.contains('show')) {
                    body.style.overflow = 'visible';
                }

            })

        });

}



// 구매하기 클릭 
$(document).on("click",'#payButton', () => {

    alert("결제를 진행하시겠습니까?");

})



function iamport() {
    const varProposalNo = document.getElementById("varProposalNo").innerText;
    const projectRequestTitle = document.getElementById("projectRequestTitle"+varProposalNo).innerText;
    const freelancerName = document.getElementById("freelancerName"+varProposalNo).innerText;
    const projectWorkPeriod = document.getElementById("projectWorkPeriod"+varProposalNo).innerText;
    const proposalPrice = document.getElementById("proposalPrice"+varProposalNo).innerText;
    const projectRequestStatus = document.getElementById("projectRequestStatus"+varProposalNo).innerText;
    const proposalEditNum = document.getElementById("proposalEditNum"+varProposalNo).innerText;
    const freelancerNo = document.getElementById("freelancerNo"+varProposalNo).innerText;
    const proposalNo = document.getElementById("proposalNo"+varProposalNo).innerText;
    const memberEmail = document.getElementById("memberEmail"+varProposalNo).innerText;
    const memberName = document.getElementById("memberName"+varProposalNo).innerText;
    const memberTel = document.getElementById("memberTel"+varProposalNo).innerText;
    const projectRequestNo = document.getElementById("projectRequestNo"+varProposalNo).innerText;
    const projectRequestSummary = document.getElementById("projectRequestSummary"+varProposalNo).innerText;
    const projectRequestContent = document.getElementById("projectRequestContent"+varProposalNo).innerText;
    const projectCreateDate = document.getElementById("projectCreateDate"+varProposalNo).innerText;
    const thirdCategoryNo = document.getElementById("thirdCategoryNo"+varProposalNo).innerText;
    const inputRequest = document.getElementById("tradeRequest").value;





    var IMP = window.IMP; // 생략가능
    IMP.init('imp13226416'); // 'iamport' 대신 부여받은 "가맹점 식별코드"를 사용
    var msg;


    IMP.request_pay({
        pg: 'kakaopay',
        pay_method: 'card',
        merchant_uid: 'merchant_' + new Date().getTime(), // 구매번호 
        name: '프매니저' + projectRequestTitle,
        amount: proposalPrice, //실제 결제되는 가격
        buyer_email: memberEmail,
        buyer_name: memberName,
        buyer_tel: memberTel,
        buyer_addr: '서울 강남구 도곡동',
        buyer_postcode: '123-456'
        //m_redirect_url : 'http://www.naver.com'
    }, function (rsp) {
        if (rsp.success) {
            
            console.log(inputRequest);
            //[1] 서버단에서 결제정보 조회를 위해 jQuery ajax로 imp_uid 전달하기
            $.ajax({
                url: "/service/payComplete/test"+proposalNo, //cross-domain error가 발생하지 않도록 주의해주세요
                type: 'POST',
                data: {
                    imp_uid: rsp.imp_uid,
                    "projectRequestTitle": projectRequestTitle,
                    "freelancerName": freelancerName,
                    "projectWorkPeriod": projectWorkPeriod,
                    "proposalPrice": proposalPrice,
                    "projectRequestStatus": projectRequestStatus,
                    "proposalEditNum": proposalEditNum,
                    "freelancerNo": freelancerNo,
                    "proposalNo": proposalNo,
                    "projectRequestNo":projectRequestNo,
                    "projectRequestSummary":projectRequestSummary,
                    "projectRequestContent":projectRequestContent,
                    "projectCreateDate":projectCreateDate,
                    "thirdCategoryNo":thirdCategoryNo,
                    "inputRequest":inputRequest
                }, success: (result) => {

                    console.log(result);
                    if (result > 0) {
                        //성공시 이동할 페이지
                        location.href = "/service/payComplete/" + result;
                    }
                    else {

                    }
                }


            });

        } else {
            msg = '결제에 실패하였습니다.';
            msg += '에러내용 : ' + rsp.error_msg;
            //실패시 이동할 페이지
            location.href = "<%=request.getContextPath()%>/order/payFail";
            alert(msg);
        }
    });

}


// $(document).on("click",'#suggestionName', () => {

//     if(proposal.proposalAdoptStatus != '대기 중'){

//         alert("이미 의뢰가 중지된 프로젝트입니다.");
//     }

// })