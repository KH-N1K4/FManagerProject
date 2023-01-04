

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

for(let each of select){
    each.addEventListener("change",function(){
        //alert("순서"+index.value+"예산"+budget.value+"전문가등급"+grade.value)

        // 비동기로 카테고리 리스트 조회
        const imageContent=document.getElementById("imageContent");
        // 리스트 이전 내용 삭제 
        imageContent.innerHTML="";
    
        $.ajax({
            url:"/selectCategoryList",
            method:"GET",
            data:{"order": index.value, "budget":budget.value, "grade":grade.value,
            "mainCategoryNo":location.href.split('/')[(location.href.split('/').length-2)],
            "thirdCategoryNo":location.href.split('/')[(location.href.split('/').length-1)]
        },
            success:CategoryList=>{
                
                category(CategoryList)
            },
            error:()=>{
                console.log("조회 실패");
            }
        })
    })

}



function category(CategoryList){

    console.log(CategoryList);

    
    for(let content of CategoryList){
        const bigdiv=document.createElement("div");

        const div=document.createElement("div"); 
        div.id="image";

        const div1=document.createElement("div");// 사진이랑 하트 들어가는 div
        const img=document.createElement("img");
        img.src=content.requestFilePath;

        const likeSpan=document.createElement("span");
        likeSpan.class="like-area";
        likeSpan.innerHTML='';

        // const cif1=document.createElement("c:if");
        // cif1.test=""; // 로그인된 멤버가 없을 때

        // const cif2=document.createElement("c:if");
        // cif2.test="ㅇㅇㅇㅇ"; // 로그인된 멤버가 있을 때

        // const cif3=document.createElement("c:if");
        // cif3.test='content.likeCheckFL=="N"'; // 로그인된 멤버가 있을 때+찜하지 않았을 때 

        // const emptyheart=document.createElement("i");
        // emptyheart.classList.add("fa-regular");
        // emptyheart.classList.add("fa-heart");
        // emptyheart.classList.add("boardLike");
        // emptyheart.id=content.serviceNo;

        // const cif4=document.createElement("c:if");
        // cif4.test=(content.likeCheckFL=="Y"); // 로그인된 멤버가 있을 때+찜했을 때 
        // const fullheart=document.createElement("i");
        // fullheart.classList.add("fa-solid");
        // fullheart.classList.add("fa-heart");
        // fullheart.classList.add("boardLike");
        // fullheart.id=content.serviceNo;

        // cif3.append(emptyheart);
        // cif4.append(fullheart);
        // cif2.append(cif3);
        // cif2.append(cif4);

        // likeSpan.append(cif1);
        // likeSpan.append(cif2);
        
        // 새로고침했을 때 하트 어떻게 나오게 하는가..

        div1.append(img);
        div1.append(likeSpan);

        const aTitle=document.createElement("a");
        //aTitle.href="/category/"+content.mainCategoryNo+"/"+content.subCategoryNo+"/"+content.thirdCategoryNo+"/"+content.serviceNo;
        aTitle.href="/service/"+content.serviceNo;
        aTitle.classList.add("imageTitle");
        aTitle.innerHTML=content.serviceTitle;

        const spanOthers=document.createElement("span");
        spanOthers.classList.add("imageOthers");
        spanOthers.innerHTML=content.serviceSummary;

        const spanPrice=document.createElement("span");
        spanPrice.classList.add("imageOthers");
        spanPrice.innerHTML="가격:"+content.servicePrice+"원";
        
        aTitle.append(spanOthers);
        aTitle.append(spanPrice);

        div.append(div1);
        div.append(aTitle);

        bigdiv.append(div);

        imageContent.append(bigdiv);
    }

}