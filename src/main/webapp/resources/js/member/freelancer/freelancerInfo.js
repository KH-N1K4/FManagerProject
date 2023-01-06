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

modalClose2.addEventListener('click', ()=>{

    modal2.style.display ='none';
    // body.style.overflow='visible';
})

const clickPortfolio = document.getElementsByClassName("portfolioSection");




for(let portfolio of clickPortfolio){
    portfolio.addEventListener("click", function() {
        const title = document.getElementsByClassName("portfolioTitle2")[0];
        const summary = document.getElementsByClassName("portfolioContent2")[0];
        const thumb = document.getElementById("portfolioThumb");
        const photo = document.getElementById("portfolioPhoto");
        // console.log(this.children[4].innerText);
        // console.log(this.children[5].innerText);
        title.innerText=this.children[4].innerHTML;
        summary.innerText=this.children[5].innerHTML;
        thumb.src=this.children[6].innerHTML;
        photo.src=this.children[7].innerHTML; 

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