 // 좋아요 버튼 클릭시 동작 
 const boardLike=document.getElementsByClassName("boardLike");


 for(like of boardLike){
     like.addEventListener("click", e=>{
         
         // 로그인 상태이면서 좋아요 상태가 아닌 경우 
         if(e.target.classList.contains('fa-regular')){ // 빈하트인 경우 
     
             $.ajax({
                 url:"/boardLikeUp",
                 data:{"serviceNo":e.target.id, "memberNo":memberNo},
                 type:"GET",
                 success:(result)=>{ 
                     if(result>0){ // 성공
                         e.target.classList.remove('fa-regular'); // 빈 하트 클래스 삭제
                         e.target.classList.add('fa-solid');// 채워진 하트 클래스 추가 
                         //likeCount.innerText=Number(likeCount.innerText)+1;
                         alert("찜 목록에 추가되었습니다.");
                     }else{ // 실패 
                         console.log("증가실패");
                     }
                 },error:()=>{console.log("증가 에러");}
             });
     
     
         }else{ // 로그인 상태이면서 좋아요 상태인 경우 , 채워진 하트인 경우 
             $.ajax({
                 url:"/boardLikeDown",
                 data:{"serviceNo":e.target.id, "memberNo":memberNo},
                 type:"GET",
                 success:(result)=>{ 
                     if(result>0){ // 성공
                         e.target.classList.add('fa-regular'); // 빈 하트 클래스 삭제
                         e.target.classList.remove('fa-solid');// 채워진 하트 클래스 추가 
                         //likeCount.innerText=Number(likeCount.innerText)-1;
                         alert("찜 목록에서 삭제되었습니다.");
                         
                     }else{ // 실패 
                         console.log("감소 실패");
                     }
                 },error:()=>{console.log("감소 에러");}
             });
             
     
         }
     
     })
 
 }


function selectChange(){
    const listOption = document.getElementById("listOption")
    const category = (listOption.options[listOption.selectedIndex].value);
    const imageContent = document.getElementById('imageContent');
    const pagination = document.querySelector(".pagination");

    $.ajax({
        url: '/member/myInfo/likeList/type',
        type: 'GET',
        data: { 'category': category },
        success: (map) =>{
            if(map!=null){
                const options=listOption.childNodes;
                for(o of options){
                    if(o.value==category){
                        o.setAttribute("selected", true);
                    }
                }

                const before = document.querySelectorAll('#image');
                for (b of before) {
                    b.remove();
                }
                
                if(document.querySelector('.pagination')!=null){

                    document.querySelector('.pagination').innerHTML = "";
                } 

                if(map.likeList.length!=0){

                    for (service of map.likeList) {
                        
                        const div1 = document.createElement("div");
                        div1.setAttribute("id","image");

                        const div2 = document.createElement("div");

                        const img1 = document.createElement("img");
                        img1.setAttribute("src",service.requestFilePath);

                        const span1 = document.createElement("span");
                        span1.classList.add("like-area");

                        const i1 = document.createElement("i");
                        i1.classList.add("fa-solid");
                        i1.classList.add("fa-heart");
                        i1.classList.add("boardLike");
                        i1.setAttribute("id",service.serviceNo);
                        span1.append(i1);
                        
                        div2.append(img1);
                        div2.append(span1);

                        const a1=document.createElement("a");
                        a1.setAttribute("href","/service/"+service.serviceNo);
                        a1.classList.add("imageTitle");
                        a1.append(document.createTextNode(service.serviceTitle));

                        const span2 = document.createElement("span");
                        span2.classList.add("imageOthers");
                        span2.append(document.createTextNode(service.serviceSummary))
                        const span3 = document.createElement("span");
                        span3.classList.add("imageOthers");
                        span3.append(document.createTextNode("가격: "+service.servicePrice))
                        a1.append(span2);
                        a1.append(span3);

                        div1.append(div2);
                        div1.append(a1);

                        imageContent.append(div1);
    
                    }
    

                    /* 페이징 */


                    const li1 = document.createElement("li");
                    const a1 = document.createElement("a");
                    a1.setAttribute('href', "/member/myInfo/likeList?cp=1"+"&value="+category);
                    a1.appendChild(document.createTextNode("<<"));
                    li1.append(a1);
                    pagination.append(li1);

                    const li2 = document.createElement("li");
                    const a2 = document.createElement("a");
                    a2.setAttribute("href", "/member/myInfo/likeList?cp=" + map.pagination.prevPage+"&value="+category);
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
                            a3.setAttribute("href", "/member/myInfo/likeList?cp=" + i+"&value="+category);
                            a3.appendChild(document.createTextNode(i));
                            li3.append(a3);
                            pagination.append(li3);
                        }
                    }

                    const li4 = document.createElement("li");
                    const a4 = document.createElement("a");
                    a4.setAttribute("href", "/member/myInfo/likeList?cp=" + map.pagination.nextPage+"&value="+category);
                    a4.appendChild(document.createTextNode(">"));
                    li4.append(a4);
                    pagination.append(li4);

                    const li5 = document.createElement("li");
                    const a5 = document.createElement("a");
                    a5.setAttribute("href", "/member/myInfo/likeList?cp=" + map.pagination.maxPage+"&value="+category);
                    a5.appendChild(document.createTextNode(">>"));
                    li5.append(a5);
                    pagination.append(li5);
                

                    const boardLike=document.getElementsByClassName("boardLike");


                    for(like of boardLike){
                        like.addEventListener("click", e=>{
                            
                            // 로그인 상태이면서 좋아요 상태가 아닌 경우 
                            if(e.target.classList.contains('fa-regular')){ // 빈하트인 경우 
                        
                                $.ajax({
                                    url:"/boardLikeUp",
                                    data:{"serviceNo":e.target.id, "memberNo":memberNo},
                                    type:"GET",
                                    success:(result)=>{ 
                                        if(result>0){ // 성공
                                            e.target.classList.remove('fa-regular'); // 빈 하트 클래스 삭제
                                            e.target.classList.add('fa-solid');// 채워진 하트 클래스 추가 
                                            //likeCount.innerText=Number(likeCount.innerText)+1;
                                            alert("찜 목록에 추가되었습니다.");
                                        }else{ // 실패 
                                            console.log("증가실패");
                                        }
                                    },error:()=>{console.log("증가 에러");}
                                });
                        
                        
                            }else{ // 로그인 상태이면서 좋아요 상태인 경우 , 채워진 하트인 경우 
                                $.ajax({
                                    url:"/boardLikeDown",
                                    data:{"serviceNo":e.target.id, "memberNo":memberNo},
                                    type:"GET",
                                    success:(result)=>{ 
                                        if(result>0){ // 성공
                                            e.target.classList.add('fa-regular'); // 빈 하트 클래스 삭제
                                            e.target.classList.remove('fa-solid');// 채워진 하트 클래스 추가 
                                            //likeCount.innerText=Number(likeCount.innerText)-1;
                                            alert("찜 목록에서 삭제되었습니다.");
                                            
                                        }else{ // 실패 
                                            console.log("감소 실패");
                                        }
                                    },error:()=>{console.log("감소 에러");}
                                });
                                
                        
                            }
                        
                        })
                    
                    }

                    }




            }
        }
    });




}










