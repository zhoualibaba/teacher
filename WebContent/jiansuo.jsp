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

ArrayList<ArrayList<String>> jiansuolist = (ArrayList<ArrayList<String>>)session.getAttribute("j");

%>

<br>
<form action="jiansuo">
<input name = "Er" type="hidden"  value="1">
<input name = "username"  type="hidden" value=<%=session.getAttribute("username") %>>
<table  border=0 cellpadding=0 cellspacing=0 bordercolor=black width = 1250px>
<tr align = "center">
<td></td>
		<td width = 100px>院系</td>
		<td  width = 100px>
		
			<select name="yuanxi" style="width:100px;height:30px">
							<option value="ALL" ${A=="ALL"?'selected':''}>不限</option>
							<option value="计算机" ${A=="计算机"?'selected':''}>计算机</option>
							<option value="生物" ${A=="生物"?'selected':''}>生物</option>
			</select>
		</td>	
		<td width = 20px></td>
		
		<td  width = 100px>专业</td>
		<td  width = 100px>
			<select name="major" style="width:100px;height:30px">
							<option value="ALL" ${B=="ALL"?'selected':''}>不限</option>
							<option value="A" ${B=="A"?'selected':''}>A</option>
							<option value="B" ${B=="B"?'selected':''}>B</option>
							
			</select>
		</td>	
		<td width = 20px></td>
		
		<td  width = 100px>职位</td>
		<td  width = 100px>
			<select name="zhiwei" style="width:100px;height:30px">
							<option value="ALL" ${C=="ALL"?'selected':''}>不限</option>
							<option value="教授" ${C=="教授"?'selected':''}>教授</option>
							<option value="讲师" ${C=="讲师"?'selected':''}>讲师</option>
			</select>
		</td>	
		<td width = 20px></td>
		
		<td  width = 100px>性别</td>
		<td  width = 100px>
			<select name="sex" style="width:100px;height:30px">
							<option value="ALL" ${D=="ALL"?'selected':''}>不限</option>
							<option value="男" ${D=="男"?'selected':''}>男</option>
							<option value="女" ${D=="女"?'selected':''}>女</option>
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
			<td width = 100px>院系</td>
			<td width = 100px>专业</td>
			<td width = 100px>职位</td>
			<td width = 100px>性别</td>
			<td></td>

		</tr>
		<%
			for(int i = 0; i < jiansuolist.size(); i++){
				ArrayList<String> ml = jiansuolist.get(i);
				String name = ml.get(0);
				String yuanxi = ml.get(1);
				String major = ml.get(2);
				String zhiwei = ml.get(3);
				String sex = ml.get(4);
				String tname = ml.get(5);
				%>
					<tr align = "center"  height = 40px>
						<td></td>
						<td width = 50px align = "left"><%=i+1 %></td>
			
			
						<td ><a href = "studentx.jsp?username=<%= username%>&teachername=<%=tname%>" title = "点击查看教师具体信息" target = "#"><%=name %></a></td>
						<td ><%=yuanxi %></td>
						<td ><%=major %></td>
						<td ><%=zhiwei %></td>
						<td ><%=sex %></td>
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
			
			