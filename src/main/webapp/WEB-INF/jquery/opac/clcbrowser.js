
$(document).ready((function () {
	function zTreeOnClick(event, treeId, treeNode) {
		var clc=treeNode.name;
		var index=clc.indexOf(" ");
		clc=clc.substring(0,index);
		$("#clcRightFrm").attr("src","opac/clcSearch.action?clc="+clc);
	};
	var setting={
		view:{
			showIcon:false
		},
		async:{
			enable:true,
			url:"opac/clcTree.action",
			autoParam:["id=parentId"]
		},
		callback:{
			onClick:zTreeOnClick
		}
	};
	
	$.fn.zTree.init($("#clcTree"),setting);
}));

