<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<title>Main</title>
</head>
<frameset rows="60,*" frameborder="0" name="up"
	noresize="noresize">
	<frame src="${pageContext.request.contextPath}/UpHead.jsp"
		scrolling="no"></frame>
	<frame src="${pageContext.request.contextPath}/PreNews.do"
		name="down" scrolling="yes"></frame>
</frameset>
</html>