<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


	<div class="modal fade" id="langModal" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title " id="exampleModalLabel"><b>프로젝트에 사용된 언어</b></h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<div class="form-group">
						<label for="projectId" class="col-form-label float-left">Project No.</label> 
						<input type="text" class="form-control" id="projectId" name="project_id">
					</div>
					<div class="form-group">
						<label for="projectLanguage" class="col-form-label float-left">언어</label> 
						<input type="text" class="form-control" id="projectLanguage" name="project_language" autocomplete="off">
					</div>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-warning" id="langUpdateBtn">수정</button>
					<button type="button" class="btn btn-danger" id="langDeleteBtn">삭제</button>
					<button type="submit" class="btn btn-success" id="langRegisterBtn">추가</button>
					<button type="button" class="btn btn-secondary"	data-dismiss="modal" id="langModalClose">취소</button>
				</div>

			</div>
		</div>
	</div>
</body>
</html>