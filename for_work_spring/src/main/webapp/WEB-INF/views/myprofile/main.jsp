<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>
<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>


	<!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
	

	<!-- jQuery library -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	
	<!-- Popper JS -->
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
	<!-- Portfolio.js -->
	<script type="text/javascript" src="/resources/js/portfolio.js"></script>

		<!-- CSS -->
	<link rel="stylesheet" type="text/css" href="../CSS/myprofile.css">
	<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
    <script type="text/javascript">
    google.charts.load('current', {'packages':['corechart']});
	google.charts.setOnLoadCallback(drawChart);
        
        var m_id = '<c:out value ="${member_id}"/>';
        
        function drawChart(){
        	var langCount= $.ajax({
    			type:'get',
    			url:'/myprofile/'+m_id+'/chart.json',
    			dataType:"json",
    			async:false
    		}).responseText;
        		console.log("춤");
        		console.log(langCount); 
        		console.log(m_id);
        		
        		// 문자열 langCount를 jsonarray로 parse
        		var contact = JSON.parse(langCount);
        		console.log(contact.length);
            
    				
    			var str='';
    			var array=[['Programming Language','Count']];
    			
    		      
    			for(var i = 0 ; i<contact.length;i++){

    				var language= contact[i].language;
    				var Count= contact[i].LANGUAGE_COUNT;
    				var countNum=parseInt(Count);
    				var innerArr=[];
    				innerArr.push(language);
    				innerArr.push(countNum);
    				array.push(innerArr);
    				}

    			console.log(array);
    			var data = google.visualization.arrayToDataTable(array);
    			var options = {'title': ''}; 
    			var chart = new google.visualization.PieChart(document.getElementById('piechart'));
    			chart.draw(data, options);
        	
        }
        $(document).ready(function(){
			$(".alert-heading").click(function(){
				var submenu = $(".alert-heading-content");
				if( submenu.is(":visible")){
				submenu.slideUp();
				}else{
				submenu.slideDown();
				}
			});
		});
	</script>
<style>
	
.grid-container {
  display: grid;
  grid-template-columns: 1.2fr 0.7fr;
  grid-template-rows: 100px 1fr;
  gap: 0px 0px;
  grid-template-areas:
    "title-container title-container"
    "portfolio-container myprofile-title-container";
}

.portfolio-container { padding:10px;
padding-right:20px;
grid-area: portfolio-container;
border: #EFF2FB 5px solid;
border-radius: 15px; }



.title-container { grid-area: title-container; display: grid;
  grid-template-columns: 1.2fr 0.7fr;
  grid-template-rows: 1fr;
  gap: 0px 0px;
  grid-template-areas:
    "add-portfolio .";
    height: 60px;}
    
.add-portfolio { grid-area: add-portfolio;
position:relative;
padding:20px;
}

#addBtn{
position:absolute;


}

ul{
list-style:none;
padding-left:0px;
}

.grid-container2 {
  display: grid;
  grid-template-columns: 1fr;
  grid-template-rows: 0.8fr 1.4fr 0.8fr;
  gap: 0px 0px;
  grid-template-areas:
    "portfolio-term"
    "portfolio-detail"
    "portfolio_language_List";
}
.portfolio-term { grid-area: portfolio-term; 
position: relative;}
.portfolio-detail { grid-area: portfolio-detail; }
.portfolio_language_List { grid-area: portfolio_language_List; }




.btn-primary {
    color: #fff;
    background-color: #303c6c;
    border-color: #303c6c;
    float:right;
    position:relative;
	top:55px;
	padding:10px;
}

.badge badge-pill badge-primary{
padding:3px;
}

.myprofile-title-container { grid-area: myprofile-title-container; display: grid;
padding-right:30px;
  grid-template-columns: 1fr;
  grid-template-rows: 80px 400px;
  gap: 0px 0px;
  grid-template-areas:
    "profile_info"
    "profile_chart";}

.profile_info { grid-area: profile_info;
display: grid;
  grid-template-columns: 1fr;
  grid-template-rows: 1fr 1fr 1fr;
  gap: 0px 0px;
  grid-template-areas:
    "profile_name"
    "profile_status"
    "profile_email"; }
    
.profile_chart { grid-area: profile_chart; margin-top:100px;}

