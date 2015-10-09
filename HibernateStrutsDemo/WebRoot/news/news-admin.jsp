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
		<script src="<%=basePath%>/resource/jquery/jquery1.11.3.min.js"></script>
		<!--css框架--引入bootstrap-->
		<script src="<%=basePath%>/resource/bootstrap/js/bootstrap.min.js"></script>
		<link href="<%=basePath%>/resource/bootstrap/css/bootstrap.css"
			rel="stylesheet">

		<!-- 引入自己的js/css -->
		<style>
/*标签选择器*/
input[type="text"] {
	width: 60%;
}
</style>
  </head>
  
  <body>
     <div class="container">
         <h2 class="page-header">东航新闻管理</h2>
         <div class="row">
            
           <form action="news!searchNews.action" method="post">
           <div class="col-md-4">
             <label class="control-label" for="input01">标题</label>
              <input name="entity.title" type="text" placeholder="placeholder" class="input-xlarge">
           </div> 
           <div class="col-md-4">
             <label class="control-label" for="input01">发布日期</label>
              <input type="text" placeholder="placeholder" class="input-xlarge" name="entity.pubdate" >
           </div> 
           <div class="col-md-4">
           <input type="submit" value="搜索" class="btn btn-danger"/>
           </div>            
            </form> 
         </div>
         <br/>
         
         <p class="text-right">
         <a href="news/news-admin-input.jsp" class="btn btn-danger">添加</a>
         <a href="news!showAll.action" class="btn btn-danger">返回</a>
         </p>
         
         <table class="table table-bordered table-hover table-condensed text-center">
         <tr>
         <td width="20%">
       		  标题
         </td>
     	  <td  width="10%">
      		   发布日期
         </td>
         <td width="55%">
     		   内容
         </td>
     	  <td>
       		  管理
         </td>
         </tr>
         
         <s:iterator value="xwlist" var="u">
        <tr>
         <td>
   ${u.title}
         </td>
       <td>
   ${u.pubdate}
         </td>
         <td>
       ${u.content}
         </td>
       <td>
        <a class="btn btn-danger" href="news!getNews.action?entity.id=${u.id}">修改</a>
         <a class="btn btn-danger" href="news!deleteNews.action?entity.id=${u.id}">删除</a>
         </td>
         </tr>
           
         </s:iterator>
  
         </table>
         
         
     </div>
  </body>
</html>
