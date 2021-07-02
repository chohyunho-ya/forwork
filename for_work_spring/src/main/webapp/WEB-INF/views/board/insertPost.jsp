<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css"
	integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l"
	crossorigin="anonymous">

<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.1/font/bootstrap-icons.css">

<!-- Optional JavaScript; choose one of the two! -->

<!-- Option 1: jQuery and Bootstrap Bundle (includes Popper) -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
	integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-Piv4xVNRyMGpqkS2by6br4gNJ7DXjqk09RmUpJ8jgGtD7zP9yug3goQfGII0yAns"
	crossorigin="anonymous"></script>
<script type="text/javascript">

function list() {
	window.location.href = "/board/list?project_id=${board.project_id}&board_id=${board.board_id}";
}

</script>

<style type="text/css">

* {
	box-sizing: border-box;
}

.container {
	margin: 0px;
}

.list-group-item {
	height: 37px;
}

.boardMenuList {
	border: 2px solid gray;
	min-height: 450px;
	width: 185px;
	margin-top: 40px;
	font-size: 14px;
	position: relative;
	padding: 10px;
	border-radius: 10px;
	position: relative;
	left: 10px;
}

.boardManagerBtn {
	position: absolute;
	bottom: 10px;
	left: 10px;
}

.container a {
	text-decoration: none;
	color: #000;
}

.container a:hover {
	font-weight: bold;
}

.postWrap {
	margin-top: 30px;
	padding-left: 40px;
	position: relative;
}

.title {
	font-size: 15px;
	margin-bottom: 20px;
}

.postTitle {
	font-weight: bold;
	font-size: 20px;
	width: 900px;
}

.postTitle input {
	border: none;
	height: 40px;
	padding-bottom: 5px;
}

table {
	border-collapse: collapse;
	margin-bottom: 20px;
}

.postContent {
	border-bottom: 1px solid gray;
	padding: 5px;
}

.postAttach {
	border-top: 1px solid gray;
	border-bottom: 1px solid gray;
	padding: 10px 0px;
	font-size: 14px;
}

.postAttach input {
	margin-left: 10px;
	font-size: 13px;
}

.contentBox {
	min-height: 260px;
	padding: 5px;
}

.contentBox textarea {
	border: none;
	font-size: 18px;
}

.btnArea {
	position: relative;
}

.editBtn {
	position: absolute;
	top: 0px;
	right: 0px;
}

.listBtn {
	position: absolute;
	left: 10px;
}

.postAttachResult li {
	list-style: none;
	margin-right: 30px;
	margin-bottom: 5px;
}

.postAttachResult ul {
	display: flex;
	flex-wrap: wrap;
}

.attachResultTr {
	display: none;
}

.deleteFileBtn {
	height: 20px;
	width: 20px;
}

.btn-light {
	width: 30px;
	height: 30px;
	text-align: center;
	position: relative;
}

.bi-x {
	position: absolute;
	top: 3px;
	left: 6px;
}