.profile_name { grid-area: profile_name; }
.profile_status { grid-area: profile_status;
display: grid;
  grid-template-columns: 0.7fr 0.3fr; 
  grid-template-rows: 1fr;
  gap: 0px 0px;
  grid-template-areas:
  "status" "statusBtnPlace";
  position: relative;
  }
  
  .status { grid-area: status; }
  .statusBtnPlace { grid-area: statusBtnPlace;
  position:relative; 
  right:0px;
}
.profile_email { grid-area: profile_email; }


[id^=icon_edit]{
position: absolute;
right: 3px;
top: 3px;

}

[id^=icon_delete]{
position: absolute;
right: 50px;
top: 3px;

}

div[id^=member]{
text-align: center;
}



</style>

</head>
<body>
<div class="grid-container">
  <div class="portfolio-container">
  
	  <div id="accordion">
<!-- portfolio-list ul 시작 -->
	  <ul class="portfolio-list">
	  <div class="card">
	  <li class="left clearfix" portfolio_id='1'>
	    <div class="card-header" id="headingOne">
	      <h5 class="mb-0">
	        <button class="btn btn-link" data-toggle="collapse" data-target="#collapseOne" aria-expanded="true" aria-controls="collapseOne">
	          	포트폴리오 제목
	        </button>
	      </h5>
	    </div>
	    <div id="collapseOne" class="collapse show" aria-labelledby="headingOne" data-parent="#accordion">
	      <div class="card-body">
			<div class="grid-container2">
				<div class="portfolio-term">
				포트폴리오 기간
				</div>
	 			<div class="portfolio-detail">
	 			포트폴리오 상세
	 			</div>
	  			<div class="portfolio_language_List">
	  			<span class="badge badge-pill badge-primary">Java</span>
	  			<span class="badge badge-pill badge-primary">CSS</span>
	  			<span class="badge badge-pill badge-primary">JavaScript</span>
	  			</div>
			</div>
	      </div>
	    </div>
	   </li>
	  </div>

	  <div class="card">
	  	<li class="left clearfix" portfolio_id='2'>
	    <div class="card-header" id="headingTwo">
	      <h5 class="mb-0">
	        <button class="btn btn-link collapsed" data-toggle="collapse" data-target="#collapseTwo" aria-expanded="false" aria-controls="collapseTwo">
	          	포트폴리오2 제목
	        </button>
	      </h5>
	    </div>
	    <div id="collapseTwo" class="collapse" aria-labelledby="headingTwo" data-parent="#accordion">
	      <div class="card-body">
			<div class="grid-container2">
				<div class="portfolio-term">
				포트폴리오2 기간
				</div>
	 			<div class="portfolio-detail">
	 			포트폴리오2 상세
	 			</div>
	  			<div class="portfolio_language_List">
	  			포트폴리오2 언어
	  			</div>
			</div>
	      </div>
	    </div>
		</li>
	  </div>
	  </ul> 
	  <!-- portfolio-list ul 끝 -->	 
	</div>
  </div>
  <div class="myprofile-title-container">
	  <div class="profile_info">
	  	<h1><div id="member_name" class="member_name"></div></h1>
	  	<div id="member_email" class="member_email"></div>
	  	<div id="member_status" class="member_status">
				  	
			<div id="statusBtnPlace" class="statusBtnPlace">
				<div class="btn-group">
				  <button type="button" class="btn btn-outline-secondary" >
				  	<div id="status" class="status"></div>
				  </button>
				  <button type="button" class="btn btn-outline-secondary dropdown-toggle dropdown-toggle-split" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
				    <span class="sr-only">Toggle Dropdown</span>
				  </button>
				  <div class="dropdown-menu">
				    <a class="dropdown-item" href="#" data-status_id="1">자리비움</a>
				    <a class="dropdown-item" href="#" data-status_id="2">회의중</a>
				    <a class="dropdown-item" href="#" data-status_id="3">근무중</a>
				    <a class="dropdown-item" href="#" data-status_id="4">오프라인</a>
				    <a class="dropdown-item" href="#" data-status_id="">상태없음</a>
				  </div>
				</div> <!-- dropdown 끝 -->
			</div>	  	
	  	</div>
		
	  </div>
	  <div class="profile_chart">
		  <div class="card-body">
			<!-- 차트 들어갈 곳.. -->
			<div id="piechart" style="width: 700px; height: 600px;"></div>
		</div>
	</div>
  </div>
  <div class="title-container">
		<div class="add-portfolio">
			<button id="addBtn" class="btn btn-primary">포트폴리오 추가</button>
		</div>
  </div>
