
const body1 = document.getElementsByClassName('modal_body')[0];
const body2 = document.getElementsByClassName('modal_body')[1];
const body3 = document.getElementsByClassName('modal_body')[2];

const body=document.querySelector("body");

const modalClose1 = document.getElementsByClassName('modal_close1')[0];
const modalClose2 = document.getElementsByClassName('modal_close2')[0];
const modalClose3 = document.getElementsByClassName('modal_close3')[0];
// const modalClose3 = document.querySelector('.modal_close3');

const modal1 = document.querySelector('.modal_major');
const modal2 = document.querySelector('.modal_career');
const modal3 = document.querySelector('.modal_license');


const btnOpenPopup1 = document.getElementById('majorPopup');
const btnOpenPopup2 = document.getElementById('careerPopup');
const btnOpenPopup3 = document.getElementById('licensePopup');

//------------------------------------------------------------------


btnOpenPopup1.addEventListener('click', () => {

  modal1.classList.toggle('show');
  modal1.style.display = 'block';   
  result1[0].focus();
  if (modal1.classList.contains('show')) {
     body1.style.display = 'block';
     body.style.overflow='hidden';
     
  }
});

modalClose1.addEventListener('click', () => {

    modal1.style.display = 'none';
    body.style.overflow='visible';

    result1[0].value="";
    result1[1].value="";
    result1[2].value="졸업";

});
//------------------------------------------------------------------

btnOpenPopup2.addEventListener('click', () => {
  modal2.classList.toggle('show');
  modal2.style.display = 'block';
  result2[0].focus();
  if (modal2.classList.contains('show')) {
    body2.style.display = 'block';
    body.style.overflow='hidden';
  }
});
modalClose2.addEventListener('click', () => {
  // modal2.classList.toggle('show');
 
  modal2.style.display = 'none';
  body.style.overflow='visible';

  result2[0].value="";
    result2[1].value="";
    result2[2].value="";
    result2[3].value="";
    careerCompanyPeriod1.value="-1";
    careerCompanyPeriod1.value="-1";

});
//------------------------------------------------------------------

