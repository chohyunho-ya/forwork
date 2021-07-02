<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ include file="header.jsp"%>
<html>
<head>
<meta charset="UTF-8">

<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css"
	integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l"
	crossorigin="anonymous">

<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.1/font/bootstrap-icons.css">
<!-- Optional JavaScript; choose one of the two! -->

<!-- Option 1: jQuery and Bootstrap Bundle (includes Popper) -->
<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<!-- <script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-Piv4xVNRyMGpqkS2by6br4gNJ7DXjqk09RmUpJ8jgGtD7zP9yug3goQfGII0yAns"
	crossorigin="anonymous"></script> -->
	
<!-- 캘린더 -->
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/fullcalendar@5.7.0/main.min.css">
<script type="text/javascript"
	src="https://cdn.jsdelivr.net/npm/fullcalendar@5.7.0/main.min.js"></script>	
<script>
	document.addEventListener('DOMContentLoaded', function() {
		var calendarEl = document.getElementById('calendar');
		var calendar = new FullCalendar.Calendar(calendarEl, {
			initialView : 'timeGridWeek',
			slotDuration: '1:00',
			allDay : true,
			allDayText: '일정',
			events: "http://localhost:8081/calendar/getWeek/1.json"
		});
		calendar.setOption('height',270);
		calendar.render();
	});
</script>

<!-- 구글차트-->
<script type="text/javascript"
	src="https://www.gstatic.com/charts/loader.js"></script>

<!-- 차트 그리기 : teamProgress.js  -->
<script type="text/javascript">

var url = window.location.pathname;
console.log("url....!!!"+url);
var project_id = url.substring(url.lastIndexOf('/')+1,url.length);
console.log("project_id....!!! " + project_id);

google.charts.load('current', {packages: ['corechart', 'bar']});
google.charts.setOnLoadCallback(function() { drawColumnProgress(project_id); });

</script>

<!-- 프로젝트 진행률 차트 그리는 js -->
<script type="text/javascript" src="/resources/js/teamProgress.js"></script>


<title>FOR WORK</title>
<style type="text/css">
.wrap {
	margin: 30px;
}

.calendar, .todolist, .notice, .project {
/*	border: 1px solid gray;  레이아웃 확인용 */
	min-height: 350px;
}
</style>

<!-- to do list style -->
<style type="text/css">
* {
	box-sizing: border-box;
}
.doneContent, .todoContent {
	min-width: 290px;
}

.bi {
	color: #000;
}

.todoLine {
	padding: 10px;
	clear: both;
	height: 40px;
}

.doneBox, .todoBox {
	clear: both;
}

.doneLine {
	padding: 10px;
	height: 40px;
}

.todolist {
	position: relative;
}

.todolistBox {
	border: 2px solid gray;
	border-radius: 15px;
	height: 300px;
	overflow: auto;
	width: 450px;
	padding: 20px;
	margin: 10px 0px 0px 50px;
	position: absolute;
	right: 40px;
	top: 0px;
}

#addTodolist button {
	border: none;
	background-color: #FFFFFF;
}

.todoContent, .doneContent {
	float: left;
	height: 30px;
	font-size: 15px;
}

.refreshBtn {
	float: left;
	margin-top: 5px;
}

.allDelBtn {
	float: right;
	padding: 0px;
}

.deleteTodoBtn, .updateDoneBtn, .modifyBtn {
	display: inline-block;
	margin: 0px 3px;
}

.bi-plus {
	font-size: 20px;
	font-weight: bold;
	color: black;
}

.todoBox {
	margin-top: 10px;
}

.doneContent {
	text-decoration: line-through;
	color: gray;
}

.bi-arrow-counterclockwise:hover, .bi-trash-fill:hover, .bi-plus:hover, .bi-pencil:HOVER, .bi-check2-circle:hover, .bi-x:hover {
	text-decoration: none;
	color: red;
	font-weight: bold;
	cursor: pointer;
}

#inputBox {
	border: 2px solid black;
	border-radius: 10px;
	height: 35px;
}

</style>

<!-- notice style -->
<style type="text/css">

.noticePreList {
	margin-top: 20px;
	width: 600px;
}

.noticePreList a {
	text-decoration: none;
	color: #000;
}

.noticePreList a:hover {
	font-weight: bold;
}

.title {
	font-size: 20px;
	font-weight: bold;
	margin: 30px 0px 10px;
}

/*캘린더 CSS*/
.calendar .fc-toolbar {
	height : 50px;

}

#calendar{
	margin-right : 20px;
}

.fc .fc-scrollgrid-section-liquid{
	display : none;

}

.fc-daygrid-body-natural{
	border-top : 2px solid black;
	border-bottom : 2px solid black;
	
}
.fc-scrollgrid-section .fc-scroller-harness .fc-scroller .fc-daygrid-body .fc-scrollgrid-sync-table{
height : 150px;

}

.fc-scrollgrid-sync-inner a{
	height : 25px;
} 

</style>


