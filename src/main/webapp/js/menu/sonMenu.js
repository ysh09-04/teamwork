$(function() {
	// datagrid
	$('#dg').datagrid({
		url : 'sonMenu/datagrid',
		title : '菜单管理',
		// width : '100%',
		fitColumns : true,
		loadMsg : '数据加载中,请稍后...',
		rownumbers : true,
		singleSelect : true,
		checkOnSelect : true,
		columns : [ [ {
			field : 'fatherMenuId',
			title : '编号',
			checkbox : true
		}, {
			field : 'menuName',
			title : '菜单名',
			width : 100
		}, {
			field : 'muneDescribe',
			title : '描述',
			width : 100
		},  {
			field : 'icon',
			title : '图标',
			width : 120,
		}, {
			field : 'muneUrl',
			title : '路径',
			width : 120,
		}, {
			field : 'fatherMenu.menuName',
			title : '上一级目录',
			width : 120,
		} 
		 ] ],
		pagination : true,
		pageSize : 20,
		pageList : [ 10, 20, 35, 50 ],
		toolbar : '#tb'
	});
		$.ajax({
			type:'post',
			url:'fatherMenu/linkbutton',
			dataType : "json", 
			success:function(result){
				$('#fatherMenuId').combobox({
				      data : result,
				      valueField:'fatherMenuId',
				      textField:'menuName'
				     });
			},
		});
});