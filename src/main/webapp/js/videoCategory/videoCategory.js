$(function() {
	// datagrid
	$('#dg').datagrid({
		url : 'videoCategory/datagrid',
		title : '菜单管理',
		width : '100%',
		loadMsg : '数据加载中,请稍后...',
		rownumbers : true,
		singleSelect : true,
		checkOnSelect : true,
		columns : [ [ {
			field : 'videoCategoryId',
			title : '编号',
			width : 150,
			align: 'center'
		}, {
			field : 'videoCategoryName',
			title : '视频类名',
			width : 250,
			align: 'center'
		}, {
			field : 'videoCategoryDescribe',
			title : '描述',
			width : 350,
			align: 'center'
		}, {
			field : 'course.courseName',
			title : '课程名',
			width : 250,
			align: 'center'
		} 
		 ] ],
		pagination : true,
		pageSize : 10,
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