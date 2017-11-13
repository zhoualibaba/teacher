<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" import="java.util.*"%>
  <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>library</title>
<meta name="viewport" content="width=device-width, initial-scale=1">

<style type="text/css">
body
{
background-image:url(1.jpg) ;
background-size:100%;
margin:0px;
padding:0px;
}
</style>

<script type="text/javascript">
function check(){
	document.getElementById("1").style.display="none";
	document.getElementById("2").style.display="none";
	document.getElementById("3").style.display="none";
    if(document.getElementById("username").value== ""){
    	document.getElementById("1").style.display="";
        return false;
    }

    if(document.getElementById("password").value== ""){
    	document.getElementById("2").style.display="";
        return false;
    }
    return true;
}
function intfunc(){
	if(document.getElementById("errorflag").value=="1"){
		document.getElementById("3").style.display="";
	}else if(document.getElementById("errorflag").value=="2"){
		alert("更改成功\n请重新登陆");
	}
}
</script>


</head>

<body onload="intfunc()">

	<input type="hidden" name = "errorflag" id = "errorflag" value="<%=request.getAttribute("errorFlag")%>" >
	<div style="height:100px"></div>
	<div >
	<center>
	<form action = "login">
		<table width = "400px"  border="0" cellpadding="0" cellspacing="0" >
	<tr height = "40px">
	<td></td>
	</tr>
	<tr height = "40px">
	<td width = "40px"></td>
	<td width = "40px"></td>
	<td width = "240px" align=center>用户登陆</td>
	<td width = "80px"></td>
	</tr>
	<tr height = "40px">
	<td></td>
	</tr>
	
	<tr height = "40px">
	<td width = "40px"></td>
	<td width = "40px"></td>
	<td width = "240px" ><span id ="3"  style="display:none;font-size:14px;color:red">用户名或密码错误</span></td>
	
	<tr height = "30px">
	<td width = "40px"></td>
	<td width = "40px">账号</td>
	<td width = "240px"><input  id="username" name="username" style="width:240px;height:30px" placeholder="用户名"  type="text" value=""/></td>
	</tr>

	<tr height = "10px">
	<td width = "40px"></td>
	<td width = "40px"></td>
	<td width = "240px"><span id = "1" style="display:none;font-size:9px;color:red">请输入帐号</span></td>
	</tr>
	
	<tr height = "30px">
	<td width = "40px"></td>
	<td width = "40px">密码</td>
	<td width = "240px"><input id="password" name="password" style="width:240px;height:30px" placeholder="密码"  type="password" value=""/></td>
	</tr>
	
	<tr height = "10px">
	<td width = "40px"></td>
	<td width = "40px"></td>
	<td width = "240px"><span id = "2"  style="display:none;font-size:9px;color:red">请输入密码</span></td>
	</tr>
	
	<tr height = "30px">
	<td width = "40px"></td>
	<td width = "40px">职业</td>
	<td width = "240px"><select name="role" style="width:100px;height:30px">
							<option value="student">学生</option>
							<option value="teacher">教师</option>
						</select>
						
	</td>
	</tr>
	<tr height = "20px"></tr>
	<tr height = "30px">
	<td></td>
	<td colspan="2"><button type="submit" onclick = "return check()" style="height:30px;width:282px;border:none;background-color:#4dc86f" onmouseover="this.style.backgroundColor='#53de79'" onmouseout="this.style.backgroundColor='#4dc86f'">登录</button></td>
	</tr>
	</table>
	</form>
	</center> 
</div>
</body>



</html>
    
