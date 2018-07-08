/**
 * @author 刘家霖
 */
var allChlidMenus;
$(function() {
	// datagrid
	$('#dg').datagrid({
		url : 'paperquestion/datagrid',
		title : '题库管理',
		width : '100%',
		loadMsg : '数据加载中,请稍后...',
		rownumbers : true,
		singleSelect : true,
		checkOnSelect : true,
		columns : [ [ {
			field : 'paperQuestionId',
			title : '编号',
			width : 60,
		},{
			field : 'paperId',
			title : '试卷ID',
			width :  60
		},
		{
			field: 'paperName',
			title: '试卷名',
			width : 60
		},{
			field: 'question.questionId',
			title: '题目名字',
			width : 60
		},{
			field: 'question.questionContent',
			title: '题目内容',
			width : 100
		},{
			field: 'question.chooseContent',
			title: '选择内容',
			width : 60,
			formatter: function(value,row,index){
				   var strs= new Array(); 
	               strs= value.split(",");
	               var xianshi='';
	               for(var i=0;i<strs.length;i++){
	            	   xianshi+=strs[i]+'<br>';
	               }
	               return xianshi;
	            }
		},{
			field: 'question.answer',
			title: '答案',
			width : 60
		}
		 ] ],
		pagination : true,
		pageSize : 10,
		pageList : [ 10, 20, 35, 50 ],
		toolbar : '#tb'
	});
	$.ajax({
		type:'post',
		url:'paper/findAll',
		dataType : "json", 
		success:function(result){
			$('#paperId').combobox({
			      data : result,
			      valueField:'paperId',
			      textField:'paperName'
			     });
		},
	});
	$.ajax({
		type:'post',
		url:'question/findAll',
		dataType : "json", 
		success:function(result){
			$('#questionId').combobox({
				
			      data : result,
			      valueField:'questionId',
			      textField:'questionContent'
			     });
		},
	});
})

function addPage() {
	$('#dlg').dialog({
		title : '添加',
		closed : false,
		cache: false,
	    width: 600,             
	    height: 300,        
		buttons : [ {
			text : '保存',
			iconCls : 'icon-add',
			handler : function() {
				add();
			}
		}, {
			text : '取消',
			iconCls : 'icon-cancel',
			handler : function() {
				$('#dlg').dialog("close");
				reset();
			}
		} ]
	})
}

function editPage() {
	var selectedRows = $('#dg').datagrid('getSelections');
	if (selectedRows.length != 1) {
		$.messager.alert('系统提示', '请选择一条记录！');
		return;
	}
	var row = selectedRows[0];
	$('#paperQuestionId').val(row.paperQuestionId);
	$("#paperId").combobox('select',row.paperId);
	$("#questionId").combobox('select',row.question.questionId);
	$('#dlg').dialog({
		title : '编辑权限',
		closed : false,
		buttons : [ {
			text : '编辑',
			iconCls : 'icon-edit',
			handler : function() {
				edit();
			}
		}, {
			text : '取消',
			iconCls : 'icon-cancel',
			handler : function() {
				$('#dlg').dialog('close');
				reset();
			}
		} ]
	})
}

function add(){
	
	var paperId= $("#paperId").combobox('getValue');
	var questionId= $("#questionId").combobox('getValue');	
	var data = {
			paperId: paperId,
			questionId: questionId		
	}
	$.ajax({
		url: 'paperquestion/add',
		data: JSON.stringify(data),
		method: 'POST',
		dataType: 'json',
		contentType : 'application/json; charset=utf-8',
		success:function(res) {
			if (res.resultCode == 200) {
				$.messager.alert("系统提示", "添加成功!");
				
				$('#dlg').dialog("close");
				$('#dg').datagrid('reload');
				reset();
			} else {
				$.messager.alert("系统提示", res.message);
			}
		},error: function() {
			$.messager.alert("系统提示", "网络错误！");
		}
	})
}

function edit(){
	var paperQuestionId = $('#paperQuestionId').val();
	var paperId= $("#paperId").combobox('getValue');
	var questionId= $("#questionId").combobox('getValue');;
	
	var data = {
			paperQuestionId:paperQuestionId,
			paperId: paperId,
			questionId: questionId
			
	}
	$.ajax({
		url: 'paperquestion/update',
		data: JSON.stringify(data),
		type: 'POST',
		dataType: 'json',
		contentType : 'application/json; charset=utf-8',
		success:function(res) {
			if (res.resultCode == 200) {
				$.messager.alert("系统提示", "更新成功!");
				reset();
				$('#dlg').dialog("close");
				$('#dg').datagrid('reload');
			} else {
				$.messager.alert("系统提示", res.message);
			}
		},error: function() {
			$.messager.alert("系统提示", "网络错误！");
		}
	})
}

function del() {
	var selectedRows = $('#dg').datagrid('getSelections');
	if (selectedRows.length != 1) {
		$.messager.alert('系统提示', '请选择一条记录！');
		return;
	}
	var row = selectedRows[0];

	var data = {
			paperQuestionId:row.paperQuestionId
			
	}
	$.messager.confirm("系统提示", "您确定要删除这条数据吗?", function(r) {
		if (r) {
			$.ajax({
				url : 'paperquestion/delete',
				dataType : 'json',
				type : 'POST',
				data : data,
				
				success : function(result) {
					if (result.resultCode == 200) {
						$.messager.alert("系统提示", "删除成功!");
						$('#dg').datagrid('reload');
					} else {
						$.messager.alert("系统提示", result.message);
					}
				},error: function () {
					$.messager.alert("系统提示", "网络错误!");
				}
			})
		}
	})
}

function reset(){
	$('#paperQuestionId').val('');
	$("#paperId").combobox('select',"--请选择--");
	$("#questionId").combobox('select',"--请选择--");	
}
