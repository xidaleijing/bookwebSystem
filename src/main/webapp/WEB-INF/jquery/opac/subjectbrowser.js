var isFirst=true;
$(document).ready((function () {
	function zTreeOnClick(event, treeId, treeNode) {
		var subject=treeNode.name;
		$("#clcRightFrm").attr("src","opac/subjectSearch.action?subject="+subject);
	};
	var setting={
		view:{
			showIcon:false
		},
		async:{
			enable:true,
			url:"opac/subjectTree.action"
		},
		callback:{
			onClick:zTreeOnClick
		}
	};
	
	$.fn.zTree.init($("#clcTree"),setting);
}));

