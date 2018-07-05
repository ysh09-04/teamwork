$(function() {
	$('#dg')
			.datagrid(
					{
						url : 'question/datagrid',
						title : '题目管理',
						width : '100%',
						loadMsg : '数据加载中,请稍后...',
						rownumbers : true,
						singleSelect : true,
						checkOnSelect : true,
						columns : [ [
								{
									field : 'questionId',
									title : '题目编号',
									width : 100,
									align: 'center'
								},
								{
									field : 'questionType',
									title : '类型',
									width : 100,
									align: 'center'
								},
								{
									field : 'questionContent',
									title : '题目内容',
									width : 100,
									align: 'center'
								},
								{
									field : 'chooseContent',
									title : '选择内容',
									width : 100,
									align: 'center'
								},
								{
									field : "answer",
									title : "答案",
									width : 100,
									align: 'center'
								},
								{
									field : 'answerAnalysis',
									title : '答案解析',
									width : 100,
									align: 'center'
								},
								{
									field : 'questionSource',
									title : '题目来源',
									width : 100,
									align: 'center'
								},
								{
									field : 'examinationPointDescription',
									title : '考点描述',
									width : 100,
									align: 'center'
								},
								{
									field : "titleAccuracy",
									title : "题目准确度",
									width : 100,
									align: 'center'
								},
								{
									field : 'questionSelectionToal',
									title : '题目可选择数目',
									width : 100,
									align: 'center'
								},
								{
									field : "questionValue",
									title : "题目分值",
									width : 100,
								},
								{
									field : 'questionBankName',
									title : '题库名',
									width : 100,
									align: 'center',
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
	$.ajax({
		type:'post',
		url:'questionBank/linkbutton',
		dataType : "json", 
		success:function(result){
			$('#questionBankId').combobox({
			      data : result,
			      valueField:'questionBankId',
			      textField:'questionBankName',
			     });
		},
	});
});
