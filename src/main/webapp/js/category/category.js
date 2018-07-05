$(function() {
	// datagrid
	$('#dg').datagrid({
		url : 'category/datagrid',
		title : '菜单管理',
		width : '100%',
		loadMsg : '数据加载中,请稍后...',
		rownumbers : true,
		singleSelect : true,
		checkOnSelect : true,
		columns : [ [ {
			field : 'categoryId',
			title : '编号',
			width : 150,
			align: 'center'
		}, {
			field : 'categoryName',
			title : '类目名',
			width : 200,
			align: 'center'
		}, {
			field : 'categoryDescribe',
			title : '描述',
			width : 300,
			align: 'center'
		},  {
			field : 'categoryLevel',
			title : '等级',
			width : 150,
			align: 'center'
		}, {
			field : 'fatherId',
			title : '上一级目录',
			width : 150,
			align: 'center'
		} 
		 ] ],
		pagination : true,
		pageSize : 20,
		pageList : [ 10, 20, 35, 50 ],
		toolbar : '#tb'
	});
});