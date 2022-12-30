
const ctx = document.getElementById('myChart');
const d = new Date();
var arr = new Array();
var arrProfit = new Array();
let num = 0;
for(var i=11; i>=0; i--){
  const agodate = (new Date(d.getFullYear(), d.getMonth()-i,d.getDate()));
  const year =agodate.getFullYear();
  const months =agodate.getMonth()+1;
  const agodate2 = year+"-"+months;
  arr[num] = agodate2;
  var booleanVal = false;
  profitList.forEach(function(arg){
    if(arg.paymentDateString == agodate2){
      arrProfit[num] = arg.paymentPrice;
      booleanVal = true;
    };
    if(booleanVal == false){
      arrProfit[num] = 0;
    }
  });
  num =num+1;
  booleanVal == false;
}

var typeChart = 'line';
var booleanVal2 = 'false';
$('#container_button').click(function(){
  if(typeChart === 'line'){
    typeChart = 'bar'
    console.log(typeChart);
  }else{
    typeChart = 'line'
  }
  booleanVal2 = 'true';
  /* $('.myChart').remove(); */
  const canvas = document.createElement("canvas"); //div 자식
  /* canvas.setAttribute("id","myChart");
  console.log(typeChart); */
  canvas.getContext("2d").clearRect(0, 0, canvas.width, canvas.height);
  new Chart(ctx, {

    type: typeChart,
    data: {
      labels: arr,
      datasets: [
        {
          label: '총 수익(원)',
          data:  arrProfit,
          backgroundColor: 'rgb(253, 98, 93)',
          borderColor:'rgb(253, 98, 93)',
          borderWidth: 3,
          pointBackgroundColor:'rgb(253, 98, 93)',
          pointBorderColor:'rgb(253, 98, 93)',
          pointBorderWidth: 3,
          hoverBorderWidth: 5,
          fill:false,
          tension: 0
        }/* ,
        {
          label: '예상수익(원)',
          data: [1000, 500, 2000, 3000, 5000,1000, 500, 2000, 3000, 5000,2000,2000],
          backgroundColor: 'rgb(255, 205, 86)','rgb(54, 162, 235)'
        } */
      ]
    },
    options: {
      scales: {
        y: {
          beginAtZero: true
        }
      },
      legend: {
        labels: {
            fontColor: 'black',
            fontSize: 10
        }
      },
      plugins: {
        tooltip: {
          enabled: true
        }
      }
    }
  
  });
  /* document.getElementById('middleBox').append(canvas); */
});

if(booleanVal2 == 'false'){
  new Chart(ctx, {

    type: typeChart,
    data: {
      labels: arr,
      datasets: [
        {
          label: '총 수익(원)',
          data:  arrProfit,
          backgroundColor: 'rgb(253, 98, 93)',
          borderColor:'rgb(253, 98, 93)',
          borderWidth: 3,
          pointBackgroundColor:'rgb(253, 98, 93)',
          pointBorderColor:'rgb(253, 98, 93)',
          pointBorderWidth: 3,
          hoverBorderWidth: 5,
          fill:false,
          tension: 0
        }/* ,
        {
          label: '예상수익(원)',
          data: [1000, 500, 2000, 3000, 5000,1000, 500, 2000, 3000, 5000,2000,2000],
          backgroundColor: 'rgb(255, 205, 86)','rgb(54, 162, 235)'
        } */
      ]
    },
    options: {
      scales: {
        y: {
          beginAtZero: true
        }
      },
      legend: {
        labels: {
            fontColor: 'black',
            fontSize: 10
        }
      },
      plugins: {
        tooltip: {
          enabled: true
        }
      }
    }
  
  });
}



/* 가입 최종로그인날짜 상세조회에서 달력 현재 날짜로 세팅하고 미래날짜는 선택 불가 */
/* document.getElementById('startDate').valueAsDate = new Date();  
document.getElementById('endtDate').valueAsDate = new Date(); */  

var now_utc = Date.now() // 지금 날짜를 밀리초로
// getTimezoneOffset()은 현재 시간과의 차이를 분 단위로 반환
var timeOff = new Date().getTimezoneOffset()*60000; // 분단위를 밀리초로 변환
// new Date(now_utc-timeOff).toISOString()은 '2022-05-11T18:09:38.134Z'를 반환
var today = new Date(now_utc-timeOff).toISOString().split("T")[0];
document.getElementById("startDate").setAttribute("max", today); //min날짜를 today로 하면 어제 날짜부터 선택 불가
document.getElementById("endtDate").setAttribute("max", today);

window.onload = function(){

  /* 옵션 선택값으로 세팅 */
  var startDate = document.getElementById("startDate").title;
  $("#startDate").val(startDate).prop('selected', true);

  /* 옵션 선택값으로 세팅 */
  var endtDate = document.getElementById("endtDate").title;
  $("#endtDate").val(endtDate).prop('selected', true);

};

