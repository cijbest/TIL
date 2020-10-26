<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<style>
#container1, #container2{
	width:100%;
	height:500px;
	border:2px solid gray;
}
</style>

<script>
function display2(data){
	Highcharts.chart('container2', {
	    chart: {
	        type: 'area'
	    },
	    accessibility: {
	        description: 'Image description: An area chart compares the nuclear stockpiles of the USA and the USSR/Russia between 1945 and 2017. The number of nuclear weapons is plotted on the Y-axis and the years on the X-axis. The chart is interactive, and the year-on-year stockpile levels can be traced for each country. The US has a stockpile of 6 nuclear weapons at the dawn of the nuclear age in 1945. This number has gradually increased to 369 by 1950 when the USSR enters the arms race with 6 weapons. At this point, the US starts to rapidly build its stockpile culminating in 32,040 warheads by 1966 compared to the USSR’s 7,089. From this peak in 1966, the US stockpile gradually decreases as the USSR’s stockpile expands. By 1978 the USSR has closed the nuclear gap at 25,393. The USSR stockpile continues to grow until it reaches a peak of 45,000 in 1986 compared to the US arsenal of 24,401. From 1986, the nuclear stockpiles of both countries start to fall. By 2000, the numbers have fallen to 10,577 and 21,000 for the US and Russia, respectively. The decreases continue until 2017 at which point the US holds 4,018 weapons compared to Russia’s 4,500.'
	    },
	    title: {
	        text: 'RPM Data Chart'
	    },
	    subtitle: {
	        text: ''
	    },
	    xAxis: {
	        allowDecimals: false,
	        labels: {
	            formatter: function () {
	                return this.value; // clean, unformatted number for year
	            }
	        },
	        accessibility: {
	            rangeDescription: '2020-09'
	        }
	    },
	    yAxis: {
	        title: {
	            text: 'Amount'
	        },
	        labels: {
	            formatter: function () {
	                return this.value / 1000 + 'rpm';
	            }
	        }
	    },
	    tooltip: {
	        pointFormat: '{series.name} had stockpiled <b>{point.y:,.0f}</b><br/>warheads in {point.x}'
	    },
	    plotOptions: {
	        area: {
	            pointStart: 1940,
	            marker: {
	                enabled: false,
	                symbol: 'circle',
	                radius: 2,
	                states: {
	                    hover: {
	                        enabled: true
	                    }
	                }
	            }
	        }
	    },
	    series: data
	});
}
function display1(data){
	Highcharts.chart('container1', {

	    chart: {
	        type: 'column'
	    },

	    title: {
	        text: 'Car Data Chart'
	    },

	    subtitle: {
	        text: 'speed, temp, oiltemp'
	    },

	    legend: {
	        align: 'right',
	        verticalAlign: 'middle',
	        layout: 'vertical'
	    },

	    xAxis: {
	        categories: ['09-26', '09-27', '09-28'],
	        labels: {
	            x: -10
	        }
	    },

	    yAxis: {
	        allowDecimals: false,
	        title: {
	            text: 'Amount'
	        }
	    },

	    series: data,

	    responsive: {
	        rules: [{
	            condition: {
	                maxWidth: 500
	            },
	            chartOptions: {
	                legend: {
	                    align: 'center',
	                    verticalAlign: 'bottom',
	                    layout: 'horizontal'
	                },
	                yAxis: {
	                    labels: {
	                        align: 'left',
	                        x: 0,
	                        y: -5
	                    },
	                    title: {
	                        text: null
	                    }
	                },
	                subtitle: {
	                    text: null
	                },
	                credits: {
	                    enabled: false
	                }
	            }
	        }]
	    }
	});

	

}

function getData(){
	$.ajax({
		url:'getdata.mc',
		success:function(data){
			display1(data);
		},
		error:function(){}
	});
	$.ajax({
		url:'getdata2.mc',
		success:function(data){
			display2(data);
		},
		error:function(){}
	});
}

$(document).ready(function(){
	getData();
	//display(1);
});
</script>

<div id="container1">

</div>
<div id="container2">

</div>