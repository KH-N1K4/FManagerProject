// const body = document.querySelector('body');
//     const modal = document.querySelector('.modal');
//     const modalClose = document.querySelector('.modal_close');
//     const OpenPopup = document.getElementById("licensePopup");

//     OpenPopup.addEventListener("click", () =>{
//         modal.classList.toggle('show');

//         if(modal.classList.contains('show')){
//             body.style.overflow = 'hidden';
//         }
//     });
//     modalClose


// //  클릭시 Modal창으로 출력하기
// licensePopup.addEventListener("click",  function(){
//     // window.open("license.jsp", "_black", "popup");
//     // window.open("/freelancer/modal/license.jsp", "popupWindow", "popup");
//     window.open("/freelancer/modal/license", "popupWindow", "popup");


// })

// (() => {
//     const licensePopup = document.getElementsByClassName("modal");

//     if(licensePopup.length >0){

//         const modal = document.querySelector(".modal");
//         // const modalClose = document.getElementById("modal-close");

//         //버튼에 클릭이벤트 추가?
//     }

// })();

const body = document.querySelector('body');
const modalClose = document.querySelector('.modal_close');

const modal = document.querySelector('.modal_license');
const btnOpenPopup = document.querySelector('#licensePopup');

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

// const result = document.querySelector(".input"); // 모달창의 input들
const result = document.querySelectorAll(".input"); // 모달창의 input들
const licenseInput = document.getElementById("licensePopup"); // 전문가등록의 자격증input칸
const sendContent = document.getElementById("sendContent"); // 모달창 제출 버튼

sendContent.addEventListener("click", function(){
    for(var i =0; i<result.length; i++){
    document.getElementById("licensePopup").value +=   result[i].value 
    }
    // document.getElementById("licensePopup").value = result.value;
    modal.style.display="none"
})