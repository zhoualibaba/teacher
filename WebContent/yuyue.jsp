<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" import="java.util.*"%>
  <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

 <style type="text/css">  
 
a{  
    
    text-decoration:none;  
    color:#000000;  
    display:block;  
    text-align:center;  
}  
a:hover{  
    background-color:#b7d3df;  
    color:#FFFFFF;  
</style>
</head>
<body >

<% 
String role = (String)session.getAttribute("role");
String username = (String)session.getAttribute("username");
ArrayList<ArrayList<String>> yuyuelist = (ArrayList<ArrayList<String>>)session.getAttribute("yuyuelist");

%>
<input name = "username" type="hidden"  value=<%=session.getAttribute("username") %>>
<input name = "role" type="hidden"  value="<%=session.getAttribute("role") %>">
<br><br><br>
<table  border=0 align=center  cellpadding=0 cellspacing=0 bordercolor=black >
		<tr align = "center" height = 40px>
			<td width = 50px align = "left"></td>
			<td width = 100px>姓名</td>
			<td width = 300px>时间</td>
		</tr>
		<%
			for(int i = 0; i < yuyuelist.size(); i++){
				ArrayList<String> ml = yuyuelist.get(i);
				String id= ml.get(0);
				String student = ml.get(1);
				String teacher = ml.get(2);
				String time = ml.get(3);
				String n = ml.get(4);
				%>
					<tr align = "center"  height = 40px>
						<td width = 50px align = "left"><%=i+1 %></td>
						<%
							if(role.equals("student")){
						%>
						<td ><%=teacher %></td>
						<%
							}
						%>
						
						<%
							if(role.equals("teacher")){
						%>
						<td ><%=student %></td>
						<%
							}
						%>
						<td><%=time %></td>
						<td width = 20px></td>
						
						
						<%
							if(role.equals("student")){
						%>
							<%
							if(role.equals("student") && n.equals("0")){
							%>
							<td width = 50px>待审核</td>
							<%
							}else if(role.equals("student") && n.equals("1")){
							%>
							<td width = 50px>已同意</td>
							<%
							}else if(role.equals("student") && n.equals("2")){
							%>
							<td width = 50px>已拒绝</td>
						<%
							}}
						%>
						
						<%
							if(role.equals("teacher") &&  n.equals("0")){
						%>
						<td width = 50px><a href="yyy?id=<%=id %>&n=<%=1 %>&username=<%=username %>&role=<%=role %>">同意</a></td>
						<td width = 20px></td>
						<td width = 50px><a href="yyy?id=<%=id %>&n=<%=2 %>&username=<%=username %>&role=<%=role %>">拒绝</a></td>
						<%
							}else if(role.equals("teacher") && n.equals("1")){
								%>
								<td width = 50px>已同意</td>
								<%
								}else if(role.equals("teacher") && n.equals("2")){
								%>
								<td width = 50px>已拒绝</td>
							<%
								}
							%>
						
					</tr>
				<%
			}
		%>
	</table>

<br><br><br><br><br><br><br>
</body>
</html>
