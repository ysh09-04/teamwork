$(function() {
	// datagrid
	$('#dg').datagrid({
		url : 'course/datagrid',
		title : '菜单管理',
		width : '100%',
		loadMsg : '数据加载中,请稍后...',
		rownumbers : true,
		singleSelect : true,
		checkOnSelect : true,
		columns : [ [ {
			field : 'courseId',
			title : '编号',
			width : 100,
			align: 'center'
		}, {
			field : 'courseName',
			title : '课程名',
			width : 200,
			align: 'center'
		}, {
			field : 'courseDescribe',
			title : '描述',
			width : 300,
			align: 'center'
		},  {
			field : 'enabledCourse',
			title : '是否启用课程',
			width : 150,
			align: 'center'
		}, {
			field : 'enabledPaper',
			title : '是否启用考试',
			width : 150,
			align: 'center'
		}, {
			field : 'category.categoryName',
			title : '类目',
			width : 200,
			align: 'center'
		} 
		 ] ],
		pagination : true,
		pageSize : 20,
		pageList : [ 10, 20, 35, 50 ],
		toolbar : '#tb'
	});
		$.ajax({
			type:'post',
			url:'category/linkbutton',
			dataType : "json", 
			success:function(result){
				$('#categoryId').combobox({
				      data : result,
				      valueField:'categoryId',
				      textField:'categoryName',
				     });
			},
		});
});