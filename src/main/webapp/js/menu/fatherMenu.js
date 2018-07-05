$(function() {
	// datagrid
	$('#dg').datagrid({
		url : 'fatherMenu/datagrid',
		title : '菜单管理',
		width : "100%",
		loadMsg : '数据加载中,请稍后...',
		rownumbers : true,
		singleSelect : true,
		checkOnSelect : true,
		columns : [ [ {
			field : 'fatherMenuId',
			title : '编号',
			width : 300,
			align: 'center'
		}, {
			field : 'menuName',
			title : '菜单名',
			width : 300,
			align: 'center'
		}, {
			field : 'muneDescribe',
			title : '描述',
			width : 300,
			align: 'center'
		},  {
			field : 'icon',
			title : '图标',
			width : 300,
			align: 'center'
		} 
		 ] ],
		pagination : true,
		pageSize : 10,
		pageList : [ 10, 20, 35, 50 ],
		toolbar : '#tb'
	});
});