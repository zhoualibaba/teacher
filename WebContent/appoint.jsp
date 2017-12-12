<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" import="java.util.*"%>
  <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">


<script type="text/javascript">
function check(){
	alert("已预约，待审核");
}

</script>



<style type="text/css">  


#next a{  
    background-color:#00FF7F;  
    text-decoration:none;  
    color:#000000;  
    display:block;  
    text-align:center;  
    margin-left:1px;  
}

#daohang a{  
    background-color:#4dc86f;  
    text-decoration:none;  
    color:#000000;  
    display:block;  
    width:100px;  
    height:30px;  
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
String sname = (String)session.getAttribute("sname");
String n = (String)session.getAttribute("n");
String ndate = (String)session.getAttribute("ndate");
ArrayList<ArrayList<String>> applist = (ArrayList<ArrayList<String>>)session.getAttribute("applist");

ArrayList<String> ddd = (ArrayList<String>)session.getAttribute("ddd");
%>

<div id = "daohang" >
<input name = "username"  type="hidden" value=<%=session.getAttribute("username") %>>
<input name = "role" type="hidden"  value="<%=session.getAttribute("role") %>">
<input name = "n" type="hidden"  value="<%= n%>">

<table  border=0 align=center  cellpadding=0 cellspacing=0 bordercolor=black>
<tr>
<td width=50px ><a href="appointb?n=<%= n %>&role=<%= role%>&username=<%=username %>">上一周</a></td>
<td width=200px align="center">第<%= n %>周</td>
<td width=50px ><a href="appointn?n=<%= n %>&role=<%= role%>&username=<%=username %>">下一周</a></td>
</tr>
</table>
</div>
<br>
<div id = "next" >
<table  border=1 align=center  cellpadding=0 cellspacing=0 bordercolor=black>
<tr>
<td colspan=2 rowspan=2 align="center">时间</td>
<td align="center">星期一</td>
<td align="center">星期二</td>
<td align="center">星期三</td>
<td align="center">星期四</td>
<td align="center">星期五</td>
<td align="center">星期六</td>
<td align="center">星期日</td>
</tr>

<tr>

<%
	for(int i = 0; i < 7; i++){
		String d = ddd.get(i);
	
		%>
		<td align = "center"> <%=d %></td>
		<%
	}
%>

</tr>
<%
int k = 0;
for(int i = 0; i < 8; i ++){
	String ii = "";
	%><tr align = "center"><%
	if(i == 0){
		%><td  rowspan=4  align=center>上午</td><%
	}
	if(i == 4){
		%><td  rowspan=4  align=center>下午</td><%
	}
	%><td  >第<br><%=i + 1 %><br>节</td><%
	for(int j = 0; j < 7; j ++){
		
		String jj = "";
		String what = "";
		if(k < applist.size()){
			ArrayList<String> ml = applist.get(k);
			ii = ml.get(1);
			jj = ml.get(2);
			what = ml.get(3);
		}
		if(String.valueOf(i + 1).equals(ii) && String.valueOf(j + 1).equals(jj)){
			k ++;
			%><td><%=what %></td><%
		}else{
			if(role.equals("teacher")){
				%><td bgcolor="#00FF7F"><a href = "ty.jsp?n=<%=n%>&role=<%= role%>&username=<%=username %>&sname=<%=sname %>&i=<%=i + 1%>&j=<%=j + 1%>" target = "teacher" title = "点击添加此时间的行程安排">添加</a></td><%
			}else{
				%><td bgcolor="#00FF7F"><a href = "yy?i=<%=i + 1%>&j=<%=j + 1%>&n=<%=n%>&role=<%= role%>&username=<%=username %>&sname=<%=sname %>" onclick ="check()">可预约</a></td><%
			}
		}
	}
	
	%></tr><%
}
%>


</table>
</div>
<br><br><br><br><br><br><br>
</body>
</html>
