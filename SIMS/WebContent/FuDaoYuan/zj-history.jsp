<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<%@ taglib prefix="s" uri="/struts-tags"%>
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
						<li><a
							href="${pageContext.request.contextPath}/FuDaoYuan/assistantAction_ownProfile">个人资料</a>
						</li>
						<li><a
							href="${pageContext.request.contextPath}/FuDaoYuan/alterpassword.jsp">修改密码</a>
						</li>
					</ul>
					<h2>学生管理</h2>
					<ul class="menu-left-nav">
						<li><a
							href="${pageContext.request.contextPath}/FuDaoYuan/assistantAction_listShiXunStudent?pageModel.pageNo=1">实训管理</a>
						</li>
						<li><a
							href="${pageContext.request.contextPath}/FuDaoYuan/internship-manage.jsp">实习管理</a>
						</li>
						<li><a
							href="${pageContext.request.contextPath}/FuDaoYuan/assistantAction_listZj?pageModel.pageNo=1">周记管理</a>
						</li>
					</ul>
					<h2>实用栏位</h2>
					<ul class="menu-left-nav">
						<li><a
							href="${pageContext.request.contextPath}/FuDaoYuan/assistantAction_listInform">校内通知</a>
						</li>
						<li><a
							href="${pageContext.request.contextPath}/FuDaoYuan/school-enterprise.jsp">校企交流</a>
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
						周记审核历史<span><input type="text" id="studentid" value="${studentid}">&nbsp;&nbsp;&nbsp;&nbsp;<button onclick="searchById()">检索</button>&nbsp;&nbsp;&nbsp;&nbsp;<a
							href="${pageContext.request.contextPath}/FuDaoYuan/assistantAction_listZj?pageModel.pageNo=1">返回</a>
						</span>
						
					</h2>
					<table class="easy-table">
						<tr>
							<th>学号</th>
							<th class="weird">标题</th>
							<th>状态</th>
							<th>操作</th>
						</tr>
						<s:if test="list!=null">
							<s:iterator value="list" var="zj">
								<tr>
									<td><s:property value="student.sno" />
									</td>
									<td><s:property value="title" />
									</td>
									<td><s:property
											value="status==1?'未审核':(status==2?'通过':'未过')" />
									</td>
									<td>
										<button
											onclick="javascript:window.location.href='assistantAction_seeZj?id='+${zj.id}">查看</button>
									</td>
								</tr>
							</s:iterator>
						</s:if>
						<s:if test="pageModel.list!=null">
							<s:iterator value="pageModel.list" var="zj">
								<tr>
									<td><s:property value="student.sno" />
									</td>
									<td><s:property value="title" />
									</td>
									<td><s:property
											value="status==1?'未审核':(status==2?'通过':'未过')" />
									</td>
									<td>
										<button
											onclick="javascript:window.location.href='assistantAction_seeZj?id='+${zj.id}">查看</button>
									</td>
								</tr>
							</s:iterator>
						</s:if>
					</table>
				</article>
				<div class="pagination">
					<ul id="page"><c:forEach var="item" varStatus="status" begin="1" end="${pageModel.totalPages}" ><li><a 
							href="${pageContext.request.contextPath}/FuDaoYuan/assistantAction_listZjHistory?pageModel.pageNo=${status.index}" class="page-numbers">${status.index}</a></li></c:forEach></ul>
				</div>
				</article>
			</section>
			<div class="clear-float"></div>
		</div>
	</div>
	<script>
		function searchById(){
			var id = document.getElementById("studentid").value;
			window.location.href="${pageContext.request.contextPath}/FuDaoYuan/assistantAction_listSbHistory?studentid="+id;
		}
		window.onload = function() {
			var curr = ${pageModel.pageNo};
			var page = document.getElementById("page");
			var cnt = page.childNodes.length;
			var firstli = document.createElement("li");
			var lastli = document.createElement("li");
			var spanli = document.createElement("span");
			firstli.innerHTML = "<a href='${pageContext.request.contextPath}/FuDaoYuan/assistantAction_listZjHistory?pageModel.pageNo=${pageModel.pageNo-1}' class='page-numbers prev'>&laquo;上一页</a>";
			lastli.innerHTML = "<a href='${pageContext.request.contextPath}/FuDaoYuan/assistantAction_listZjHistory?pageModel.pageNo=${pageModel.pageNo+1}' class='page-numbers next'>下一页&raquo;</a>";
			spanli.innerHTML = "<span class='page-numbers next'>下一页&raquo;</span>";
			page.childNodes[curr - 1].innerHTML = "<a href='${pageContext.request.contextPath}/FuDaoYuan/assistantAction_listZjHistory?pageModel.pageNo=${pageModel.pageNo}' class='page-numbers current'>"+${pageModel.pageNo}+"</a>";;
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
