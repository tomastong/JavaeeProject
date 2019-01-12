<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <title>校企交流</title>
    <meta name="description" content="校企,交流">
    <meta name="keywords" content="校企,交流">
    <link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/menu.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/content.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/all-table.css" rel="stylesheet">
</head>

<body>
    <div class="wrapper">
        <header class="header"><img src="${pageContext.request.contextPath}/imgs/top.jpg" title=""></header>
        <div class="wrapper2">
            <section class="sidebar">
                <aside class="menu-left-nav-container">
                    <h2>个人栏位</h2>
                    <ul class="menu-left-nav">
                        <li><a href="${pageContext.request.contextPath}/FuDaoYuan/assistantAction_ownProfile">个人资料</a></li>
                        <li><a href="${pageContext.request.contextPath}/FuDaoYuan/alterpassword.jsp">修改密码</a></li>
                    </ul>
                    <h2>学生管理</h2>
                    <ul class="menu-left-nav">
                        <li><a href="${pageContext.request.contextPath}/FuDaoYuan/assistantAction_listShiXunStudent?pageModel.pageNo=1">实训管理</a></li>
                        <li><a href="${pageContext.request.contextPath}/FuDaoYuan/internship-manage.jsp">实习管理</a></li>
                        <li><a href="${pageContext.request.contextPath}/FuDaoYuan/assistantAction_listZj?pageModel.pageNo=1">周记管理</a></li>
                    </ul>
                    <h2>实用栏位</h2>
                    <ul class="menu-left-nav">
                        <li><a href="${pageContext.request.contextPath}/FuDaoYuan/assistantAction_listInform">校内通知</a>
                        </li>
                        <li><a href="${pageContext.request.contextPath}/FuDaoYuan/school-enterprise.jsp">校企交流</a>
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
                	<h2>校企聊天室</h2>
                	<form action="" method="post">
                		<table class="form-table">
                			<tr>
                				<td>聊天记录</td>
                				<td><textarea name="" id="" cols="30" rows="10"></textarea></td>
                			</tr>
                			<tr>
                				<td>我想要说</td>
                				<td><input type="text" class="chat">&nbsp;&nbsp;<button type="submit">发送</button></td>
                			</tr>
                		</table>
                	</form>
                </article>
            </section>
            <div class="clear-float"></div>
        </div>
    </div>
</body>

</html>
