//文档加载完毕执行
$(function() {

	// 在js中获取web路径
	var location = (window.location + '').split('/');
	var basePath = location[0] + '//' + location[2] + '/' + location[3] + '/';

	// 加载新闻
	jzxw();
	
	//保存触发   http://www.5icool.org/a/201204/576.html 
	$("#bcbtn").click(function(){
		tjxw();
	})
	
	//关闭触发  http://www.hello-code.com/blog/Bootstrap/201507/5233.html
	$('#myModal').on('hide.bs.modal', function () {      
		   //清空saveform http://www.jb51.net/article/54144.htm
		  //$('#saveform')[0].reset();
		 $("#saveform :input").not(":button, :submit, :reset").val("").removeAttr("checked").remove("selected");//核心 
		 
		 //隐藏提示
		 $("#bcinfo").hide();
		
		 //刷新table
		 jzxw();
	  })
	  
	
	 $("#ssbtn").click(function(){
		 ssxw();
	 }) 
	
})


function jzxw(){	
	$.ajax( {
		type : 'POST',
		dataType : 'json', // json对象
		url : 'news-ajax!showAll.action',
		data : null,
		success : function(response, status, xhr) {
			var s = "";
			$.each(response,function(index, value) {
								// 组合
								s += '<tr><td>' + value.title;
								s += '</td><td>' + value.pubdate
										+ '</td><td>' + value.content
										+ '</td><td>';
								s += '<a class="btn btn-danger" data-target="#myModal" data-toggle="modal" onclick="xgxw('+value.id+') ">修改</a>&nbsp;&nbsp;';
								s += '<a class="btn btn-danger" onclick="scxw('+value.id+')">删除</a>';
								s += '</td></tr>';
							})
		    //$(s).insertAfter("#xwmain tr");
			//$("#xwmain tr").first().after().empty;				
			//$("#xwmain tr").first().after(s);
			$("#xwmain tbody").html(s); 
		},
		error : function() {
			alert("加载失败");
		}

	})

}

//搜索新闻
function ssxw(){	
	$.ajax( {
		type : 'POST',
		dataType : 'json', // json对象
		url : 'news-ajax!searchNews.action',
		data:$("#searchform").serialize(), 
		success : function(response, status, xhr) {
			var s = "";
			$.each(response,function(index, value) {
								// 组合
								s += '<tr><td>' + value.title;
								s += '</td><td>' + value.pubdate
										+ '</td><td>' + value.content
										+ '</td><td>';
								s += '<a class="btn btn-danger" data-target="#myModal" data-toggle="modal" onclick="xgxw('+value.id+') ">修改</a>&nbsp;&nbsp;';
								s += '<a class="btn btn-danger" onclick="scxw('+value.id+')">删除</a>';
								s += '</td></tr>';
							})
		    //$(s).insertAfter("#xwmain tr");
			//$("#xwmain tr").first().after().empty;				
			//$("#xwmain tr").first().after(s);
			$("#xwmain tbody").html(s); 
		},
		error : function() {
			alert("加载失败");
		}

	})

}


//添加/保存新闻
function tjxw(){	
	$.ajax( {
		type : 'POST',
		dataType : 'json', // json对象
		url : 'news-ajax!saveNews.action',
//		data : {
//		 'entity.title':$("#saveform input[name='entity.title']").val(),
//		 'entity.pubdate':$("#saveform input[name='entity.pubdate']").val(),
//		 'entity.content':$("#saveform textarea[name='entity.content']").val()
//	     },
		data:$("#saveform").serialize(),     //多个字段时，推荐
		success : function(response, status, xhr) {		
			$("#bcinfo").show();
		},
		error : function() {
			alert("加载失败");
		}

	})
}

//删除新闻
function scxw(id){	
	$.ajax( {
		type : 'POST',
		dataType : 'json', // json对象
		url : 'news-ajax!deleteNews.action',
		data : {
		 'entity.id':id
	     },
		success : function(response, status, xhr) {		
	    	//考虑用提示框
	    	alert("删除成功！");
			jzxw();
		},
		error : function() {
			alert("加载失败");
		}

	})
}

//修改新闻
function xgxw(id){	
	$.ajax( {
		type : 'POST',
		dataType : 'json', // json对象
		url : 'news-ajax!getNews.action',
		data : {
		 'entity.id':id
	     },
		success : function(response, status, xhr) {		
	    	 $("#saveform input[name='entity.id']").val(response.id);
	    	 $("#saveform input[name='entity.title']").val(response.title);
	    	 $("#saveform input[name='entity.pubdate']").val(response.pubdate);
	    	 $("#saveform textarea[name='entity.content']").val(response.content);
	    	 
	    	 	    	 
		},
		error : function() {
			alert("加载失败");
		}

	})
}


