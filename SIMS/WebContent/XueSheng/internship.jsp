<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
		<title>实习</title>
		<meta name="description" content="实习">
		<meta name="keywords" content="实习">
		<link href="${pageContext.request.contextPath}/css/style.css"
			rel="stylesheet">
		<link href="${pageContext.request.contextPath}/css/menu.css"
			rel="stylesheet">
		<link href="${pageContext.request.contextPath}/css/content.css"
			rel="stylesheet">
		<link href="${pageContext.request.contextPath}/css/intership.css"
			rel="stylesheet">
		<script src="${pageContext.request.contextPath}/js/test.js">
</script>
	</head>

	<body>
		<div class="wrapper">
			<header class="header">
			<img src="${pageContext.request.contextPath}/imgs/top.jpg" title="">
			</header>
			<div class="wrapper2">
				<section class="sidebar">
				<aside class="menu-left-nav-container">
				<h2>
					个人栏位
				</h2>
				<ul class="menu-left-nav">
					<li>
						<a
							href="${pageContext.request.contextPath}/XueSheng/studentAction_ownProfile">个人资料</a>
					</li>
					<li>
						<a
							href="${pageContext.request.contextPath}/XueSheng/alterpassword.jsp">修改密码</a>
					</li>
				</ul>
				<h2>
					培养方案
				</h2>
				<ul class="menu-left-nav">
					<li>
						<a
							href="${pageContext.request.contextPath}/XueSheng/studentAction_judgeShiXunTime">实训申请</a>
					</li>
					<li>
						<a
							href="${pageContext.request.contextPath}/XueSheng/studentAction_judgeShiXiTime">实习申请</a>
					</li>
					<li>
						<a
							href="${pageContext.request.contextPath}/XueSheng/studentAction_listZj">实习周记</a>
					</li>
				</ul>
				<h2>
					实用栏位
				</h2>
				<ul class="menu-left-nav">
					<li>
						<a
							href="${pageContext.request.contextPath}/XueSheng/studentAction_listInform">校内通知</a>
					</li>
					<li>
						<a
							href="${pageContext.request.contextPath}/XueSheng/studentAction_listRes">资源下载</a>
					</li>
					<li>
						<a
							href="${pageContext.request.contextPath}/XueSheng/bbs-platform.jsp">BBS交流</a>
					</li>
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
				<h2>
					实习申请
					<span><a href="${pageContext.request.contextPath}/XueSheng/studentAction_seeShiXi">查看结果</a> </span>
				</h2>
				<form action="${pageContext.request.contextPath}/XueSheng/studentAction_addShiXi" method="post">
					<div class="radio-option">
						<input type="radio" name="internship.type" value="考研"
							onchange="closeapply()">
						考研
						<input type="radio" name="internship.type" value="考公务员"
							onchange="closeapply()">
						考公务员
						<input type="radio" name="internship.type" value="自主实习"
							onchange="openapply()">
						自主实习
						<input type="radio" name="internship.type" value="正常实习"
							onchange="closeapply()">
						正常实习
						<input type="radio" name="internship.type" value="学校安排"
							onchange="closeapply()">
						学校安排
						<input type="radio" name="internship.type" value="其它"
							onchange="toggleapply()">
						其它
						<button type="submit">
							提交申请
						</button>
					</div>
					<div id="apply-form-ip">
						<table>
							<tr>
								<td>
									实习单位名称：
								</td>
								<td>
									<input type="text" name="internship.companyName">
									<br />
								</td>
							</tr>
							<tr>
								<td>
									实习岗位：
								</td>
								<td>
									<input type="text" name="internship.internshipPosition">
									<br />
								</td>
							</tr>
							<tr>
								<td>
									单位地址：
								</td>
								<td>
									<input type="text" name="internship.companyAddress">
									<br />
								</td>
							</tr>
							<tr>
								<td>
									单位网址：
								</td>
								<td>
									<input type="text" name="internship.companyUrl">
									<br />
								</td>
							</tr>
						</table>
					</div>
					<div id="ps-info">
						<p>
							附加信息：
						</p>
						<textarea name="" id="" cols="30" rows="10"
							name="internship.addInformation"></textarea>
					</div>
				</form>
				</article>
				</section>
				<div class="clear-float"></div>
			</div>
		</div>
		<script>
window.onload = closeapply();
</script>
	</body>

</html>
