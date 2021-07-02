console.log("post module...");

var postService = (function () {
	
	function add(post, callback, error) {
		console.log("add post...");
		
		$.ajax({
			type: 'post',
			url: '/post/new',
			data: JSON.stringify(post),
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
	
	function remove(post_id, callback, error) {
		$.ajax({
			type: 'delete',
			url: '/post/' + post_id,
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
	
	function update(post, callback, error) {
		console.log("post_id: " + post.post_id);
		
		$.ajax({
			type: 'put',
			url: '/post/' + post.post_id,
			data: JSON.stringify(post),
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
		update: update
	};
	
})();