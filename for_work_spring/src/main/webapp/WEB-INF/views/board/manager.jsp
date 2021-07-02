<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
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

<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.1/font/bootstrap-icons.css">

<!-- Optional JavaScript; choose one of the two! -->

<!-- Option 1: jQuery and Bootstrap Bundle (includes Popper) -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
	integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-Piv4xVNRyMGpqkS2by6br4gNJ7DXjqk09RmUpJ8jgGtD7zP9yug3goQfGII0yAns"
	crossorigin="anonymous"></script>

<style type="text/css">
* {
	box-sizing: border-box;
}

.list-group-item {
	height: 37px;
}

.managerWrap {
	margin: 15px 0px 0px 30px;
	padding: 20px;
	position: relative;
}

.boardEditList {
	border: 1px solid gray;
	padding: 20px;
	margin-top: 20px;
	width: 500px;
	min-height: 400px;
	border-radius: 20px;
	font-weight: bold;
}

#addBoard {
	position: absolute;
	right: 100px;
}

.title {
	margin-bottom: 30px;
	font-size: 20px;
}

.contentLine, .clickLine {
	display: inline-block;
}

.container a {
	text-decoration: none;
	color: #000;
}

.container a:hover {
	font-weight: bold;
}

.bi-clipboard-plus:hover {
	font-weight: bold;
	color: red;
	font-size: 17px;
}

.contentLine {
	width: 150px;
	height: 30px;
	line-height: 20px;
	padding: 7px;
}

.boardMenuList {
	padding: 10px;
}

.container {
	margin: 0px;
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

button {
	border: none;
	background-color: #fff;
}

.bi-pencil, .bi-trash {
	color: #000;
	font-size: 15px;
	font-weight: normal;
	margin: 0px 6px;
}

.bi-pencil:hover, .bi-trash:hover {
	color: red;
	font-size: 17px;
	margin: 0px 5px;
	font-weight: bolder;
	cursor: pointer;
}

#addBoardBtn {
	float: right;
	margin-right: 10px;
	font-size: 25px;
	font-weight: bold;
	box-sizing: border-box;
	text-align: center;
}

#addBoardBtn:HOVER {
	color: gray;
	font-size: 27px;
	cursor: pointer;
}

</style>

<title>4WORK | 게시판 관리</title>
</head>
<body>
	<div class="wrap">
		<div class="container">
			<div class="row">
				<div class="col-2">

					<div class="boardMenuList">
						<ul class="list-group list-group-flush">
							<li class="list-group-item"><a href="/board/main/${project_id}"><i class="bi bi-house-door"></i> 게시판 홈</a></li>
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
					<div class="managerWrap">
						<div class="title">게시판 관리</div>

						<%-- <form action="board/new" method="post" id="addBoard">
							<input type="hidden" name="project_id" value="${project_id}">새 게시판 
							<br> <input type="text" size=25 name="board_name">
							<button onclick="addBoard.submit">
								<i class="bi bi-clipboard-plus"></i>
							</button>
						</form> --%>

						<div class="boardEditList">
							<div id="addBoardBtn"><i class="bi bi-folder-plus"></i></div>
							<c:forEach var="menu" items="${menu}">
								<div class="contentBox">
									<div class="contentLine">${menu.board_name}</div>
									<c:if test="${menu.board_name ne '공지 사항'}">
										<div class="clickLine">
											<input type="hidden" value="${menu.board_id}" name="boardId">
											<span class="bi bi-pencil updateBoardBtn"></span> <span class="bi bi-trash deleteBoardBtn"></span>
										</div>
									</c:if>
								</div>
							</c:forEach>
						</div>
					</div>
				</div>
				<!-- col-10 -->
			</div>
		</div>
	</div>
	
	<!-- board modal -->
	<div class="modal" tabindex="-1">
	  <div class="modal-dialog">
	    <div class="modal-content">
	      <div class="modal-header">
	        <h5 class="modal-title">게시판 관리</h5>
	        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
	      </div>
	      <div class="modal-body">
	        <input type="text" size=59 name="board_name">
	      </div>
	      <div class="modal-footer">
	        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal" id="cancelBtn">취소</button>
	        <button type="button" class="btn btn-primary" id="saveBtn">저장</button>
	        <button type="button" class="btn btn-primary" id="updateBtn">수정</button>
	        <button type="button" class="btn btn-primary" id="removeBtn">삭제</button>
	      </div>
	    </div>
	  </div>
	</div> <!-- board modal end -->
	
	<script type="text/javascript" src="/resources/js/board.js"></script>
	
	<script type="text/javascript">
	
//		$(document).ready(function() {
			
			var project_id = '<c:out value="${project_id}"/>';
			var modal = $(".modal");
			var inputBoard = modal.find("input[name='board_name']");
			var cancelBtn = $("#cancelBtn");
			var saveBtn = $("#saveBtn");
			var updateBtn = $("#updateBtn");
			var removeBtn = $("#removeBtn");
			
			$("#addBoardBtn").on("click", function(e) {
				modal.find("input").val("일반 게시판");
				modal.find("button[id = 'updateBtn']").hide();
				modal.find("button[id = 'removeBtn']").hide();
				saveBtn.show();
				$(".modal").modal("show");
				
				$("#cancelBtn").on("click", function(e) {
					$(".modal").modal("hide");
				});
			});
			
			saveBtn.on("click", function(e) {
				
				var board = {
						project_id:project_id,
						board_name:inputBoard.val()
				};
				
				boardService.add(board, function(result) {
					
					if (result == "success") alert("게시판이 생성되었습니다.");
					
					modal.find("input").val("");
					modal.modal("hide");
					
					window.location.reload();
				});
				
			});
						
			$(".updateBoardBtn").on("click", function(e) {
				
				var pre = $(this).parent().parent().find(".contentLine").text();
				var board_id = $(this).parent().find("input[name='boardId']").val();
				
				modal.find("input").val(pre);
				modal.find("button[id = 'saveBtn']").hide();
				modal.find("button[id = 'removeBtn']").hide();
				updateBtn.show();
				$(".modal").modal("show");
				
				$("#cancelBtn").on("click", function(e) {
					$(".modal").modal("hide");
				});
				
				updateBtn.on("click", function(e) {
					
					var board = {
						board_id:board_id,
						board_name:inputBoard.val()
					};
					
					boardService.update(board, function(result) {
						if (result == "success") alert("게시판이 수정되었습니다.");
						
						modal.find("input").val("");
						modal.modal("hide");
						
						window.location.reload();
					});
					
				});
				
			});
			
			$(".deleteBoardBtn").on("click", function(e) {
				
				var board_id = $(this).parent().find("input[name='boardId']").val();
				
				modal.find("input").hide();
				modal.find("button[id = 'saveBtn']").hide();
				modal.find("button[id = 'updateBtn']").hide();
				removeBtn.show();
				
				modal.find(".modal-body").html('<p>게시판 내의 게시글이 모두 삭제됩니다.<br>정말 삭제하시겠습니까?</p>')
				
				$(".modal").modal("show");
				
				$("#cancelBtn").on("click", function(e) {
					$(".modal").modal("hide");
				});
				
				removeBtn.on("click", function(e) {
					
					boardService.remove(board_id, function(result) {
						if (result == "success") alert("게시판이 삭제되었습니다.");
						modal.modal("hide");
						
						window.location.reload();
					});
					
				});
				
			});
			
			
//		});
	
	</script>
</body>
</html>
<%@ include file="../footer.jsp"%>