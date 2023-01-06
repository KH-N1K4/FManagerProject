

function selectChange(){

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

                if( map != null){
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

                    if( map.proposal.length != 0){  // 게시글이 존재할 때
                        

                        for (proposal of map.proposal) {

                            const tr = document.createElement("tr");
                            tr.setAttribute("class","suggestionTable");
                            tr.setAttribute("id","suggestionTable");
                            tbody.append(tr);
    
                            const td1 = document.createElement("td");
                            td1.setAttribute("class" , "tc");
                            tr.append(td1);

                            const span1 = document.createElement("span");
                            span1.setAttribute("class" , "num");
                            span1.innerText = proposal.proposalNo;      
                            td1.append(span1);

                            const td2 = document.createElement("td");
                            td2.setAttribute("class" , "tl");
                            tr.append(td2);

                            const div1 = document.createElement("div");
                            div1.setAttribute("class","suggestion_name_area td_link");
                            td2.append(div1);

                            const a = document.createElement("a");
                            a.setAttribute("class","suggestionName");
                            a.setAttribute("href","#");
                            a.setAttribute("id","suggestionName");
                            a.innerText = proposal.projectRequestTitle;
                            div1.append(a);

                            const td3 = document.createElement("td");
                            td3.setAttribute("class" , "tc");
                            tr.append(td3);

                            const div2 = document.createElement("div");
                            div2.setAttribute("class","expert_name_area td_link");
                            td3.append(div2);

                            const a2 = document.createElement("a");
                            a2.setAttribute("class","expertName");
                            a2.setAttribute("href","#");
                            a2.setAttribute("id","expertName");
                            a2.innerText = proposal.freelancerName;
                            div2.append(a2);

                            const td4 = document.createElement("td");
                            td4.setAttribute("class" , "tc");
                            tr.append(td4);

                            const span2 = document.createElement("span");
                            span2.setAttribute("class","text");
                            span2.innerText = proposal.gradeName;
                            td4.append(span2);

                            const td5 = document.createElement("td");
                            td5.setAttribute("class" , "tc");
                            tr.append(td5);

                            const span3 = document.createElement("span");
                            span3.setAttribute("class","text");
                            span3.innerText = proposal.proposalPrice + "원";
                            td5.append(span3);

                            const td6 = document.createElement("td");
                            td6.setAttribute("class" , "tc");
                            tr.append(td6);

                            const span4 = document.createElement("span");
                            span4.setAttribute("class","num");
                            span4.innerText = proposal.proposalEditNum +"/5";
                            td6.append(span4);

                            const td7 = document.createElement("td");
                            td7.setAttribute("class" , "tc");
                            td7.setAttribute("id" , "proposalStatus");
                            tr.append(td7);

                            const span5 = document.createElement("span");
                            span5.setAttribute("class","text");
                            span5.innerText = proposal.proposalAdoptStatus;
                            td7.append(span5);

                            const td8 = document.createElement("td");
                            td8.setAttribute("class" , "tc");
                            tr.append(td8);

                            const button = document.createElement("button");
                            button.setAttribute("id","chooseBtn");
                            button.setAttribute("class","chooseBtn btn_type");
                            button.innerText = "채택";
                            td8.append(button);

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


                    } else{ // 게시글이 존재하지 않을 때 

                        const tr = document.createElement("tr");
                        tr.setAttribute("class","suggestionTable");
                        tbody.append(tr);

                        const td = document.createElement("td");
                        td.setAttribute("colspan" , "8");
                        td.innerText ="받은 제안이 없습니다.";
                        tr.append(td);
                    }




































                }
            } 

        })
}






























const suggestionTable = document.getElementById("suggestionTable");


// document.getElementById("chooseBtn").addEventListener("click", e=>{

//     // 확인을 클릭할 경우
//     if(confirm("해당 제안을 채택하시겠습니까?")){

//         $.ajax({

//             url : '/member/myProject/myReceiveList',
//             type : 'POST',
//             data : { 'inputComment': inputComment,
//                         'memberNo': memberNo},
//             success : (result) => {

//                 if(result != null) {
//                     document.getElementById("proposalStatus").remove();
//                     const th = document.createElement("th");
//                     const span = document.createElement("span");
//                     th.setAttribute("class","tc");
//                     // th.setAttribute("id","proposalStatus");
//                     span.setAttribute("class","text");
//                     // span.innerText = 'proposalAdoptStatus'; 
//                     suggestionTable.append("th");
//                     th.append("span");
//                 }

//             },
//             error:()=>{

//                 console.log("채택 실패");
//             }

//         })

//     // 취소를 클릭할 경우
//     } else{
//         e.preventDefault();
//     }

// });



