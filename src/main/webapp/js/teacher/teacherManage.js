$(function() {
	$('#dg')
			.datagrid(
					{
						url : 'teacher/findAll',
						title : '用户管理',
						fitColumns : true,
						loadMsg : '数据加载中,请稍后...',
						rownumbers : true,
						singleSelect : true,
						checkOnSelect : true,
						columns : [ [
								{
									field : 'tid',
									title : '编号',
									checkbox : true
								},
								{
									field : 'tname',
									title : '教师名',
									width : 100
								},
								{
									field : 'sex',
									title : '性别',
									width : 100
								},
								{
									field : 'age',
									title : '年龄',
									width : 100,
								},
								{
									field : "hobbies",
									title : "爱好",
									width : 100,
								} 
								] ],
						pagination : true,
						pageSize : 10,
						pageList : [ 10, 20, 35, 50 ],
						toolbar : '#tb'
					});
})