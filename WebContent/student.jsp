<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" import="java.util.*"%>
  <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>teacher</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link  href="top.css" rel="stylesheet" type="text/css" />
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
	
	
	
	 function defaulIframePageHeight() {
		    var ifm = document.getElementById("defaulIframePage");
		    var subWeb = document.frames ? document.frames["defaulIframePage"].document : ifm.contentDocument;
		    if (ifm != null && subWeb != null) {
		        ifm.height = subWeb.body.scrollHeight;
		    }

		}
</script>

</head>
<body>
<input name = "username"  type="hidden" value=<%=session.getAttribute("username") %>>
<input name = "password" type="hidden" value="<%=session.getAttribute("password") %>">
<input name = "role" type="hidden"  value="<%=session.getAttribute("role") %>">
<input name = "errorFlag" type="hidden"  value="100">


<div >
	<div id="main">
			<table height="50px" width="1250px" border="0" cellpadding="0" cellspacing="0">				
				<tr height="20px">
					<td></td>
					<td></td>
					<td colspan="4"  align="right">
							<span id="time" style="font-size:15px;">
								<script>
								 setInterval("document.getElementById('time').innerHTML=new Date().toLocaleString();",1000);  
								</script>					
							</span>
					</td>
				</tr>
				<tr height="30px" align="center">
					<td></td>
					<td width="1000px"></td>
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
			<td width = "120px"> <a href="appoint.jsp" target = "teacher">行程安排</a></td>
			<td width = "120px"> <a href="#" target = "teacher">教师基金</a></td>
			<td width = "120px"> <a href="#" target = "teacher">科研成果</a></td>
			<td width = "120px"> <a href="#" target = "teacher">我的预约</a></td>
			<td></td>
		</tr>
	</table>	
	</div>
</div>
<iframe allowtransparency="true"   id="defaulIframePage" name="teacher"  frameborder="0" scrolling="no" width="100%" onload="defaulIframePageHeight()"></iframe>
</body>
</html>
