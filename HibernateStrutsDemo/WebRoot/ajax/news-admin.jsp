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

		<title>My JSP 'news-admin.jsp' starting page</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<!--js框架--引入jquery，因为bootstrap使用了jquery，所以要在它前面引入-->
		<script src="<%=basePath%>resource/jquery/jquery1.11.3.min.js"></script>
		<!--css框架--引入bootstrap-->
		<script src="<%=basePath%>resource/bootstrap/js/bootstrap.min.js"></script>
		<link href="<%=basePath%>resource/bootstrap/css/bootstrap.css"
			rel="stylesheet">

		<!-- 引入自己的js/css -->
		<script src="<%=basePath%>ajax/js/news-admin.js"></script>
		<script src="<%=basePath%>ajax/js/msgTips.js"></script>
		
		
		 <style>
       input[type="text"],textarea{
       width:80%;
       }
       </style>
	</head>

	<body>
		<div class="container">
			<h2 class="page-header">
				东航新闻管理
			</h2>
			<div class="row">

				<form id="searchform">
					<div class="col-md-4">
						<label class="control-label" for="input01">
							标题
						</label>
						<input name="entity.title" type="text" placeholder="placeholder"
							class="input-xlarge">
					</div>
					<div class="col-md-4">
						<label class="control-label" for="input01">
							发布日期
						</label>
						<input type="text" placeholder="placeholder" class="input-xlarge"
							name="entity.pubdate">
					</div>
					<div class="col-md-4">
						<input type="button" value="搜索" class="btn btn-danger" id="ssbtn"/>
					</div>
				</form>
			</div>
			<br />

			<p class="text-right">
				<a  class="btn btn-danger" data-target="#myModal" data-toggle="modal">添加</a>
				<a href="<%=basePath%>ajax/news-list.jsp" class="btn btn-danger">返回</a>
			</p>
           
			<table
				class="table table-bordered table-hover table-condensed text-center"
				id="xwmain">
				<thead>
				<tr>
					<td width="20%">
						标题
					</td>
					<td width="10%">
						发布日期
					</td>
					<td width="55%">
						内容
					</td>
					<td>
						管理
					</td>
				</tr>
               </thead>
               <tbody>
               
               </tbody>
			</table>


		</div>
		
 


<!--遮层弹出框测试 -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog modal-lg" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">新闻添加/修改</h4>
      </div>
      <div class="modal-body">      
      
        <p class="bg-primary text-center" style="display:none" id="bcinfo">保存成功！</p>
        
        <form class="form-horizontal" id="saveform">
				 
				 <input type="hidden" value="${entity.id}" name="entity.id"/>
				 
					<div class="control-group">

						<!-- Text input-->
						<label class="control-label" for="input01">
							 标题
						</label>
						<div class="controls">
							<input type="text" placeholder="请输入标题" class="input-xlarge" name="entity.title" value="${entity.title}">
							 
						</div>
					</div>

					<div class="control-group">

						<!-- Text input-->
						<label class="control-label" for="input01">
							发布时间
						</label>
						<div class="controls">
							<input type="text" placeholder="清输入时间" class="input-xlarge" name="entity.pubdate" value="${entity.pubdate}">
							 
						</div>
					</div>

					<div class="control-group">

						<!-- Textarea -->
						<label class="control-label">
							内容
						</label>
						<div class="controls">
							<div class="textarea">
								<textarea  class="" rows="10" name="entity.content">${entity.content} </textarea>
							</div>
						</div>
					</div>
				 
			</form>
        
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-danger" id="bcbtn">保存</button>
        <button type="button" class="btn btn-danger" data-dismiss="modal">关闭</button>
       
      </div>
    </div>
  </div>
</div>
   
	</body>
</html>
