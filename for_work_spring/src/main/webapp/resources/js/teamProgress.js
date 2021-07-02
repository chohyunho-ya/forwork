		//var project_id = 1;

console.log("teamProgress Module 실행.....!!!");

function drawColumnProgress(project_id) {
	
	var columnCounts = $.ajax({
		type : 'get',
		url : '/pmPage/'+project_id+'/getColumnPr.json',
		dataType : "json",
        async : false
	}).responseText;
	
	console.log("columnCounts: " + JSON.parse(columnCounts).storiesCount +"/" + JSON.parse(columnCounts).todoCount);
	
	//var data = new google.visualization.DataTable(columnCounts);

	

      var data = google.visualization.arrayToDataTable([
        ['Columns', 'Task개수', { role: 'style' }],
        ['Stories', JSON.parse(columnCounts).storiesCount,'#DC3545'],
        ['To-do', JSON.parse(columnCounts).todoCount,'#FFC107'],
        ['Doing', JSON.parse(columnCounts).doingCount,'#17A2B8'],
        ['Done', JSON.parse(columnCounts).doneCount,'#007BFF']
      ]);

      var options = {
        title: '< 프로젝트 컬럼별 진행률 >',
        height : 300,
        width : 500,
        legend: 'none',
        hAxis: {
        	title: '총 Task 개수',
            viewWindow: {
                min: Math.floor(0),
                max: Math.ceil(JSON.parse(columnCounts).totalCount)
            }
        },
        titleTextStyle:{
        	fontSize: 18
        }
      };

      var chart = new google.visualization.BarChart(document.getElementById('columns_chart'));

      chart.draw(data, options);
    }

function totalProgress(project_id) {
	
	var columnCounts = $.ajax({
		type : 'get',
		url : '/pmPage/'+project_id+'/getColumnPr.json',
		dataType : "json",
        async : false
	}).responseText;

    // Create the data table.
    var data = new google.visualization.DataTable();
    data.addColumn('string', 'Uncompleted');
    data.addColumn('number', 'completed');
    data.addRows([
      ['Uncompleted', 1-(JSON.parse(columnCounts).doneCount/JSON.parse(columnCounts).totalCount)],
      ['completed', (JSON.parse(columnCounts).doneCount/JSON.parse(columnCounts).totalCount)]
    ]);

    // Set chart options
    var options = {
    		 title: '< 프로젝트 전체 진행률 >',
    		  pieHole: 0.41,  // 도넛차트	 
    		  width: 600,
    		  height: 500,
    		  colors: ['#DC3545','#007BFF'],
    		  titleTextStyle:{
    			  fontSize: 18
    	        }
    }
    // Instantiate and draw our chart, passing in some options.
    var chart2 = new google.visualization.PieChart(document.getElementById('total_chart'));
    chart2.draw(data, options);
  
}

// 개인별 진행률 구글차트로 그리기
function drawPersonalProgress(project_id) {
	
	$.ajax({
		type : 'get',
		url : '/pmPage/'+project_id+'.json',
		data : {},
        success : function(data) {
        	console.log(data);
        	
        	var str ="";
        	
			for(i in data){
				
				var personalChartDiv = $("#personal_chart");
				var personalChartId = "personalChart"+i;
				console.log(personalChartId + "/" + data[i].name);
				
				var arr = [
					['progress','Completed','Uncompleted'],
					['progress',data[i].doneCount,data[i].totalCount-data[i].doneCount]
				];
				
				var datas = new google.visualization.arrayToDataTable(arr);


				      var options = {
				       // title: data[i].name+'의 진행률',
				        height : 50,
				        width : 400,
				        bar : {groupWidth:'30%'},
				        hAxis: {
				        	title: '총 Task 개수',
				            viewWindow: {
				                min: Math.floor(0),
				                max: Math.ceil(data[i].totalCount)
				            }
				        },
				        isStacked: true
				      };

				      var chart = new google.visualization.BarChart(document.getElementById(personalChartId));
				      console.log(chart);
				      chart.draw(datas, options);
				     console.log(data[i].name+"의 그래프 그렸다.");

					}
			}
			
		
	});
    }







