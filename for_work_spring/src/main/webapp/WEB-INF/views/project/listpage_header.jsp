<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>

<head>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.min.js"></script>

	<sec:authorize access="isAuthenticated()">
		<sec:authentication property="principal.member" var="member"/>
		</sec:authorize>
		
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="Start your development with a Dashboard for Bootstrap 4.">
<meta name="author" content="Creative Tim">
<title>FORWORK</title>
<!-- Favicon -->
<link rel="icon" href="../../resources/assets/img/brand/favicon.png" type="image/png">
<!-- Fonts -->
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Open+Sans:300,400,600,700">
<!-- Icons -->
<link rel="stylesheet" href="../../resources/assets/vendor/nucleo/css/nucleo.css" type="text/css">
<link rel="stylesheet" href="../../resources/assets/vendor/@fortawesome/fontawesome-free/css/all.min.css" type="text/css">
<!-- Page plugins -->
<!-- Argon CSS -->
<link rel="stylesheet" href="../../resources/assets/css/argon.css?v=1.2.0" type="text/css">
<style type="text/css">
	.unread-color {
		background-color: #FD7860;
		color: white;
		padding: 3px;
		font-size: 1px;
		padding-left: 8px;
		padding-right: 8px;
		border-radius: 300px;
	}
	.add-chat {
		margin-left: 350px;
	}
</style>


</head>

<body>
<%@ include file="./listpage_sidebar.jsp" %>
	
<!-- Main content -->
<div class="main-content" id="panel">
	<!-- Topnav -->
	<nav class="navbar navbar-top navbar-expand navbar-dark bg-primary border-bottom">
	  <div class="container-fluid">
		<div class="collapse navbar-collapse" id="navbarSupportedContent">
		  <!-- Search form -->
		  <form class="navbar-search navbar-search-light form-inline mr-sm-3" id="navbar-search-main">
			<div class="form-group mb-0">
			  <div class="input-group input-group-alternative input-group-merge">
				<div class="input-group-prepend">
				  <span class="input-group-text"><i class="fas fa-search"></i></span>
				</div>
				<input class="form-control" placeholder="Search" type="text">
			  </div>
			</div>
			<button type="button" class="close" data-action="search-close" data-target="#navbar-search-main" aria-label="Close">
			  <span aria-hidden="true">Ã</span>
			</button>
		  </form>
		  <!-- Navbar links -->
		  <ul class="navbar-nav align-items-center  ml-md-auto ">
			<li class="nav-item d-xl-none">
			  <!-- Sidenav toggler -->
			  <div class="pr-3 sidenav-toggler sidenav-toggler-dark" data-action="sidenav-pin" data-target="#sidenav-main">
				<div class="sidenav-toggler-inner">
				  <i class="sidenav-toggler-line"></i>
				  <i class="sidenav-toggler-line"></i>
				  <i class="sidenav-toggler-line"></i>
				</div>
			  </div>
			</li>
			
			<li class="nav-item dropdown">
			  <a class="nav-link" href="#" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
				<i class="ni ni-chat-round"></i>
			  </a>
			  <div class="dropdown-menu dropdown-menu-xl  dropdown-menu-right  py-0 overflow-hidden">
				<!-- Dropdown header -->
				<div class="px-3 py-3">
					<a href="/chatting/invite"><img alt="Image placeholder" src="/resources/Img/add-chat.png" class="add-chat" width="30px"></a>
				  <h6 class="text-sm text-muted m-0">You have <strong class="text-primary" id="n-chatroom"></strong> chatrooms.</h6>
				</div>
				<!-- List group -->
				<div id="listChat">
				</div>
			  </div>
			</li>
		  </ul>
		  <ul class="navbar-nav align-items-center  ml-auto ml-md-0 ">
			<li class="nav-item dropdown">
			  <a class="nav-link pr-0" href="#" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
				<div class="media align-items-center">
				  <span class="avatar avatar-sm rounded-circle">
					<i class="ni ni-single-02"></i>
				  </span>
				  <div class="media-body  ml-2  d-none d-lg-block">
					<span class="mb-0 text-sm  font-weight-bold">${member.name}</span>
				  </div>
				</div>
			  </a>
			  <div class="dropdown-menu  dropdown-menu-right ">
				<div class="dropdown-header noti-title">
				  <h6 class="text-overflow m-0">Welcome!</h6>
				</div>
				<a href="/myprofile/main" class="dropdown-item">
				  <i class="ni ni-single-02"></i>
				  <span>My profile</span>
				</a>
				<a href="#!" class="dropdown-item">
				  <i class="ni ni-settings-gear-65"></i>
				  <span>Settings</span>
				</a>
				<a href="#!" class="dropdown-item">
				  <i class="ni ni-calendar-grid-58"></i>
				  <span>Activity</span>
				</a>
				<a href="#!" class="dropdown-item">
				  <i class="ni ni-support-16"></i>
				  <span>Support</span>
				</a>
				<sec:authorize access="isAuthenticated()">
				<div class="dropdown-divider"></div>
				<a href="/logout" class="dropdown-item">
				  <i class="ni ni-user-run"></i>
				  <span>logout</span>
				  </sec:authorize>
				</a>
			  </div>
			</li>
		  </ul>
		</div>
	  </div>
	</nav>
