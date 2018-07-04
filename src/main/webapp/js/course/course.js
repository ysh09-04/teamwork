$(function() {
	// datagrid
	$('#dg').datagrid({
		url : 'course/datagrid',
		title : '菜单管理',
		// width : '100%',
		fitColumns : true,
		loadMsg : '数据加载中,请稍后...',
		rownumbers : true,
		singleSelect : true,
		checkOnSelect : true,
		columns : [ [ {
			field : 'courseId',
			title : '编号',
			checkbox : true
		}, {
			field : 'courseName',
			title : '课程名',
			width : 100
		}, {
			field : 'courseDescribe',
			title : '描述',
			width : 100
		},  {
			field : 'enabledCourse',
			title : '是否启用课程',
			width : 100,
		}, {
			field : 'enabledPaper',
			title : '是否启用考试',
			width : 100,
		}, {
			field : 'category.categoryName',
			title : '类目',
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