
const body2 = document.getElementsByClassName('modal_body')[0];
const body3 = document.getElementsByClassName('modal_body')[1];

const modalClose2 = document.getElementsByClassName('modal_close2')[0];
const modalClose3 = document.getElementsByClassName('modal_close3')[0];
// const modalClose3 = document.querySelector('.modal_close3');

const modal2 = document.querySelector('.modal_career');
const modal3 = document.querySelector('.modal_license');


// const btnOpenPopup = document.querySelector('#licensePopup');
const btnOpenPopup2 = document.getElementById('careerPopup');
const btnOpenPopup3 = document.getElementById('licensePopup');

//------------------------------------------------------------------

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
const result2 = document.getElementsByClassName('input2');
const careerInput2 = document.getElementById('careerPopup');
const sendContent2 = document.getElementById('sendContent2');



sendContent2.addEventListener('click',function() {
  const test2 = $("#careerCompanyPeriod1 option:selected").text();
  const test3 = $("#careerCompanyPeriod2 option:selected").text();
  
  // for(let i = 0; i < result2.length-2; i++) {
  //   careerInput2.value += result2[i].value +',';
  // }
  // careerInput2.value += test2+" ";  // ?년 [4]
  // careerInput2.value += test3;     // ?개월 [5]


  // if(licenseInput2.value.trim().length != 0){
    //   freelancerCont.value += 
    //   licenseInput2.value.split(',')[4].split('년')[0];
    
    // }
    
    
    
    
    const newOne=document.createElement("div");
    newOne.classList.add("newOne");
    
    const newText=document.createElement("input");
    const xBtn=document.createElement("span");
    xBtn.classList.add("xbtn");
    xBtn.innerHTML="&times;";
    
    newText.name="career";
    newText.classList.add("addContent");
    
    
    newText.value=result2[0].value+"/"+result2[1].value+"/"+result2[2].value+"/"+result2[3].value+"/"+test2+test3;
    
    
    newOne.append(newText);
    newOne.append(xBtn);
    careerInput2.parentElement.append(newOne);
    
    
    // span에 click 이벤트 동작 추가(동적 요소에 이벤트 추가)
    xBtn.addEventListener("click",function(){
      // 클릭된 X버튼의 부모 요소(div.row)를 삭제 
      // 요소.remove() : 해당 요소를 제거 
      this.parentElement.remove();
    })
    modal2.style.display='none';
  });

const result3 = document.getElementsByClassName("input3"); // 모달창의 input들
const licenseInput3 = document.getElementById("licensePopup"); // 전문가등록의 자격증input칸
const sendContent3 = document.getElementById("sendContent3"); // 모달창 제출 버튼

sendContent3.addEventListener("click", function(){

    // for(let i =0; i<result3.length-1; i++){
    // document.getElementById("licensePopup").value +=   result3[i].value  +',';
    // if(licenseInput3[i].value = 1){
    //   result3[i].innerText
    // }
   // }
    //licenseInput3.value += result3[2].value;
    // document.getElementById("licensePopup").value = result.value;


    const newOne=document.createElement("div");
    newOne.classList.add("newOne");
  
     const newText=document.createElement("input");
     const xBtn=document.createElement("span");
     xBtn.classList.add("xbtn");
     xBtn.innerHTML="&times;";
    
     newText.name="license";
     newText.classList.add("addContent");
    newText.value=result3[0].value+"/"+result3[1].value+"/"+result3[2].value;
     newOne.append(newText);
     newOne.append(xBtn);
     licenseInput3.parentElement.append(newOne);
  
  
      // span에 click 이벤트 동작 추가(동적 요소에 이벤트 추가)
      xBtn.addEventListener("click",function(){
      // 클릭된 X버튼의 부모 요소(div.row)를 삭제 
      // 요소.remove() : 해당 요소를 제거 
      this.parentElement.remove();
  })

    modal3.style.display="none"
});


