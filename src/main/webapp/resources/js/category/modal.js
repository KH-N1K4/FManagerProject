 const body = document.querySelector('body');
      const modal = document.querySelector('.modal');
      const modalClose = document.querySelector('.modal_close');
      const btnOpenPopup = document.querySelector('#askService');

      btnOpenPopup.addEventListener('click', () => {
        modal.classList.toggle('show');

        if (modal.classList.contains('show')) {
          body.style.overflow = 'hidden';
        }
      });
      modalClose.addEventListener('click', () => {
        modal.classList.toggle('show');

        if (modal.classList.contains('show')) {
          body.style.overflow = 'hidden';
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