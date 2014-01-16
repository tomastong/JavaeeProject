<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <title>Bootstrap 3, from LayoutIt!</title>
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
	<style type="text/css">
		#headdiv{
			background-image: linear-gradient(to bottom, #EEE 0%,#F5F5F5 15%);
			padding: 10px 0;
			height: 60px;
			position: relative;
			margin:0px;
			-webkit-box-shadow: 0 0 3px rgba(0, 0, 0, 0.7);
		    -moz-box-shadow: 0 0 3px rgba(0, 0, 0, 0.7);
			box-shadow: 0 0 3px rgba(0, 0, 0, 0.7);
		}
		.headfont{
			font-family: inherit;
			font-weight: bold;
			color: inherit;
			text-rendering: optimizelegibility;
			margin-top:5px;
			margin-left:120px;

			float:left;
		}
	</style>
</head>

<body>
<div id="headdiv" class="page-header" contenteditable="true">
	<h2 class="headfont" style="margin-right:300px;">WelcomeTo后台管理!</h2><h4 class="headfont" style="margin-top:20px"><div id="disptime" style="float:left"></div>&nbsp;&nbsp; <font color="4F87D4">${sessionScope.name}</font>,欢迎您!</h4>
</div>
</body>
<script type="text/javascript">
	clock();
	function clock(){
    	var mydate=new Date();  
    	document.getElementById("disptime").innerHTML=mydate.getFullYear()+"年"+(mydate.getMonth()+1)+"月"+mydate.getDate()+"日"+" "+mydate.getHours()+":"+mydate.getMinutes()+":"+mydate.getSeconds();
    	setTimeout("clock()",1000);
   	}
</script>
</html>
