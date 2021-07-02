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

<!-- Project Select js -->
<script type="text/javascript" src="/resources/js/projectSelect.js"></script>

<!-- Project select 처리 -->
<script type="text/javascript">

$(document).ready(function() {
	
	var member_id = "${member.member_id}";
	console.log("Pm 프로젝트 선택 페이지 member_id...>!!!!!!" +member_id);
	var pmPageBtn = $("#pmPageBtn");
	
	showProjects(member_id);
	
	function showProjects(member_id){
		
		var prDiv = $("#projectsDiv");
		
		projectSelect.getProjects(member_id,function(list){
			
			var str ="";
			var prStatus ="";
			if(list==null || list.length==0){
				prDiv.html("");
				
				return;
			}
			
			for(var i=0, len=list.length||0;i<len;i++){

				if(list[i].project_status_id==1){
					prStatus = "승인대기";
				}
				if(list[i].project_status_id==2){
					prStatus = "승인";
				}
				if(list[i].project_status_id==3){
					prStatus = "반려";
				}
				if(list[i].project_status_id==4){
					prStatus = "완료";
				}
				console.log(prStatus);
				str += "<div class='col-md-5'><div class='card'><div class='card-body'><h4 class='card-title'>";
				str += "Project No." + (i+1) + "</h4><p class='card-text'><table class='table'>";
				str += "<thead><tr><th scope='col'>항목</th><th scope='col'>내용</th></tr></thead>";
				str += "<tbody><tr><th scope='row'>Project Title</th><td>"+list[i].project_title +"</td></tr>";
				str += "<tbody><tr><th scope='row'>Project Status</th><td>"+prStatus +"</td></tr>";
				str += "<tbody><tr><th scope='row'>Start Date</th><td>"+list[i].project_start_date +"</td></tr>";
				str += "<tbody><tr><th scope='row'>End Date</th><td>"+list[i].project_end_date +"</td></tr>";
				str += "</tbody></table></p><div class='d-grid gap-2 float-end'>";
				str += "<a class='btn btn-primary float-right' role='button' data-project_id='"+list[i].project_id+"' href='/pmPage/main/"+list[i].project_id+"'>프로젝트 선택</a></div></div></div></div>";
				
			};
			
			prDiv.html(str);
		}); //end function
	}// end showProjects
	
});

</script>

</head>
<body>

	<div class="container-fluid pt-1 px-0">

		<div class="row flex-row justify-content-md-center my-4">
			<h2>관리할 Project 목록</h2>
		</div>

		<div class="row flex-row justify-content-md-center" id="projectsDiv">

			

			</div>

		</div>




</body>
</html>
