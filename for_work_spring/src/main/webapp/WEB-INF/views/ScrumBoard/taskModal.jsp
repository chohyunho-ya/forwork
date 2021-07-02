<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


	<div class="modal fade" id="taskModal" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">Task 내용을 입력하세요.</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<div class="form-group">
						<label for="taskId" class="col-form-label">Task ID</label> 
						<input type="text" class="form-control" id="taskId" name="task_id">
					</div>
					<div class="form-group">
						<label for="taskContent" class="col-form-label">내용</label> 
						<input type="text" class="form-control" id="taskContent" name="task_content" autocomplete="off">
					</div>
					<div class="form-group">
						<label for="taskRes" class="col-form-label">담당자</label> 
						<input type="text" class="form-control" id="taskRes" name="name">
					</div>
					<div class="form-group">
						<label for="taskWriter" class="col-form-label">작성자</label> 
						<input type="text" class="form-control" id="taskWriter" name="writer">
					</div>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-warning" id="taskUpdateBtn">수정</button>
					<button type="button" class="btn btn-danger" id="taskDeleteBtn">삭제</button>
					<button type="submit" class="btn btn-success" id="taskRegisterBtn">추가</button>
					<button type="button" class="btn btn-secondary"	data-dismiss="modal" id="taskModalClose">취소</button>
				</div>

			</div>
		</div>
	</div>
</body>
</html>