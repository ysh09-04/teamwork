$(function() {
	// datagrid
	$('#dg').datagrid({
		url : 'videoCategory/datagrid',
		title : '菜单管理',
		// width : '100%',
		fitColumns : true,
		loadMsg : '数据加载中,请稍后...',
		rownumbers : true,
		singleSelect : true,
		checkOnSelect : true,
		columns : [ [ {
			field : 'videoCategoryId',
			title : '编号',
			checkbox : true
		}, {
			field : 'videoCategoryName',
			title : '视频类名',
			width : 100
		}, {
			field : 'videoCategoryDescribe',
			title : '描述',
			width : 100
		}, {
			field : 'course.courseName',
			title : '课程名',
			width : 100,
		} 
		 ] ],
		pagination : true,
		pageSize : 20,
		pageList : [ 10, 20, 35, 50 ],
		toolbar : '#tb'
	});
		$.ajax({
			type:'post',
			url:'course/linkbutton',
			dataType : "json", 
			success:function(result){
				$('#courseId').combobox({
				      data : result,
				      valueField:'courseId',
				      textField:'courseName'
				     });
			},
		});
});