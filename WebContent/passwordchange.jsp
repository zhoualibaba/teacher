<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" import="java.util.*"%>
  <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>有意义的更改密码界面</title>
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
	
	document.getElementById("0").style.display="none";
	document.getElementById("1").style.display="none";
	document.getElementById("2").style.display="none";
	document.getElementById("3").style.display="none";
	document.getElementById("4").style.display="none";
	
	if(document.getElementById("oldpassword").value==""){
		document.getElementById("1").style.display="";
        return false;
	}
	
    if(document.getElementById("newpassword").value==""){
    	document.getElementById("2").style.display="";
        return false;
    }
    
    if(document.getElementById("newpasswords").value==""){
    	document.getElementById("3").style.display="";
        return false;
    }
    
    if(document.getElementById("newpassword").value!=document.getElementById("newpasswords").value){
    	document.getElementById("4").style.display="";
        return false;
    }
    
    if(document.getElementById("password").value!=document.getElementById("oldpassword").value){
    	document.getElementById("0").style.display="";
        return false;
    }
    return true;
}

</script>


</head>

<body>
<form action = "passwordchange">
	<input name="username" type="hidden" value="<%=session.getAttribute("username") %>">
	<input id="password"  type="hidden" value="<%=session.getAttribute("password") %>">
	<input name="role" type="hidden" value="<%=session.getAttribute("role") %>">
	
	<div style="height:100px"></div>
	<div >
	<center>
		<table width = "400px"  border="0" cellpadding="0" cellspacing="0" >
	<tr height = "40px">
	<td></td>
	</tr>
	
	<tr height = "40px">
	<td width = "40px"></td>
	<td width = "40px"></td>
	<td width = "240px" align=center>更改密码</td>
	<td width = "80px"></td>
	</tr>
	
	<tr height = "40px">
	<td></td>
	</tr>
	
	<tr height = "40px">
	<td width = "40px"></td>
	<td width = "40px"></td>
	<td width = "240px" ><span id ="0"  style="display:none;font-size:14px;color:red">密码错误</span></td>
	</tr>
	
	<tr height = "30px">
	<td width = "40px"></td>
	<td width = "40px">旧密码</td>
	<td width = "240px"><input id="oldpassword"  style="width:240px;height:30px" placeholder="旧密码"  type="password" value=""/></td>
	</tr>
	
	<tr height = "10px">
	<td width = "40px"></td>
	<td width = "40px"></td>
	<td width = "240px"><span id = "1"  style="display:none;font-size:9px;color:red">请输入密码</span></td>
	</tr>
	
	<tr height = "30px">
	<td width = "40px"></td>
	<td width = "40px">新密码</td>
	<td width = "240px"><input id="newpassword" name="newpassword" style="width:240px;height:30px" placeholder="新密码"  type="password" value=""/></td>
	</tr>
	
	<tr height = "10px">
	<td width = "40px"></td>
	<td width = "40px"></td>
	<td width = "240px"><span id = "2"  style="display:none;font-size:9px;color:red">请输入密码</span></td>
	</tr>
	
	
	<tr height = "30px">
	<td width = "40px"></td>
	<td width = "40px">确认密码</td>
	<td width = "240px"><input id="newpasswords"  style="width:240px;height:30px" placeholder="再次输入"  type="password" value=""/></td>
	</tr>
	
	<tr height = "10px">
	<td width = "40px"></td>
	<td width = "40px"></td>
	<td width = "240px"><span id = "3"  style="display:none;font-size:9px;color:red">请输入密码</span>
						<span id = "4"  style="display:none;font-size:9px;color:red">两次密码不一致</span>
	</td>
	</tr>
	
	
	<tr height = "20px"></tr>
	<tr height = "30px">
	<td></td>
	<td colspan="2"><button type="submit" onclick = "return check()" style="height:30px;width:282px;border:none;background-color:#4dc86f" onmouseover="this.style.backgroundColor='#53de79'" onmouseout="this.style.backgroundColor='#4dc86f'">更新</button></td>
	</tr>

	</table>

	</center> 
	</div>
     </form>
    
</body>



</html>
    

