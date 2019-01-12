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
    <link href="${pageContext.request.contextPath}/css/all-table.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/improve.css" rel="stylesheet">
</head>

<body>
    <div class="wrapper">
        <header class="header"><img src="${pageContext.request.contextPath}/imgs/top.jpg" title=""></header>
        <div class="wrapper2">
            <section class="sidebar">
                <aside class="menu-left-nav-container">
                    <h2>个人栏位</h2>
                    <ul class="menu-left-nav">
                        <li><a href="${pageContext.request.contextPath}/JiaoShi/teacherAction_ownProfile">个人资料</a>
                        </li>
                        <li><a href="${pageContext.request.contextPath}/JiaoShi/alterpassword.jsp">修改密码</a>
                        </li>
                    </ul>
                    <h2>实用栏位</h2>
                    <ul class="menu-left-nav">
                        <li><a href="${pageContext.request.contextPath}/JiaoShi/teacherAction_listRes">资源管理</a>
                        </li>
                        <li><a href="${pageContext.request.contextPath}/JiaoShi/bbs-platform.jsp">BBS交流</a>
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
								<td>${teacher.name }</td>
                    		</tr>
                            <tr>
                                <td>性别：</td>
                                <td>${teacher.sex }</td>
                            </tr>
                            <tr>
                                <td>年级：</td>
                                <td>${teacher.grade.name }</td>
                            </tr>
                            <tr>
                                <td>班级：</td>
                                <td>${teacher.direction.name } ${teacher.classes.name }</td>
                            </tr>
                            <tr>
                                <td>联系方式：</td>
                                <td>${teacher.tel }</td>
                            </tr>
                    	</table>
                    </div>
                    <div id="poster-preview">
                    	<img class="avatar" src="${pageContext.request.contextPath}/${teacher.imgSrc }" alt="">
                    </div>
                    <div class="clear-float"></div>
                </article>
            </section>
            <div class="clear-float"></div>
        </div>
    </div>
</body>

</html>
