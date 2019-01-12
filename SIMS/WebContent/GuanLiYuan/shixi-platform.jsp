<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <title>管理员系统</title>
    <meta name="description" content="实训,管理">
    <meta name="keywords" content="实训,管理">
    <link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/menu.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/content.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/all-table.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/improve.css" rel="stylesheet">
    <script src="${pageContext.request.contextPath}/js/test.js"></script>
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
                    <h2>实习平台</h2>
                    <form action="${pageContext.request.contextPath}/GuanLiYuan/adminAction_addShiXiTime" method="post">
                        <div class="div-top-1">
                            <span>对应年级: <select name="time.grade.id">
							<c:forEach items="${list}" var="grade">
                            <option value="${grade.id }">${grade.name }</option>
                            </c:forEach>
                            </select></span>
                            <button type="submit" class="control-button" onclick="initConfirmDateTime()">开放</button>
                        </div>
                        <div>

                            <time>起始时间：
                                <input type="date" id="begintime" name="time.startTime">
                            </time>
                            <time>截止时间：
                                <input type="date" id="endtime" name="time.endTime">
                            </time>
                        </div>
                    </form>
                </article>

            </section>
            <div class="clear-float"></div>
        </div>
    </div>
    <script>
  		var prompt = "${prompt}";
  		if(prompt==null || prompt ==""){
  		}else{
  			alert(prompt);
  			window.location.href="${pageContext.request.contextPath}/GuanLiYuan/adminAction_shixiPlatform";
  		}
    </script>
</body>

</html>
