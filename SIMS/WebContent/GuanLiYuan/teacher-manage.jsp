<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <title>管理员实训管理系统</title>
    <meta name="description" content="实训,管理">
    <meta name="keywords" content="实训,管理">
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
                        <li><a href="${pageContext.request.contextPath}/GuanLiYuan/adminAction_ownProfile">个人资料</a>
                        </li>
                        <li><a href="${pageContext.request.contextPath}/GuanLiYuan/alterpassword.jsp">修改密码</a>
                        </li>
                    </ul>
                    <h2>用户管理</h2>
                    <ul class="menu-left-nav">
                        <li><a href="${pageContext.request.contextPath}/GuanLiYuan/adminAction_listStudent?pageModel.pageNo=1">学生管理</a>
                        </li>
                        <li><a href="${pageContext.request.contextPath}/GuanLiYuan/adminAction_listTeacher">教师管理</a>
                        </li>
                        <li><a href="${pageContext.request.contextPath}/GuanLiYuan/adminAction_listAssistant">导员管理</a>
                        </li>
                    </ul>
                    <h2>平台管理</h2>
                    <ul class="menu-left-nav">
                        <li><a href="${pageContext.request.contextPath}/GuanLiYuan/adminAction_shixunPlatform">实训平台</a>
                        </li>
                        <li><a href="${pageContext.request.contextPath}/GuanLiYuan/adminAction_shixiPlatform">实习平台</a>
                        </li>
                        <li><a href="${pageContext.request.contextPath}/GuanLiYuan/adminAction_searchAllGrade">新新一届</a></li>
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
                	<h2>教师管理<span><a href="add-teacher.jsp">添加教师</a></span></h2>
                     <table class="easy-table">
                         <tr>
                             <th>工号</th>
                             <th>姓名</th>
                             <th>负责年级</th>
                             <th>邮箱</th>
                             <th colspan="3">操作</th>
                         </tr>
						<s:iterator value="list" var="teacher">
							<tr>
								<td>${teacher.jobNum}</td>
								<td>${teacher.name}</td>
								<td>${teacher.grade.name}</td>
								<td>${teacher.tel}</td>
								<td><button
										onclick="javascript:window.location.href='adminAction_seeTeacher?id='+${teacher.id}+'&flag=alter'">修改</button>
								</td>
								<td><button
										onclick="javascript:window.location.href='adminAction_delTeacher?id='+${teacher.id}">删除</button>
								</td>
								<td><button
										onclick="javascript:window.location.href='adminAction_seeTeacher?id='+${teacher.id}+'&flag=see'">查看</button>
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
