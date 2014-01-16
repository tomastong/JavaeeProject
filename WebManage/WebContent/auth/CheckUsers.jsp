<%@page import="cn.itjava.util.PageModel"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<html>
	<head>
		<title>用户管理</title>	
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
		table a{
			cursor:pointer;
			
		}
		.page a{
			font-size: 20px;
			margin-left: 50px;
			margin-right:50px;		
		}
		.page{
			margin-top:10px;
			margin-bottom:10px;
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
<div class='fix_wrapper' style="margin-top:50px;margin-right:100px"> 
	<h2>用户管理</h2>
	<div class="smallcontain" style="border:1px solid #ccc">	
			<table class="table" contenteditable="true">
				<thead>
					<tr>
						<th>名称</th>
						<th>修改</th>
						<th>删除</th>
						<th>查看</th>
						
					</tr>
				</thead>
				<tbody>
					<c:forEach var="user" items="${requestScope.pageModel.list}" >
						<tr>
							<td>${user.name}</td>
							<td><a href="#" onclick="upd(${user.id})">修改</a></td>
							<td><a href="#" onclick="del(${user.id})">删除</a></td>
							<td><a href="#" onclick="see(${user.id})">查看</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<div class="page"><a href="#" onclick="topPage()" >首页</a><a href="#" onclick="previousPage()">上一页</a><a href="#" onclick="nextPage()">下一页</a><a href="#" onclick="bottomPage()">尾页</a></div>
	</div>
</div>
<script type="text/javascript">
	var delAns = "${requestScope.delAns}";
	if(delAns=="success"){
		alert("删除成功");
	}else if(delAns=="error"){
		alert("删除失败");
	}

	var updAns = "${requestScope.updAns}";
	if(updAns=="success"){
		alert("修改成功");
	}else if(updAns=="error"){
		alert("修改失败");
	}

	function topPage(){
		window.location="${pageContext.request.contextPath}/users.do?method=seePage&pageNo=${requestScope.pageModel.getTopPageNo()}";
		}
	function previousPage(){
		window.location="${pageContext.request.contextPath}/users.do?method=seePage&pageNo=${requestScope.pageModel.getPreviousPageNo()}";
	}
	function nextPage(){
		window.location="${pageContext.request.contextPath}/users.do?method=seePage&pageNo=${requestScope.pageModel.getNextPageNo()}";
	}
	function bottomPage(){
		window.location="${pageContext.request.contextPath}/users.do?method=seePage&pageNo=${requestScope.pageModel.getBottomPageNo()}";
	}
	
	function del(id){
		if(confirm('确认删除吗')){
			window.location="${pageContext.request.contextPath}/users.do?method=del&id="+id;
		}
	}
	function upd(id){
		if(confirm('确认修改吗')){
			window.location="${pageContext.request.contextPath}/users.do?method=see&id="+id;
		}
	}
	function see(id){
		window.location="${pageContext.request.contextPath}/users.do?method=see&id="+id;
	}
	
</script>
</body>
</html>