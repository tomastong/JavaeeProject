<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
	<head>
		<title>修改密码</title>	
		<link href="${pageContext.request.contextPath}/css/main-9ef9c0e87dc02c8281af9d91272fd02e.css?body=1"
			rel="stylesheet" type="text/css">
		<link href="${pageContext.request.contextPath}/css/layout-e1c09780018325a8d26698a6e8aa7597.css?body=1"
			rel="stylesheet" type="text/css">
		<link href="${pageContext.request.contextPath}/css/bootstrap-a8e65df0a1d46934b11bbe665c5e00d6.css?body=1"
			rel="stylesheet" type="text/css">
		<link href="${pageContext.request.contextPath}/css/fontawesome-cea23e4121b590dd7fbd5a715f8ea879.css?body=1"
			rel="stylesheet" type="text/css">
		<link href="${pageContext.request.contextPath}/css/bootstrap_and_overrides-ba002271e6152982a71a1893fa440d42.css?body=1"
			rel="stylesheet" type="text/css">
	</head>
<body>
	<div class='fix_wrapper' style="margin-top:50px;margin-right:100px"> 
		<h2>修改密码</h2>
		<aside class='form'>
		<form accept-charset="UTF-8" action="${pageContext.request.contextPath}/users.do?method=modPass" method="post">
					<div class='component'>
						<label for="pwd">密&nbsp;&nbsp;码:</label> <input class="text_field_280"
							id="pwd" name="pwd" type="password" placeholder="Password" style="height:30px"/>
					</div>
					<div class='component'>
						<label for="newpwd">新密码:</label> <input class="text_field_280"
							id="newpwd" name="newpwd" type="password" placeholder="New Password" style="height:30px"/>
					</div>
					<div class='component'>
						<label for="renewpwd">确&nbsp;&nbsp;认:</label> <input class="text_field_280"
							id="renewpwd" name="renewpwd" type="password" placeholder="New Password" style="height:30px"/>
					</div>
					<input class="btn btn-success" name="commit" type="submit"
						value="提交" onclick="return checkPass()" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<input class="btn btn-success" name="settle" type="reset"
						value="重置" />
				</form>
		</aside>
	</div>
</body>
<script type="text/javascript">
	function checkPass(){
		var pwd = document.getElementById("pwd").value;
		var newpwd = document.getElementById("newpwd").value;
		var renewpwd = document.getElementById("renewpwd").value;
		if(pwd==null || pwd.trim()==""){
			alert("密码不可为空");
			return false;
		}
		if(newpwd==null || newpwd.trim()==""){
			alert("新密码不可为空");
			return false;
		}
		if(renewpwd==null || renewpwd.trim()==""){
			alert("确认密码不可为空");
			return false;
		}
		if(newpwd!=renewpwd){
			alert("两次密码输入不一致");
			return false;
		}
		return true;
	}
</script>
</html>