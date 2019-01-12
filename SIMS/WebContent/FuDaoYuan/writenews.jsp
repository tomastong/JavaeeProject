<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<title>新帖</title>
<meta name="description" content="新帖">
<meta name="keywords" content="新帖">
<link href="${pageContext.request.contextPath}/css/style.css"
	rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/menu.css"
	rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/content.css"
	rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/improve.css"
	rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/all-table.css"
	rel="stylesheet">
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/tinymce/tinymce.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/tinymce/langs/zh_CN.js"></script>

<script type="text/javascript">
	tinyMCE
			.init({
				selector : "textarea",
				plugins : [
						"advlist autolink lists link image charmap print preview",
						"searchreplace visualblocks code fullscreen",
						"insertdatetime contextmenu paste" ],
				toolbar : "insertfile undo redo | styleselect | bold italic | alignleft aligncenter alignright alignjustify | bullist numlist outdent indent | link image"
			});
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
					<h2>个人栏位</h2>
					<ul class="menu-left-nav">
						<li><a
							href="${pageContext.request.contextPath}/FuDaoYuan/assistantAction_ownProfile">个人资料</a>
						</li>
						<li><a
							href="${pageContext.request.contextPath}/FuDaoYuan/alterpassword.jsp">修改密码</a>
						</li>
					</ul>
					<h2>学生管理</h2>
					<ul class="menu-left-nav">
						<li><a
							href="${pageContext.request.contextPath}/FuDaoYuan/assistantAction_listShiXunStudent?pageModel.pageNo=1">实训管理</a>
						</li>
						<li><a
							href="${pageContext.request.contextPath}/FuDaoYuan/internship-manage.jsp">实习管理</a>
						</li>
						<li><a
							href="${pageContext.request.contextPath}/FuDaoYuan/assistantAction_listZj?pageModel.pageNo=1">周记管理</a>
						</li>
					</ul>
					<h2>实用栏位</h2>
					<ul class="menu-left-nav">
						<li><a
							href="${pageContext.request.contextPath}/FuDaoYuan/assistantAction_listInform">校内通知</a>
						</li>
						<li><a
							href="${pageContext.request.contextPath}/FuDaoYuan/school-enterprise.jsp">校企交流</a>
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
					<h2>新通知</h2>
					<form action="assistantAction_addInform" method="post">
						<table class="form-table">
							<tr>
								<td class="adjust-td">范围：</td>
								<td><select name="inform.scope" id="scope">
										<option value="0">全体学生</option>
										<option value="1">Java班级</option>
										<option value="2">.Net班级</option>
										<option value="3">物联网班级</option>
								</select>
								</td>
							</tr>
							<tr>
								<td>标题：</td>
								<td><input type="text" name="inform.title">
								</td>
							</tr>
							<tr>
								<td>描述：</td>
								<td><textarea name="inform.descr" id="" cols="50" rows="10"></textarea>
								</td>
							</tr>
							<tr>
								<td></td>
								<td><button type="submit">发表</button>&nbsp;&nbsp;&nbsp;&nbsp;
									<button type="reset">重置</button>
								</td>
							</tr>
						</table>
					</form>
				</article>
			</section>
			<div class="clear-float"></div>
		</div>
	</div>
	<script>
		var prompt = "${prompt}";
		if (prompt == null || prompt == "") {
		} else {
			alert(prompt);
			window.location.href='${pageContext.request.contextPath}/FuDaoYuan/assistantAction_listInform';
		}
	</script>
</body>

</html>
