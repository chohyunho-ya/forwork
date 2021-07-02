console.log("GET Project Module....!!!");

var getPrService = (function() {
	
	function getPr(project_id, callback, error){
		
		$.get("/task/getPr/"+project_id+".json", function(result){
			if(callback){
				callback(result);
			}
		}).fail(function(xhr,status,err){
			if(error){
				error();
			}
		});
	}
	
	return{
		getPr : getPr
	};
})();