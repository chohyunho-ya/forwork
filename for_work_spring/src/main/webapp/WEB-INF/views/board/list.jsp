<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<%@ include file="../header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<!-- Required meta tags -->
<!-- Required meta tags -->
<meta charset="utf-8">
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
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
	integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-Piv4xVNRyMGpqkS2by6br4gNJ7DXjqk09RmUpJ8jgGtD7zP9yug3goQfGII0yAns"
	crossorigin="anonymous"></script>

<!-- Option 2: Separate Popper and Bootstrap JS -->
<!--
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.min.js" integrity="sha384-+YQ4JLhjyBLPDQt//I+STsc9iw4uQqACwlvpslubQzn4u2UU2UFM80nGisd026JF" crossorigin="anonymous"></script>
    -->
    

<style type="text/css">

.container {
	margin: 0px;
}

.list-group-item {
	height: 37px;
}

.boardMenuList {
	border: 2px solid gray;
	min-height: 450px;
	width: 185px;
	margin-top: 40px;
	font-size: 14px;
	position: relative;
	padding: 10px;
	border-radius: 10px;
	position: relative;
	left: 10px;
}

.boardManagerBtn {
	position: absolute;
	bottom: 10px;
	left: 10px;
}

.container a {
	text-decoration: none;
	color: #000;
}

.container a:hover {
	font-weight: bold;
}

.listWrap {
	margin-top: 30px;
	padding-left: 40px;
	position: relative;
}

.boardName {
	font-size: 20px;
	font-weight: bold;
	margin-bottom: 20px; 
}

table {
	
}

.write {
	border: 3px solid gray;
	height: 30px;
	width: 80px;
	border-radius: 5px;
	position: absolute;
	right: 10px;	
	top: 0px;
}

.writeBox {
	position: relative;
	left: 13px;
}

.listFooterArea {
	position: relative;
	min-height: 50px;
}

.pagingBtnArea {
	position: absolute;
	top: 55px;
	right: 30px;
}

.searchArea {
	position: absolute;
	top: 10px;
	left: 40px;
}

.active {
	background-color: #6c757d;
}

.searchBtn {
	position: relative;
	top: -5px;
	left: 5px;
}

.searchBtn:HOVER {
	background-color: white;
	font-weight: bold;
}

.commentCnt {
	display: inline-block;
	margin-left: 20px;
	border: 1px solid #EAEAEA;
	min-width: 25px;
	height: 22px;
	text-align: center;
	border-radius: 8px;
}

