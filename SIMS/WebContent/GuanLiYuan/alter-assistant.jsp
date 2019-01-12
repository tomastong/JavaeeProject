<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <title>管理员系统</title>
    <meta name="description" content="实训,管理">
    <meta name="keywords" content="实训,管理">
    <link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/menu.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/content.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/all-table.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/improve.css" rel="stylesheet">
    <script src="${pageContext.request.contextPath}/js/test.js"></script>
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
                        <li><a href="${pageContext.request.contextPath}/GuanLiYuan/adminAction_ownProfile">个人资料</a>
                        </li>
                        <li><a href="${pageContext.request.contextPath}/GuanLiYuan/alterpassword.jsp">修改密码</a>
                        </li>
                    </ul>
                    <h2>用户管理</h2>
                    <ul class="menu-left-nav">
                        <li><a href="${pageContext.request.contextPath}/GuanLiYuan/adminAction_listStudent?pageModel.pageNo=1">学生管理</a>
                        </li>
                        <li><a href="${pageContext.request.contextPath}/GuanLiYuan/adminAction_listTeacher">教师管理</a>
                        </li>
                        <li><a href="${pageContext.request.contextPath}/GuanLiYuan/adminAction_listAssistant">导员管理</a>
                        </li>
                    </ul>
                    <h2>平台管理</h2>
                    <ul class="menu-left-nav">
                        <li><a href="${pageContext.request.contextPath}/GuanLiYuan/adminAction_shixunPlatform">实训平台</a>
                        </li>
                        <li><a href="${pageContext.request.contextPath}/GuanLiYuan/adminAction_shixiPlatform">实习平台</a>
                        </li>
                        <li><a href="${pageContext.request.contextPath}/GuanLiYuan/adminAction_searchAllGrade">新新一届</a></li>
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
                    <h2>辅导员信息修改<span><a href="${pageContext.request.contextPath}/GuanLiYuan/adminAction_listAssistant">返回</a></span></h2>
                    <form action="${pageContext.request.contextPath}/GuanLiYuan/adminAction_modAssistant?id=${assistant.id}" method="post" enctype="multipart/form-data">
                        <table class="easy-table content-layout table-block">
                            <tr>
                                <td>姓名：</td>
                                <td>
                                    <input type="text" name="assistant.name" value="${assistant.name }">
                                </td>
                            </tr>
                            <tr>
                                <td>性别：</td>
                                <td>
                                    <input type="radio" name="assistant.sex" value="男" <s:property value='assistant.sex=="男"? "checked":""'/>>男&nbsp;
                                    <input type="radio" name="assistant.sex" value="女" <s:property value='assistant.sex=="女"? "checked":""'/>>女</td>
                            </tr>
                            <tr>
                                <td>联系方式：</td>
                                <td>
                                    <input type="text" name="assistant.tel" value="${assistant.tel }">
                                </td>
                            </tr>
                            <tr>
                                <td>负责年级：</td>
                                <td>
                                   <input type="text" name="gradeName" value="${assistant.grade.name }">
                                </td>
                            </tr>
                            <tr>
                                <td>工号：</td>
                                <td>
                                    <input type="text" name="assistant.jobNum" value="${assistant.jobNum }">
                                </td>
                            </tr>
                            <tr>
                                <td>家庭住址：</td>
                                <td>
                                    <input type="text" name="assistant.address" value="${assistant.address }">
                                </td>
                            </tr>
                            <tr>
                                <td>上传头像：</td>
                                <td>
                                    <input type="file" class="minish" name="upload" onchange="previewFile()">
                                </td>
                            </tr>
                        </table>
                        <div class="preview-box">
                            <img src="${pageContext.request.contextPath}/${assistant.imgSrc }" alt="Drag Image here..." id="head-img">
                        </div>
                        <div class="clear-float"></div>
                        <div class="button-box">
                            <button type="submit">提交</button>
                            <button type="submit">重置</button>
                        </div>
                    </form>
                </article>
            </section>
            <div class="clear-float"></div>
        </div>
    </div>
    <script>
    var preview = document.getElementById('head-img');
    preview.addEventListener('dragover', handleDragOver, false);
    preview.addEventListener('drop', handleFileSelect, false);

    window.onload = adjust();
    </script>
</body>

</html>
