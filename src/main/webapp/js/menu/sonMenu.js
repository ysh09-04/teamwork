$(function() {
	// datagrid
	$('#dg').datagrid({
		url : 'sonMenu/datagrid',
		title : '菜单管理',
		width : '100%',
		loadMsg : '数据加载中,请稍后...',
		rownumbers : true,
		singleSelect : true,
		checkOnSelect : true,
		columns : [ [ {
			field : 'sonMenuId',
			title : '编号',
			width : 100,
			align: 'center'
		}, {
			field : 'menuName',
			title : '菜单名',
			width : 200,
			align: 'center'
		}, {
			field : 'muneDescribe',
			title : '描述',
			width : 250,
			align: 'center'
		},  {
			field : 'icon',
			title : '图标',
			width : 150,
			align: 'center'
		}, {
			field : 'muneUrl',
			title : '路径',
			width : 300,
			align: 'center'
		}, {
			field : 'fatherMenu.menuName',
			title : '上一级目录',
			width : 200,
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