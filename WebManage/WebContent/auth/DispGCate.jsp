<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
	<head>
		<title>添加用户</title>	
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
		<h2>修改类别</h2>
		<aside class='form'>
		<form accept-charset="UTF-8" action="${pageContext.request.contextPath}/gcate.do?method=upd" method="post">
					<div class='component'>
						<label for="category">类别:</label> <input class="text_field_280" value="${requestScope.gcate.name}"
							id="category" name="category" type="text" placeholder="Username" style="height:30px"/>
					</div>
					<input class="btn btn-success" name="GCateId" type="hidden"
						value="${requestScope.gcate.id }"  />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<input class="btn btn-success" name="commit" type="submit"
						value="提交" onclick="return checkSubmit()" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<input class="btn btn-success" name="settle" type="reset"
						value="重置" />
				</form>
				</aside>
	</div>
</body>
<script type="text/javascript">
var addAns = "${addAns}";
if(addAns=="success"){
	alert("添加成功");
}else if(addAns=="error"){
	alert("添加失败");
}

function checkSubmit(){
	var category = document.getElementById("category").value;
	if(category==null || category.trim()==""){
		alert("用户名或密码不许为空");
		return false;
	}
}
</script>
</html>