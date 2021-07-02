<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@ include file="../header.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<link rel="stylesheet"
	href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.min.js"></script>
<!-- 부트스트랩 4.x를 사용한다. -->
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>


<!-- div먼저 그리기 -->
<!-- 
<script type="text/javascript">
$(document).ready(function(){
	drawDivs();
	
	function drawDivs(){
		console.log("drawDivs 실행됨");

$.ajax({
	type : 'get',
	url : '/pmPage/'+project_id+'.json',
	data : {},
    success : function(data) {
    	var str ="";
    	
		for(i in data){

var personalChartDiv = $("#personal_chart");
var personalChartId = "personalChart"+i;
str += "<a href'#'><p data-project_id='"+data[i].project_id+"' data-responsibility='"+data[i].responsibility+"'>"+data[i].name+"의 업무진척도</p></a>";
str += "<div id='"+personalChartId+"'></div>";
personalChartDiv.html(str);

    }
    }
});
	}
});
</script>
-->

<!-- 구글차트-->
<script type="text/javascript"
	src="https://www.gstatic.com/charts/loader.js"></script>

<!-- 차트 그리기 : teamProgress.js  -->
<script type="text/javascript">
	
	var url = window.location.pathname;
	console.log("PM페이지 메인 url....!!!"+url);
	var project_id = url.substring(url.lastIndexOf('/')+1,url.length);
	console.log("PM페이지 메인  project_id....!!! " + project_id);
	
		
	google.charts.load('current', {
		packages : [ 'corechart', 'bar' ]
	});
	google.charts.setOnLoadCallback(function() {
		drawColumnProgress(project_id);
	});
	google.charts.setOnLoadCallback(function() {
		totalProgress(project_id);
	});
	//google.charts.setOnLoadCallback(function() { drawPersonalProgress(project_id); });
</script>

<!-- 팀 진행률 차트 그리는 js -->
<script type="text/javascript" src="/resources/js/teamProgress.js"></script>

<!-- 개인별 진행률 js -->
<script type="text/javascript" src="/resources/js/personalProgress.js"></script>
<!-- 개인별 진행률 차트 그리기 -->
<script type="text/javascript">
	$(document)
			.ready(
					function() {

						var personalChartDiv = $("#personal_chart");

						showPersonalChart();

						function showPersonalChart() {

							personalChart
									.getPersonalData(function(list) {

										var str = "";

										if (list == null || list.length == 0) {
											personalChartDiv
													.html("<p>등록된 업무가 없습니다.</p>");

											return;
										}
										for (var i = 0, len = list.length || 0; i < len; i++) {
											str += "<a href'#'><p data-project_id='"+list[i].project_id+"' data-responsibility='"+list[i].responsibility+"'>"
													+ list[i].name
													+ "의 업무진척도</p></a>";
											str += "<div class='progress' id='personalChartId"+i+"'>";
											str += "<div class='progress-bar bg-danger' role='progressbar' style='width: "
													+ (list[i].storiesCount
															/ list[i].totalCount * 100)
													+ "%' aria-valuenow='"
													+ list[i].storiesCount
													+ "' aria-valuemin='0' aria-valuemax='"
													+ list[i].totalCount
													+ "'>"
													+ "Stories: "
													+ list[i].storiesCount
													+ "</div>";
											str += "<div class='progress-bar bg-warning' role='progressbar' style='width: "
													+ (list[i].todoCount
															/ list[i].totalCount * 100)
													+ "%' aria-valuenow='"
													+ list[i].todoCount
													+ "' aria-valuemin='0' aria-valuemax='"
													+ list[i].totalCount
													+ "'>"
													+ "To-do: "
													+ list[i].todoCount
													+ "</div>";
											str += "<div class='progress-bar bg-info' role='progressbar' style='width: "
													+ (list[i].doingCount
															/ list[i].totalCount * 100)
													+ "%' aria-valuenow='"
													+ list[i].doingCount
													+ "' aria-valuemin='0' aria-valuemax='"
													+ list[i].totalCount
													+ "'>"
													+ "Doing: "
													+ list[i].doingCount
													+ "</div>";
											str += "<div class='progress-bar' role='progressbar' style='width: "
													+ (list[i].doneCount
															/ list[i].totalCount * 100)
													+ "%' aria-valuenow='"
													+ list[i].doneCount
													+ "' aria-valuemin='0' aria-valuemax='"
													+ list[i].totalCount
													+ "'>"
													+ "Done: "
													+ list[i].doneCount
													+ "</div>";
											str += "</div>";
										}
										personalChartDiv.html(str);
									}); //end function
						}// end showPersonalChart

					})
</script>

<!-- 개별 업무 목록 js-->
<script type="text/javascript" src="/resources/js/personalTasks.js"></script>

<!-- 개인별 업무 목록 모달창 띄우기 -->

<script type="text/javascript">
	$(document)
			.ready(
					function() {

						var personalModal = $("#personalModal");
						var contentDiv = $("#perTaskContent");
						var modalTitle = $("#modalTitle");

						$("#personal_chart")
								.on(
										"click",
										"p",
										function(e) {

											var prId = $(this).data(
													"project_id");
											var res = $(this).data(
													"responsibility");
											console.log("개별 업무 모달 project_id....: "
													+ prId);
											console.log("개별 업무 모달 responsibility....: "
													+ res);

											personalTask
													.getTasks(
															prId,
															res,
															function(list) {

																var content = "";
																var title = "";

																if (list == null
																		|| list.length == 0) {
																	contentDiv
																			.html("<p>맡은 없무가 없습니다.</p>");
																	return;
																}

																title += "<h5 class='modal-title' id='modalLabel'>"
																		+ list[0].name
																		+ "의 업무 목록</h5>";
																modalTitle
																		.html(title);

																for (var i = 0, len = list.length; i < len; i++) {

																	content += "<div><label class='float-left'>No."
																			+ (i + 1)
																			+ "</label><input type='text' class='form-control' id='taskContent"+i+
				"' name='task_content' readonly='readonly' value='"+list[i].task_content+"'></div>";

																	contentDiv
																			.html(content);

																	//var name = "input[id='taskContent"+i+"']";
																	//spersonalModal.find(name).val(list[i].task_content);

																	console
																			.log(list[i].task_content);
																}
																;

																$(
																		"#personalModal")
																		.modal(
																				"show");

															});

										});

					});
