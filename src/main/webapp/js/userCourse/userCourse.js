$(function() {
	// datagrid
	$('#dg').datagrid({
		url : 'UserCourse/datagrid',
		title : '菜单管理',
		width : '100%',
		loadMsg : '数据加载中,请稍后...',
		rownumbers : true,
		singleSelect : true,
		checkOnSelect : true,
		columns : [ [ {
			field : 'userCourseId',
			title : '编号',
			width : 100,
			align: 'center'
		}, {
			field : 'tUser.userName',
			title : '用户名',
			width : 100,
			align: 'center'
		}, {
			field : 'course.courseName',
			title : '课程名',
			width : 100,
			align: 'center'
		}, {
			field : 'courseState',
			title : '修改课程状态',
			width : 100,
		} 
		 ] ],
		pagination : true,
		pageSize : 10,
		pageList : [ 10, 20, 35, 50 ],
		toolbar : '#tb'
	});
});