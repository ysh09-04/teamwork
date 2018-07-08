/**
 * @author 刘家霖
 */
var allChlidMenus;
$(function() {
	// datagrid
	$('#dg').datagrid({
		url : 'order/datagrid',
		title : '题库管理',
		width : '100%',
		loadMsg : '数据加载中,请稍后...',
		rownumbers : true,
		singleSelect : true,
		checkOnSelect : true,
		columns : [ [ {
			field : 'orderId',
			title : '编号',
			width : 60
		},{
			field : 'orderType',
			title : '订单类型',
			width :  60
		},
		{
			field: 'paymentType',
			title: '支付类型',
			width : 60
		},{
			field: 'paymentNumber',
			title: '支付编号',
			width : 60
		},{
			field: 'paymentMoney',
			title: '支付金额',
			width : 60
		},	{
			field: 'state',
			title: '订单状态',
			width : 60
		},{
			field: 'tUser.tUserId',
			title: '用户ID',
			width : 60
		},{
			field: 'tUser.userName',
			title: '用户名',
			width : 60
		}
		 ] ],
		pagination : true,
		pageSize : 10,
		pageList : [ 10, 20, 35, 50 ],
		toolbar : '#tb'
	});

})



function del() {
	var selectedRows = $('#dg').datagrid('getSelections');
	if (selectedRows.length != 1) {
		$.messager.alert('系统提示', '请选择一条记录！');
		return;
	}
	var row = selectedRows[0];
	var data = {
	   		 orderId:row.orderId,
					state:'确认收货'}

	$.messager.confirm("系统提示", "您确定要修改这条数据吗?", function(r) {
		if (r) {
			$.ajax({
				url : 'order/update',
				dataType : 'json',
				method : 'POST',
				contentType: 'application/json; charset=utf-8',
				data : JSON.stringify(data),
				success : function(result) {
					if (result.resultCode == 200) {
						$.messager.alert("系统提示", "修改成功!");
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
function add() {
	var selectedRows = $('#dg').datagrid('getSelections');
	if (selectedRows.length != 1) {
		$.messager.alert('系统提示', '请选择一条记录！');
		return;
	}
	var row = selectedRows[0];
	var data = {
   		 orderId:row.orderId,
				state:'未发货'}
	$.messager.confirm("系统提示", "您确定要修改这条数据吗?", function(r) {
		if (r) {
			$.ajax({
				url : 'order/update',
				dataType : 'json',
				method : 'POST',
				contentType: 'application/json; charset=utf-8',
				data : JSON.stringify(data),
				success : function(result) {
					if (result.resultCode == 200) {
						$.messager.alert("系统提示", "修改成功!");
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
function edit() {
	var selectedRows = $('#dg').datagrid('getSelections');
	if (selectedRows.length != 1) {
		$.messager.alert('系统提示', '请选择一条记录！');
		return;
	}
	var row = selectedRows[0];
     var data = {
    		 orderId:row.orderId,
				state:'已发货'}
	$.messager.confirm("系统提示", "您确定要修改这条数据吗?", function(r) {
		if (r) {
			$.ajax({
				url : 'order/update',
				dataType : 'json',
				method : 'POST',
				contentType: 'application/json; charset=utf-8',
				data : JSON.stringify(data),
				success : function(result) {
					if (result.resultCode == 200) {
						$.messager.alert("系统提示", "修改成功!");
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
