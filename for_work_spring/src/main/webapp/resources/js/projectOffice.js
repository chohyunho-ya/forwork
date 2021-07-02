console.log("ProjectOffice Module.....");

var projectOfficeService=(function(){
	function getStatusId(param, callback, error){
		var project_id = param.project_id;
		$.get("/PMOpage/"+project_id+"/status_id.json", function(result){
			if(callback){
				callback(result);
			}
		}).fail(function(xhr, status, err){
			if(error){
				error();
			}
		});
	}
	
	
	function update(dto, callback, error){
		$.ajax({
			method: "PUT",
			url: '/PMOpage/'+dto.project_id+'/update',	
			data: JSON.stringify(dto),
			contentType: "application/json; charset=utf-8",
			success : function(result, status, xhr){
				if(callback){
					callback(result);
				}
			},
			error:function(xhr, status, er){
				console.log(dto);
				if(error){
					error(er)
				}
			}
		});
	}
	
return {
	getStatusId:getStatusId,
	update:update,
	countProject:countProject
	};
})();