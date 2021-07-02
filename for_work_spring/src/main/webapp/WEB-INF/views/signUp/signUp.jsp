<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<title>ForWork : 회원가입</title>
		<link rel="stylesheet" href="../../../resources/assets/css/signUp.css">
		
	</head>
	<body>
		<!-- header -->
		<div id="header">
			<img src="../../../resources/Img/forworklogo.JPG" id="logo">
		</div>


		<!-- wrapper -->
		<div id="wrapper">
		<form method="post" action="/member/signUp">
			<!-- content-->
			<div id="content">
			
				<!-- EMAIL -->
				<div>
					<h3 class="join_title"><label for="email">이메일<span class="optional"></span></label></h3>
					<span class="box int_email">
						<input type="email" name="email" id="email" class="int" maxlength="100" placeholder="abcd1234@gmail.com">
					</span>
					<span class="error_next_box">이메일 주소를 다시 확인해주세요.</span>	
				</div>
				

				<!-- PW1 -->
				<div>
					<h3 class="join_title"><label for="pswd1">비밀번호</label></h3>
					<span class="box int_pass">
						<input type="password" id="pswd1" name="pw" class="int" maxlength="20"
						placeholder="8자이상 특수문자포함"
						pattern="^(?=.*[A-Za-z])(?=.*\d)(?=.*[$@$!%*#?&])[A-Za-z\d$@$!%*#?&]{8,}$">
						<span id="alertTxt">사용불가</span>
						<img src="../../../resources/Img/pw.jpg" id="pswd1_img1" class="pswdImg">
					</span>
					<span class="error_next_box"></span>
				</div>

				<!-- PW2 -->
				<div>
					<h3 class="join_title"><label for="pw">비밀번호 확인</label></h3>
					<span class="box int_pass_check">
						<input type="password" id="pswd2" name="pwck" class="int" maxlength="20">
						<img src="../../../resources/Img/pw.jpg" id="pswd2_img1" class="pswdImg">
					</span>
					<span class="error_next_box"></span>
					<span id="alert-success" style="display: none;">비밀번호가 일치합니다.</span>
					<span id="alert-danger" style="display: none;color: #d92742; font-weight: bold;  ">비밀번호가 일치합니다.</span>
				</div>

				<!-- NAME -->
				<div>
					<h3 class="join_title"><label for="name">이름</label></h3>
					<span class="box int_name">
						<input type="text" id="name" name="name" class="int" maxlength="20">
					</span>
					<span class="error_next_box"></span>
				</div>

				

				<!-- MOBILE  추후 추가되면 프로젝트 진행-->
				<!--   <div>
					<h3 class="join_title"><label for="phoneNo">휴대전화</label></h3>
					<span class="box int_mobile">
						<input type="tel" id="mobile" class="int" maxlength="16" placeholder="전화번호 입력">
					</span>
					<span class="error_next_box"></span>	
				</div> --> 


				<!-- JOIN BTN-->
				<div class="btn_area" >
					<button type="submit" id="btnJoin" value="회원가입">
						<span>가입하기</span>
					</button>
				</div>
				
				
				
		
			</div> 
			</form>
			<!-- content-->

		</div> 
		<!-- wrapper -->
	<script src="main.js">
	function check() {
		if(!document.user.userid.value){
			alert("비밀번호를 입력하세요.")
			return false;
		}else if(document.user.userpw.value !== document.user.userpwck.value){
			alert("비밀번호를 다시 입력하세요.")
			return false;
		}else if(!document.user.real_name.value){
			alert("이름을 입력하세요.")
			return false;
		}else if(!document.user.userphone.value){
			alert("번호를 입력하세요.")
			return false;
		}else if (!ischeckId){
			alert("아이디 중복-확인을 하세요.")
			return false;
		}
	}
	var ischeckId = false;
	var expId = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
		$('#userid').blur(function(){
			var id = $('#userid').val();

			$.ajax({
				url : '/member/idCheck?userid='+id,
				type : 'get',
				success : function (data){
					console.log(data);
					if (data == 1){
						$("#check").text("사용중인 아이디입니다.");
					}else if (data == 0){
						if (!expId.test(id)){
							$("#check").text("이메일 형식이 아닙니다.");
						}else {
							$("#check").text("사용가능한 아이디입니다.");
							ischeckId = true;
						}
					}
				}
				,error:function(request,status,error){
				alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);}

			})
		});
	</script>
	</body>
</html>