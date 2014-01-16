<%@page import="cn.itjava.domain.GCate"%>
<%@page import="java.util.List"%>
<%@page import="cn.itjava.util.PageModel"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<html>
<head>
<title>添加新闻</title>
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
		<h2>商品管理</h2>
		<div class="smallcontain" style="border: 1px solid #ccc">

			<form class="form-search"  style="margin-top: 30px">
				<input class="input-medium search-query"
					style="width: 200px; height: 30px" value="${str}" type="text" name="str" id="str" />
				<input type="button" class="btn" onclick="submitSearch()" value="查找"/>
				<input type="button" style="margin-left: 250px" class="btn"
					value="添加商品" onclick="add()" /> <input type="button"
					style="margin-left: 20px" class="btn" value="批量删除" onclick="delPage()">
			</form>

			<table class="table" contenteditable="true">
				<thead>
					<tr style="background-color:#f5f5f5;">
						<th><input type="checkbox" id="allChecked" name="allChecked"
							style="width: 20px; height: 20px" onclick="selectAll()">&nbsp;&nbsp;&nbsp;&nbsp;全选</th>
						<th>名称</th>
						<th>类别</th>
						<th>修改</th>
						<th>删除</th>
						<th>查看</th>

					</tr>
				</thead>
				<tbody>
					<c:forEach var="goods" items="${requestScope.pageModel.list}" >
						<tr>
							<td><input type="checkbox" name="singleChecked"
								style="width: 20px; height: 20px" value="${goods.id}" ></td>
							<td>${goods.name}</td>
							<td>${goods.gcate.name}</td>
							<td><a href="#" onclick="mod(${goods.id})">修改</a></td>
							<td><a href="#" onclick="del(${goods.id})">删除</a></td>
							<td><a href="#" onclick="see(${goods.id})">查看</a></td>
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
		var delAns = "${requestScope.delAns}";
		if (delAns=="success"){
			alert("删除成功");
		}else if(delAns=="error"){
			alert("删除失败");
		}
		
		var delPageAns = "${requestScope.delPageAns}";
		if (delPageAns=="success"){
			alert("删除成功");
		}else if(delPageAns=="error"){
			alert("删除失败");
		}

		var updAns = "${requestScope.updAns}";
		if (updAns=="success"){
			alert("修改成功");
		}else if(updAns=="error"){
			alert("修改失败");
		}
		
		function topPage(){
			var str = document.getElementById("str").value;
			window.location="${pageContext.request.contextPath}/goods.do?method=seePage&pageNo=${requestScope.pageModel.getTopPageNo()}"+"&str="+str;
	 	}
		function previousPage(){
			var str = document.getElementById("str").value;
	    	window.location="${pageContext.request.contextPath}/goods.do?method=seePage&pageNo=${requestScope.pageModel.getPreviousPageNo()}"+"&str="+str;
    	}
    	function nextPage(){
    		var str = document.getElementById("str").value;
	    	window.location="${pageContext.request.contextPath}/goods.do?method=seePage&pageNo=${requestScope.pageModel.getNextPageNo()}"+"&str="+str;
    	}
    	function bottomPage(){
    		var str = document.getElementById("str").value;
	    	window.location="${pageContext.request.contextPath}/goods.do?method=seePage&pageNo=${requestScope.pageModel.getBottomPageNo()}"+"&str="+str;
		}
    
    	function submitSearch(){
    		var str = document.getElementById("str").value;
    		window.location = "${pageContext.request.contextPath}/goods.do?method=seePage&str="+str;
    	}
    	
    	function selectAll(){
     		var allChecked = document.getElementById("allChecked");
     		var singleChecked = document.getElementsByName("singleChecked");
     		if(allChecked.checked){
     			for(var i=0;i<singleChecked.length;i++){
     				singleChecked[i].checked = true;
     			}
     		}else{
     			for(var i=0;i<singleChecked.length;i++){
     				singleChecked[i].checked = false;
     			}
     		}
     	}
	    function delPage(){
    	 	var singleChecked = document.getElementsByName("singleChecked");
     		var count = 0;
     		var ids = "";
     		for(var i=0; i<singleChecked.length; i++){
     			if(singleChecked[i].checked){
     				count++;
     				ids += singleChecked[i].value+",";
     			}
     		}
     		if(count == 0){
     	  		alert("请选择一项进行删除！");
     	  		return;
     		}
     		ids=ids.substr(0,(ids.length - 1));
     		if(window.confirm("确认要删除吗？")){
     		  	window.location = "${pageContext.request.contextPath}/goods.do?method=delPage&ids="+ids;
     		}
     	}
	    function mod(id){
	    	if(confirm('确认要修改吗')){
	    		window.location = "${pageContext.request.contextPath}/goods.do?method=see&id="+id;
	    	}
	    }
	    function del(id){
	    	if(confirm('确认要删除吗')){
	    		window.location = "${pageContext.request.contextPath}/goods.do?method=del&id="+id;
	    	}
	    }
	    function add(){
	    	window.location="${pageContext.request.contextPath}/gcate.do?method=dispGCate";
	    }
	    function see(id){
	    	window.location = "${pageContext.request.contextPath}/goods.do?method=see&id="+id+"&flag=on";
	    }
	    
	</script>
</body>
</html>