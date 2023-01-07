const body1 = document.getElementsByClassName('modal_body')[0];
const body2 = document.getElementsByClassName('modal_body')[1];

const modalClose1 = document.getElementsByClassName('modal_close')[0];


const modal1 = document.querySelector('.modal_portfolioDetail');

const clickPortfolio=document.getElementsByClassName("portfolioPhoto");


const title=document.getElementById("portfolioTitle");
const summary=document.getElementById("portfolioContent");
const thumb=document.getElementById("portfolioThumb");
const photo=document.getElementById("portfolioPhoto");
//--------------------------------------------------------------------

for(let portfolio of clickPortfolio){
    portfolio.addEventListener('click', function(){

        title.innerText=this.children[1].innerHTML;
        summary.innerText=this.children[2].innerHTML;
        thumb.src=this.children[3].innerHTML;
        photo.src=this.children[4].innerHTML;
    
        modal1.classList.toggle('show');
        modal1.style.display= 'block';
        body1.style.display ='block';
        body.style.overflow = 'hidden';
        
        // if(modal.classList.contains('show')){
        // }
    })
    
    modalClose1.addEventListener('click', ()=>{
    
        modal1.style.display ='none';
        body.style.overflow='visible';
    })

}
