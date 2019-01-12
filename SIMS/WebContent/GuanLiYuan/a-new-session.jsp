<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>

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
<link href="${pageContext.request.contextPath}/css/improve.css"
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
						<li><a
							href="${pageContext.request.contextPath}/GuanLiYuan/adminAction_ownProfile">个人资料</a>
						</li>
						<li><a
							href="${pageContext.request.contextPath}/GuanLiYuan/alterpassword.jsp">修改密码</a>
						</li>
					</ul>
					<h2>用户管理</h2>
					<ul class="menu-left-nav">
						<li><a
							href="${pageContext.request.contextPath}/GuanLiYuan/adminAction_listStudent?pageModel.pageNo=1">学生管理</a>
						</li>
						<li><a
							href="${pageContext.request.contextPath}/GuanLiYuan/adminAction_listTeacher">教师管理</a>
						</li>
						<li><a
							href="${pageContext.request.contextPath}/GuanLiYuan/adminAction_listAssistant">导员管理</a>
						</li>
					</ul>
					<h2>平台管理</h2>
					<ul class="menu-left-nav">
						<li><a
							href="${pageContext.request.contextPath}/GuanLiYuan/adminAction_shixunPlatform">实训平台</a>
						</li>
						<li><a
							href="${pageContext.request.contextPath}/GuanLiYuan/adminAction_shixiPlatform">实习平台</a>
						</li>
						<li><a
							href="${pageContext.request.contextPath}/GuanLiYuan/adminAction_searchAllGrade">新新一届</a></li>
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
					<h2>添加实训班级</h2>
					<p class="offset-left">添加年级：</p>
					<form action="${pageContext.request.contextPath}/GuanLiYuan/adminAction_addGrade" method="post">
						<table class="easy-table content-layout offset-left">
							<tr>
								<td><input type="text"  required name="grade.name">
								</td>
								<td>
									<button type="submit">添加</button>
								</td>
							</tr>
						</table>
					</form>
					<p class="offset-left">添加方向：</p>
					<form action="${pageContext.request.contextPath}/GuanLiYuan/adminAction_addDirection" method="post">
						<table class="easy-table content-layout offset-left">
							<tr>
								<td><select name="direction.grade.id" id="">
										<option value="">-选择年级-</option>
										<c:forEach items="${gradeList}" var="grade">
											<option value="${grade.id }">${grade.name }</option>
										</c:forEach>
								</select></td>
								<td><input type="text" name="direction.name"></td>
								<td>
									<button type="submit">添加</button>
								</td>
							</tr>
						</table>
					</form>
					<p class="offset-left">添加班级：</p>
					<form action="${pageContext.request.contextPath}/GuanLiYuan/adminAction_addClasses" method="post">
						<table class="easy-table content-layout offset-left">
							<tr>
								<td><select name="" id="grade3" onchange="aaa()">
										<option value="">-选择年级-</option>
										<c:forEach items="${gradeList}" var="grade">
											<option value="${grade.id }">${grade.name }</option>
										</c:forEach>
								</select></td>
								<td><select name="classes.direction.id" id="shixun3">
										<option value="">-选择方向-</option>
								</select></td>
								<td><input type="text" name="classes.name"></td>
								<td>
									<button type="submit">添加</button>
								</td>
							</tr>
						</table>
					</form>

				</article>
			</section>
			<div class="clear-float"></div>
		</div>
	</div>
	<script>
	var nianji = new Array(); //存储科目
	var fangxiang = new Array(); //存储院系
	
	
	//存储年级
	<s:iterator value="gradeList" id="grade">
		nianji.push("${grade.id}","${grade.name}");
	</s:iterator>

	//存储方向
	<s:iterator value="directionList" id="shixun">
		fangxiang.push("${shixun.grade.id}","${shixun.name}","${shixun.id}");
	</s:iterator>
	
	function aaa(){
		var select1 = document.getElementById("grade3");
		var select2 = document.getElementById("shixun3");
		select2.length = 1;
		var index = select1.selectedIndex;
		var value = select1.options[index].value;
		for(var i=0; i<fangxiang.length; i+=3){
			if(value==fangxiang[i]){
				select2.options.add(new Option(fangxiang[i+1],fangxiang[i+2]));
			}
		}
	}
	
	</script>
</body>

</html>
