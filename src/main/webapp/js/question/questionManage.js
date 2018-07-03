$(function() {
	$('#dg')
			.datagrid(
					{
						url : 'question/datagrid',
						title : '题目管理',
						fitColumns : true,
						loadMsg : '数据加载中,请稍后...',
						rownumbers : true,
						singleSelect : true,
						checkOnSelect : true,
						columns : [ [
								{
									field : 'questionId',
									title : '题目编号',
									checkbox : true
								},
								{
									field : 'questionType',
									title : '类型',
									width : 50
								},
								{
									field : 'questionContent',
									title : '题目内容',
									width : 50
								},
								{
									field : 'chooseContent',
									title : '选择内容',
									width : 50,
								},
								{
									field : "answer",
									title : "答案",
									width : 50,
								},
								{
									field : 'answerAnalysis',
									title : '答案解析',
									width : 50
								},
								{
									field : 'questionSource',
									title : '题目来源',
									width : 50
								},
								{
									field : 'examinationPointDescription',
									title : '考点描述',
									width : 50,
								},
								{
									field : "titleAccuracy",
									title : "题目准确度",
									width : 100,
								},
								{
									field : 'questionSelectionToal',
									title : '题目可选择数目',
									width : 50,
								},
								{
									field : "questionValue",
									title : "题目分值",
									width : 50,
								},
								{
									field : 'questionBankName',
									title : '题库名',
									width : 50,
									formatter : function(value, row, index) {
										return row.questionBank.questionBankName;
									}
								}
								 
								] ],
						pagination : true,
						pageSize : 10,
						pageList : [ 10, 20, 35, 50 ],
						toolbar : '#tb'
					});
})