<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>logs</title>
<link rel="stylesheet"
	href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<!-- 부트스트랩 4.x를 사용한다. -->
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.min.js"></script>

<script type="text/javascript">
	$(function() {
		var obj = function() {
			var list = {};
			var href = document.location.href.split("/");
			var task_id = href[href.length - 1];
			
			$.ajax({
				url : "/task/logs/get/" + task_id,
				method : "GET",
				dataType : "json",
				async : false,
				success : function(data) {
					console.log("success");
					list = data;
				},
				error : function(e) {
					console.log("error");
				}
			});

			return list;
		}();
		
		if(obj != null){
			var str = "<table class='table table-striped'><thead><tr><th>log</th><th>Date</th></tr></thead><tbody>";
			for(var i = 0; i < obj.length; i++){
				str+= "<tr><td>"+obj[i].log_detail +"</td><td>"+new Date(obj[i].log_time)+"</td></tr>";
			}
			str+="</tbody></table>"
				$(".logs").html(str);
		}
		
	});
</script>

</head>
<body>
	<div class="logs"></div>
</body>
</html>