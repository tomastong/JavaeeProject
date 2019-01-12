<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <title>教师实训管理系统</title>
    <meta name="description" content="实训,管理">
    <meta name="keywords" content="实训,管理">
    <link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/menu.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/content.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/all-table.css" rel="stylesheet">
</head>

<body>
    <div class="wrapper">&nbsp; 
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
                	<h2>校内通知<span><a href="${pageContext.request.contextPath}/FuDaoYuan/writenews.jsp">我要通知</a></span></h2>
                     <table class="easy-table">
                         <tr>
                             <th class="weird">标题</th>
                             <th>范围</th>
                             <th>日期</th>
                             <th colspan="3">操作</th>
                         </tr>
                         <s:iterator value="list" var="inform">
                         <tr>
                             <td>${inform.title }</td>
                             <td><s:property value="scope==0?'全部学生':(scope==1?'Java班级':(scope==2?'.Net班级':'物联网班级'))" /></td>
                             <td><s:date name="date" format="yyyy/MM/dd"/></td>
                             <td><button onclick="javascript:window.location.href='${pageContext.request.contextPath}/FuDaoYuan/assistantAction_seeInform?id='+${inform.id}+'&flag=alter'">修改</button></td>
                             <td><button onclick="javascript:window.location.href='${pageContext.request.contextPath}/FuDaoYuan/assistantAction_delInform?id='+${inform.id}">删除</button></td>
                             <td><button onclick="javascript:window.location.href='${pageContext.request.contextPath}/FuDaoYuan/assistantAction_seeInform?id='+${inform.id}+'&flag=see'">查看</button></td>
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