</style>
<title>4WORK | ${board.board_name}</title>
</head>
<body>

	<div class="wrap">
		<div class="container">
			<div class="row">
				<div class="col-2">
				
					<div class="boardMenuList">
						<ul class="list-group list-group-flush">
							<li class="list-group-item"><a href="/board/main/${board.project_id}"><i class="bi bi-house-door"></i> 게시판 홈</a></li>
							<c:forEach var="menu" items="${menu}">
								<li class="list-group-item">
									<a href="/board/list?project_id=${menu.project_id}&board_id=${menu.board_id}">
									<i class="bi bi-clipboard"></i> ${menu.board_name}</a></li>
							</c:forEach>
						</ul>
						<a href="/board/manager?project_id=${board.project_id}" class="boardManagerBtn"><i class="bi bi-pencil-square"></i> 게시판 관리</a>
					</div>
					
				</div>
				<div class="col-10">
					<div class="listWrap">
						<div class="boardName">${board.board_name}</div>
						 <div class="write"><a href="/board/insertPost?project_id=${board.project_id}&board_id=${board.board_id}" class="writeBox">글쓰기</a></div>

						<table class="table table-hover">
							<thead>
								<tr>
									<th scope="col">No.</th>
									<th scope="col" style="width: 55%; text-align: center">제목</th>
									<th scope="col">작성자</th>
									<th scope="col">작성일</th>
									<th scope="col">조회</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="list" items="${list}">
									<tr>
										<td>${list.post_id}</td>
										<td><a href="${list.post_id}" class="postBtn">${list.post_title}</a><div class="commentCnt">${list.commentCnt}</div></td>
										 <td>${list.post_writer}</td>
										<td><fmt:parseDate var="dt" value="${list.post_date}"
												pattern="yyyy-MM-dd HH:mm:ss"></fmt:parseDate> <fmt:formatDate
												value="${dt}" pattern="yyyy.MM.dd HH:mm" /></td>
										<td>${list.hitcount}</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
					<!-- post list end -->
 					
					<div class="listFooterArea">
						<div class="searchArea">
							<form id="searchForm" action="/board/list" method="get">
								<select name='type'>
									<option value="" <c:out value="${pageMaker.cri.type == null ? 'selected' : ''}"/>>--</option>
									<option value="T" <c:out value="${pageMaker.cri.type eq 'T' ? 'selected' : ''}"/>>제목</option>
									<option value="C" <c:out value="${pageMaker.cri.type eq 'C' ? 'selected' : ''}"/>>내용</option>
									<option value="W" <c:out value="${pageMaker.cri.type eq 'W' ? 'selected' : ''}"/>>작성자</option>
									<option value="TC" <c:out value="${pageMaker.cri.type eq 'TC' ? 'selected' : ''}"/>>제목+내용</option>
									<option value="TW" <c:out value="${pageMaker.cri.type eq 'TW' ? 'selected' : ''}"/>>제목+작성자</option>
									<option value="TCW" <c:out value="${pageMaker.cri.type eq 'TCW' ? 'selected' : ''}"/>>제목+내용+작성자</option>
								</select>
								<input type="text" name="keyword"/>
								<input type="hidden" name="project_id" value="${board.project_id}">
								<input type="hidden" name="board_id" value="${board.board_id}">
								<input type="hidden" name="pageNum" value="${pageMaker.cri.pageNum}">
								<button class="btn btn-default searchBtn">검색</button>
							</form>	
						</div>
						<!-- SearchArea end -->
 						
						<div class="pagingBtnArea">
							<div class="btn-toolbar mb-3" role="toolbar" aria-label="Toolbar with button groups">
								<c:if test="${pageMaker.prev}">
									<div class="btn-group me-2" role="group" aria-label="First group">
										<a href="${pageMaker.startPage - 1}"><button type="button" class="btn btn-outline-secondary pagingBtn">이전</button></a>
									</div>
								</c:if>
							
								<div class="btn-group me-2" role="group" aria-label="Second group">
									<c:forEach var="num" begin="${pageMaker.startPage}" end="${pageMaker.endPage}">
										<a href="${num}">
											<button type="button" class="btn btn-outline-secondary pagingBtn ${pageMaker.cri.pageNum == num ? "active" : ""}">${num}</button>
										</a>
									</c:forEach>
								</div>
								
								<c:if test="${pageMaker.next}">
									<div class="btn-group me-2" role="group" aria-label="Third group">
										<a href="${pageMaker.endPage + 1}"><button type="button" class="btn btn-outline-secondary pagingBtn">다음</button></a>
									</div>
								</c:if>
							</div>
						</div>
						<!-- pagingBtn end -->
					</div>
				</div>
				<!-- col-10 -->
				
				<form id="actionForm" action="/board/list" method="get">
					<input type="hidden" name="project_id" value="${board.project_id}">
					<input type="hidden" name="board_id" value="${board.board_id}">
					<input type="hidden" name="pageNum" value="${pageMaker.cri.pageNum}">
					<input type="hidden" name="type" value='<c:out value="${pageMaker.cri.type}"/>'>
					<input type="hidden" name="keyword" value='<c:out value="${pageMaker.cri.keyword}"/>'>
				</form>
				
				<form id="actionPostForm" action="/board/post" method="get">
					<input type="hidden" name="project_id" value="${board.project_id}">
					<input type="hidden" name="board_id" value="${board.board_id}">
					<input type="hidden" name="post_id" value="">
					<input type="hidden" name="pageNum" value="${pageMaker.cri.pageNum}">
					<input type="hidden" name="type" value='<c:out value="${pageMaker.cri.type}"/>'>
					<input type="hidden" name="keyword" value='<c:out value="${pageMaker.cri.keyword}"/>'>
				</form>
				
			</div>
		</div>
	</div>

	<script type="text/javascript">
	
		$(document).ready(function() {
			
			var actionForm = $("#actionForm");
			
			$('.pagingBtn').on("click", function(e) {
				
				e.preventDefault();
				console.log("click");
				
				actionForm.find("input[name='pageNum']").val($(this).parent().attr("href"));
	
				actionForm.submit();

			});
			
			
			var searchForm = $("#searchForm");
			
			$("#searchForm button").on("click", function(e) {
				
				if(!searchForm.find("option:selected").val()) {
					alert("검색 종류를 선택하세요.");
					return false;
				}
				
				if(!searchForm.find("input[name='keyword']").val()) {
					alert("검색 키워드를 입력하세요.");
				}
				
				searchForm.find("input[name='pageNum']").val("1");
				e.preventDefault();
				
				searchForm.submit();
				
			});
			
			var actionPostForm = $("#actionPostForm");
			
			$(".postBtn").on("click", function(e) {
				
				e.preventDefault();
				
				actionPostForm.find("input[name='post_id']").val($(this).attr("href"));
				
				actionPostForm.submit();
			});
			
		});
		
	</script>
</body>
</html>

<%@ include file="../footer.jsp"%>