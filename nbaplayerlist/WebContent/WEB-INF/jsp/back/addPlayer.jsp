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
		<title>Add New Player</title> 
		<link href="${basePath}resources/css/all.css" rel="stylesheet" type="text/css"/>
	</head>
	<body style="background: #e1e9eb;">
		<form action="<%= basePath %>AddOne.action" id="addOneForm" method="post">
			<table class="tab1">
				<tbody>
					<tr>
						<td width="100" align="right">Player Name:&nbsp;</td>
						<td>
							<input id="nameAdd" name="nameAdd" type="text" class="allInput"/>
						</td>
						<td width="90" align="right">Team Name:&nbsp;</td>
						<td>
							<input id="teamAdd" name="teamAdd" type="text" class="allInput"/>
						</td>
						<td width="110" align="right">Player Number:&nbsp;</td>
						<td>
							<input id="numberAdd" name="numberAdd" type="text" class="allInput"/>
						</td>			
						<td width="80" align="right"><input type="submit" class="tabSub" value="Add" /></td>
						<td width="80" align="right"><input type="button" class="tabSub" onclick="location='<%=basePath%>List.action'" value="Cancel"></td>		
		       		</tr>
				</tbody>
			</table>
		</form>
	</body>
</html>


<!-- 首先，在原页面的点击增加，跳转到当前这个页面；然后，编辑这个页面内容，美化；最后，将用户输入信息post至AddOneServlet对应的url -->