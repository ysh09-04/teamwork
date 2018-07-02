$(function() {
	$('#dg')
			.datagrid(
					{
						url : 'users/datagrid',
						title : '用户管理',
						fitColumns : true,
						loadMsg : '数据加载中,请稍后...',
						rownumbers : true,
						singleSelect : true,
						checkOnSelect : true,
						columns : [ [
								{
									field : 'userId',
									title : '编号',
									checkbox : true
								},
								{
									field : 'userName',
									title : '用户名',
									width : 100
								},
								{
									field : 'password',
									title : '密码',
									width : 100
								},
								{
									field : 'state',
									title : '用户状态',
									width : 80,
									sortable : true,
									rownumbers : true,
									formatter : function(value, row, index) {
										if (value == 0) {
											return "<font color='green'>正常</font>";
										} else if (value == 1) {
											return "<font color='red'>封停</font>";
										}
									}
								},
								
								 ] ],
						pagination : true,
						pageSize : 10,
						pageList : [ 10, 20, 35, 50 ],
						toolbar : '#tb'
					});
})




