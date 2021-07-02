console.log("board module...");

var boardService = (function () {
	
	function add(board, callback, error) {
		console.log("add board...");
		
		$.ajax({
			type: 'post',
			url: '/board/new',
			data: JSON.stringify(board),
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
	
	function remove(board_id, callback, error) {
		$.ajax({
			type: 'delete',
			url: '/board/' + board_id,
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
	
	function update(board, callback, error) {
		console.log("board_id: " + board.board_id);
		
		$.ajax({
			type: 'put',
			url: '/board/' + board.board_id,
			data: JSON.stringify(board),
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