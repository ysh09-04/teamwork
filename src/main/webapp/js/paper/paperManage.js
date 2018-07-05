$(function() {
	$('#dg')
			.datagrid(
					{
						url : 'paper/datagrid',
						title : '用户管理',
						width : '100%',
						loadMsg : '数据加载中,请稍后...',
						rownumbers : true,
						singleSelect : true,
						checkOnSelect : true,
						columns : [ [
								{
									field : 'paperId',
									title : '编号',
									width : 100,
									align: 'center'
								},
								{
									field : 'paperTotalScore',
									title : '总分',
									width : 100,
									align: 'center'
								},
								{
									field : 'paperDescription',
									title : '描述',
									width : 300,
									align: 'center'
								},
								{
									field : 'paperName',
									title : '考卷名',
									width : 200,
									align: 'center'
								},
								{
									field : "paperType",
									title : "考卷类型",
									width : 200,
									align: 'center'
								}, 
								{
									field : 'course.courseName',
									title : '课程名',
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
		url:'course/linkbutton',
		dataType : "json", 
		success:function(result){
			$('#courseId').combobox({
			      data : result,
			      valueField:'courseId',
			      textField:'courseName',
			     });
		},
	});
})