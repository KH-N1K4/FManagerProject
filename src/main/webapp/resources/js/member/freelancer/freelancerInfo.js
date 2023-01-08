const body1 = document.getElementsByClassName('modal_body')[0]; /* 포트폴리오추가 */
const body2 = document.getElementsByClassName('modal_body')[1]; /* 포트폴리오상세 */
const body=   document.querySelector('body'); /* 전문가정보 body */

const modalClose1 = document.getElementsByClassName('modal_close1')[0]; /* 포트폴리오추가 */
const modalClose2 = document.getElementsByClassName('modal_close2')[0]; /* 포트폴리오상세 */

const modal1 = document.querySelector('.modal_addPortfolio'); /* 포트폴리오추가 */
const modal2 = document.querySelector('.modal_portfolioDetail'); /* 포트폴리오상세 */

const btnOpenPopup1 = document.getElementById('addPortfolioPopupBtn'); /* 포트폴리오추가 */
const btnOpenPopup2 = document.getElementById('portfolioDetailPopupBtn'); /* 포트폴리오상세 */

//--------------------------------------------------------------------
btnOpenPopup1.addEventListener('click', () =>{

    modal1.classList.toggle('show');
    modal1.style.display= 'block';
    if(modal1.classList.contains('show')){
        body1.style.display ='block';
        // body.style.overflow = 'hidden';
    }
})


modalClose1.addEventListener('click', ()=>{

    modal1.style.display ='none';
    // body.style.overflow='visible';
    portfolioTitle.value='';
    portfolioContent.value='';
    document.getElementById('image-input1').value = null;
    document.getElementById('image-input2').value = null;
    fileName1.innerText='선택된 파일없음';
    fileName2.innerText='선택된 파일없음';
    

})

// btnOpenPopup2.addEventListener('click', () =>{

//     const writerName = document.getElementById("writerName").value;
//     console.log(writerName);
//     // location.href="/portfolioDetail/${portfolio.portfolioNo}"


//     modal2.classList.toggle('show');
//     modal2.style.display= 'block';
//     if(modal2.classList.contains('show')){
//         body2.style.display ='block';
//         // body.style.overflow = 'hidden';
//     }
// })




// 여기 주석해제하기
modalClose2.addEventListener('click', ()=>{

    modal2.style.display ='none';

    
})

const clickPortfolio = document.getElementsByClassName("portfolioSection");

const title = document.getElementsByClassName("portfolioTitle2")[0];
const summary = document.getElementsByClassName("portfolioContent2")[0];
const thumb = document.getElementById("portfolioThumb");
const photo = document.getElementById("portfolioPhoto");

for(let portfolio of clickPortfolio){
    portfolio.addEventListener("click", function() {
       
        // console.log(this.children[4].innerText);
        // console.log(this.children[5].innerText);
        title.innerText=this.children[5].innerHTML;
        summary.innerText=this.children[6].innerHTML;
        thumb.src=this.children[7].innerHTML;
        photo.src=this.children[8].innerHTML; 

        modal2.classList.toggle('show');
        modal2.style.display= 'block';
        body2.style.display ='block';
        body.style.overflow = 'hidden';
    } )
}


modalClose2.addEventListener('click', ()=>{

    modal2.style.display ='none';
    body.style.overflow='visible';
})

// var pNo = ${freelancer1.portfolioNo};

/* 포트폴리오 삭제 */
deletePortfolio();




function deletePortfolio(){
    const deleteBtn = document.querySelectorAll(".deleteBtn");

    for(d of deleteBtn){
        d.addEventListener('click', e => {
            const pNo =  e.target.parentElement.nextElementSibling.innerText;
            const fNo =  e.target.parentElement.nextElementSibling.nextElementSibling.innerText;
            if(confirm("정말로 삭제하시겠습니까?")){
                console.log(pNo);
                console.log(fNo);
                $.ajax({   
                    url : '/member/freelancer/deletePortfolio',
                    data: {pNo : pNo, fNo : fNo},
                    type: 'GET',
                    success: (result) =>{
                        if(result >0){
                            alert="포트폴리오 삭제 성공";
                            location.reload();

                        }else{
                            alert="포트폴리오 삭제 실패";
                        }
                    }
                });
            } else{
                return false;
            }

        });
    
}
}

function updatePortfolio(){
    const updateBtn = document.querySelectorAll(".updateBtn");

    for(u of updateBtn){
        u.addEventListener('click', e => {


            
            const pNo =  e.target.parentElement.nextElementSibling.innerText;
            const fNo =  e.target.parentElement.nextElementSibling.nextElementSibling.innerText;
            if(confirm("")){
                console.log(pNo);
                console.log(fNo);
                $.ajax({   
                    url : '/member/freelancer/updatePortfolio',
                    data: {pNo : pNo, fNo : fNo},
                    type: 'GET',
                    success: (result) =>{
                        if(result >0){
                        

                        }else{
                            
                        }
                    }
                });
            } else{
                return false;
            }

        });
    
}
}