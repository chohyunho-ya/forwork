console.log("comment module...");

var commentService = (function () {
	
	function add(comment, callback, error) {
		console.log("add comment...");
		
		$.ajax({
			type: 'post',
			url: '/comments/new',
			data: JSON.stringify(comment),
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
	
	function getList(param, callback, error) {
		var post_id = param.post_id;
		var page = param.page || 1;
		
		$.getJSON("/comments/pages/" + post_id + "/" + page + ".json",
			function(data) {
			if (callback) {
				callback(data);
			}
		}).fail(function(xhr, status, err) {
			if (error) {
				error();
			}
		});
	}
	
	function remove(comment_id, callback, error) {
		$.ajax({
			type: 'delete',
			url: '/comments/' + comment_id,
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
	
	function update(comment, callback, error) {
		console.log("comment_id: " + comment.comment_id);
		
		$.ajax({
			type: 'put',
			url: '/comments/' + comment.comment_id,
			data: JSON.stringify(comment),
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
	
	function get(comment_id, callback, error) {
		$.get("/comments/" + comment_id + ".json", function(result) {
			if (callback) {
				callback(result);
			}
		}).fail(function(xhr, status, err) {
			if (error) {
				error();
			}
		});
	}
	
	return {
		add: add,
		getList: getList,
		remove: remove,
		update: update,
		get: get
	};
	
})();