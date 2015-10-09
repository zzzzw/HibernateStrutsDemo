<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!--引入struts标签 -->
<%@ taglib prefix="s" uri="/struts-tags"%>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title>新闻Demo</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">

		<!--js框架--引入jquery，因为bootstrap使用了jquery，所以要在它前面引入-->
		<script src="<%=basePath%>/resource/jquery/jquery1.11.3.min.js"></script>
		<!--css框架--引入bootstrap-->
		<script src="<%=basePath%>/resource/bootstrap/js/bootstrap.min.js"></script>
		<link href="<%=basePath%>/resource/bootstrap/css/bootstrap.css" rel="stylesheet">

		<!-- 引入自己的js/css -->
        <script src="<%=basePath%>/ajax/js/news-list.js"></script>
 
		<style>
.table>tbody>tr>td {
	border-top: none
}
</style>


	</head>

	<body>

		<div class="container">
			<div class="col-md-12">

				<h2 class="page-header">
					东航新闻
				</h2>
				<table class="table table-hover" id="xwmain">
				  <!-- 填充数据 --> 

				</table>
				<div class="text-right">
					<a class="btn btn-danger " href="<%=basePath%>ajax/news-admin.jsp" />管理</a>
				</div>
			</div>


		</div>

	</body>
</html>
