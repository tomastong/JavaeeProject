<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <title>实训</title>
    <meta name="description" content="实训">
    <meta name="keywords" content="实训">
    <link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/menu.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/content.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/all-table.css" rel="stylesheet">
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
                        <li><a href="${pageContext.request.contextPath}/FuDaoYuan/assistantAction_ownProfile">个人资料</a></li>
                        <li><a href="${pageContext.request.contextPath}/FuDaoYuan/alterpassword.jsp">修改密码</a></li>
                    </ul>
                    <h2>学生管理</h2>
                    <ul class="menu-left-nav">
                        <li><a href="${pageContext.request.contextPath}/FuDaoYuan/assistantAction_listShiXunStudent?pageModel.pageNo=1">实训管理</a></li>
                        <li><a href="${pageContext.request.contextPath}/FuDaoYuan/internship-manage.jsp">实习管理</a></li>
                        <li><a href="${pageContext.request.contextPath}/FuDaoYuan/assistantAction_listZj?pageModel.pageNo=1">周记管理</a></li>
                    </ul>
                    <h2>实用栏位</h2>
                    <ul class="menu-left-nav">
                        <li><a href="${pageContext.request.contextPath}/FuDaoYuan/assistantAction_listInform">校内通知</a>
                        </li>
                        <li><a href="${pageContext.request.contextPath}/FuDaoYuan/school-enterprise.jsp">校企交流</a>
                        </li>
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
                    <h2>实训修改<span>${student.sno } ${student.name }&nbsp;&nbsp;&nbsp;&nbsp;<a href="${pageContext.request.contextPath}/FuDaoYuan/assistantAction_listShiXunStudent?pageModel.pageNo=1">返回</a></span></h2>
                    <table class="easy-table">
                        <tr>
                            <th>方向</th>
                            <th>班级</th>
                            <th>上限</th>
                            <th>操作</th>
                        </tr>
                        <c:forEach items="${student.grade.directions }" var="direction">
                        <tr>
                            <td>${direction.name }</td>
                            <td>
                                <select name="" id="select${direction.id }" onchange="showNop('nop${direction.id }', 'select${direction.id }')">
                                    <option value="--">-选择班级-</option>
	                                <c:forEach items="${direction.classes}" var="classes">
	                                    <option value="${classes.id }-${classes.maxNum}">${classes.name}</option>
	                                </c:forEach>
                                </select>
                            </td>
                            <td id="nop${direction.id }">--
                            </td>
                            <td>
                                <button onclick="choose('select${direction.id }')">选择</button>
                            </td>
                        </tr>
                        </c:forEach>
                    </table>
                </article>
            </section>
            <div class="clear-float"></div>
        </div>
    </div>
    <script>
    	var prompt = "${prompt}";
		if(prompt==null || prompt==""){
		}else{
			alert(prompt);
			window.location.href="assistantAction_listShiXunStudent?pageModel.pageNo=1";
		}

	    function showNop(id, selectid){
    		var select = document.getElementById(selectid);
    		var nop = document.getElementById(id);
    		var index = select.selectedIndex;
    		var value = select.options[index].value;
    		if("--" != value){
    			arr = value.split("-");
    			nop.innerHTML = arr[1];
    		}else{
    			nop.innerHTML = value;
    		}
    	}
    	
    	function choose(selectid){
    		var select = document.getElementById(selectid);
    		var index = select.selectedIndex;
    		var value = select.options[index].value;
    		if("--" != value){
    			arr = value.split("-");
    			window.location.href="${pageContext.request.contextPath}/FuDaoYuan/assistantAction_modShiXun?studentid=${student.id}&id="+arr[0];;
    		}else{
    			alert("请选择班级！");
    		}
    	}
    </script>
</body>

</html>
