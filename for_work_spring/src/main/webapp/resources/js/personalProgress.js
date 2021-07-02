console.log("Personal Progress Module..>!!!");

var personalChart = (function(){
	
	function getPersonalData(callback, error){
		
		$.getJSON("/pmPage/"+project_id+".json",
				function(data){
					if(callback){
						callback(data);
					}
			}).fail(function(xhr,status,err){
				if(error){
					error();
				}
			});
	}
	return{
		getPersonalData:getPersonalData
		};
})();
