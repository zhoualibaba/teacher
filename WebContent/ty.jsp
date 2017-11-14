<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" import="java.util.*"%>
  <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

</head>
<body>
<form action = "tyy">
<input name = "username"  type = "hidden" value=<%=request.getParameter("username") %>>
<input name = "sname" type = "hidden"   value=<%=request.getParameter("sname") %>>
<input name = "role" type = "hidden"  value="<%=request.getParameter("role") %>">
<input name = "n" type = "hidden"  value="<%=request.getParameter("n")%>">
<input name = "i" type = "hidden"  value="<%=request.getParameter("i")%>">
<input name = "j" type = "hidden"  value="<%=request.getParameter("j")%>">
<table  border=0 align=center  cellpadding=0 cellspacing=0 bordercolor=black>
<tr>
	<td>添加行程</td>
</tr>
<tr>
	<td><input  name = "what" style="width:240px;height:30px" placeholder="<%=request.getParameter("n")%>周周<%=request.getParameter("j")%>第<%=request.getParameter("i")%>节课" type="text" value=""/></td>
</tr>
<tr height = 30px><td></td></tr>
<tr>
	<td><button type="submit" style="height:30px;width:240px;border:none;background-color:#4dc86f" onmouseover="this.style.backgroundColor='#53de79'" onmouseout="this.style.backgroundColor='#4dc86f'">添加</button></td>
</tr>
</table>
</form>
<br><br><br>
</body>
</html>
