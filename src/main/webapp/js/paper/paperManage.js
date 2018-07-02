$(function() {
	$('#dg')
			.datagrid(
					{
						url : 'paper/datagrid',
						title : '用户管理',
						fitColumns : true,
						loadMsg : '数据加载中,请稍后...',
						rownumbers : true,
						singleSelect : true,
						checkOnSelect : true,
						columns : [ [
								{
									field : 'paperId',
									title : '编号',
									checkbox : true
								},
								{
									field : 'paperTotalScore',
									title : '总分',
									width : 50
								},
								{
									field : 'paperDescription',
									title : '描述',
									width : 100
								},
								{
									field : 'paperName',
									title : '考卷名',
									width : 50,
								},
								{
									field : "paperType",
									title : "考卷类型",
									width : 100,
								}, 
								{
									field : 'courseName',
									title : '课程名',
									width : 100,
									formatter : function(value, row, index) {
										return row.course.courseName;
									}
								}
								 
								] ],
						pagination : true,
						pageSize : 10,
						pageList : [ 10, 20, 35, 50 ],
						toolbar : '#tb'
					});
})