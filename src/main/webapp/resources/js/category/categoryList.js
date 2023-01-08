

 // 좋아요 버튼 클릭시 동작 
const boardLike=document.getElementsByClassName("boardLike");


    for(like of boardLike){
        like.addEventListener("click", e=>{
            //alert(e.target.id);
    
            // 로그인 상태가 아닌 경우 
            // (전역변수 memberNo, boardNo 사용(boardDetail.jsp))
            if(memberNo==""){
                alert("로그인 후 이용해주세요.");
                return;
            }
        
            // const likeCount=e.target.nextElementSibling;
        
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






const index=document.getElementById("index");
const budget=document.getElementById("budget");
const grade=document.getElementById("grade");

const select=document.getElementsByClassName("select");
const pagination = document.querySelector(".pagination");
for(let each of select){
    each.addEventListener("change",function(){
        //alert("순서"+index.value+"예산"+budget.value+"전문가등급"+grade.value)

        // 비동기로 카테고리 리스트 조회
        const imageContent=document.getElementById("imageContent");
       
        // 리스트 이전 내용 삭제 
        imageContent.innerHTML="";
        pagination.innerHTML="";
    
        $.ajax({
            url:"/selectCategoryList",
            method:"GET",
            data:{"order": index.value, "budget":budget.value, "grade":grade.value,
            "mainCategoryNo":location.href.split('/')[(location.href.split('/').length-2)],
            "thirdCategoryNo":location.href.split('/')[(location.href.split('/').length-1)]
        },
            success:(map)=>{
                
                category(map)
            },
            error:()=>{
                console.log("조회 실패");
            }
        })
    })

}



function category(map){

    
    
    for(let content of map.serviceList){
        const bigdiv=document.createElement("div");

        const div=document.createElement("div"); 
        div.id="image";

        const div1=document.createElement("div");// 사진이랑 하트 들어가는 div
        const img=document.createElement("img");
        img.src=content.requestFilePath;

        const likeSpan=document.createElement("span");
        likeSpan.classList.add("like-area");
        likeSpan.innerHTML='';

    
        const emptyheart=document.createElement("i");
        emptyheart.classList.add("fa-regular");
        emptyheart.classList.add("fa-heart");
        emptyheart.classList.add("boardLike");
        emptyheart.id=content.serviceNo;


        const fullheart=document.createElement("i");
        fullheart.classList.add("fa-solid");
        fullheart.classList.add("fa-heart");
        fullheart.classList.add("boardLike");
        fullheart.id=content.serviceNo;

        if(content.likeCheckFL=='Y'){
            likeSpan.append(fullheart);
        }else if(content.likeCheckFL=='N'){
            likeSpan.append(emptyheart);
        }else{
            likeSpan.append(emptyheart);
        }

        div1.append(img);
        div1.append(likeSpan);

        const aTitle=document.createElement("a");
        //aTitle.href="/category/"+content.mainCategoryNo+"/"+content.subCategoryNo+"/"+content.thirdCategoryNo+"/"+content.serviceNo;
        aTitle.href="/service/"+content.serviceNo;
        aTitle.classList.add("imageTitle");

        const aa = document.createElement("span");
        aa.classList.add("aaa");
        aa.setAttribute("style","font-size:16px;");
        aa.innerHTML=content.serviceTitle;

        const spanOthers=document.createElement("span");
        spanOthers.classList.add("imageOthers");
        spanOthers.classList.add("aaa");
        spanOthers.innerHTML=content.serviceSummary;
        
        const spanPrice=document.createElement("span");
        spanPrice.classList.add("imageOthers");
        spanPrice.setAttribute("style","margin-bottom:0px; text-align:end; font-size:16px;");
        spanPrice.innerHTML=content.servicePriceString+" 원";
        
        const reviewPoint=document.createElement("span");
        reviewPoint.classList.add("imageOthers");
        reviewPoint.classList.add("right");
        const s1 = document.createElement("strong");
        s1.innerText="평점 ";
        const s2 = document.createElement("strong");
        s2.append(document.createTextNode("★ "+ content.reviewPoint))
        reviewPoint.append(s1);
        reviewPoint.append(document.createTextNode(" "))
        reviewPoint.append(s2);

        const sellCount=document.createElement("span");
        sellCount.classList.add("imageOthers");
        sellCount.classList.add("right");
        const s3 = document.createElement("strong");
        s3.innerHTML="판매수"
        const s4 = document.createElement("strong");
        s4.innerHTML=content.sellCount+" 회";
        sellCount.append(s3);
        sellCount.append(document.createTextNode(" "))
        sellCount.append(s4);



        aTitle.append(aa);
        aTitle.append(spanOthers);
        aTitle.append(spanPrice);
        aTitle.append(reviewPoint);
        aTitle.append(sellCount);

        div.append(div1);
        div.append(aTitle);

        bigdiv.append(div);

        imageContent.append(bigdiv);

        
        
        
        
        
    }
    /* 페이징 */


    const li1 = document.createElement("li");
    const a1 = document.createElement("a");
  //   a1.setAttribute('href', "/manager/memberList?cp=1"+"&value="+value);
    a1.setAttribute('href', "/manager/memberList?cp=1");
    a1.appendChild(document.createTextNode("<<"));
    li1.append(a1);
    pagination.append(li1);

    const li2 = document.createElement("li");
    const a2 = document.createElement("a");
  //   a2.setAttribute("href", "/manager/memberList?cp=" + map.pagination.prevPage+"&value="+value);
    a2.setAttribute("href", "?cp=" + map.pagination.prevPage);
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
          //   a3.setAttribute("href", "/manager/memberList?cp=" + i+"&value="+value);
            a3.setAttribute("href", "?cp=" + i);
            a3.appendChild(document.createTextNode(i));
            li3.append(a3);
            pagination.append(li3);
        }
    }

    const li4 = document.createElement("li");
    const a4 = document.createElement("a");
  //   a4.setAttribute("href", "/manager/memberList?cp=" + map.pagination.nextPage+"&value="+value);
    a4.setAttribute("href", "?cp=" + map.pagination.nextPage);
    a4.appendChild(document.createTextNode(">"));
    li4.append(a4);
    pagination.append(li4);

    const li5 = document.createElement("li");
    const a5 = document.createElement("a");
  //   a5.setAttribute("href", "/manager/memberList?cp=" + map.pagination.maxPage+"&value="+value);
    a5.setAttribute("href", "?cp=" + map.pagination.maxPage);
    a5.appendChild(document.createTextNode(">>"));
    li5.append(a5);
    pagination.append(li5);

   

    for(like of boardLike){
        like.addEventListener("click", e=>{
            //alert(e.target.id);
    
            // 로그인 상태가 아닌 경우 
            // (전역변수 memberNo, boardNo 사용(boardDetail.jsp))
            if(memberNo==""){
                alert("로그인 후 이용해주세요.");
                return;
            }
        
            // const likeCount=e.target.nextElementSibling;
        
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

