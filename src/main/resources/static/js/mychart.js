// Convert json data to readable format
function decodeHtml(html) {
	const text = document.createElement("textarea");
	text.innerHTML = html;
	return text.value;	
}

const chartDataStr = decodeHtml(chartData);
const chartDataArray = JSON.parse(chartDataStr);

const countData = [];
const labels = [];

chartDataArray.forEach((chartDatum) => {
	countData.push(chartDatum.value);
	labels.push(chartDatum.label);
});

  const data = {
    labels: labels,
    datasets: [{
      label: 'Project Stage',
      backgroundColor: ["limegreen", "tomato", "darkslategray"],
      data: countData,
    }]
  };

  const config = {
    type: 'doughnut',
    data: data,
    options: {
		responsive: true,
		plugins:{
			legend:{
				position:'top'
			},
			title: {
				display: true,
				text: 'Project Status',
			},
		},
	}
  };
  
  const myChart = new Chart(
    document.getElementById('myDoughnutChart'),
    config
  );
 