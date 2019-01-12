<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<title>修改密码</title>
<meta name="description" content="密码">
<meta name="keywords" content="密码">
<link href="${pageContext.request.contextPath}/css/style.css"
	rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/menu.css"
	rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/content.css"
	rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/information.css"
	rel="stylesheet">
<script src="${pageContext.request.contextPath}/js/test.js"></script>
</head>

<body>
	<div class="wrapper">
		<header class="header">
			<img src="${pageContext.request.contextPath}/imgs/top.jpg" title="">
		</header>
		<div class="wrapper2">
			<section class="sidebar">
				<aside class="menu-left-nav-container">
					<h2>个人栏位</h2>
					<ul class="menu-left-nav">
						<li><a href="${pageContext.request.contextPath}/JiaoShi/teacherAction_ownProfile">个人资料</a></li>
						<li><a href="${pageContext.request.contextPath}/JiaoShi/alterpassword.jsp">修改密码</a></li>
					</ul>
					<h2>实用栏位</h2>
					<ul class="menu-left-nav">
						<li><a href="${pageContext.request.contextPath}/JiaoShi/teacherAction_listRes">资源管理</a></li>
						<li><a href="${pageContext.request.contextPath}/JiaoShi/bbs-platform.jsp">BBS交流</a></li>
					</ul>
					<h2>系统管理</h2>
                    <ul class="menu-left-nav">
                        <li><a href="${pageContext.request.contextPath}/login.jsp">注销用户</a>
                        </li>
                    </ul>
				</aside>
			</section>
			<section class="main-content">
				<article>
					<h2>修改密码</h2>
					<form action="teacherAction_modifyPassword" method="post">
						<table class="table">
							<tr>
								<td>原密码：</td>
								<td><input type="password" required id="oldpassword"
									name="oldpassword" value="${oldpassword}" /></td>
							</tr>
							<tr>
								<td>新密码：</td>
								<td><input type="password" required id="password"
									name="password" value="${password}" /></td>
							</tr>
							<tr>
								<td>确&nbsp;&nbsp;认：</td>
								<td><input type="password" required id="password2" /></td>
							</tr>
							<tr>
								<td>
									<button type="submit" onclick="initConfirmPassword()">保存</button>
								</td>
								<td>
									<button type="reset">重置</button></td>
							</tr>
						</table>
					</form>
				</article>
			</section>
			<div class="clear-float"></div>
		</div>
	</div>
	<script>
		initConfirmPassword();
		var prompt = "${prompt}";
		var flag = "${flag}";
		if (prompt == null || prompt == "") {
		} else {
			alert(prompt);
			if (flag == 1) {
				window.location.href = "${pageContext.request.contextPath}/JiaoShi/teacherAction_listRes";
			}
		}
	</script>
</body>

</html>
