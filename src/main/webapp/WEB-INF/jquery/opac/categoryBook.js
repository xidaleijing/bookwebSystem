
$(document).ready((function () {
	//frame 中页面 div的高度
	var divHeight = $("#bookContent").height();
	//外面内容的高度	
	var h1 = window.parent.$("#content-con").height();
	//整个页面的高度
	var height = $(window.parent.parent).height();
	var navHeight = window.parent.$("#nav").height();
	var headerHeight = window.parent.$("#header").height();
	var footerHeight = window.parent.$("#footer").height();
	var contentHeight = height - navHeight - headerHeight - footerHeight;
	if (divHeight < contentHeight) {
		window.parent.$("#clcRightFrm").height(contentHeight);
		window.parent.$("#content-con").height(contentHeight);
		window.parent.$("#content").height(contentHeight);
		window.parent.$("#clc_left").height(contentHeight-40);
	} else {
		if (h1 > divHeight) {
			window.parent.$("#clcRightFrm").height(h1);
			window.parent.$("#content-con").height(h1);
			window.parent.$("#content").height(h1);
			window.parent.$("#clc_left").height(h1-40);
		} else {
			window.parent.$("#clcRightFrm").height(divHeight);
			window.parent.$("#content-con").height(divHeight+35);
			window.parent.$("#content").height(divHeight+35);
			window.parent.$("#clc_left").height(divHeight-5);
		}
	}
}));

