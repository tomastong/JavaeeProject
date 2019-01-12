<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <title>管理员实训管理系统</title>
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
                	<h2>学生管理<span><a href="${pageContext.request.contextPath}/GuanLiYuan/add-student.jsp">添加学生</a></span></h2>
                     <table class="easy-table">
                         <tr>
                             <th>学号</th>
                             <th>姓名</th>
                             <th>年级</th>
                             <th>班级</th>
                             <th>电话</th>
                             <th colspan="3">操作</th>
                         </tr>
                         <s:iterator value="pageModel.list" var="student">
                         <tr>
                             <td>${student.sno}</td>
                             <td>${student.name}</td>
                             <td>${student.grade.name} </td>
                             <td>${student.direction.name}${student.classes.name}</td>
                             <td>${student.tel}</td>
                             <td><button onclick="javascript:window.location.href='adminAction_seeStudent?id='+${student.id}+'&flag=alter'">修改</button></td>
                             <td><button onclick="javascript:window.location.href='adminAction_delStudent?id='+${student.id}">删除</button></td>
                             <td><button onclick="javascript:window.location.href='adminAction_seeStudent?id='+${student.id}+'&flag=see'">查看</button></td>
                         </tr>
                         </s:iterator>
                     </table>
                </article>
                <div class="pagination">
					<ul id="page"><c:forEach var="item" varStatus="status" begin="1" end="${pageModel.totalPages}" ><li><a 
							href="${pageContext.request.contextPath}/GuanLiYuan/adminAction_listStudent?pageModel.pageNo=${status.index}" class="page-numbers">${status.index}</a></li></c:forEach></ul>
				</div>
            </section>
            <div class="clear-float"></div>
        </div>
    </div>
    <script>
    	window.onload = function() {
			var curr = ${pageModel.pageNo};
			var page = document.getElementById("page");
			var cnt = page.childNodes.length;
			var firstli = document.createElement("li");
			var lastli = document.createElement("li");
			var spanli = document.createElement("span");
			firstli.innerHTML = "<a href='${pageContext.request.contextPath}/GuanLiYuan/adminAction_listStudent?pageModel.pageNo=${pageModel.pageNo-1}' class='page-numbers prev'>&laquo;上一页</a>";
			lastli.innerHTML = "<a href='${pageContext.request.contextPath}/GuanLiYuan/adminAction_listStudent?pageModel.pageNo=${pageModel.pageNo+1}' class='page-numbers next'>下一页&raquo;</a>";
			spanli.innerHTML = "<span class='page-numbers next'>下一页&raquo;</span>";
			page.childNodes[curr - 1].innerHTML = "<a href='${pageContext.request.contextPath}/GuanLiYuan/adminAction_listStudent?pageModel.pageNo=${pageModel.pageNo}' class='page-numbers current'>"+${pageModel.pageNo}+"</a>";;
			if (cnt != curr && cnt != 1) {
				page.insertBefore(lastli, page.childNodes[cnt]);
			}
			if(cnt == 1){
				page.insertBefore(spanli, page.childNodes[cnt]);
			}
			if (curr != 1) {
				page.insertBefore(firstli, page.childNodes[0]);
			}
		}
    </script>
</body>

</html>
