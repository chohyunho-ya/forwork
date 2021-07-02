console.log("Personal Tasks Module......!!!");

var personalTask = (function() {

	function getTasks(project_id,responsibility, callback, error) {

		$.getJSON("/pmPage/getTasks/" +project_id+"/" + responsibility + ".json",

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

	return {
		getTasks : getTasks
	};
})();