console.log("Project Language Module......!!!");

var langService = (function() {

	function insertLang(prLang, callback, error) {
		console.log("insert Language..........!!!");

		$.ajax({
			type : 'post',
			url : '/pmPage/addLang',
			data : JSON.stringify(prLang),
			contentType : "application/json; charset=utf-8",
			success : function(result, status, xhr) {
				if (callback) {
					callback(result);
				}
			},
			error : function(xhr, status, er) {
				if (error) {
					error(er);
				}
			}
		});

	}

	function getLang(project_id,callback, error) {
		
		$.getJSON("/pmPage/getLang/"+project_id+ ".json", function(data) {
			if (callback) {
				callback(data);
			}
		}).fail(function(xhr, status, err) {
			if (error) {
				error();
			}
		});
	}
	
	function deleteLang(pr_lang_seq, callback, error) {
		$.ajax({
			type:'delete',
			url:'/pmPage/' + pr_lang_seq,
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
	
	
	function updateLang(prLang, callback, error){
			
			console.log("pr_lang_seq: "+prLang.project_language_seq);
			
			$.ajax({
				type : 'put',
				url : '/pmPage/' + prLang.project_language_seq,
				data : JSON.stringify(prLang),
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
	
	function getSeq(pr_lang_seq, callback, error){
		
		$.get("/pmPage/get/"+pr_lang_seq + ".json", function(result){
			
			if(callback){
				callback(result);
			}
		}).fail(function(xhr, status, err){
			if(error){
				error();
			}
		});
	}
	
	return{
		insertLang : insertLang,
		getLang : getLang,
		deleteLang : deleteLang,
		updateLang : updateLang,
		getSeq : getSeq
	};

})();