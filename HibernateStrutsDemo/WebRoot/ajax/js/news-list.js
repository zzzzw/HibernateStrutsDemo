//文档加载完毕执行
$(function() {
	
    //在js中获取web路径
	var location = (window.location+'').split('/'); 
	var basePath = location[0]+'//'+location[2]+'/'+location[3]+'/'; 

	// 加载新闻
	$.ajax( {
		type : 'POST',
		dataType : 'json', // json对象
		url : 'news-ajax!showAll.action',
		data : null,
		success : function(response, status, xhr) {
			var s = "";
			$.each(response, function(index, value) {
				// 组合
					s += '<tr><td class="text-left">';
					s += '<a href="'+basePath+'ajax/news-show.jsp?entity.id='
							+ value.id + '">' + value.title;
					s += '</a></td><td class="text-right">' + value.pubdate
							.substring(0, 10);
					s += '</td></tr>';
				})
			$("#xwmain").append(s);

		},
		error : function() {
			alert("加载失败");
		}

	})

})