<%@page import="cn.itjava.domain.News"%>
<%@page import="java.util.List"%>
<%@page import="cn.itjava.util.PageModel"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<html>
<head>
<title>新闻浏览</title>
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
</style>
</head>
<body>
	<div class='fix_wrapper' style="margin-top: 50px; margin-right: 100px">
		<h2>新闻管理</h2>
		<div class="smallcontain" style="border: 1px solid #ccc">
 
			<table class="table" contenteditable="true">
				<thead>
					<tr style="background-color:#f5f5f5;">
						<th>名称</th>
						<th>类别</th>
						<th>查看</th>

					</tr>
				</thead>
				<tbody>
					<c:forEach var="goods" items="${requestScope.list}" >
						<tr>
							<td>${goods.name}</td>
							<td>${goods.gcate.name}</td>
							<td><a href="#" onclick="see(${goods.id})">查看</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<div class="page">
				<h2>没有更多的动态啦！</h2>
			</div>
		</div>
	</div>
	<script type="text/javascript">
	    function see(id){
	    	window.location = "${pageContext.request.contextPath}/PreGoods.do?method=justSee&id="+id;
	    }
	</script>
</body>
</html>