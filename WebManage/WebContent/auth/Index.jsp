<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
	<head>
		<title>Main</title>
	</head>
	<frameset rows="60,*" frameborder="0" name="headframe" noresize="noresize">
		<frame src="${pageContext.request.contextPath}/auth/Head.jsp" scrolling="no"></frame>
		<frameset cols="280,*" frameborder="0" >
			<frame src="${pageContext.request.contextPath}/auth/Menu.jsp" name="leftframe" scrolling="no"></frame>
			<frame src="${pageContext.request.contextPath}/auth/Welcome.jsp" name="rightframe" scrolling="yes"></frame>
		</frameset>
	</frameset>
</html>