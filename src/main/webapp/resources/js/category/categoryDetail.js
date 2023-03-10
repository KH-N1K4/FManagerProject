

const pauseBtn=document.getElementById("pauseService");

if(pauseBtn!=null){
	pauseBtn.addEventListener("click", (e)=>{
        if(confirm("정말로 중지하시겠습니까?")){
            alert("중지되었습니다.");
        }else{
            alert("중지가 취소되었습니다.");
            e.preventDefault();
        }
	});
}

 // 좋아요 버튼 클릭시 동작 
const boardLike=document.getElementById("boardLike");

boardLike.addEventListener("click", e=>{
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
            data:{"serviceNo":serviceNo, "memberNo":memberNo},
            type:"GET",
            success:(result)=>{ 
                if(result>0){ // 성공
                    e.target.classList.remove('fa-regular'); // 빈 하트 클래스 삭제
                    e.target.classList.add('fa-solid');// 채워진 하트 클래스 추가 
                    // likeCount.innerText=Number(likeCount.innerText)+1;

                }else{ // 실패 
                    console.log("증가실패");
                }
            },error:()=>{console.log("증가 에러");}
        });


    }else{ // 로그인 상태이면서 좋아요 상태인 경우 , 채워진 하트인 경우 
        $.ajax({
            url:"/boardLikeDown",
            data:{"serviceNo":serviceNo, "memberNo":memberNo},
            type:"GET",
            success:(result)=>{ 
                if(result>0){ // 성공
                    e.target.classList.add('fa-regular'); // 빈 하트 클래스 삭제
                    e.target.classList.remove('fa-solid');// 채워진 하트 클래스 추가 
                    // likeCount.innerText=Number(likeCount.innerText)-1;
                    
                }else{ // 실패 
                    console.log("감소 실패");
                }
            },error:()=>{console.log("감소 에러");}
        });
        

    }

})

const reportReview=document.getElementsByClassName("reportReview");

for(let report of reportReview){
    report.addEventListener("click",()=>{
        if(confirm("해당 리뷰를 신고하시겠습니까?")){
            $.ajax({
                url:"/reportReview",
                data:{"reviewNo":report.parentElement.id},
                type:"GET",
                success:(result)=>{ 
                    if(result>0){ // 성공
                        report.parentElement.parentElement.parentElement.children[1].innerText="신고된 리뷰입니다.";
                        alert("신고가 접수되었습니다.")
                    }else{ // 실패 
                        console.log("신고 실패");
                    }
                },error:()=>{console.log("신고 에러");}
            });
        }else{
            alert("신고가 취소되었습니다.");
        }
    })
}


const writeComment=document.getElementsByClassName("writeComment");
const freelancerName=document.getElementsByClassName("expertName")[0].children[0].innerText;
for(let comment of writeComment){
    comment.addEventListener("click",()=>{
        
        $.ajax({
            url:"/writeComment",
            data:{"reviewNo":comment.id,
            "reviewContent":comment.parentElement.children[0].value
            },
            type:"GET",
            success:(result)=>{ 
                if(result>0){ // 성공
                    comment.parentElement.parentElement.innerHTML
                    ='<div> <span class="freelancerName">'+freelancerName+' </span></div>'
                    +'<div class="responseContent">'+comment.parentElement.children[0].value+'</div>'
                }else{ // 실패 
                    console.log("댓글 달기 실패");
                }
            },error:()=>{console.log("댓글 달기 에러");}
        });
        
    })
}