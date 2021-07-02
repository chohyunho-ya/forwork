console.log("Portfolio Module.....");

var portfolioService=(function(){
	
	function add(wrapper, callback, error){
		console.log("wrapper(portfolio+pfLangList)..........");
	$.ajax({
		type: 'post',
		url: '/myprofile/'+wrapper.member_id+'/new',
		data: JSON.stringify(wrapper),
		contentType: "application/json; charset=utf-8",
		success: function(result, status, xhr){
			if(callback){
				callback(result);
			}
		},
		error: function(xhr, status, er){
		console.log("========add_if_error========")
			if(error){
				error(er);
			}
		}	
		})
	}/*add 함수 끝*/
	function getList(param,callback,error){
		var member_id = param.member_id;
		$.getJSON("/myprofile/"+member_id+"/list.json",
			function(data){
			if(callback){
				callback(data);
			}
		}).fail(function(xhr,status,err){
			if(error){
				error();
			}
		});
	}/*getList 함수 끝*/
	
	function remove(param, callback, error){
		var portfolio_id = param.portfolio_id; 
		console.log("@Portfolio.js remove");
		console.log("portfolio_id"+portfolio_id);
		$.ajax({
			type:'delete',
			url: '/myprofile/'+portfolio_id,
			success: function(deleteResult, status, xhr){
				if(callback){
					callback(deleteResult);
				}
			},
			error : function(xhr, status, er){
				if(error){
					error(er);
				}
			}
		});
	}
	
	function update(wrapper, callback, error){
		console.log("wrapper"+ wrapper.portfolio);
		$.ajax({
			type: 'put',
			url: '/myprofile/'+wrapper.portfolio_id+'/update',
			data: JSON.stringify(wrapper),
			contentType: "application/json; charset=utf-8",
			success : function(result, status, xhr){
				if(callback){
					callback(result);
				}
			},
			error:function(xhr, status, er){
				if(error){
					error(er)
				}
			}
		});
	}
	
	function get(param,callback,error){
		var portfolio_id = param.portfolio_id;
		console.log("portfolio_id"+portfolio_id)
		$.getJSON("/myprofile/"+portfolio_id+"/portfolio.json",
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
	
	function getPfLangList(param,callback,error){
		var portfolio_id = param.portfolio_id;
		$.getJSON("/myprofile/"+portfolio_id+"/language.json",
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
	
	function getInfo(param,callback,error){
		var member_id = param.member_id;
		$.getJSON("/myprofile/"+member_id+"/info.json",
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
	
	function displayTime(timeValue){
		
		var dateObj = new Date(timeValue);
		var str="";
		var yy = dateObj.getFullYear();
		var mm = dateObj.getMonth()+1;
		var dd = dateObj.getDate();
		
		return[yy,'-',(mm > 9 ? '' : '0')+mm,'-',
			(dd>9 ?'' :'0')+dd].join('');
	}
	
	function chart(param,callback,error){
		var member_id = param.member_id;
		console.log("member_id @portfolio.js"+member_id)
		$.getJSON("/myprofile/"+member_id+"/chart.json",
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
	function updateMStatus(wrapper, callback, error){
		$.ajax({
			type: 'put',
			url: '/myprofile/'+wrapper.member_id+'/updateMemberStatus',
			data: JSON.stringify(wrapper),
			contentType: "application/json; charset=utf-8",
			success : function(result, status, xhr){
				if(callback){
					console.log(wrapper);
					callback(result);
				}
			},
			error:function(xhr, status, er){
				if(error){
					error(er)
				}
			}
		});
	}
	
	return {add:add,
		getList: getList,
		remove: remove,
		update: update,
		get: get,
		getInfo: getInfo,
		displayTime: displayTime,
		chart: chart,
		getPfLangList:getPfLangList,
		updateMStatus:updateMStatus
		};
})();