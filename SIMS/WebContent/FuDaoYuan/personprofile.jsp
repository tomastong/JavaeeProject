<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <title>个人资料</title>
    <meta name="description" content="个人,资料">
    <meta name="keywords" content="个人,资料">
    <link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/menu.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/content.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/information.css" rel="stylesheet">
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
                    <h2>我的资料</h2>
                    <div id="person-detail">
                    	<table class="table">
                    		<tr>
                    			<td>姓名：</td>
								<td>${assistant.name }</td>
                    		</tr>
                            <tr>
                                <td>工号：</td>
                                <td>${assistant.jobNum }</td>
                            </tr>
                            <tr>
                                <td>性别：</td>
                                <td>${assistant.sex }</td>
                            </tr>
                            <tr>
                                <td>电话：</td>
                                <td>${assistant.tel }</td>
                            </tr>
                    		<tr>
                    			<td>负责班级：</td>
								<td>${assistant.grade.name }</td>
                    		</tr>
                    		<tr>
                    			<td>地址：</td>
								<td>${assistant.address }</td>
                    		</tr>
                    	</table>
                    </div>
                    <div id="poster-preview">
                    	<img class="avatar" src="${pageContext.request.contextPath}/${assistant.imgSrc}" alt="辅导员" title="辅导员">
                    </div>
                    <div class="clear-float"></div>
                </article>
            </section>
            <div class="clear-float"></div>
        </div>
    </div>
</body>

</html>
