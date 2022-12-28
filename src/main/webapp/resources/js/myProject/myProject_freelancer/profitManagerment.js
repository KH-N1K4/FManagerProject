const ctx = document.getElementById('myChart');
const d = new Date();
var arr = new Array();
let num = 0;
for(var i=12; i>=0; i--){
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
        label: '총수익(원)',
        data:  [3000, 1000, 5000, 6000, 10000,3000, 1000, 5000, 6000, 10000,10000,10000,20000],
        backgroundColor: 'rgb(54, 162, 235)'
      }/* ,
      {
        label: '예상수익(원)',
        data: [1000, 500, 2000, 3000, 5000,1000, 500, 2000, 3000, 5000,2000,2000],
        backgroundColor: 'rgb(255, 205, 86)',
      } */
    ]
  },
  options: {
    scales: {
      y: {
        beginAtZero: true
      }
    }
  }

});

/* 
const labels = Utils.months({count: 7});
const data = {
  labels: labels,
  datasets: [
    {
      label: 'Dataset 1',
      data: Utils.numbers(NUMBER_CFG),
      borderColor: Utils.CHART_COLORS.red,
      backgroundColor: Utils.transparentize(Utils.CHART_COLORS.red, 0.5),
    },
    {
      label: 'Dataset 2',
      data: Utils.numbers(NUMBER_CFG),
      borderColor: Utils.CHART_COLORS.blue,
      backgroundColor: Utils.transparentize(Utils.CHART_COLORS.blue, 0.5),
    }
  ]
};

const config = {
  type: 'bar',
  data: data,
  options: {
    responsive: true,
    plugins: {
      legend: {
        position: 'top',
      },
      title: {
        display: true,
        text: 'Chart.js Bar Chart'
      }
    }
  }
};

new Chart(
  document.getElementById('myChart'),
  config
);

const actions = [
  {
    name: 'Randomize',
    handler(chart) {
      chart.data.datasets.forEach(dataset => {
        dataset.data = Utils.numbers({count: chart.data.labels.length, min: -100, max: 100});
      });
      chart.update();
    }
  },
  {
    name: 'Add Dataset',
    handler(chart) {
      const data = chart.data;
      const dsColor = Utils.namedColor(chart.data.datasets.length);
      const newDataset = {
        label: 'Dataset ' + (data.datasets.length + 1),
        backgroundColor: Utils.transparentize(dsColor, 0.5),
        borderColor: dsColor,
        borderWidth: 1,
        data: Utils.numbers({count: data.labels.length, min: -100, max: 100}),
      };
      chart.data.datasets.push(newDataset);
      chart.update();
    }
  },
  {
    name: 'Add Data',
    handler(chart) {
      const data = chart.data;
      if (data.datasets.length > 0) {
        data.labels = Utils.months({count: data.labels.length + 1});

        for (let index = 0; index < data.datasets.length; ++index) {
          data.datasets[index].data.push(Utils.rand(-100, 100));
        }

        chart.update();
      }
    }
  },
  {
    name: 'Remove Dataset',
    handler(chart) {
      chart.data.datasets.pop();
      chart.update();
    }
  },
  {
    name: 'Remove Data',
    handler(chart) {
      chart.data.labels.splice(-1, 1); // remove the label first

      chart.data.datasets.forEach(dataset => {
        dataset.data.pop();
      });

      chart.update();
    }
  }
];

 */