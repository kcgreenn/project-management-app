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
      backgroundColor: ["darkslategray", "tomato", "#3cba91"],
      data: countData,
    }]
  };

  const config = {
    type: 'doughnut',
    data: data,
    options: {
		title: {
			display: true,
			text: 'Project Statuses',
			color: 'black',
			fullSize: true,
			position: 'top',	
		}
}
  };
  
  const myChart = new Chart(
    document.getElementById('myDoughnutChart'),
    config
  );
 