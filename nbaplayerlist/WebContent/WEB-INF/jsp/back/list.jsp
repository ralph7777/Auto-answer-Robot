<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
 String path = request.getContextPath();
 String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/"; 
%>

<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<meta http-equiv="X-UA-Compatible"content="IE=9; IE=8; IE=7; IE=EDGE" />
		<title>Player List</title> 
		<link href="${basePath}resources/css/all.css" rel="stylesheet" type="text/css"/>
		<script src="<%=basePath%>resources/js/common/jquery-1.8.0.min.js"></script>
		<script src="<%=basePath%>resources/js/back/list.js"></script>
	</head>
	<body style="background: #e1e9eb;">
		<form action="<%= basePath %>List.action" id="mainForm" method="post">
			<div class="right">
				<div class="current">current position:<a href="javascript:void(0)" style="color:#6E6E6E;">Management</a> &gt; PlayerList</div>
				<div class="rightCont">
					<p class="g_title fix">Player List
						<a class="btn03" href="<%=basePath%>Add.action">Add</a>&nbsp;&nbsp;&nbsp;&nbsp;
						<a class="btn03" href="javascript:deleteBatch('<%=basePath%>');">Delete</a>
					</p>
					<table class="tab1">
						<tbody>
							<tr>
								<td width="90" align="right">Player Name:&nbsp;</td>
								<td>
									<input id="name" name="name" type="text" class="allInput" value="${name}"/>
								</td>
								<td width="90" align="right">Player Team:&nbsp;</td>
								<td>
									<input id="team" name="team" type="text" class="allInput" value="${team}"/>
								</td>
	                            <td width="85" align="right"><input type="submit" class="tabSub" value="Search" /></td>
	       					</tr>
						</tbody>
					</table>
					<div class="zixun fix">
						<table class="tab2" width="100%">
							<tbody>
								<tr>
								    <th><input type="checkbox" id="all" onclick="#"/></th>
								    <th>Id</th>
								    <th>Name</th>
								    <th>Team</th>
								    <th>Number</th>								    
								    <th>Management</th>
								</tr>
								<c:forEach items="${playerList}" var="player" varStatus="status">
									<tr <c:if test="${status.index % 2 != 0}"> style="background-color:#ECF6EE;" </c:if>>
										<td><input type="checkbox" name="id" value="${player.id}"/></td>
											<td>${player.id}</td>
											<td>${player.name}</td>
											<td>${player.team}</td>
											<td>${player.number}</td>											
											<td>
												<a href="#">revise</a>&nbsp;&nbsp;&nbsp;
												<a id="deleteOne" href="<%=basePath %>DeleteOne.action?id=${player.id}">delete</a>
												<!-- <a id="deleteOne" href="#">delete</a>  -->
										</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
						<div class='page fix'>
							total page&nbsp;<b>1</b>&nbsp;&nbsp;&nbsp;&nbsp;
							<!-- <a href='###' class='first'>first</a>
							<a href='###' class='pre'>last</a> -->
							current page&nbsp;<span>1/1</span>&nbsp;&nbsp;&nbsp;
							<!-- <a href='###' class='next'>next</a>
							<a href='###' class='last'>final</a> -->
							skip to page&nbsp;<input type='text' value='1' class='allInput w28' />
							<a href='###' class='go'>GO</a>
						</div>
					</div>
				</div>
			</div>
	    </form>
	</body>
	<!-- 
	<script>
		$(document).ready(function(){
		  $("#deleteOne").click(function(){
			$.post("<%=basePath%>DeleteOne.action",
			JSON.stringify({
				name:$("#name").val(),
				team:$("#team").val(),
				id:$("#playerId").val(),
			}),
			function(){
				var idNum=$("#playerId").val()
				alert("No."+ idNum +" player has been deleted.");
			});
		   });
		});
		  
	
	</script>
	 -->
</html>