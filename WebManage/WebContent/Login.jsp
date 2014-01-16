<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>管理员登录</title>
<link href="css/main-9ef9c0e87dc02c8281af9d91272fd02e.css?body=1"
	rel="stylesheet" type="text/css">
<link href="css/layout-e1c09780018325a8d26698a6e8aa7597.css?body=1"
	rel="stylesheet" type="text/css">
<link href="css/bootstrap-a8e65df0a1d46934b11bbe665c5e00d6.css?body=1"
	rel="stylesheet" type="text/css">
<link href="css/fontawesome-cea23e4121b590dd7fbd5a715f8ea879.css?body=1"
	rel="stylesheet" type="text/css">
<link href="css/bootstrap_and_overrides-ba002271e6152982a71a1893fa440d42.css?body=1"
	rel="stylesheet" type="text/css">
</head>
</script>
<body>
	<div class='fix_wrapper'>
		<nav class='global-nav affix-top'>
			<h2>Administrator登录!</h2>
		</nav>
		<section class='wrap about role' id='about'>
			<aside class='form'>
				<legend>
					<strong>登陆信息</strong>
				</legend>
				<form accept-charset="UTF-8" action="login.do" method="post"  autocomplete="on">
					<div class='component'>
						<label for="username">Username:</label> <input class="text_field_280"
							id="username" name="username" type="text" placeholder="Username" />
					</div>
					<div class='component'>
						<label for="password">Password:</label> <input class="text_field_280"
							id="password" name="password" type="password" placeholder="Password"/>
					</div>
					<div class='component'>
						<label for="verifycode">验&nbsp;&nbsp;证&nbsp;&nbsp;码:</label> <input class="text_field_280" style="width:100px"
							id="verifycode" name="verifycode" type="text" placeholder="Verify Code" maxlength="4" />
						<img src="image.jsp" onclick="change()"  id="imgcode" style="cursor:pointer;margin-bottom:10px; margin-left:30px; margin-right:85px" />
					</div>
					<input class="btn btn-success" name="commit" type="submit"
						value="登陆" onclick="return check()" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<input class="btn btn-success" name="settle" type="reset"
						value="重置" />
			  </div>
				</form>
			</aside>
		</section>
	</div>
	<script type="text/javascript">	//关键总结：在js中使用el表达式一定要使用双引号
		var str = "${str}";
		if(str!=""){
			alert(str);
		}
		
		function change(){
			document.getElementById("imgcode").src="image.jsp";
			
		}
		
		function check(){
			var name=document.getElementById("username").value;
			var pwd=document.getElementById("password").value;
			var vcode=document.getElementById("verifycode").value;
			if(name==null || name.trim()=="" || pwd==null || pwd.trim()==""){
				alert("用户名或密码不许为空");
				return false;
			}
			if(name.length>15 || pwd.length>15){
				alert("用户名或密码超过10位");
				return false;
			}
			if(vcode==null || vcode.trim()==""){
				alert("验证码不许为空");
				return false;
			}
		}
		
	</script>
</body>
</html>