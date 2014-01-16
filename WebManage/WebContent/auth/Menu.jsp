<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <title>This is the Menu!</title>
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta name="description" content="">
  <meta name="author" content="">

	<!--link rel="stylesheet/less" href="less/bootstrap.less" type="text/css" /-->
	<!--link rel="stylesheet/less" href="less/responsive.less" type="text/css" /-->
	<!--script src="js/less-1.3.3.min.js"></script-->
	<!--append ‘#!watch’ to the browser URL, then refresh the page. -->
	
	<link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
	<link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet">

  <!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
  <!--[if lt IE 9]>
    <script src="js/html5shiv.js"></script>
  <![endif]-->

  <!-- Fav and touch icons -->
  <link rel="apple-touch-icon-precomposed" sizes="144x144" href="${pageContext.request.contextPath}/img/apple-touch-icon-144-precomposed.png">
  <link rel="apple-touch-icon-precomposed" sizes="114x114" href="${pageContext.request.contextPath}/img/apple-touch-icon-114-precomposed.png">
  <link rel="apple-touch-icon-precomposed" sizes="72x72" href="${pageContext.request.contextPath}/img/apple-touch-icon-72-precomposed.png">
  <link rel="apple-touch-icon-precomposed" href="${pageContext.request.contextPath}/img/apple-touch-icon-57-precomposed.png">
  <link rel="shortcut icon" href="${pageContext.request.contextPath}/img/favicon.png">
  
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/scripts.js"></script>
</head>

<body>
<div class="container" style="margin-left:50px;margin-top:100px">
	<div class="row clearfix">
		<div class="col-md-4 column" >
			<div class="panel-group" id="panel-698700" >
				<div class="panel panel-default" style="width:150px;text-align:center">
					<div class="panel-heading">
						 <a class="panel-title collapsed" data-toggle="collapse" data-parent="#panel-698700" href="#panel-element-174793">新闻管理</a>
					</div>
					<div id="panel-element-174793" class="panel-collapse collapse">
						<div class="panel-body">
							<a href="${pageContext.request.contextPath}/auth/AddNews.jsp" target="rightframe" style="color:#555">新闻信息添加</a>
						</div>
						<div class="panel-body">
							<a href="${pageContext.request.contextPath}/news.do?method=seePage" target="rightframe" style="color:#555">新闻信息浏览</a>
						</div>
					</div>
				</div>
				<div class="panel panel-default" style="width:150px;text-align:center">
					<div class="panel-heading">
						 <a class="panel-title collapsed" data-toggle="collapse" data-parent="#panel-698700" href="#panel-element-703835">商品管理</a>
					</div>
					<div id="panel-element-703835" class="panel-collapse collapse">
						<div class="panel-body">
							<a href="${pageContext.request.contextPath}/gcate.do?method=seePage" target="rightframe" style="color:#555">商品类别管理</a>
						</div>
						<div class="panel-body">
							<a href="${pageContext.request.contextPath}/gcate.do?method=dispGCate" target="rightframe" style="color:#555">商品注册</a>
						</div>
						<div class="panel-body">
							<a href="${pageContext.request.contextPath}/goods.do?method=seePage" target="rightframe" style="color:#555">商品浏览</a>
						</div>
					</div>
				</div>

				<div class="panel panel-default" style="width:150px;text-align:center">
					<div class="panel-heading">
						 <a class="panel-title collapsed" data-toggle="collapse" data-parent="#panel-698700" href="#panel-element-703836">用户管理</a>
					</div>
					<div id="panel-element-703836" class="panel-collapse collapse">
						<div class="panel-body" id="addUserInfo">
							<a href="${pageContext.request.contextPath}/auth/AddUsers.jsp" target="rightframe" style="color:#555">用户信息添加</a>
						</div>
						<div class="panel-body" id="checkUserInfo">
							<a href="${pageContext.request.contextPath}/users.do?method=seePage" target="rightframe" style="color:#555">用户信息浏览</a>
						</div>
						<div class="panel-body" id="modifyPassword">
							<a href="${pageContext.request.contextPath}/auth/ModifyPassword.jsp" target="rightframe" style="color:#555">修改密码</a>
						</div>
					</div>
				</div>


				<div class="panel panel-default" style="width:150px;text-align:center">
					<div class="panel-heading">
						 <a class="panel-title collapsed" data-toggle="collapse" data-parent="#panel-698700" href="#panel-element-703837">系统管理</a>
					</div>
					<div id="panel-element-703837" class="panel-collapse collapse">
						<div class="panel-body">
							<a href="${pageContext.request.contextPath}/log.do" target="rightframe" style="color:#555">日志管理</a>
						</div>
						<div class="panel-body">
							<a href="${pageContext.request.contextPath}/Login.jsp" target="_parent" style="color:#555">系统退出</a>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="col-md-8 column">
		</div>
	</div>
</div>
<script type="text/javascript">
	var level = "${sessionScope.leval}";	// 这里可以采取session进行控制
	if(level==1){
		document.getElementById("addUserInfo").style.display="none";
		document.getElementById("checkUserInfo").style.display="none";
	}else{
		document.getElementById("modifyPassword").style.display="none";	
	}
</script>
</body>
</html>
    