<input type="text" value="${member.member_id }" id="user" style="display:none;">
<script src="https://cdn.jsdelivr.net/npm/sockjs-client@1/dist/sockjs.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/stomp.js/2.3.3/stomp.min.js"></script>
<script src="/resources/assets/vendor/jquery/dist/jquery.min.js"></script>
<script type="text/javascript" src="/resources/js/chatting.js"></script>
<script type="text/javascript">
	let stompClient2 = null;
	let socket2 = new SockJS("/websocket");

	stompClient2 = Stomp.over(socket2);
	let userId = document.getElementById("user").value;
	
	chattingService.getUnreadCount(userId, function(unreadCountPerChatroom){
		chattingService.getChatrooms(userId, function(chatrooms){
			chattingService.getLastMessages(userId, function(lastMessages){
				console.log(lastMessages);
				let chatroomBox = document.querySelector("#listChat");
				let chatroomNumber = document.querySelector("#n-chatroom");
				chatroomNumber.innerHTML = chatrooms.length;
				let html = "";
				chatrooms.forEach(chatroom => {
					let lastMessageOfChatroom = lastMessages.find(m => m.chatroom_id === chatroom.chatroom_id);
					let unreadCountOfChatroom = unreadCountPerChatroom.find(data => data.chatroomId === chatroom.chatroom_id);
					if (!unreadCountOfChatroom){
						unreadCountOfChatroom = {
							"unreadCount" : 0
						}
					}
					html += 
					'<div class="list-group list-group-flush">' + 
						'<a href="/chatting/detail/' + chatroom.chatroom_id + '" class="list-group-item list-group-item-action">'+
							'<div class="row align-items-center">'+
								'<div class="col-auto">' +'<img alt="Image placeholder" src="/resources/Img/chatroom.png" class="avatar rounded-circle">'+'</div>' +
								'<div class="col ml--2">' +
									'<div class="d-flex justify-content-between align-items-center">' +
										'<div>' +'<h4 class="mb-0 text-sm">' + chatroom.chatroom_name + '</h4>' +'</div>' +
										'<div class="text-right text-muted">' +'<small id="last-sent-time' + chatroom.chatroom_id + '">' + lastMessageOfChatroom.send_time + '</small>' + '</div>' +
									'</div>' +
									'<p class="text-sm mb-0"  id="last-sent-msg' + chatroom.chatroom_id + '">';
					if (unreadCountOfChatroom.unreadCount !== 0){
						html += '<span class="unread-color" id="unread' + chatroom.chatroom_id + '">' + unreadCountOfChatroom.unreadCount + '</span>&nbsp;&nbsp;&nbsp;'
					}
					html += lastMessageOfChatroom.message + '</p>' +
								'</div>' +
							'</div>' +
						'</a>' +
					'</div>'
				})
				chatroomBox.innerHTML = html;
			})
		});
	})
	
	
	stompClient2.connect({}, function(frame){
  		console.log('connected: ' + frame);
  		stompClient2.subscribe("/topic/user/" + userId, function(response){
  			notify(JSON.parse(response.body));
  			updateLastMessage(JSON.parse(response.body));
  		});
  	}, function(error) {
  		console.log(error);
  	}); 
  	
  	function notify(msg){
  		if (msg.sender.member_id !== userId){
  			const img = '/resources/Img/forworklogo.JPG';
  	  		if (Notification.permission !== "denied") {
  	  			Notification.requestPermission(permission => {
  	  			  if (permission === "granted") {
  	  				const option = { body: msg.message, icon: img };
  	  				new Notification(msg.sender.name, option);
  	  			  } else {
  	  			  }
  	  			});
  	  		  }
  		}
  	}
  	
  	function updateLastMessage(msg){
  		let lastSentTime = document.querySelector("#last-sent-time" + msg.chatroom_id);
  		lastSentTime.innerHTML = msg.send_time;
  		
  		let lastSentMsg = document.querySelector("#last-sent-msg" + msg.chatroom_id);
  		lastSentMsg.innerHTML = msg.message;
  	}
</script>