</script>

<!-- 프로젝트 언어 처리 -->
<script type="text/javascript" src="/resources/js/projectLanguage.js"></script>
<script type="text/javascript">

$(document).ready(function(){
	
	var url = window.location.pathname;
	console.log("프로젝트 언어 url....!!!"+url);
	var projectId = url.substring(url.lastIndexOf('/')+1,url.length);
	console.log("프로젝트 언어 project_id....!!! " + projectId);
	
	var langDiv = $("#langDiv");
	
	showLang(projectId);
	
	// 프로젝트 사용 언어 목록 출력
	function showLang(projectId){
		
		langService.getLang(projectId,function(list){
			
			var str = "";
			if(list==null || list.length==0){
				langDiv.html("");
			}
			for(var i=0, len=list.length||0; i<len; i++){
				str += "<button id='langBtn' class='btn btn-primary' data-project_language_seq='"+list[i].project_language_seq+"'>"+list[i].project_language+"</button>";
			}
			
			langDiv.html(str);
		}); //end function
	}//end showLang
	
	
	var langModal = $("#langModal");
	
	var prIdInput = langModal.find("input[name='project_id']");
	var prLangInput = langModal.find("input[name='project_language']"); 
	
	var langUpdateBtn = $("#langUpdateBtn");
	var langDeleteBtn = $("#langDeleteBtn");
	var langRegisterBtn = $("#langRegisterBtn");
	var langModalClose = $("#langModalClose");
	
	//lang 모달 띄우기
	$("#addLang").on("click", function(e) {
		
		langModal.find("input").val("");
		prIdInput.val(projectId).attr("readonly","readonly");
		langModal.find("button[id!='langModalClose']").hide();
		
		 langRegisterBtn.show();
		 
		 $("#langModal").modal("show");
		
	});
	
	// 사용 언어 추가
	langRegisterBtn.on("click", function(e) {
		
		var prLang = {
				project_id : prIdInput.val(),
				project_language : prLangInput.val()
		};
		
		langService.insertLang(prLang, function(result) {
			
			alert("사용 언어가 추가되었습니다.")
			
			langModal.find("input").val("");
			langModal.modal("hide");
			
			showLang(projectId);
		});
	});
	
	// 사용 언어 수정&삭제
	$("#langDiv").on("click","#langBtn", function(e){
		
		var lang_seq = $(this).data("project_language_seq");
		console.log("프로젝트 언어 Language Sequence: "+ lang_seq);
		
		langService.getSeq(lang_seq, function(prLang) {
			
			prIdInput.val(prLang.project_id).attr("readonly","readonly");
			prLangInput.val(prLang.project_language);
			langModal.data("project_language_seq", prLang.project_language_seq)
			
			
			langModal.find("button[id!='langModalClose']").hide();
			langUpdateBtn.show();
			langDeleteBtn.show();
			
			$("#langModal").modal("show");
			
		});
	});	
		
		//언어 수정하기
		langUpdateBtn.on("click", function(e) {
			
			var prLang = {
					project_language_seq : langModal.data("project_language_seq"),
					project_id : prIdInput.val(),
					project_language : prLangInput.val()
			};
			console.log("프로젝트 언어 수정 Project:"+prLang);
			
			langService.updateLang(prLang, function(result){
				
				alert("사용 언어가 수정되었습니다.");
				langModal.modal("hide");
				showLang(projectId);
			});
		});
		
		//언어 삭제하기
		langDeleteBtn.on("click", function(e){
			
			var lang_seq =  langModal.data("project_language_seq");
			
			langService.deleteLang(lang_seq, function(result){
				
				alert("사용 언어가 삭제되었습니다.");
				langModal.modal("hide");
				showLang(projectId);
			});
			
		});

	
	
	
});

</script>

</head>
<body>


	<!-- 전체화면 틀 -->
	<div class="container-fluid pt-0 px-0">

		<div class="row flex-row justify-content-md-center">

			<!-- 왼쪽부분 -->
			<div class="col-6 flex-fill align-self-center ml-2">
				<div class="col-6 flex-fill align-self-end mb-3">
					<div id="columns_chart"></div>
				</div>
				<div class="col-6 flex-fill align-self-center">
					<div id="total_chart"></div>
				</div>
			</div>

			<!-- 오른쪽부분 -->
			<div class="col-5 flex-fill mt-3" >
				<div class="card text-center">
					<div class="card-header">프로젝트 사용 언어
						<button id='addLang' class='btn btn-primary btn-xs float-right'>+</button>
						<%@ include file="./langModal.jsp"%>
					</div>
					<div class="card-body" id="langDiv">
						
					</div>
				</div>
				<div class="card text-center">
					<div class="card-header">개인별 업무 진행률</div>
					<div class="card-body">
						<%@ include file="./personalTasksModal.jsp"%>
			
						<div id="personal_chart"></div>
					</div>
				</div>
			</div>

		</div>


	</div>

</body>
</html>
<%@ include file="../footer.jsp"%>