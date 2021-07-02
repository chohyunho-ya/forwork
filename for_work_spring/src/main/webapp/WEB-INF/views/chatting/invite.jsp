<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<sec:authorize access="isAuthenticated()">
	<sec:authentication property="principal.member" var="member" />
</sec:authorize>
<title>Insert title here</title>
<style type="text/css">
.title-container {
	width: 100%;
	background-color: rgb(212, 214, 241);
	height: 80px;
	margin: auto;
}

.title {
	margin-left: 43%;
	line-height: 80px;
	font-weight: bold;
	font-size: 20px;
}

.search {
	padding-left: 2%;
	width: 97%;
	height: 40px;
	margin-top: 10px;
	border: 1px solid rgb(212, 211, 211);
}

.chatroom-title {
	padding-left: 2%;
	width: 20%;
	height: 40px;
	margin-top: 30px;
	border: 1px solid rgb(212, 211, 211);
}

.search:focus {
	outline: none !important;
	border: 1px solid #5a1ac0;
}

.btn {
	background-color: #5a1ac0;
	padding: 15px;
	border-radius: 10px;
	color: white;
	font-size: 13px;
	text-decoration: none;
	margin-right: 20px;
}

#all {
	height: 900px;
}

#member {
	height: 70%;
}

#footer {
	margin-left: 45%;
}

.member-list {
	list-style: none;
}

.member-list li {
	float: left;
	padding-top: 30px;
	line-height: 40px;
}

.member-list li:hover {
	font-weight: bold;
	cursor: pointer;
	color: #5a1ac0;
}

.bold {
	font-weight: bold;
	color: #5a1ac0;
}

.profile {
	padding-top: 30px;
	padding-right: 20px;
	float: left;
	clear: both;
}

.bubble {
	display: inline-block;
	max-width: 300px;
	font-size: 14px;
	position: relative;
}
</style>
</head>
<body>
	<div id="all">
		<div class="title-container">
			<div class="title">대화상대 초대</div>
		</div>
		<input type="text" class="search" placeholder="이름으로 검색해보세요"
			onkeyup="search()" /> <input type="text" class="chatroom-title"
			placeholder="채팅방 제목을 입력해주세요" />
		<div id="member"></div>
		<div id="footer">
			<a href="#" class="btn" onclick="history.back()">취소</a><a href="#" class="btn"
				onclick="createChatroom(this)"><span id="num-member">0</span>명
				초대</a>
		</div>
	</div>
	<input type="text" value="${member.member_id }" id="user"
		style="display: none;">
</body>
<script src="/resources/assets/vendor/jquery/dist/jquery.min.js"></script>
<script type="text/javascript" src="/resources/js/chatting.js"></script>
<script>
	let memberContainer = document.querySelector("#member");
	let numSelected = document.querySelector("#num-member");
	let chatroomTitle = document.querySelector(".chatroom-title");
	let userId = document.getElementById("user").value;
	let selectedMembers = [userId];
	let allMembers = [];
	
	chattingService.getAllMembers(function(members){
		showMember(members);
		allMembers = members;
		console.log(allMembers);
	})
	
	function addMember(e){
		let memberId = e.dataset.memberId;
		if (selectedMembers.includes(memberId)){
			let idx = selectedMembers.indexOf(memberId);
			if (idx > -1) selectedMembers.splice(idx, 1);
			e.classList.remove("bold");
		} else {
			selectedMembers.push(memberId);
			e.classList.add("bold");
		}
		numSelected.innerHTML = selectedMembers.length-1;
	}
	
	function createChatroom(e){
		if (!chatroomTitle.value){
			alert("제목을 입력해주세요!");
			chatroomTitle.focus();
			return;
		}
		if (selectedMembers.length == 1){
			alert("초대할 멤버를 선택해주세요!");
			return;
		}
		let data = {
			"title": [chatroomTitle.value],
			"memberIds": selectedMembers
		}
		chattingService.createChatroom(data, function(chatroomId){
			console.log(chatroomId);
			window.location.href = "/chatting/detail/" + chatroomId;
		})	
	}
	
	function showMember(members){
		html = "<ul class='member-list'>";
		members.forEach(member => {
			if(member.member_id !== userId){
				html += '<img class="bubble profile" src="/resources/Img/profile.png" width="38"><li class="member" data-member-id="' + member.member_id + '" onclick="addMember(this)">' + member.name + "</li>"	
			}
		})
		console.log(allMembers);
		html += "</ul>";
		memberContainer.innerHTML = html;
	}
	
	function search(){
		let query = document.querySelector(".search").value;
		console.log(query);
		showMember(allMembers.filter(m => m.name.includes(query)));
	}
	
</script>
</html>
