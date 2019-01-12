<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<title>实习周记</title>
<meta name="description" content="实习,周记">
<meta name="keywords" content="实习,周记">
<link href="${pageContext.request.contextPath}/css/style.css"
	rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/menu.css"
	rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/content.css"
	rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/all-table.css"
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
						<li><a href="${pageContext.request.contextPath}/XueSheng/studentAction_ownProfile">个人资料</a>
						</li>
						<li><a href="${pageContext.request.contextPath}/XueSheng/alterpassword.jsp">修改密码</a>
						</li>
					</ul>
					<h2>培养方案</h2>
					<ul class="menu-left-nav">
						<li><a href="${pageContext.request.contextPath}/XueSheng/studentAction_judgeShiXunTime">实训申请</a>
						</li>
						<li><a href="${pageContext.request.contextPath}/XueSheng/studentAction_judgeShiXiTime">实习申请</a>
						</li>
						<li><a href="${pageContext.request.contextPath}/XueSheng/studentAction_listZj">实习周记</a>
						</li>
					</ul>
					<h2>实用栏位</h2>
					<ul class="menu-left-nav">
						<li><a href="${pageContext.request.contextPath}/XueSheng/studentAction_listInform">校内通知</a>
						</li>
						<li><a href="${pageContext.request.contextPath}/XueSheng/studentAction_listRes">资源下载</a>
						</li>
						<li><a href="${pageContext.request.contextPath}/XueSheng/bbs-platform.jsp">BBS交流</a>
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
						实习周记 <span><a href="${pageContext.request.contextPath}/XueSheng/writezj.jsp">我要写周记</a>
					</h2>

					<table class="form-table">
						<tr>
							<th class="weird">标题</th>
							<th>日期</th>
							<th>状态</th>
							<th colspan="2">操作</th>
						</tr>
							<s:iterator value="list" var="zj">
								<tr>
									<td><s:property value="title"/>
									</td>
									<td><s:date name="date" format="yyyy/MM/dd" />
									</td>
									<td><s:property value="status==1?'未审核':(status==2?'通过':'未过')"/>
									</td>
									<td><button
											onclick="javascript:window.location.href='studentAction_seeZj?id='+${id}">查看</button>
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
