console.log("todolist module...");

var todolistService = (function () {
	
	function add(todolist, callback, error) {
		console.log("add todolist...");
		
		$.ajax({
			type: 'post',
			url: '/todolist/new',
			data: JSON.stringify(todolist),
			contentType: "application/json; charset=utf-8",
			success: function(result, status, xhr) {
				if (callback) {
					callback(result);
				}
			},
			error: function(xhr, status, er) {
				if (error) {
					error(er);
				}
			}
		});
	}
	
	function remove(todolist_id, callback, error) {
		$.ajax({
			type: 'delete',
			url: '/todolist/' + todolist_id,
			success: function(deleteResult, status, xhr) {
				if (callback) {
					callback(deleteResult);
				}
			},
			error: function(xhr, status, er) {
				if (error) {
					error(er);
				}
			}
		});
	}

	function removeAllDone(member_id, callback, error) {
		$.ajax({
			type: 'delete',
			url: '/todolist/done/' + member_id,
			success: function(deleteResult, status, xhr) {
				if (callback) {
					callback(deleteResult);
				}
			},
			error: function(xhr, status, er) {
				if (error) {
					error(er);
				}
			}
		});
	}
	
	function update(todolist, callback, error) {
		console.log("todolist_id: " + todolist.todolist_id);
		
		$.ajax({
			type: 'put',
			url: '/todolist/' + todolist.todolist_id,
			data: JSON.stringify(todolist),
			contentType: "application/json; charset=utf-8",
			success: function(result, status, xhr) {
				if (callback) {
					callback(result);
				}
			},
			error: function(xhr, status, er) {
				if (error) {
					error(er);
				}
			}
		});
	}

	function updateDone(todolist_id, callback, error) {
		console.log("todolist_id: " + todolist_id);
		
		$.ajax({
			type: 'put',
			url: '/todolist/done/' + todolist_id,
			data: JSON.stringify(todolist_id),
			contentType: "application/json; charset=utf-8",
			success: function(result, status, xhr) {
				if (callback) {
					callback(result);
				}
			},
			error: function(xhr, status, er) {
				if (error) {
					error(er);
				}
			}
		});
	}
	
	return {
		add: add,
		remove: remove,
		update: update,
		removeAllDone: removeAllDone,
		updateDone: updateDone
	};
	
})();