</head>
<body>
	<div class="wrap">
		<div class="container">
			<div class="row">

				<div class="col-sm-7 calendar mt-3">
				
					<div id='calendar'></div>
				
				</div>
				<!-- calendar end -->

				<div class="col-sm-5 todolist">
					<div class="todolistBox">

						<form>
							<input type="hidden" name="member_id" value="${member_id}">
							<input type="text" name="todolist_content" size=42 id="inputBox"> 
							<button type="button" id="addTodoBtn"><i class="bi bi-plus"></i></button>
							<button type="button" id="modifyTodoBtn"><i class="bi bi-check"></i></button>
						</form>

						<div class="todoBox">
							<div class="refreshBtn">
								<a href="main?member_id=${member_id}&project_id=${project_id}"><i
									class="bi bi-arrow-counterclockwise"></i></a>
							</div>
							<!-- <div class="allDelBtn">done list <i class="bi bi-trash-fill"></i></div> -->
							
							<c:forEach var="doing" items="${doing}">
								<div class="todoLine">
									<div class="todoContent">${doing.todolist_content}</div>
									<input type="hidden" name="todolist_id" value="${doing.todolist_id}">
									<div class="updateDoneBtn"><i class="bi bi-check2-circle"></i></div>
									<div class="modifyBtn"><i class="bi bi-pencil"></i></div>
									<div class="deleteTodoBtn"><i class="bi bi-x"></i></div>
								</div>
							</c:forEach>
						</div>

						<div class="doneBox">
							<c:forEach var="done" items="${done}">
								<div class="doneLine">
									<div class="doneContent">${done.todolist_content}</div>
									<input type="hidden" name="todolist_id" value="${done.todolist_id}">
									<div class="deleteTodoBtn"><i class="bi bi-x"></i></div>
								</div>
							</c:forEach>
						</div>

					</div>
				</div>
				<!-- to do list end -->

				<div class="col-sm-7 notice">
					<div class="noticePreList">
						<div>
							<div class="title">공지 사항</div>
						</div>
						<table class="table table-hover">
							<tr>
								<th>No.</th>
								<th>제목</th>
								<th>작성일</th>
							</tr>
							<c:forEach var="notice" items="${notice}">
								<tr>
									<td>${notice.post_id}</td>
									<td style="width: 50%"><a
										href="/board/post?post_id=${notice.post_id}&board_id=${notice.board_id}&project_id=${project_id}">${notice.post_title}</a></td>
									<td><fmt:parseDate var="dt" value="${notice.post_date}"
											pattern="yyyy-MM-dd HH:mm:ss"></fmt:parseDate> <fmt:formatDate
											value="${dt}" pattern="yyyy.MM.dd" /></td>
								</tr>
							</c:forEach>
						</table>

					</div>
				</div>
				<!-- notice end -->

				<div class="col-sm-5 project">
				
					<div id="columns_chart">
					
					</div>
				
				</div>
				<!-- project end -->

			</div>
			<!-- row end -->
		</div>
		<!-- container end -->
	</div>
	<!-- wrap end -->
	
	<script type="text/javascript" src="/resources/js/todolist.js"></script>
	
	<script type="text/javascript">
	
		function main() {
			window.location.href = "${project_id}";
		}	
	
	</script>
	
	<!-- to do list javaScript -->
	<script type="text/javascript">
	
		$(document).ready(function() {
			
			var member_id = '<c:out value="${member_id}"/>';
			var inputBox = $("input[name='todolist_content']");
			var addTodoBtn = $("#addTodoBtn");
			var modifyTodoBtn = $("#modifyTodoBtn");
			
			modifyTodoBtn.hide();
			
			addTodoBtn.on("click", function(e) {
							
				if(!inputBox.val()) alert("내용을 입력하세요.");
				
				var todolist = {
						member_id:member_id,
						todolist_content:inputBox.val()
				};
				
				todolistService.add(todolist, function(result) {
					console.log(result);
					main();
				});
				
			});
			
			$(".updateDoneBtn").on("click", function(e) {
				
				var todolist_id = $(this).parent().find("input[name='todolist_id']").val();
				
				todolistService.updateDone(todolist_id, function(result) {
					console.log(result);
					main();
				});
				
			});
			
			$(".modifyBtn").on("click", function(e) {
				
				var todolist_id = $(this).parent().find("input[name='todolist_id']").val();
				var content = $(this).parent().find(".todoContent").text();
				
				inputBox.val(content);
				addTodoBtn.hide();
				modifyTodoBtn.show();
				
				
				modifyTodoBtn.on("click", function(e) {
					
					if(!inputBox.val()) alert("내용을 입력하세요.");
					
					var todolist = {
							todolist_id:todolist_id,
							todolist_content:inputBox.val()
					};
					
					todolistService.update(todolist, function(result) {
						console.log(result);
						main();
					});
					
				});
				
			});
			
			$(".deleteTodoBtn").on("click", function() {
				
				var todolist_id = $(this).parent().find("input[name='todolist_id']").val();
				
				todolistService.remove(todolist_id, function(result) {
					console.log(result);
					main();
				});
				
			});

/* 			$(".allDelBtn").on("click", function() {				
				todolistService.removeAllDone(member_id, function(result) {
					console.log(result);
					main();
				});
			}); */
			
		});
	
	</script>
</body>
</html>
<%@ include file="footer.jsp"%>