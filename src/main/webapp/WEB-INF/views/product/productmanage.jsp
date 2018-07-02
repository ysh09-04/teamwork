<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../common/head.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="js/product/productManage.js"></script>
<script type="text/javascript">
	var url = "${pageContext.request.contextPath}/product";
	var method;
	
	function searchProduct() {
		$("#dg").datagrid('load', {
			"productName" : $("#name").val()
		});
	}

	function deleteProduct() {
		var selectedRows = $("#dg").datagrid('getSelections');
		if (selectedRows.length == 0) {
			$.messager.alert("系统提示", "请选择要删除的数据！");
			return;
		}
		var strIds = [];
		for ( var i = 0; i < selectedRows.length; i++) {
			var productId = selectedRows[i].productId;
			if (productId == 1) {
				$.messager.alert("系统提示", "操作失败!");
				return;
			}
			strIds.push(productId);
		}
		var ids = strIds.join(",");
		$.messager.confirm("系统提示", "您确认要删除这<font color=red>"
				+ selectedRows.length + "</font>条数据吗？", function(r) {
			if (r) {
				$.ajax({
					type : "DELETE",//方法类型
					dataType : "json",//预期服务器返回的数据类型
					url : url + '/' + ids,//url
					data : {},
					success : function(result) {
						//console.log(result);//打印服务端返回的数据
						if (result.resultCode == 200) {
							$.messager.alert("系统提示", "数据已成功删除！");
							$("#dg").datagrid("reload");
						} else {
							$.messager.alert("系统提示", "数据删除失败！");
						}

						;
					},
					error : function() {
						$.messager.alert("ERROR！");
					}
				});
			}
		});

	}

	function openProductAddDialog() {
		$("#dlg").dialog("open").dialog("setTitle", "添加教师信息");
		method = "POST";
	}

	function saveProduct() {
	    var productId = $("#productId").val();
		var productName = $("#productName").val();
		var productDescription = $("#productDescription").val();
		var productPrice = $("#productPrice").val();
		var productEffectiveDate = $("#productEffectiveDate").val();
		var enabled = $("#enabled").val();
		var browseNumber = $("#browseNumber").val();
		var purchaseTimes = $("#purchaseTimes").val();
		var category = $("#category").val();
		var data = {
			"productId" : productId,
			"productName" : productName,
			"productDescription": productDescription,
			"productPrice" : productPrice,
			"productEffectiveDate" : productEffectiveDate,
			"enabled": enabled,
			"browseNumber" : browseNumber,
			"purchaseTimes" : purchaseTimes,
			"category": category,
		}
		$.ajax({
			type : method,//方法类型
			dataType : "json",//预期服务器返回的数据类型
			url : url,//url
			contentType : "application/json; charset=utf-8",
			data : JSON.stringify(data),
			success : function(result) {
				//console.log(result);//打印服务端返回的数据
				if (result.resultCode == 200) {
					$.messager.alert("系统提示", "保存成功");
					$("#dlg").dialog("close");
					$("#dg").datagrid("reload");
					resetValue();
				} else {
					$.messager.alert("系统提示", "操作失败");
					$("#dlg").dialog("close");
					resetValue();
				}
				;
			},
			error : function() {
				$.messager.alert("系统提示", "操作失败");
			}
		});
	}

	function openProductModifyDialog() {
		var selectedRows = $("#dg").datagrid('getSelections');
		if (selectedRows.length != 1) {
			$.messager.alert("系统提示", "请选择一条要编辑的数据！");
			return;
		}
		var row = selectedRows[0];
		if (row.productId == 1) {
			$.messager.alert("系统提示", "操作失败！");
			return;
		}
		$("#dlg").dialog("open").dialog("setTitle", "编辑商品信息");
		$('#fm').form('load', row);
		$("#productId").val(row.productId);
		$("#productName").val(row.productName);
		$("#productDescription").val(row.productDescription);
		$("#productPrice").val(row.productPrice);
		$("#productEffectiveDate").val(row.productEffectiveDate);
		$("#enabled").val(row.enabled);
		$("#browseNumber").val(row.browseNumber);
		$("#purchaseTimes").val(row.purchaseTimes);
		$("#category").val(row.category);
		method = "PUT";
	}

	function resetValue() {
		$("#productName").val("");
		$("#productDescription").val("");
		$("#productPrice").val("");
		$("#productEffectiveDate").val("");
		$("#enabled").val("");
		$("#browseNumber").val("");
		$("#purchaseTimes").val("");
		$("#category").val("");
	}

	function closeProductDialog() {
		$("#dlg").dialog("close");
		resetValue();
	}
	
	
