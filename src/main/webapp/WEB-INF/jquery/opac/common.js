
$(document).ready((function () {
	$(".submit").click(function () {
		var searchValue = $("#searchValue").val();
		searchValue = searchValue.replace(/(^\s*)|(\s*$)/g, "");
		if (searchValue == "") {
			alert("[\u67e5\u8be2\u5185\u5bb9] \u4e0d\u80fd\u4e3a\u7a7a");
			return false;
		}
		return true;
	});
	$(".multiReset").click(function () {
		$("form")[0].reset();
		return false;
	});
	$(".multiSubmit").click(function () {
		var hasValue = false;
		$.each($(":text"), function () {
			var searchValue = $(this).val();
			searchValue = searchValue.replace(/(^\s*)|(\s*$)/g, "");
			if (searchValue != "") {
				hasValue = true;				
			}
		});
		if (hasValue == false) {
			alert("请输入检索值");
			return false;
		}
		return true;
	});
	$("#btnSearchNew").click(function () {
		$("#searchNew").val(true);
		return true;
	});
	$(".expand").click(function () {
		$(this).parent().parent().children("dd[class='hidea']").removeClass("hidea");
		$(this).parent().remove();
		initContentHeight();
	});
}));

