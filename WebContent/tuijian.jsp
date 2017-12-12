<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" import="java.util.*"%>
  <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

 
<style type="text/css">  

 

#jiansuo a{  
    
    text-decoration:none;  
    color:#000000;  
    display:block;  
    width:100px;  
    height:30px;  
    line-height:30px;  
    text-align:center;  
}  
#jiansuo a:hover{  
    background-color:#b7d3df;  
    color:#FFFFFF;  

}  
</style>


</head>
<body >
<%
ArrayList<ArrayList<String>> tuijianlist = (ArrayList<ArrayList<String>>)session.getAttribute("tuijianlist");
String username = (String)session.getAttribute("username");

%>
<input name = "username"  type="hidden" value=<%=session.getAttribute("username") %>>
<input name = "role" type="hidden"  value="<%=session.getAttribute("role") %>">
<br><br><br>
<div id = "jiansuo">

<table  border=0 align=center  cellpadding=0 cellspacing=0 bordercolor=black width = 1250px>
		<tr align = "center" height = 40px>
			<td></td>
			<td width = 50px align = "left"></td>
			<td width = 100px>姓名</td>
			<td width = 200px>院系</td>
			<td width = 200px>专业</td>
			<td width = 100px>预约</td>
			<td></td>

		</tr>
		<%
			for(int i = 0; i < tuijianlist.size(); i++){
				ArrayList<String> ml = tuijianlist.get(i);
				String name = ml.get(0);
				String yuanxi = ml.get(1);
				String major = ml.get(2);
				
				String tname = ml.get(3);
				String url = ml.get(4);
				%>
					<tr align = "center"  height = 40px>
						<td></td>
						<td width = 50px align = "left"><%=i+1 %></td>
			
			
						<td ><a href = <%=url %> title = "点击查看教师具体信息" target = "#"><%=name %></a></td>
						<td ><%=yuanxi %></td>
						<td ><%=major %></td>
						<td ><a href="studentx.jsp?username=<%= username%>&teachername=<%=tname%>" target = "#">预约</a></td>
						<td></td>
					</tr>
				<%
			}
		%>
	</table>
	
</div>
<br><br><br><br><br><br><br>
</body>
</html>
