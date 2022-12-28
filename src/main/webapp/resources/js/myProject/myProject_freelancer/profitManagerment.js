
const ctx = document.getElementById('myChart');
const d = new Date();
var arr = new Array();
let num = 0;
for(var i=11; i>=0; i--){
  const agodate = (new Date(d.getFullYear(), d.getMonth()-i,d.getDate()));
  const year =agodate.getFullYear();
  const months =agodate.getMonth()+1;
  const agodate2 = year+"-"+months;
  arr[num] = agodate2;
  num =num+1;
}

new Chart(ctx, {

  type: 'line',
  data: {
    labels: arr,
    datasets: [
      {
        label: '총 수익(원)',
        data:  [3000, 5000, 6000, 10000,3000, 1000, 5000, 6000, 10000,10000,10000,20000],
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

