<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" import="java.util.*"%>
  <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">


<style type="text/css">  


#daohang a{  
    background-color:#4dc86f;  
    text-decoration:none;  
    color:#000000;  
    display:block;  
    width:50px;  
    height:20px;  
    text-align:center;  
}  
#daohang a:hover{  
    background-color:#53de79;  
    /*伸缩变换设置高度变化*/  
    /*和使用负值向反方向移动*/  
}  
</style>


</head>
<body >


<% 
String role = (String)session.getAttribute("role");
String username = (String)session.getAttribute("username");
ArrayList<ArrayList<String>> keyanlist = (ArrayList<ArrayList<String>>)session.getAttribute("keyanlist");

%>
<form action = "tk">
<input name = "username"  type="hidden" value=<%=session.getAttribute("username") %>>
<input name = "role" type="hidden"  value="<%=session.getAttribute("role") %>">
<br><br><br><br>
<table id = "daohang" border=0 align=center  cellpadding=0 cellspacing=0 bordercolor=black>
<%
for(int i = 0; i < keyanlist.size(); i++){
	ArrayList<String> ml = keyanlist.get(i);
	String ID = ml.get(0);
	String what = ml.get(1);
	%>
		<tr align = "center">
			<td width = 50px align = "left"><%=i+1 %></td>
			<td width = 400px><%=what %></td>
			<%
				if(role.equals("teacher")){
			%>
			<!-- <td width = 50px><a href = "changekeyan?ID=<%=ID%>">更改</a></td> -->
			
			<td width ="60px"></td>
			<td width = 50px><a href = "delkeyan?ID=<%=ID%>&username=<%= username %>&role=teacher">删除</a></td>
			<%
				}
			%>
		</tr>
		<tr height = "10px" ></tr>
	<%
}

if(role.equals("teacher")){
%>
<tr height = 100px></tr>
<tr align = "center">
		<td width = 50px align = "left"></td>
		
		<td width = 400px><input  name = "what" style="width:400px;height:30px" placeholder="添加新科研项目" type="text" value=""/></td>
	
		<td width ="10px"></td>
		<td width = 100px><button type="submit"  style="width:100px;height:30px;border:none;background-color:#4dc86f" onmouseover="this.style.backgroundColor='#53de79'" onmouseout="this.style.backgroundColor='#4dc86f'">增加</button></td>
	
	</tr>

<%
			}
%>
</table>
</form>
<br><br><br><br><br><br><br>
</body>
</html>
