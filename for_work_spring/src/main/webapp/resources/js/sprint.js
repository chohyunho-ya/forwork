
console.log("Sprint Module........");

var sprintService = (function() {

	function insertSprint(sprint, callback, error) {
		console.log("insert task........!!!!!!");
		
		$.ajax({
			type: 'post',
			url: '/sprint/add',
			data: JSON.stringify(sprint),
			contentType : "application/json; charset=utf-8",
			success: function(result, status, xhr) {
				if(callback){
					callback(result);
				}
			},
			error: function(xhr, status, er){
				if(error){
					error(er);
				}
			}
		});
	}
	
	function listSprint(projectId,callback, error) {
		
		$.getJSON("/sprint/list/"+projectId+".json",
				function(data) {
					if(callback){
						callback(data);
					}
				}).fail(function(xhr, status, err){
					if(error){
						error();
					}
				});
	}
	
	function deleteSprint(sprint_id, callback, error) {
		$.ajax({
			type:'delete',
			url:'/sprint/' + sprint_id,
			success : function(deleteResult, status, er) {
				if(callback){
					callback(deleteResult);
				}
			},
			error : function(xhr, status, er) {
				if(error){
					error(er);
				}
			}
		});
	}
	
function updateSprint(sprint, callback, error){
		
		console.log("SPRINT_ID: "+sprint.sprint_id);
		
		$.ajax({
			type : 'put',
			url : '/sprint/' + sprint.sprint_id,
			data : JSON.stringify(sprint),
			contentType : "application/json; charset=utf-8",
			success : function(result, status, xhr){
				if(callback){
					callback(result);
				}
			},
			error : function(xhr, status, er) {
				if(error){
					error(er);
				}
			}
		});
	}

function getSprint(sprint_id, callback, error){
	
	$.get("/sprint/" + sprint_id + ".json", function(result){
		
		if(callback){
			callback(result);
		}
	}).fail(function(xhr, status, err){
		if(error){
			error();
		}
	});
}
	
	return{
		insertSprint : insertSprint,
		listSprint : listSprint,
		deleteSprint : deleteSprint,
		updateSprint : updateSprint,
		getSprint : getSprint
	};
})();