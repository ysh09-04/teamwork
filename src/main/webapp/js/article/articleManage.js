$(function() {
	$('#dg')
			.datagrid(
					{
						url : 'article/datagrid',
						title : '用户管理',
						width : '100%',
						loadMsg : '数据加载中,请稍后...',
						rownumbers : true,
						singleSelect : true,
						checkOnSelect : true,
						columns : [ [
								{
									field : 'articleId',
									title : '文章编号',
									width : 100,
									align: 'center'
								},
								{
									field : 'articleType',
									title : '文章类别',
									width : 100,
									align: 'center'
								},
								{
									field : 'articleTitle',
									title : '文章标题',
									width : 100,
									align: 'center'
								},
								{
									field : 'articleWriter',
									title : '作者',
									width : 100,
									align: 'center'
								},
								{
									field : "articleContent",
									title : "文章内容",
									width : 100,
									align: 'center'
								}, 
								{
									field : 'readNumber',
									title : '阅读数目',
									width : 100,
									align: 'center'
								},
								{
									field : 'course.courseName',
									title : '课程名字',
									width : 100,
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