</script>
</head>
<body style="margin:1px;">
	<table id="dg"></table>
	<div id="tb">
		<div>
			<a href="javascript:openProductAddDialog()" class="easyui-linkbutton"
				iconCls="icon-add" plain="true">添加</a> <a
				href="javascript:openProductModifyDialog()" class="easyui-linkbutton"
				iconCls="icon-edit" plain="true">修改</a> <a
				href="javascript:deleteProduct()" class="easyui-linkbutton"
				iconCls="icon-remove" plain="true">删除</a>
		</div>
		<div>
			&nbsp;商品名：&nbsp;<input type="text" id="name" size="20"
				onkeydown="if(event.keyCode==13) searchProduct()" /> <a
				href="javascript:searchProduct()" class="easyui-linkbutton"
				iconCls="icon-search" plain="true">搜索</a>
		</div>
	</div>

	<div id="dlg" class="easyui-dialog"
		style="width: 620px;height:250px;padding: 10px 20px" closed="true"
		buttons="#dlg-buttons">
		<form id="fm" method="post">
			<table cellspacing="8px">
				<tr>
					<td>商品名：</td>
					<td><input type="text" id="productName" name="productName"
						class="easyui-validatebox" required="true" />&nbsp;<font
						color="red">*</font> <input type="hidden" id="productId" value="0">
					</td>
				</tr>
				
				<tr>
					<td>描述：</td>
					<td><input type="text" id="productDescription" name="productDescription"
						class="easyui-validatebox" required="true" />&nbsp;<font
						color="red">*</font> 
					</td>
				</tr>
				<tr>
					<td>价格：</td>
					<td><input type="text" id="productPrice" name="productPrice"
						class="easyui-validatebox" required="true" />&nbsp;<font
						color="red">*</font> <input type="hidden" id="productId" value="0">
					</td>
				</tr>
				
				<tr>
					<td>有效日期：</td>
					<td><input type="text" id="productEffectiveDate" name="productEffectiveDate"
						class="easyui-validatebox" required="true" />&nbsp;<font
						color="red">*</font> 
					</td>
				</tr>
				<tr>
					<td>是否启用：</td>
					<td><input type="text" id="enabled" name="enabled"
						class="easyui-validatebox" required="true" />&nbsp;<font
						color="red">*</font> <input type="hidden" id="productId" value="0">
					</td>
				</tr>
				
				<tr>
					<td>浏览次数：</td>
					<td><input type="text" id="browseNumber" name="browseNumber"
						class="easyui-validatebox" required="true" />&nbsp;<font
						color="red">*</font> 
					</td>
				</tr>
				<tr>
					<td>购买次数：</td>
					<td><input type="text" id="purchaseTimes" name="purchaseTimes"
						class="easyui-validatebox" required="true" />&nbsp;<font
						color="red">*</font> <input type="hidden" id="productId" value="0">
					</td>
				</tr>
				
				<tr>
					<td>类别：</td>
					<td><input type="text" id="category" name="category"
						class="easyui-validatebox" required="true" />&nbsp;<font
						color="red">*</font> 
					</td>
				</tr>
				
			</table>
		</form>
	</div>

	<div id="dlg-buttons">
		<a href="javascript:saveProduct()" class="easyui-linkbutton"
			iconCls="icon-ok">保存</a> <a href="javascript:closeProductDialog()"
			class="easyui-linkbutton" iconCls="icon-cancel">关闭</a>
	</div>
</body>
</html>