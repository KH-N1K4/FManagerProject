const body1 = document.getElementsByClassName('modal_body')[0];
const body2 = document.getElementsByClassName('modal_body')[1];

const modalClose1 = document.getElementsByClassName('modal_close1')[0];
const modalClose2 = document.getElementsByClassName('modal_close2')[0];

const modal1 = document.querySelector('.modal_addPortfolio');
const modal2 = document.querySelector('.modal_portfolioDetail');

const btnOpenPopup1 = document.getElementById('addPortfolioPopupBtn');
const btnOpenPopup2 = document.getElementById('portfolioDetailPopupBtn');

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

btnOpenPopup2.addEventListener('click', () =>{

    const writerName = document.getElementById("writerName").value;
    console.log(writerName);
    // location.href="/portfolioDetail/${portfolio.portfolioNo}"


    modal2.classList.toggle('show');
    modal2.style.display= 'block';
    if(modal2.classList.contains('show')){
        body2.style.display ='block';
        // body.style.overflow = 'hidden';
    }
})

modalClose2.addEventListener('click', ()=>{

    modal2.style.display ='none';
    // body.style.overflow='visible';
})