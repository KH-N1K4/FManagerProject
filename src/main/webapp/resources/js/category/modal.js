 const body = document.querySelector('body');
      const modal = document.querySelector('.modal');
      const modalClose = document.querySelector('.modal_close');
      const btnOpenPopup = document.querySelector('#askService');


     
   if(btnOpenPopup!=null){
     btnOpenPopup.addEventListener('click', () => {
     
      if(memberNo==""){
     alert("로그인 후 이용 가능합니다.");
     location.href="/member/login";
   }else{
     modal.classList.toggle('show');

       if (modal.classList.contains('show')) {
         body.style.overflow = 'hidden';
       }
   }
   
     
   });
 
 
 
 modalClose.addEventListener('click', () => {
   modal.classList.toggle('show');

   if (!modal.classList.contains('show')) {
     body.style.overflow = 'visible';
   }
 });

   }

      

      // modal.addEventListener('click', (event) => {
      //   if (event.target === modal) {
      //     modal.classList.toggle('show');

      //     if (!modal.classList.contains('show')) {
      //       body.style.overflow = 'auto';
      //     }
      //   }
      // });