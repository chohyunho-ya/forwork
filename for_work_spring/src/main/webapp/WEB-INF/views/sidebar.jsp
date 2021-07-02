<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8" %>
<!-- Sidenav -->
  <nav class="sidenav navbar navbar-vertical  fixed-left  navbar-expand-xs navbar-light bg-white" id="sidenav-main">
	<div class="scrollbar-inner">
	  <!-- Brand -->
	  <div class="sidenav-header  align-items-center">
		<a class="navbar-brand" href="/project/list">
		  <img src="../../../resources/Img/logo.png" class="navbar-brand-img" alt="...">
		</a>
	  </div>
	  <div class="navbar-inner">
		<!-- Collapse -->
		<div class="collapse navbar-collapse" id="sidenav-collapse-main">
		  <!-- Nav items -->
		  <ul class="navbar-nav">
			<li class="nav-item">
			  <a class="nav-link active" href="dashboard.html">
				<i class="ni ni-shop"></i>
				<span class="nav-link-text">메인</span>
			  </a>
			</li>
			<li class="nav-item">
			  <a class="nav-link" href="/attendance">
			   <i class="ni ni-time-alarm"></i>
				<span class="nav-link-text">출퇴근</span>
			  </a>
			</li>
			<li class="nav-item">
			  <a class="nav-link" href="/project/list">
				<i class="ni ni-collection"></i>
				<span class="nav-link-text">프로젝트</span>
			  </a>
			</li>
			<li class="nav-item">
			  <a class="nav-link" href="profile.html">
				<i class="ni ni-badge"></i>
				<span class="nav-link-text">게시판</span>
			  </a>
			</li>
			<li class="nav-item">
			  <a class="nav-link" id = "sidebar_calendar" href="#">
			   <i class="ni ni-calendar-grid-58"></i>  
				<span class="nav-link-text">캘린더</span>
			  </a>
			</li>
			<li class="nav-item" id="scrumPage">
				<script type="text/javascript">
				
				$(document).ready(function() {
					
					var url = window.location.pathname;
					console.log("sidebar 스크럼보드 url....!!!"+url);
					var project_id = url.substring(url.lastIndexOf('/')+1,url.length);
					console.log("sidebar 스크럼보드 project_id....!!! " + project_id);
					
					var scrumBoard = $("#scrumPage");
					var str="";

					str += "<a class='nav-link' href='/task/taskPage/"+project_id+"'><i class='ni ni-chart-bar-32'></i><span class='nav-link-text'>스크럼보드</span></a>"
					
					scrumBoard.html(str);

					
					// 게시판 이동
					$("#board").on("click", function(e) {
						e.preventDefault();
						
						window.location.href = "/board/main/" + project_id;
					});
				});
				</script>

			</li>
			<li class="nav-item" id="pmPageBtn">
				<script type="text/javascript" src="/resources/js/isPm.js"></script>  
				<script type="text/javascript">
				
				$(document).ready(function() {
				
					var url = window.location.pathname;
					console.log("sidebar 관리자페이지 url....!!!"+url);
					var project_id = url.substring(url.lastIndexOf('/')+1,url.length);
					console.log("sidebar 관리자페이지 project_id....!!! " + project_id);
					
					var member_id = "${member.member_id}";
					console.log("sidebar 관리자페이지 member_id...>!!!!!!" +member_id);
					var pmPageBtn = $("#pmPageBtn");
					
					checkIsPm(project_id, member_id);
					$("#sidebar_calendar").attr("href","/calendar/"+project_id);
					
					function checkIsPm(project_id, member_id) {
						
						isPmService.isPm(project_id, member_id,function(result){
							
							console.log("sidebar 관리자페이지 is pm 확인 : "+result.is_pm);
							var str = "";
							if(result.is_pm=="y"){
								str += "<a class='nav-link' href='/pmPage/select/"+project_id+"'><i class='ni ni-single-02'></i><span class='nav-link-text'>관리자페이지</span></a>"
							}
							pmPageBtn.html(str);
						}); //end function
						
					}// end checkIsPm
					
					
					
				});
				
				</script>
		   
			</li>
		  </ul>
		</div>
	  </div>
	</div>
  </nav>