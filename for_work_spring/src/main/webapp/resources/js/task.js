
console.log("Reply Module........!!!!");

var taskService = (function() {
	
	function insertTask(task, callback, error ) {
		console.log("INSERT TASK.....!!!");
		$.ajax({
			type : 'post',
			url : '/task/add',
			data : JSON.stringify(task),
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
		})
	}
	
	function listTask(project_id,callback, error) {
		
		$.getJSON("/task/list/"+project_id+".json",
				
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
	
	function deleteTask(task_id, callback, error) {
		$.ajax({
			type:'delete',
			url:'/task/' + task_id,
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
	
	function updateTask(member_name,task, callback, error){
		
		console.log("TASK_ID: "+task.task_id);
		
		$.ajax({
			type : 'put',
			url : '/task/' + task.task_id+"/"+member_name,
			data : JSON.stringify(task),
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
	
	function detailTask(task_id, callback, error){
		
		$.get("/task/" + task_id + ".json", function(result){
			
			if(callback){
				callback(result);
			}
		}).fail(function(xhr, status, err){
			if(error){
				error();
			}
		});
	}
	
	function sendTodo(param, callback, error){
		var task_id=param.task_id;
		$.ajax({
			type:'get',
			url: '/task/sendTodo/'+task_id,
			success: function(result, status, xhr){
				if(callback){
					callback(result);
				}
			},
			error : function(xhr, status, er){
				if(error){
					error(er);
				}
			}
		});
	}
	
	return{
		insertTask : insertTask,
		listTask : listTask,
		deleteTask : deleteTask,
		updateTask : updateTask,
		detailTask : detailTask,
		sendTodo : sendTodo
	};
})();