<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
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
		<link href="${pageContext.request.contextPath}/css/improve.css"
			rel="stylesheet">
		<link href="${pageContext.request.contextPath}/css/all-table.css"
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
				<h2>
					实习申请结果
					<span><a
						href="${pageContext.request.contextPath}/FuDaoYuan/assistantAction_listShiXiStudent">返回</a>
					</span>
				</h2>
				<div class="text-content">
					<table class="form-table">
						<tr>
							<tr>
                    			<td>学号:${student.sno }</td>
								<td>姓名:${student.name }</td>
                    		</tr>
							<tr>
                    			<td>实习类型：</td>
								<td>${student.internshipDirection.type}</td>
                    		</tr>
							<tr>
                    			<td>实习单位名称：</td>
								<td>${student.internshipDirection.companyName}</td>
                    		</tr>
							<tr>
                    			<td>实习岗位：</td>
								<td>${student.internshipDirection.internshipPosition}</td>
                    		</tr>
							<tr>
                    			<td>单位地址：</td>
								<td>${student.internshipDirection.companyAddress}</td>
                    		</tr>
							<tr>
                    			<td>单位网址：</td>
								<td>${student.internshipDirection.companyUrl}</td>
                    		</tr>
							<tr>
                    			<td>附加说明：</td>
								<td>${student.internshipDirection.addInformation}</td>
                    		</tr>
					</table>
				</div>
				</article>
				</section>
				<div class="clear-float"></div>
			</div>
		</div>
	</body>

</html>
