const projectService = {
	projectCreate : function() {
		console.log("projectTitle : " + document.$('#project_title').value);
		if (document.$('#project_title').value == null
				|| document.$('#project_title').value === "") {
			alert("프로젝트명을 입력하세요.");
			return false;
		} else if (document.$('#pmo_id').value == null
				|| document.$('#pmo_id').value === "") {
			alert("PMO ID를 입력하세요.");
			return false;
		} else if (document.$('#pm_id').value == null
				|| document.$('#pm_id').value === "") {
			alert("PM ID를 입력하세요.");
			return false;
		} else if (document.$('#pa_id').value == null
				|| document.$('#pa_id').value === "") {
			alert("PA ID를 입력하세요.");
			return false;
		} else if (document.$('#project_start_date').value == null
				|| document.$('#project_start_date').value === "") {
			alert("시작날짜를 입력하세요.");
			return false;
		} else if (document.$('#project_end_date').value == null
				|| document.$('#project_end_date').value === "") {
			alert("마감날짜를 입력하세요.");
			return false;
		}
	},
	addPaBtn : function() {
		const
		HTML = '<div class="col-4 text-right align-self-center">PA :</div>\n'
				+ '                                    <input type="text" name="pa_id"\n'
				+ '                                           class="form-control form-control-muted col-8 mt-3"\n'
				+ '                                           placeholder="ex)email"/>'
		$('#append').append(HTML);
	}
}