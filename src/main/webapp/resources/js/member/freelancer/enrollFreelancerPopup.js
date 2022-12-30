
const body1 = document.getElementsByClassName('modal_body')[0];
const body2 = document.getElementsByClassName('modal_body')[1];
const body3 = document.getElementsByClassName('modal_body')[2];

const modalClose1 = document.getElementsByClassName('modal_close1')[0];
const modalClose2 = document.getElementsByClassName('modal_close2')[0];
const modalClose3 = document.getElementsByClassName('modal_close3')[0];
// const modalClose3 = document.querySelector('.modal_close3');

const modal1 = document.querySelector('.modal_major');
const modal2 = document.querySelector('.modal_career');
const modal3 = document.querySelector('.modal_license');


// const btnOpenPopup = document.querySelector('#licensePopup');
const btnOpenPopup1 = document.getElementById('majorPopup');
const btnOpenPopup2 = document.getElementById('careerPopup');
const btnOpenPopup3 = document.getElementById('licensePopup');

//------------------------------------------------------------------
btnOpenPopup1.addEventListener('click', () => {
  modal1.classList.toggle('show');
  modal1.style.display = 'block'; 
  if (modal1.classList.contains('show')) {
    body1.style.display = 'block';
    // body1.style.overflow='hidden';
  }
});

modalClose1.addEventListener('click', () => {
  // modal1.classList.toggle('show');

modal1.style.display = 'none';
  // if (modal1.classList.contains('show')) {
  //   body1.style.display = 'none';
  // }
});
//------------------------------------------------------------------

btnOpenPopup2.addEventListener('click', () => {
  modal2.classList.toggle('show');
  modal2.style.display = 'block';

  if (modal2.classList.contains('show')) {
    body2.style.display = 'block';
  }
});
modalClose2.addEventListener('click', () => {
  // modal2.classList.toggle('show');
 
  modal2.style.display = 'none';
// modal2.style.backgroundColor='transparent';

  // if (modal2.classList.contains('show')) {
  //   body2.style.display = 'none';
  // }
});
//------------------------------------------------------------------

btnOpenPopup3.addEventListener('click', () => {
  modal3.classList.toggle('show');
  modal3.style.display = 'block';

  if (modal3.classList.contains('show')) {
    body3.style.display = 'block';
  }
});
modalClose3.addEventListener('click', () => {
  // modal3.classList.toggle('show');
  modal3.style.display = 'none';
  // modal3.style.backgroundColor='transparent';

  // if (modal3.classList.contains('show')) {
  //   body3.style.display = 'none';
  // }
});

//------------------------------------------------------------------

// document.addEventListener('DOMContentLoaded',()=>{


// })

//
const result1 = document.getElementsByClassName('input1');
const select1 = document.getElementById('graduateStatus');
const majorInput1 = document.getElementById('majorPopup');
const sendContent1 = document.getElementById('sendContent1');

// const select = document.getElementById('graduateStatus');
// const value = select.value;
// const text = select.options[select.selectedIndex].text;

// const allOptions = Array.from(select.options).map(option => option.value);


sendContent1.addEventListener('click',function() {
  const test1 = $("#graduateStatus option:selected").text()
  // console.log($(".graduateStatus option:selected").text());
  document.getElementById('majorStatus').value = $("#graduateStatus option:selected").val(); // input hidden값
  for(let i = 0; i < result1.length-1; i++) {
    majorInput1.value += result1[i].value +',';
  }
  majorInput1.value += test1;
  modal1.style.display='none';
});



const result2 = document.getElementsByClassName('input2');
const careerInput2 = document.getElementById('careerPopup');
const sendContent2 = document.getElementById('sendContent2');



sendContent2.addEventListener('click',function() {
  const test2 = $("#careerCompanyPeriod1 option:selected").text();
  const test3 = $("#careerCompanyPeriod2 option:selected").text();
  
  for(let i = 0; i < result2.length-2; i++) {
    careerInput2.value += result2[i].value +',';
  }
  careerInput2.value += test2+" ";  // ?년 [4]
  careerInput2.value += test3;     // ?개월 [5]

  modal2.style.display='none';
  if(careerInput2.value.trim().length != 0){
    freelancerCont.value += 
    careerInput2.value.split(',')[4].split('년')[0];

  }
});

const result3 = document.getElementsByClassName("input3"); // 모달창의 input들
const licenseInput3 = document.getElementById("licensePopup"); // 전문가등록의 자격증input칸
const sendContent3 = document.getElementById("sendContent3"); // 모달창 제출 버튼

sendContent3.addEventListener("click", function(){
    for(let i =0; i<result3.length-1; i++){
    document.getElementById("licensePopup").value +=   result3[i].value  +',';
    // if(licenseInput3[i].value = 1){
    //   result3[i].innerText
    // }
    }
    licenseInput3.value += result3[2].value;
    // document.getElementById("licensePopup").value = result.value;
    modal3.style.display="none"
});


