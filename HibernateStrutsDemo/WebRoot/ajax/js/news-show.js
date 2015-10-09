//文档加载完毕执行
$(function() {
		 
    //在js中获取web路径 http://www.2cto.com/kf/201307/227003.html
	var location = (window.location+'').split('/'); 
	var basePath = location[0]+'//'+location[2]+'/'+location[3]+'/'; 
    
	// 加载新闻
	$.ajax( {
		type : 'POST',
		dataType : 'json', // json对象
		url : 'news-ajax!showContent.action',
		data : {
		'entity.id':GetQueryString("entity.id")   //传参
	        },
		success : function(response, status, xhr) {
			var s = "";
			 alert(response.title);
			$("#xwmain").append(s);

		},
		error : function() {
			alert("加载失败");
		}

	})

})

//采用正则表达式获取地址栏参数
//http://www.cnblogs.com/fishtreeyu/archive/2011/02/27/1966178.html
function GetQueryString(name)
{
     var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)");
     var r = window.location.search.substr(1).match(reg);
     if(r!=null)return  unescape(r[2]); return null;
}