btnOpenPopup3.addEventListener('click', () => {
  modal3.classList.toggle('show');
  modal3.style.display = 'block';
  result3[0].focus();
  if (modal3.classList.contains('show')) {
    body3.style.display = 'block';
    body.style.overflow='hidden';
  }
});
modalClose3.addEventListener('click', () => {
  // modal3.classList.toggle('show');
  modal3.style.display = 'none';
  body.style.overflow='visible';

  result3[0].value="";
  result3[1].value="";
  result3[2].value="";
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

const xBtn=document.getElementsByClassName("xbtn");

if(xBtn!=null){
  for(let single of xBtn){
    single.addEventListener("click",function(){
      // 클릭된 X버튼의 부모 요소(div.row)를 삭제 
      // 요소.remove() : 해당 요소를 제거 
      this.parentElement.remove();
    
    })
  }
}


sendContent1.addEventListener('click',function(e) {


  if(result1[0].value.trim().length==0||result1[1].value.trim().length==0){
    alert("값을 모두 입력해주세요");
  }else{
    if(document.getElementsByClassName("newOne")!=null){
      newOne=document.createElement("div");
      newOne.classList.add("newOne");
    }else{
      newOne=document.getElementsByClassName("newOne")[0];
    }
  
     const newText=document.createElement("input");
     newText.readOnly=true;
     const xBtn=document.createElement("span");
     xBtn.classList.add("xbtn");
     xBtn.innerHTML="&times;";
    
     newText.name="major";
     newText.classList.add("addContent");
     newText.value=result1[0].value+"/"+result1[1].value+"/"+result1[2].value;
     newOne.append(newText);
     newOne.append(xBtn);
     majorInput1.parentElement.append(newOne);
  
     result1[0].value="";
     result1[1].value="";
     result1[2].value="졸업";

     
 // span에 click 이벤트 동작 추가(동적 요소에 이벤트 추가)
    xBtn.addEventListener("click",function(){
    // 클릭된 X버튼의 부모 요소(div.row)를 삭제 
    // 요소.remove() : 해당 요소를 제거 
    this.parentElement.remove();
  
  })
  
  modal1.style.display='none';
  body.style.overflow='visible';
  }
});



const result2 = document.getElementsByClassName('input2');
const careerInput2 = document.getElementById('careerPopup');
const sendContent2 = document.getElementById('sendContent2');
const careerCompanyPeriod1 = document.getElementById('careerCompanyPeriod1');
const careerCompanyPeriod2 = document.getElementById('careerCompanyPeriod2');



sendContent2.addEventListener('click',function() {
  
    if(result2[0].value.trim().length==0||result2[1].value.trim().length==0
    ||result2[2].value.trim().length==0||result2[3].value.trim().length==0
    ||careerCompanyPeriod1.value==-1||careerCompanyPeriod2.value==-1){
      alert("값을 모두 입력해주세요");
    }else{
      const newOne=document.createElement("div");
      newOne.classList.add("newOne");
      
      const newText=document.createElement("input");
      newText.readOnly=true;
      const xBtn=document.createElement("span");
      xBtn.classList.add("xbtn");
      xBtn.innerHTML="&times;";
      
      newText.name="career";
      newText.classList.add("addContent");
      
      
      newText.value=result2[0].value+"/"+result2[1].value+"/"+result2[2].value+"/"+result2[3].value+"/"
      +careerCompanyPeriod1.value+"년"+careerCompanyPeriod2.value+"개월";
      
      
      newOne.append(newText);
      newOne.append(xBtn);
      careerInput2.parentElement.append(newOne);

      result2[0].value="";
      result2[1].value="";
      result2[2].value="";
      result2[3].value="";
      careerCompanyPeriod1.value="-1";
      careerCompanyPeriod1.value="-1";
      
      
      // span에 click 이벤트 동작 추가(동적 요소에 이벤트 추가)
      xBtn.addEventListener("click",function(){
        // 클릭된 X버튼의 부모 요소(div.row)를 삭제 
        // 요소.remove() : 해당 요소를 제거 
        this.parentElement.remove();
      })
      modal2.style.display='none';
      body.style.overflow='visible';

    }

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

    if(result3[0].value.trim().length==0||result3[1].value.trim().length==0
    ||result3[2].value.trim().length==0){
      alert("값을 모두 입력해주세요");
    }else{
      const newOne=document.createElement("div");
      newOne.classList.add("newOne");
    
       const newText=document.createElement("input");
       newText.readOnly=true;
       const xBtn=document.createElement("span");
       xBtn.classList.add("xbtn");
       xBtn.innerHTML="&times;";
      
       newText.name="license";
       newText.classList.add("addContent");
      newText.value=result3[0].value+"/"+result3[1].value+"/"+result3[2].value;
       newOne.append(newText);
       newOne.append(xBtn);
       licenseInput3.parentElement.append(newOne);
    


     result3[0].value="";
     result3[1].value="";
     result3[2].value="";

    
        // span에 click 이벤트 동작 추가(동적 요소에 이벤트 추가)
        xBtn.addEventListener("click",function(){
        // 클릭된 X버튼의 부모 요소(div.row)를 삭제 
        // 요소.remove() : 해당 요소를 제거 
        this.parentElement.remove();
    })
  
      modal3.style.display="none"
      body.style.overflow='visible';

    }
});

const checkObj={"area":false,
                "freelancerField":false,
                "bankCode":false,
                "bankAccountNumber":false,
            };




  const freelancerField=document.getElementsByName("freelancerField");
  const area=document.getElementById("area");
  const bankCode=document.getElementById("bankCode");
  document.getElementById("registerFrm").addEventListener("submit",function(event){


    for(let field of freelancerField){
        if(field.checked==true){
          checkObj.freelancerField=true;
          break;
        }else{
          checkObj.freelancerField=false;
        }
    }

    if(area.value>0){
      checkObj.area=true;
    }
    if(bankCode.value>0){
      checkObj.bankCode=true;
    }
     // 문자가 입력되지 않은 경우 
     if(bankAccountNumber.value.trim().length==0){
      checkObj.bankAccountNumber=false;
      return;
  }

    const regEx=/^\d{11,14}$/;

    if(regEx.test(bankAccountNumber.value)){ // 유효한 경우
        checkObj.bankAccountNumber=true;
    }else{
        checkObj.bankAccountNumber=false;
    }


    for(key in checkObj){
        let str;

        if(!checkObj[key]){
            switch(key){
                case "area": str="지역을 선택해주세요"; break;
                case "freelancerField": str="관심분야를 선택해주세요"; break;
                case "bankCode": str="은행을 선택해주세요"; break;
                case "bankAccountNumber": str="계좌번호가 유효하지 않습니다."; break;
            }

            alert(str); // 대화상자 출력 
            // 유효하지 않은 입력으로 포커스 이동 
            if(key!="freelancerField"){
              document.getElementById(key).focus();
            }
            
            event.preventDefault(); // 제출 이벤트 제거 
            return; // 함수 종료
        }
    }

})



// area.addEventListener("change",()=>{
//   if(area.value==0){
//     checkObj.area=false;
//   }else{
//     checkObj.area=true;
//   }
// });



const bankAccountNumber=document.getElementById("bankAccountNumber");

// bankCode.addEventListener("change",()=>{
//   if(bankCode.value==0){
//     checkObj.bankCode=false;
//   }else{
//     checkObj.bankCode=true;
//   }
// });

// bankAccountNumber.addEventListener("keydown",function(){
//     // 문자가 입력되지 않은 경우 
//     if(bankAccountNumber.value.trim().length==0){
//         checkObj.bankAccountNumber=false;
//         return;
//     }

//     const regEx=/^\d{12,14}$/;

//     if(regEx.test(bankAccountNumber.value)){ // 유효한 경우
//         checkObj.bankAccountNumber=true;
//     }else{
//         checkObj.bankAccountNumber=false;
//     }
// });


//-----------------------------------------------------------------------------------
/* 가입 최종로그인날짜 상세조회에서 달력 현재 날짜로 세팅하고 미래날짜는 선택 불가 */
/* document.getElementById('startDate').valueAsDate = new Date();  
document.getElementById('endtDate').valueAsDate = new Date(); */  

var now_utc = Date.now() // 지금 날짜를 밀리초로
// getTimezoneOffset()은 현재 시간과의 차이를 분 단위로 반환
var timeOff = new Date().getTimezoneOffset()*60000; // 분단위를 밀리초로 변환
// new Date(now_utc-timeOff).toISOString()은 '2022-05-11T18:09:38.134Z'를 반환
var today = new Date(now_utc-timeOff).toISOString().split("T")[0];
if(document.getElementById("licenseContent2") !=null){
  document.getElementById("licenseContent2").setAttribute("max", today);
}

