<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<html>
	<head>
		<title>修改商品</title>	
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
	</head>
<body>
	<div class='fix_wrapper' style="margin-top:50px;margin-right:100px"> 
		<h2>商品查看</h2>
		<aside class='form'>
		<form accept-charset="UTF-8" action="#" method="post">
					<div class='component'>
						<label for="GoodsName">名称:</label> <input class="text_field_280" value="${requestScope.goods.name}"
							id="GoodsName" name="GoodsName" type="text" readonly="readonly" placeholder="Enter Name" style="height:30px" />
					</div>
					<div class='component'>
						<label for="GoodsCategory">类别:</label>
						<select disabled="disabled" size="1" class="text_field_280" id="GoodsCategory" name="GoodsCategory" style="font-size:15px" size="3">
							<option>${goods.gcate.name}</option>
						</select>
					</div>
					<div class='component'>
						<label for="GoodsDescribe">说明:</label> <textarea class="text_field_280"
							id="GoodsDescribe" name="GoodsDescribe" readonly="readonly" placeholder="Enter Describe" style="resize:none" rows="8" >${goods.desc }</textarea>
					</div>
					<input class="btn btn-success" name="GoodsId" value="${requestScope.goods.id}" type="hidden"/>
				</form>
				</aside>
	</div>
</body>
</html>