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
String username = (String)session.getAttribute("username");

String A = (String)session.getAttribute("A");
String B = (String)session.getAttribute("B");
String C = (String)session.getAttribute("C");
String D = (String)session.getAttribute("D");
String Er = (String)session.getAttribute("Er");


%>





<br>
<form action="jiansuo">
<input name = "Er" type="hidden"  value="1">
<input name = "username"  type="hidden" value=<%=session.getAttribute("username") %>>
<table  border=0 cellpadding=0 cellspacing=0 bordercolor=black width = 1250px>
<tr align = "center">
<td></td>
		<td width = 100px>检索类别A</td>
		<td  width = 100px>
			<select name="D" style="width:100px;height:30px">
							<option value="ALL" ${D=="ALL"?'selected':''}>不限</option>
							<option value="teacher" ${D=="teacher"?'selected':''}>教师</option>
			</select>
		</td>	
		<td width = 20px></td>
		
		<td  width = 100px>检索类别B</td>
		<td  width = 100px>
			<select name="A" style="width:100px;height:30px">
							<option value="ALL" ${A=="ALL"?'selected':''}>不限</option>
							<option value="teacher" ${A=="teacher"?'selected':''}>教师</option>
			</select>
		</td>	
		<td width = 20px></td>
		
		<td  width = 100px>检索类别C</td>
		<td  width = 100px>
			<select name="B" style="width:100px;height:30px">
							<option value="ALL" ${B=="ALL"?'selected':''}>不限</option>
							<option value="teacher" ${B=="teacher"?'selected':''}>教师</option>
			</select>
		</td>	
		<td width = 20px></td>
		
		<td  width = 100px>检索类别D</td>
		<td  width = 100px>
			<select name="C" style="width:100px;height:30px">
							<option value="ALL" ${C=="ALL"?'selected':''}>不限</option>
							<option value="teacher" ${C=="teacher"?'selected':''}>教师</option>
			</select>
		</td>	
		<td width = 20px></td>

		<td  width = 100px>
			<button type="submit" style="width:100px;height:30px;border:none;background-color:#4dc86f" onmouseover="this.style.backgroundColor='#53de79'" onmouseout="this.style.backgroundColor='#4dc86f'">搜索</button>
		</td>
		<td></td>
</tr>
</table>
<br><br>
<%if(Er.equals("1")){
	%>
	<div id = "jiansuo">
	<table  border=0 align=center  cellpadding=0 cellspacing=0 bordercolor=black width = 1250px>
		<tr align = "center" height = 40px>
			<td></td>
			<td width = 50px align = "left"></td>
			<td width = 100px>姓名</td>
			<td width = 100px>B</td>
			<td width = 100px>C</td>
			<td width = 100px>D</td>
			<td></td>

		</tr>
		<%
			for(int i = 0; i < 5; i++){
				String teachername = "X";
				%>
					<tr align = "center"  height = 40px>
						<td></td>
						<td width = 50px align = "left"><%=i+1 %></td>
			
			
						<td ><a href = "studentx.jsp?username=<%= username%>&teachername=<%=teachername%>" title = "点击查看教师具体信息" target = "#">X</a></td>
						<td >X</td>
						<td >X</td>
						<td >X</td>
						<td></td>
					</tr>
				<%
			}
		%>
	</table>
	</div>
	<%
	}
	%>
<br><br>
</form>

</body>
</html>
			
			