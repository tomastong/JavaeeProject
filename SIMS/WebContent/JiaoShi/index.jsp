<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<title>教师实训管理系统</title>
<meta name="description" content="实训,管理">
<meta name="keywords" content="实训,管理">
<link href="${pageContext.request.contextPath}/css/style.css"
	rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/menu.css"
	rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/content.css"
	rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/all-table.css"
	rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/improve.css"
	rel="stylesheet">
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
					<h2>
						资源管理<span><a href="${pageContext.request.contextPath}/JiaoShi/upload-resource.jsp">我要上传</a>
						</span>
					</h2>
					<table class="easy-table">
						<tr>
							<th class="weird">文件名</th>
							<th>大小</th>
							<th>修改时间</th>
							<th colspan="2">操作</th>
						</tr>
						<s:iterator value="list" var="res">
							<tr>
								<td><s:property value="fileName" />
								</td>
								<td><s:property value="fileSize" />
								</td>
								<td><s:date name="date" format="yyyy/MM/dd" />
								</td>
								<td><button
										onclick="javascript:window.location.href='teacherAction_deleteFile?id=' + ${res.id}">删除</button>
								</td>
							</tr>
						</s:iterator>
					</table>
				</article>
			</section>
			<div class="clear-float"></div>
		</div>
	</div>
</body>

</html>
