<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<title>帖子信息</title>
<meta name="description" content="帖子">
<meta name="keywords" content="帖子">
<link href="${pageContext.request.contextPath}/css/style.css"
	rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/menu.css"
	rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/content.css"
	rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/information.css"
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
						<li><a href="${pageContext.request.contextPath}/XueSheng/studentAction_ownProfile">个人资料</a></li>
						<li><a href="${pageContext.request.contextPath}/XueSheng/alterpassword.jsp">修改密码</a></li>
					</ul>
					<h2>培养方案</h2>
					<ul class="menu-left-nav">
						<li><a href="${pageContext.request.contextPath}/XueSheng/studentAction_judgeShiXunTime">实训申请</a></li>
						<li><a href="${pageContext.request.contextPath}/XueSheng/studentAction_judgeShiXiTime">实习申请</a></li>
						<li><a href="${pageContext.request.contextPath}/XueSheng/studentAction_listZj">实习周记</a></li>
					</ul>
					<h2>实用栏位</h2>
					<ul class="menu-left-nav">
						<li><a href="${pageContext.request.contextPath}/XueSheng/studentAction_listInform">校内通知</a></li>
						<li><a href="${pageContext.request.contextPath}/XueSheng/studentAction_listRes">资源下载</a></li>
						<li><a href="${pageContext.request.contextPath}/XueSheng/bbs-platform.jsp">BBS交流</a></li>
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
						贵阳一女大学生网上办贷款被骗几千元<span>董红岩</span>
					</h2>
					<div class="post-desc">
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;花溪一高校的一名女大学生上网时发现一个贷款的广告，她便萌生了贷款作生活费的想法，但给对方汇去2800元后，再无下文，她才意识到自己遭遇了骗局。
						<br />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;17日中午，小李来到贵阳市花溪明珠派出所报警。小李说，她在网上浏览网页时，看到一个贷款的广告，广告称只需要一张二代身份证就能56天的无息贷款，想着自己家庭比较拮据而自己又正在读大学，她便想通过贷款来解决生活费，随即拨打了对方电话希望贷款1万元。
					</div>
				</article>
				<div class="comment">
					<div>
						<div class="ds-thread" id="comments"></div>
						<script type="text/javascript">
							var duoshuoQuery = {
								short_name : "tomastong"
							};
							(function() {
								var ds = document.createElement('script');
								ds.type = 'text/javascript';
								ds.async = true;
								ds.src = 'http://static.duoshuo.com/embed.js';
								ds.charset = 'UTF-8';
								(document.getElementsByTagName('head')[0] || document
										.getElementsByTagName('body')[0])
										.appendChild(ds);
							})();
						</script>
					</div>
				</div>
			</section>
			<div class="clear-float"></div>
		</div>
	</div>
</body>

</html>
