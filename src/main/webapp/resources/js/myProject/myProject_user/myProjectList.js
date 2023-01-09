



function selectChange(){

    // 페이지 처리 구역 
        const pagination = document.querySelector(".pagination");
    // 생성할 구역을 포함하는 div
        const container = document.querySelector(".contain");
    // 생성할 구역 
        const content = document.querySelectorAll(".myProject_content");
    // 카테고리 selectBox
        const srchOption = document.getElementById("srchOption");
    // 진행상태 selectBox value
        const optionVal = (srchOption.options[srchOption.selectedIndex].value);


        $.ajax({
            url: '/member/categoryTypeSelect',
            type: 'GET',
            data: { 'optionVal': optionVal },
            success: (map) => {

                if (map != null) {

                    console.log(optionVal);
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

                    if( map.myProject.length != 0){  // 게시글이 존재할 때

                        for (myProject of map.myProject) {

                            const div = document.createElement("div");
                            div.setAttribute("class","myProject_content");
                            container.append(div);

                            const div1 = document.createElement("div");
                            div1.setAttribute("class","projuctContent_image");
                            div.append(div1);

                            const img = document.createElement("img");
                            img.setAttribute("src", myProject.requestFilePath);
                            div1.append(img);

                            const div2 = document.createElement("div");
                            div2.setAttribute("class","projuctContent_info");
                            div.append(div2);

                            const divdiv1 = document.createElement("div");
                            divdiv1.setAttribute("class","info_title");
                            div2.append(divdiv1);

                            const a = document.createElement("a");
                            a.setAttribute('href', "/projectRequest/projectRequestDetail/"+myProject.projectRequestNo);
                            divdiv1.append(a);

                            const span = document.createElement("span");
                            span.innerText= myProject.projectRequestTitle;
                            a.append(span);

                            const divdiv2 = document.createElement("div");
                            divdiv2.setAttribute("class","info_content");
                            div2.append(divdiv2);

                            const divdivdiv1 = document.createElement("div");
                            divdivdiv1.setAttribute("class","info_content_left");
                            divdiv2.append(divdivdiv1);

                            const divdivdivdiv1 = document.createElement("div");
                            divdivdivdiv1.setAttribute("class","info_content_list");
                            divdivdiv1.append(divdivdivdiv1);

                            const divdivdivdivdiv1 = document.createElement("div");
                            divdivdivdivdiv1.setAttribute("class","list_title");
                            divdivdivdiv1.append(divdivdivdivdiv1);

                            const span2 = document.createElement("span");
                            span2.innerText="모집분야";
                            divdivdivdivdiv1.append(span2);

                            const divdivdivdivdiv2 = document.createElement("div");
                            divdivdivdivdiv2.setAttribute("class","list_content");
                            divdivdivdiv1.append(divdivdivdivdiv2);

                            const divdivdivdivdivdiv1 = document.createElement("div");
                            divdivdivdivdivdiv1.setAttribute("class","main1category");
                            divdivdivdivdiv2.append(divdivdivdivdivdiv1);

                            const child1 = document.createElement("span");
                            child1.innerText= myProject.mainCategoryName;
                            divdivdivdivdivdiv1.append(child1);

                            const span3 = document.createElement("span");
                            span3.innerText=">";
                            divdivdivdivdiv2.append(span3);

                            const divdivdivdivdivdiv2 = document.createElement("div");
                            divdivdivdivdivdiv2.setAttribute("class","main3category");
                            divdivdivdivdiv2.append(divdivdivdivdivdiv2);

                            const child2 = document.createElement("span");
                            child2.innerText= myProject.thirdCategoryName;
                            divdivdivdivdivdiv2.append(child2);


                            const divdivdivdiv2 = document.createElement("div");
                            divdivdivdiv2.setAttribute("class","info_content_list");
                            divdivdiv1.append(divdivdivdiv2);

                            const divdivdivdivdiv3 = document.createElement("div");
                            divdivdivdivdiv3.setAttribute("class","list_title"); 
                            divdivdivdiv2.append(divdivdivdivdiv3);

                            const child3 = document.createElement("span");
                            child3.innerText= "예산";
                            divdivdivdivdiv3.append(child3);

                            const divdivdivdivdiv4 = document.createElement("div");
                            divdivdivdivdiv4.setAttribute("class","list_content"); 
                            divdivdivdiv2.append(divdivdivdivdiv4);

                            const child4 = document.createElement("span");
                            child4.innerText= myProject.projectRequestBudget;
                            divdivdivdivdiv4.append(child4);

                            const divdivdivdiv3 = document.createElement("div");
                            divdivdivdiv3.setAttribute("class","info_content_list");
                            divdivdiv1.append(divdivdivdiv3);

                            const divdivdivdivdiv5 = document.createElement("div");
                            divdivdivdivdiv5.setAttribute("class","list_title");  
                            divdivdivdiv3.append(divdivdivdivdiv5);


                            const child5 = document.createElement("span");
                            child5.innerText= "모집마감일";
                            divdivdivdivdiv5.append(child5);

                            const divdivdivdivdiv6 = document.createElement("div");
                            divdivdivdivdiv6.setAttribute("class","list_content");  
                            divdivdivdiv3.append(divdivdivdivdiv6);

                            const child6 = document.createElement("span");
                            child6.innerText= myProject.projectRecruitDate;
                            divdivdivdivdiv6.append(child6);



                            const divdivdiv2 = document.createElement("div");
                            divdivdiv2.setAttribute("class","info_content_right");
                            divdiv2.append(divdivdiv2);

                            const lastdiv = document.createElement("div");
                            lastdiv.setAttribute("class","signState");
                            divdivdiv2.append(lastdiv);

                            const lastSpan = document.createElement("span");
                            lastSpan.innerText=myProject.projectRequestStatus;
                            lastdiv.append(lastSpan);

                        }

                        // 페이징
                        const li1 = document.createElement("li");
                        const a1 = document.createElement("a");
                        a1.setAttribute('href', "/member/myProject/myRequestList?cp=1" + "&optionVal=" + optionVal);
                        a1.appendChild(document.createTextNode("<<"));
                        li1.append(a1);
                        pagination.append(li1);


                        const li2 = document.createElement("li");
                        const a2 = document.createElement("a");
                        a2.setAttribute("href", "/member/myProject/myRequestList?cp=" + map.pagination.prevPage + "&optionVal=" + optionVal);
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
                                a3.setAttribute("href", "/member/myProject/myRequestList?cp=" + i + "&optionVal=" + optionVal);
                                a3.appendChild(document.createTextNode(i));
                                li3.append(a3);
                                pagination.append(li3);
                            }
                        }

                        const li4 = document.createElement("li");
                        const a4 = document.createElement("a");
                        a4.setAttribute("href", "/member/myProject/myRequestList?cp=" + "&optionVal=" + optionVal);
                        a4.appendChild(document.createTextNode(">"));
                        li4.append(a4);
                        pagination.append(li4);

                        const li5 = document.createElement("li");
                        const a5 = document.createElement("a");
                        a5.setAttribute("href", "/member/myProject/myRequestList?cp=" + "&optionVal=" + optionVal);
                        a5.appendChild(document.createTextNode(">>"));
                        li5.append(a5);
                        pagination.append(li5);



                    } else{ // 게시글이 존재하지 않을 때 

                        const div = document.createElement("div");
                        div.setAttribute("class","myProject_content");
                        div.innerText = "등록된 프로젝트가 없습니다.";
                        container.append(div);

                    }






                }
            }

        })
            
}


// $(document).on("click",'#suggestionName', () => {

//     alert("이미 의뢰가 중지된 프로젝트입니다.");

// })