<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ include file="header.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/fullcalendar@5.7.0/main.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.min.js"></script>
<!-- 부트스트랩 4.x를 사용한다. -->
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>

<script type="text/javascript"
		src="https://cdn.jsdelivr.net/npm/fullcalendar@5.7.0/main.min.js"></script>

<title>Insert title here</title>
<style type="text/css">
#calendar {
	max-width: 1100px;
	margin: 40px auto;
}
</style>
</head>
<body>
	<div id='calendar'></div>
	<%@ include file="calendarModal.jsp"%>


	<script type="text/javascript">
		var project_id = window.location.href;
		project_id = project_id.substr(project_id.lastIndexOf('/')+1);
			
		function dateFormat(date){
			var year = date.getFullYear();
			var month = date.getMonth()+1;
			month = month >= 10 ? month : '0' + month;
			var day = date.getDate();
			day = day >= 10 ? day : '0' + day;
			return year+"-"+month+"-"+day;
		}
	
	
		document.addEventListener('DOMContentLoaded', function() {
			var calendarEl = document.getElementById('calendar');
			var calendar = new FullCalendar.Calendar(calendarEl, {
				timeZone : 'UTC',
				initialView : 'dayGridMonth',
				displayEventTime: false,
			    headerToolbar: {
			        center: 'addEventButton'
			    },
			    eventClick: function(info) {
			    	var modal = $("#calendarModal");
	            	$("#addCalendar").html("수정");
	            	$("#calendar_content").val(info.event.title);
	            	$("#calendar_start_date").val(dateFormat(info.event.start));
	            	$("#calendar_end_date").val(dateFormat(info.event.end));
	            	if($("#deleteCalendar").html() == undefined)
		            	$("#addCalendar").after('<button type="button" class="btn btn-danger" id="deleteCalendar">삭제</button>')
	            	
	            	modal.modal("show");
	            	
	            	$("#addCalendar").on("click",function(){
	            		var content = $("#calendar_content").val();
	            		var start = $("#calendar_start_date").val();
	            		var start_date = new Date(start);
	            		var end = $("#calendar_end_date").val();
	            		var end_date = new Date(end);

	            		 if(content ==""){
	            			 alert("일정 내용을 입력해주세요.");
	            		 }else if(isNaN(start_date) || isNaN(end_date)){
	            			 alert("날짜를 입력해주세요.");
	            		 }
            			 else if(end_date - start_date < 0){
	            			 alert("종료 날짜가 시작 날짜보다 이전입니다.");			            			 
	            		 }else{
	            			var obj = {
	            				 "calendar_content":content,
           						 "calendar_start_date":start_date,
        						 "calendar_end_date":end_date,
        						 "calendar_id": info.event.id
        						 };
	            			$.ajax({
	            				url : "/calendar/update",
	            				method : "POST",
	            				contentType:"application/json",
	            				data : JSON.stringify(obj),
	            				success:function(data){
	            					if(data == "success"){
		            					alert("수정되었습니다.");
					            		 modal.modal("hide");
					            		 window.location.reload();
	            					}
	            					else
	            						alert("실패하였습니다.");
	            				}
	            			});
	            		}
	            	}); //update event end
	            	
	            	$("#deleteCalendar").on("click",function(){
	            		var result = window.prompt("삭제를 원하시면 '삭제'를 입력해주세요.");
	            		if(result == "삭제"){
	            			$.ajax({
	            				url:"/calendar/delete/"+info.event.id,
	            				method:"delete",
	            				success : function(data){
	            					if(data == "success"){
	            						alert("정상적으로 삭제되었습니다.")
	            						modal.modal("hide");
	            						window.location.reload();
	            					}
	            				}
	            			});
	            		}
	            		else
	            			return;
	            	});
	            	
	            	


			    },
			    customButtons: {
			         addEventButton: {
			        	text : "일정 추가",
			             click:function(){
			            	 var modal = $("#calendarModal");
			            	 modal.modal("show");
			            	 $("#addCalendar").on("click",function(){
			            		 var start = $("#calendar_start_date").val();
			            		 var start_date = new Date(start);
			            		 var end = $("#calendar_end_date").val();
			            		 var end_date = new Date(end);
			            		 var content = $("#calendar_content").val();
			            		 if(content ==""){
			            			 alert("일정 내용을 입력해주세요.");
			            		 }else if(isNaN(start_date) || isNaN(end_date)){
			            			 alert("날짜를 입력해주세요.");
			            		 }
		            			 else if(end_date - start_date < 0){
			            			 alert("종료 날짜가 시작 날짜보다 이전입니다.");			            			 
			            		 }
			            		 else{
			            			 var cal = {
			            					 "calendar_content":content,
			            					 "calendar_start_date":start,
			            					 "calendar_end_date":end,
			            					 "project_id":project_id
			            			 }
			            			 console.log(cal);
			            			 $.ajax({
			            				 url:"/calendar/add",
			            				 method:"POST",
			            				 contentType:"application/json",
			            				 data:JSON.stringify(cal),
			            				 success:function(data){
			            					 alert("추가되었습니다.");
						            		 modal.modal("hide");
						            		 window.location.reload();
			            				 }
			            			 })

			            		 }
			            	 });
			            	
			             }
			     	}
			     },
				editable : true,
				selectable : true,
				events: "http://localhost:8081/calendar/get/"+project_id+".json"
			});
			calendar.render();			
		});
		
		
	</script>
	
</body>
</html>

<%@ include file="footer.jsp"%>