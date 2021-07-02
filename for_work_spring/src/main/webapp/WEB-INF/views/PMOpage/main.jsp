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
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<style>

.grid-container {
  display: grid;
  grid-template-columns: 1fr 1fr;
  grid-template-rows: 1fr 1fr;
  gap: 10px 10px;
  grid-template-areas:
    "approved not-yet-approved"
    "disapproved completed";
}

.approved { grid-area: approved; }

.not-yet-approved { grid-area: not-yet-approved; }

.disapproved { grid-area: disapproved; }

.completed { grid-area: completed; }


[id^=tb]{
margin-top :30px;

}

h3{
padding-top:10px;
}

</style>
<body>

<div class="grid-container">
	  <div class="approved">
	  <c:forEach items="${count_list}" var="count">
	  <h3>
  		진행중인 프로젝트 
		  <small class="text-muted">

		  		<c:if test="${count.approval_id==2 }">
		  			<c:out value="${count.count}"/> 건
		  		</c:if>
		   </small>
	  </h3>
		  <table class="table" id="tb_approved" data-approval_id="2">
			  <thead>
			    <tr>
			      <th scope="col">Project_title</th>
			      <th scope="col">PM</th>
			      <th scope="col">Approved Date</th>
			      <th scope="col">project end Date</th>
			    </tr>
			  </thead>
			  <tbody>
			  <c:forEach items="${list_approved}" var="PMODto">
			    <tr>
			      <th scope="row"><a class="getLink" data-project_id="${PMODto.project_id}"><c:out value="${PMODto.project_title}"/></a></th>
			      <td><c:out value="${PMODto.name}"/></td>
				  <td><fmt:formatDate pattern="yyyy-MM-dd"
									value="${PMODto.check_date}" /></td>
			      <td><c:out value="${PMODto.project_end_date}"/></td>
			    </tr>
			  </c:forEach>
			  </tbody>
			</table>
		</div>
		<div class="not-yet-approved">
		 <h3>
  			승인대기 프로젝트
		  <small class="text-muted">

		  		<c:if test="${count.approval_id==1 }">
		  			<c:out value="${count.count}"/> 건
		  		</c:if>
		   </small>
	     </h3>
			<table class="table" id="tb_not_approved" data-approval_id="1">
			  <thead>
			    <tr>
			      <th scope="col">Project_title</th>
			      <th scope="col">PM</th>
			      <th scope="col">Registered Date</th>
			      <th scope="col">project start Date</th>
			    </tr>
			  </thead>
			  <tbody>
			    <c:forEach items="${list_not_yet_approved}" var="PMODto">
			    <tr>
				      <th scope="row"><a class="getLink" data-project_id="${PMODto.project_id}"><c:out value="${PMODto.project_title}"/></a></th>
			     <td><c:out value="${PMODto.name}"/></td>
			      <td><fmt:formatDate pattern="yyyy-MM-dd"
									value="${PMODto.register_date}" /></td>
			      <td><c:out value="${PMODto.project_start_date}"/></td>
			    </tr>
			    </c:forEach>
			  </tbody>
			</table>	  
		</div>
		<div class="disapproved">
		<h3>
  			반려 프로젝트
		  		  <small class="text-muted">

		  		<c:if test="${count.approval_id==3 }">
		  			<c:out value="${count.count}"/> 건
		  		</c:if>
		   </small>
	     </h3>
		<table class="table" id="tb_disapproved" data-approval_id="3">
			  <thead>
			    <tr>
			      <th scope="col">Project_title</th>
			      <th scope="col">PM</th>
			      <th scope="col">Registered Date</th>
			      <th scope="col">Disapproved Date</th>
			    </tr>
			  </thead>
			  <tbody>
			    <c:forEach items="${list_disapproved}" var="PMODto">
			    <tr>
				      <th scope="row"><a class="getLink" data-project_id="${PMODto.project_id}"><c:out value="${PMODto.project_title}"/></a></th>
			     <td><c:out value="${PMODto.name}"/></td>
			      <td><fmt:formatDate pattern="yyyy-MM-dd"
									value="${PMODto.register_date}" /></td>
			      <td><fmt:formatDate pattern="yyyy-MM-dd"
									value="${PMODto.check_date}" /></td>
			    </tr>
			    </c:forEach>
			  </tbody>
			</table>
			</div>
			<div class="completed">
		<h3>
  			완료 프로젝트
		 		  <small class="text-muted">

		  		<c:if test="${count.approval_id==4 }">
		  			<c:out value="${count.count}"/> 건
		  		</c:if>
		   </small>	     </h3>
			<table class="table" id="tb_completed" data-approval_id="4">
				  <thead>
				    <tr>
				      <th scope="col">Project_title</th>
				      <th scope="col">PM</th>
				      <th scope="col">Project end Date</th>
				      <th scope="col">Completed Date</th>
				    </tr>
				  </thead>
				  <tbody>
				    <c:forEach items="${list_completed}" var="PMODto">
				    <tr>
					      <th scope="row"><a class="getLink" data-project_id="${PMODto.project_id}"><c:out value="${PMODto.project_title}"/></a></th>
				     <td><c:out value="${PMODto.name}"/></td>
				      <td><c:out value="${PMODto.project_end_date}"/></td>
				      <td><fmt:formatDate pattern="yyyy-MM-dd"
										value="${PMODto.complete_date}" /></td>
				    </tr>
				    </c:forEach>
				  </tbody>
				</table>
		</c:forEach>		
		</div>
</div>


</body>

<script>
$(document).ready(function(){
	$(".getLink").on("click",function(){
		var project_id = $(this).data("project_id");
		self.location="get?project_id="+project_id;
	})
	
})
</script>

</html>
<%@ include file="../footer.jsp" %>