<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
		<!-- projectOffice.js -->
	<script type="text/javascript" src="/resources/js/projectOffice.js"></script>	
	<!-- jQuery library -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
		<!-- Popper JS -->
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
	
	
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>PMOPage_project_detail</title>
	<style>
		table {
			margin: 30px auto auto;
			width: 80%;
			border: 1px solid #b4b4b4;
			font-size:20px;
			background:#dcdcdc;
			font-family:-apple-system,BlinkMacSystemFont,"Segoe UI",Roboto,"Helvetica Neue",Arial,sans-serif,"Apple Color Emoji","Segoe UI Emoji","Segoe UI Symbol";
		}
		
		.first-row {
		text-align:center;
			background: #c8c8c8;
			border-bottom: 1px solid #ccc;
		}
		#check_date{
	border-bottom: 0px;
		}
		#register_date{
		border-bottom: 0px;
		}
		
		#title {
			font-weight: bold;
			font-size: 30px;
		}
		#button-group{
		margin:auto;
		}
		
</style>
</head>
	<body>
	
		
	<table>
				<tr class="first-row">
					<td rowspan="3" colspan="3" id="title"> <c:out value="${project.project_title}"/></td>
					<td class="project-date" id="register_date">생성일 : <fmt:formatDate pattern="yyyy-MM-dd"
                           value="${timeline.register_date}" /></td>	
                	<c:set var = "approval_id" scope = "session" value = "${project.approval_id}"/>
				  	 <c:choose>
						<c:when test = "${approval_id ==1 }">
							<td rowspan="3" id="apporval_detail">상태: <span
								class='badge badge-warning'>승인대기</span>
							</td>
							<td rowspan="3" id="button-group">
								<div data-approval_id='2' class='btn btn-success'>승인</div>
								<div data-approval_id='3' class='btn btn-danger'>반려</div>
							</td>
						</c:when>
						
						<c:when test = "${approval_id ==2 }">
							<td rowspan="3" id="apporval_detail">상태: <span
								class='badge badge-success'>승인</span>
							</td>
							<td rowspan="3" id="button-group">
								<div data-approval_id='4' class='btn btn-primary'>완료</div>
							</td>	
				  	  </c:when>
						<c:when test = "${approval_id ==3 }">
						<td rowspan="3" id="apporval_detail">상태: <span
								class='badge badge-danger'>반려</span>
							</td>
							<td rowspan="3" id="button-group">
							</td>
				  	  </c:when>
						<c:when test = "${approval_id ==4 }">
							<td rowspan="3" id="apporval_detail">상태: <span
								class='badge badge-primary'>완료</span>
							</td>
							<td rowspan="3" id="button-group">
							</td>		  	  
						</c:when>
				  	 </c:choose>
				  	 </tr>
				  	 
					<tr class="first-row">
					  <c:set var = "approval_id" scope = "session" value = "${project.approval_id}"/>
					  <c:choose>
					  <c:when test="${approval_id ==3 }">
					  <td class="project-date" id="check_date">반려일: <fmt:formatDate pattern="yyyy-MM-dd"
	                           value="${timeline.check_date}" /></td>
					  </c:when>
					  <c:otherwise>
						<td class="project-date" id="check_date">승인일 : <fmt:formatDate pattern="yyyy-MM-dd"
	                           value="${timeline.check_date}" /></td>
	                  </c:otherwise>
	                  </c:choose>
					</tr>
	
					<tr class="first-row">
						<td class="project-date" id="complete_date">완료일 : <fmt:formatDate pattern="yyyy-MM-dd"
	                           value="${timeline.complete_date}" /></td>
					</tr>
	
					<tr>
						<td></td>
						<td id="PM"><c:out value="${project.name}"/>(PM)</td>
						<td colspan="2" id="PA"><c:forEach items="${memberList}" var="member">
				 	<c:out value="${member.name}"/>
				  </c:forEach></td>
						<td colspan="2" id="term" >프로젝트 기간 : <c:out value="${project.project_start_date}"/>~<c:out value="${project.project_end_date}"/></td>
					</tr>
					<tr>
					<td rowspan="5" colspan="5"></td>
					<tr>
	
				</table>
				  	 
<script type="text/javascript">
	$(document).ready(function(){
		
		 $(document).on("click", "[class^=btn]", function(){
			 console.log("btn click!");
			 
		      var p_id = '<c:out value ="${project_id}"/>';
		      var a_id = $(this).data("approval_id")+"";
		      console.log(a_id);
		      projectOfficeService.update({
		             project_id:p_id,
		             approval_id:a_id
		          },function(result){
		            
		        	  alert("RESULT: "+result);
					
		          })//update 서비스 끝
 		            location.href="main"; 
		          
		});
		
		
	});
	

</script>
</body>
</html>
<%@ include file="../footer.jsp" %>