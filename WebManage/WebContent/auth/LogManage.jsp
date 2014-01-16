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
 <script src="js/jquery.js"></script>
 <script src="js/bootstrap-datepicker.js"></script>
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
			<table style="width:400px; margin-left:300px;float:left;" >
					<thead>
						<tr style="background-color: white">
							<th>Start date<a href="#" class="btn small" id="dp4" data-date-format="yyyy-mm-dd" data-date="2014-01-01">Change</a></th>
							<th>End date<a href="#" class="btn small" id="dp5" data-date-format="yyyy-mm-dd" data-date="2014-01-02">Change</a></th>
						</tr>
					</thead>
					<tbody>
						<tr style="background-color: white">
							<td  id="startDate">2014-01-01</td>
							<td  id="endDate">2014-01-02</td>
						</tr>
					</tbody>
			</table>
			<input class="btn" style="width:50px; height:50px;margin-bottom:7px;margin-right:100px" type="button" value="查询" onclick="queDate()" />
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
					<c:forEach var="log" items="${requestScope.pageModel.list}" >
						<tr style="height:40px">
							<td>${log.name}</td>
							<td>${log.opera}</td>
							<td><fmt:formatDate value="${log.time}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<div class="page">
				<a href="#" onclick="topPage()">首页</a><a href="#" onclick="previousPage()">上一页</a><a
					href="#" onclick="nextPage()">下一页</a><a href="#" onclick="bottomPage()">尾页</a>
			</div>
		</div>
	</div>
	<script type="text/javascript">
		
		function topPage(){
			window.location="${pageContext.request.contextPath}/log.do?pageNo=${requestScope.pageModel.getTopPageNo()}";
	 	}
		function previousPage(){
	    	window.location="${pageContext.request.contextPath}/log.do?pageNo=${requestScope.pageModel.getPreviousPageNo()}";
    	}
    	function nextPage(){
	    	window.location="${pageContext.request.contextPath}/log.do?pageNo=${requestScope.pageModel.getNextPageNo()}";
    	}
    	function bottomPage(){
	    	window.location="${pageContext.request.contextPath}/log.do?pageNo=${requestScope.pageModel.getBottomPageNo()}";
		}
    	function queDate(){
    		var startDate = document.getElementById("startDate").innerText;
    		var endDate = document.getElementById("endDate").innerText;
	    	window.location="${pageContext.request.contextPath}/log.do?queBy=date"+"&startDate="+startDate+"&endDate="+endDate;
    	}
	</script>
	<script type="text/javascript">
		$(function(){
			window.prettyPrint && prettyPrint();
			$('#dp1').datepicker({
				format: 'mm-dd-yyyy'
			});
			$('#dp2').datepicker();
			$('#dp3').datepicker();
			$('#dp3').datepicker();
			$('#dpYears').datepicker();
			$('#dpMonths').datepicker();
			
			
			var startDate = new Date(2012,1,20);
			var endDate = new Date(2012,1,25);
			$('#dp4').datepicker()
				.on('changeDate', function(ev){
					if (ev.date.valueOf() > endDate.valueOf()){
						$('#alert').show().find('strong').text('The start date can not be greater then the end date');
					} else {
						$('#alert').hide();
						startDate = new Date(ev.date);
						$('#startDate').text($('#dp4').data('date'));
					}
					$('#dp4').datepicker('hide');
				});
			$('#dp5').datepicker()
				.on('changeDate', function(ev){
					if (ev.date.valueOf() < startDate.valueOf()){
						$('#alert').show().find('strong').text('The end date can not be less then the start date');
					} else {
						$('#alert').hide();
						endDate = new Date(ev.date);
						$('#endDate').text($('#dp5').data('date'));
					}
					$('#dp5').datepicker('hide');
				});

        // disabling dates
        var nowTemp = new Date();
        var now = new Date(nowTemp.getFullYear(), nowTemp.getMonth(), nowTemp.getDate(), 0, 0, 0, 0);

        var checkin = $('#dpd1').datepicker({
          onRender: function(date) {
            return date.valueOf() < now.valueOf() ? 'disabled' : '';
          }
        }).on('changeDate', function(ev) {
          if (ev.date.valueOf() > checkout.date.valueOf()) {
            var newDate = new Date(ev.date)
            newDate.setDate(newDate.getDate() + 1);
            checkout.setValue(newDate);
          }
          checkin.hide();
          $('#dpd2')[0].focus();
        }).data('datepicker');
        var checkout = $('#dpd2').datepicker({
          onRender: function(date) {
            return date.valueOf() <= checkin.date.valueOf() ? 'disabled' : '';
          }
        }).on('changeDate', function(ev) {
          checkout.hide();
        }).data('datepicker');
		});
	</script>
</body>
</html>