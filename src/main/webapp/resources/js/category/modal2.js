 const body = document.querySelector('body');
const modal = document.querySelector('.modal');
const modalClose = document.querySelector('.modal_close');
const btnOpenPopup = document.querySelectorAll('.askService');


const serviceTitle=document.getElementById("serviceTitle");
const serviceSummary=document.getElementById("serviceSummary");
const serviceInquiryContent=document.getElementById("serviceInquiryContent");

for(btn of btnOpenPopup){


  btn.addEventListener('click', (e) => {
     serviceTitle.innerText=e.target.nextElementSibling.value; // 타이틀 
     serviceSummary.innerText=e.target.nextElementSibling.nextElementSibling.value;
     serviceInquiryContent.innerText=e.target.nextElementSibling.nextElementSibling.nextElementSibling.value;




    modal.classList.toggle('show');

     if (modal.classList.contains('show')) {
       body.style.overflow = 'hidden';
     }

  //   $.ajax({
  //     url:"/member/myInfo/sendSuggestionContent",
  //     data:{"serviceInquiryNo":btn.id},
  //     type:"GET",
  //     success:(askView)=>{
        
        
  //        console.log(askView);

          
  //     },
  //     error:()=>{
  //         console.log("조회 실패");
  //     }
  // })

  });

  
}

modalClose.addEventListener('click', () => {
  modal.classList.toggle('show');

  if (!modal.classList.contains('show')) {
    body.style.overflow = 'visible';
  }
});



   




      

      // modal.addEventListener('click', (event) => {
      //   if (event.target === modal) {
      //     modal.classList.toggle('show');

      //     if (!modal.classList.contains('show')) {
      //       body.style.overflow = 'auto';
      //     }
      //   }
      // });