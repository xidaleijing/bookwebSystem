$(document).ready((function() {
	initContentHeight();		
		//这里设置img的宽度
		var maxImgWidth=$("#content-con").width()-20;
		$("#content-con img").each(function(){
			var thisWidth=$(this).width();
			if(thisWidth>maxImgWidth){
				$(this).width(maxImgWidth);
			}
		});
	}));
	function initContentHeight(){
		var height = $(window).height();
		var navHeight = $("#nav").height();
		var headerHeight = $("#header").height();
		var footerHeight = $("#footer").height();
		var contentHeight = height - navHeight - headerHeight - footerHeight;
		var contentConHeight = $("#content-con").height();
		if (contentHeight > contentConHeight) {
			$("#content-con").height(contentHeight);
			$("#content").height(contentHeight);
		} else {
		$("#content-con").height(contentConHeight);
			$("#content").height(contentConHeight);
		}
	}