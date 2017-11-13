<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" import="java.util.*"%>
  <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>有意义的教师界面</title>
<meta name="viewport" content="width=device-width, initial-scale=1">

<style type="text/css">  

 

#daohang a{  
    
    text-decoration:none;  
    color:#000000;  
    display:block;  
    width:120px;  
    height:30px;  
    line-height:30px;  
    text-align:center;  
    margin-left:1px;  
}  
#daohang a:hover{  
    background-color:#b7d3df;  
    color:#FFFFFF;  
    /*伸缩变换设置高度变化*/  
    height:40px;  
    /*和使用负值向反方向移动*/  
    margin-top:-10px;  
    line-height:50px;  
}  
</style>
<script type="text/javascript">
	function relogin(){
		var i = window.confirm("你确认退出？");
		return i;
	}
	function numF(){
		if(document.getElementById("num").value!="0"){
			document.getElementById("nums").style.color="red";
			document.getElementById("nums").innerHTML="你有" + document.getElementById("num").value +"条新预约";
		}else{
			document.getElementById("nums").style.color="";
			document.getElementById("nums").innerHTML="新生预约";
		}
	}
	
	
	
	 function defaulIframePageHeight() {
		    var ifm = document.getElementById("defaulIframePage");
		    var subWeb = document.frames ? document.frames["defaulIframePage"].document : ifm.contentDocument;
		    if (ifm != null && subWeb != null) {
		        ifm.height = subWeb.body.scrollHeight;
		    }

		}
</script>

</head>
<body onload="numF()">

<%
String role = (String)session.getAttribute("role");
String name = (String)session.getAttribute("name");

String username = (String)session.getAttribute("username");

%>

<input name = "username"  type="hidden" value=<%=session.getAttribute("username") %>>
<input name = "password" type="hidden" value="<%=session.getAttribute("password") %>">
<input name = "role" type="hidden"  value="<%=session.getAttribute("role") %>">
<input name = "errorFlag" type="hidden"  value="100">

<input id="num" type="hidden" value="<%=session.getAttribute("num") %>">

<div >
	<div id="main">
			<table height="50px" width="1250px" border="0" cellpadding="0" cellspacing="0">				
				<tr height="20px">
					<td></td>
					<td rowspan="2" align="right">欢迎您， <%=session.getAttribute("name") %>！</td>
					<td colspan="4"  align="right">
							<span id="time" style="font-size:15px;">
								<script>
								 setInterval("document.getElementById('time').innerHTML=new Date().toLocaleString();",1000);  
								</script>					
							</span>
					</td>
				</tr>
				<tr height="30px" align="center">
					<td  width="800px"></td>
					
					<td width="70px"><a href="#">个人信息</a></td>
					<td width="40px"><a href="123.jsp" target="teacher">主页</a></td>
					<td width="40px"><a href="passwordchange.jsp">密码</a></td>
					<td width="40px"><a href="login.jsp" onclick="return relogin()">退出</a></td>
				</tr>
			</table>
	</div>
	<div id = "daohang" style="width:100%">
	<table style="border-bottom:10px solid #b7d3df;" border="0" cellpadding="0" cellspacing="0" width="100%">
		<tr >
			<td width = "90px"> <a href="appoint?username=<%= username %>&role=<%=role %>" target = "teacher">行程安排</a></td>
			<td width = "90px"> <a href="money?username=<%= username %>&role=<%=role %>" target = "teacher">教师基金</a></td>
			<td width = "90px"> <a href="keyan?username=<%= username %>&role=<%=role %>" target = "teacher">科研成果</a></td>
			<td width = "120px"> <a href="yuyue?username=<%= username %>&role=<%=role %>" target = "teacher"><span id="nums">学生预约</span></a></td>
			<td></td>
		</tr>
	</table>	
	</div>
</div>
<iframe allowtransparency="true"   id="defaulIframePage" name="teacher"  frameborder="0" scrolling="no" width="100%" onload="defaulIframePageHeight()"></iframe>
</body>
</html>
