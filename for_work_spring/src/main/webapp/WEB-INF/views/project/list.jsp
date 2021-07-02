<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<%@ include file="./listpage_header.jsp" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<div class="low mt-5 ml-3">
			<button type="button" class="col-2 btn btn-primary" id="targetCreateProjectForm" data-toggle="modal" data-target="#CreateProjectForm">프로젝트 생성</button>
		</div>

		<c:forEach items="${projects}" var="project">
			<div class="card mt-3 ml-3" style="width: 18rem;float: left">
			
				<div class="card-body">
				
					<h5 class="card-title">프로젝트 이름</h5>
					
					<c:if test="${project.project_status_id == '1'}" >
						<span  class="card-link">${project.project_title}</span>
					</c:if>
					<c:if test="${project.project_status_id == '2'}" >
						<a href="/main/${project.project_id}" class="card-link">${project.project_title}</a>
					</c:if>	
					<c:if test="${project.project_status_id == '3'}" >
						<span  class="card-link">${project.project_title}</span>
					</c:if>	
					<c:if test="${project.project_status_id == '4'}" >
						<a href="/main/${project.project_id}" class="card-link">${project.project_title}</a>
					</c:if>	
				</div>
				
				
				<ul class="list-group list-group-flush">
					<c:if test="${project.is_pm == 'y' }">
						<li class="list-group-item">프로젝트 권한: PM</li>
					</c:if>
					<c:if test="${project.is_pm == 'n' }">
						<li class="list-group-item">프로젝트 권한: PA</li>
					</c:if>
						<li class="list-group-item">시작날짜:${project.project_start_date}</li>
						<li class="list-group-item">마감날짜:${project.project_end_date}</li>
					<c:if test="${project.project_status_id == '1'}">
						<li class="list-group-item">프로젝트 상태 : 승인대기</li>
					</c:if>
					<c:if test="${project.project_status_id == '2'}">
						<li class="list-group-item">프로젝트 상태 : 승인</li>
					</c:if>
					<c:if test="${project.project_status_id == '3'}">
						<li class="list-group-item">프로젝트 상태 : 반려</li>
					</c:if>
					<c:if test="${project.project_status_id == '4'}">
						<li class="list-group-item">프로젝트 상태 : 완료</li>
					</c:if>
				</ul>
				<div class="card-body">
					<a href="#" class="card-link">프로젝트 수정</a>
				</div>
			</div>
		</c:forEach>
</html>
<%-- js --%>
<script src="/resources/assets/js/project/projectList.js"></script>
<%@ include file="./create_project_form.jsp" %>
<%@ include file="../footer.jsp" %>