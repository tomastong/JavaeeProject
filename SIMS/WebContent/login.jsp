<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<title>实习管理系统</title>
<meta name="description" content="学生实习管理">
<meta name="keywords" content="实习">
<link
	href="${pageContext.request.contextPath}/css/login/bootstrap.min.css"
	rel="stylesheet">
<link
	href="${pageContext.request.contextPath}/css/login/bootstrap-improve.css"
	rel="stylesheet">
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/test.js"></script>
</head>

<body id="body">

	<div class="container">

		<form class="form-horizontal" action="loginAction" role="form"
			method="post">
			<div class="div-header">
				<h1>
					<strong>实习管理系统</strong>
				</h1>
			</div>
			<div class="form-group">
				<label for="identify" class="col-sm-5 control-label">身&nbsp;&nbsp;&nbsp;&nbsp;份：</label>
				<div class="col-sm-7">
					<select class="form-control" id="identify" name="level">
						<option value="1" selected>学生</option>
						<option value="2">辅导员</option>
						<option value="3">实训教师</option>
						<option value="4">管理员</option>
					</select>
				</div>
			</div>

			<div class="form-group">
				<label for="username" class="col-sm-5 control-label">用户名：</label>
				<div class="col-sm-7">
					<input type="text" class="form-control" id="username"
						name="username" pattern="^\d{8}$" oninput="out(this)" required
						placeholder="Username" value="${username}">
				</div>
			</div>
			<div class="form-group">
				<label for="password" class="col-sm-5 control-label">密&nbsp;&nbsp;&nbsp;&nbsp;码：</label>
				<div class="col-sm-7">
					<input type="password" class="form-control" id="password"
						name="password" required placeholder="Password" value="${password}">
				</div>
			</div>


			<div class="form-group">
				<label for="verifycode" class="col-sm-5 control-label">验证码：</label>
				<div class="col-sm-7">
					<input type="text" class="form-control" id="verifycode"
						name="verifycode" maxlength="4" required placeholder="verify code" />
					<img id="imgcode" src="image.jsp" alt="点击切换" title="点击切换"
						onclick="javascript:this.src='image.jsp'" />
				</div>
			</div>

			<div class="form-group">
				<div class="col-sm-offset-5 col-sm-7 div-footer">
					<button type="submit" class="btn btn-success">登录</button>
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<button type="reset" class="btn btn-success">重置</button>
				</div>
			</div>
		</form>
	</div>
	<script>
		var prompt = "${prompt}";
		var level = "${level}";
		if (prompt == null || prompt == "") {
		} else {
			alert(prompt);
		}
		var select = document.getElementById("identify");
		for(var i=0; i<select.options.length; i++){
			if(level == select.options[i].value){
				select.options[i].selected = true;
			}
		}
	</script>
</body>

</html>
