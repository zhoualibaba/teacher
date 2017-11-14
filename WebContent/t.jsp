<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" import="java.util.*"%>
  <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

</head>
<body>
<%
 ArrayList<String> d = (ArrayList<String>)session.getAttribute("ddd");
%>
<table  border=0 align=center  cellpadding=0 cellspacing=0 bordercolor=black>
<tr>
	<td width = 100px>姓名</td>
	<td rowspan = 17 width = 30px></td>
	<td width = 200px><%=d.get(0) %></td>
</tr>
<tr height = 20px></tr>
<tr>
	<td width = 30px>性别</td>
	<td width = 100px><%=d.get(1) %></td>
</tr>
<tr height = 20px></tr>
<tr>
	<td width = 30px>电话</td>
	<td width = 100px><%=d.get(2) %></td>
</tr>
<tr height = 20px></tr>
<tr>
	<td width = 30px>院系</td>
	<td width = 100px><%=d.get(3) %></td>
</tr>
<tr height = 20px></tr>
<tr>
	<td width = 30px>国家</td>
	<td width = 100px><%=d.get(4) %></td>
</tr>
<tr height = 20px></tr>
<tr>
	<td width = 30px>民族</td>
	<td width = 100px><%=d.get(5) %></td>
</tr>
<tr height = 20px></tr>
<tr>
	<td width = 30px>职位</td>
	<td width = 100px><%=d.get(6) %></td>
</tr>
<tr height = 20px></tr>
<tr>
	<td width = 30px>社会面貌</td>
	<td width = 100px><%=d.get(7) %></td>
</tr>
<tr height = 20px></tr>
<tr>
	<td width = 30px>专业</td>
	<td width = 100px><%=d.get(8) %></td>
</tr>
</table>
<br><br><br><br>
</body>
</html>