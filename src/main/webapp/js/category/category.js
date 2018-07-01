$(function() {
	// datagrid
	$('#dg').datagrid({
		url : 'category/datagrid',
		title : '菜单管理',
		// width : '100%',
		fitColumns : true,
		loadMsg : '数据加载中,请稍后...',
		rownumbers : true,
		singleSelect : true,
		checkOnSelect : true,
		columns : [ [ {
			field : 'categoryId',
			title : '编号',
			checkbox : true
		}, {
			field : 'categoryName',
			title : '类目名',
			width : 100
		}, {
			field : 'categoryDescribe',
			title : '描述',
			width : 100
		},  {
			field : 'categoryLevel',
			title : '等级',
			width : 100,
		}, {
			field : 'fatherId',
			title : '上一级目录',
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
				$('#fatherId').combobox({
				      data : result,
				      valueField:'categoryId',
				      textField:'categoryName'
				     });
			},
		});
});