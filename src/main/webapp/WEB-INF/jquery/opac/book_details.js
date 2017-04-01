
$(document).ready((function () {
	$("#tabs").tabs({activate:function (event, ui) {
		resetHeight(ui.newPanel.height() + ui.newTab.height());
	}, create:function (event, ui) {
		resetHeight(ui.panel.height() + ui.tab.height());
	}});
}));
function resetHeight(height) {
	//窗体的高度
	height=height+72;
	var winHeight = $(window).height();
		//最顶层导航的高度
	var navHeight = $("#nav").height();
		//图片高度
	var headerHeight = $("#header").height();
		//最顶层高度
	var footerHeight = $("#footer").height();
	var contentHeight = winHeight - navHeight - headerHeight - footerHeight;
	if (contentHeight > height) {
		$("#content-con").height(contentHeight);
		$("#content").height(contentHeight);
	} else {
		$("#content-con").height(height);
		$("#content").height(height);
	}
}

