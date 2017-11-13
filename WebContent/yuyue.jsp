<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" import="java.util.*"%>
  <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

 


</head>
<body >
<input name = "username"  type="hidden" value=<%=session.getAttribute("username") %>>
<input name = "role" type="hidden"  value="<%=session.getAttribute("role") %>">
<br><br><br>
<table  border=0 align=center  cellpadding=0 cellspacing=0 bordercolor=black width = 1250px>
		<tr align = "center" height = 40px>
			<td></td>
			<td width = 50px align = "left"></td>
			<td width = 100px>姓名</td>
			<td width = 100px>时间</td>
			<td></td>
		</tr>
		<%
			for(int i = 0; i < 5; i++){
				%>
					<tr align = "center"  height = 40px>
						<td></td>
						<td width = 50px align = "left"><%=i+1 %></td>
						<td >X</td>
						<td >X</td>
						<td></td>
					</tr>
				<%
			}
		%>
	</table>

<br><br><br><br><br><br><br>
</body>
</html>
