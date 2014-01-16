<%@page import="cn.itjava.domain.GCate"%>
<%@page import="java.util.List"%>
<%@page import="cn.itjava.util.PageModel"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
<title>日志查看</title>
<link href="${pageContext.request.contextPath}/css/main-9ef9c0e87dc02c8281af9d91272fd02e.css?body=1"
	rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath}/css/layout-e1c09780018325a8d26698a6e8aa7597.css?body=1"
	rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath}/css/bootstrap-a8e65df0a1d46934b11bbe665c5e00d6.css?body=1"
	rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath}/css/fontawesome-cea23e4121b590dd7fbd5a715f8ea879.css?body=1"
	rel="stylesheet" type="text/css">
<link
	href="${pageContext.request.contextPath}/css/bootstrap_and_overrides-ba002271e6152982a71a1893fa440d42.css?body=1"
	rel="stylesheet" type="text/css">
<link href="css/bootstrap.css" rel="stylesheet">
<link href="css/datepicker.css" rel="stylesheet">
<style type="text/css">
table a {
	cursor: pointer;
}

.page a {
	font-size: 20px;
	margin-left: 50px;
	margin-right: 50px;
}

.page {
	margin-top: 10px;
	margin-bottom: 10px;
}
table tr:nth-child(odd){
	background-color:#d9edf7;
}
table tr:nth-child(even){
	background-color:#f5f5f5;
}
#alert{
	display: none;
}
#que  a:link{
	 text-decoration: none; 
}

</style>
</head>
<body>
	<div class='fix_wrapper' style="margin-top: 50px; margin-right: 100px">
		<h2>日志管理</h2>
		<div class="smallcontain" style="border: 1px solid #ccc">
		     
			<table class="table" contenteditable="true" style="text-align:center">
				<thead>
					<tr style="background-color:#f5f5f5;">
						<th>用户</th>
						<th>操作</th>
						<th>时间</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="log" items="${requestScope.list}" >
						<tr style="height:40px">
							<td>${log.name}</td>
							<td>${log.opera}</td>
							<td><fmt:formatDate value="${log.time}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<div class="page">
				结束啦！没有更多的日志记录啦！
			</div>
		</div>
	</div>
</body>
</html>