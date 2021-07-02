 // 즉시 실행되는 함수
let chattingService = (function() {

	function getMessages(chatroomId, callback, error) {
		$.ajax({
			type : 'get',
			url : '/message/chatroom/' + chatroomId,
			dataType : "json",
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
		})
	}
	
	function getMessagesWithPaging(criteria, chatroomId, callback, error){
		$.ajax({
			type : 'post',
			url : '/message/chatroom/' + chatroomId,
			data : JSON.stringify(criteria),
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
		})
	}
	
	function getChatroomName(chatroomId, callback, error) {
		$.ajax({
			type : 'get',
			url : '/chatroom/' + chatroomId,
			dataType : "json",
			success : function(result, status, xhr) {
				if (callback) {
					callback(result);
				}
			},
			error : function(xhr, status, er) {
				console.log("error");
				if (error) {
					error(er);
				}
			}
		})
	}
	
	function insertMessage(message, callback, error) {
		$.ajax({
			type : 'post',
			url : '/message/new',
			data : JSON.stringify(message),
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
		})
	}
	
	function getChatrooms(userId, callback, error) {
		$.ajax({
			type : 'get',
			url : '/chatroom/member/' + userId,
			dataType : "json",
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
		})
	}
	
	function updateReadStatus(messageId, memberId, callback, error){
		$.ajax({
			type : 'put',
			url : '/message/read/' + messageId + '/member/' + memberId,
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
		})
	}
	
	function updateReadAll(chatroomId, memberId, callback, error){
		$.ajax({
			type : 'put',
			url : '/message/read/member/' + memberId + '/chatroom/' + chatroomId,
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
		})
	}
	
	function getLastMessages(memberId, callback, error){
		$.ajax({
			type : 'get',
			url : '/message/last/member/' + memberId,
			dataType : "json",
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
		})
	}
	
	function getMembers(chatroomId, callback, error){
		$.ajax({
			type : 'get',
			url : '/chattingMember/chatroom/' + chatroomId,
			dataType : "json",
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
		})
	}
	
	function getUnreadCount(memberId, callback, error) {
		$.ajax({
			type : 'get',
			url : '/message/unread/member/' + memberId,
			dataType : "json",
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
		})
	}
	
	function saveFile(file, callback, error) {
		$.ajax({
			url: '/message/file/new',
			processData : false,
			contentType : false,
			data : file,
			type : 'POST',
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
		})
	}
	
	
	// TODO: 다른 js에서 가져오기
	function getAllMembers(callback, error){
		$.ajax({
			type : 'get',
			url : '/chattingMember/all',
			dataType : "json",
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
		})
	}
	
	function createChatroom(data, callback, error){
		$.ajax({
			type : 'post',
			url : '/chatroom/new',
			data : JSON.stringify(data),
			contentType : "application/json; charset=utf-8",
			success : function(result, status, xhr) {
				if (callback) {
					callback(result);
				}
			},
			error : function(xhr, status, er) {
				console.log(er);
				console.log("error");
			}
		})
	}
	
	function deleteChatroomMemberRelation(chatroomId, memberId, callback, error){
		$.ajax({
			type: 'delete',
			url: '/chatroom/' + chatroomId + '/member/' + memberId,
			success: function(result, status, xhr) {
				if (callback) {
					callback(result);
				}
			},
			error : function(xhr, status, er) {
				console.log(er);
				console.log("error");
			}
		});
	}
	
	function getMemberDetail(memberId, callback, error){
		$.ajax({
			type : 'get',
			url : '/chattingMember/' + memberId,
			dataType : "json",
			success : function(result, status, xhr) {
				if (callback) {
					callback(result);
				}
			},
			error : function(xhr, status, er) {
				console.log(er);
				console.log("error");
			}
		})
	}
	
	function searchMessage(chatroomId, data, callback, error){
		$.ajax({
			type : 'post',
			url : '/message/search/chatroom/' + chatroomId,
			data : JSON.stringify(data),
			contentType : "application/json; charset=utf-8",
			success : function(result, status, xhr) {
				if (callback) {
					callback(result);
				}
			},
			error : function(xhr, status, er) {
				console.log(er);
				console.log("error");
			}
		})
	}

	return {
		getMessages : getMessages,
		getMessagesWithPaging : getMessagesWithPaging,
		getChatroomName : getChatroomName,
		insertMessage : insertMessage,
		getChatrooms : getChatrooms,
		updateReadStatus : updateReadStatus,
		updateReadAll : updateReadAll,
		getLastMessages : getLastMessages,
		getMembers : getMembers,
		getUnreadCount : getUnreadCount,
		saveFile : saveFile,
		getAllMembers : getAllMembers,
		createChatroom : createChatroom,
		deleteChatroomMemberRelation : deleteChatroomMemberRelation,
		getMemberDetail : getMemberDetail,
		searchMessage : searchMessage,
	};

})();
