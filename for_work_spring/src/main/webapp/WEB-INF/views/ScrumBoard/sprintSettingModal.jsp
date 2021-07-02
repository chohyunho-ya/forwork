<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


	<div class="modal fade" id="sprintSettingModal" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">Sprint 이름을 선택하세요.</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<div class="form-group">
						<label for="taskId" class="col-form-label">Sprint Name</label> 
						<input type="text" class="form-control" id="sprint_name" name="sprint_name" readonly="readonly">
						<div id="suggestion"></div>
						<input type="hidden" id="select_sprint_id">
						<input type="hidden" id="select_task_id">
					</div>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-warning" id="taskSprintUpdateBtn">수정</button>
					<button type="button" class="btn btn-secondary"	data-dismiss="modal" id="sprintSettingModalClose">취소</button>
				</div>

			</div>
		</div>
	</div>
</body>
</html>