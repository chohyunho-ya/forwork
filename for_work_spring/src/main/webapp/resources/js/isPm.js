console.log("Is PM Module 실행....!!!");

var isPmService = (function() {
	
function isPm(project_id, member_id,callback, error){
		
		$.get("/pmPage/isPm/"+project_id+"/"+member_id+".json", function(result){
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
	isPm : isPm
	};
})();