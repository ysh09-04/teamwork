/**
 * @author 刘家霖
 */
var allChlidMenus;
$(function() {
	// datagrid
	$('#dg').datagrid({
		url : 'shop_content/datagrid',
		title : '商品内容',
		width : '100%',
		loadMsg : '数据加载中,请稍后...',
		rownumbers : true,
		singleSelect : true,
		checkOnSelect : true,
		columns : [ [ {
			field : 'productContentID',
			title : '产品ID',
			width : 100,
			align: 'center'
		},{
			field : 'productId',
			title : '产品ID',
			width : 100,
			align: 'center'
		},{
			field : 'productName',
			title : '产品名字',
			width : 150,
			align: 'center'
		},
		{
			field : 'type',
			title : '类型',
			width : 100,
			align: 'center'
		},
		{
			field: 'contentId',
			title: '视频类目or试卷or题库ID',
			width : 300,
			align: 'center'
		},{
			field: 'contentName',
			title: '视频类目or试卷or题库名',
			width : 300,
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
		url:'product/findAll',
		dataType : "json", 
		success:function(result){
			$('#productId').combobox({
			      data : result,
			      valueField:'productId',
			      textField:'productName'
			     });
		}
	});
	
	
})


function addPage() {
	$('#dlg').dialog({
		title : '添加商品内容',
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
function ceshi(contentId,type){
	if(type=='试卷'){
		$.ajax({
			type:'post',
			url:'paper/findAll',
			dataType : "json", 
			success:function(result){
				$('#contentId').combobox({
				      data : result,
				      valueField:'paperId',
				      textField:'paperName',
				     });
				for(var i=0;i<result.length;i++){
				  if(result[i].paperId==contentId){
					 $("#contentId").combobox('select',contentId);
				  }
				}
			}
		});
	}else if(type=='题库'){
		$.ajax({
			type:'post',
			url:'questionBank/findAll',
			dataType : "json", 
			success:function(result){
				$('#contentId').combobox({
				      data : result,
				      valueField:'questionBankId',
				      textField:'questionBankName',
				     });
				for(var i=0;i<result.length;i++){
				  if(result[i].questionBankId==contentId){
					 $("#contentId").combobox('select',contentId);
				  }
				}
			}
		});
		
	}else if(type=='视频类目'){
		$.ajax({
			type:'post',
			url:'videoCategory/findAll',
			dataType : "json", 
			success:function(result){
				$('#contentId').combobox({
				      data : result,
				      valueField:'videoCategoryId',
				      textField:'videoCategoryName',
				     });
				for(var i=0;i<result.length;i++){
				  if(result[i].videoCategoryId==contentId){
					 $("#contentId").combobox('select',contentId);
				   }
				}
			}
		});
	};
}

function editPage() {
	var selectedRows = $('#dg').datagrid('getSelections');
	if (selectedRows.length != 1) {
		$.messager.alert('系统提示', '请选择一条记录！');
		return;
	}
	var row = selectedRows[0];
	$("#productContentID").val(row.productContentID);
	$("#productId").combobox('select',row.productId);
	$("#type").combobox('select',row.type);
	
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
	ceshi(row.contentId,row.type);
}

function add(){	
	var productId= $("#productId").combobox('getValue');
	var type= $("#type").combobox('getValue');	
	var contentId= $("#contentId").combobox('getValue');	
	var data = {
			productId: productId,
			type: type,
			contentId: contentId			
	}
	$.ajax({
		url: 'shop_content/add',
		data: JSON.stringify(data),
		type:'POST',
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
	var productContentID = $('#productContentID').val();
	var productId= $("#productId").combobox('getValue');
	var type= $("#type").combobox('getValue');	
	var contentId= $("#contentId").combobox('getValue');	
	var data = {
				productContentID: productContentID,
				productId: productId,
				type: type,
				contentId:contentId
	}
	$.ajax({
		url: 'shop_content/update',
		data: JSON.stringify(data),
		method: 'POST',
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

	$.messager.confirm("系统提示", "您确定要删除这条数据吗?", function(r) {
		if (r) {
			$.ajax({
				url : 'shop_content/delete',
				dataType : 'json',
				type : 'POST',
				data : {
						productId:row.productId,
						type:row.type,
						contentId:row.contentId
						},
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
	$('#contentId').combobox('loadData', {});//清空
	$("#productId").combobox('setValue',"--请选择--");
	$("#type").combobox('setValue',"--请选择--");
	$("#contentId").combobox('setValue',"--请选择--");
}






$(document).ready(function () {
    $('#type').combobox({
        onChange: function (n, o) {
        		var type= $("#type").combobox('getValue');
        		if(type=='试卷'){
        			$.ajax({
        				type:'post',
        				url:'paper/findAll',
        				dataType : "json", 
        				success:function(result){
        					$('#contentId').combobox({
        					      data : result,
        					      valueField:'paperId',
        					      textField:'paperName'
        					     });
        				}
        			});
        		}else if(type=='视频类目'){
        			$.ajax({
        				type:'post',
        				url:'videoCategory/findAll',
        				dataType : "json", 
        				success:function(result){
        					$('#contentId').combobox({
        					      data : result,
        					      valueField:'videoCategoryId',
        					      textField:'videoCategoryName'
        					     });
        				}
        			});
        		}else if(type=='题库'){
        			$.ajax({
        				type:'post',
        				url:'questionBank/findAll',
        				dataType : "json", 
        				success:function(result){
        					$('#contentId').combobox({
        					      data : result,
        					      valueField:'questionBankId',
        					      textField:'questionBankName'
        					     });
        				}
        			});
        		}
        }
    });
});