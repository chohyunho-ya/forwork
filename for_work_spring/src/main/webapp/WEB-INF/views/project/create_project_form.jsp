<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- Modal -->
<div class="modal fade" id="CreateProjectForm" tabindex="-1"
	role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
	<div class="modal-dialog modal-dialog-centered"
		style="min-width: 600px;" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="exampleModalLabel">프로젝트 생성</h5>
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body">
				<div class="card-body">
					<div class="col-md-12 form-inline">
						<div class="col-md-12">
							<form method="post" action="/project/create"
								onsubmit="return projectService.projectCreate()">
								<div class="row my-3 inline">
									<div class="col-4 text-right align-self-center">프로젝트 생성 :</div>
									<input type="text" name="project_title" id="project_title"
										class="form-control form-control-muted col-8 mt-3"
										placeholder="ex)projectTitle" />
									<div class="col-4 text-right align-self-center">PM :</div>
									<input type="email" name="pm_id" id="pm_id"
										class="form-control form-control-muted col-8 mt-3"
										placeholder="ex)email" />
									<button
										class="col-12 mt-3 btn btn-success text-center align-self-center"
										type="button" onclick="projectService.addPaBtn()">PA
										Email추가</button>
									<div class="col-4 text-right align-self-center">PA :</div>
									<input type="email" name="pa_id" id="pa_id"
										class="form-control form-control-muted col-8 mt-3"
										placeholder="ex)email" />
									<div class="row my-2 inline col-12" id="append"></div>
									<div class="col-4 text-right align-self-center">프로젝트 시작날짜
										:</div>
									<input type="date" name="project_start_date"
										id="project_start_date"
										class="form-control form-control-muted col-8 mt-3" required>

									<div class="col-4 text-right align-self-center">프로젝트 마감날짜
										:</div>
									<input type="date" name="project_end_date"
										id="project_end_date"
										class="form-control form-control-muted col-8 mt-3" required />
								</div>

								<div class="row pt-3 inline">
									<div class="col-6 text-center">
										<input type="submit" class="btn btn-success" value="프로젝트 생성하기" />
									</div>
									<div class="col-4 text-center">
										<button type="button" class="btn btn-secondary"
											data-dismiss="modal">취소하기</button>
									</div>
								</div>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
