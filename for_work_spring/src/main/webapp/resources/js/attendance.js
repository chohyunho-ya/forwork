

var attendanceService = (function(){
		function drawGraph(ago,id){
			console.log('ago : ' + ago);
			google.charts.load('current', {packages: ['corechart', 'bar']});
		 	google.charts.setOnLoadCallback(drawAxisTickColors);
		 	
		 	function drawAxisTickColors(){
		 	   	var data = new google.visualization.DataTable();
		 	   	data.addColumn('string','day');
		 	   	data.addColumn('number','근무시간');
		 	   	data.addRows([
			         ['월요일', 0],            
		 	         ['화요일', 0],            
		 	         ['수요일', 0],
		 	         ['목요일', 0],
		 	         ['금요일', 0],
		 	         ['토요일', 0],
		 	         ['일요일', 0]
		 	   	]);
		 	   	$.ajax({
		 	   		url:"/attendance/getWeek/"+ago+"/"+id,
		 	   		method : "get",
		 	   		success:function(week){
		 	   			for(var i = 0; i < week.length; i++){
		 	   				for(var j = 0; j < 7; j++){
		  	   					if(week[i].week == data.getValue(j, 0)){
		 	   						data.setValue(j, 1, week[i].workTime);
		 	   					} 
		 	   				}
		 	   			}

		 	 
		 				var options = {
		 						title : '주간 근무 현황 ',
		 						colors :['blue']
		 					};
		 				
		 				var chart = new google.visualization.ColumnChart(document.getElementById('chart_div'));
		 				chart.draw(data, options);
		 				setWeek(ago);
		 	   		}
		 	   	})
		 
			};
		
		};
		
		function today(){
			var now = new Date();
			var month = now.getMonth()+1;
			var date = now.getDate();
			month = month >=10 ? month : "0" + month;
			date  = date  >= 10 ? date : "0" + date;
			$('#today').html(month+"월 "+date+"일");
		}
		


		function setting(){
			printTime();
			today();
		}
		
		return {
			drawGraph : drawGraph,
			setting:setting
		};

		
	})();
	
	
	var ago = 0;
	
 $(function(){
		$("#previous").on("click", function(e) {
			e.preventDefault();
			ago += 1;
			attendanceService.drawGraph(ago,id);
			setWeek(ago);
		})
		$("#next").on("click", function(e) {
			e.preventDefault();
			ago -= 1;
			attendanceService.drawGraph(ago,id);
			setWeek(ago);
		})
	
	 attendanceService.drawGraph(ago,id);
	 attendanceService.setting;
	 
	  $("button").click(function(e) {	
	 		var check = window.prompt($(this).val()+"하시려면 "+$(this).val()+"을 입력해주세요", "");
			//출근 또는 퇴근 실행
			if(check == $(this).val()){
				if(check == "출근"){
					e.preventDefault();
					$.ajax({
						url:"/attendance/commute/"+id,
						method:"post",
						success:function(str){
							if(str == 'success'){
								printTime();
							}
						}
					})
					
				}else{
					if($("#commute").html() != "-"){
						e.preventDefault();
						
						$.ajax({
							url:"/attendance/off/"+id,
							method:"post",
							success:function(str){
								if(str == 'success'){
									printTime();
								}
							}
						})
					}else{
						alert("아직 출근하지 않았습니다.");
					}
				}
			}else{
				alert("잘못된 입력입니다.")}
		})
	});

 

 	function setWeek(ago){
		// getDay시 0 : 일 1 : 월 ~ 6 : 토
		var now = new Date();
		var mon = new Date();
		var sun = new Date();
		var day = parseInt(now.getDay());

		// mon를 월요일로 변경
		if (day > 0) {
			mon.setDate(now.getDate() - (day - 1) - (7 * ago));
		} else {
			mon.setDate(now.getDate() - 6 - (7 * ago));
		}
		sun.setTime(mon.getTime() + 518400000);

		var sMonth = mon.getMonth() + 1;
		var sDay = mon.getDate();
		sDay = sDay >= 10 ? sDay : "0" + sDay;
		var eMonth = sun.getMonth() + 1;
		var eDay = sun.getDate();
		eDay = eDay >= 10 ? eDay : "0" + eDay;

		var str = sMonth + '.' + sDay + ' ~ ' + eMonth + '.' + eDay;

		$("#weekdays").html(str);
	}
 	


		


		
	
		
	$(function(){
 		printTime();
		})
		
	function printTime(){
			$.ajax({
				url:"/attendance/getTime/"+id,
				method:"get",
				success:function(time){

					if (time != null) {
						var commuteTime = time.commute == null ? ''
								: time.commute;
						var offTime = time.off == null ? '' : time.off;
						if (commuteTime != '') {
							$("#commute").html(commuteTime);
						} else {
							$("#commute").html("-");
						}

						if (offTime != '') {
							$("#off").html(offTime);
						} else {
							$("#off").html("-");
						}
					}else{
						$("#commute").html("-");
						$("#off").html("-");
					}
				}
			});
		}