</style>
<title>Insert title here</title>
</head>
<body>

	<div class="wrap">
		<div class="container">
			<div class="row">
				<div class="col-2">

					<div class="boardMenuList">
						<ul class="list-group list-group-flush">
							<li class="list-group-item"><a href="/board/main/${board.project_id}"><i class="bi bi-house-door"></i> 게시판 홈</a></li>
							<c:forEach var="menu" items="${menu}">
								<li class="list-group-item">
									<a href="/board/list?project_id=${menu.project_id}&board_id=${menu.board_id}">
									<i class="bi bi-clipboard"></i> ${menu.board_name}</a></li>
							</c:forEach>
						</ul>
						<a href="/board/manager?project_id=${board.project_id}" class="boardManagerBtn"><i class="bi bi-pencil-square"></i> 게시판 관리</a>
					</div>

				</div>
				<div class="col-10">
					<div class="postWrap">
						<div class="title">${board.board_name}</div>
						
						<form role="form">
							<input type="hidden" name="board_id" value="${board.board_id}">
							<input type="hidden" name="project_id" value="${board.project_id}">
						<table>
							<tr>
								<td colspan="3" class="postTitle">
									<input type="text" name="post_title" size="100" placeholder="제목을 입력하세요.">
								</td>
							</tr>
							<tr>
								<td colspan="3" class="postWriter">
									<input type="hidden" name="post_writer" value="${member.name}">
								</td>
							</tr>
							<tr>
								<td colspan="3" class="postAttach">
									첨부 파일 <input type="file" name="uploadFile" multiple>
								</td>
							</tr>
							<tr class="attachResultTr">
								<td colspan="3" class="postAttachResult">
									<ul>
										
									</ul>
								</td>
							</tr>
							<tr>
								<td colspan="3" class="postContent">
									<div class="contentBox">
										<textarea rows="10" cols="110" name="post_content" placeholder="내용을 입력하세요."></textarea>
									</div>
								</td>
							</tr>
						</table>
						
						</form>
						<div class="btnArea">
							<div class="listBtn">
								<button onclick="list()">취소</button>
							</div>
							<div class="editBtn">
								<button type="button" id="saveBtn">저장</button>
							</div>
						</div>
						
					</div>
				</div>
				<!-- col-10 -->
			</div>
		</div>
	</div>
	
	<script type="text/javascript" src="/resources/js/post.js"></script>
	
	<script type="text/javascript">
	
		$(document).ready(function() {
									
			var board_id = '<c:out value="${board.board_id}"/>';
			var saveBtn = $("#saveBtn");
			
			var regex = new RegExp("(.*?)\.(exe|sh|zip|alz)$");
			var maxSize = 5242880; // 5MB
			
			function checkExtension(fileName, fileSize) {
				if (fileSize >= maxSize) {
					alert("파일 용량이 초과되었습니다.");
					return false;
				}
				
				if (regex.test(fileName)) {
					alert("해당 종류의 파일은 첨부할 수 없습니다.");
					return false;
				}
				
				return true;
			}
			
			var uploadResult = $(".postAttachResult ul");
			
			function showUploadedFile(uploadResultArr) {
				var str = "";
				
				$(uploadResultArr).each(function(i, obj) {
					str += "<li>" + obj.fileName + "</li>";
				});
				uploadResult.append(str);
			}
			
			saveBtn.on("click", function(e) {
				
				var post_title = $("input[name='post_title']").val();
				var post_writer = $("input[name='post_writer']").val();
				var post_content = $("textarea[name='post_content']").val();
				
				if (!post_title) {
					alert("제목을 입력하세요.");
					return false;
				} else if (!post_content) {
					alert("내용을 입력하세요.");
					return false;
				} 
				
				var attachList = [];
				
				$(".postAttachResult ul li").each(function(i, obj) {		
				      var jobj = $(obj);
				      
				      console.dir(jobj);
				      
				      var attach = {
				    		  uuid:jobj.data("uuid"),
				    		  uploadPath:jobj.data("path"),
				    		  fileName:jobj.data("filename"),
				    		  fileType:jobj.data("type")
				      };
				      
				      attachList.push(attach);
				});				
				
				var post = {
					board_id:board_id,
					post_title:post_title,
					post_writer:post_writer,
					post_content:post_content,
					attachList:attachList
				};
				
				postService.add(post, function(result) {
					if (result == "success") alert("게시글이 등록되었습니다.");
					list();
				});
				
			});			
			
			function showUploadResult(uploadResultArr) {
				
				if(!uploadResultArr || uploadResultArr.length == 0){ return; }
				
				var uploadUL = $(".postAttachResult ul");
				
				str = "";
				
				$(uploadResultArr).each(function(i, obj) {
					
					var fileCallPath =  encodeURIComponent( obj.uploadPath+"/"+ obj.uuid +"_"+obj.fileName);
					var fileLink = fileCallPath.replace(new RegExp(/\\/g),"/");
					
					str += "<li data-path='"+obj.uploadPath+"' data-uuid='"+obj.uuid+"' data-filename='"+obj.fileName+"' data-type='"+obj.image+"'>"
					str += "<div><i class='bi bi-paperclip'></i> " + obj.fileName;
					str += "<button type='button' class='btn btn-light' data-file=\'"+fileCallPath+"\' data-type='file' class='deleteFileBtn'>";
					str += "<i class='bi bi-x'></i></button></div></li>"
					
				});
				uploadUL.append(str);
			}
			
			$("input[type='file']").change(function(e) {
				
				// 첨부 파일
				var formData = new FormData();
				var inputFile = $("input[name='uploadFile']");
				var files = inputFile[0].files;
				
				for (var i = 0; i < files.length; i++) {
					
					if (!checkExtension(files[i].name, files[i].size)) {
						return false;
					}
					
					formData.append("uploadFile", files[i]);
				}
				
				$.ajax({
					url: '/uploadAjaxAction',
					processData: false,
					contentType: false,
					data: formData,
					type: 'POST',
					dataType: 'json',
					success: function(result) {
						console.log(result);
						$(".attachResultTr").show();
						showUploadResult(result);
					}
				}); // ajax
				
			});
			
			$(".postAttachResult").on("click", "button", function(e) {
				
				console.log("delete file");
				
				var targetFile = $(this).data("file");
			    var type = $(this).data("type"); 
			    var targetLi = $(this).closest("li");
			    
			    $.ajax({
			      url: '/deleteFile',
			      data: {fileName: targetFile, type:type},
			      dataType:'text',
			      type: 'POST',
			        success: function(result){
			           
			           targetLi.remove();
			         }
			    }); //$.ajax
				
			});
			
		});
	
	</script>

</body>
</html>
<%@ include file="../footer.jsp"%>