</div>
	
	
<div id="deleteModal" class="modal" tabindex="-1" role="dialog">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title">포트폴리오 삭제</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <input type="hidden" id="portfolio_id" value="">
      <div class="modal-body">
        <p>정말 삭제하시겠습니까?</p>
      </div>
      <div class="modal-footer">
        <button id="realDeleteBtn" type="button" class="btn btn-danger">삭제</button>
        <button id="backToList" type="button" class="btn btn-secondary" data-dismiss="modal">취소</button>
      </div>
    </div>
  </div>
</div>

<script type="text/javascript">



$(document).ready(function(){
	var memberNameDiv = $("#member_name");
	var memberEmailDiv = $("#member_email");
	var memberStatusDiv = $("#status");
	var m_id = '<c:out value ="${member_id}"/>';
	var editMem = $("#editProfileBtn");
	console.log("@ShowInfo"+portfolioService);
	
	showInfo(); 
	function showInfo(){
		
		portfolioService.getInfo({
			member_id : m_id
		}, function(member){
			memberNameDiv.html(member.name);
			memberEmailDiv.html(member.email);
			memberStatusDiv.html(member.status_detail);
			
			$(".dropdown-item").on("click",function(){
	            var s_id=$(this).data("status_id");
	            portfolioService.updateMStatus({
	               member_id : m_id,
	               status_id : s_id
	            },function(result){
	               alert("RESULT: "+result);
	           	self.location="main?member_id="+m_id;
	            })
	            

	         })
			
		});
	 } 
	
	
	
});	
	
	
$(document).ready(function(){
	

	console.log("@showPfList"+portfolioService);
	
	var m_id = '<c:out value ="${member_id}"/>';
	console.log("m_id" + m_id);
	
	function add() {
		window.location.href = "add?member_id="+m_id;
	}

	var p_id='';
	
	var deleteBtn = $("#deleteBtn");
	var portfolioUL = $(".portfolio-list");
	
	$("#addBtn").on("click",function(){
		self.location="add?member_id="+m_id;
	})
	
	

	
	showPfList();	
	
	function showPfList(){

		portfolioService.getList({
			member_id : m_id
			}, function(list){
				
				
				var str="";
				if(list == null || list.length ==0){
				}
				
				for(var i = 0, len = list.length||0;i<len;i++){
					/* console.log("list"+list[i].portfolio_title); */
					str +="<li class= 'left clearfix' data-portfolio_id="+list[i].portfolio_id+">";
					str +="	<div class='card-header' id='heading"+i+"'>";
					str +="	  <h5 class='mb-0'>";
					if(i == 0){
					str +="	     <button class='btn btn-link' data-toggle='collapse' data-target='#collapse"+i+"' aria-expanded='true' aria-controls='collapse"+i+"'>";
					}else{
					str +="	     <button class='btn btn-link' data-toggle='collapse' data-target='#collapse"+i+"' aria-expanded='false' aria-controls='collapse"+i+"'>";
					}
					str +=list[i].portfolio_title;
					str +="		 </button>";
					str +="		</h5>";
					str +="	</div>";
					if(i==0){
					str +="<div id='collapse"+i+"' class='collapse show' aria-labelledby='heading"+i+"' data-parent=''#accordion'>";
					}else{
					str +="<div id='collapse"+i+"' class='collapse' aria-labelledby='heading"+i+"' data-parent=''#accordion'>";
					}
					str +="	<div class='card-body'>";
					str +="		<div class='grid-container2'>";
					str +="			<div class='portfolio-term'>";
					str +=portfolioService.displayTime(list[i].portfolio_start_date)+"-"+portfolioService.displayTime(list[i].portfolio_end_date);
					
 					str +="<a><button data-portfolio_id="+list[i].portfolio_id+" id='icon_delete"+list[i].portfolio_id+"' type='button' class='btn btn-outline-danger'>";
					str +="<svg xmlns='http://www.w3.org/2000/svg' width='16' height='16' fill='currentColor' class='bi bi-trash' viewBox='0 0 16 16'>";
					str +="<path d='M5.5 5.5A.5.5 0 0 1 6 6v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5zm2.5 0a.5.5 0 0 1 .5.5v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5zm3 .5a.5.5 0 0 0-1 0v6a.5.5 0 0 0 1 0V6z'/>";
					str +="<path fill-rule='evenodd' d='M14.5 3a1 1 0 0 1-1 1H13v9a2 2 0 0 1-2 2H5a2 2 0 0 1-2-2V4h-.5a1 1 0 0 1-1-1V2a1 1 0 0 1 1-1H6a1 1 0 0 1 1-1h2a1 1 0 0 1 1 1h3.5a1 1 0 0 1 1 1v1zM4.118 4 4 4.059V13a1 1 0 0 0 1 1h6a1 1 0 0 0 1-1V4.059L11.882 4H4.118zM2.5 3V2h11v1h-11z'/>";	
					str +="</svg>"+"</button></a>";
					
					str +="<a><button data-portfolio_id="+list[i].portfolio_id+" id='icon_edit"+list[i].portfolio_id+"'type='button' class='btn btn-outline-primary'>";
					str += "<svg xmlns='http://www.w3.org/2000/svg' width='16' height='16' fill='currentColor' class='bi bi-pencil-fill' viewBox='0 0 16 16'>";
					str +="<path d='M12.854.146a.5.5 0 0 0-.707 0L10.5 1.793 14.207 5.5l1.647-1.646a.5.5 0 0 0 0-.708l-3-3zm.646 6.061L9.793 2.5 3.293 9H3.5a.5.5 0 0 1 .5.5v.5h.5a.5.5 0 0 1 .5.5v.5h.5a.5.5 0 0 1 .5.5v.5h.5a.5.5 0 0 1 .5.5v.207l6.5-6.5zm-7.468 7.468A.5.5 0 0 1 6 13.5V13h-.5a.5.5 0 0 1-.5-.5V12h-.5a.5.5 0 0 1-.5-.5V11h-.5a.5.5 0 0 1-.5-.5V10h-.5a.499.499 0 0 1-.175-.032l-.179.178a.5.5 0 0 0-.11.168l-2 5a.5.5 0 0 0 .65.65l5-2a.5.5 0 0 0 .168-.11l.178-.178z'/>";
					str +="</svg>"+"</button></a></div>";
					str +="<div class='portfolio-detail'><pre>"+list[i].portfolio_detail+"</pre></div>";
					
					/* console.log(list[i].portfolio_id); */
					p_id=list[i].portfolio_id;
					/* console.log(p_id); */
					str +="<div class='portfolio_language_List'>";
					for(var j =0 ,len0 = list[i].portfolioLanguage.length || 0 ; j < len0 ; j++){
						/* console.log(list[i]) */

					str+= "<span class='badge badge-pill badge-primary'>"+list[i].portfolioLanguage[j].portfolio_language+"</span>";
					};
					str+="</div></div></div></div></li>";
					/* console.log(list[i].portfolio_title); */
				}
				portfolioUL.html(str);
				
					var modal = $(".modal");
					var editBtn = $("#icon_edit");
					var deleteBtn = $("#icon_delete");
					var realDeleteBtn = $("#realDeleteBtn"); 
					var project_id=[]; 

					
					$("[id^=icon_edit]").on("click",function(e){
						var p_id = $(this).data("portfolio_id");
						self.location="update?portfolio_id="+p_id;
						console.log(p_id);
					}); 
					$("[id^=icon_delete]").on("click",function(e){
						e.preventDefault();
						var p_id = $(this).data("portfolio_id");
						console.log("project Id");
						console.log(p_id);
						project_id.push(p_id);
						
						$('#deleteModal').modal('show');
						realDeleteBtn.on("click",function(e){
							e.preventDefault();
							var id=project_id[0];
							console.log("id");
							console.log(id);
							portfolioService.remove({
									portfolio_id:id
								},function(result){
									alert(result);
									modal.modal("hide");
									self.location="main?member_id="+m_id;
								})
							}) 
						}); 
						

		});
		
	}//end showPfList
	

});



 


</script>
</body>
</html>
<%@ include file="../footer.jsp" %>